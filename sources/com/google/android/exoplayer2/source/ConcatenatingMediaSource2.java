package com.google.android.exoplayer2.source;

import a8.c;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.IdentityHashMap;

public final class ConcatenatingMediaSource2 extends CompositeMediaSource<Integer> {
    private static final int MSG_UPDATE_TIMELINE = 0;
    private final MediaItem mediaItem;
    private final IdentityHashMap<MediaPeriod, MediaSourceHolder> mediaSourceByMediaPeriod;
    private final ImmutableList<MediaSourceHolder> mediaSourceHolders;
    @Nullable
    private Handler playbackThreadHandler;
    private boolean timelineUpdateScheduled;

    public static final class Builder {
        private int index;
        @Nullable
        private MediaItem mediaItem;
        @Nullable
        private MediaSource.Factory mediaSourceFactory;
        private final ImmutableList.Builder<MediaSourceHolder> mediaSourceHoldersBuilder = ImmutableList.builder();

        @CanIgnoreReturnValue
        public Builder add(MediaItem mediaItem2) {
            return add(mediaItem2, (long) C.TIME_UNSET);
        }

        public ConcatenatingMediaSource2 build() {
            boolean z11;
            if (this.index > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkArgument(z11, "Must add at least one source to the concatenation.");
            if (this.mediaItem == null) {
                this.mediaItem = MediaItem.fromUri(Uri.EMPTY);
            }
            return new ConcatenatingMediaSource2(this.mediaItem, this.mediaSourceHoldersBuilder.build());
        }

        @CanIgnoreReturnValue
        public Builder setMediaItem(MediaItem mediaItem2) {
            this.mediaItem = mediaItem2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMediaSourceFactory(MediaSource.Factory factory) {
            this.mediaSourceFactory = (MediaSource.Factory) Assertions.checkNotNull(factory);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder useDefaultMediaSourceFactory(Context context) {
            return setMediaSourceFactory(new DefaultMediaSourceFactory(context));
        }

        @CanIgnoreReturnValue
        public Builder add(MediaItem mediaItem2, long j11) {
            Assertions.checkNotNull(mediaItem2);
            Assertions.checkStateNotNull(this.mediaSourceFactory, "Must use useDefaultMediaSourceFactory or setMediaSourceFactory first.");
            return add(this.mediaSourceFactory.createMediaSource(mediaItem2), j11);
        }

        @CanIgnoreReturnValue
        public Builder add(MediaSource mediaSource) {
            return add(mediaSource, (long) C.TIME_UNSET);
        }

        @CanIgnoreReturnValue
        public Builder add(MediaSource mediaSource, long j11) {
            Assertions.checkNotNull(mediaSource);
            Assertions.checkState(!(mediaSource instanceof ProgressiveMediaSource) || j11 != C.TIME_UNSET, "Progressive media source must define an initial placeholder duration.");
            ImmutableList.Builder<MediaSourceHolder> builder = this.mediaSourceHoldersBuilder;
            int i11 = this.index;
            this.index = i11 + 1;
            builder.add((Object) new MediaSourceHolder(mediaSource, i11, Util.msToUs(j11)));
            return this;
        }
    }

    public static final class ConcatenatedTimeline extends Timeline {
        private final long defaultPositionUs;
        private final long durationUs;
        private final ImmutableList<Integer> firstPeriodIndices;
        private final boolean isDynamic;
        private final boolean isSeekable;
        @Nullable
        private final Object manifest;
        private final MediaItem mediaItem;
        private final ImmutableList<Long> periodOffsetsInWindowUs;
        private final ImmutableList<Timeline> timelines;

        public ConcatenatedTimeline(MediaItem mediaItem2, ImmutableList<Timeline> immutableList, ImmutableList<Integer> immutableList2, ImmutableList<Long> immutableList3, boolean z11, boolean z12, long j11, long j12, @Nullable Object obj) {
            this.mediaItem = mediaItem2;
            this.timelines = immutableList;
            this.firstPeriodIndices = immutableList2;
            this.periodOffsetsInWindowUs = immutableList3;
            this.isSeekable = z11;
            this.isDynamic = z12;
            this.durationUs = j11;
            this.defaultPositionUs = j12;
            this.manifest = obj;
        }

        private int getChildIndexByPeriodIndex(int i11) {
            return Util.binarySearchFloor(this.firstPeriodIndices, Integer.valueOf(i11 + 1), false, false);
        }

        public final int getIndexOfPeriod(Object obj) {
            if (!(obj instanceof Pair) || !(((Pair) obj).first instanceof Integer)) {
                return -1;
            }
            int access$100 = ConcatenatingMediaSource2.getChildIndex(obj);
            int indexOfPeriod = this.timelines.get(access$100).getIndexOfPeriod(ConcatenatingMediaSource2.getChildPeriodUid(obj));
            if (indexOfPeriod == -1) {
                return -1;
            }
            return this.firstPeriodIndices.get(access$100).intValue() + indexOfPeriod;
        }

        public final Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
            int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i11);
            this.timelines.get(childIndexByPeriodIndex).getPeriod(i11 - this.firstPeriodIndices.get(childIndexByPeriodIndex).intValue(), period, z11);
            period.windowIndex = 0;
            period.positionInWindowUs = this.periodOffsetsInWindowUs.get(i11).longValue();
            if (z11) {
                period.uid = ConcatenatingMediaSource2.getPeriodUid(childIndexByPeriodIndex, Assertions.checkNotNull(period.uid));
            }
            return period;
        }

        public final Timeline.Period getPeriodByUid(Object obj, Timeline.Period period) {
            int access$100 = ConcatenatingMediaSource2.getChildIndex(obj);
            Object access$200 = ConcatenatingMediaSource2.getChildPeriodUid(obj);
            Timeline timeline = this.timelines.get(access$100);
            timeline.getPeriodByUid(access$200, period);
            period.windowIndex = 0;
            period.positionInWindowUs = this.periodOffsetsInWindowUs.get(this.firstPeriodIndices.get(access$100).intValue() + timeline.getIndexOfPeriod(access$200)).longValue();
            period.uid = obj;
            return period;
        }

        public int getPeriodCount() {
            return this.periodOffsetsInWindowUs.size();
        }

        public final Object getUidOfPeriod(int i11) {
            int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i11);
            return ConcatenatingMediaSource2.getPeriodUid(childIndexByPeriodIndex, this.timelines.get(childIndexByPeriodIndex).getUidOfPeriod(i11 - this.firstPeriodIndices.get(childIndexByPeriodIndex).intValue()));
        }

