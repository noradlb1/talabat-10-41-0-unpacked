package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import h8.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class SsMediaSource extends BaseMediaSource implements Loader.Callback<ParsingLoadable<SsManifest>> {
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;
    private static final int MINIMUM_MANIFEST_REFRESH_PERIOD_MS = 5000;
    private static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000;
    private final SsChunkSource.Factory chunkSourceFactory;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionManager drmSessionManager;
    private final long livePresentationDelayMs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final MediaItem.LocalConfiguration localConfiguration;
    private SsManifest manifest;
    private DataSource manifestDataSource;
    private final DataSource.Factory manifestDataSourceFactory;
    private final MediaSourceEventListener.EventDispatcher manifestEventDispatcher;
    private long manifestLoadStartTimestamp;
    private Loader manifestLoader;
    private LoaderErrorThrower manifestLoaderErrorThrower;
    private final ParsingLoadable.Parser<? extends SsManifest> manifestParser;
    private Handler manifestRefreshHandler;
    private final Uri manifestUri;
    private final MediaItem mediaItem;
    private final ArrayList<SsMediaPeriod> mediaPeriods;
    @Nullable
    private TransferListener mediaTransferListener;
    private final boolean sideloadedManifest;

    public static final class Factory implements MediaSourceFactory {
        private final SsChunkSource.Factory chunkSourceFactory;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private long livePresentationDelayMs;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        @Nullable
        private final DataSource.Factory manifestDataSourceFactory;
        @Nullable
        private ParsingLoadable.Parser<? extends SsManifest> manifestParser;

        public Factory(DataSource.Factory factory) {
            this(new DefaultSsChunkSource.Factory(factory), factory);
        }

        public int[] getSupportedTypes() {
            return new int[]{1};
        }

        @CanIgnoreReturnValue
        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2) {
            this.compositeSequenceableLoaderFactory = (CompositeSequenceableLoaderFactory) Assertions.checkNotNull(compositeSequenceableLoaderFactory2, "SsMediaSource.Factory#setCompositeSequenceableLoaderFactory no longer handles null by instantiating a new DefaultCompositeSequenceableLoaderFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setLivePresentationDelayMs(long j11) {
            this.livePresentationDelayMs = j11;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setManifestParser(@Nullable ParsingLoadable.Parser<? extends SsManifest> parser) {
            this.manifestParser = parser;
            return this;
        }

        public Factory(SsChunkSource.Factory factory, @Nullable DataSource.Factory factory2) {
            this.chunkSourceFactory = (SsChunkSource.Factory) Assertions.checkNotNull(factory);
            this.manifestDataSourceFactory = factory2;
            this.drmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.livePresentationDelayMs = 30000;
            this.compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
        }

        public SsMediaSource createMediaSource(SsManifest ssManifest) {
            return createMediaSource(ssManifest, MediaItem.fromUri(Uri.EMPTY));
        }

        @CanIgnoreReturnValue
        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider2) {
            this.drmSessionManagerProvider = (DrmSessionManagerProvider) Assertions.checkNotNull(drmSessionManagerProvider2, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
            this.loadErrorHandlingPolicy = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy2, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public SsMediaSource createMediaSource(SsManifest ssManifest, MediaItem mediaItem) {
            List list;
            SsManifest ssManifest2 = ssManifest;
            MediaItem mediaItem2 = mediaItem;
            boolean z11 = true;
            Assertions.checkArgument(!ssManifest2.isLive);
            MediaItem.LocalConfiguration localConfiguration = mediaItem2.localConfiguration;
            if (localConfiguration != null) {
                list = localConfiguration.streamKeys;
            } else {
                list = ImmutableList.of();
            }
            if (!list.isEmpty()) {
                ssManifest2 = ssManifest2.copy((List<StreamKey>) list);
            }
            SsManifest ssManifest3 = ssManifest2;
            if (mediaItem2.localConfiguration == null) {
                z11 = false;
            }
            MediaItem build = mediaItem.buildUpon().setMimeType(MimeTypes.APPLICATION_SS).setUri(z11 ? mediaItem2.localConfiguration.uri : Uri.EMPTY).build();
            return new SsMediaSource(build, ssManifest3, (DataSource.Factory) null, (ParsingLoadable.Parser) null, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.drmSessionManagerProvider.get(build), this.loadErrorHandlingPolicy, this.livePresentationDelayMs);
        }

        public SsMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.localConfiguration);
            ParsingLoadable.Parser parser = this.manifestParser;
            if (parser == null) {
                parser = new SsManifestParser();
            }
            List<StreamKey> list = mediaItem.localConfiguration.streamKeys;
            return new SsMediaSource(mediaItem, (SsManifest) null, this.manifestDataSourceFactory, !list.isEmpty() ? new FilteringManifestParser(parser, list) : parser, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.drmSessionManagerProvider.get(mediaItem), this.loadErrorHandlingPolicy, this.livePresentationDelayMs);
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.smoothstreaming");
    }

    private void processManifest() {
        SinglePeriodTimeline singlePeriodTimeline;
        long j11;
        long j12;
        for (int i11 = 0; i11 < this.mediaPeriods.size(); i11++) {
            this.mediaPeriods.get(i11).updateManifest(this.manifest);
        }
        long j13 = Long.MIN_VALUE;
        long j14 = Long.MAX_VALUE;
        for (SsManifest.StreamElement streamElement : this.manifest.streamElements) {
            if (streamElement.chunkCount > 0) {
                j14 = Math.min(j14, streamElement.getStartTimeUs(0));
                j13 = Math.max(j13, streamElement.getStartTimeUs(streamElement.chunkCount - 1) + streamElement.getChunkDurationUs(streamElement.chunkCount - 1));
            }
        }
        if (j14 == Long.MAX_VALUE) {
            if (this.manifest.isLive) {
                j12 = -9223372036854775807L;
            } else {
                j12 = 0;
            }
            SsManifest ssManifest = this.manifest;
            boolean z11 = ssManifest.isLive;
            singlePeriodTimeline = new SinglePeriodTimeline(j12, 0, 0, 0, true, z11, z11, (Object) ssManifest, this.mediaItem);
        } else {
            SsManifest ssManifest2 = this.manifest;
            if (ssManifest2.isLive) {
                long j15 = ssManifest2.dvrWindowLengthUs;
                if (j15 != C.TIME_UNSET && j15 > 0) {
                    j14 = Math.max(j14, j13 - j15);
                }
                long j16 = j14;
                long j17 = j13 - j16;
                long msToUs = j17 - Util.msToUs(this.livePresentationDelayMs);
                if (msToUs < MIN_LIVE_DEFAULT_START_POSITION_US) {
                    msToUs = Math.min(MIN_LIVE_DEFAULT_START_POSITION_US, j17 / 2);
                }
                singlePeriodTimeline = new SinglePeriodTimeline((long) C.TIME_UNSET, j17, j16, msToUs, true, true, true, (Object) this.manifest, this.mediaItem);
            } else {
                long j18 = ssManifest2.durationUs;
                if (j18 != C.TIME_UNSET) {
                    j11 = j18;
                } else {
                    j11 = j13 - j14;
                }
                singlePeriodTimeline = new SinglePeriodTimeline(j14 + j11, j11, j14, 0, true, false, false, (Object) this.manifest, this.mediaItem);
            }
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    private void scheduleManifestRefresh() {
        if (this.manifest.isLive) {
            this.manifestRefreshHandler.postDelayed(new a(this), Math.max(0, (this.manifestLoadStartTimestamp + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* access modifiers changed from: private */
    public void startLoadingManifest() {
        if (!this.manifestLoader.hasFatalError()) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.manifestDataSource, this.manifestUri, 4, this.manifestParser);
            this.manifestEventDispatcher.loadStarted(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, this.manifestLoader.startLoading(parsingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable.type))), parsingLoadable.type);
        }
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId);
        SsMediaPeriod ssMediaPeriod = new SsMediaPeriod(this.manifest, this.chunkSourceFactory, this.mediaTransferListener, this.compositeSequenceableLoaderFactory, this.drmSessionManager, createDrmEventDispatcher(mediaPeriodId), this.loadErrorHandlingPolicy, createEventDispatcher, this.manifestLoaderErrorThrower, allocator);
        this.mediaPeriods.add(ssMediaPeriod);
        return ssMediaPeriod;
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        this.drmSessionManager.setPlayer(Looper.myLooper(), getPlayerId());
        this.drmSessionManager.prepare();
        if (this.sideloadedManifest) {
            this.manifestLoaderErrorThrower = new LoaderErrorThrower.Dummy();
            processManifest();
            return;
        }
        this.manifestDataSource = this.manifestDataSourceFactory.createDataSource();
        Loader loader = new Loader("SsMediaSource");
        this.manifestLoader = loader;
        this.manifestLoaderErrorThrower = loader;
        this.manifestRefreshHandler = Util.createHandlerForCurrentLooper();
        startLoadingManifest();
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((SsMediaPeriod) mediaPeriod).release();
        this.mediaPeriods.remove(mediaPeriod);
    }

    public void releaseSourceInternal() {
        SsManifest ssManifest;
        if (this.sideloadedManifest) {
            ssManifest = this.manifest;
        } else {
            ssManifest = null;
        }
        this.manifest = ssManifest;
        this.manifestDataSource = null;
        this.manifestLoadStartTimestamp = 0;
        Loader loader = this.manifestLoader;
        if (loader != null) {
            loader.release();
            this.manifestLoader = null;
        }
        Handler handler = this.manifestRefreshHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.manifestRefreshHandler = null;
        }
        this.drmSessionManager.release();
    }

    private SsMediaSource(MediaItem mediaItem2, @Nullable SsManifest ssManifest, @Nullable DataSource.Factory factory, @Nullable ParsingLoadable.Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, long j11) {
        Uri uri;
        boolean z11 = false;
        Assertions.checkState(ssManifest == null || !ssManifest.isLive);
        this.mediaItem = mediaItem2;
        MediaItem.LocalConfiguration localConfiguration2 = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem2.localConfiguration);
        this.localConfiguration = localConfiguration2;
        this.manifest = ssManifest;
        if (localConfiguration2.uri.equals(Uri.EMPTY)) {
            uri = null;
        } else {
            uri = Util.fixSmoothStreamingIsmManifestUri(localConfiguration2.uri);
        }
        this.manifestUri = uri;
        this.manifestDataSourceFactory = factory;
        this.manifestParser = parser;
        this.chunkSourceFactory = factory2;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.livePresentationDelayMs = j11;
        this.manifestEventDispatcher = createEventDispatcher((MediaSource.MediaPeriodId) null);
        this.sideloadedManifest = ssManifest != null ? true : z11;
        this.mediaPeriods = new ArrayList<>();
    }

    public void onLoadCanceled(ParsingLoadable<SsManifest> parsingLoadable, long j11, long j12, boolean z11) {
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        this.manifestEventDispatcher.loadCanceled(loadEventInfo, parsingLoadable2.type);
    }

    public void onLoadCompleted(ParsingLoadable<SsManifest> parsingLoadable, long j11, long j12) {
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        this.manifestEventDispatcher.loadCompleted(loadEventInfo, parsingLoadable2.type);
        this.manifest = parsingLoadable.getResult();
        this.manifestLoadStartTimestamp = j11 - j12;
        processManifest();
        scheduleManifestRefresh();
    }

    public Loader.LoadErrorAction onLoadError(ParsingLoadable<SsManifest> parsingLoadable, long j11, long j12, IOException iOException, int i11) {
        Loader.LoadErrorAction loadErrorAction;
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.type), iOException2, i11));
        if (retryDelayMsFor == C.TIME_UNSET) {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
        } else {
            loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
        }
        boolean z11 = !loadErrorAction.isRetry();
        this.manifestEventDispatcher.loadError(loadEventInfo, parsingLoadable2.type, iOException2, z11);
        if (z11) {
            this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        }
        return loadErrorAction;
    }
}
