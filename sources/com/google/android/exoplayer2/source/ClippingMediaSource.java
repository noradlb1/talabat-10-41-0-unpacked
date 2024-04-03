package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

public final class ClippingMediaSource extends WrappingMediaSource {
    private final boolean allowDynamicClippingUpdates;
    @Nullable
    private IllegalClippingException clippingError;
    @Nullable
    private ClippingTimeline clippingTimeline;
    private final boolean enableInitialDiscontinuity;
    private final long endUs;
    private final ArrayList<ClippingMediaPeriod> mediaPeriods;
    private long periodEndUs;
    private long periodStartUs;
    private final boolean relativeToDefaultPosition;
    private final long startUs;
    private final Timeline.Window window;

    public static final class ClippingTimeline extends ForwardingTimeline {
        private final long durationUs;
        private final long endUs;
        private final boolean isDynamic;
        private final long startUs;

        public ClippingTimeline(Timeline timeline, long j11, long j12) throws IllegalClippingException {
            super(timeline);
            long j13;
            long j14;
            boolean z11 = false;
            if (timeline.getPeriodCount() == 1) {
                Timeline.Window window = timeline.getWindow(0, new Timeline.Window());
                long max = Math.max(0, j11);
                if (window.isPlaceholder || max == 0 || window.isSeekable) {
                    if (j12 == Long.MIN_VALUE) {
                        j13 = window.durationUs;
                    } else {
                        j13 = Math.max(0, j12);
                    }
                    long j15 = window.durationUs;
                    if (j15 != C.TIME_UNSET) {
                        j13 = j13 > j15 ? j15 : j13;
                        if (max > j13) {
                            throw new IllegalClippingException(2);
                        }
                    }
                    this.startUs = max;
                    this.endUs = j13;
                    int i11 = (j13 > C.TIME_UNSET ? 1 : (j13 == C.TIME_UNSET ? 0 : -1));
                    if (i11 == 0) {
                        j14 = -9223372036854775807L;
                    } else {
                        j14 = j13 - max;
                    }
                    this.durationUs = j14;
                    if (window.isDynamic && (i11 == 0 || (j15 != C.TIME_UNSET && j13 == j15))) {
                        z11 = true;
                    }
                    this.isDynamic = z11;
                    return;
                }
                throw new IllegalClippingException(1);
            }
            throw new IllegalClippingException(0);
        }

        public Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
            long j11;
            this.timeline.getPeriod(0, period, z11);
            long positionInWindowUs = period.getPositionInWindowUs() - this.startUs;
            long j12 = this.durationUs;
            if (j12 == C.TIME_UNSET) {
                j11 = -9223372036854775807L;
            } else {
                j11 = j12 - positionInWindowUs;
            }
            return period.set(period.f34906id, period.uid, 0, j11, positionInWindowUs);
        }

        public Timeline.Window getWindow(int i11, Timeline.Window window, long j11) {
            this.timeline.getWindow(0, window, 0);
            long j12 = window.positionInFirstPeriodUs;
            long j13 = this.startUs;
            window.positionInFirstPeriodUs = j12 + j13;
            window.durationUs = this.durationUs;
            window.isDynamic = this.isDynamic;
            long j14 = window.defaultPositionUs;
            if (j14 != C.TIME_UNSET) {
                long max = Math.max(j14, j13);
                window.defaultPositionUs = max;
                long j15 = this.endUs;
                if (j15 != C.TIME_UNSET) {
                    max = Math.min(max, j15);
                }
                window.defaultPositionUs = max - this.startUs;
            }
            long usToMs = Util.usToMs(this.startUs);
            long j16 = window.presentationStartTimeMs;
            if (j16 != C.TIME_UNSET) {
                window.presentationStartTimeMs = j16 + usToMs;
            }
            long j17 = window.windowStartTimeMs;
            if (j17 != C.TIME_UNSET) {
                window.windowStartTimeMs = j17 + usToMs;
            }
            return window;
        }
    }

    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalClippingException(int i11) {
            super("Illegal clipping: " + getReasonDescription(i11));
            this.reason = i11;
        }

        private static String getReasonDescription(int i11) {
            return i11 != 0 ? i11 != 1 ? i11 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j11, long j12) {
        this(mediaSource, j11, j12, true, false, false);
    }

    private void refreshClippedTimeline(Timeline timeline) {
        long j11;
        timeline.getWindow(0, this.window);
        long positionInFirstPeriodUs = this.window.getPositionInFirstPeriodUs();
        long j12 = Long.MIN_VALUE;
        if (this.clippingTimeline == null || this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            long j13 = this.startUs;
            long j14 = this.endUs;
            if (this.relativeToDefaultPosition) {
                long defaultPositionUs = this.window.getDefaultPositionUs();
                j13 += defaultPositionUs;
                j14 += defaultPositionUs;
            }
            this.periodStartUs = positionInFirstPeriodUs + j13;
            if (this.endUs != Long.MIN_VALUE) {
                j12 = positionInFirstPeriodUs + j14;
            }
            this.periodEndUs = j12;
            int size = this.mediaPeriods.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mediaPeriods.get(i11).updateClipping(this.periodStartUs, this.periodEndUs);
            }
            j11 = j13;
            j12 = j14;
        } else {
            long j15 = this.periodStartUs - positionInFirstPeriodUs;
            if (this.endUs != Long.MIN_VALUE) {
                j12 = this.periodEndUs - positionInFirstPeriodUs;
            }
            j11 = j15;
        }
        try {
            ClippingTimeline clippingTimeline2 = new ClippingTimeline(timeline, j11, j12);
            this.clippingTimeline = clippingTimeline2;
            refreshSourceInfo(clippingTimeline2);
        } catch (IllegalClippingException e11) {
            this.clippingError = e11;
            for (int i12 = 0; i12 < this.mediaPeriods.size(); i12++) {
                this.mediaPeriods.get(i12).setClippingError(this.clippingError);
            }
        }
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.mediaSource.createPeriod(mediaPeriodId, allocator, j11), this.enableInitialDiscontinuity, this.periodStartUs, this.periodEndUs);
        this.mediaPeriods.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw illegalClippingException;
    }

    public void onChildSourceInfoRefreshed(Timeline timeline) {
        if (this.clippingError == null) {
            refreshClippedTimeline(timeline);
        }
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        Assertions.checkState(this.mediaPeriods.remove(mediaPeriod));
        this.mediaSource.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        if (this.mediaPeriods.isEmpty() && !this.allowDynamicClippingUpdates) {
            refreshClippedTimeline(((ClippingTimeline) Assertions.checkNotNull(this.clippingTimeline)).timeline);
        }
    }

    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.clippingError = null;
        this.clippingTimeline = null;
    }

    public ClippingMediaSource(MediaSource mediaSource, long j11) {
        this(mediaSource, 0, j11, true, false, true);
    }

    public ClippingMediaSource(MediaSource mediaSource, long j11, long j12, boolean z11, boolean z12, boolean z13) {
        super((MediaSource) Assertions.checkNotNull(mediaSource));
        Assertions.checkArgument(j11 >= 0);
        this.startUs = j11;
        this.endUs = j12;
        this.enableInitialDiscontinuity = z11;
        this.allowDynamicClippingUpdates = z12;
        this.relativeToDefaultPosition = z13;
        this.mediaPeriods = new ArrayList<>();
        this.window = new Timeline.Window();
    }
}
