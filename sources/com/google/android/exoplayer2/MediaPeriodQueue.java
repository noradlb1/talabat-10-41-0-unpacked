package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.common.collect.ImmutableList;

final class MediaPeriodQueue {
    public static final long INITIAL_RENDERER_POSITION_OFFSET_US = 1000000000000L;
    private static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
    private final AnalyticsCollector analyticsCollector;
    private final HandlerWrapper analyticsCollectorHandler;
    private int length;
    @Nullable
    private MediaPeriodHolder loading;
    private long nextWindowSequenceNumber;
    @Nullable
    private Object oldFrontPeriodUid;
    private long oldFrontPeriodWindowSequenceNumber;
    private final Timeline.Period period = new Timeline.Period();
    @Nullable
    private MediaPeriodHolder playing;
    @Nullable
    private MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final Timeline.Window window = new Timeline.Window();

    public MediaPeriodQueue(AnalyticsCollector analyticsCollector2, HandlerWrapper handlerWrapper) {
        this.analyticsCollector = analyticsCollector2;
        this.analyticsCollectorHandler = handlerWrapper;
    }

    private boolean areDurationsCompatible(long j11, long j12) {
        return j11 == C.TIME_UNSET || j11 == j12;
    }

    private boolean canKeepMediaPeriodHolder(MediaPeriodInfo mediaPeriodInfo, MediaPeriodInfo mediaPeriodInfo2) {
        return mediaPeriodInfo.startPositionUs == mediaPeriodInfo2.startPositionUs && mediaPeriodInfo.f34904id.equals(mediaPeriodInfo2.f34904id);
    }

