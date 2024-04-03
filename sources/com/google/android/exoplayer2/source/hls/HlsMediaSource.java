package com.google.android.exoplayer2.source.hls;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public final class HlsMediaSource extends BaseMediaSource implements HlsPlaylistTracker.PrimaryPlaylistListener {
    public static final int METADATA_TYPE_EMSG = 3;
    public static final int METADATA_TYPE_ID3 = 1;
    private final boolean allowChunklessPreparation;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private final long elapsedRealTimeOffsetMs;
    private final HlsExtractorFactory extractorFactory;
    private MediaItem.LiveConfiguration liveConfiguration;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final MediaItem.LocalConfiguration localConfiguration;
    private final MediaItem mediaItem;
    @Nullable
    private TransferListener mediaTransferListener;
    private final int metadataType;
    private final HlsPlaylistTracker playlistTracker;
    private final boolean useSessionKeys;

    public static final class Factory implements MediaSourceFactory {
        private boolean allowChunklessPreparation;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private long elapsedRealTimeOffsetMs;
        private HlsExtractorFactory extractorFactory;
        private final HlsDataSourceFactory hlsDataSourceFactory;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private int metadataType;
        private HlsPlaylistParserFactory playlistParserFactory;
        private HlsPlaylistTracker.Factory playlistTrackerFactory;
        private boolean useSessionKeys;

        public Factory(DataSource.Factory factory) {
            this((HlsDataSourceFactory) new DefaultHlsDataSourceFactory(factory));
        }

        public int[] getSupportedTypes() {
            return new int[]{2};
        }

        @CanIgnoreReturnValue
        public Factory setAllowChunklessPreparation(boolean z11) {
            this.allowChunklessPreparation = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2) {
            this.compositeSequenceableLoaderFactory = (CompositeSequenceableLoaderFactory) Assertions.checkNotNull(compositeSequenceableLoaderFactory2, "HlsMediaSource.Factory#setCompositeSequenceableLoaderFactory no longer handles null by instantiating a new DefaultCompositeSequenceableLoaderFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @VisibleForTesting
        @CanIgnoreReturnValue
        public Factory setElapsedRealTimeOffsetMs(long j11) {
            this.elapsedRealTimeOffsetMs = j11;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setExtractorFactory(@Nullable HlsExtractorFactory hlsExtractorFactory) {
            if (hlsExtractorFactory == null) {
                hlsExtractorFactory = HlsExtractorFactory.DEFAULT;
            }
            this.extractorFactory = hlsExtractorFactory;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setMetadataType(int i11) {
            this.metadataType = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            this.playlistParserFactory = (HlsPlaylistParserFactory) Assertions.checkNotNull(hlsPlaylistParserFactory, "HlsMediaSource.Factory#setPlaylistParserFactory no longer handles null by instantiating a new DefaultHlsPlaylistParserFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setPlaylistTrackerFactory(HlsPlaylistTracker.Factory factory) {
            this.playlistTrackerFactory = (HlsPlaylistTracker.Factory) Assertions.checkNotNull(factory, "HlsMediaSource.Factory#setPlaylistTrackerFactory no longer handles null by defaulting to DefaultHlsPlaylistTracker.FACTORY. Explicitly pass a reference to this instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setUseSessionKeys(boolean z11) {
            this.useSessionKeys = z11;
            return this;
        }

        public Factory(HlsDataSourceFactory hlsDataSourceFactory2) {
            this.hlsDataSourceFactory = (HlsDataSourceFactory) Assertions.checkNotNull(hlsDataSourceFactory2);
            this.drmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
            this.playlistParserFactory = new DefaultHlsPlaylistParserFactory();
            this.playlistTrackerFactory = DefaultHlsPlaylistTracker.FACTORY;
            this.extractorFactory = HlsExtractorFactory.DEFAULT;
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
            this.metadataType = 1;
            this.elapsedRealTimeOffsetMs = C.TIME_UNSET;
            this.allowChunklessPreparation = true;
        }

        public HlsMediaSource createMediaSource(MediaItem mediaItem) {
            MediaItem mediaItem2 = mediaItem;
            Assertions.checkNotNull(mediaItem2.localConfiguration);
            HlsPlaylistParserFactory hlsPlaylistParserFactory = this.playlistParserFactory;
            List<StreamKey> list = mediaItem2.localConfiguration.streamKeys;
            if (!list.isEmpty()) {
                hlsPlaylistParserFactory = new FilteringHlsPlaylistParserFactory(hlsPlaylistParserFactory, list);
            }
            HlsDataSourceFactory hlsDataSourceFactory2 = this.hlsDataSourceFactory;
            HlsExtractorFactory hlsExtractorFactory = this.extractorFactory;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2 = this.compositeSequenceableLoaderFactory;
            DrmSessionManager drmSessionManager = this.drmSessionManagerProvider.get(mediaItem2);
            LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.loadErrorHandlingPolicy;
            return new HlsMediaSource(mediaItem, hlsDataSourceFactory2, hlsExtractorFactory, compositeSequenceableLoaderFactory2, drmSessionManager, loadErrorHandlingPolicy2, this.playlistTrackerFactory.createTracker(this.hlsDataSourceFactory, loadErrorHandlingPolicy2, hlsPlaylistParserFactory), this.elapsedRealTimeOffsetMs, this.allowChunklessPreparation, this.metadataType, this.useSessionKeys);
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
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetadataType {
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
    }

    private SinglePeriodTimeline createTimelineForLive(HlsMediaPlaylist hlsMediaPlaylist, long j11, long j12, HlsManifest hlsManifest) {
        long j13;
        long j14;
        boolean z11;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        long initialStartTimeUs = hlsMediaPlaylist2.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
        if (hlsMediaPlaylist2.hasEndTag) {
            j13 = initialStartTimeUs + hlsMediaPlaylist2.durationUs;
        } else {
            j13 = -9223372036854775807L;
        }
        long liveEdgeOffsetUs = getLiveEdgeOffsetUs(hlsMediaPlaylist);
        long j15 = this.liveConfiguration.targetOffsetMs;
        if (j15 != C.TIME_UNSET) {
            j14 = Util.msToUs(j15);
        } else {
            j14 = getTargetLiveOffsetUs(hlsMediaPlaylist2, liveEdgeOffsetUs);
        }
        updateLiveConfiguration(hlsMediaPlaylist2, Util.constrainValue(j14, liveEdgeOffsetUs, hlsMediaPlaylist2.durationUs + liveEdgeOffsetUs));
        long liveWindowDefaultStartPositionUs = getLiveWindowDefaultStartPositionUs(hlsMediaPlaylist2, liveEdgeOffsetUs);
        if (hlsMediaPlaylist2.playlistType != 2 || !hlsMediaPlaylist2.hasPositiveStartOffset) {
            z11 = false;
        } else {
            z11 = true;
        }
        return new SinglePeriodTimeline(j11, j12, C.TIME_UNSET, j13, hlsMediaPlaylist2.durationUs, initialStartTimeUs, liveWindowDefaultStartPositionUs, true, !hlsMediaPlaylist2.hasEndTag, z11, hlsManifest, this.mediaItem, this.liveConfiguration);
    }

    private SinglePeriodTimeline createTimelineForOnDemand(HlsMediaPlaylist hlsMediaPlaylist, long j11, long j12, HlsManifest hlsManifest) {
        long j13;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        if (hlsMediaPlaylist2.startOffsetUs == C.TIME_UNSET || hlsMediaPlaylist2.segments.isEmpty()) {
            j13 = 0;
        } else {
            if (!hlsMediaPlaylist2.preciseStart) {
                long j14 = hlsMediaPlaylist2.startOffsetUs;
                if (j14 != hlsMediaPlaylist2.durationUs) {
                    j13 = findClosestPrecedingSegment(hlsMediaPlaylist2.segments, j14).relativeStartTimeUs;
                }
            }
            j13 = hlsMediaPlaylist2.startOffsetUs;
        }
        long j15 = hlsMediaPlaylist2.durationUs;
        return new SinglePeriodTimeline(j11, j12, C.TIME_UNSET, j15, j15, 0, j13, true, false, true, hlsManifest, this.mediaItem, (MediaItem.LiveConfiguration) null);
    }

    @Nullable
    private static HlsMediaPlaylist.Part findClosestPrecedingIndependentPart(List<HlsMediaPlaylist.Part> list, long j11) {
        HlsMediaPlaylist.Part part = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            HlsMediaPlaylist.Part part2 = list.get(i11);
            long j12 = part2.relativeStartTimeUs;
            if (j12 <= j11 && part2.isIndependent) {
                part = part2;
            } else if (j12 > j11) {
                break;
            }
        }
        return part;
    }

    private static HlsMediaPlaylist.Segment findClosestPrecedingSegment(List<HlsMediaPlaylist.Segment> list, long j11) {
        return list.get(Util.binarySearchFloor(list, Long.valueOf(j11), true, true));
    }

    private long getLiveEdgeOffsetUs(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist.hasProgramDateTime) {
            return Util.msToUs(Util.getNowUnixTimeMs(this.elapsedRealTimeOffsetMs)) - hlsMediaPlaylist.getEndTimeUs();
        }
        return 0;
    }

    private long getLiveWindowDefaultStartPositionUs(HlsMediaPlaylist hlsMediaPlaylist, long j11) {
        long j12 = hlsMediaPlaylist.startOffsetUs;
        if (j12 == C.TIME_UNSET) {
            j12 = (hlsMediaPlaylist.durationUs + j11) - Util.msToUs(this.liveConfiguration.targetOffsetMs);
        }
        if (hlsMediaPlaylist.preciseStart) {
            return j12;
        }
        HlsMediaPlaylist.Part findClosestPrecedingIndependentPart = findClosestPrecedingIndependentPart(hlsMediaPlaylist.trailingParts, j12);
        if (findClosestPrecedingIndependentPart != null) {
            return findClosestPrecedingIndependentPart.relativeStartTimeUs;
        }
        if (hlsMediaPlaylist.segments.isEmpty()) {
            return 0;
        }
        HlsMediaPlaylist.Segment findClosestPrecedingSegment = findClosestPrecedingSegment(hlsMediaPlaylist.segments, j12);
        HlsMediaPlaylist.Part findClosestPrecedingIndependentPart2 = findClosestPrecedingIndependentPart(findClosestPrecedingSegment.parts, j12);
        if (findClosestPrecedingIndependentPart2 != null) {
            return findClosestPrecedingIndependentPart2.relativeStartTimeUs;
        }
        return findClosestPrecedingSegment.relativeStartTimeUs;
    }

    private static long getTargetLiveOffsetUs(HlsMediaPlaylist hlsMediaPlaylist, long j11) {
        long j12;
        HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.serverControl;
        long j13 = hlsMediaPlaylist.startOffsetUs;
        if (j13 != C.TIME_UNSET) {
            j12 = hlsMediaPlaylist.durationUs - j13;
        } else {
            long j14 = serverControl.partHoldBackUs;
            if (j14 == C.TIME_UNSET || hlsMediaPlaylist.partTargetDurationUs == C.TIME_UNSET) {
                long j15 = serverControl.holdBackUs;
                if (j15 != C.TIME_UNSET) {
                    j12 = j15;
                } else {
                    j12 = hlsMediaPlaylist.targetDurationUs * 3;
                }
            } else {
                j12 = j14;
            }
        }
        return j12 + j11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateLiveConfiguration(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist r5, long r6) {
        /*
            r4 = this;
            com.google.android.exoplayer2.MediaItem r0 = r4.mediaItem
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r0 = r0.liveConfiguration
            float r1 = r0.minPlaybackSpeed
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0028
            float r0 = r0.maxPlaybackSpeed
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0028
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$ServerControl r5 = r5.serverControl
            long r0 = r5.holdBackUs
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0028
            long r0 = r5.partHoldBackUs
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0028
            r5 = 1
            goto L_0x0029
        L_0x0028:
            r5 = 0
        L_0x0029:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r0 = new com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder
            r0.<init>()
            long r6 = com.google.android.exoplayer2.util.Util.usToMs(r6)
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r6 = r0.setTargetOffsetMs(r6)
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r5 == 0) goto L_0x003c
            r0 = r7
            goto L_0x0040
        L_0x003c:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r0 = r4.liveConfiguration
            float r0 = r0.minPlaybackSpeed
        L_0x0040:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r6 = r6.setMinPlaybackSpeed(r0)
            if (r5 == 0) goto L_0x0047
            goto L_0x004b
        L_0x0047:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r5 = r4.liveConfiguration
            float r7 = r5.maxPlaybackSpeed
        L_0x004b:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r5 = r6.setMaxPlaybackSpeed(r7)
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r5 = r5.build()
            r4.liveConfiguration = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaSource.updateLiveConfiguration(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist, long):void");
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId);
        return new HlsMediaPeriod(this.extractorFactory, this.playlistTracker, this.dataSourceFactory, this.mediaTransferListener, this.drmSessionManager, createDrmEventDispatcher(mediaPeriodId), this.loadErrorHandlingPolicy, createEventDispatcher, allocator, this.compositeSequenceableLoaderFactory, this.allowChunklessPreparation, this.metadataType, this.useSessionKeys, getPlayerId());
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.playlistTracker.maybeThrowPrimaryPlaylistRefreshError();
    }

    public void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist) {
        long j11;
        long j12;
        SinglePeriodTimeline singlePeriodTimeline;
        if (hlsMediaPlaylist.hasProgramDateTime) {
            j11 = Util.usToMs(hlsMediaPlaylist.startTimeUs);
        } else {
            j11 = -9223372036854775807L;
        }
        int i11 = hlsMediaPlaylist.playlistType;
        if (i11 == 2 || i11 == 1) {
            j12 = j11;
        } else {
            j12 = -9223372036854775807L;
        }
        HlsManifest hlsManifest = new HlsManifest((HlsMultivariantPlaylist) Assertions.checkNotNull(this.playlistTracker.getMultivariantPlaylist()), hlsMediaPlaylist);
        if (this.playlistTracker.isLive()) {
            singlePeriodTimeline = createTimelineForLive(hlsMediaPlaylist, j12, j11, hlsManifest);
        } else {
            singlePeriodTimeline = createTimelineForOnDemand(hlsMediaPlaylist, j12, j11, hlsManifest);
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        this.drmSessionManager.setPlayer((Looper) Assertions.checkNotNull(Looper.myLooper()), getPlayerId());
        this.drmSessionManager.prepare();
        this.playlistTracker.start(this.localConfiguration.uri, createEventDispatcher((MediaSource.MediaPeriodId) null), this);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).release();
    }

    public void releaseSourceInternal() {
        this.playlistTracker.stop();
        this.drmSessionManager.release();
    }

    private HlsMediaSource(MediaItem mediaItem2, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, HlsPlaylistTracker hlsPlaylistTracker, long j11, boolean z11, int i11, boolean z12) {
        this.localConfiguration = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem2.localConfiguration);
        this.mediaItem = mediaItem2;
        this.liveConfiguration = mediaItem2.liveConfiguration;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.extractorFactory = hlsExtractorFactory;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.playlistTracker = hlsPlaylistTracker;
        this.elapsedRealTimeOffsetMs = j11;
        this.allowChunklessPreparation = z11;
        this.metadataType = i11;
        this.useSessionKeys = z12;
    }
}
