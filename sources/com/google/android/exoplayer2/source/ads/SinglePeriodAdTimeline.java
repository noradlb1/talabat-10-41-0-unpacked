package com.google.android.exoplayer2.source.ads;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;

@VisibleForTesting(otherwise = 3)
public final class SinglePeriodAdTimeline extends ForwardingTimeline {
    private final AdPlaybackState adPlaybackState;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState2) {
        super(timeline);
        boolean z11;
        boolean z12 = false;
        if (timeline.getPeriodCount() == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        Assertions.checkState(timeline.getWindowCount() == 1 ? true : z12);
        this.adPlaybackState = adPlaybackState2;
    }

    public Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
        this.timeline.getPeriod(i11, period, z11);
        long j11 = period.durationUs;
        if (j11 == C.TIME_UNSET) {
            j11 = this.adPlaybackState.contentDurationUs;
        }
        Timeline.Period period2 = period;
        period2.set(period.f34906id, period.uid, period.windowIndex, j11, period.getPositionInWindowUs(), this.adPlaybackState, period.isPlaceholder);
        return period;
    }
}
