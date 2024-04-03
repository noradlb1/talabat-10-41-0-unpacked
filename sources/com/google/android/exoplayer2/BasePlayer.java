package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.List;

public abstract class BasePlayer implements Player {
    protected final Timeline.Window window = new Timeline.Window();

    private int getRepeatModeForNavigation() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    private void repeatCurrentMediaItem(int i11) {
        seekTo(getCurrentMediaItemIndex(), C.TIME_UNSET, i11, true);
    }

    private void seekToCurrentItem(long j11, int i11) {
        seekTo(getCurrentMediaItemIndex(), j11, i11, false);
    }

    private void seekToDefaultPositionInternal(int i11, int i12) {
        seekTo(i11, C.TIME_UNSET, i12, false);
    }

    private void seekToNextMediaItemInternal(int i11) {
        int nextMediaItemIndex = getNextMediaItemIndex();
        if (nextMediaItemIndex != -1) {
            if (nextMediaItemIndex == getCurrentMediaItemIndex()) {
                repeatCurrentMediaItem(i11);
            } else {
                seekToDefaultPositionInternal(nextMediaItemIndex, i11);
            }
        }
    }

    private void seekToOffset(long j11, int i11) {
        long currentPosition = getCurrentPosition() + j11;
        long duration = getDuration();
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekToCurrentItem(Math.max(currentPosition, 0), i11);
    }

    private void seekToPreviousMediaItemInternal(int i11) {
        int previousMediaItemIndex = getPreviousMediaItemIndex();
        if (previousMediaItemIndex != -1) {
            if (previousMediaItemIndex == getCurrentMediaItemIndex()) {
                repeatCurrentMediaItem(i11);
            } else {
                seekToDefaultPositionInternal(previousMediaItemIndex, i11);
            }
        }
    }

    public final void addMediaItem(int i11, MediaItem mediaItem) {
        addMediaItems(i11, ImmutableList.of(mediaItem));
    }

