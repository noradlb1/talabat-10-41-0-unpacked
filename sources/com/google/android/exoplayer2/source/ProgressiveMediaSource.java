package com.google.android.exoplayer2.source;

import a8.v;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    private final int continueLoadingCheckIntervalBytes;
    private final DataSource.Factory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private final LoadErrorHandlingPolicy loadableLoadErrorHandlingPolicy;
    private final MediaItem.LocalConfiguration localConfiguration;
    private final MediaItem mediaItem;
    private final ProgressiveMediaExtractor.Factory progressiveMediaExtractorFactory;
    private long timelineDurationUs;
    private boolean timelineIsLive;
    private boolean timelineIsPlaceholder;
    private boolean timelineIsSeekable;
    @Nullable
    private TransferListener transferListener;

    public static final class Factory implements MediaSourceFactory {
        private int continueLoadingCheckIntervalBytes;
        @Nullable
        private String customCacheKey;
        private final DataSource.Factory dataSourceFactory;
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private ProgressiveMediaExtractor.Factory progressiveMediaExtractorFactory;
        @Nullable
        private Object tag;

        public Factory(DataSource.Factory factory) {
            this(factory, (ExtractorsFactory) new DefaultExtractorsFactory());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ProgressiveMediaExtractor lambda$new$0(ExtractorsFactory extractorsFactory, PlayerId playerId) {
            return new BundledExtractorsAdapter(extractorsFactory);
        }

        public int[] getSupportedTypes() {
            return new int[]{4};
        }

        @CanIgnoreReturnValue
        public Factory setContinueLoadingCheckIntervalBytes(int i11) {
            this.continueLoadingCheckIntervalBytes = i11;
            return this;
        }

        public Factory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
            this(factory, (ProgressiveMediaExtractor.Factory) new v(extractorsFactory));
        }

        public ProgressiveMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.localConfiguration);
            MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
            boolean z11 = true;
            boolean z12 = localConfiguration.tag == null && this.tag != null;
            if (localConfiguration.customCacheKey != null || this.customCacheKey == null) {
                z11 = false;
            }
            if (z12 && z11) {
                mediaItem = mediaItem.buildUpon().setTag(this.tag).setCustomCacheKey(this.customCacheKey).build();
            } else if (z12) {
                mediaItem = mediaItem.buildUpon().setTag(this.tag).build();
            } else if (z11) {
                mediaItem = mediaItem.buildUpon().setCustomCacheKey(this.customCacheKey).build();
            }
            MediaItem mediaItem2 = mediaItem;
            return new ProgressiveMediaSource(mediaItem2, this.dataSourceFactory, this.progressiveMediaExtractorFactory, this.drmSessionManagerProvider.get(mediaItem2), this.loadErrorHandlingPolicy, this.continueLoadingCheckIntervalBytes);
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

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2) {
            this(factory, factory2, new DefaultDrmSessionManagerProvider(), new DefaultLoadErrorHandlingPolicy(), 1048576);
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManagerProvider drmSessionManagerProvider2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, int i11) {
            this.dataSourceFactory = factory;
            this.progressiveMediaExtractorFactory = factory2;
            this.drmSessionManagerProvider = drmSessionManagerProvider2;
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
            this.continueLoadingCheckIntervalBytes = i11;
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.google.android.exoplayer2.source.ProgressiveMediaSource$1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void notifySourceInfoRefreshed() {
        /*
            r9 = this;
            com.google.android.exoplayer2.source.SinglePeriodTimeline r8 = new com.google.android.exoplayer2.source.SinglePeriodTimeline
            long r1 = r9.timelineDurationUs
            boolean r3 = r9.timelineIsSeekable
            r4 = 0
            boolean r5 = r9.timelineIsLive
            r6 = 0
            com.google.android.exoplayer2.MediaItem r7 = r9.mediaItem
            r0 = r8
            r0.<init>((long) r1, (boolean) r3, (boolean) r4, (boolean) r5, (java.lang.Object) r6, (com.google.android.exoplayer2.MediaItem) r7)
            boolean r0 = r9.timelineIsPlaceholder
            if (r0 == 0) goto L_0x001a
            com.google.android.exoplayer2.source.ProgressiveMediaSource$1 r0 = new com.google.android.exoplayer2.source.ProgressiveMediaSource$1
            r0.<init>(r9, r8)
            r8 = r0
        L_0x001a:
            r9.refreshSourceInfo(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ProgressiveMediaSource.notifySourceInfoRefreshed():void");
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        DataSource createDataSource = this.dataSourceFactory.createDataSource();
        TransferListener transferListener2 = this.transferListener;
        if (transferListener2 != null) {
            createDataSource.addTransferListener(transferListener2);
        }
        return new ProgressiveMediaPeriod(this.localConfiguration.uri, createDataSource, this.progressiveMediaExtractorFactory.createProgressiveMediaExtractor(getPlayerId()), this.drmSessionManager, createDrmEventDispatcher(mediaPeriodId), this.loadableLoadErrorHandlingPolicy, createEventDispatcher(mediaPeriodId), this, allocator, this.localConfiguration.customCacheKey, this.continueLoadingCheckIntervalBytes);
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public void maybeThrowSourceInfoRefreshError() {
    }

    public void onSourceInfoRefreshed(long j11, boolean z11, boolean z12) {
        if (j11 == C.TIME_UNSET) {
            j11 = this.timelineDurationUs;
        }
        if (this.timelineIsPlaceholder || this.timelineDurationUs != j11 || this.timelineIsSeekable != z11 || this.timelineIsLive != z12) {
            this.timelineDurationUs = j11;
            this.timelineIsSeekable = z11;
            this.timelineIsLive = z12;
            this.timelineIsPlaceholder = false;
            notifySourceInfoRefreshed();
        }
    }

    public void prepareSourceInternal(@Nullable TransferListener transferListener2) {
        this.transferListener = transferListener2;
        this.drmSessionManager.setPlayer((Looper) Assertions.checkNotNull(Looper.myLooper()), getPlayerId());
        this.drmSessionManager.prepare();
        notifySourceInfoRefreshed();
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod) mediaPeriod).release();
    }

    public void releaseSourceInternal() {
        this.drmSessionManager.release();
    }

    private ProgressiveMediaSource(MediaItem mediaItem2, DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i11) {
        this.localConfiguration = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem2.localConfiguration);
        this.mediaItem = mediaItem2;
        this.dataSourceFactory = factory;
        this.progressiveMediaExtractorFactory = factory2;
        this.drmSessionManager = drmSessionManager2;
        this.loadableLoadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.continueLoadingCheckIntervalBytes = i11;
        this.timelineIsPlaceholder = true;
        this.timelineDurationUs = C.TIME_UNSET;
    }
}
