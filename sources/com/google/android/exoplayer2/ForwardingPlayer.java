package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Size;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.List;

public class ForwardingPlayer implements Player {
    private final Player player;

    public static final class ForwardingListener implements Player.Listener {
        private final ForwardingPlayer forwardingPlayer;
        private final Player.Listener listener;

        public ForwardingListener(ForwardingPlayer forwardingPlayer2, Player.Listener listener2) {
            this.forwardingPlayer = forwardingPlayer2;
            this.listener = listener2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingListener)) {
                return false;
            }
            ForwardingListener forwardingListener = (ForwardingListener) obj;
            if (!this.forwardingPlayer.equals(forwardingListener.forwardingPlayer)) {
                return false;
            }
            return this.listener.equals(forwardingListener.listener);
        }

        public int hashCode() {
            return (this.forwardingPlayer.hashCode() * 31) + this.listener.hashCode();
        }

        public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            this.listener.onAudioAttributesChanged(audioAttributes);
        }

        public void onAudioSessionIdChanged(int i11) {
            this.listener.onAudioSessionIdChanged(i11);
        }

        public void onAvailableCommandsChanged(Player.Commands commands) {
            this.listener.onAvailableCommandsChanged(commands);
        }

        public void onCues(List<Cue> list) {
            this.listener.onCues(list);
        }

        public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            this.listener.onDeviceInfoChanged(deviceInfo);
        }

        public void onDeviceVolumeChanged(int i11, boolean z11) {
            this.listener.onDeviceVolumeChanged(i11, z11);
        }

        public void onEvents(Player player, Player.Events events) {
            this.listener.onEvents(this.forwardingPlayer, events);
        }

        public void onIsLoadingChanged(boolean z11) {
            this.listener.onIsLoadingChanged(z11);
        }

        public void onIsPlayingChanged(boolean z11) {
            this.listener.onIsPlayingChanged(z11);
        }

        public void onLoadingChanged(boolean z11) {
            this.listener.onIsLoadingChanged(z11);
        }

        public void onMaxSeekToPreviousPositionChanged(long j11) {
            this.listener.onMaxSeekToPreviousPositionChanged(j11);
        }

        public void onMediaItemTransition(@Nullable MediaItem mediaItem, int i11) {
            this.listener.onMediaItemTransition(mediaItem, i11);
        }

        public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            this.listener.onMediaMetadataChanged(mediaMetadata);
        }

        public void onMetadata(Metadata metadata) {
            this.listener.onMetadata(metadata);
        }

        public void onPlayWhenReadyChanged(boolean z11, int i11) {
            this.listener.onPlayWhenReadyChanged(z11, i11);
        }

        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            this.listener.onPlaybackParametersChanged(playbackParameters);
        }

        public void onPlaybackStateChanged(int i11) {
            this.listener.onPlaybackStateChanged(i11);
        }

        public void onPlaybackSuppressionReasonChanged(int i11) {
            this.listener.onPlaybackSuppressionReasonChanged(i11);
        }

        public void onPlayerError(PlaybackException playbackException) {
            this.listener.onPlayerError(playbackException);
        }

        public void onPlayerErrorChanged(@Nullable PlaybackException playbackException) {
            this.listener.onPlayerErrorChanged(playbackException);
        }

        public void onPlayerStateChanged(boolean z11, int i11) {
            this.listener.onPlayerStateChanged(z11, i11);
        }

        public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            this.listener.onPlaylistMetadataChanged(mediaMetadata);
        }

        public void onPositionDiscontinuity(int i11) {
            this.listener.onPositionDiscontinuity(i11);
        }

        public void onRenderedFirstFrame() {
            this.listener.onRenderedFirstFrame();
        }

        public void onRepeatModeChanged(int i11) {
            this.listener.onRepeatModeChanged(i11);
        }

        public void onSeekBackIncrementChanged(long j11) {
            this.listener.onSeekBackIncrementChanged(j11);
        }

        public void onSeekForwardIncrementChanged(long j11) {
            this.listener.onSeekForwardIncrementChanged(j11);
        }

        public void onSeekProcessed() {
            this.listener.onSeekProcessed();
        }

        public void onShuffleModeEnabledChanged(boolean z11) {
            this.listener.onShuffleModeEnabledChanged(z11);
        }

        public void onSkipSilenceEnabledChanged(boolean z11) {
            this.listener.onSkipSilenceEnabledChanged(z11);
        }

        public void onSurfaceSizeChanged(int i11, int i12) {
            this.listener.onSurfaceSizeChanged(i11, i12);
        }

        public void onTimelineChanged(Timeline timeline, int i11) {
            this.listener.onTimelineChanged(timeline, i11);
        }

        public void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            this.listener.onTrackSelectionParametersChanged(trackSelectionParameters);
        }

        public void onTracksChanged(Tracks tracks) {
            this.listener.onTracksChanged(tracks);
        }

        public void onVideoSizeChanged(VideoSize videoSize) {
            this.listener.onVideoSizeChanged(videoSize);
        }

        public void onVolumeChanged(float f11) {
            this.listener.onVolumeChanged(f11);
        }

        public void onCues(CueGroup cueGroup) {
            this.listener.onCues(cueGroup);
        }

        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) {
            this.listener.onPositionDiscontinuity(positionInfo, positionInfo2, i11);
        }
    }

    public ForwardingPlayer(Player player2) {
        this.player = player2;
    }

    @CallSuper
    public void addListener(Player.Listener listener) {
        this.player.addListener(new ForwardingListener(this, listener));
    }

    public void addMediaItem(MediaItem mediaItem) {
        this.player.addMediaItem(mediaItem);
    }

    public void addMediaItems(List<MediaItem> list) {
        this.player.addMediaItems(list);
    }

    public boolean canAdvertiseSession() {
        return this.player.canAdvertiseSession();
    }

    public void clearMediaItems() {
        this.player.clearMediaItems();
    }

    public void clearVideoSurface() {
        this.player.clearVideoSurface();
    }

    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        this.player.clearVideoSurfaceHolder(surfaceHolder);
    }

    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        this.player.clearVideoSurfaceView(surfaceView);
    }

    public void clearVideoTextureView(@Nullable TextureView textureView) {
        this.player.clearVideoTextureView(textureView);
    }

    public void decreaseDeviceVolume() {
        this.player.decreaseDeviceVolume();
    }

    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    public AudioAttributes getAudioAttributes() {
        return this.player.getAudioAttributes();
    }

    public Player.Commands getAvailableCommands() {
        return this.player.getAvailableCommands();
    }

    public int getBufferedPercentage() {
        return this.player.getBufferedPercentage();
    }

    public long getBufferedPosition() {
        return this.player.getBufferedPosition();
    }

    public long getContentBufferedPosition() {
        return this.player.getContentBufferedPosition();
    }

    public long getContentDuration() {
        return this.player.getContentDuration();
    }

    public long getContentPosition() {
        return this.player.getContentPosition();
    }

    public int getCurrentAdGroupIndex() {
        return this.player.getCurrentAdGroupIndex();
    }

    public int getCurrentAdIndexInAdGroup() {
        return this.player.getCurrentAdIndexInAdGroup();
    }

    public CueGroup getCurrentCues() {
        return this.player.getCurrentCues();
    }

    public long getCurrentLiveOffset() {
        return this.player.getCurrentLiveOffset();
    }

    @Nullable
    public Object getCurrentManifest() {
        return this.player.getCurrentManifest();
    }

    @Nullable
    public MediaItem getCurrentMediaItem() {
        return this.player.getCurrentMediaItem();
    }

    public int getCurrentMediaItemIndex() {
        return this.player.getCurrentMediaItemIndex();
    }

    public int getCurrentPeriodIndex() {
        return this.player.getCurrentPeriodIndex();
    }

    public long getCurrentPosition() {
        return this.player.getCurrentPosition();
    }

    public Timeline getCurrentTimeline() {
        return this.player.getCurrentTimeline();
    }

    public Tracks getCurrentTracks() {
        return this.player.getCurrentTracks();
    }

    @Deprecated
    public int getCurrentWindowIndex() {
        return this.player.getCurrentWindowIndex();
    }

    public DeviceInfo getDeviceInfo() {
        return this.player.getDeviceInfo();
    }

    public int getDeviceVolume() {
        return this.player.getDeviceVolume();
    }

    public long getDuration() {
        return this.player.getDuration();
    }

    public long getMaxSeekToPreviousPosition() {
        return this.player.getMaxSeekToPreviousPosition();
    }

    public MediaItem getMediaItemAt(int i11) {
        return this.player.getMediaItemAt(i11);
    }

    public int getMediaItemCount() {
        return this.player.getMediaItemCount();
    }

    public MediaMetadata getMediaMetadata() {
        return this.player.getMediaMetadata();
    }

    public int getNextMediaItemIndex() {
        return this.player.getNextMediaItemIndex();
    }

    @Deprecated
    public int getNextWindowIndex() {
        return this.player.getNextWindowIndex();
    }

    public boolean getPlayWhenReady() {
        return this.player.getPlayWhenReady();
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.player.getPlaybackParameters();
    }

    public int getPlaybackState() {
        return this.player.getPlaybackState();
    }

    public int getPlaybackSuppressionReason() {
        return this.player.getPlaybackSuppressionReason();
    }

    @Nullable
    public PlaybackException getPlayerError() {
        return this.player.getPlayerError();
    }

    public MediaMetadata getPlaylistMetadata() {
        return this.player.getPlaylistMetadata();
    }

    public int getPreviousMediaItemIndex() {
        return this.player.getPreviousMediaItemIndex();
    }

    @Deprecated
    public int getPreviousWindowIndex() {
        return this.player.getPreviousWindowIndex();
    }

    public int getRepeatMode() {
        return this.player.getRepeatMode();
    }

    public long getSeekBackIncrement() {
        return this.player.getSeekBackIncrement();
    }

    public long getSeekForwardIncrement() {
        return this.player.getSeekForwardIncrement();
    }

    public boolean getShuffleModeEnabled() {
        return this.player.getShuffleModeEnabled();
    }

    public Size getSurfaceSize() {
        return this.player.getSurfaceSize();
    }

    public long getTotalBufferedDuration() {
        return this.player.getTotalBufferedDuration();
    }

    public TrackSelectionParameters getTrackSelectionParameters() {
        return this.player.getTrackSelectionParameters();
    }

    public VideoSize getVideoSize() {
        return this.player.getVideoSize();
    }

    public float getVolume() {
        return this.player.getVolume();
    }

    public Player getWrappedPlayer() {
        return this.player;
    }

    @Deprecated
    public boolean hasNext() {
        return this.player.hasNext();
    }

    public boolean hasNextMediaItem() {
        return this.player.hasNextMediaItem();
    }

    @Deprecated
    public boolean hasNextWindow() {
        return this.player.hasNextWindow();
    }

    @Deprecated
    public boolean hasPrevious() {
        return this.player.hasPrevious();
    }

    public boolean hasPreviousMediaItem() {
        return this.player.hasPreviousMediaItem();
    }

    @Deprecated
    public boolean hasPreviousWindow() {
        return this.player.hasPreviousWindow();
    }

    public void increaseDeviceVolume() {
        this.player.increaseDeviceVolume();
    }

    public boolean isCommandAvailable(int i11) {
        return this.player.isCommandAvailable(i11);
    }

    public boolean isCurrentMediaItemDynamic() {
        return this.player.isCurrentMediaItemDynamic();
    }

    public boolean isCurrentMediaItemLive() {
        return this.player.isCurrentMediaItemLive();
    }

    public boolean isCurrentMediaItemSeekable() {
        return this.player.isCurrentMediaItemSeekable();
    }

    @Deprecated
    public boolean isCurrentWindowDynamic() {
        return this.player.isCurrentWindowDynamic();
    }

    @Deprecated
    public boolean isCurrentWindowLive() {
        return this.player.isCurrentWindowLive();
    }

    @Deprecated
    public boolean isCurrentWindowSeekable() {
        return this.player.isCurrentWindowSeekable();
    }

    public boolean isDeviceMuted() {
        return this.player.isDeviceMuted();
    }

    public boolean isLoading() {
        return this.player.isLoading();
    }

    public boolean isPlaying() {
        return this.player.isPlaying();
    }

    public boolean isPlayingAd() {
        return this.player.isPlayingAd();
    }

    public void moveMediaItem(int i11, int i12) {
        this.player.moveMediaItem(i11, i12);
    }

    public void moveMediaItems(int i11, int i12, int i13) {
        this.player.moveMediaItems(i11, i12, i13);
    }

    @Deprecated
    public void next() {
        this.player.next();
    }

    public void pause() {
        this.player.pause();
    }

    public void play() {
        this.player.play();
    }

    public void prepare() {
        this.player.prepare();
    }

    @Deprecated
    public void previous() {
        this.player.previous();
    }

    public void release() {
        this.player.release();
    }

    @CallSuper
    public void removeListener(Player.Listener listener) {
        this.player.removeListener(new ForwardingListener(this, listener));
    }

    public void removeMediaItem(int i11) {
        this.player.removeMediaItem(i11);
    }

    public void removeMediaItems(int i11, int i12) {
        this.player.removeMediaItems(i11, i12);
    }

    public void seekBack() {
        this.player.seekBack();
    }

    public void seekForward() {
        this.player.seekForward();
    }

    public void seekTo(long j11) {
        this.player.seekTo(j11);
    }

    public void seekToDefaultPosition() {
        this.player.seekToDefaultPosition();
    }

    public void seekToNext() {
        this.player.seekToNext();
    }

    public void seekToNextMediaItem() {
        this.player.seekToNextMediaItem();
    }

    @Deprecated
    public void seekToNextWindow() {
        this.player.seekToNextWindow();
    }

    public void seekToPrevious() {
        this.player.seekToPrevious();
    }

    public void seekToPreviousMediaItem() {
        this.player.seekToPreviousMediaItem();
    }

    @Deprecated
    public void seekToPreviousWindow() {
        this.player.seekToPreviousWindow();
    }

    public void setDeviceMuted(boolean z11) {
        this.player.setDeviceMuted(z11);
    }

    public void setDeviceVolume(int i11) {
        this.player.setDeviceVolume(i11);
    }

    public void setMediaItem(MediaItem mediaItem) {
        this.player.setMediaItem(mediaItem);
    }

    public void setMediaItems(List<MediaItem> list) {
        this.player.setMediaItems(list);
    }

    public void setPlayWhenReady(boolean z11) {
        this.player.setPlayWhenReady(z11);
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.player.setPlaybackParameters(playbackParameters);
    }

    public void setPlaybackSpeed(float f11) {
        this.player.setPlaybackSpeed(f11);
    }

    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        this.player.setPlaylistMetadata(mediaMetadata);
    }

    public void setRepeatMode(int i11) {
        this.player.setRepeatMode(i11);
    }

    public void setShuffleModeEnabled(boolean z11) {
        this.player.setShuffleModeEnabled(z11);
    }

    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        this.player.setTrackSelectionParameters(trackSelectionParameters);
    }

    public void setVideoSurface(@Nullable Surface surface) {
        this.player.setVideoSurface(surface);
    }

    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        this.player.setVideoSurfaceHolder(surfaceHolder);
    }

    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        this.player.setVideoSurfaceView(surfaceView);
    }

    public void setVideoTextureView(@Nullable TextureView textureView) {
        this.player.setVideoTextureView(textureView);
    }

    public void setVolume(float f11) {
        this.player.setVolume(f11);
    }

    public void stop() {
        this.player.stop();
    }

    public void addMediaItem(int i11, MediaItem mediaItem) {
        this.player.addMediaItem(i11, mediaItem);
    }

    public void addMediaItems(int i11, List<MediaItem> list) {
        this.player.addMediaItems(i11, list);
    }

    public void clearVideoSurface(@Nullable Surface surface) {
        this.player.clearVideoSurface(surface);
    }

    public void seekTo(int i11, long j11) {
        this.player.seekTo(i11, j11);
    }

    public void seekToDefaultPosition(int i11) {
        this.player.seekToDefaultPosition(i11);
    }

    public void setMediaItem(MediaItem mediaItem, long j11) {
        this.player.setMediaItem(mediaItem, j11);
    }

    public void setMediaItems(List<MediaItem> list, boolean z11) {
        this.player.setMediaItems(list, z11);
    }

    @Deprecated
    public void stop(boolean z11) {
        this.player.stop(z11);
    }

    public void setMediaItem(MediaItem mediaItem, boolean z11) {
        this.player.setMediaItem(mediaItem, z11);
    }

    public void setMediaItems(List<MediaItem> list, int i11, long j11) {
        this.player.setMediaItems(list, i11, j11);
    }
}
