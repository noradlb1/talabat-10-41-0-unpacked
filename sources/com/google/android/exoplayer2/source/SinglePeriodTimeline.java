package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodTimeline extends Timeline {
    private static final MediaItem MEDIA_ITEM = new MediaItem.Builder().setMediaId("SinglePeriodTimeline").setUri(Uri.EMPTY).build();
    private static final Object UID = new Object();
    private final long elapsedRealtimeEpochOffsetMs;
    private final boolean isDynamic;
    private final boolean isSeekable;
    @Nullable
    private final MediaItem.LiveConfiguration liveConfiguration;
    @Nullable
    private final Object manifest;
    @Nullable
    private final MediaItem mediaItem;
    private final long periodDurationUs;
    private final long presentationStartTimeMs;
    private final boolean suppressPositionProjection;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;
    private final long windowStartTimeMs;

    @Deprecated
    public SinglePeriodTimeline(long j11, boolean z11, boolean z12, boolean z13, @Nullable Object obj, @Nullable Object obj2) {
        this(j11, j11, 0, 0, z11, z12, z13, obj, obj2);
    }

    public int getIndexOfPeriod(Object obj) {
        return UID.equals(obj) ? 0 : -1;
    }

    public Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
        Object obj;
        Assertions.checkIndex(i11, 0, 1);
        if (z11) {
            obj = UID;
        } else {
            obj = null;
        }
        return period.set((Object) null, obj, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    public int getPeriodCount() {
        return 1;
    }

    public Object getUidOfPeriod(int i11) {
        Assertions.checkIndex(i11, 0, 1);
        return UID;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r1 > r3) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.Timeline.Window getWindow(int r25, com.google.android.exoplayer2.Timeline.Window r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            com.google.android.exoplayer2.util.Assertions.checkIndex(r3, r1, r2)
            long r1 = r0.windowDefaultStartPositionUs
            boolean r14 = r0.isDynamic
            if (r14 == 0) goto L_0x002e
            boolean r3 = r0.suppressPositionProjection
            if (r3 != 0) goto L_0x002e
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x002e
            long r3 = r0.windowDurationUs
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0027
        L_0x0024:
            r16 = r5
            goto L_0x0030
        L_0x0027:
            long r1 = r1 + r27
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x002e
            goto L_0x0024
        L_0x002e:
            r16 = r1
        L_0x0030:
            java.lang.Object r4 = com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID
            com.google.android.exoplayer2.MediaItem r5 = r0.mediaItem
            java.lang.Object r6 = r0.manifest
            long r7 = r0.presentationStartTimeMs
            long r9 = r0.windowStartTimeMs
            long r11 = r0.elapsedRealtimeEpochOffsetMs
            boolean r13 = r0.isSeekable
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r15 = r0.liveConfiguration
            long r1 = r0.windowDurationUs
            r18 = r1
            r20 = 0
            r21 = 0
            long r1 = r0.windowPositionInPeriodUs
            r22 = r1
            r3 = r26
            com.google.android.exoplayer2.Timeline$Window r1 = r3.set(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SinglePeriodTimeline.getWindow(int, com.google.android.exoplayer2.Timeline$Window, long):com.google.android.exoplayer2.Timeline$Window");
    }

    public int getWindowCount() {
        return 1;
    }

    public SinglePeriodTimeline(long j11, boolean z11, boolean z12, boolean z13, @Nullable Object obj, MediaItem mediaItem2) {
        this(j11, j11, 0, 0, z11, z12, z13, obj, mediaItem2);
    }

    @Deprecated
    public SinglePeriodTimeline(long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13, @Nullable Object obj, @Nullable Object obj2) {
        this((long) C.TIME_UNSET, (long) C.TIME_UNSET, (long) C.TIME_UNSET, j11, j12, j13, j14, z11, z12, z13, obj, obj2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SinglePeriodTimeline(long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13, @Nullable Object obj, MediaItem mediaItem2) {
        this(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j11, j12, j13, j14, z11, z12, false, obj, mediaItem2, z13 ? mediaItem2.liveConfiguration : null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SinglePeriodTimeline(long r22, long r24, long r26, long r28, long r30, long r32, long r34, boolean r36, boolean r37, boolean r38, @androidx.annotation.Nullable java.lang.Object r39, @androidx.annotation.Nullable java.lang.Object r40) {
        /*
            r21 = this;
            r17 = 0
            com.google.android.exoplayer2.MediaItem r0 = MEDIA_ITEM
            com.google.android.exoplayer2.MediaItem$Builder r1 = r0.buildUpon()
            r2 = r40
            com.google.android.exoplayer2.MediaItem$Builder r1 = r1.setTag(r2)
            com.google.android.exoplayer2.MediaItem r19 = r1.build()
            if (r38 == 0) goto L_0x0017
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r0 = r0.liveConfiguration
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            r20 = r0
            r0 = r21
            r1 = r22
            r3 = r24
            r5 = r26
            r7 = r28
            r9 = r30
            r11 = r32
            r13 = r34
            r15 = r36
            r16 = r37
            r18 = r39
            r0.<init>(r1, r3, r5, r7, r9, r11, r13, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SinglePeriodTimeline.<init>(long, long, long, long, long, long, long, boolean, boolean, boolean, java.lang.Object, java.lang.Object):void");
    }

    @Deprecated
    public SinglePeriodTimeline(long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z11, boolean z12, @Nullable Object obj, MediaItem mediaItem2, @Nullable MediaItem.LiveConfiguration liveConfiguration2) {
        this(j11, j12, j13, j14, j15, j16, j17, z11, z12, false, obj, mediaItem2, liveConfiguration2);
    }

    public SinglePeriodTimeline(long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z11, boolean z12, boolean z13, @Nullable Object obj, MediaItem mediaItem2, @Nullable MediaItem.LiveConfiguration liveConfiguration2) {
        this.presentationStartTimeMs = j11;
        this.windowStartTimeMs = j12;
        this.elapsedRealtimeEpochOffsetMs = j13;
        this.periodDurationUs = j14;
        this.windowDurationUs = j15;
        this.windowPositionInPeriodUs = j16;
        this.windowDefaultStartPositionUs = j17;
        this.isSeekable = z11;
        this.isDynamic = z12;
        this.suppressPositionProjection = z13;
        this.manifest = obj;
        this.mediaItem = (MediaItem) Assertions.checkNotNull(mediaItem2);
        this.liveConfiguration = liveConfiguration2;
    }
}
