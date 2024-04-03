package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class MediaPeriodInfo {
    public final long durationUs;
    public final long endPositionUs;

    /* renamed from: id  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f34904id;
    public final boolean isFinal;
    public final boolean isFollowedByTransitionToSameStream;
    public final boolean isLastInTimelinePeriod;
    public final boolean isLastInTimelineWindow;
    public final long requestedContentPositionUs;
    public final long startPositionUs;

    public MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15;
        boolean z16;
        boolean z17 = z11;
        boolean z18 = z12;
        boolean z19 = z13;
        boolean z21 = z14;
        boolean z22 = false;
        if (!z21 || z18) {
            z15 = true;
        } else {
            z15 = false;
        }
        Assertions.checkArgument(z15);
        if (!z19 || z18) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        if (!z17 || (!z18 && !z19 && !z21)) {
            z22 = true;
        }
        Assertions.checkArgument(z22);
        this.f34904id = mediaPeriodId;
        this.startPositionUs = j11;
        this.requestedContentPositionUs = j12;
        this.endPositionUs = j13;
        this.durationUs = j14;
        this.isFollowedByTransitionToSameStream = z17;
        this.isLastInTimelinePeriod = z18;
        this.isLastInTimelineWindow = z19;
        this.isFinal = z21;
    }

    public MediaPeriodInfo copyWithRequestedContentPositionUs(long j11) {
        if (j11 == this.requestedContentPositionUs) {
            return this;
        }
        return new MediaPeriodInfo(this.f34904id, this.startPositionUs, j11, this.endPositionUs, this.durationUs, this.isFollowedByTransitionToSameStream, this.isLastInTimelinePeriod, this.isLastInTimelineWindow, this.isFinal);
    }

    public MediaPeriodInfo copyWithStartPositionUs(long j11) {
        if (j11 == this.startPositionUs) {
            return this;
        }
        return new MediaPeriodInfo(this.f34904id, j11, this.requestedContentPositionUs, this.endPositionUs, this.durationUs, this.isFollowedByTransitionToSameStream, this.isLastInTimelinePeriod, this.isLastInTimelineWindow, this.isFinal);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaPeriodInfo.class != obj.getClass()) {
            return false;
        }
        MediaPeriodInfo mediaPeriodInfo = (MediaPeriodInfo) obj;
        if (this.startPositionUs == mediaPeriodInfo.startPositionUs && this.requestedContentPositionUs == mediaPeriodInfo.requestedContentPositionUs && this.endPositionUs == mediaPeriodInfo.endPositionUs && this.durationUs == mediaPeriodInfo.durationUs && this.isFollowedByTransitionToSameStream == mediaPeriodInfo.isFollowedByTransitionToSameStream && this.isLastInTimelinePeriod == mediaPeriodInfo.isLastInTimelinePeriod && this.isLastInTimelineWindow == mediaPeriodInfo.isLastInTimelineWindow && this.isFinal == mediaPeriodInfo.isFinal && Util.areEqual(this.f34904id, mediaPeriodInfo.f34904id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f34904id.hashCode()) * 31) + ((int) this.startPositionUs)) * 31) + ((int) this.requestedContentPositionUs)) * 31) + ((int) this.endPositionUs)) * 31) + ((int) this.durationUs)) * 31) + (this.isFollowedByTransitionToSameStream ? 1 : 0)) * 31) + (this.isLastInTimelinePeriod ? 1 : 0)) * 31) + (this.isLastInTimelineWindow ? 1 : 0)) * 31) + (this.isFinal ? 1 : 0);
    }
}
