package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;

public abstract class WrappingMediaSource extends CompositeMediaSource<Void> {
    private static final Void CHILD_SOURCE_ID = null;
    protected final MediaSource mediaSource;

    public WrappingMediaSource(MediaSource mediaSource2) {
        this.mediaSource = mediaSource2;
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        return this.mediaSource.createPeriod(mediaPeriodId, allocator, j11);
    }

    public final void disableChildSource() {
        disableChildSource(CHILD_SOURCE_ID);
    }

    public final void enableChildSource() {
        enableChildSource(CHILD_SOURCE_ID);
    }

    @Nullable
    public Timeline getInitialTimeline() {
        return this.mediaSource.getInitialTimeline();
    }

    public MediaItem getMediaItem() {
        return this.mediaSource.getMediaItem();
    }

    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    public long getMediaTimeForChildMediaTime(long j11) {
        return j11;
    }

    public int getWindowIndexForChildWindowIndex(int i11) {
        return i11;
    }

    public boolean isSingleWindow() {
        return this.mediaSource.isSingleWindow();
    }

    public final void prepareChildSource() {
        prepareChildSource(CHILD_SOURCE_ID, this.mediaSource);
    }

    public final void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareSourceInternal();
    }

    public final void releaseChildSource() {
        releaseChildSource(CHILD_SOURCE_ID);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.mediaSource.releasePeriod(mediaPeriod);
    }

    @Nullable
    public final MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void voidR, MediaSource.MediaPeriodId mediaPeriodId) {
        return getMediaPeriodIdForChildMediaPeriodId(mediaPeriodId);
    }

    public final long getMediaTimeForChildMediaTime(Void voidR, long j11) {
        return getMediaTimeForChildMediaTime(j11);
    }

    public final int getWindowIndexForChildWindowIndex(Void voidR, int i11) {
        return getWindowIndexForChildWindowIndex(i11);
    }

    public final void onChildSourceInfoRefreshed(Void voidR, MediaSource mediaSource2, Timeline timeline) {
        onChildSourceInfoRefreshed(timeline);
    }

    public void onChildSourceInfoRefreshed(Timeline timeline) {
        refreshSourceInfo(timeline);
    }

    public void prepareSourceInternal() {
        prepareChildSource();
    }
}
