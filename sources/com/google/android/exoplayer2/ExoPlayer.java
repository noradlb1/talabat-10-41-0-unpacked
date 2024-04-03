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
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import g7.a0;
import g7.b0;
import g7.c0;
import g7.d0;
import g7.e0;
import g7.f0;
import g7.g0;
import g7.h0;
import g7.i0;
import g7.l;
import g7.m;
import g7.n;
import g7.o;
import g7.p;
import g7.q;
import g7.r;
import g7.s;
import g7.t;
import g7.u;
import g7.v;
import g7.w;
import g7.x;
import g7.y;
import g7.z;
import java.util.List;

public interface ExoPlayer extends Player {
    public static final long DEFAULT_DETACH_SURFACE_TIMEOUT_MS = 2000;
    public static final long DEFAULT_RELEASE_TIMEOUT_MS = 500;

    @Deprecated
    public interface AudioComponent {
        @Deprecated
        void clearAuxEffectInfo();

        @Deprecated
        AudioAttributes getAudioAttributes();

        @Deprecated
        int getAudioSessionId();

        @Deprecated
        boolean getSkipSilenceEnabled();

        @Deprecated
        float getVolume();

        @Deprecated
        void setAudioAttributes(AudioAttributes audioAttributes, boolean z11);

        @Deprecated
        void setAudioSessionId(int i11);

        @Deprecated
        void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

        @Deprecated
        void setSkipSilenceEnabled(boolean z11);

        @Deprecated
        void setVolume(float f11);
    }

    public interface AudioOffloadListener {
        void onExperimentalOffloadSchedulingEnabledChanged(boolean z11);

        void onExperimentalOffloadedPlayback(boolean z11);

        void onExperimentalSleepingForOffloadChanged(boolean z11);
    }

    public static final class Builder {
        Function<Clock, AnalyticsCollector> analyticsCollectorFunction;
        AudioAttributes audioAttributes;
        Supplier<BandwidthMeter> bandwidthMeterSupplier;
        boolean buildCalled;
        Clock clock;
        final Context context;
        long detachSurfaceTimeoutMs;
        long foregroundModeTimeoutMs;
        boolean handleAudioBecomingNoisy;
        boolean handleAudioFocus;
        LivePlaybackSpeedControl livePlaybackSpeedControl;
        Supplier<LoadControl> loadControlSupplier;
        Looper looper;
        Supplier<MediaSource.Factory> mediaSourceFactorySupplier;
        boolean pauseAtEndOfMediaItems;
        @Nullable
        Looper playbackLooper;
        @Nullable
        PriorityTaskManager priorityTaskManager;
        long releaseTimeoutMs;
        Supplier<RenderersFactory> renderersFactorySupplier;
        long seekBackIncrementMs;
        long seekForwardIncrementMs;
        SeekParameters seekParameters;
        boolean skipSilenceEnabled;
        Supplier<TrackSelector> trackSelectorSupplier;
        boolean useLazyPreparation;
        boolean usePlatformDiagnostics;
        int videoChangeFrameRateStrategy;
        int videoScalingMode;
        int wakeMode;

