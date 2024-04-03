package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l8.a;
import o8.g;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import z7.b;
import z7.c;
import z7.d;
import z7.e;
import z7.f;
import z7.h;

public final class DownloadHelper {
    public static final DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT = DefaultTrackSelector.Parameters.DEFAULT_WITHOUT_CONTEXT.buildUpon().setForceHighestSupportedBitrate(true).setConstrainAudioChannelCountToDeviceCapabilities(false).build();
    private Callback callback;
    private final Handler callbackHandler;
    private List<ExoTrackSelection>[][] immutableTrackSelectionsByPeriodAndRenderer;
    private boolean isPreparedWithMedia;
    private final MediaItem.LocalConfiguration localConfiguration;
    private MappingTrackSelector.MappedTrackInfo[] mappedTrackInfos;
    private MediaPreparer mediaPreparer;
    @Nullable
    private final MediaSource mediaSource;
    private final RendererCapabilities[] rendererCapabilities;
    private final SparseIntArray scratchSet = new SparseIntArray();
    private TrackGroupArray[] trackGroupArrays;
    private List<ExoTrackSelection>[][] trackSelectionsByPeriodAndRenderer;
    private final DefaultTrackSelector trackSelector;
    private final Timeline.Window window;

    public interface Callback {
        void onPrepareError(DownloadHelper downloadHelper, IOException iOException);

        void onPrepared(DownloadHelper downloadHelper);
    }

    public static final class DownloadTrackSelection extends BaseTrackSelection {

        public static final class Factory implements ExoTrackSelection.Factory {
            private Factory() {
            }

            public ExoTrackSelection[] createTrackSelections(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
                DownloadTrackSelection downloadTrackSelection;
                ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
                for (int i11 = 0; i11 < definitionArr.length; i11++) {
                    ExoTrackSelection.Definition definition = definitionArr[i11];
                    if (definition == null) {
                        downloadTrackSelection = null;
                    } else {
                        downloadTrackSelection = new DownloadTrackSelection(definition.group, definition.tracks);
                    }
                    exoTrackSelectionArr[i11] = downloadTrackSelection;
                }
                return exoTrackSelectionArr;
            }
        }

        public DownloadTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
        }

        public int getSelectedIndex() {
            return 0;
        }

        @Nullable
        public Object getSelectionData() {
            return null;
        }

        public int getSelectionReason() {
            return 0;
        }