        public final Timeline.Window getWindow(int i11, Timeline.Window window, long j11) {
            return window.set(Timeline.Window.SINGLE_WINDOW_UID, this.mediaItem, this.manifest, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, this.isSeekable, this.isDynamic, (MediaItem.LiveConfiguration) null, this.defaultPositionUs, this.durationUs, 0, getPeriodCount() - 1, -this.periodOffsetsInWindowUs.get(0).longValue());
        }

        public int getWindowCount() {
            return 1;
        }
    }

    public static final class MediaSourceHolder {
        public int activeMediaPeriods;
        public final int index;
        public final long initialPlaceholderDurationUs;
        public final MaskingMediaSource mediaSource;

        public MediaSourceHolder(MediaSource mediaSource2, int i11, long j11) {
            this.mediaSource = new MaskingMediaSource(mediaSource2, false);
            this.index = i11;
            this.initialPlaceholderDurationUs = j11;
        }
    }

    private void disableUnusedMediaSources() {
        for (int i11 = 0; i11 < this.mediaSourceHolders.size(); i11++) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i11);
            if (mediaSourceHolder.activeMediaPeriods == 0) {
                disableChildSource(Integer.valueOf(mediaSourceHolder.index));
            }
        }
    }

    /* access modifiers changed from: private */
    public static int getChildIndex(Object obj) {
        return ((Integer) ((Pair) obj).first).intValue();
    }

    private static int getChildIndexFromChildWindowSequenceNumber(long j11, int i11) {
        return (int) (j11 % ((long) i11));
    }

    /* access modifiers changed from: private */
    public static Object getChildPeriodUid(Object obj) {
        return ((Pair) obj).second;
    }

    private static long getChildWindowSequenceNumber(long j11, int i11, int i12) {
        return (j11 * ((long) i11)) + ((long) i12);
    }

    /* access modifiers changed from: private */
    public static Object getPeriodUid(int i11, Object obj) {
        return Pair.create(Integer.valueOf(i11), obj);
    }

    private static long getWindowSequenceNumberFromChildWindowSequenceNumber(long j11, int i11) {
        return j11 / ((long) i11);
    }

    /* access modifiers changed from: private */
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return true;
        }
        updateTimeline();
        return true;
    }

    @Nullable
    private ConcatenatedTimeline maybeCreateConcatenatedTimeline() {
        Object obj;
        Timeline.Period period;
        ImmutableList.Builder builder;
        boolean z11;
        int i11;
        boolean z12;
        boolean z13;
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period2 = new Timeline.Period();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        ImmutableList.Builder builder3 = ImmutableList.builder();
        ImmutableList.Builder builder4 = ImmutableList.builder();
        boolean z14 = true;
        boolean z15 = true;
        boolean z16 = true;
        int i12 = 0;
        Object obj2 = null;
        int i13 = 0;
        long j11 = 0;
        boolean z17 = false;
        long j12 = 0;
        long j13 = 0;
        boolean z18 = false;
        while (i12 < this.mediaSourceHolders.size()) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i12);
            Timeline timeline = mediaSourceHolder.mediaSource.getTimeline();
            Assertions.checkArgument(timeline.isEmpty() ^ z14, "Can't concatenate empty child Timeline.");
            builder2.add((Object) timeline);
            builder3.add((Object) Integer.valueOf(i13));
            i13 += timeline.getPeriodCount();
            int i14 = 0;
            while (i14 < timeline.getWindowCount()) {
                timeline.getWindow(i14, window);
                if (!z18) {
                    obj2 = window.manifest;
                    z18 = true;
                }
                if (!z15 || !Util.areEqual(obj2, window.manifest)) {
                    i11 = i12;
                    z15 = false;
                } else {
                    i11 = i12;
                    z15 = true;
                }
                long j14 = window.durationUs;
                if (j14 == C.TIME_UNSET) {
                    j14 = mediaSourceHolder.initialPlaceholderDurationUs;
                    if (j14 == C.TIME_UNSET) {
                        return null;
                    }
                }
                j12 += j14;
                if (mediaSourceHolder.index == 0 && i14 == 0) {
                    j13 = window.defaultPositionUs;
                    j11 = -window.positionInFirstPeriodUs;
                } else {
                    if (window.positionInFirstPeriodUs == 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    Assertions.checkArgument(z13, "Can't concatenate windows. A window has a non-zero offset in a period.");
                }
                if (window.isSeekable || window.isPlaceholder) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z16 &= z12;
                z17 |= window.isDynamic;
                i14++;
                i12 = i11;
            }
            int i15 = i12;
            int periodCount = timeline.getPeriodCount();
            int i16 = 0;
            while (i16 < periodCount) {
                builder4.add((Object) Long.valueOf(j11));
                timeline.getPeriod(i16, period2);
                long j15 = period2.durationUs;
                if (j15 == C.TIME_UNSET) {
                    period = period2;
                    if (periodCount == 1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    Assertions.checkArgument(z11, "Can't concatenate multiple periods with unknown duration in one window.");
                    long j16 = window.durationUs;
                    if (j16 == C.TIME_UNSET) {
                        j16 = mediaSourceHolder.initialPlaceholderDurationUs;
                    }
                    builder = builder2;
                    j15 = j16 + window.positionInFirstPeriodUs;
                } else {
                    period = period2;
                    builder = builder2;
                }
                j11 += j15;
                i16++;
                builder2 = builder;
                period2 = period;
            }
            Timeline.Period period3 = period2;
            ImmutableList.Builder builder5 = builder2;
            i12 = i15 + 1;
            z14 = true;
        }
        MediaItem mediaItem2 = this.mediaItem;
        ImmutableList build = builder2.build();
        ImmutableList build2 = builder3.build();
        ImmutableList build3 = builder4.build();
        if (z15) {
            obj = obj2;
        } else {
            obj = null;
        }
        return new ConcatenatedTimeline(mediaItem2, build, build2, build3, z16, z17, j12, j13, obj);
    }

    private void scheduleTimelineUpdate() {
        if (!this.timelineUpdateScheduled) {
            ((Handler) Assertions.checkNotNull(this.playbackThreadHandler)).obtainMessage(0).sendToTarget();
            this.timelineUpdateScheduled = true;
        }
    }

    private void updateTimeline() {
        this.timelineUpdateScheduled = false;
        ConcatenatedTimeline maybeCreateConcatenatedTimeline = maybeCreateConcatenatedTimeline();
        if (maybeCreateConcatenatedTimeline != null) {
            refreshSourceInfo(maybeCreateConcatenatedTimeline);
        }
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(getChildIndex(mediaPeriodId.periodUid));
        MediaSource.MediaPeriodId copyWithWindowSequenceNumber = mediaPeriodId.copyWithPeriodUid(getChildPeriodUid(mediaPeriodId.periodUid)).copyWithWindowSequenceNumber(getChildWindowSequenceNumber(mediaPeriodId.windowSequenceNumber, this.mediaSourceHolders.size(), mediaSourceHolder.index));
        enableChildSource(Integer.valueOf(mediaSourceHolder.index));
        mediaSourceHolder.activeMediaPeriods++;
        MaskingMediaPeriod createPeriod = mediaSourceHolder.mediaSource.createPeriod(copyWithWindowSequenceNumber, allocator, j11);
        this.mediaSourceByMediaPeriod.put(createPeriod, mediaSourceHolder);
        disableUnusedMediaSources();
        return createPeriod;
    }

    public void enableInternal() {
    }

    @Nullable
    public Timeline getInitialTimeline() {
        return maybeCreateConcatenatedTimeline();
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public int getWindowIndexForChildWindowIndex(Integer num, int i11) {
        return 0;
    }

    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        this.playbackThreadHandler = new Handler(new c(this));
        for (int i11 = 0; i11 < this.mediaSourceHolders.size(); i11++) {
            prepareChildSource(Integer.valueOf(i11), this.mediaSourceHolders.get(i11).mediaSource);
        }
        scheduleTimelineUpdate();
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByMediaPeriod.remove(mediaPeriod));
        mediaSourceHolder.mediaSource.releasePeriod(mediaPeriod);
        mediaSourceHolder.activeMediaPeriods--;
        if (!this.mediaSourceByMediaPeriod.isEmpty()) {
            disableUnusedMediaSources();
        }
    }

    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        Handler handler = this.playbackThreadHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.playbackThreadHandler = null;
        }
        this.timelineUpdateScheduled = false;
    }

    private ConcatenatingMediaSource2(MediaItem mediaItem2, ImmutableList<MediaSourceHolder> immutableList) {
        this.mediaItem = mediaItem2;
        this.mediaSourceHolders = immutableList;
        this.mediaSourceByMediaPeriod = new IdentityHashMap<>();
    }

    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() != getChildIndexFromChildWindowSequenceNumber(mediaPeriodId.windowSequenceNumber, this.mediaSourceHolders.size())) {
            return null;
        }
        return mediaPeriodId.copyWithPeriodUid(getPeriodUid(num.intValue(), mediaPeriodId.periodUid)).copyWithWindowSequenceNumber(getWindowSequenceNumberFromChildWindowSequenceNumber(mediaPeriodId.windowSequenceNumber, this.mediaSourceHolders.size()));
    }

    public void onChildSourceInfoRefreshed(Integer num, MediaSource mediaSource, Timeline timeline) {
        scheduleTimelineUpdate();
    }
}