        public Builder(Context context2) {
            this(context2, (Supplier<RenderersFactory>) new i0(context2), (Supplier<MediaSource.Factory>) new m(context2));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$new$0(Context context2) {
            return new DefaultRenderersFactory(context2);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$new$1(Context context2) {
            return new DefaultMediaSourceFactory(context2, (ExtractorsFactory) new DefaultExtractorsFactory());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ TrackSelector lambda$new$10(TrackSelector trackSelector) {
            return trackSelector;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ LoadControl lambda$new$11(LoadControl loadControl) {
            return loadControl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ BandwidthMeter lambda$new$12(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ AnalyticsCollector lambda$new$13(AnalyticsCollector analyticsCollector, Clock clock2) {
            return analyticsCollector;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ TrackSelector lambda$new$14(Context context2) {
            return new DefaultTrackSelector(context2);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$new$2(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$new$3(Context context2) {
            return new DefaultMediaSourceFactory(context2, (ExtractorsFactory) new DefaultExtractorsFactory());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$new$4(Context context2) {
            return new DefaultRenderersFactory(context2);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$new$5(MediaSource.Factory factory) {
            return factory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$new$6(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$new$7(MediaSource.Factory factory) {
            return factory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$new$8(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$new$9(MediaSource.Factory factory) {
            return factory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ AnalyticsCollector lambda$setAnalyticsCollector$21(AnalyticsCollector analyticsCollector, Clock clock2) {
            return analyticsCollector;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ BandwidthMeter lambda$setBandwidthMeter$20(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ LoadControl lambda$setLoadControl$19(LoadControl loadControl) {
            return loadControl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory lambda$setMediaSourceFactory$17(MediaSource.Factory factory) {
            return factory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory lambda$setRenderersFactory$16(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ TrackSelector lambda$setTrackSelector$18(TrackSelector trackSelector) {
            return trackSelector;
        }

        public ExoPlayer build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new ExoPlayerImpl(this, (Player) null);
        }

        public SimpleExoPlayer buildSimpleExoPlayer() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new SimpleExoPlayer(this);
        }

        @CanIgnoreReturnValue
        public Builder experimentalSetForegroundModeTimeoutMs(long j11) {
            Assertions.checkState(!this.buildCalled);
            this.foregroundModeTimeoutMs = j11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(analyticsCollector);
            this.analyticsCollectorFunction = new w(analyticsCollector);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setAudioAttributes(AudioAttributes audioAttributes2, boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.audioAttributes = (AudioAttributes) Assertions.checkNotNull(audioAttributes2);
            this.handleAudioFocus = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(bandwidthMeter);
            this.bandwidthMeterSupplier = new b0(bandwidthMeter);
            return this;
        }

        @VisibleForTesting
        @CanIgnoreReturnValue
        public Builder setClock(Clock clock2) {
            Assertions.checkState(!this.buildCalled);
            this.clock = clock2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDetachSurfaceTimeoutMs(long j11) {
            Assertions.checkState(!this.buildCalled);
            this.detachSurfaceTimeoutMs = j11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setHandleAudioBecomingNoisy(boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.handleAudioBecomingNoisy = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl2) {
            Assertions.checkState(!this.buildCalled);
            this.livePlaybackSpeedControl = (LivePlaybackSpeedControl) Assertions.checkNotNull(livePlaybackSpeedControl2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setLoadControl(LoadControl loadControl) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(loadControl);
            this.loadControlSupplier = new d0(loadControl);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setLooper(Looper looper2) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(looper2);
            this.looper = looper2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMediaSourceFactory(MediaSource.Factory factory) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(factory);
            this.mediaSourceFactorySupplier = new c0(factory);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPauseAtEndOfMediaItems(boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.pauseAtEndOfMediaItems = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlaybackLooper(Looper looper2) {
            Assertions.checkState(!this.buildCalled);
            this.playbackLooper = looper2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager2) {
            Assertions.checkState(!this.buildCalled);
            this.priorityTaskManager = priorityTaskManager2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setReleaseTimeoutMs(long j11) {
            Assertions.checkState(!this.buildCalled);
            this.releaseTimeoutMs = j11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setRenderersFactory(RenderersFactory renderersFactory) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(renderersFactory);
            this.renderersFactorySupplier = new n(renderersFactory);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSeekBackIncrementMs(@IntRange(from = 1) long j11) {
            boolean z11;
            if (j11 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkArgument(z11);
            Assertions.checkState(!this.buildCalled);
            this.seekBackIncrementMs = j11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSeekForwardIncrementMs(@IntRange(from = 1) long j11) {
            boolean z11;
            if (j11 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkArgument(z11);
            Assertions.checkState(!this.buildCalled);
            this.seekForwardIncrementMs = j11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSeekParameters(SeekParameters seekParameters2) {
            Assertions.checkState(!this.buildCalled);
            this.seekParameters = (SeekParameters) Assertions.checkNotNull(seekParameters2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSkipSilenceEnabled(boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.skipSilenceEnabled = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTrackSelector(TrackSelector trackSelector) {
            Assertions.checkState(!this.buildCalled);
            Assertions.checkNotNull(trackSelector);
            this.trackSelectorSupplier = new l(trackSelector);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUseLazyPreparation(boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.useLazyPreparation = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUsePlatformDiagnostics(boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.usePlatformDiagnostics = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setVideoChangeFrameRateStrategy(int i11) {
            Assertions.checkState(!this.buildCalled);
            this.videoChangeFrameRateStrategy = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setVideoScalingMode(int i11) {
            Assertions.checkState(!this.buildCalled);
            this.videoScalingMode = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setWakeMode(int i11) {
            Assertions.checkState(!this.buildCalled);
            this.wakeMode = i11;
            return this;
        }

        public Builder(Context context2, RenderersFactory renderersFactory) {
            this(context2, (Supplier<RenderersFactory>) new s(renderersFactory), (Supplier<MediaSource.Factory>) new t(context2));
            Assertions.checkNotNull(renderersFactory);
        }

        public Builder(Context context2, MediaSource.Factory factory) {
            this(context2, (Supplier<RenderersFactory>) new o(context2), (Supplier<MediaSource.Factory>) new p(factory));
            Assertions.checkNotNull(factory);
        }

        public Builder(Context context2, RenderersFactory renderersFactory, MediaSource.Factory factory) {
            this(context2, (Supplier<RenderersFactory>) new q(renderersFactory), (Supplier<MediaSource.Factory>) new r(factory));
            Assertions.checkNotNull(renderersFactory);
            Assertions.checkNotNull(factory);
        }

        public Builder(Context context2, RenderersFactory renderersFactory, MediaSource.Factory factory, TrackSelector trackSelector, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
            this(context2, (Supplier<RenderersFactory>) new u(renderersFactory), (Supplier<MediaSource.Factory>) new v(factory), (Supplier<TrackSelector>) new x(trackSelector), (Supplier<LoadControl>) new y(loadControl), (Supplier<BandwidthMeter>) new z(bandwidthMeter), (Function<Clock, AnalyticsCollector>) new a0(analyticsCollector));
            Assertions.checkNotNull(renderersFactory);
            Assertions.checkNotNull(factory);
            Assertions.checkNotNull(trackSelector);
            Assertions.checkNotNull(bandwidthMeter);
            Assertions.checkNotNull(analyticsCollector);
        }

        private Builder(Context context2, Supplier<RenderersFactory> supplier, Supplier<MediaSource.Factory> supplier2) {
            this(context2, supplier, supplier2, (Supplier<TrackSelector>) new e0(context2), (Supplier<LoadControl>) new f0(), (Supplier<BandwidthMeter>) new g0(context2), (Function<Clock, AnalyticsCollector>) new h0());
        }

        private Builder(Context context2, Supplier<RenderersFactory> supplier, Supplier<MediaSource.Factory> supplier2, Supplier<TrackSelector> supplier3, Supplier<LoadControl> supplier4, Supplier<BandwidthMeter> supplier5, Function<Clock, AnalyticsCollector> function) {
            this.context = (Context) Assertions.checkNotNull(context2);
            this.renderersFactorySupplier = supplier;
            this.mediaSourceFactorySupplier = supplier2;
            this.trackSelectorSupplier = supplier3;
            this.loadControlSupplier = supplier4;
            this.bandwidthMeterSupplier = supplier5;
            this.analyticsCollectorFunction = function;
            this.looper = Util.getCurrentOrMainLooper();
            this.audioAttributes = AudioAttributes.DEFAULT;
            this.wakeMode = 0;
            this.videoScalingMode = 1;
            this.videoChangeFrameRateStrategy = 0;
            this.useLazyPreparation = true;
            this.seekParameters = SeekParameters.DEFAULT;
            this.seekBackIncrementMs = 5000;
            this.seekForwardIncrementMs = 15000;
            this.livePlaybackSpeedControl = new DefaultLivePlaybackSpeedControl.Builder().build();
            this.clock = Clock.DEFAULT;
            this.releaseTimeoutMs = 500;
            this.detachSurfaceTimeoutMs = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
            this.usePlatformDiagnostics = true;
        }
    }

    @Deprecated
    public interface DeviceComponent {
        @Deprecated
        void decreaseDeviceVolume();

        @Deprecated
        DeviceInfo getDeviceInfo();

        @Deprecated
        int getDeviceVolume();

        @Deprecated
        void increaseDeviceVolume();

        @Deprecated
        boolean isDeviceMuted();

        @Deprecated
        void setDeviceMuted(boolean z11);

        @Deprecated
        void setDeviceVolume(int i11);
    }

    @Deprecated
    public interface TextComponent {
        @Deprecated
        CueGroup getCurrentCues();
    }

    @Deprecated
    public interface VideoComponent {
        @Deprecated
        void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

        @Deprecated
        void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void clearVideoSurface();

        @Deprecated
        void clearVideoSurface(@Nullable Surface surface);

        @Deprecated
        void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        void clearVideoSurfaceView(@Nullable SurfaceView surfaceView);

        @Deprecated
        void clearVideoTextureView(@Nullable TextureView textureView);

        @Deprecated
        int getVideoChangeFrameRateStrategy();

        @Deprecated
        int getVideoScalingMode();

        @Deprecated
        VideoSize getVideoSize();

        @Deprecated
        void setCameraMotionListener(CameraMotionListener cameraMotionListener);

        @Deprecated
        void setVideoChangeFrameRateStrategy(int i11);

        @Deprecated
        void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void setVideoScalingMode(int i11);

        @Deprecated
        void setVideoSurface(@Nullable Surface surface);

        @Deprecated
        void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        void setVideoSurfaceView(@Nullable SurfaceView surfaceView);

        @Deprecated
        void setVideoTextureView(@Nullable TextureView textureView);
    }

    void addAnalyticsListener(AnalyticsListener analyticsListener);

    void addAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    void addMediaSource(int i11, MediaSource mediaSource);

    void addMediaSource(MediaSource mediaSource);

    void addMediaSources(int i11, List<MediaSource> list);

    void addMediaSources(List<MediaSource> list);

    void clearAuxEffectInfo();

    void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

    void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    PlayerMessage createMessage(PlayerMessage.Target target);

    boolean experimentalIsSleepingForOffload();

    void experimentalSetOffloadSchedulingEnabled(boolean z11);

    AnalyticsCollector getAnalyticsCollector();

    @Deprecated
    @Nullable
    AudioComponent getAudioComponent();

    @Nullable
    DecoderCounters getAudioDecoderCounters();

    @Nullable
    Format getAudioFormat();

    int getAudioSessionId();

    Clock getClock();

    @Deprecated
    TrackGroupArray getCurrentTrackGroups();

    @Deprecated
    TrackSelectionArray getCurrentTrackSelections();

    @Deprecated
    @Nullable
    DeviceComponent getDeviceComponent();

    boolean getPauseAtEndOfMediaItems();

    Looper getPlaybackLooper();

    @Nullable
    ExoPlaybackException getPlayerError();

    @Nullable
    /* bridge */ /* synthetic */ PlaybackException getPlayerError();

    Renderer getRenderer(int i11);

    int getRendererCount();

    int getRendererType(int i11);

    SeekParameters getSeekParameters();

    boolean getSkipSilenceEnabled();

    @Deprecated
    @Nullable
    TextComponent getTextComponent();

    @Nullable
    TrackSelector getTrackSelector();

    int getVideoChangeFrameRateStrategy();

    @Deprecated
    @Nullable
    VideoComponent getVideoComponent();

    @Nullable
    DecoderCounters getVideoDecoderCounters();

    @Nullable
    Format getVideoFormat();

    int getVideoScalingMode();

    boolean isTunnelingEnabled();

    @Deprecated
    void prepare(MediaSource mediaSource);

    @Deprecated
    void prepare(MediaSource mediaSource, boolean z11, boolean z12);

    void removeAnalyticsListener(AnalyticsListener analyticsListener);

    void removeAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    @Deprecated
    void retry();

    void setAudioAttributes(AudioAttributes audioAttributes, boolean z11);

    void setAudioSessionId(int i11);

    void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

    void setCameraMotionListener(CameraMotionListener cameraMotionListener);

    void setForegroundMode(boolean z11);

    void setHandleAudioBecomingNoisy(boolean z11);

    @Deprecated
    void setHandleWakeLock(boolean z11);

    void setMediaSource(MediaSource mediaSource);

    void setMediaSource(MediaSource mediaSource, long j11);

    void setMediaSource(MediaSource mediaSource, boolean z11);

    void setMediaSources(List<MediaSource> list);

    void setMediaSources(List<MediaSource> list, int i11, long j11);

    void setMediaSources(List<MediaSource> list, boolean z11);

    void setPauseAtEndOfMediaItems(boolean z11);

    @RequiresApi(23)
    void setPreferredAudioDevice(@Nullable AudioDeviceInfo audioDeviceInfo);

    void setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager);

    void setSeekParameters(@Nullable SeekParameters seekParameters);

    void setShuffleOrder(ShuffleOrder shuffleOrder);

    void setSkipSilenceEnabled(boolean z11);

    void setVideoChangeFrameRateStrategy(int i11);

    void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    void setVideoScalingMode(int i11);

    void setWakeMode(int i11);
}