        public void updateSelectedTrack(long j11, long j12, long j13, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        }
    }

    public static final class FakeBandwidthMeter implements BandwidthMeter {
        private FakeBandwidthMeter() {
        }

        public void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        }

        public long getBitrateEstimate() {
            return 0;
        }

        public /* synthetic */ long getTimeToFirstByteEstimateUs() {
            return a.a(this);
        }

        @Nullable
        public TransferListener getTransferListener() {
            return null;
        }

        public void removeEventListener(BandwidthMeter.EventListener eventListener) {
        }
    }

    public static class LiveContentUnsupportedException extends IOException {
    }

    public static final class MediaPreparer implements MediaSource.MediaSourceCaller, MediaPeriod.Callback, Handler.Callback {
        private static final int DOWNLOAD_HELPER_CALLBACK_MESSAGE_FAILED = 1;
        private static final int DOWNLOAD_HELPER_CALLBACK_MESSAGE_PREPARED = 0;
        private static final int MESSAGE_CHECK_FOR_FAILURE = 1;
        private static final int MESSAGE_CONTINUE_LOADING = 2;
        private static final int MESSAGE_PREPARE_SOURCE = 0;
        private static final int MESSAGE_RELEASE = 3;
        private final Allocator allocator = new DefaultAllocator(true, 65536);
        private final DownloadHelper downloadHelper;
        private final Handler downloadHelperHandler = Util.createHandlerForCurrentOrMainLooper(new a(this));
        public MediaPeriod[] mediaPeriods;
        private final MediaSource mediaSource;
        private final Handler mediaSourceHandler;
        private final HandlerThread mediaSourceThread;
        private final ArrayList<MediaPeriod> pendingMediaPeriods = new ArrayList<>();
        private boolean released;
        public Timeline timeline;

        public MediaPreparer(MediaSource mediaSource2, DownloadHelper downloadHelper2) {
            this.mediaSource = mediaSource2;
            this.downloadHelper = downloadHelper2;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadHelper");
            this.mediaSourceThread = handlerThread;
            handlerThread.start();
            Handler createHandler = Util.createHandler(handlerThread.getLooper(), this);
            this.mediaSourceHandler = createHandler;
            createHandler.sendEmptyMessage(0);
        }

        /* access modifiers changed from: private */
        public boolean handleDownloadHelperCallbackMessage(Message message) {
            if (this.released) {
                return false;
            }
            int i11 = message.what;
            if (i11 == 0) {
                try {
                    this.downloadHelper.onMediaPrepared();
                } catch (ExoPlaybackException e11) {
                    this.downloadHelperHandler.obtainMessage(1, new IOException(e11)).sendToTarget();
                }
                return true;
            } else if (i11 != 1) {
                return false;
            } else {
                release();
                this.downloadHelper.onMediaPreparationFailed((IOException) Util.castNonNull(message.obj));
                return true;
            }
        }

        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 != 0) {
                int i12 = 0;
                if (i11 == 1) {
                    try {
                        if (this.mediaPeriods == null) {
                            this.mediaSource.maybeThrowSourceInfoRefreshError();
                        } else {
                            while (i12 < this.pendingMediaPeriods.size()) {
                                this.pendingMediaPeriods.get(i12).maybeThrowPrepareError();
                                i12++;
                            }
                        }
                        this.mediaSourceHandler.sendEmptyMessageDelayed(1, 100);
                    } catch (IOException e11) {
                        this.downloadHelperHandler.obtainMessage(1, e11).sendToTarget();
                    }
                    return true;
                } else if (i11 == 2) {
                    MediaPeriod mediaPeriod = (MediaPeriod) message.obj;
                    if (this.pendingMediaPeriods.contains(mediaPeriod)) {
                        mediaPeriod.continueLoading(0);
                    }
                    return true;
                } else if (i11 != 3) {
                    return false;
                } else {
                    MediaPeriod[] mediaPeriodArr = this.mediaPeriods;
                    if (mediaPeriodArr != null) {
                        int length = mediaPeriodArr.length;
                        while (i12 < length) {
                            this.mediaSource.releasePeriod(mediaPeriodArr[i12]);
                            i12++;
                        }
                    }
                    this.mediaSource.releaseSource(this);
                    this.mediaSourceHandler.removeCallbacksAndMessages((Object) null);
                    this.mediaSourceThread.quit();
                    return true;
                }
            } else {
                this.mediaSource.prepareSource(this, (TransferListener) null, PlayerId.UNSET);
                this.mediaSourceHandler.sendEmptyMessage(1);
                return true;
            }
        }

        public void onPrepared(MediaPeriod mediaPeriod) {
            this.pendingMediaPeriods.remove(mediaPeriod);
            if (this.pendingMediaPeriods.isEmpty()) {
                this.mediaSourceHandler.removeMessages(1);
                this.downloadHelperHandler.sendEmptyMessage(0);
            }
        }

        public void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline2) {
            MediaPeriod[] mediaPeriodArr;
            if (this.timeline == null) {
                if (timeline2.getWindow(0, new Timeline.Window()).isLive()) {
                    this.downloadHelperHandler.obtainMessage(1, new LiveContentUnsupportedException()).sendToTarget();
                    return;
                }
                this.timeline = timeline2;
                this.mediaPeriods = new MediaPeriod[timeline2.getPeriodCount()];
                int i11 = 0;
                while (true) {
                    mediaPeriodArr = this.mediaPeriods;
                    if (i11 >= mediaPeriodArr.length) {
                        break;
                    }
                    MediaPeriod createPeriod = this.mediaSource.createPeriod(new MediaSource.MediaPeriodId(timeline2.getUidOfPeriod(i11)), this.allocator, 0);
                    this.mediaPeriods[i11] = createPeriod;
                    this.pendingMediaPeriods.add(createPeriod);
                    i11++;
                }
                for (MediaPeriod prepare : mediaPeriodArr) {
                    prepare.prepare(this, 0);
                }
            }
        }

        public void release() {
            if (!this.released) {
                this.released = true;
                this.mediaSourceHandler.sendEmptyMessage(3);
            }
        }

        public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            if (this.pendingMediaPeriods.contains(mediaPeriod)) {
                this.mediaSourceHandler.obtainMessage(2, mediaPeriod).sendToTarget();
            }
        }
    }

    public DownloadHelper(MediaItem mediaItem, @Nullable MediaSource mediaSource2, TrackSelectionParameters trackSelectionParameters, RendererCapabilities[] rendererCapabilitiesArr) {
        this.localConfiguration = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration);
        this.mediaSource = mediaSource2;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(trackSelectionParameters, (ExoTrackSelection.Factory) new DownloadTrackSelection.Factory());
        this.trackSelector = defaultTrackSelector;
        this.rendererCapabilities = rendererCapabilitiesArr;
        defaultTrackSelector.init(new d(), new FakeBandwidthMeter());
        this.callbackHandler = Util.createHandlerForCurrentOrMainLooper();
        this.window = new Timeline.Window();
    }

    @RequiresNonNull({"trackGroupArrays", "trackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline"})
    private void addTrackSelectionInternal(int i11, TrackSelectionParameters trackSelectionParameters) throws ExoPlaybackException {
        this.trackSelector.setParameters(trackSelectionParameters);
        runTrackSelection(i11);
        UnmodifiableIterator<TrackSelectionOverride> it = trackSelectionParameters.overrides.values().iterator();
        while (it.hasNext()) {
            this.trackSelector.setParameters(trackSelectionParameters.buildUpon().setOverrideForType(it.next()).build());
            runTrackSelection(i11);
        }
    }

    @EnsuresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    private void assertPreparedWithMedia() {
        Assertions.checkState(this.isPreparedWithMedia);
    }

    public static MediaSource createMediaSource(DownloadRequest downloadRequest, DataSource.Factory factory) {
        return createMediaSource(downloadRequest, factory, (DrmSessionManager) null);
    }

    private static MediaSource createMediaSourceInternal(MediaItem mediaItem, DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(factory, ExtractorsFactory.EMPTY);
        if (drmSessionManager != null) {
            defaultMediaSourceFactory.setDrmSessionManagerProvider((DrmSessionManagerProvider) new b(drmSessionManager));
        }
        return defaultMediaSourceFactory.createMediaSource(mediaItem);
    }

    @Deprecated
    public static DownloadHelper forDash(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forDash(uri, factory, renderersFactory, (DrmSessionManager) null, getDefaultTrackSelectorParameters(context));
    }

    @Deprecated
    public static DownloadHelper forHls(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forHls(uri, factory, renderersFactory, (DrmSessionManager) null, getDefaultTrackSelectorParameters(context));
    }

    public static DownloadHelper forMediaItem(Context context, MediaItem mediaItem) {
        Assertions.checkArgument(isProgressive((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration)));
        return forMediaItem(mediaItem, getDefaultTrackSelectorParameters(context), (RenderersFactory) null, (DataSource.Factory) null, (DrmSessionManager) null);
    }

    @Deprecated
    public static DownloadHelper forProgressive(Context context, Uri uri) {
        return forMediaItem(context, new MediaItem.Builder().setUri(uri).build());
    }

    @Deprecated
    public static DownloadHelper forSmoothStreaming(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forSmoothStreaming(uri, factory, renderersFactory, (DrmSessionManager) null, DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT);
    }

    public static DefaultTrackSelector.Parameters getDefaultTrackSelectorParameters(Context context) {
        return DefaultTrackSelector.Parameters.getDefaults(context).buildUpon().setForceHighestSupportedBitrate(true).setConstrainAudioChannelCountToDeviceCapabilities(false).build();
    }

    public static RendererCapabilities[] getRendererCapabilities(RenderersFactory renderersFactory) {
        Renderer[] createRenderers = renderersFactory.createRenderers(Util.createHandlerForCurrentOrMainLooper(), new VideoRendererEventListener() {
            public /* synthetic */ void onDroppedFrames(int i11, long j11) {
                g.a(this, i11, j11);
            }

            public /* synthetic */ void onRenderedFirstFrame(Object obj, long j11) {
                g.b(this, obj, j11);
            }

            public /* synthetic */ void onVideoCodecError(Exception exc) {
                g.c(this, exc);
            }

            public /* synthetic */ void onVideoDecoderInitialized(String str, long j11, long j12) {
                g.d(this, str, j11, j12);
            }

            public /* synthetic */ void onVideoDecoderReleased(String str) {
                g.e(this, str);
            }

            public /* synthetic */ void onVideoDisabled(DecoderCounters decoderCounters) {
                g.f(this, decoderCounters);
            }

            public /* synthetic */ void onVideoEnabled(DecoderCounters decoderCounters) {
                g.g(this, decoderCounters);
            }

            public /* synthetic */ void onVideoFrameProcessingOffset(long j11, int i11) {
                g.h(this, j11, i11);
            }

            public /* synthetic */ void onVideoInputFormatChanged(Format format) {
                g.i(this, format);
            }

            public /* synthetic */ void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
                g.j(this, format, decoderReuseEvaluation);
            }

            public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
                g.k(this, videoSize);
            }
        }, new AudioRendererEventListener() {
            public /* synthetic */ void onAudioCodecError(Exception exc) {
                i7.d.a(this, exc);
            }

            public /* synthetic */ void onAudioDecoderInitialized(String str, long j11, long j12) {
                i7.d.b(this, str, j11, j12);
            }

            public /* synthetic */ void onAudioDecoderReleased(String str) {
                i7.d.c(this, str);
            }

            public /* synthetic */ void onAudioDisabled(DecoderCounters decoderCounters) {
                i7.d.d(this, decoderCounters);
            }

            public /* synthetic */ void onAudioEnabled(DecoderCounters decoderCounters) {
                i7.d.e(this, decoderCounters);
            }

            public /* synthetic */ void onAudioInputFormatChanged(Format format) {
                i7.d.f(this, format);
            }

            public /* synthetic */ void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
                i7.d.g(this, format, decoderReuseEvaluation);
            }

            public /* synthetic */ void onAudioPositionAdvancing(long j11) {
                i7.d.h(this, j11);
            }

            public /* synthetic */ void onAudioSinkError(Exception exc) {
                i7.d.i(this, exc);
            }

            public /* synthetic */ void onAudioUnderrun(int i11, long j11, long j12) {
                i7.d.j(this, i11, j11, j12);
            }

            public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z11) {
                i7.d.k(this, z11);
            }
        }, new e(), new f());
        RendererCapabilities[] rendererCapabilitiesArr = new RendererCapabilities[createRenderers.length];
        for (int i11 = 0; i11 < createRenderers.length; i11++) {
            rendererCapabilitiesArr[i11] = createRenderers[i11].getCapabilities();
        }
        return rendererCapabilitiesArr;
    }

    private static boolean isProgressive(MediaItem.LocalConfiguration localConfiguration2) {
        return Util.inferContentTypeForUriAndMimeType(localConfiguration2.uri, localConfiguration2.mimeType) == 4;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ DrmSessionManager lambda$createMediaSourceInternal$6(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
        return drmSessionManager;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getRendererCapabilities$0(CueGroup cueGroup) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getRendererCapabilities$1(Metadata metadata) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$2() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMediaPreparationFailed$5(IOException iOException) {
        ((Callback) Assertions.checkNotNull(this.callback)).onPrepareError(this, iOException);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMediaPrepared$4() {
        ((Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$prepare$3(Callback callback2) {
        callback2.onPrepared(this);
    }

    /* access modifiers changed from: private */
    public void onMediaPreparationFailed(IOException iOException) {
        ((Handler) Assertions.checkNotNull(this.callbackHandler)).post(new c(this, iOException));
    }

    /* access modifiers changed from: private */
    public void onMediaPrepared() throws ExoPlaybackException {
        Assertions.checkNotNull(this.mediaPreparer);
        Assertions.checkNotNull(this.mediaPreparer.mediaPeriods);
        Assertions.checkNotNull(this.mediaPreparer.timeline);
        int length = this.mediaPreparer.mediaPeriods.length;
        int length2 = this.rendererCapabilities.length;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = length;
        Class<List> cls = List.class;
        this.trackSelectionsByPeriodAndRenderer = (List[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = length2;
        iArr2[0] = length;
        this.immutableTrackSelectionsByPeriodAndRenderer = (List[][]) Array.newInstance(cls, iArr2);
        for (int i11 = 0; i11 < length; i11++) {
            for (int i12 = 0; i12 < length2; i12++) {
                this.trackSelectionsByPeriodAndRenderer[i11][i12] = new ArrayList();
                this.immutableTrackSelectionsByPeriodAndRenderer[i11][i12] = Collections.unmodifiableList(this.trackSelectionsByPeriodAndRenderer[i11][i12]);
            }
        }
        this.trackGroupArrays = new TrackGroupArray[length];
        this.mappedTrackInfos = new MappingTrackSelector.MappedTrackInfo[length];
        for (int i13 = 0; i13 < length; i13++) {
            this.trackGroupArrays[i13] = this.mediaPreparer.mediaPeriods[i13].getTrackGroups();
            this.trackSelector.onSelectionActivated(runTrackSelection(i13).info);
            this.mappedTrackInfos[i13] = (MappingTrackSelector.MappedTrackInfo) Assertions.checkNotNull(this.trackSelector.getCurrentMappedTrackInfo());
        }
        setPreparedWithMedia();
        ((Handler) Assertions.checkNotNull(this.callbackHandler)).post(new z7.g(this));
    }

    @RequiresNonNull({"trackGroupArrays", "trackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline"})
    private TrackSelectorResult runTrackSelection(int i11) throws ExoPlaybackException {
        boolean z11;
        TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.trackGroupArrays[i11], new MediaSource.MediaPeriodId(this.mediaPreparer.timeline.getUidOfPeriod(i11)), this.mediaPreparer.timeline);
        for (int i12 = 0; i12 < selectTracks.length; i12++) {
            ExoTrackSelection exoTrackSelection = selectTracks.selections[i12];
            if (exoTrackSelection != null) {
                List<ExoTrackSelection> list = this.trackSelectionsByPeriodAndRenderer[i11][i12];
                int i13 = 0;
                while (true) {
                    if (i13 >= list.size()) {
                        z11 = false;
                        break;
                    }
                    ExoTrackSelection exoTrackSelection2 = list.get(i13);
                    if (exoTrackSelection2.getTrackGroup().equals(exoTrackSelection.getTrackGroup())) {
                        this.scratchSet.clear();
                        for (int i14 = 0; i14 < exoTrackSelection2.length(); i14++) {
                            this.scratchSet.put(exoTrackSelection2.getIndexInTrackGroup(i14), 0);
                        }
                        for (int i15 = 0; i15 < exoTrackSelection.length(); i15++) {
                            this.scratchSet.put(exoTrackSelection.getIndexInTrackGroup(i15), 0);
                        }
                        int[] iArr = new int[this.scratchSet.size()];
                        for (int i16 = 0; i16 < this.scratchSet.size(); i16++) {
                            iArr[i16] = this.scratchSet.keyAt(i16);
                        }
                        list.set(i13, new DownloadTrackSelection(exoTrackSelection2.getTrackGroup(), iArr));
                        z11 = true;
                    } else {
                        i13++;
                    }
                }
                if (!z11) {
                    list.add(exoTrackSelection);
                }
            }
        }
        return selectTracks;
    }

    @RequiresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    private void setPreparedWithMedia() {
        this.isPreparedWithMedia = true;
    }

    public void addAudioLanguagesToSelection(String... strArr) {
        boolean z11;
        try {
            assertPreparedWithMedia();
            DefaultTrackSelector.Parameters.Builder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            buildUpon.setForceHighestSupportedBitrate(true);
            for (RendererCapabilities trackType : this.rendererCapabilities) {
                int trackType2 = trackType.getTrackType();
                if (trackType2 != 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                buildUpon.setTrackTypeDisabled(trackType2, z11);
            }
            int periodCount = getPeriodCount();
            for (String preferredAudioLanguage : strArr) {
                TrackSelectionParameters build = buildUpon.setPreferredAudioLanguage(preferredAudioLanguage).build();
                for (int i11 = 0; i11 < periodCount; i11++) {
                    addTrackSelectionInternal(i11, build);
                }
            }
        } catch (ExoPlaybackException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public void addTextLanguagesToSelection(boolean z11, String... strArr) {
        boolean z12;
        try {
            assertPreparedWithMedia();
            DefaultTrackSelector.Parameters.Builder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            buildUpon.setSelectUndeterminedTextLanguage(z11);
            buildUpon.setForceHighestSupportedBitrate(true);
            for (RendererCapabilities trackType : this.rendererCapabilities) {
                int trackType2 = trackType.getTrackType();
                if (trackType2 != 3) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                buildUpon.setTrackTypeDisabled(trackType2, z12);
            }
            int periodCount = getPeriodCount();
            for (String preferredTextLanguage : strArr) {
                TrackSelectionParameters build = buildUpon.setPreferredTextLanguage(preferredTextLanguage).build();
                for (int i11 = 0; i11 < periodCount; i11++) {
                    addTrackSelectionInternal(i11, build);
                }
            }
        } catch (ExoPlaybackException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public void addTrackSelection(int i11, TrackSelectionParameters trackSelectionParameters) {
        try {
            assertPreparedWithMedia();
            addTrackSelectionInternal(i11, trackSelectionParameters);
        } catch (ExoPlaybackException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public void addTrackSelectionForSingleRenderer(int i11, int i12, DefaultTrackSelector.Parameters parameters, List<DefaultTrackSelector.SelectionOverride> list) {
        boolean z11;
        try {
            assertPreparedWithMedia();
            DefaultTrackSelector.Parameters.Builder buildUpon = parameters.buildUpon();
            for (int i13 = 0; i13 < this.mappedTrackInfos[i11].getRendererCount(); i13++) {
                if (i13 != i12) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                buildUpon.setRendererDisabled(i13, z11);
            }
            if (list.isEmpty()) {
                addTrackSelectionInternal(i11, buildUpon.build());
                return;
            }
            TrackGroupArray trackGroups = this.mappedTrackInfos[i11].getTrackGroups(i12);
            for (int i14 = 0; i14 < list.size(); i14++) {
                buildUpon.setSelectionOverride(i12, trackGroups, list.get(i14));
                addTrackSelectionInternal(i11, buildUpon.build());
            }
        } catch (ExoPlaybackException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public void clearTrackSelections(int i11) {
        assertPreparedWithMedia();
        for (int i12 = 0; i12 < this.rendererCapabilities.length; i12++) {
            this.trackSelectionsByPeriodAndRenderer[i11][i12].clear();
        }
    }

    public DownloadRequest getDownloadRequest(@Nullable byte[] bArr) {
        return getDownloadRequest(this.localConfiguration.uri.toString(), bArr);
    }

    @Nullable
    public Object getManifest() {
        if (this.mediaSource == null) {
            return null;
        }
        assertPreparedWithMedia();
        if (this.mediaPreparer.timeline.getWindowCount() > 0) {
            return this.mediaPreparer.timeline.getWindow(0, this.window).manifest;
        }
        return null;
    }

    public MappingTrackSelector.MappedTrackInfo getMappedTrackInfo(int i11) {
        assertPreparedWithMedia();
        return this.mappedTrackInfos[i11];
    }

    public int getPeriodCount() {
        if (this.mediaSource == null) {
            return 0;
        }
        assertPreparedWithMedia();
        return this.trackGroupArrays.length;
    }

    public TrackGroupArray getTrackGroups(int i11) {
        assertPreparedWithMedia();
        return this.trackGroupArrays[i11];
    }

    public List<ExoTrackSelection> getTrackSelections(int i11, int i12) {
        assertPreparedWithMedia();
        return this.immutableTrackSelectionsByPeriodAndRenderer[i11][i12];
    }

    public Tracks getTracks(int i11) {
        assertPreparedWithMedia();
        return TrackSelectionUtil.buildTracks(this.mappedTrackInfos[i11], (List<? extends TrackSelection>[]) this.immutableTrackSelectionsByPeriodAndRenderer[i11]);
    }

    public void prepare(Callback callback2) {
        boolean z11;
        if (this.callback == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        this.callback = callback2;
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            this.mediaPreparer = new MediaPreparer(mediaSource2, this);
        } else {
            this.callbackHandler.post(new h(this, callback2));
        }
    }

    public void release() {
        MediaPreparer mediaPreparer2 = this.mediaPreparer;
        if (mediaPreparer2 != null) {
            mediaPreparer2.release();
        }
        this.trackSelector.release();
    }

    public void replaceTrackSelections(int i11, TrackSelectionParameters trackSelectionParameters) {
        try {
            assertPreparedWithMedia();
            clearTrackSelections(i11);
            addTrackSelectionInternal(i11, trackSelectionParameters);
        } catch (ExoPlaybackException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static MediaSource createMediaSource(DownloadRequest downloadRequest, DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        return createMediaSourceInternal(downloadRequest.toMediaItem(), factory, drmSessionManager);
    }

    @Deprecated
    public static DownloadHelper forProgressive(Context context, Uri uri, @Nullable String str) {
        return forMediaItem(context, new MediaItem.Builder().setUri(uri).setCustomCacheKey(str).build());
    }

    @Deprecated
    public static DownloadHelper forSmoothStreaming(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forSmoothStreaming(uri, factory, renderersFactory, (DrmSessionManager) null, getDefaultTrackSelectorParameters(context));
    }

    public DownloadRequest getDownloadRequest(String str, @Nullable byte[] bArr) {
        DownloadRequest.Builder mimeType = new DownloadRequest.Builder(str, this.localConfiguration.uri).setMimeType(this.localConfiguration.mimeType);
        MediaItem.DrmConfiguration drmConfiguration = this.localConfiguration.drmConfiguration;
        DownloadRequest.Builder data = mimeType.setKeySetId(drmConfiguration != null ? drmConfiguration.getKeySetId() : null).setCustomCacheKey(this.localConfiguration.customCacheKey).setData(bArr);
        if (this.mediaSource == null) {
            return data.build();
        }
        assertPreparedWithMedia();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = this.trackSelectionsByPeriodAndRenderer.length;
        for (int i11 = 0; i11 < length; i11++) {
            arrayList2.clear();
            for (List<ExoTrackSelection> addAll : this.trackSelectionsByPeriodAndRenderer[i11]) {
                arrayList2.addAll(addAll);
            }
            arrayList.addAll(this.mediaPreparer.mediaPeriods[i11].getStreamKeys(arrayList2));
        }
        return data.setStreamKeys(arrayList).build();
    }

    @Deprecated
    public static DownloadHelper forDash(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, TrackSelectionParameters trackSelectionParameters) {
        return forMediaItem(new MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_MPD).build(), trackSelectionParameters, renderersFactory, factory, drmSessionManager);
    }

    @Deprecated
    public static DownloadHelper forHls(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, TrackSelectionParameters trackSelectionParameters) {
        return forMediaItem(new MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_M3U8).build(), trackSelectionParameters, renderersFactory, factory, drmSessionManager);
    }

    public static DownloadHelper forMediaItem(Context context, MediaItem mediaItem, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory) {
        return forMediaItem(mediaItem, getDefaultTrackSelectorParameters(context), renderersFactory, factory, (DrmSessionManager) null);
    }

    @Deprecated
    public static DownloadHelper forSmoothStreaming(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, TrackSelectionParameters trackSelectionParameters) {
        return forMediaItem(new MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_SS).build(), trackSelectionParameters, renderersFactory, factory, drmSessionManager);
    }

    public static DownloadHelper forMediaItem(MediaItem mediaItem, TrackSelectionParameters trackSelectionParameters, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory) {
        return forMediaItem(mediaItem, trackSelectionParameters, renderersFactory, factory, (DrmSessionManager) null);
    }

    public static DownloadHelper forMediaItem(MediaItem mediaItem, TrackSelectionParameters trackSelectionParameters, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        MediaSource mediaSource2;
        boolean isProgressive = isProgressive((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration));
        Assertions.checkArgument(isProgressive || factory != null);
        if (isProgressive) {
            mediaSource2 = null;
        } else {
            mediaSource2 = createMediaSourceInternal(mediaItem, (DataSource.Factory) Util.castNonNull(factory), drmSessionManager);
        }
        return new DownloadHelper(mediaItem, mediaSource2, trackSelectionParameters, renderersFactory != null ? getRendererCapabilities(renderersFactory) : new RendererCapabilities[0]);
    }
}
