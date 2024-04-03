package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Size;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;

@Deprecated
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {
    private final ConditionVariable constructorFinished;
    private final ExoPlayerImpl player;

    @Deprecated
    public SimpleExoPlayer(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSource.Factory factory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean z11, Clock clock, Looper looper) {
        this(new ExoPlayer.Builder(context, renderersFactory, factory, trackSelector, loadControl, bandwidthMeter, analyticsCollector).setUseLazyPreparation(z11).setClock(clock).setLooper(looper));
    }

    private void blockUntilConstructorFinished() {
        this.constructorFinished.blockUninterruptible();
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        blockUntilConstructorFinished();
        this.player.addAnalyticsListener(analyticsListener);
    }

    public void addAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        blockUntilConstructorFinished();
        this.player.addAudioOffloadListener(audioOffloadListener);
    }

    public void addListener(Player.Listener listener) {
        blockUntilConstructorFinished();
        this.player.addListener(listener);
    }

    public void addMediaItems(int i11, List<MediaItem> list) {
        blockUntilConstructorFinished();
        this.player.addMediaItems(i11, list);
    }

    public void addMediaSource(MediaSource mediaSource) {
        blockUntilConstructorFinished();
        this.player.addMediaSource(mediaSource);
    }

    public void addMediaSources(List<MediaSource> list) {
        blockUntilConstructorFinished();
        this.player.addMediaSources(list);
    }

    public void clearAuxEffectInfo() {
        blockUntilConstructorFinished();
        this.player.clearAuxEffectInfo();
    }

    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener) {
        blockUntilConstructorFinished();
        this.player.clearCameraMotionListener(cameraMotionListener);
    }

    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        blockUntilConstructorFinished();
        this.player.clearVideoFrameMetadataListener(videoFrameMetadataListener);
    }

    public void clearVideoSurface() {
        blockUntilConstructorFinished();
        this.player.clearVideoSurface();
    }

    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        blockUntilConstructorFinished();
        this.player.clearVideoSurfaceHolder(surfaceHolder);
    }

    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        blockUntilConstructorFinished();
        this.player.clearVideoSurfaceView(surfaceView);
    }

    public void clearVideoTextureView(@Nullable TextureView textureView) {
        blockUntilConstructorFinished();
        this.player.clearVideoTextureView(textureView);
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        blockUntilConstructorFinished();
        return this.player.createMessage(target);
    }

    public void decreaseDeviceVolume() {
        blockUntilConstructorFinished();
        this.player.decreaseDeviceVolume();
    }

    public boolean experimentalIsSleepingForOffload() {
        blockUntilConstructorFinished();
        return this.player.experimentalIsSleepingForOffload();
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z11) {
        blockUntilConstructorFinished();
        this.player.experimentalSetOffloadSchedulingEnabled(z11);
    }

    public AnalyticsCollector getAnalyticsCollector() {
        blockUntilConstructorFinished();
        return this.player.getAnalyticsCollector();
    }

    public Looper getApplicationLooper() {
        blockUntilConstructorFinished();
        return this.player.getApplicationLooper();
    }

    public AudioAttributes getAudioAttributes() {
        blockUntilConstructorFinished();
        return this.player.getAudioAttributes();
    }

    @Deprecated
    @Nullable
    public ExoPlayer.AudioComponent getAudioComponent() {
        return this;
    }

    @Nullable
    public DecoderCounters getAudioDecoderCounters() {
        blockUntilConstructorFinished();
        return this.player.getAudioDecoderCounters();
    }

    @Nullable
    public Format getAudioFormat() {
        blockUntilConstructorFinished();
        return this.player.getAudioFormat();
    }

    public int getAudioSessionId() {
        blockUntilConstructorFinished();
        return this.player.getAudioSessionId();
    }

    public Player.Commands getAvailableCommands() {
        blockUntilConstructorFinished();
        return this.player.getAvailableCommands();
    }

    public long getBufferedPosition() {
        blockUntilConstructorFinished();
        return this.player.getBufferedPosition();
    }

    public Clock getClock() {
        blockUntilConstructorFinished();
        return this.player.getClock();
    }

    public long getContentBufferedPosition() {
        blockUntilConstructorFinished();
        return this.player.getContentBufferedPosition();
    }

    public long getContentPosition() {
        blockUntilConstructorFinished();
        return this.player.getContentPosition();
    }

    public int getCurrentAdGroupIndex() {
        blockUntilConstructorFinished();
        return this.player.getCurrentAdGroupIndex();
    }

    public int getCurrentAdIndexInAdGroup() {
        blockUntilConstructorFinished();
        return this.player.getCurrentAdIndexInAdGroup();
    }

    public CueGroup getCurrentCues() {
        blockUntilConstructorFinished();
        return this.player.getCurrentCues();
    }

    public int getCurrentMediaItemIndex() {
        blockUntilConstructorFinished();
        return this.player.getCurrentMediaItemIndex();
    }

    public int getCurrentPeriodIndex() {
        blockUntilConstructorFinished();
        return this.player.getCurrentPeriodIndex();
    }

    public long getCurrentPosition() {
        blockUntilConstructorFinished();
        return this.player.getCurrentPosition();
    }

    public Timeline getCurrentTimeline() {
        blockUntilConstructorFinished();
        return this.player.getCurrentTimeline();
    }

    @Deprecated
    public TrackGroupArray getCurrentTrackGroups() {
        blockUntilConstructorFinished();
        return this.player.getCurrentTrackGroups();
    }

    @Deprecated
    public TrackSelectionArray getCurrentTrackSelections() {
        blockUntilConstructorFinished();
        return this.player.getCurrentTrackSelections();
    }

    public Tracks getCurrentTracks() {
        blockUntilConstructorFinished();
        return this.player.getCurrentTracks();
    }

    @Deprecated
    @Nullable
    public ExoPlayer.DeviceComponent getDeviceComponent() {
        return this;
    }

    public DeviceInfo getDeviceInfo() {
        blockUntilConstructorFinished();
        return this.player.getDeviceInfo();
    }

    public int getDeviceVolume() {
        blockUntilConstructorFinished();
        return this.player.getDeviceVolume();
    }

    public long getDuration() {
        blockUntilConstructorFinished();
        return this.player.getDuration();
    }

    public long getMaxSeekToPreviousPosition() {
        blockUntilConstructorFinished();
        return this.player.getMaxSeekToPreviousPosition();
    }

    public MediaMetadata getMediaMetadata() {
        blockUntilConstructorFinished();
        return this.player.getMediaMetadata();
    }

    public boolean getPauseAtEndOfMediaItems() {
        blockUntilConstructorFinished();
        return this.player.getPauseAtEndOfMediaItems();
    }

    public boolean getPlayWhenReady() {
        blockUntilConstructorFinished();
        return this.player.getPlayWhenReady();
    }

    public Looper getPlaybackLooper() {
        blockUntilConstructorFinished();
        return this.player.getPlaybackLooper();
    }

    public PlaybackParameters getPlaybackParameters() {
        blockUntilConstructorFinished();
        return this.player.getPlaybackParameters();
    }

    public int getPlaybackState() {
        blockUntilConstructorFinished();
        return this.player.getPlaybackState();
    }

    public int getPlaybackSuppressionReason() {
        blockUntilConstructorFinished();
        return this.player.getPlaybackSuppressionReason();
    }

    public MediaMetadata getPlaylistMetadata() {
        blockUntilConstructorFinished();
        return this.player.getPlaylistMetadata();
    }

    public Renderer getRenderer(int i11) {
        blockUntilConstructorFinished();
        return this.player.getRenderer(i11);
    }

    public int getRendererCount() {
        blockUntilConstructorFinished();
        return this.player.getRendererCount();
    }

    public int getRendererType(int i11) {
        blockUntilConstructorFinished();
        return this.player.getRendererType(i11);
    }

    public int getRepeatMode() {
        blockUntilConstructorFinished();
        return this.player.getRepeatMode();
    }

    public long getSeekBackIncrement() {
        blockUntilConstructorFinished();
        return this.player.getSeekBackIncrement();
    }

    public long getSeekForwardIncrement() {
        blockUntilConstructorFinished();
        return this.player.getSeekForwardIncrement();
    }

    public SeekParameters getSeekParameters() {
        blockUntilConstructorFinished();
        return this.player.getSeekParameters();
    }

    public boolean getShuffleModeEnabled() {
        blockUntilConstructorFinished();
        return this.player.getShuffleModeEnabled();
    }

    public boolean getSkipSilenceEnabled() {
        blockUntilConstructorFinished();
        return this.player.getSkipSilenceEnabled();
    }

    public Size getSurfaceSize() {
        blockUntilConstructorFinished();
        return this.player.getSurfaceSize();
    }

    @Deprecated
    @Nullable
    public ExoPlayer.TextComponent getTextComponent() {
        return this;
    }

    public long getTotalBufferedDuration() {
        blockUntilConstructorFinished();
        return this.player.getTotalBufferedDuration();
    }

    public TrackSelectionParameters getTrackSelectionParameters() {
        blockUntilConstructorFinished();
        return this.player.getTrackSelectionParameters();
    }

    public TrackSelector getTrackSelector() {
        blockUntilConstructorFinished();
        return this.player.getTrackSelector();
    }

    public int getVideoChangeFrameRateStrategy() {
        blockUntilConstructorFinished();
        return this.player.getVideoChangeFrameRateStrategy();
    }

    @Deprecated
    @Nullable
    public ExoPlayer.VideoComponent getVideoComponent() {
        return this;
    }

    @Nullable
    public DecoderCounters getVideoDecoderCounters() {
        blockUntilConstructorFinished();
        return this.player.getVideoDecoderCounters();
    }

    @Nullable
    public Format getVideoFormat() {
        blockUntilConstructorFinished();
        return this.player.getVideoFormat();
    }

    public int getVideoScalingMode() {
        blockUntilConstructorFinished();
        return this.player.getVideoScalingMode();
    }

    public VideoSize getVideoSize() {
        blockUntilConstructorFinished();
        return this.player.getVideoSize();
    }

    public float getVolume() {
        blockUntilConstructorFinished();
        return this.player.getVolume();
    }

    public void increaseDeviceVolume() {
        blockUntilConstructorFinished();
        this.player.increaseDeviceVolume();
    }

    public boolean isDeviceMuted() {
        blockUntilConstructorFinished();
        return this.player.isDeviceMuted();
    }

    public boolean isLoading() {
        blockUntilConstructorFinished();
        return this.player.isLoading();
    }

    public boolean isPlayingAd() {
        blockUntilConstructorFinished();
        return this.player.isPlayingAd();
    }

    public boolean isTunnelingEnabled() {
        blockUntilConstructorFinished();
        return this.player.isTunnelingEnabled();
    }

    public void moveMediaItems(int i11, int i12, int i13) {
        blockUntilConstructorFinished();
        this.player.moveMediaItems(i11, i12, i13);
    }

    public void prepare() {
        blockUntilConstructorFinished();
        this.player.prepare();
    }

    public void release() {
        blockUntilConstructorFinished();
        this.player.release();
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        blockUntilConstructorFinished();
        this.player.removeAnalyticsListener(analyticsListener);
    }

    public void removeAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        blockUntilConstructorFinished();
        this.player.removeAudioOffloadListener(audioOffloadListener);
    }

    public void removeListener(Player.Listener listener) {
        blockUntilConstructorFinished();
        this.player.removeListener(listener);
    }

    public void removeMediaItems(int i11, int i12) {
        blockUntilConstructorFinished();
        this.player.removeMediaItems(i11, i12);
    }

    @Deprecated
    public void retry() {
        blockUntilConstructorFinished();
        this.player.retry();
    }

    @VisibleForTesting(otherwise = 4)
    public void seekTo(int i11, long j11, int i12, boolean z11) {
        blockUntilConstructorFinished();
        this.player.seekTo(i11, j11, i12, z11);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes, boolean z11) {
        blockUntilConstructorFinished();
        this.player.setAudioAttributes(audioAttributes, z11);
    }

    public void setAudioSessionId(int i11) {
        blockUntilConstructorFinished();
        this.player.setAudioSessionId(i11);
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        blockUntilConstructorFinished();
        this.player.setAuxEffectInfo(auxEffectInfo);
    }

    public void setCameraMotionListener(CameraMotionListener cameraMotionListener) {
        blockUntilConstructorFinished();
        this.player.setCameraMotionListener(cameraMotionListener);
    }

    public void setDeviceMuted(boolean z11) {
        blockUntilConstructorFinished();
        this.player.setDeviceMuted(z11);
    }

    public void setDeviceVolume(int i11) {
        blockUntilConstructorFinished();
        this.player.setDeviceVolume(i11);
    }

    public void setForegroundMode(boolean z11) {
        blockUntilConstructorFinished();
        this.player.setForegroundMode(z11);
    }

    public void setHandleAudioBecomingNoisy(boolean z11) {
        blockUntilConstructorFinished();
        this.player.setHandleAudioBecomingNoisy(z11);
    }

    @Deprecated
    public void setHandleWakeLock(boolean z11) {
        blockUntilConstructorFinished();
        this.player.setHandleWakeLock(z11);
    }

    public void setMediaItems(List<MediaItem> list, boolean z11) {
        blockUntilConstructorFinished();
        this.player.setMediaItems(list, z11);
    }

    public void setMediaSource(MediaSource mediaSource) {
        blockUntilConstructorFinished();
        this.player.setMediaSource(mediaSource);
    }

    public void setMediaSources(List<MediaSource> list) {
        blockUntilConstructorFinished();
        this.player.setMediaSources(list);
    }

    public void setPauseAtEndOfMediaItems(boolean z11) {
        blockUntilConstructorFinished();
        this.player.setPauseAtEndOfMediaItems(z11);
    }

    public void setPlayWhenReady(boolean z11) {
        blockUntilConstructorFinished();
        this.player.setPlayWhenReady(z11);
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        blockUntilConstructorFinished();
        this.player.setPlaybackParameters(playbackParameters);
    }

    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        blockUntilConstructorFinished();
        this.player.setPlaylistMetadata(mediaMetadata);
    }

    @RequiresApi(23)
    public void setPreferredAudioDevice(@Nullable AudioDeviceInfo audioDeviceInfo) {
        blockUntilConstructorFinished();
        this.player.setPreferredAudioDevice(audioDeviceInfo);
    }

    public void setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
        blockUntilConstructorFinished();
        this.player.setPriorityTaskManager(priorityTaskManager);
    }

    public void setRepeatMode(int i11) {
        blockUntilConstructorFinished();
        this.player.setRepeatMode(i11);
    }

    public void setSeekParameters(@Nullable SeekParameters seekParameters) {
        blockUntilConstructorFinished();
        this.player.setSeekParameters(seekParameters);
    }

    public void setShuffleModeEnabled(boolean z11) {
        blockUntilConstructorFinished();
        this.player.setShuffleModeEnabled(z11);
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        blockUntilConstructorFinished();
        this.player.setShuffleOrder(shuffleOrder);
    }

    public void setSkipSilenceEnabled(boolean z11) {
        blockUntilConstructorFinished();
        this.player.setSkipSilenceEnabled(z11);
    }

    public void setThrowsWhenUsingWrongThread(boolean z11) {
        blockUntilConstructorFinished();
        this.player.setThrowsWhenUsingWrongThread(z11);
    }

    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        blockUntilConstructorFinished();
        this.player.setTrackSelectionParameters(trackSelectionParameters);
    }

    public void setVideoChangeFrameRateStrategy(int i11) {
        blockUntilConstructorFinished();
        this.player.setVideoChangeFrameRateStrategy(i11);
    }

    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        blockUntilConstructorFinished();
        this.player.setVideoFrameMetadataListener(videoFrameMetadataListener);
    }

    public void setVideoScalingMode(int i11) {
        blockUntilConstructorFinished();
        this.player.setVideoScalingMode(i11);
    }

    public void setVideoSurface(@Nullable Surface surface) {
        blockUntilConstructorFinished();
        this.player.setVideoSurface(surface);
    }

    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        blockUntilConstructorFinished();
        this.player.setVideoSurfaceHolder(surfaceHolder);
    }

    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        blockUntilConstructorFinished();
        this.player.setVideoSurfaceView(surfaceView);
    }

    public void setVideoTextureView(@Nullable TextureView textureView) {
        blockUntilConstructorFinished();
        this.player.setVideoTextureView(textureView);
    }

    public void setVolume(float f11) {
        blockUntilConstructorFinished();
        this.player.setVolume(f11);
    }

    public void setWakeMode(int i11) {
        blockUntilConstructorFinished();
        this.player.setWakeMode(i11);
    }

    public void stop() {
        blockUntilConstructorFinished();
        this.player.stop();
    }

    @Deprecated
    public static final class Builder {
        /* access modifiers changed from: private */
        public final ExoPlayer.Builder wrappedBuilder;

        @Deprecated
        public Builder(Context context) {
            this.wrappedBuilder = new ExoPlayer.Builder(context);
        }

        @Deprecated
        public SimpleExoPlayer build() {
            return this.wrappedBuilder.buildSimpleExoPlayer();
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder experimentalSetForegroundModeTimeoutMs(long j11) {
            this.wrappedBuilder.experimentalSetForegroundModeTimeoutMs(j11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector) {
            this.wrappedBuilder.setAnalyticsCollector(analyticsCollector);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setAudioAttributes(AudioAttributes audioAttributes, boolean z11) {
            this.wrappedBuilder.setAudioAttributes(audioAttributes, z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
            this.wrappedBuilder.setBandwidthMeter(bandwidthMeter);
            return this;
        }

        @VisibleForTesting
        @CanIgnoreReturnValue
        @Deprecated
        public Builder setClock(Clock clock) {
            this.wrappedBuilder.setClock(clock);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDetachSurfaceTimeoutMs(long j11) {
            this.wrappedBuilder.setDetachSurfaceTimeoutMs(j11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setHandleAudioBecomingNoisy(boolean z11) {
            this.wrappedBuilder.setHandleAudioBecomingNoisy(z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            this.wrappedBuilder.setLivePlaybackSpeedControl(livePlaybackSpeedControl);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setLoadControl(LoadControl loadControl) {
            this.wrappedBuilder.setLoadControl(loadControl);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setLooper(Looper looper) {
            this.wrappedBuilder.setLooper(looper);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setMediaSourceFactory(MediaSource.Factory factory) {
            this.wrappedBuilder.setMediaSourceFactory(factory);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setPauseAtEndOfMediaItems(boolean z11) {
            this.wrappedBuilder.setPauseAtEndOfMediaItems(z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
            this.wrappedBuilder.setPriorityTaskManager(priorityTaskManager);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setReleaseTimeoutMs(long j11) {
            this.wrappedBuilder.setReleaseTimeoutMs(j11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setSeekBackIncrementMs(@IntRange(from = 1) long j11) {
            this.wrappedBuilder.setSeekBackIncrementMs(j11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setSeekForwardIncrementMs(@IntRange(from = 1) long j11) {
            this.wrappedBuilder.setSeekForwardIncrementMs(j11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setSeekParameters(SeekParameters seekParameters) {
            this.wrappedBuilder.setSeekParameters(seekParameters);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setSkipSilenceEnabled(boolean z11) {
            this.wrappedBuilder.setSkipSilenceEnabled(z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setTrackSelector(TrackSelector trackSelector) {
            this.wrappedBuilder.setTrackSelector(trackSelector);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setUseLazyPreparation(boolean z11) {
            this.wrappedBuilder.setUseLazyPreparation(z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setVideoChangeFrameRateStrategy(int i11) {
            this.wrappedBuilder.setVideoChangeFrameRateStrategy(i11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setVideoScalingMode(int i11) {
            this.wrappedBuilder.setVideoScalingMode(i11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setWakeMode(int i11) {
            this.wrappedBuilder.setWakeMode(i11);
            return this;
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory) {
            this.wrappedBuilder = new ExoPlayer.Builder(context, renderersFactory);
        }

        @Deprecated
        public Builder(Context context, ExtractorsFactory extractorsFactory) {
            this.wrappedBuilder = new ExoPlayer.Builder(context, (MediaSource.Factory) new DefaultMediaSourceFactory(context, extractorsFactory));
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory, ExtractorsFactory extractorsFactory) {
            this.wrappedBuilder = new ExoPlayer.Builder(context, renderersFactory, (MediaSource.Factory) new DefaultMediaSourceFactory(context, extractorsFactory));
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSource.Factory factory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
            this.wrappedBuilder = new ExoPlayer.Builder(context, renderersFactory, factory, trackSelector, loadControl, bandwidthMeter, analyticsCollector);
        }
    }

    @Nullable
    public ExoPlaybackException getPlayerError() {
        blockUntilConstructorFinished();
        return this.player.getPlayerError();
    }

    public void addMediaSource(int i11, MediaSource mediaSource) {
        blockUntilConstructorFinished();
        this.player.addMediaSource(i11, mediaSource);
    }

    public void addMediaSources(int i11, List<MediaSource> list) {
        blockUntilConstructorFinished();
        this.player.addMediaSources(i11, list);
    }

    public void clearVideoSurface(@Nullable Surface surface) {
        blockUntilConstructorFinished();
        this.player.clearVideoSurface(surface);
    }

    @Deprecated
    public void prepare(MediaSource mediaSource) {
        blockUntilConstructorFinished();
        this.player.prepare(mediaSource);
    }

    public void setMediaItems(List<MediaItem> list, int i11, long j11) {
        blockUntilConstructorFinished();
        this.player.setMediaItems(list, i11, j11);
    }

    public void setMediaSource(MediaSource mediaSource, boolean z11) {
        blockUntilConstructorFinished();
        this.player.setMediaSource(mediaSource, z11);
    }

    public void setMediaSources(List<MediaSource> list, boolean z11) {
        blockUntilConstructorFinished();
        this.player.setMediaSources(list, z11);
    }

    @Deprecated
    public void stop(boolean z11) {
        blockUntilConstructorFinished();
        this.player.stop(z11);
    }

    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z11, boolean z12) {
        blockUntilConstructorFinished();
        this.player.prepare(mediaSource, z11, z12);
    }

    public void setMediaSource(MediaSource mediaSource, long j11) {
        blockUntilConstructorFinished();
        this.player.setMediaSource(mediaSource, j11);
    }

    public void setMediaSources(List<MediaSource> list, int i11, long j11) {
        blockUntilConstructorFinished();
        this.player.setMediaSources(list, i11, j11);
    }

    public SimpleExoPlayer(Builder builder) {
        this(builder.wrappedBuilder);
    }

    public SimpleExoPlayer(ExoPlayer.Builder builder) {
        ConditionVariable conditionVariable = new ConditionVariable();
        this.constructorFinished = conditionVariable;
        try {
            this.player = new ExoPlayerImpl(builder, this);
            conditionVariable.open();
        } catch (Throwable th2) {
            this.constructorFinished.open();
            throw th2;
        }
    }
}
