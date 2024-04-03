package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public final class LoopingMediaSource extends WrappingMediaSource {
    private final Map<MediaSource.MediaPeriodId, MediaSource.MediaPeriodId> childMediaPeriodIdToMediaPeriodId;
    private final int loopCount;
    private final Map<MediaPeriod, MediaSource.MediaPeriodId> mediaPeriodToChildMediaPeriodId;

    public static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        public InfinitelyLoopingTimeline(Timeline timeline) {
            super(timeline);
        }

        public int getNextWindowIndex(int i11, int i12, boolean z11) {
            int nextWindowIndex = this.timeline.getNextWindowIndex(i11, i12, z11);
            if (nextWindowIndex == -1) {
                return getFirstWindowIndex(z11);
            }
            return nextWindowIndex;
        }

        public int getPreviousWindowIndex(int i11, int i12, boolean z11) {
            int previousWindowIndex = this.timeline.getPreviousWindowIndex(i11, i12, z11);
            if (previousWindowIndex == -1) {
                return getLastWindowIndex(z11);
            }
            return previousWindowIndex;
        }
    }

    public static final class LoopingTimeline extends AbstractConcatenatedTimeline {
        private final int childPeriodCount;
        private final Timeline childTimeline;
        private final int childWindowCount;
        private final int loopCount;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoopingTimeline(Timeline timeline, int i11) {
            super(false, new ShuffleOrder.UnshuffledShuffleOrder(i11));
            boolean z11 = false;
            this.childTimeline = timeline;
            int periodCount = timeline.getPeriodCount();
            this.childPeriodCount = periodCount;
            this.childWindowCount = timeline.getWindowCount();
            this.loopCount = i11;
            if (periodCount > 0) {
                Assertions.checkState(i11 <= Integer.MAX_VALUE / periodCount ? true : z11, "LoopingMediaSource contains too many periods");
            }
        }

        public int getChildIndexByChildUid(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }

        public int getChildIndexByPeriodIndex(int i11) {
            return i11 / this.childPeriodCount;
        }

        public int getChildIndexByWindowIndex(int i11) {
            return i11 / this.childWindowCount;
        }

        public Object getChildUidByChildIndex(int i11) {
            return Integer.valueOf(i11);
        }

        public int getFirstPeriodIndexByChildIndex(int i11) {
            return i11 * this.childPeriodCount;
        }

        public int getFirstWindowIndexByChildIndex(int i11) {
            return i11 * this.childWindowCount;
        }

        public int getPeriodCount() {
            return this.childPeriodCount * this.loopCount;
        }

        public Timeline getTimelineByChildIndex(int i11) {
            return this.childTimeline;
        }

        public int getWindowCount() {
            return this.childWindowCount * this.loopCount;
        }
    }

    public LoopingMediaSource(MediaSource mediaSource) {
        this(mediaSource, Integer.MAX_VALUE);
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        if (this.loopCount == Integer.MAX_VALUE) {
            return this.mediaSource.createPeriod(mediaPeriodId, allocator, j11);
        }
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        this.childMediaPeriodIdToMediaPeriodId.put(copyWithPeriodUid, mediaPeriodId);
        MediaPeriod createPeriod = this.mediaSource.createPeriod(copyWithPeriodUid, allocator, j11);
        this.mediaPeriodToChildMediaPeriodId.put(createPeriod, copyWithPeriodUid);
        return createPeriod;
    }

    @Nullable
    public Timeline getInitialTimeline() {
        MaskingMediaSource maskingMediaSource = (MaskingMediaSource) this.mediaSource;
        if (this.loopCount != Integer.MAX_VALUE) {
            return new LoopingTimeline(maskingMediaSource.getTimeline(), this.loopCount);
        }
        return new InfinitelyLoopingTimeline(maskingMediaSource.getTimeline());
    }

    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId) {
        if (this.loopCount != Integer.MAX_VALUE) {
            return this.childMediaPeriodIdToMediaPeriodId.get(mediaPeriodId);
        }
        return mediaPeriodId;
    }

    public boolean isSingleWindow() {
        return false;
    }

    public void onChildSourceInfoRefreshed(Timeline timeline) {
        Timeline timeline2;
        if (this.loopCount != Integer.MAX_VALUE) {
            timeline2 = new LoopingTimeline(timeline, this.loopCount);
        } else {
            timeline2 = new InfinitelyLoopingTimeline(timeline);
        }
        refreshSourceInfo(timeline2);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.mediaSource.releasePeriod(mediaPeriod);
        MediaSource.MediaPeriodId remove = this.mediaPeriodToChildMediaPeriodId.remove(mediaPeriod);
        if (remove != null) {
            this.childMediaPeriodIdToMediaPeriodId.remove(remove);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoopingMediaSource(MediaSource mediaSource, int i11) {
        super(new MaskingMediaSource(mediaSource, false));
        boolean z11 = false;
        Assertions.checkArgument(i11 > 0 ? true : z11);
        this.loopCount = i11;
        this.childMediaPeriodIdToMediaPeriodId = new HashMap();
        this.mediaPeriodToChildMediaPeriodId = new HashMap();
    }
}