    @Nullable
    private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        return getMediaPeriodInfo(playbackInfo.timeline, playbackInfo.periodId, playbackInfo.requestedContentPositionUs, playbackInfo.positionUs);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00cc, code lost:
        if (r0.isServerSideInsertedAdGroup(r0.getRemovedAdGroupCount()) != false) goto L_0x00d0;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.MediaPeriodInfo getFollowingMediaPeriodInfo(com.google.android.exoplayer2.Timeline r20, com.google.android.exoplayer2.MediaPeriodHolder r21, long r22) {
        /*
            r19 = this;
            r9 = r19
            r8 = r20
            r10 = r21
            com.google.android.exoplayer2.MediaPeriodInfo r11 = r10.info
            long r0 = r21.getRendererOffset()
            long r2 = r11.durationUs
            long r0 = r0 + r2
            long r6 = r0 - r22
            boolean r0 = r11.isLastInTimelinePeriod
            r13 = -1
            r14 = 1
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r17 = 0
            if (r0 == 0) goto L_0x00ef
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r11.f34904id
            java.lang.Object r0 = r0.periodUid
            int r1 = r8.getIndexOfPeriod(r0)
            com.google.android.exoplayer2.Timeline$Period r2 = r9.period
            com.google.android.exoplayer2.Timeline$Window r3 = r9.window
            int r0 = r9.repeatMode
            boolean r5 = r9.shuffleModeEnabled
            r4 = r0
            r0 = r20
            int r0 = r0.getNextPeriodIndex(r1, r2, r3, r4, r5)
            if (r0 != r13) goto L_0x0038
            return r17
        L_0x0038:
            com.google.android.exoplayer2.Timeline$Period r1 = r9.period
            com.google.android.exoplayer2.Timeline$Period r1 = r8.getPeriod(r0, r1, r14)
            int r3 = r1.windowIndex
            com.google.android.exoplayer2.Timeline$Period r1 = r9.period
            java.lang.Object r1 = r1.uid
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r11.f34904id
            long r4 = r2.windowSequenceNumber
            com.google.android.exoplayer2.Timeline$Window r2 = r9.window
            com.google.android.exoplayer2.Timeline$Window r2 = r8.getWindow(r3, r2)
            int r2 = r2.firstPeriodIndex
            if (r2 != r0) goto L_0x0099
            com.google.android.exoplayer2.Timeline$Window r1 = r9.window
            com.google.android.exoplayer2.Timeline$Period r2 = r9.period
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r12 = 0
            long r6 = java.lang.Math.max(r12, r6)
            r0 = r20
            android.util.Pair r0 = r0.getPeriodPositionUs(r1, r2, r3, r4, r6)
            if (r0 != 0) goto L_0x006e
            return r17
        L_0x006e:
            java.lang.Object r1 = r0.first
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r4 = r0.longValue()
            com.google.android.exoplayer2.MediaPeriodHolder r0 = r21.getNext()
            if (r0 == 0) goto L_0x008d
            java.lang.Object r2 = r0.uid
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x008d
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.info
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.f34904id
            long r2 = r0.windowSequenceNumber
            goto L_0x0094
        L_0x008d:
            long r2 = r9.nextWindowSequenceNumber
            r6 = 1
            long r6 = r6 + r2
            r9.nextWindowSequenceNumber = r6
        L_0x0094:
            r12 = r4
            r17 = r15
            r4 = r2
            goto L_0x009d
        L_0x0099:
            r12 = 0
            r17 = r12
        L_0x009d:
            com.google.android.exoplayer2.Timeline$Window r6 = r9.window
            com.google.android.exoplayer2.Timeline$Period r7 = r9.period
            r0 = r20
            r2 = r12
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = resolveMediaPeriodIdForAds(r0, r1, r2, r4, r6, r7)
            int r0 = (r17 > r15 ? 1 : (r17 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x00e3
            long r0 = r11.requestedContentPositionUs
            int r0 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x00e3
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r11.f34904id
            java.lang.Object r0 = r0.periodUid
            com.google.android.exoplayer2.Timeline$Period r1 = r9.period
            com.google.android.exoplayer2.Timeline$Period r0 = r8.getPeriodByUid(r0, r1)
            int r0 = r0.getAdGroupCount()
            if (r0 <= 0) goto L_0x00cf
            com.google.android.exoplayer2.Timeline$Period r0 = r9.period
            int r1 = r0.getRemovedAdGroupCount()
            boolean r0 = r0.isServerSideInsertedAdGroup(r1)
            if (r0 == 0) goto L_0x00cf
            goto L_0x00d0
        L_0x00cf:
            r14 = 0
        L_0x00d0:
            boolean r0 = r2.isAd()
            if (r0 == 0) goto L_0x00dd
            if (r14 == 0) goto L_0x00dd
            long r0 = r11.requestedContentPositionUs
            r3 = r0
            r5 = r12
            goto L_0x00e6
        L_0x00dd:
            if (r14 == 0) goto L_0x00e3
            long r0 = r11.requestedContentPositionUs
            r5 = r0
            goto L_0x00e4
        L_0x00e3:
            r5 = r12
        L_0x00e4:
            r3 = r17
        L_0x00e6:
            r0 = r19
            r1 = r20
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.getMediaPeriodInfo(r1, r2, r3, r5)
            return r0
        L_0x00ef:
            r0 = r13
            r12 = 0
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r10 = r11.f34904id
            java.lang.Object r1 = r10.periodUid
            com.google.android.exoplayer2.Timeline$Period r2 = r9.period
            r8.getPeriodByUid(r1, r2)
            boolean r1 = r10.isAd()
            if (r1 == 0) goto L_0x016b
            int r3 = r10.adGroupIndex
            com.google.android.exoplayer2.Timeline$Period r1 = r9.period
            int r1 = r1.getAdCountInAdGroup(r3)
            if (r1 != r0) goto L_0x010c
            return r17
        L_0x010c:
            com.google.android.exoplayer2.Timeline$Period r0 = r9.period
            int r2 = r10.adIndexInAdGroup
            int r4 = r0.getNextAdIndexToPlay(r3, r2)
            if (r4 >= r1) goto L_0x0126
            java.lang.Object r2 = r10.periodUid
            long r5 = r11.requestedContentPositionUs
            long r10 = r10.windowSequenceNumber
            r0 = r19
            r1 = r20
            r7 = r10
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.getMediaPeriodInfoForAd(r1, r2, r3, r4, r5, r7)
            return r0
        L_0x0126:
            long r0 = r11.requestedContentPositionUs
            int r2 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x014c
            com.google.android.exoplayer2.Timeline$Window r1 = r9.window
            com.google.android.exoplayer2.Timeline$Period r2 = r9.period
            int r3 = r2.windowIndex
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r6 = java.lang.Math.max(r12, r6)
            r0 = r20
            android.util.Pair r0 = r0.getPeriodPositionUs(r1, r2, r3, r4, r6)
            if (r0 != 0) goto L_0x0144
            return r17
        L_0x0144:
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
        L_0x014c:
            java.lang.Object r2 = r10.periodUid
            int r3 = r10.adGroupIndex
            long r2 = r9.getMinStartPositionAfterAdGroupUs(r8, r2, r3)
            java.lang.Object r4 = r10.periodUid
            long r5 = java.lang.Math.max(r2, r0)
            long r11 = r11.requestedContentPositionUs
            long r13 = r10.windowSequenceNumber
            r0 = r19
            r1 = r20
            r2 = r4
            r3 = r5
            r5 = r11
            r7 = r13
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.getMediaPeriodInfoForContent(r1, r2, r3, r5, r7)
            return r0
        L_0x016b:
            com.google.android.exoplayer2.Timeline$Period r0 = r9.period
            int r1 = r10.nextAdGroupIndex
            int r4 = r0.getFirstAdIndexToPlay(r1)
            com.google.android.exoplayer2.Timeline$Period r0 = r9.period
            int r1 = r10.nextAdGroupIndex
            boolean r0 = r0.isServerSideInsertedAdGroup(r1)
            if (r0 == 0) goto L_0x018a
            com.google.android.exoplayer2.Timeline$Period r0 = r9.period
            int r1 = r10.nextAdGroupIndex
            int r0 = r0.getAdState(r1, r4)
            r1 = 3
            if (r0 != r1) goto L_0x018a
            r12 = r14
            goto L_0x018b
        L_0x018a:
            r12 = 0
        L_0x018b:
            com.google.android.exoplayer2.Timeline$Period r0 = r9.period
            int r1 = r10.nextAdGroupIndex
            int r0 = r0.getAdCountInAdGroup(r1)
            if (r4 == r0) goto L_0x01aa
            if (r12 == 0) goto L_0x0198
            goto L_0x01aa
        L_0x0198:
            java.lang.Object r2 = r10.periodUid
            int r3 = r10.nextAdGroupIndex
            long r5 = r11.durationUs
            long r10 = r10.windowSequenceNumber
            r0 = r19
            r1 = r20
            r7 = r10
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.getMediaPeriodInfoForAd(r1, r2, r3, r4, r5, r7)
            return r0
        L_0x01aa:
            java.lang.Object r0 = r10.periodUid
            int r1 = r10.nextAdGroupIndex
            long r3 = r9.getMinStartPositionAfterAdGroupUs(r8, r0, r1)
            java.lang.Object r2 = r10.periodUid
            long r5 = r11.durationUs
            long r10 = r10.windowSequenceNumber
            r0 = r19
            r1 = r20
            r7 = r10
            com.google.android.exoplayer2.MediaPeriodInfo r0 = r0.getMediaPeriodInfoForContent(r1, r2, r3, r5, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaPeriodQueue.getFollowingMediaPeriodInfo(com.google.android.exoplayer2.Timeline, com.google.android.exoplayer2.MediaPeriodHolder, long):com.google.android.exoplayer2.MediaPeriodInfo");
    }

    @Nullable
    private MediaPeriodInfo getMediaPeriodInfo(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j11, long j12) {
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        Timeline timeline2 = timeline;
        timeline.getPeriodByUid(mediaPeriodId2.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            return getMediaPeriodInfoForAd(timeline, mediaPeriodId2.periodUid, mediaPeriodId2.adGroupIndex, mediaPeriodId2.adIndexInAdGroup, j11, mediaPeriodId2.windowSequenceNumber);
        }
        return getMediaPeriodInfoForContent(timeline, mediaPeriodId2.periodUid, j12, j11, mediaPeriodId2.windowSequenceNumber);
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(Timeline timeline, Object obj, int i11, int i12, long j11, long j12) {
        long j13;
        long j14;
        int i13 = i12;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i11, i13, j12);
        long adDurationUs = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        if (i13 == this.period.getFirstAdIndexToPlay(i11)) {
            j13 = this.period.getAdResumePositionUs();
        } else {
            j13 = 0;
        }
        boolean isServerSideInsertedAdGroup = this.period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex);
        if (adDurationUs == C.TIME_UNSET || j13 < adDurationUs) {
            j14 = j13;
        } else {
            j14 = Math.max(0, adDurationUs - 1);
        }
        return new MediaPeriodInfo(mediaPeriodId, j14, j11, C.TIME_UNSET, adDurationUs, isServerSideInsertedAdGroup, false, false, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.MediaPeriodInfo getMediaPeriodInfoForContent(com.google.android.exoplayer2.Timeline r25, java.lang.Object r26, long r27, long r29, long r31) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            com.google.android.exoplayer2.Timeline$Period r5 = r0.period
            r1.getPeriodByUid(r2, r5)
            com.google.android.exoplayer2.Timeline$Period r5 = r0.period
            int r5 = r5.getAdGroupIndexAfterPositionUs(r3)
            r6 = 1
            r7 = 0
            r8 = -1
            if (r5 != r8) goto L_0x002e
            com.google.android.exoplayer2.Timeline$Period r9 = r0.period
            int r9 = r9.getAdGroupCount()
            if (r9 <= 0) goto L_0x004d
            com.google.android.exoplayer2.Timeline$Period r9 = r0.period
            int r10 = r9.getRemovedAdGroupCount()
            boolean r9 = r9.isServerSideInsertedAdGroup(r10)
            if (r9 == 0) goto L_0x004d
            r9 = r6
            goto L_0x004e
        L_0x002e:
            com.google.android.exoplayer2.Timeline$Period r9 = r0.period
            boolean r9 = r9.isServerSideInsertedAdGroup(r5)
            if (r9 == 0) goto L_0x004d
            com.google.android.exoplayer2.Timeline$Period r9 = r0.period
            long r9 = r9.getAdGroupTimeUs(r5)
            com.google.android.exoplayer2.Timeline$Period r11 = r0.period
            long r12 = r11.durationUs
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L_0x004d
            boolean r9 = r11.hasPlayedAdGroup(r5)
            if (r9 == 0) goto L_0x004d
            r9 = r6
            r5 = r8
            goto L_0x004e
        L_0x004d:
            r9 = r7
        L_0x004e:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r11 = new com.google.android.exoplayer2.source.MediaSource$MediaPeriodId
            r12 = r31
            r11.<init>(r2, r12, r5)
            boolean r2 = r0.isLastInPeriod(r11)
            boolean r22 = r0.isLastInWindow(r1, r11)
            boolean r23 = r0.isLastInTimeline(r1, r11, r2)
            if (r5 == r8) goto L_0x006e
            com.google.android.exoplayer2.Timeline$Period r1 = r0.period
            boolean r1 = r1.isServerSideInsertedAdGroup(r5)
            if (r1 == 0) goto L_0x006e
            r20 = r6
            goto L_0x0070
        L_0x006e:
            r20 = r7
        L_0x0070:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == r8) goto L_0x0080
            com.google.android.exoplayer2.Timeline$Period r1 = r0.period
            long r14 = r1.getAdGroupTimeUs(r5)
        L_0x007d:
            r16 = r14
            goto L_0x0089
        L_0x0080:
            if (r9 == 0) goto L_0x0087
            com.google.android.exoplayer2.Timeline$Period r1 = r0.period
            long r14 = r1.durationUs
            goto L_0x007d
        L_0x0087:
            r16 = r12
        L_0x0089:
            int r1 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x0097
            r14 = -9223372036854775808
            int r1 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r1 != 0) goto L_0x0094
            goto L_0x0097
        L_0x0094:
            r18 = r16
            goto L_0x009d
        L_0x0097:
            com.google.android.exoplayer2.Timeline$Period r1 = r0.period
            long r14 = r1.durationUs
            r18 = r14
        L_0x009d:
            int r1 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x00b4
            int r1 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r1 < 0) goto L_0x00b4
            if (r23 != 0) goto L_0x00ab
            if (r9 != 0) goto L_0x00aa
            goto L_0x00ab
        L_0x00aa:
            r6 = r7
        L_0x00ab:
            long r3 = (long) r6
            long r3 = r18 - r3
            r5 = 0
            long r3 = java.lang.Math.max(r5, r3)
        L_0x00b4:
            r12 = r3
            com.google.android.exoplayer2.MediaPeriodInfo r1 = new com.google.android.exoplayer2.MediaPeriodInfo
            r10 = r1
            r14 = r29
            r21 = r2
            r10.<init>(r11, r12, r14, r16, r18, r20, r21, r22, r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaPeriodQueue.getMediaPeriodInfoForContent(com.google.android.exoplayer2.Timeline, java.lang.Object, long, long, long):com.google.android.exoplayer2.MediaPeriodInfo");
    }

    private long getMinStartPositionAfterAdGroupUs(Timeline timeline, Object obj, int i11) {
        timeline.getPeriodByUid(obj, this.period);
        long adGroupTimeUs = this.period.getAdGroupTimeUs(i11);
        if (adGroupTimeUs == Long.MIN_VALUE) {
            return this.period.durationUs;
        }
        return adGroupTimeUs + this.period.getContentResumeOffsetUs(i11);
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.isAd() && mediaPeriodId.nextAdGroupIndex == -1;
    }

    private boolean isLastInTimeline(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z11) {
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        if (!timeline.getWindow(timeline.getPeriod(indexOfPeriod, this.period).windowIndex, this.window).isDynamic) {
            if (!timeline.isLastPeriod(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) || !z11) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean isLastInWindow(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (!isLastInPeriod(mediaPeriodId)) {
            return false;
        }
        int i11 = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex;
        if (timeline.getWindow(i11, this.window).lastPeriodIndex == timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyQueueUpdate$0(ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.analyticsCollector.updateMediaPeriodQueueInfo(builder.build(), mediaPeriodId);
    }

    private void notifyQueueUpdate() {
        MediaSource.MediaPeriodId mediaPeriodId;
        ImmutableList.Builder builder = ImmutableList.builder();
        for (MediaPeriodHolder mediaPeriodHolder = this.playing; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.getNext()) {
            builder.add((Object) mediaPeriodHolder.info.f34904id);
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.reading;
        if (mediaPeriodHolder2 == null) {
            mediaPeriodId = null;
        } else {
            mediaPeriodId = mediaPeriodHolder2.info.f34904id;
        }
        this.analyticsCollectorHandler.post(new o0(this, builder, mediaPeriodId));
    }

    private long resolvePeriodIndexToWindowSequenceNumber(Timeline timeline, Object obj) {
        int indexOfPeriod;
        int i11 = timeline.getPeriodByUid(obj, this.period).windowIndex;
        Object obj2 = this.oldFrontPeriodUid;
        if (obj2 != null && (indexOfPeriod = timeline.getIndexOfPeriod(obj2)) != -1 && timeline.getPeriod(indexOfPeriod, this.period).windowIndex == i11) {
            return this.oldFrontPeriodWindowSequenceNumber;
        }
        for (MediaPeriodHolder mediaPeriodHolder = this.playing; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.getNext()) {
            if (mediaPeriodHolder.uid.equals(obj)) {
                return mediaPeriodHolder.info.f34904id.windowSequenceNumber;
            }
        }
        for (MediaPeriodHolder mediaPeriodHolder2 = this.playing; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.getNext()) {
            int indexOfPeriod2 = timeline.getIndexOfPeriod(mediaPeriodHolder2.uid);
            if (indexOfPeriod2 != -1 && timeline.getPeriod(indexOfPeriod2, this.period).windowIndex == i11) {
                return mediaPeriodHolder2.info.f34904id.windowSequenceNumber;
            }
        }
        long j11 = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = 1 + j11;
        if (this.playing == null) {
            this.oldFrontPeriodUid = obj;
            this.oldFrontPeriodWindowSequenceNumber = j11;
        }
        return j11;
    }

    private boolean updateForPlaybackModeChange(Timeline timeline) {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder == null) {
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodHolder.uid);
        while (true) {
            indexOfPeriod = timeline.getNextPeriodIndex(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while (mediaPeriodHolder.getNext() != null && !mediaPeriodHolder.info.isLastInTimelinePeriod) {
                mediaPeriodHolder = mediaPeriodHolder.getNext();
            }
            MediaPeriodHolder next = mediaPeriodHolder.getNext();
            if (indexOfPeriod == -1 || next == null || timeline.getIndexOfPeriod(next.uid) != indexOfPeriod) {
                boolean removeAfter = removeAfter(mediaPeriodHolder);
                mediaPeriodHolder.info = getUpdatedMediaPeriodInfo(timeline, mediaPeriodHolder.info);
            } else {
                mediaPeriodHolder = next;
            }
        }
        boolean removeAfter2 = removeAfter(mediaPeriodHolder);
        mediaPeriodHolder.info = getUpdatedMediaPeriodInfo(timeline, mediaPeriodHolder.info);
        return !removeAfter2;
    }

    @Nullable
    public MediaPeriodHolder advancePlayingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.reading) {
            this.reading = mediaPeriodHolder.getNext();
        }
        this.playing.release();
        int i11 = this.length - 1;
        this.length = i11;
        if (i11 == 0) {
            this.loading = null;
            MediaPeriodHolder mediaPeriodHolder2 = this.playing;
            this.oldFrontPeriodUid = mediaPeriodHolder2.uid;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder2.info.f34904id.windowSequenceNumber;
        }
        this.playing = this.playing.getNext();
        notifyQueueUpdate();
        return this.playing;
    }

    public MediaPeriodHolder advanceReadingPeriod() {
        boolean z11;
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        if (mediaPeriodHolder == null || mediaPeriodHolder.getNext() == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        Assertions.checkState(z11);
        this.reading = this.reading.getNext();
        notifyQueueUpdate();
        return this.reading;
    }

    public void clear() {
        if (this.length != 0) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkStateNotNull(this.playing);
            this.oldFrontPeriodUid = mediaPeriodHolder.uid;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder.info.f34904id.windowSequenceNumber;
            while (mediaPeriodHolder != null) {
                mediaPeriodHolder.release();
                mediaPeriodHolder = mediaPeriodHolder.getNext();
            }
            this.playing = null;
            this.loading = null;
            this.reading = null;
            this.length = 0;
            notifyQueueUpdate();
        }
    }

    public MediaPeriodHolder enqueueNextMediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        long j11;
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            j11 = INITIAL_RENDERER_POSITION_OFFSET_US;
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodInfo;
        } else {
            j11 = (mediaPeriodHolder.getRendererOffset() + this.loading.info.durationUs) - mediaPeriodInfo.startPositionUs;
        }
        MediaPeriodHolder mediaPeriodHolder2 = new MediaPeriodHolder(rendererCapabilitiesArr, j11, trackSelector, allocator, mediaSourceList, mediaPeriodInfo, trackSelectorResult);
        MediaPeriodHolder mediaPeriodHolder3 = this.loading;
        if (mediaPeriodHolder3 != null) {
            mediaPeriodHolder3.setNext(mediaPeriodHolder2);
        } else {
            this.playing = mediaPeriodHolder2;
            this.reading = mediaPeriodHolder2;
        }
        this.oldFrontPeriodUid = null;
        this.loading = mediaPeriodHolder2;
        this.length++;
        notifyQueueUpdate();
        return mediaPeriodHolder2;
    }

    @Nullable
    public MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    @Nullable
    public MediaPeriodInfo getNextMediaPeriodInfo(long j11, PlaybackInfo playbackInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            return getFirstMediaPeriodInfo(playbackInfo);
        }
        return getFollowingMediaPeriodInfo(playbackInfo.timeline, mediaPeriodHolder, j11);
    }

    @Nullable
    public MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    @Nullable
    public MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.MediaPeriodInfo getUpdatedMediaPeriodInfo(com.google.android.exoplayer2.Timeline r19, com.google.android.exoplayer2.MediaPeriodInfo r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r2.f34904id
            boolean r12 = r0.isLastInPeriod(r3)
            boolean r13 = r0.isLastInWindow(r1, r3)
            boolean r14 = r0.isLastInTimeline(r1, r3, r12)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r4 = r2.f34904id
            java.lang.Object r4 = r4.periodUid
            com.google.android.exoplayer2.Timeline$Period r5 = r0.period
            r1.getPeriodByUid(r4, r5)
            boolean r1 = r3.isAd()
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0035
            int r1 = r3.nextAdGroupIndex
            if (r1 != r4) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            com.google.android.exoplayer2.Timeline$Period r7 = r0.period
            long r7 = r7.getAdGroupTimeUs(r1)
            goto L_0x0036
        L_0x0035:
            r7 = r5
        L_0x0036:
            boolean r1 = r3.isAd()
            if (r1 == 0) goto L_0x0048
            com.google.android.exoplayer2.Timeline$Period r1 = r0.period
            int r5 = r3.adGroupIndex
            int r6 = r3.adIndexInAdGroup
            long r5 = r1.getAdDurationUs(r5, r6)
        L_0x0046:
            r9 = r5
            goto L_0x005c
        L_0x0048:
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0055
            r5 = -9223372036854775808
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r9 = r7
            goto L_0x005c
        L_0x0055:
            com.google.android.exoplayer2.Timeline$Period r1 = r0.period
            long r5 = r1.getDurationUs()
            goto L_0x0046
        L_0x005c:
            boolean r1 = r3.isAd()
            if (r1 == 0) goto L_0x006c
            com.google.android.exoplayer2.Timeline$Period r1 = r0.period
            int r4 = r3.adGroupIndex
            boolean r1 = r1.isServerSideInsertedAdGroup(r4)
        L_0x006a:
            r11 = r1
            goto L_0x007c
        L_0x006c:
            int r1 = r3.nextAdGroupIndex
            if (r1 == r4) goto L_0x007a
            com.google.android.exoplayer2.Timeline$Period r4 = r0.period
            boolean r1 = r4.isServerSideInsertedAdGroup(r1)
            if (r1 == 0) goto L_0x007a
            r1 = 1
            goto L_0x006a
        L_0x007a:
            r1 = 0
            goto L_0x006a
        L_0x007c:
            com.google.android.exoplayer2.MediaPeriodInfo r15 = new com.google.android.exoplayer2.MediaPeriodInfo
            long r4 = r2.startPositionUs
            long r1 = r2.requestedContentPositionUs
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaPeriodQueue.getUpdatedMediaPeriodInfo(com.google.android.exoplayer2.Timeline, com.google.android.exoplayer2.MediaPeriodInfo):com.google.android.exoplayer2.MediaPeriodInfo");
    }

    public boolean isLoading(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod == mediaPeriod;
    }

    public void reevaluateBuffer(long j11) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.reevaluateBuffer(j11);
        }
    }

    public boolean removeAfter(MediaPeriodHolder mediaPeriodHolder) {
        boolean z11;
        boolean z12 = false;
        if (mediaPeriodHolder != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        if (mediaPeriodHolder.equals(this.loading)) {
            return false;
        }
        this.loading = mediaPeriodHolder;
        while (mediaPeriodHolder.getNext() != null) {
            mediaPeriodHolder = mediaPeriodHolder.getNext();
            if (mediaPeriodHolder == this.reading) {
                this.reading = this.playing;
                z12 = true;
            }
            mediaPeriodHolder.release();
            this.length--;
        }
        this.loading.setNext((MediaPeriodHolder) null);
        notifyQueueUpdate();
        return z12;
    }

    public MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object obj, long j11) {
        return resolveMediaPeriodIdForAds(timeline, obj, j11, resolvePeriodIndexToWindowSequenceNumber(timeline, obj), this.window, this.period);
    }

    public MediaSource.MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange(Timeline timeline, Object obj, long j11) {
        long resolvePeriodIndexToWindowSequenceNumber = resolvePeriodIndexToWindowSequenceNumber(timeline, obj);
        timeline.getPeriodByUid(obj, this.period);
        timeline.getWindow(this.period.windowIndex, this.window);
        boolean z11 = false;
        for (int indexOfPeriod = timeline.getIndexOfPeriod(obj); indexOfPeriod >= this.window.firstPeriodIndex; indexOfPeriod--) {
            boolean z12 = true;
            timeline.getPeriod(indexOfPeriod, this.period, true);
            if (this.period.getAdGroupCount() <= 0) {
                z12 = false;
            }
            z11 |= z12;
            Timeline.Period period2 = this.period;
            if (period2.getAdGroupIndexForPositionUs(period2.durationUs) != -1) {
                obj = Assertions.checkNotNull(this.period.uid);
            }
            if (z11 && (!z12 || this.period.durationUs != 0)) {
                break;
            }
        }
        return resolveMediaPeriodIdForAds(timeline, obj, j11, resolvePeriodIndexToWindowSequenceNumber, this.window, this.period);
    }

    public boolean shouldLoadNextMediaPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null || (!mediaPeriodHolder.info.isFinal && mediaPeriodHolder.isFullyBuffered() && this.loading.info.durationUs != C.TIME_UNSET && this.length < 100)) {
            return true;
        }
        return false;
    }

    public boolean updateQueuedPeriods(Timeline timeline, long j11, long j12) {
        MediaPeriodInfo mediaPeriodInfo;
        long j13;
        boolean z11;
        MediaPeriodHolder mediaPeriodHolder = null;
        for (MediaPeriodHolder mediaPeriodHolder2 = this.playing; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.getNext()) {
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder2.info;
            if (mediaPeriodHolder == null) {
                mediaPeriodInfo = getUpdatedMediaPeriodInfo(timeline, mediaPeriodInfo2);
            } else {
                MediaPeriodInfo followingMediaPeriodInfo = getFollowingMediaPeriodInfo(timeline, mediaPeriodHolder, j11);
                if (followingMediaPeriodInfo == null) {
                    return !removeAfter(mediaPeriodHolder);
                }
                if (!canKeepMediaPeriodHolder(mediaPeriodInfo2, followingMediaPeriodInfo)) {
                    return !removeAfter(mediaPeriodHolder);
                }
                mediaPeriodInfo = followingMediaPeriodInfo;
            }
            mediaPeriodHolder2.info = mediaPeriodInfo.copyWithRequestedContentPositionUs(mediaPeriodInfo2.requestedContentPositionUs);
            if (!areDurationsCompatible(mediaPeriodInfo2.durationUs, mediaPeriodInfo.durationUs)) {
                mediaPeriodHolder2.updateClipping();
                long j14 = mediaPeriodInfo.durationUs;
                if (j14 == C.TIME_UNSET) {
                    j13 = Long.MAX_VALUE;
                } else {
                    j13 = mediaPeriodHolder2.toRendererTime(j14);
                }
                if (mediaPeriodHolder2 != this.reading || mediaPeriodHolder2.info.isFollowedByTransitionToSameStream || (j12 != Long.MIN_VALUE && j12 < j13)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (removeAfter(mediaPeriodHolder2) || z11) {
                    return false;
                }
                return true;
            }
            mediaPeriodHolder = mediaPeriodHolder2;
        }
        return true;
    }

    public boolean updateRepeatMode(Timeline timeline, int i11) {
        this.repeatMode = i11;
        return updateForPlaybackModeChange(timeline);
    }

    public boolean updateShuffleModeEnabled(Timeline timeline, boolean z11) {
        this.shuffleModeEnabled = z11;
        return updateForPlaybackModeChange(timeline);
    }

    private static MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object obj, long j11, long j12, Timeline.Window window2, Timeline.Period period2) {
        timeline.getPeriodByUid(obj, period2);
        timeline.getWindow(period2.windowIndex, window2);
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        Object obj2 = obj;
        while (period2.durationUs == 0 && period2.getAdGroupCount() > 0 && period2.isServerSideInsertedAdGroup(period2.getRemovedAdGroupCount()) && period2.getAdGroupIndexForPositionUs(0) == -1) {
            int i11 = indexOfPeriod + 1;
            if (indexOfPeriod >= window2.lastPeriodIndex) {
                break;
            }
            timeline.getPeriod(i11, period2, true);
            obj2 = Assertions.checkNotNull(period2.uid);
            indexOfPeriod = i11;
        }
        timeline.getPeriodByUid(obj2, period2);
        int adGroupIndexForPositionUs = period2.getAdGroupIndexForPositionUs(j11);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(obj2, j12, period2.getAdGroupIndexAfterPositionUs(j11));
        }
        return new MediaSource.MediaPeriodId(obj2, adGroupIndexForPositionUs, period2.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j12);
    }
}