    public final void addMediaItems(List<MediaItem> list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    public final boolean canAdvertiseSession() {
        return true;
    }

    public final void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == C.TIME_UNSET || duration == C.TIME_UNSET) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    public final long getContentDuration() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return C.TIME_UNSET;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).getDurationMs();
    }

    public final long getCurrentLiveOffset() {
        Timeline currentTimeline = getCurrentTimeline();
        if (!currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).windowStartTimeMs != C.TIME_UNSET) {
            return (this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - getContentPosition();
        }
        return C.TIME_UNSET;
    }

    @Nullable
    public final Object getCurrentManifest() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).manifest;
    }

    @Nullable
    public final MediaItem getCurrentMediaItem() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).mediaItem;
    }

    @Deprecated
    public final int getCurrentWindowIndex() {
        return getCurrentMediaItemIndex();
    }

    public final MediaItem getMediaItemAt(int i11) {
        return getCurrentTimeline().getWindow(i11, this.window).mediaItem;
    }

    public final int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    public final int getNextMediaItemIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getNextWindowIndex(getCurrentMediaItemIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Deprecated
    public final int getNextWindowIndex() {
        return getNextMediaItemIndex();
    }

    public final int getPreviousMediaItemIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getPreviousWindowIndex(getCurrentMediaItemIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Deprecated
    public final int getPreviousWindowIndex() {
        return getPreviousMediaItemIndex();
    }

    @Deprecated
    public final boolean hasNext() {
        return hasNextMediaItem();
    }

    public final boolean hasNextMediaItem() {
        return getNextMediaItemIndex() != -1;
    }

    @Deprecated
    public final boolean hasNextWindow() {
        return hasNextMediaItem();
    }

    @Deprecated
    public final boolean hasPrevious() {
        return hasPreviousMediaItem();
    }

    public final boolean hasPreviousMediaItem() {
        return getPreviousMediaItemIndex() != -1;
    }

    @Deprecated
    public final boolean hasPreviousWindow() {
        return hasPreviousMediaItem();
    }

    public final boolean isCommandAvailable(int i11) {
        return getAvailableCommands().contains(i11);
    }

    public final boolean isCurrentMediaItemDynamic() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty() || !currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isDynamic) {
            return false;
        }
        return true;
    }

    public final boolean isCurrentMediaItemLive() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty() || !currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isLive()) {
            return false;
        }
        return true;
    }

    public final boolean isCurrentMediaItemSeekable() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty() || !currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isSeekable) {
            return false;
        }
        return true;
    }

    @Deprecated
    public final boolean isCurrentWindowDynamic() {
        return isCurrentMediaItemDynamic();
    }

    @Deprecated
    public final boolean isCurrentWindowLive() {
        return isCurrentMediaItemLive();
    }

    @Deprecated
    public final boolean isCurrentWindowSeekable() {
        return isCurrentMediaItemSeekable();
    }

    public final boolean isPlaying() {
        if (getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0) {
            return true;
        }
        return false;
    }

    public final void moveMediaItem(int i11, int i12) {
        if (i11 != i12) {
            moveMediaItems(i11, i11 + 1, i12);
        }
    }

    @Deprecated
    public final void next() {
        seekToNextMediaItem();
    }

    public final void pause() {
        setPlayWhenReady(false);
    }

    public final void play() {
        setPlayWhenReady(true);
    }

    @Deprecated
    public final void previous() {
        seekToPreviousMediaItem();
    }

    public final void removeMediaItem(int i11) {
        removeMediaItems(i11, i11 + 1);
    }

    public final void seekBack() {
        seekToOffset(-getSeekBackIncrement(), 11);
    }

    public final void seekForward() {
        seekToOffset(getSeekForwardIncrement(), 12);
    }

    @VisibleForTesting(otherwise = 4)
    public abstract void seekTo(int i11, long j11, int i12, boolean z11);

    public final void seekTo(long j11) {
        seekToCurrentItem(j11, 5);
    }

    public final void seekToDefaultPosition() {
        seekToDefaultPositionInternal(getCurrentMediaItemIndex(), 4);
    }

    public final void seekToNext() {
        if (!getCurrentTimeline().isEmpty() && !isPlayingAd()) {
            if (hasNextMediaItem()) {
                seekToNextMediaItemInternal(9);
            } else if (isCurrentMediaItemLive() && isCurrentMediaItemDynamic()) {
                seekToDefaultPositionInternal(getCurrentMediaItemIndex(), 9);
            }
        }
    }

    public final void seekToNextMediaItem() {
        seekToNextMediaItemInternal(8);
    }

    @Deprecated
    public final void seekToNextWindow() {
        seekToNextMediaItem();
    }

    public final void seekToPrevious() {
        if (!getCurrentTimeline().isEmpty() && !isPlayingAd()) {
            boolean hasPreviousMediaItem = hasPreviousMediaItem();
            if (!isCurrentMediaItemLive() || isCurrentMediaItemSeekable()) {
                if (!hasPreviousMediaItem || getCurrentPosition() > getMaxSeekToPreviousPosition()) {
                    seekToCurrentItem(0, 7);
                } else {
                    seekToPreviousMediaItemInternal(7);
                }
            } else if (hasPreviousMediaItem) {
                seekToPreviousMediaItemInternal(7);
            }
        }
    }

    public final void seekToPreviousMediaItem() {
        seekToPreviousMediaItemInternal(6);
    }

    @Deprecated
    public final void seekToPreviousWindow() {
        seekToPreviousMediaItem();
    }

    public final void setMediaItem(MediaItem mediaItem) {
        setMediaItems(ImmutableList.of(mediaItem));
    }

    public final void setMediaItems(List<MediaItem> list) {
        setMediaItems(list, true);
    }

    public final void setPlaybackSpeed(float f11) {
        setPlaybackParameters(getPlaybackParameters().withSpeed(f11));
    }

    public final void addMediaItem(MediaItem mediaItem) {
        addMediaItems(ImmutableList.of(mediaItem));
    }

    public final void seekTo(int i11, long j11) {
        seekTo(i11, j11, 10, false);
    }

    public final void setMediaItem(MediaItem mediaItem, long j11) {
        setMediaItems(ImmutableList.of(mediaItem), 0, j11);
    }

    public final void seekToDefaultPosition(int i11) {
        seekToDefaultPositionInternal(i11, 10);
    }

    public final void setMediaItem(MediaItem mediaItem, boolean z11) {
        setMediaItems(ImmutableList.of(mediaItem), z11);
    }
}
