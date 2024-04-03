package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.AudioBecomingNoisyManager;
import com.google.android.exoplayer2.AudioFocusManager;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.StreamVolumeManager;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.analytics.MediaMetricsListener;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Size;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import g7.j0;
import g7.k;
import g7.l0;
import i7.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import o8.g;

final class ExoPlayerImpl extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {
    private static final String TAG = "ExoPlayerImpl";
    /* access modifiers changed from: private */
    public final AnalyticsCollector analyticsCollector;
    private final Context applicationContext;
    private final Looper applicationLooper;
    private AudioAttributes audioAttributes;
    private final AudioBecomingNoisyManager audioBecomingNoisyManager;
    /* access modifiers changed from: private */
    @Nullable
    public DecoderCounters audioDecoderCounters;
    private final AudioFocusManager audioFocusManager;
    /* access modifiers changed from: private */
    @Nullable
    public Format audioFormat;
    private final CopyOnWriteArraySet<ExoPlayer.AudioOffloadListener> audioOffloadListeners;
    private int audioSessionId;
    private Player.Commands availableCommands;
    private final BandwidthMeter bandwidthMeter;
    @Nullable
    private CameraMotionListener cameraMotionListener;
    private final Clock clock;
    private final ComponentListener componentListener;
    private final ConditionVariable constructorFinished;
    /* access modifiers changed from: private */
    public CueGroup currentCueGroup;
    private final long detachSurfaceTimeoutMs;
    /* access modifiers changed from: private */
    public DeviceInfo deviceInfo;
    final TrackSelectorResult emptyTrackSelectorResult;
    private boolean foregroundMode;
    private final FrameMetadataListener frameMetadataListener;
    private boolean hasNotifiedFullWrongThreadWarning;
    private final ExoPlayerImplInternal internalPlayer;
    private boolean isPriorityTaskManagerRegistered;
    @Nullable
    private AudioTrack keepSessionIdAudioTrack;
    /* access modifiers changed from: private */
    public final ListenerSet<Player.Listener> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    /* access modifiers changed from: private */
    public MediaMetadata mediaMetadata;
    private final MediaSource.Factory mediaSourceFactory;
    private final List<MediaSourceHolderSnapshot> mediaSourceHolderSnapshots;
    @Nullable
    private Surface ownedSurface;
    private boolean pauseAtEndOfMediaItems;
    private boolean pendingDiscontinuity;
    private int pendingDiscontinuityReason;
    private int pendingOperationAcks;
    private int pendingPlayWhenReadyChangeReason;
    private final Timeline.Period period;
    final Player.Commands permanentAvailableCommands;
    private PlaybackInfo playbackInfo;
    private final HandlerWrapper playbackInfoUpdateHandler;
    private final ExoPlayerImplInternal.PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private boolean playerReleased;
    private MediaMetadata playlistMetadata;
    @Nullable
    private PriorityTaskManager priorityTaskManager;
    private final Renderer[] renderers;
    private int repeatMode;
    private final long seekBackIncrementMs;
    private final long seekForwardIncrementMs;
    private SeekParameters seekParameters;
    private boolean shuffleModeEnabled;
    private ShuffleOrder shuffleOrder;
    /* access modifiers changed from: private */
    public boolean skipSilenceEnabled;
    @Nullable
    private SphericalGLSurfaceView sphericalGLSurfaceView;
    /* access modifiers changed from: private */
    public MediaMetadata staticAndDynamicMediaMetadata;
    /* access modifiers changed from: private */
    public final StreamVolumeManager streamVolumeManager;
    @Nullable
    private SurfaceHolder surfaceHolder;
    /* access modifiers changed from: private */
    public boolean surfaceHolderSurfaceIsVideoOutput;
    private Size surfaceSize;
    @Nullable
    private TextureView textureView;
    private boolean throwsWhenUsingWrongThread;
    private final TrackSelector trackSelector;
    private final boolean useLazyPreparation;
    private int videoChangeFrameRateStrategy;
    /* access modifiers changed from: private */
    @Nullable
    public DecoderCounters videoDecoderCounters;
    /* access modifiers changed from: private */
    @Nullable
    public Format videoFormat;
    @Nullable
    private VideoFrameMetadataListener videoFrameMetadataListener;
    /* access modifiers changed from: private */
    @Nullable
    public Object videoOutput;
    private int videoScalingMode;
    /* access modifiers changed from: private */
    public VideoSize videoSize;
    private float volume;
    private final WakeLockManager wakeLockManager;
    private final WifiLockManager wifiLockManager;
    private final Player wrappingPlayer;

    @RequiresApi(31)
    public static final class Api31 {
        private Api31() {
        }

        @DoNotInline
        public static PlayerId registerMediaMetricsListener(Context context, ExoPlayerImpl exoPlayerImpl, boolean z11) {
            MediaMetricsListener create = MediaMetricsListener.create(context);
            if (create == null) {
                Log.w(ExoPlayerImpl.TAG, "MediaMetricsService unavailable.");
                return new PlayerId(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z11) {
                exoPlayerImpl.addAnalyticsListener(create);
            }
            return new PlayerId(create.getLogSessionId());
        }
    }

    public final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.VideoSurfaceListener, AudioFocusManager.PlayerControl, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, ExoPlayer.AudioOffloadListener {
        private ComponentListener() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onMetadata$4(Player.Listener listener) {
            listener.onMediaMetadataChanged(ExoPlayerImpl.this.mediaMetadata);
        }

        public void executePlayerCommand(int i11) {
            boolean playWhenReady = ExoPlayerImpl.this.getPlayWhenReady();
            ExoPlayerImpl.this.updatePlayWhenReady(playWhenReady, i11, ExoPlayerImpl.getPlayWhenReadyChangeReason(playWhenReady, i11));
        }

        public void onAudioBecomingNoisy() {
            ExoPlayerImpl.this.updatePlayWhenReady(false, -1, 3);
        }

        public void onAudioCodecError(Exception exc) {
            ExoPlayerImpl.this.analyticsCollector.onAudioCodecError(exc);
        }

        public void onAudioDecoderInitialized(String str, long j11, long j12) {
            ExoPlayerImpl.this.analyticsCollector.onAudioDecoderInitialized(str, j11, j12);
        }

        public void onAudioDecoderReleased(String str) {
            ExoPlayerImpl.this.analyticsCollector.onAudioDecoderReleased(str);
        }

        public void onAudioDisabled(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.analyticsCollector.onAudioDisabled(decoderCounters);
            Format unused = ExoPlayerImpl.this.audioFormat = null;
            DecoderCounters unused2 = ExoPlayerImpl.this.audioDecoderCounters = null;
        }

        public void onAudioEnabled(DecoderCounters decoderCounters) {
            DecoderCounters unused = ExoPlayerImpl.this.audioDecoderCounters = decoderCounters;
            ExoPlayerImpl.this.analyticsCollector.onAudioEnabled(decoderCounters);
        }

        public /* synthetic */ void onAudioInputFormatChanged(Format format) {
            d.f(this, format);
        }

        public void onAudioInputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = ExoPlayerImpl.this.audioFormat = format;
            ExoPlayerImpl.this.analyticsCollector.onAudioInputFormatChanged(format, decoderReuseEvaluation);
        }

        public void onAudioPositionAdvancing(long j11) {
            ExoPlayerImpl.this.analyticsCollector.onAudioPositionAdvancing(j11);
        }

        public void onAudioSinkError(Exception exc) {
            ExoPlayerImpl.this.analyticsCollector.onAudioSinkError(exc);
        }

        public void onAudioUnderrun(int i11, long j11, long j12) {
            ExoPlayerImpl.this.analyticsCollector.onAudioUnderrun(i11, j11, j12);
        }

        public void onCues(List<Cue> list) {
            ExoPlayerImpl.this.listeners.sendEvent(27, new g0(list));
        }

        public void onDroppedFrames(int i11, long j11) {
            ExoPlayerImpl.this.analyticsCollector.onDroppedFrames(i11, j11);
        }

        public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z11) {
            k.a(this, z11);
        }

        public /* synthetic */ void onExperimentalOffloadedPlayback(boolean z11) {
            k.b(this, z11);
        }

        public void onExperimentalSleepingForOffloadChanged(boolean z11) {
            ExoPlayerImpl.this.updateWakeAndWifiLock();
        }

        public void onMetadata(Metadata metadata) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            MediaMetadata unused = exoPlayerImpl.staticAndDynamicMediaMetadata = exoPlayerImpl.staticAndDynamicMediaMetadata.buildUpon().populateFromMetadata(metadata).build();
            MediaMetadata access$1400 = ExoPlayerImpl.this.buildUpdatedMediaMetadata();
            if (!access$1400.equals(ExoPlayerImpl.this.mediaMetadata)) {
                MediaMetadata unused2 = ExoPlayerImpl.this.mediaMetadata = access$1400;
                ExoPlayerImpl.this.listeners.queueEvent(14, new e0(this));
            }
            ExoPlayerImpl.this.listeners.queueEvent(28, new f0(metadata));
            ExoPlayerImpl.this.listeners.flushEvents();
        }

        public void onRenderedFirstFrame(Object obj, long j11) {
            ExoPlayerImpl.this.analyticsCollector.onRenderedFirstFrame(obj, j11);
            if (ExoPlayerImpl.this.videoOutput == obj) {
                ExoPlayerImpl.this.listeners.sendEvent(26, new l0());
            }
        }

        public void onSkipSilenceEnabledChanged(boolean z11) {
            if (ExoPlayerImpl.this.skipSilenceEnabled != z11) {
                boolean unused = ExoPlayerImpl.this.skipSilenceEnabled = z11;
                ExoPlayerImpl.this.listeners.sendEvent(23, new i0(z11));
            }
        }

        public void onStreamTypeChanged(int i11) {
            DeviceInfo access$2400 = ExoPlayerImpl.createDeviceInfo(ExoPlayerImpl.this.streamVolumeManager);
            if (!access$2400.equals(ExoPlayerImpl.this.deviceInfo)) {
                DeviceInfo unused = ExoPlayerImpl.this.deviceInfo = access$2400;
                ExoPlayerImpl.this.listeners.sendEvent(29, new h0(access$2400));
            }
        }

        public void onStreamVolumeChanged(int i11, boolean z11) {
            ExoPlayerImpl.this.listeners.sendEvent(30, new j0(i11, z11));
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            ExoPlayerImpl.this.setSurfaceTextureInternal(surfaceTexture);
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(i11, i12);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ExoPlayerImpl.this.setVideoOutputInternal((Object) null);
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(0, 0);
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(i11, i12);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void onVideoCodecError(Exception exc) {
            ExoPlayerImpl.this.analyticsCollector.onVideoCodecError(exc);
        }

        public void onVideoDecoderInitialized(String str, long j11, long j12) {
            ExoPlayerImpl.this.analyticsCollector.onVideoDecoderInitialized(str, j11, j12);
        }

        public void onVideoDecoderReleased(String str) {
            ExoPlayerImpl.this.analyticsCollector.onVideoDecoderReleased(str);
        }

        public void onVideoDisabled(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.analyticsCollector.onVideoDisabled(decoderCounters);
            Format unused = ExoPlayerImpl.this.videoFormat = null;
            DecoderCounters unused2 = ExoPlayerImpl.this.videoDecoderCounters = null;
        }

        public void onVideoEnabled(DecoderCounters decoderCounters) {
            DecoderCounters unused = ExoPlayerImpl.this.videoDecoderCounters = decoderCounters;
            ExoPlayerImpl.this.analyticsCollector.onVideoEnabled(decoderCounters);
        }

        public void onVideoFrameProcessingOffset(long j11, int i11) {
            ExoPlayerImpl.this.analyticsCollector.onVideoFrameProcessingOffset(j11, i11);
        }

        public /* synthetic */ void onVideoInputFormatChanged(Format format) {
            g.i(this, format);
        }

        public void onVideoInputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = ExoPlayerImpl.this.videoFormat = format;
            ExoPlayerImpl.this.analyticsCollector.onVideoInputFormatChanged(format, decoderReuseEvaluation);
        }

        public void onVideoSizeChanged(VideoSize videoSize) {
            VideoSize unused = ExoPlayerImpl.this.videoSize = videoSize;
            ExoPlayerImpl.this.listeners.sendEvent(25, new l0(videoSize));
        }

        public void onVideoSurfaceCreated(Surface surface) {
            ExoPlayerImpl.this.setVideoOutputInternal(surface);
        }

        public void onVideoSurfaceDestroyed(Surface surface) {
            ExoPlayerImpl.this.setVideoOutputInternal((Object) null);
        }

        public void setVolumeMultiplier(float f11) {
            ExoPlayerImpl.this.sendVolumeToRenderers();
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(i12, i13);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.surfaceHolderSurfaceIsVideoOutput) {
                ExoPlayerImpl.this.setVideoOutputInternal(surfaceHolder.getSurface());
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.surfaceHolderSurfaceIsVideoOutput) {
                ExoPlayerImpl.this.setVideoOutputInternal((Object) null);
            }
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(0, 0);
        }

        public void onCues(CueGroup cueGroup) {
            CueGroup unused = ExoPlayerImpl.this.currentCueGroup = cueGroup;
            ExoPlayerImpl.this.listeners.sendEvent(27, new k0(cueGroup));
        }
    }

    public static final class FrameMetadataListener implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.Target {
        public static final int MSG_SET_CAMERA_MOTION_LISTENER = 8;
        public static final int MSG_SET_SPHERICAL_SURFACE_VIEW = 10000;
        public static final int MSG_SET_VIDEO_FRAME_METADATA_LISTENER = 7;
        @Nullable
        private CameraMotionListener cameraMotionListener;
        @Nullable
        private CameraMotionListener internalCameraMotionListener;
        @Nullable
        private VideoFrameMetadataListener internalVideoFrameMetadataListener;
        @Nullable
        private VideoFrameMetadataListener videoFrameMetadataListener;

        private FrameMetadataListener() {
        }

        public void handleMessage(int i11, @Nullable Object obj) {
            if (i11 == 7) {
                this.videoFrameMetadataListener = (VideoFrameMetadataListener) obj;
            } else if (i11 == 8) {
                this.cameraMotionListener = (CameraMotionListener) obj;
            } else if (i11 == 10000) {
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
                if (sphericalGLSurfaceView == null) {
                    this.internalVideoFrameMetadataListener = null;
                    this.internalCameraMotionListener = null;
                    return;
                }
                this.internalVideoFrameMetadataListener = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.internalCameraMotionListener = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }

        public void onCameraMotion(long j11, float[] fArr) {
            CameraMotionListener cameraMotionListener2 = this.internalCameraMotionListener;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.onCameraMotion(j11, fArr);
            }
            CameraMotionListener cameraMotionListener3 = this.cameraMotionListener;
            if (cameraMotionListener3 != null) {
                cameraMotionListener3.onCameraMotion(j11, fArr);
            }
        }

        public void onCameraMotionReset() {
            CameraMotionListener cameraMotionListener2 = this.internalCameraMotionListener;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.onCameraMotionReset();
            }
            CameraMotionListener cameraMotionListener3 = this.cameraMotionListener;
            if (cameraMotionListener3 != null) {
                cameraMotionListener3.onCameraMotionReset();
            }
        }

        public void onVideoFrameAboutToBeRendered(long j11, long j12, Format format, @Nullable MediaFormat mediaFormat) {
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.internalVideoFrameMetadataListener;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.onVideoFrameAboutToBeRendered(j11, j12, format, mediaFormat);
            }
            VideoFrameMetadataListener videoFrameMetadataListener3 = this.videoFrameMetadataListener;
            if (videoFrameMetadataListener3 != null) {
                videoFrameMetadataListener3.onVideoFrameAboutToBeRendered(j11, j12, format, mediaFormat);
            }
        }
    }

    public static final class MediaSourceHolderSnapshot implements MediaSourceInfoHolder {
        /* access modifiers changed from: private */
        public Timeline timeline;
        private final Object uid;

        public MediaSourceHolderSnapshot(Object obj, Timeline timeline2) {
            this.uid = obj;
            this.timeline = timeline2;
        }

        public Timeline getTimeline() {
            return this.timeline;
        }

        public Object getUid() {
            return this.uid;
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.exoplayer");
    }

    /* JADX WARNING: type inference failed for: r40v0, types: [com.google.android.exoplayer2.Player] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.annotation.SuppressLint({"HandlerLeak"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExoPlayerImpl(com.google.android.exoplayer2.ExoPlayer.Builder r39, @androidx.annotation.Nullable com.google.android.exoplayer2.Player r40) {
        /*
            r38 = this;
            r1 = r38
            r0 = r39
            r38.<init>()
            com.google.android.exoplayer2.util.ConditionVariable r2 = new com.google.android.exoplayer2.util.ConditionVariable
            r2.<init>()
            r1.constructorFinished = r2
            java.lang.String r3 = "ExoPlayerImpl"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0348 }
            r4.<init>()     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = "Init "
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            int r5 = java.lang.System.identityHashCode(r38)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = java.lang.Integer.toHexString(r5)     // Catch:{ all -> 0x0348 }
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = " ["
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = "ExoPlayerLib/2.18.7"
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = "] ["
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO     // Catch:{ all -> 0x0348 }
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = "]"
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.Log.i(r3, r4)     // Catch:{ all -> 0x0348 }
            android.content.Context r3 = r0.context     // Catch:{ all -> 0x0348 }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0348 }
            r1.applicationContext = r3     // Catch:{ all -> 0x0348 }
            com.google.common.base.Function<com.google.android.exoplayer2.util.Clock, com.google.android.exoplayer2.analytics.AnalyticsCollector> r4 = r0.analyticsCollectorFunction     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.Clock r5 = r0.clock     // Catch:{ all -> 0x0348 }
            java.lang.Object r4 = r4.apply(r5)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.analytics.AnalyticsCollector r4 = (com.google.android.exoplayer2.analytics.AnalyticsCollector) r4     // Catch:{ all -> 0x0348 }
            r1.analyticsCollector = r4     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.PriorityTaskManager r5 = r0.priorityTaskManager     // Catch:{ all -> 0x0348 }
            r1.priorityTaskManager = r5     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.audio.AudioAttributes r5 = r0.audioAttributes     // Catch:{ all -> 0x0348 }
            r1.audioAttributes = r5     // Catch:{ all -> 0x0348 }
            int r5 = r0.videoScalingMode     // Catch:{ all -> 0x0348 }
            r1.videoScalingMode = r5     // Catch:{ all -> 0x0348 }
            int r5 = r0.videoChangeFrameRateStrategy     // Catch:{ all -> 0x0348 }
            r1.videoChangeFrameRateStrategy = r5     // Catch:{ all -> 0x0348 }
            boolean r5 = r0.skipSilenceEnabled     // Catch:{ all -> 0x0348 }
            r1.skipSilenceEnabled = r5     // Catch:{ all -> 0x0348 }
            long r5 = r0.detachSurfaceTimeoutMs     // Catch:{ all -> 0x0348 }
            r1.detachSurfaceTimeoutMs = r5     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.ExoPlayerImpl$ComponentListener r15 = new com.google.android.exoplayer2.ExoPlayerImpl$ComponentListener     // Catch:{ all -> 0x0348 }
            r14 = 0
            r15.<init>()     // Catch:{ all -> 0x0348 }
            r1.componentListener = r15     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.ExoPlayerImpl$FrameMetadataListener r13 = new com.google.android.exoplayer2.ExoPlayerImpl$FrameMetadataListener     // Catch:{ all -> 0x0348 }
            r13.<init>()     // Catch:{ all -> 0x0348 }
            r1.frameMetadataListener = r13     // Catch:{ all -> 0x0348 }
            android.os.Handler r6 = new android.os.Handler     // Catch:{ all -> 0x0348 }
            android.os.Looper r5 = r0.looper     // Catch:{ all -> 0x0348 }
            r6.<init>(r5)     // Catch:{ all -> 0x0348 }
            com.google.common.base.Supplier<com.google.android.exoplayer2.RenderersFactory> r5 = r0.renderersFactorySupplier     // Catch:{ all -> 0x0348 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0348 }
            r7 = r5
            com.google.android.exoplayer2.RenderersFactory r7 = (com.google.android.exoplayer2.RenderersFactory) r7     // Catch:{ all -> 0x0348 }
            r8 = r6
            r9 = r15
            r10 = r15
            r11 = r15
            r12 = r15
            com.google.android.exoplayer2.Renderer[] r7 = r7.createRenderers(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0348 }
            r1.renderers = r7     // Catch:{ all -> 0x0348 }
            int r5 = r7.length     // Catch:{ all -> 0x0348 }
            r12 = 0
            if (r5 <= 0) goto L_0x00a1
            r5 = 1
            goto L_0x00a2
        L_0x00a1:
            r5 = r12
        L_0x00a2:
            com.google.android.exoplayer2.util.Assertions.checkState(r5)     // Catch:{ all -> 0x0348 }
            com.google.common.base.Supplier<com.google.android.exoplayer2.trackselection.TrackSelector> r5 = r0.trackSelectorSupplier     // Catch:{ all -> 0x0348 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0348 }
            r10 = r5
            com.google.android.exoplayer2.trackselection.TrackSelector r10 = (com.google.android.exoplayer2.trackselection.TrackSelector) r10     // Catch:{ all -> 0x0348 }
            r1.trackSelector = r10     // Catch:{ all -> 0x0348 }
            com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory> r5 = r0.mediaSourceFactorySupplier     // Catch:{ all -> 0x0348 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.source.MediaSource$Factory r5 = (com.google.android.exoplayer2.source.MediaSource.Factory) r5     // Catch:{ all -> 0x0348 }
            r1.mediaSourceFactory = r5     // Catch:{ all -> 0x0348 }
            com.google.common.base.Supplier<com.google.android.exoplayer2.upstream.BandwidthMeter> r5 = r0.bandwidthMeterSupplier     // Catch:{ all -> 0x0348 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0348 }
            r9 = r5
            com.google.android.exoplayer2.upstream.BandwidthMeter r9 = (com.google.android.exoplayer2.upstream.BandwidthMeter) r9     // Catch:{ all -> 0x0348 }
            r1.bandwidthMeter = r9     // Catch:{ all -> 0x0348 }
            boolean r5 = r0.useLazyPreparation     // Catch:{ all -> 0x0348 }
            r1.useLazyPreparation = r5     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.SeekParameters r5 = r0.seekParameters     // Catch:{ all -> 0x0348 }
            r1.seekParameters = r5     // Catch:{ all -> 0x0348 }
            r16 = r15
            long r14 = r0.seekBackIncrementMs     // Catch:{ all -> 0x0348 }
            r1.seekBackIncrementMs = r14     // Catch:{ all -> 0x0348 }
            long r14 = r0.seekForwardIncrementMs     // Catch:{ all -> 0x0348 }
            r1.seekForwardIncrementMs = r14     // Catch:{ all -> 0x0348 }
            boolean r5 = r0.pauseAtEndOfMediaItems     // Catch:{ all -> 0x0348 }
            r1.pauseAtEndOfMediaItems = r5     // Catch:{ all -> 0x0348 }
            android.os.Looper r15 = r0.looper     // Catch:{ all -> 0x0348 }
            r1.applicationLooper = r15     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.Clock r14 = r0.clock     // Catch:{ all -> 0x0348 }
            r1.clock = r14     // Catch:{ all -> 0x0348 }
            if (r40 != 0) goto L_0x00e7
            r5 = r1
            goto L_0x00e9
        L_0x00e7:
            r5 = r40
        L_0x00e9:
            r1.wrappingPlayer = r5     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.ListenerSet r8 = new com.google.android.exoplayer2.util.ListenerSet     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.m r11 = new com.google.android.exoplayer2.m     // Catch:{ all -> 0x0348 }
            r11.<init>(r1)     // Catch:{ all -> 0x0348 }
            r8.<init>(r15, r14, r11)     // Catch:{ all -> 0x0348 }
            r1.listeners = r8     // Catch:{ all -> 0x0348 }
            java.util.concurrent.CopyOnWriteArraySet r8 = new java.util.concurrent.CopyOnWriteArraySet     // Catch:{ all -> 0x0348 }
            r8.<init>()     // Catch:{ all -> 0x0348 }
            r1.audioOffloadListeners = r8     // Catch:{ all -> 0x0348 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0348 }
            r8.<init>()     // Catch:{ all -> 0x0348 }
            r1.mediaSourceHolderSnapshots = r8     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder r8 = new com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder     // Catch:{ all -> 0x0348 }
            r8.<init>(r12)     // Catch:{ all -> 0x0348 }
            r1.shuffleOrder = r8     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r8 = new com.google.android.exoplayer2.trackselection.TrackSelectorResult     // Catch:{ all -> 0x0348 }
            int r11 = r7.length     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.RendererConfiguration[] r11 = new com.google.android.exoplayer2.RendererConfiguration[r11]     // Catch:{ all -> 0x0348 }
            int r12 = r7.length     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r12 = new com.google.android.exoplayer2.trackselection.ExoTrackSelection[r12]     // Catch:{ all -> 0x0348 }
            r20 = r6
            com.google.android.exoplayer2.Tracks r6 = com.google.android.exoplayer2.Tracks.EMPTY     // Catch:{ all -> 0x0348 }
            r21 = r9
            r9 = 0
            r8.<init>(r11, r12, r6, r9)     // Catch:{ all -> 0x0348 }
            r1.emptyTrackSelectorResult = r8     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Timeline$Period r6 = new com.google.android.exoplayer2.Timeline$Period     // Catch:{ all -> 0x0348 }
            r6.<init>()     // Catch:{ all -> 0x0348 }
            r1.period = r6     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = new com.google.android.exoplayer2.Player$Commands$Builder     // Catch:{ all -> 0x0348 }
            r6.<init>()     // Catch:{ all -> 0x0348 }
            r12 = 21
            int[] r9 = new int[r12]     // Catch:{ all -> 0x0348 }
            r11 = 1
            r18 = 0
            r9[r18] = r11     // Catch:{ all -> 0x0348 }
            r12 = 2
            r9[r11] = r12     // Catch:{ all -> 0x0348 }
            r24 = r2
            r2 = 3
            r9[r12] = r2     // Catch:{ all -> 0x0348 }
            r19 = 13
            r9[r2] = r19     // Catch:{ all -> 0x0348 }
            r22 = 14
            r2 = 4
            r9[r2] = r22     // Catch:{ all -> 0x0348 }
            r23 = 15
            r2 = 5
            r9[r2] = r23     // Catch:{ all -> 0x0348 }
            r25 = 16
            r2 = 6
            r9[r2] = r25     // Catch:{ all -> 0x0348 }
            r26 = 17
            r2 = 7
            r9[r2] = r26     // Catch:{ all -> 0x0348 }
            r27 = 18
            r2 = 8
            r9[r2] = r27     // Catch:{ all -> 0x0348 }
            r28 = 19
            r2 = 9
            r9[r2] = r28     // Catch:{ all -> 0x0348 }
            r11 = 31
            r2 = 10
            r9[r2] = r11     // Catch:{ all -> 0x0348 }
            r29 = 11
            r30 = 20
            r9[r29] = r30     // Catch:{ all -> 0x0348 }
            r29 = 12
            r31 = 30
            r9[r29] = r31     // Catch:{ all -> 0x0348 }
            r29 = 21
            r9[r19] = r29     // Catch:{ all -> 0x0348 }
            r19 = 22
            r9[r22] = r19     // Catch:{ all -> 0x0348 }
            r19 = 23
            r9[r23] = r19     // Catch:{ all -> 0x0348 }
            r19 = 24
            r9[r25] = r19     // Catch:{ all -> 0x0348 }
            r19 = 25
            r9[r26] = r19     // Catch:{ all -> 0x0348 }
            r19 = 26
            r9[r27] = r19     // Catch:{ all -> 0x0348 }
            r19 = 27
            r9[r28] = r19     // Catch:{ all -> 0x0348 }
            r19 = 28
            r9[r30] = r19     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.addAll((int[]) r9)     // Catch:{ all -> 0x0348 }
            boolean r9 = r10.isSetParametersSupported()     // Catch:{ all -> 0x0348 }
            r12 = 29
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.addIf(r12, r9)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands r6 = r6.build()     // Catch:{ all -> 0x0348 }
            r1.permanentAvailableCommands = r6     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands$Builder r9 = new com.google.android.exoplayer2.Player$Commands$Builder     // Catch:{ all -> 0x0348 }
            r9.<init>()     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r9.addAll((com.google.android.exoplayer2.Player.Commands) r6)     // Catch:{ all -> 0x0348 }
            r9 = 4
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.add(r9)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.add(r2)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands r6 = r6.build()     // Catch:{ all -> 0x0348 }
            r1.availableCommands = r6     // Catch:{ all -> 0x0348 }
            r12 = 0
            com.google.android.exoplayer2.util.HandlerWrapper r6 = r14.createHandler(r15, r12)     // Catch:{ all -> 0x0348 }
            r1.playbackInfoUpdateHandler = r6     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.w r9 = new com.google.android.exoplayer2.w     // Catch:{ all -> 0x0348 }
            r9.<init>(r1)     // Catch:{ all -> 0x0348 }
            r1.playbackInfoUpdateListener = r9     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.PlaybackInfo r6 = com.google.android.exoplayer2.PlaybackInfo.createDummy(r8)     // Catch:{ all -> 0x0348 }
            r1.playbackInfo = r6     // Catch:{ all -> 0x0348 }
            r4.setPlayer(r5, r15)     // Catch:{ all -> 0x0348 }
            int r6 = com.google.android.exoplayer2.util.Util.SDK_INT     // Catch:{ all -> 0x0348 }
            if (r6 >= r11) goto L_0x01e0
            com.google.android.exoplayer2.analytics.PlayerId r5 = new com.google.android.exoplayer2.analytics.PlayerId     // Catch:{ all -> 0x0348 }
            r5.<init>()     // Catch:{ all -> 0x0348 }
            goto L_0x01e6
        L_0x01e0:
            boolean r5 = r0.usePlatformDiagnostics     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.analytics.PlayerId r5 = com.google.android.exoplayer2.ExoPlayerImpl.Api31.registerMediaMetricsListener(r3, r1, r5)     // Catch:{ all -> 0x0348 }
        L_0x01e6:
            r22 = r5
            com.google.android.exoplayer2.ExoPlayerImplInternal r11 = new com.google.android.exoplayer2.ExoPlayerImplInternal     // Catch:{ all -> 0x0348 }
            com.google.common.base.Supplier<com.google.android.exoplayer2.LoadControl> r5 = r0.loadControlSupplier     // Catch:{ all -> 0x0348 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0348 }
            r17 = r5
            com.google.android.exoplayer2.LoadControl r17 = (com.google.android.exoplayer2.LoadControl) r17     // Catch:{ all -> 0x0348 }
            int r5 = r1.repeatMode     // Catch:{ all -> 0x0348 }
            boolean r12 = r1.shuffleModeEnabled     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.SeekParameters r2 = r1.seekParameters     // Catch:{ all -> 0x0348 }
            r23 = r15
            com.google.android.exoplayer2.LivePlaybackSpeedControl r15 = r0.livePlaybackSpeedControl     // Catch:{ all -> 0x0348 }
            r27 = r2
            r26 = r3
            long r2 = r0.releaseTimeoutMs     // Catch:{ all -> 0x0348 }
            r30 = r2
            boolean r2 = r1.pauseAtEndOfMediaItems     // Catch:{ all -> 0x0348 }
            android.os.Looper r3 = r0.playbackLooper     // Catch:{ all -> 0x0348 }
            r28 = r5
            r5 = r11
            r0 = r6
            r32 = r20
            r6 = r7
            r7 = r10
            r33 = r21
            r21 = r9
            r9 = r17
            r34 = r10
            r10 = r33
            r35 = r0
            r0 = r11
            r11 = r28
            r17 = 0
            r36 = r13
            r13 = r4
            r20 = r14
            r28 = r17
            r14 = r27
            r37 = r16
            r40 = r23
            r16 = r30
            r18 = r2
            r19 = r40
            r23 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0348 }
            r1.internalPlayer = r0     // Catch:{ all -> 0x0348 }
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.volume = r2     // Catch:{ all -> 0x0348 }
            r2 = 0
            r1.repeatMode = r2     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.MediaMetadata r3 = com.google.android.exoplayer2.MediaMetadata.EMPTY     // Catch:{ all -> 0x0348 }
            r1.mediaMetadata = r3     // Catch:{ all -> 0x0348 }
            r1.playlistMetadata = r3     // Catch:{ all -> 0x0348 }
            r1.staticAndDynamicMediaMetadata = r3     // Catch:{ all -> 0x0348 }
            r3 = -1
            r1.maskingWindowIndex = r3     // Catch:{ all -> 0x0348 }
            r3 = r35
            r5 = 21
            if (r3 >= r5) goto L_0x025c
            int r3 = r1.initializeKeepSessionIdAudioTrack(r2)     // Catch:{ all -> 0x0348 }
            r1.audioSessionId = r3     // Catch:{ all -> 0x0348 }
            goto L_0x0262
        L_0x025c:
            int r3 = com.google.android.exoplayer2.util.Util.generateAudioSessionIdV21(r26)     // Catch:{ all -> 0x0348 }
            r1.audioSessionId = r3     // Catch:{ all -> 0x0348 }
        L_0x0262:
            com.google.android.exoplayer2.text.CueGroup r3 = com.google.android.exoplayer2.text.CueGroup.EMPTY_TIME_ZERO     // Catch:{ all -> 0x0348 }
            r1.currentCueGroup = r3     // Catch:{ all -> 0x0348 }
            r3 = 1
            r1.throwsWhenUsingWrongThread = r3     // Catch:{ all -> 0x0348 }
            r1.addListener(r4)     // Catch:{ all -> 0x0348 }
            android.os.Handler r5 = new android.os.Handler     // Catch:{ all -> 0x0348 }
            r6 = r40
            r5.<init>(r6)     // Catch:{ all -> 0x0348 }
            r6 = r33
            r6.addEventListener(r5, r4)     // Catch:{ all -> 0x0348 }
            r4 = r37
            r1.addAudioOffloadListener(r4)     // Catch:{ all -> 0x0348 }
            r5 = r39
            long r6 = r5.foregroundModeTimeoutMs     // Catch:{ all -> 0x0348 }
            r8 = 0
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x028a
            r0.experimentalSetForegroundModeTimeoutMs(r6)     // Catch:{ all -> 0x0348 }
        L_0x028a:
            com.google.android.exoplayer2.AudioBecomingNoisyManager r0 = new com.google.android.exoplayer2.AudioBecomingNoisyManager     // Catch:{ all -> 0x0348 }
            android.content.Context r6 = r5.context     // Catch:{ all -> 0x0348 }
            r7 = r32
            r0.<init>(r6, r7, r4)     // Catch:{ all -> 0x0348 }
            r1.audioBecomingNoisyManager = r0     // Catch:{ all -> 0x0348 }
            boolean r6 = r5.handleAudioBecomingNoisy     // Catch:{ all -> 0x0348 }
            r0.setEnabled(r6)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.AudioFocusManager r0 = new com.google.android.exoplayer2.AudioFocusManager     // Catch:{ all -> 0x0348 }
            android.content.Context r6 = r5.context     // Catch:{ all -> 0x0348 }
            r0.<init>(r6, r7, r4)     // Catch:{ all -> 0x0348 }
            r1.audioFocusManager = r0     // Catch:{ all -> 0x0348 }
            boolean r6 = r5.handleAudioFocus     // Catch:{ all -> 0x0348 }
            if (r6 == 0) goto L_0x02aa
            com.google.android.exoplayer2.audio.AudioAttributes r14 = r1.audioAttributes     // Catch:{ all -> 0x0348 }
            goto L_0x02ac
        L_0x02aa:
            r14 = r28
        L_0x02ac:
            r0.setAudioAttributes(r14)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.StreamVolumeManager r0 = new com.google.android.exoplayer2.StreamVolumeManager     // Catch:{ all -> 0x0348 }
            android.content.Context r6 = r5.context     // Catch:{ all -> 0x0348 }
            r0.<init>(r6, r7, r4)     // Catch:{ all -> 0x0348 }
            r1.streamVolumeManager = r0     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.audio.AudioAttributes r4 = r1.audioAttributes     // Catch:{ all -> 0x0348 }
            int r4 = r4.usage     // Catch:{ all -> 0x0348 }
            int r4 = com.google.android.exoplayer2.util.Util.getStreamTypeForAudioUsage(r4)     // Catch:{ all -> 0x0348 }
            r0.setStreamType(r4)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.WakeLockManager r4 = new com.google.android.exoplayer2.WakeLockManager     // Catch:{ all -> 0x0348 }
            android.content.Context r6 = r5.context     // Catch:{ all -> 0x0348 }
            r4.<init>(r6)     // Catch:{ all -> 0x0348 }
            r1.wakeLockManager = r4     // Catch:{ all -> 0x0348 }
            int r6 = r5.wakeMode     // Catch:{ all -> 0x0348 }
            if (r6 == 0) goto L_0x02d2
            r12 = r3
            goto L_0x02d3
        L_0x02d2:
            r12 = r2
        L_0x02d3:
            r4.setEnabled(r12)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.WifiLockManager r4 = new com.google.android.exoplayer2.WifiLockManager     // Catch:{ all -> 0x0348 }
            android.content.Context r6 = r5.context     // Catch:{ all -> 0x0348 }
            r4.<init>(r6)     // Catch:{ all -> 0x0348 }
            r1.wifiLockManager = r4     // Catch:{ all -> 0x0348 }
            int r5 = r5.wakeMode     // Catch:{ all -> 0x0348 }
            r6 = 2
            if (r5 != r6) goto L_0x02e6
            r12 = r3
            goto L_0x02e7
        L_0x02e6:
            r12 = r2
        L_0x02e7:
            r4.setEnabled(r12)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.DeviceInfo r0 = createDeviceInfo(r0)     // Catch:{ all -> 0x0348 }
            r1.deviceInfo = r0     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.video.VideoSize r0 = com.google.android.exoplayer2.video.VideoSize.UNKNOWN     // Catch:{ all -> 0x0348 }
            r1.videoSize = r0     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.Size r0 = com.google.android.exoplayer2.util.Size.UNKNOWN     // Catch:{ all -> 0x0348 }
            r1.surfaceSize = r0     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.audio.AudioAttributes r0 = r1.audioAttributes     // Catch:{ all -> 0x0348 }
            r5 = r34
            r5.setAudioAttributes(r0)     // Catch:{ all -> 0x0348 }
            int r0 = r1.audioSessionId     // Catch:{ all -> 0x0348 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0348 }
            r2 = 10
            r1.sendRendererMessage(r3, r2, r0)     // Catch:{ all -> 0x0348 }
            int r0 = r1.audioSessionId     // Catch:{ all -> 0x0348 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0348 }
            r1.sendRendererMessage(r6, r2, r0)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.audio.AudioAttributes r0 = r1.audioAttributes     // Catch:{ all -> 0x0348 }
            r2 = 3
            r1.sendRendererMessage(r3, r2, r0)     // Catch:{ all -> 0x0348 }
            int r0 = r1.videoScalingMode     // Catch:{ all -> 0x0348 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0348 }
            r2 = 4
            r1.sendRendererMessage(r6, r2, r0)     // Catch:{ all -> 0x0348 }
            int r0 = r1.videoChangeFrameRateStrategy     // Catch:{ all -> 0x0348 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0348 }
            r2 = 5
            r1.sendRendererMessage(r6, r2, r0)     // Catch:{ all -> 0x0348 }
            boolean r0 = r1.skipSilenceEnabled     // Catch:{ all -> 0x0348 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0348 }
            r2 = 9
            r1.sendRendererMessage(r3, r2, r0)     // Catch:{ all -> 0x0348 }
            r0 = r36
            r2 = 7
            r1.sendRendererMessage(r6, r2, r0)     // Catch:{ all -> 0x0348 }
            r2 = 8
            r3 = 6
            r1.sendRendererMessage(r3, r2, r0)     // Catch:{ all -> 0x0348 }
            r24.open()
            return
        L_0x0348:
            r0 = move-exception
            com.google.android.exoplayer2.util.ConditionVariable r2 = r1.constructorFinished
            r2.open()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImpl.<init>(com.google.android.exoplayer2.ExoPlayer$Builder, com.google.android.exoplayer2.Player):void");
    }

    private List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders(int i11, List<MediaSource> list) {
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder(list.get(i12), this.useLazyPreparation);
            arrayList.add(mediaSourceHolder);
            this.mediaSourceHolderSnapshots.add(i12 + i11, new MediaSourceHolderSnapshot(mediaSourceHolder.uid, mediaSourceHolder.mediaSource.getTimeline()));
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndInsert(i11, arrayList.size());
        return arrayList;
    }

    /* access modifiers changed from: private */
    public MediaMetadata buildUpdatedMediaMetadata() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return this.staticAndDynamicMediaMetadata;
        }
        return this.staticAndDynamicMediaMetadata.buildUpon().populate(currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).mediaItem.mediaMetadata).build();
    }

    /* access modifiers changed from: private */
    public static DeviceInfo createDeviceInfo(StreamVolumeManager streamVolumeManager2) {
        return new DeviceInfo(0, streamVolumeManager2.getMinVolume(), streamVolumeManager2.getMaxVolume());
    }

    private Timeline createMaskingTimeline() {
        return new PlaylistTimeline(this.mediaSourceHolderSnapshots, this.shuffleOrder);
    }

    private List<MediaSource> createMediaSources(List<MediaItem> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(this.mediaSourceFactory.createMediaSource(list.get(i11)));
        }
        return arrayList;
    }

    private PlayerMessage createMessageInternal(PlayerMessage.Target target) {
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        ExoPlayerImplInternal exoPlayerImplInternal = this.internalPlayer;
        Timeline timeline = this.playbackInfo.timeline;
        if (currentWindowIndexInternal == -1) {
            currentWindowIndexInternal = 0;
        }
        return new PlayerMessage(exoPlayerImplInternal, target, timeline, currentWindowIndexInternal, this.clock, exoPlayerImplInternal.getPlaybackLooper());
    }

    private Pair<Boolean, Integer> evaluateMediaItemTransitionReason(PlaybackInfo playbackInfo2, PlaybackInfo playbackInfo3, boolean z11, int i11, boolean z12, boolean z13) {
        Timeline timeline = playbackInfo3.timeline;
        Timeline timeline2 = playbackInfo2.timeline;
        if (timeline2.isEmpty() && timeline.isEmpty()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i12 = 3;
        if (timeline2.isEmpty() != timeline.isEmpty()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (!timeline.getWindow(timeline.getPeriodByUid(playbackInfo3.periodId.periodUid, this.period).windowIndex, this.window).uid.equals(timeline2.getWindow(timeline2.getPeriodByUid(playbackInfo2.periodId.periodUid, this.period).windowIndex, this.window).uid)) {
            if (z11 && i11 == 0) {
                i12 = 1;
            } else if (z11 && i11 == 1) {
                i12 = 2;
            } else if (!z12) {
                throw new IllegalStateException();
            }
            return new Pair<>(Boolean.TRUE, Integer.valueOf(i12));
        } else if (z11 && i11 == 0 && playbackInfo3.periodId.windowSequenceNumber < playbackInfo2.periodId.windowSequenceNumber) {
            return new Pair<>(Boolean.TRUE, 0);
        } else {
            if (!z11 || i11 != 1 || !z13) {
                return new Pair<>(Boolean.FALSE, -1);
            }
            return new Pair<>(Boolean.TRUE, 2);
        }
    }

    private long getCurrentPositionUsInternal(PlaybackInfo playbackInfo2) {
        if (playbackInfo2.timeline.isEmpty()) {
            return Util.msToUs(this.maskingWindowPositionMs);
        }
        if (playbackInfo2.periodId.isAd()) {
            return playbackInfo2.positionUs;
        }
        return periodPositionUsToWindowPositionUs(playbackInfo2.timeline, playbackInfo2.periodId, playbackInfo2.positionUs);
    }

    private int getCurrentWindowIndexInternal() {
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingWindowIndex;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        return playbackInfo2.timeline.getPeriodByUid(playbackInfo2.periodId.periodUid, this.period).windowIndex;
    }

    @Nullable
    private Pair<Object, Long> getPeriodPositionUsAfterTimelineChanged(Timeline timeline, Timeline timeline2) {
        boolean z11;
        long contentPosition = getContentPosition();
        int i11 = -1;
        if (timeline.isEmpty() || timeline2.isEmpty()) {
            if (timeline.isEmpty() || !timeline2.isEmpty()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                i11 = getCurrentWindowIndexInternal();
            }
            if (z11) {
                contentPosition = -9223372036854775807L;
            }
            return maskWindowPositionMsOrGetPeriodPositionUs(timeline2, i11, contentPosition);
        }
        Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, getCurrentMediaItemIndex(), Util.msToUs(contentPosition));
        Object obj = ((Pair) Util.castNonNull(periodPositionUs)).first;
        if (timeline2.getIndexOfPeriod(obj) != -1) {
            return periodPositionUs;
        }
        Object resolveSubsequentPeriod = ExoPlayerImplInternal.resolveSubsequentPeriod(this.window, this.period, this.repeatMode, this.shuffleModeEnabled, obj, timeline, timeline2);
        if (resolveSubsequentPeriod == null) {
            return maskWindowPositionMsOrGetPeriodPositionUs(timeline2, -1, C.TIME_UNSET);
        }
        timeline2.getPeriodByUid(resolveSubsequentPeriod, this.period);
        int i12 = this.period.windowIndex;
        return maskWindowPositionMsOrGetPeriodPositionUs(timeline2, i12, timeline2.getWindow(i12, this.window).getDefaultPositionMs());
    }

    /* access modifiers changed from: private */
    public static int getPlayWhenReadyChangeReason(boolean z11, int i11) {
        return (!z11 || i11 == 1) ? 1 : 2;
    }

    private Player.PositionInfo getPositionInfo(long j11) {
        int i11;
        Object obj;
        MediaItem mediaItem;
        Object obj2;
        long j12;
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        if (!this.playbackInfo.timeline.isEmpty()) {
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            Object obj3 = playbackInfo2.periodId.periodUid;
            playbackInfo2.timeline.getPeriodByUid(obj3, this.period);
            int indexOfPeriod = this.playbackInfo.timeline.getIndexOfPeriod(obj3);
            i11 = indexOfPeriod;
            obj = obj3;
            obj2 = this.playbackInfo.timeline.getWindow(currentMediaItemIndex, this.window).uid;
            mediaItem = this.window.mediaItem;
        } else {
            mediaItem = null;
            obj = null;
            i11 = -1;
            obj2 = null;
        }
        long usToMs = Util.usToMs(j11);
        if (this.playbackInfo.periodId.isAd()) {
            j12 = Util.usToMs(getRequestedContentPositionUs(this.playbackInfo));
        } else {
            j12 = usToMs;
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        return new Player.PositionInfo(obj2, currentMediaItemIndex, mediaItem, obj, i11, usToMs, j12, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
    }

    private Player.PositionInfo getPreviousPositionInfo(int i11, PlaybackInfo playbackInfo2, int i12) {
        int i13;
        Object obj;
        MediaItem mediaItem;
        int i14;
        Object obj2;
        long j11;
        long j12;
        PlaybackInfo playbackInfo3 = playbackInfo2;
        Timeline.Period period2 = new Timeline.Period();
        if (!playbackInfo3.timeline.isEmpty()) {
            Object obj3 = playbackInfo3.periodId.periodUid;
            playbackInfo3.timeline.getPeriodByUid(obj3, period2);
            int i15 = period2.windowIndex;
            int indexOfPeriod = playbackInfo3.timeline.getIndexOfPeriod(obj3);
            Object obj4 = playbackInfo3.timeline.getWindow(i15, this.window).uid;
            mediaItem = this.window.mediaItem;
            obj = obj3;
            i13 = indexOfPeriod;
            obj2 = obj4;
            i14 = i15;
        } else {
            i14 = i12;
            obj2 = null;
            mediaItem = null;
            obj = null;
            i13 = -1;
        }
        if (i11 == 0) {
            if (playbackInfo3.periodId.isAd()) {
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo3.periodId;
                j12 = period2.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
                j11 = getRequestedContentPositionUs(playbackInfo2);
                long usToMs = Util.usToMs(j12);
                long usToMs2 = Util.usToMs(j11);
                MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo3.periodId;
                return new Player.PositionInfo(obj2, i14, mediaItem, obj, i13, usToMs, usToMs2, mediaPeriodId2.adGroupIndex, mediaPeriodId2.adIndexInAdGroup);
            } else if (playbackInfo3.periodId.nextAdGroupIndex != -1) {
                j12 = getRequestedContentPositionUs(this.playbackInfo);
            } else {
                j12 = period2.positionInWindowUs + period2.durationUs;
            }
        } else if (playbackInfo3.periodId.isAd()) {
            j12 = playbackInfo3.positionUs;
            j11 = getRequestedContentPositionUs(playbackInfo2);
            long usToMs3 = Util.usToMs(j12);
            long usToMs22 = Util.usToMs(j11);
            MediaSource.MediaPeriodId mediaPeriodId22 = playbackInfo3.periodId;
            return new Player.PositionInfo(obj2, i14, mediaItem, obj, i13, usToMs3, usToMs22, mediaPeriodId22.adGroupIndex, mediaPeriodId22.adIndexInAdGroup);
        } else {
            j12 = period2.positionInWindowUs + playbackInfo3.positionUs;
        }
        j11 = j12;
        long usToMs32 = Util.usToMs(j12);
        long usToMs222 = Util.usToMs(j11);
        MediaSource.MediaPeriodId mediaPeriodId222 = playbackInfo3.periodId;
        return new Player.PositionInfo(obj2, i14, mediaItem, obj, i13, usToMs32, usToMs222, mediaPeriodId222.adGroupIndex, mediaPeriodId222.adIndexInAdGroup);
    }

    private static long getRequestedContentPositionUs(PlaybackInfo playbackInfo2) {
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period2 = new Timeline.Period();
        playbackInfo2.timeline.getPeriodByUid(playbackInfo2.periodId.periodUid, period2);
        if (playbackInfo2.requestedContentPositionUs == C.TIME_UNSET) {
            return playbackInfo2.timeline.getWindow(period2.windowIndex, window).getDefaultPositionUs();
        }
        return period2.getPositionInWindowUs() + playbackInfo2.requestedContentPositionUs;
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePlaybackInfo */
    public void lambda$new$1(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        long j11;
        boolean z11;
        long j12;
        boolean z12;
        int i11 = this.pendingOperationAcks - playbackInfoUpdate.operationAcks;
        this.pendingOperationAcks = i11;
        boolean z13 = true;
        if (playbackInfoUpdate.positionDiscontinuity) {
            this.pendingDiscontinuityReason = playbackInfoUpdate.discontinuityReason;
            this.pendingDiscontinuity = true;
        }
        if (playbackInfoUpdate.hasPlayWhenReadyChangeReason) {
            this.pendingPlayWhenReadyChangeReason = playbackInfoUpdate.playWhenReadyChangeReason;
        }
        if (i11 == 0) {
            Timeline timeline = playbackInfoUpdate.playbackInfo.timeline;
            if (!this.playbackInfo.timeline.isEmpty() && timeline.isEmpty()) {
                this.maskingWindowIndex = -1;
                this.maskingWindowPositionMs = 0;
                this.maskingPeriodIndex = 0;
            }
            if (!timeline.isEmpty()) {
                List<Timeline> childTimelines = ((PlaylistTimeline) timeline).getChildTimelines();
                if (childTimelines.size() == this.mediaSourceHolderSnapshots.size()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                Assertions.checkState(z12);
                for (int i12 = 0; i12 < childTimelines.size(); i12++) {
                    Timeline unused = this.mediaSourceHolderSnapshots.get(i12).timeline = childTimelines.get(i12);
                }
            }
            if (this.pendingDiscontinuity) {
                if (playbackInfoUpdate.playbackInfo.periodId.equals(this.playbackInfo.periodId) && playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs == this.playbackInfo.positionUs) {
                    z13 = false;
                }
                if (z13) {
                    if (timeline.isEmpty() || playbackInfoUpdate.playbackInfo.periodId.isAd()) {
                        j12 = playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs;
                    } else {
                        PlaybackInfo playbackInfo2 = playbackInfoUpdate.playbackInfo;
                        j12 = periodPositionUsToWindowPositionUs(timeline, playbackInfo2.periodId, playbackInfo2.discontinuityStartPositionUs);
                    }
                    j11 = j12;
                } else {
                    j11 = -9223372036854775807L;
                }
                z11 = z13;
            } else {
                j11 = -9223372036854775807L;
                z11 = false;
            }
            this.pendingDiscontinuity = false;
            updatePlaybackInfo(playbackInfoUpdate.playbackInfo, 1, this.pendingPlayWhenReadyChangeReason, false, z11, this.pendingDiscontinuityReason, j11, -1, false);
        }
    }

    private int initializeKeepSessionIdAudioTrack(int i11) {
        AudioTrack audioTrack = this.keepSessionIdAudioTrack;
        if (!(audioTrack == null || audioTrack.getAudioSessionId() == i11)) {
            this.keepSessionIdAudioTrack.release();
            this.keepSessionIdAudioTrack = null;
        }
        if (this.keepSessionIdAudioTrack == null) {
            this.keepSessionIdAudioTrack = new AudioTrack(3, 4000, 4, 2, 2, 0, i11);
        }
        return this.keepSessionIdAudioTrack.getAudioSessionId();
    }

    private static boolean isPlaying(PlaybackInfo playbackInfo2) {
        return playbackInfo2.playbackState == 3 && playbackInfo2.playWhenReady && playbackInfo2.playbackSuppressionReason == 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Player.Listener listener, FlagSet flagSet) {
        listener.onEvents(this.wrappingPlayer, new Player.Events(flagSet));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.playbackInfoUpdateHandler.post(new z(this, playbackInfoUpdate));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setPlaylistMetadata$7(Player.Listener listener) {
        listener.onPlaylistMetadataChanged(this.playlistMetadata);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateAvailableCommands$26(Player.Listener listener) {
        listener.onAvailableCommandsChanged(this.availableCommands);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$updatePlaybackInfo$13(int i11, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.onPositionDiscontinuity(i11);
        listener.onPositionDiscontinuity(positionInfo, positionInfo2, i11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$updatePlaybackInfo$19(PlaybackInfo playbackInfo2, Player.Listener listener) {
        listener.onLoadingChanged(playbackInfo2.isLoading);
        listener.onIsLoadingChanged(playbackInfo2.isLoading);
    }

    private PlaybackInfo maskTimelineAndPosition(PlaybackInfo playbackInfo2, Timeline timeline, @Nullable Pair<Object, Long> pair) {
        boolean z11;
        MediaSource.MediaPeriodId mediaPeriodId;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        List list;
        int i11;
        long j11;
        Timeline timeline2 = timeline;
        Pair<Object, Long> pair2 = pair;
        if (timeline.isEmpty() || pair2 != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        Timeline timeline3 = playbackInfo2.timeline;
        PlaybackInfo copyWithTimeline = playbackInfo2.copyWithTimeline(timeline);
        if (timeline.isEmpty()) {
            MediaSource.MediaPeriodId dummyPeriodForEmptyTimeline = PlaybackInfo.getDummyPeriodForEmptyTimeline();
            long msToUs = Util.msToUs(this.maskingWindowPositionMs);
            PlaybackInfo copyWithLoadingMediaPeriodId = copyWithTimeline.copyWithNewPosition(dummyPeriodForEmptyTimeline, msToUs, msToUs, msToUs, 0, TrackGroupArray.EMPTY, this.emptyTrackSelectorResult, ImmutableList.of()).copyWithLoadingMediaPeriodId(dummyPeriodForEmptyTimeline);
            copyWithLoadingMediaPeriodId.bufferedPositionUs = copyWithLoadingMediaPeriodId.positionUs;
            return copyWithLoadingMediaPeriodId;
        }
        Object obj = copyWithTimeline.periodId.periodUid;
        boolean z12 = !obj.equals(((Pair) Util.castNonNull(pair)).first);
        if (z12) {
            mediaPeriodId = new MediaSource.MediaPeriodId(pair2.first);
        } else {
            mediaPeriodId = copyWithTimeline.periodId;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long longValue = ((Long) pair2.second).longValue();
        long msToUs2 = Util.msToUs(getContentPosition());
        if (!timeline3.isEmpty()) {
            msToUs2 -= timeline3.getPeriodByUid(obj, this.period).getPositionInWindowUs();
        }
        if (z12 || longValue < msToUs2) {
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            Assertions.checkState(!mediaPeriodId3.isAd());
            if (z12) {
                trackGroupArray = TrackGroupArray.EMPTY;
            } else {
                trackGroupArray = copyWithTimeline.trackGroups;
            }
            TrackGroupArray trackGroupArray2 = trackGroupArray;
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId3;
            if (z12) {
                trackSelectorResult = this.emptyTrackSelectorResult;
            } else {
                trackSelectorResult = copyWithTimeline.trackSelectorResult;
            }
            TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
            if (z12) {
                list = ImmutableList.of();
            } else {
                list = copyWithTimeline.staticMetadata;
            }
            PlaybackInfo copyWithLoadingMediaPeriodId2 = copyWithTimeline.copyWithNewPosition(mediaPeriodId4, longValue, longValue, longValue, 0, trackGroupArray2, trackSelectorResult2, list).copyWithLoadingMediaPeriodId(mediaPeriodId4);
            copyWithLoadingMediaPeriodId2.bufferedPositionUs = longValue;
            return copyWithLoadingMediaPeriodId2;
        }
        if (i11 == 0) {
            int indexOfPeriod = timeline2.getIndexOfPeriod(copyWithTimeline.loadingMediaPeriodId.periodUid);
            if (indexOfPeriod == -1 || timeline2.getPeriod(indexOfPeriod, this.period).windowIndex != timeline2.getPeriodByUid(mediaPeriodId2.periodUid, this.period).windowIndex) {
                timeline2.getPeriodByUid(mediaPeriodId2.periodUid, this.period);
                if (mediaPeriodId2.isAd()) {
                    j11 = this.period.getAdDurationUs(mediaPeriodId2.adGroupIndex, mediaPeriodId2.adIndexInAdGroup);
                } else {
                    j11 = this.period.durationUs;
                }
                copyWithTimeline = copyWithTimeline.copyWithNewPosition(mediaPeriodId2, copyWithTimeline.positionUs, copyWithTimeline.positionUs, copyWithTimeline.discontinuityStartPositionUs, j11 - copyWithTimeline.positionUs, copyWithTimeline.trackGroups, copyWithTimeline.trackSelectorResult, copyWithTimeline.staticMetadata).copyWithLoadingMediaPeriodId(mediaPeriodId2);
                copyWithTimeline.bufferedPositionUs = j11;
            }
        } else {
            MediaSource.MediaPeriodId mediaPeriodId5 = mediaPeriodId2;
            Assertions.checkState(!mediaPeriodId5.isAd());
            long max = Math.max(0, copyWithTimeline.totalBufferedDurationUs - (longValue - msToUs2));
            long j12 = copyWithTimeline.bufferedPositionUs;
            if (copyWithTimeline.loadingMediaPeriodId.equals(copyWithTimeline.periodId)) {
                j12 = longValue + max;
            }
            copyWithTimeline = copyWithTimeline.copyWithNewPosition(mediaPeriodId5, longValue, longValue, longValue, max, copyWithTimeline.trackGroups, copyWithTimeline.trackSelectorResult, copyWithTimeline.staticMetadata);
            copyWithTimeline.bufferedPositionUs = j12;
        }
        return copyWithTimeline;
    }

    @Nullable
    private Pair<Object, Long> maskWindowPositionMsOrGetPeriodPositionUs(Timeline timeline, int i11, long j11) {
        if (timeline.isEmpty()) {
            this.maskingWindowIndex = i11;
            if (j11 == C.TIME_UNSET) {
                j11 = 0;
            }
            this.maskingWindowPositionMs = j11;
            this.maskingPeriodIndex = 0;
            return null;
        }
        if (i11 == -1 || i11 >= timeline.getWindowCount()) {
            i11 = timeline.getFirstWindowIndex(this.shuffleModeEnabled);
            j11 = timeline.getWindow(i11, this.window).getDefaultPositionMs();
        }
        return timeline.getPeriodPositionUs(this.window, this.period, i11, Util.msToUs(j11));
    }

    /* access modifiers changed from: private */
    public void maybeNotifySurfaceSizeChanged(int i11, int i12) {
        if (i11 != this.surfaceSize.getWidth() || i12 != this.surfaceSize.getHeight()) {
            this.surfaceSize = new Size(i11, i12);
            this.listeners.sendEvent(24, new b(i11, i12));
        }
    }

    private long periodPositionUsToWindowPositionUs(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j11) {
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return j11 + this.period.getPositionInWindowUs();
    }

    private PlaybackInfo removeMediaItemsInternal(int i11, int i12) {
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        Timeline currentTimeline = getCurrentTimeline();
        int size = this.mediaSourceHolderSnapshots.size();
        boolean z11 = true;
        this.pendingOperationAcks++;
        removeMediaSourceHolders(i11, i12);
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionUsAfterTimelineChanged(currentTimeline, createMaskingTimeline));
        int i13 = maskTimelineAndPosition.playbackState;
        if (i13 == 1 || i13 == 4 || i11 >= i12 || i12 != size || currentMediaItemIndex < maskTimelineAndPosition.timeline.getWindowCount()) {
            z11 = false;
        }
        if (z11) {
            maskTimelineAndPosition = maskTimelineAndPosition.copyWithPlaybackState(4);
        }
        this.internalPlayer.removeMediaSources(i11, i12, this.shuffleOrder);
        return maskTimelineAndPosition;
    }

    private void removeMediaSourceHolders(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            this.mediaSourceHolderSnapshots.remove(i13);
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndRemove(i11, i12);
    }

    private void removeSurfaceCallbacks() {
        if (this.sphericalGLSurfaceView != null) {
            createMessageInternal(this.frameMetadataListener).setType(10000).setPayload((Object) null).send();
            this.sphericalGLSurfaceView.removeVideoSurfaceListener(this.componentListener);
            this.sphericalGLSurfaceView = null;
        }
        TextureView textureView2 = this.textureView;
        if (textureView2 != null) {
            if (textureView2.getSurfaceTextureListener() != this.componentListener) {
                Log.w(TAG, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.textureView = null;
        }
        SurfaceHolder surfaceHolder2 = this.surfaceHolder;
        if (surfaceHolder2 != null) {
            surfaceHolder2.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    private void sendRendererMessage(int i11, int i12, @Nullable Object obj) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == i11) {
                createMessageInternal(renderer).setType(i12).setPayload(obj).send();
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendVolumeToRenderers() {
        sendRendererMessage(1, 2, Float.valueOf(this.volume * this.audioFocusManager.getVolumeMultiplier()));
    }

    private void setMediaSourcesInternal(List<MediaSource> list, int i11, long j11, boolean z11) {
        int i12;
        long j12;
        int i13 = i11;
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        long currentPosition = getCurrentPosition();
        boolean z12 = true;
        this.pendingOperationAcks++;
        if (!this.mediaSourceHolderSnapshots.isEmpty()) {
            removeMediaSourceHolders(0, this.mediaSourceHolderSnapshots.size());
        }
        List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders = addMediaSourceHolders(0, list);
        Timeline createMaskingTimeline = createMaskingTimeline();
        if (createMaskingTimeline.isEmpty() || i13 < createMaskingTimeline.getWindowCount()) {
            long j13 = j11;
            if (z11) {
                int firstWindowIndex = createMaskingTimeline.getFirstWindowIndex(this.shuffleModeEnabled);
                j12 = C.TIME_UNSET;
                i12 = firstWindowIndex;
            } else if (i13 == -1) {
                i12 = currentWindowIndexInternal;
                j12 = currentPosition;
            } else {
                i12 = i13;
                j12 = j13;
            }
            PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, maskWindowPositionMsOrGetPeriodPositionUs(createMaskingTimeline, i12, j12));
            int i14 = maskTimelineAndPosition.playbackState;
            if (!(i12 == -1 || i14 == 1)) {
                i14 = (createMaskingTimeline.isEmpty() || i12 >= createMaskingTimeline.getWindowCount()) ? 4 : 2;
            }
            PlaybackInfo copyWithPlaybackState = maskTimelineAndPosition.copyWithPlaybackState(i14);
            this.internalPlayer.setMediaSources(addMediaSourceHolders, i12, Util.msToUs(j12), this.shuffleOrder);
            if (this.playbackInfo.periodId.periodUid.equals(copyWithPlaybackState.periodId.periodUid) || this.playbackInfo.timeline.isEmpty()) {
                z12 = false;
            }
            updatePlaybackInfo(copyWithPlaybackState, 0, 1, false, z12, 4, getCurrentPositionUsInternal(copyWithPlaybackState), -1, false);
            return;
        }
        throw new IllegalSeekPositionException(createMaskingTimeline, i13, j11);
    }

    private void setNonVideoOutputSurfaceHolderInternal(SurfaceHolder surfaceHolder2) {
        this.surfaceHolderSurfaceIsVideoOutput = false;
        this.surfaceHolder = surfaceHolder2;
        surfaceHolder2.addCallback(this.componentListener);
        Surface surface = this.surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        Rect surfaceFrame = this.surfaceHolder.getSurfaceFrame();
        maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
    }

    /* access modifiers changed from: private */
    public void setSurfaceTextureInternal(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        setVideoOutputInternal(surface);
        this.ownedSurface = surface;
    }

    /* access modifiers changed from: private */
    public void setVideoOutputInternal(@Nullable Object obj) {
        boolean z11;
        ArrayList<PlayerMessage> arrayList = new ArrayList<>();
        Renderer[] rendererArr = this.renderers;
        int length = rendererArr.length;
        int i11 = 0;
        while (true) {
            z11 = true;
            if (i11 >= length) {
                break;
            }
            Renderer renderer = rendererArr[i11];
            if (renderer.getTrackType() == 2) {
                arrayList.add(createMessageInternal(renderer).setType(1).setPayload(obj).send());
            }
            i11++;
        }
        Object obj2 = this.videoOutput;
        if (obj2 == null || obj2 == obj) {
            z11 = false;
        } else {
            try {
                for (PlayerMessage blockUntilDelivered : arrayList) {
                    blockUntilDelivered.blockUntilDelivered(this.detachSurfaceTimeoutMs);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z11 = false;
            Object obj3 = this.videoOutput;
            Surface surface = this.ownedSurface;
            if (obj3 == surface) {
                surface.release();
                this.ownedSurface = null;
            }
        }
        this.videoOutput = obj;
        if (z11) {
            stopInternal(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(3), 1003));
        }
    }

    private void stopInternal(boolean z11, @Nullable ExoPlaybackException exoPlaybackException) {
        PlaybackInfo playbackInfo2;
        boolean z12;
        if (z11) {
            playbackInfo2 = removeMediaItemsInternal(0, this.mediaSourceHolderSnapshots.size()).copyWithPlaybackError((ExoPlaybackException) null);
        } else {
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            playbackInfo2 = playbackInfo3.copyWithLoadingMediaPeriodId(playbackInfo3.periodId);
            playbackInfo2.bufferedPositionUs = playbackInfo2.positionUs;
            playbackInfo2.totalBufferedDurationUs = 0;
        }
        PlaybackInfo copyWithPlaybackState = playbackInfo2.copyWithPlaybackState(1);
        if (exoPlaybackException != null) {
            copyWithPlaybackState = copyWithPlaybackState.copyWithPlaybackError(exoPlaybackException);
        }
        PlaybackInfo playbackInfo4 = copyWithPlaybackState;
        this.pendingOperationAcks++;
        this.internalPlayer.stop();
        if (!playbackInfo4.timeline.isEmpty() || this.playbackInfo.timeline.isEmpty()) {
            z12 = false;
        } else {
            z12 = true;
        }
        updatePlaybackInfo(playbackInfo4, 0, 1, false, z12, 4, getCurrentPositionUsInternal(playbackInfo4), -1, false);
    }

    private void updateAvailableCommands() {
        Player.Commands commands = this.availableCommands;
        Player.Commands availableCommands2 = Util.getAvailableCommands(this.wrappingPlayer, this.permanentAvailableCommands);
        this.availableCommands = availableCommands2;
        if (!availableCommands2.equals(commands)) {
            this.listeners.queueEvent(13, new g(this));
        }
    }

    /* access modifiers changed from: private */
    public void updatePlayWhenReady(boolean z11, int i11, int i12) {
        boolean z12;
        int i13 = 0;
        if (!z11 || i11 == -1) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12 && i11 != 1) {
            i13 = 1;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.playWhenReady != z12 || playbackInfo2.playbackSuppressionReason != i13) {
            this.pendingOperationAcks++;
            PlaybackInfo copyWithPlayWhenReady = playbackInfo2.copyWithPlayWhenReady(z12, i13);
            this.internalPlayer.setPlayWhenReady(z12, i13);
            updatePlaybackInfo(copyWithPlayWhenReady, 0, i12, false, false, 5, C.TIME_UNSET, -1, false);
        }
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo2, int i11, int i12, boolean z11, boolean z12, int i13, long j11, int i14, boolean z13) {
        boolean z14;
        boolean z15;
        boolean z16;
        PlaybackInfo playbackInfo3 = playbackInfo2;
        int i15 = i13;
        PlaybackInfo playbackInfo4 = this.playbackInfo;
        this.playbackInfo = playbackInfo3;
        boolean z17 = !playbackInfo4.timeline.equals(playbackInfo3.timeline);
        Pair<Boolean, Integer> evaluateMediaItemTransitionReason = evaluateMediaItemTransitionReason(playbackInfo2, playbackInfo4, z12, i13, z17, z13);
        boolean booleanValue = ((Boolean) evaluateMediaItemTransitionReason.first).booleanValue();
        int intValue = ((Integer) evaluateMediaItemTransitionReason.second).intValue();
        MediaMetadata mediaMetadata2 = this.mediaMetadata;
        MediaItem mediaItem = null;
        if (booleanValue) {
            if (!playbackInfo3.timeline.isEmpty()) {
                mediaItem = playbackInfo3.timeline.getWindow(playbackInfo3.timeline.getPeriodByUid(playbackInfo3.periodId.periodUid, this.period).windowIndex, this.window).mediaItem;
            }
            this.staticAndDynamicMediaMetadata = MediaMetadata.EMPTY;
        }
        if (booleanValue || !playbackInfo4.staticMetadata.equals(playbackInfo3.staticMetadata)) {
            this.staticAndDynamicMediaMetadata = this.staticAndDynamicMediaMetadata.buildUpon().populateFromMetadata(playbackInfo3.staticMetadata).build();
            mediaMetadata2 = buildUpdatedMediaMetadata();
        }
        boolean z18 = !mediaMetadata2.equals(this.mediaMetadata);
        this.mediaMetadata = mediaMetadata2;
        if (playbackInfo4.playWhenReady != playbackInfo3.playWhenReady) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (playbackInfo4.playbackState != playbackInfo3.playbackState) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15 || z14) {
            updateWakeAndWifiLock();
        }
        boolean z19 = playbackInfo4.isLoading;
        boolean z21 = playbackInfo3.isLoading;
        if (z19 != z21) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            updatePriorityTaskManagerForIsLoadingChange(z21);
        }
        if (z17) {
            this.listeners.queueEvent(0, new h(playbackInfo3, i11));
        }
        if (z12) {
            this.listeners.queueEvent(11, new n(i15, getPreviousPositionInfo(i15, playbackInfo4, i14), getPositionInfo(j11)));
        }
        if (booleanValue) {
            this.listeners.queueEvent(1, new o(mediaItem, intValue));
        }
        if (playbackInfo4.playbackError != playbackInfo3.playbackError) {
            this.listeners.queueEvent(10, new p(playbackInfo3));
            if (playbackInfo3.playbackError != null) {
                this.listeners.queueEvent(10, new q(playbackInfo3));
            }
        }
        TrackSelectorResult trackSelectorResult = playbackInfo4.trackSelectorResult;
        TrackSelectorResult trackSelectorResult2 = playbackInfo3.trackSelectorResult;
        if (trackSelectorResult != trackSelectorResult2) {
            this.trackSelector.onSelectionActivated(trackSelectorResult2.info);
            this.listeners.queueEvent(2, new r(playbackInfo3));
        }
        if (z18) {
            this.listeners.queueEvent(14, new s(this.mediaMetadata));
        }
        if (z16) {
            this.listeners.queueEvent(3, new t(playbackInfo3));
        }
        if (z15 || z14) {
            this.listeners.queueEvent(-1, new u(playbackInfo3));
        }
        if (z15) {
            this.listeners.queueEvent(4, new v(playbackInfo3));
        }
        if (z14) {
            this.listeners.queueEvent(5, new i(playbackInfo3, i12));
        }
        if (playbackInfo4.playbackSuppressionReason != playbackInfo3.playbackSuppressionReason) {
            this.listeners.queueEvent(6, new j(playbackInfo3));
        }
        if (isPlaying(playbackInfo4) != isPlaying(playbackInfo2)) {
            this.listeners.queueEvent(7, new k(playbackInfo3));
        }
        if (!playbackInfo4.playbackParameters.equals(playbackInfo3.playbackParameters)) {
            this.listeners.queueEvent(12, new l(playbackInfo3));
        }
        if (z11) {
            this.listeners.queueEvent(-1, new j0());
        }
        updateAvailableCommands();
        this.listeners.flushEvents();
        if (playbackInfo4.sleepingForOffload != playbackInfo3.sleepingForOffload) {
            Iterator<ExoPlayer.AudioOffloadListener> it = this.audioOffloadListeners.iterator();
            while (it.hasNext()) {
                it.next().onExperimentalSleepingForOffloadChanged(playbackInfo3.sleepingForOffload);
            }
        }
    }

    private void updatePriorityTaskManagerForIsLoadingChange(boolean z11) {
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        if (priorityTaskManager2 == null) {
            return;
        }
        if (z11 && !this.isPriorityTaskManagerRegistered) {
            priorityTaskManager2.add(0);
            this.isPriorityTaskManagerRegistered = true;
        } else if (!z11 && this.isPriorityTaskManagerRegistered) {
            priorityTaskManager2.remove(0);
            this.isPriorityTaskManagerRegistered = false;
        }
    }

    /* access modifiers changed from: private */
    public void updateWakeAndWifiLock() {
        int playbackState = getPlaybackState();
        boolean z11 = true;
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                boolean experimentalIsSleepingForOffload = experimentalIsSleepingForOffload();
                WakeLockManager wakeLockManager2 = this.wakeLockManager;
                if (!getPlayWhenReady() || experimentalIsSleepingForOffload) {
                    z11 = false;
                }
                wakeLockManager2.setStayAwake(z11);
                this.wifiLockManager.setStayAwake(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
    }

    private void verifyApplicationThread() {
        IllegalStateException illegalStateException;
        this.constructorFinished.blockUninterruptible();
        if (Thread.currentThread() != getApplicationLooper().getThread()) {
            String formatInvariant = Util.formatInvariant("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), getApplicationLooper().getThread().getName());
            if (!this.throwsWhenUsingWrongThread) {
                if (this.hasNotifiedFullWrongThreadWarning) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                Log.w(TAG, formatInvariant, illegalStateException);
                this.hasNotifiedFullWrongThreadWarning = true;
                return;
            }
            throw new IllegalStateException(formatInvariant);
        }
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        this.analyticsCollector.addListener((AnalyticsListener) Assertions.checkNotNull(analyticsListener));
    }

    public void addAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.audioOffloadListeners.add(audioOffloadListener);
    }

    public void addListener(Player.Listener listener) {
        this.listeners.add((Player.Listener) Assertions.checkNotNull(listener));
    }

    public void addMediaItems(int i11, List<MediaItem> list) {
        verifyApplicationThread();
        addMediaSources(i11, createMediaSources(list));
    }

    public void addMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        addMediaSources(Collections.singletonList(mediaSource));
    }

    public void addMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        addMediaSources(this.mediaSourceHolderSnapshots.size(), list);
    }

    public void clearAuxEffectInfo() {
        verifyApplicationThread();
        setAuxEffectInfo(new AuxEffectInfo(0, 0.0f));
    }

    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener2) {
        verifyApplicationThread();
        if (this.cameraMotionListener == cameraMotionListener2) {
            createMessageInternal(this.frameMetadataListener).setType(8).setPayload((Object) null).send();
        }
    }

    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener2) {
        verifyApplicationThread();
        if (this.videoFrameMetadataListener == videoFrameMetadataListener2) {
            createMessageInternal(this.frameMetadataListener).setType(7).setPayload((Object) null).send();
        }
    }

    public void clearVideoSurface() {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoOutputInternal((Object) null);
        maybeNotifySurfaceSizeChanged(0, 0);
    }

    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder2) {
        verifyApplicationThread();
        if (surfaceHolder2 != null && surfaceHolder2 == this.surfaceHolder) {
            clearVideoSurface();
        }
    }

    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder2;
        verifyApplicationThread();
        if (surfaceView == null) {
            surfaceHolder2 = null;
        } else {
            surfaceHolder2 = surfaceView.getHolder();
        }
        clearVideoSurfaceHolder(surfaceHolder2);
    }

    public void clearVideoTextureView(@Nullable TextureView textureView2) {
        verifyApplicationThread();
        if (textureView2 != null && textureView2 == this.textureView) {
            clearVideoSurface();
        }
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        verifyApplicationThread();
        return createMessageInternal(target);
    }

    public void decreaseDeviceVolume() {
        verifyApplicationThread();
        this.streamVolumeManager.decreaseVolume();
    }

    public boolean experimentalIsSleepingForOffload() {
        verifyApplicationThread();
        return this.playbackInfo.sleepingForOffload;
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z11) {
        verifyApplicationThread();
        this.internalPlayer.experimentalSetOffloadSchedulingEnabled(z11);
        Iterator<ExoPlayer.AudioOffloadListener> it = this.audioOffloadListeners.iterator();
        while (it.hasNext()) {
            it.next().onExperimentalOffloadSchedulingEnabledChanged(z11);
        }
    }

    public AnalyticsCollector getAnalyticsCollector() {
        verifyApplicationThread();
        return this.analyticsCollector;
    }

    public Looper getApplicationLooper() {
        return this.applicationLooper;
    }

    public AudioAttributes getAudioAttributes() {
        verifyApplicationThread();
        return this.audioAttributes;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ExoPlayer.AudioComponent getAudioComponent() {
        verifyApplicationThread();
        return this;
    }

    @Nullable
    public DecoderCounters getAudioDecoderCounters() {
        verifyApplicationThread();
        return this.audioDecoderCounters;
    }

    @Nullable
    public Format getAudioFormat() {
        verifyApplicationThread();
        return this.audioFormat;
    }

    public int getAudioSessionId() {
        verifyApplicationThread();
        return this.audioSessionId;
    }

    public Player.Commands getAvailableCommands() {
        verifyApplicationThread();
        return this.availableCommands;
    }

    public long getBufferedPosition() {
        verifyApplicationThread();
        if (!isPlayingAd()) {
            return getContentBufferedPosition();
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.loadingMediaPeriodId.equals(playbackInfo2.periodId)) {
            return Util.usToMs(this.playbackInfo.bufferedPositionUs);
        }
        return getDuration();
    }

    public Clock getClock() {
        return this.clock;
    }

    public long getContentBufferedPosition() {
        verifyApplicationThread();
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingWindowPositionMs;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.loadingMediaPeriodId.windowSequenceNumber != playbackInfo2.periodId.windowSequenceNumber) {
            return playbackInfo2.timeline.getWindow(getCurrentMediaItemIndex(), this.window).getDurationMs();
        }
        long j11 = playbackInfo2.bufferedPositionUs;
        if (this.playbackInfo.loadingMediaPeriodId.isAd()) {
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            Timeline.Period periodByUid = playbackInfo3.timeline.getPeriodByUid(playbackInfo3.loadingMediaPeriodId.periodUid, this.period);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.playbackInfo.loadingMediaPeriodId.adGroupIndex);
            if (adGroupTimeUs == Long.MIN_VALUE) {
                j11 = periodByUid.durationUs;
            } else {
                j11 = adGroupTimeUs;
            }
        }
        PlaybackInfo playbackInfo4 = this.playbackInfo;
        return Util.usToMs(periodPositionUsToWindowPositionUs(playbackInfo4.timeline, playbackInfo4.loadingMediaPeriodId, j11));
    }

    public long getContentPosition() {
        verifyApplicationThread();
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        playbackInfo2.timeline.getPeriodByUid(playbackInfo2.periodId.periodUid, this.period);
        PlaybackInfo playbackInfo3 = this.playbackInfo;
        if (playbackInfo3.requestedContentPositionUs == C.TIME_UNSET) {
            return playbackInfo3.timeline.getWindow(getCurrentMediaItemIndex(), this.window).getDefaultPositionMs();
        }
        return this.period.getPositionInWindowMs() + Util.usToMs(this.playbackInfo.requestedContentPositionUs);
    }

    public int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    public int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    public CueGroup getCurrentCues() {
        verifyApplicationThread();
        return this.currentCueGroup;
    }

    public int getCurrentMediaItemIndex() {
        verifyApplicationThread();
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        if (currentWindowIndexInternal == -1) {
            return 0;
        }
        return currentWindowIndexInternal;
    }

    public int getCurrentPeriodIndex() {
        verifyApplicationThread();
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingPeriodIndex;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        return playbackInfo2.timeline.getIndexOfPeriod(playbackInfo2.periodId.periodUid);
    }

    public long getCurrentPosition() {
        verifyApplicationThread();
        return Util.usToMs(getCurrentPositionUsInternal(this.playbackInfo));
    }

    public Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return this.playbackInfo.timeline;
    }

    public TrackGroupArray getCurrentTrackGroups() {
        verifyApplicationThread();
        return this.playbackInfo.trackGroups;
    }

    public TrackSelectionArray getCurrentTrackSelections() {
        verifyApplicationThread();
        return new TrackSelectionArray(this.playbackInfo.trackSelectorResult.selections);
    }

    public Tracks getCurrentTracks() {
        verifyApplicationThread();
        return this.playbackInfo.trackSelectorResult.tracks;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ExoPlayer.DeviceComponent getDeviceComponent() {
        verifyApplicationThread();
        return this;
    }

    public DeviceInfo getDeviceInfo() {
        verifyApplicationThread();
        return this.deviceInfo;
    }

    public int getDeviceVolume() {
        verifyApplicationThread();
        return this.streamVolumeManager.getVolume();
    }

    public long getDuration() {
        verifyApplicationThread();
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.periodId;
        playbackInfo2.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return Util.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
    }

    public long getMaxSeekToPreviousPosition() {
        verifyApplicationThread();
        return C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    }

    public MediaMetadata getMediaMetadata() {
        verifyApplicationThread();
        return this.mediaMetadata;
    }

    public boolean getPauseAtEndOfMediaItems() {
        verifyApplicationThread();
        return this.pauseAtEndOfMediaItems;
    }

    public boolean getPlayWhenReady() {
        verifyApplicationThread();
        return this.playbackInfo.playWhenReady;
    }

    public Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    public PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return this.playbackInfo.playbackParameters;
    }

    public int getPlaybackState() {
        verifyApplicationThread();
        return this.playbackInfo.playbackState;
    }

    public int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        return this.playbackInfo.playbackSuppressionReason;
    }

    public MediaMetadata getPlaylistMetadata() {
        verifyApplicationThread();
        return this.playlistMetadata;
    }

    public Renderer getRenderer(int i11) {
        verifyApplicationThread();
        return this.renderers[i11];
    }

    public int getRendererCount() {
        verifyApplicationThread();
        return this.renderers.length;
    }

    public int getRendererType(int i11) {
        verifyApplicationThread();
        return this.renderers[i11].getTrackType();
    }

    public int getRepeatMode() {
        verifyApplicationThread();
        return this.repeatMode;
    }

    public long getSeekBackIncrement() {
        verifyApplicationThread();
        return this.seekBackIncrementMs;
    }

    public long getSeekForwardIncrement() {
        verifyApplicationThread();
        return this.seekForwardIncrementMs;
    }

    public SeekParameters getSeekParameters() {
        verifyApplicationThread();
        return this.seekParameters;
    }

    public boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return this.shuffleModeEnabled;
    }

    public boolean getSkipSilenceEnabled() {
        verifyApplicationThread();
        return this.skipSilenceEnabled;
    }

    public Size getSurfaceSize() {
        verifyApplicationThread();
        return this.surfaceSize;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ExoPlayer.TextComponent getTextComponent() {
        verifyApplicationThread();
        return this;
    }

    public long getTotalBufferedDuration() {
        verifyApplicationThread();
        return Util.usToMs(this.playbackInfo.totalBufferedDurationUs);
    }

    public TrackSelectionParameters getTrackSelectionParameters() {
        verifyApplicationThread();
        return this.trackSelector.getParameters();
    }

    public TrackSelector getTrackSelector() {
        verifyApplicationThread();
        return this.trackSelector;
    }

    public int getVideoChangeFrameRateStrategy() {
        verifyApplicationThread();
        return this.videoChangeFrameRateStrategy;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ExoPlayer.VideoComponent getVideoComponent() {
        verifyApplicationThread();
        return this;
    }

    @Nullable
    public DecoderCounters getVideoDecoderCounters() {
        verifyApplicationThread();
        return this.videoDecoderCounters;
    }

    @Nullable
    public Format getVideoFormat() {
        verifyApplicationThread();
        return this.videoFormat;
    }

    public int getVideoScalingMode() {
        verifyApplicationThread();
        return this.videoScalingMode;
    }

    public VideoSize getVideoSize() {
        verifyApplicationThread();
        return this.videoSize;
    }

    public float getVolume() {
        verifyApplicationThread();
        return this.volume;
    }

    public void increaseDeviceVolume() {
        verifyApplicationThread();
        this.streamVolumeManager.increaseVolume();
    }

    public boolean isDeviceMuted() {
        verifyApplicationThread();
        return this.streamVolumeManager.isMuted();
    }

    public boolean isLoading() {
        verifyApplicationThread();
        return this.playbackInfo.isLoading;
    }

    public boolean isPlayingAd() {
        verifyApplicationThread();
        return this.playbackInfo.periodId.isAd();
    }

    public boolean isTunnelingEnabled() {
        verifyApplicationThread();
        for (RendererConfiguration rendererConfiguration : this.playbackInfo.trackSelectorResult.rendererConfigurations) {
            if (rendererConfiguration != null && rendererConfiguration.tunneling) {
                return true;
            }
        }
        return false;
    }

    public void moveMediaItems(int i11, int i12, int i13) {
        boolean z11;
        int i14 = i11;
        int i15 = i12;
        int i16 = i13;
        verifyApplicationThread();
        if (i14 < 0 || i14 > i15 || i16 < 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        int size = this.mediaSourceHolderSnapshots.size();
        int min = Math.min(i12, size);
        int min2 = Math.min(i16, size - (min - i14));
        if (i14 < size && i14 != min && i14 != min2) {
            Timeline currentTimeline = getCurrentTimeline();
            this.pendingOperationAcks++;
            Util.moveItems(this.mediaSourceHolderSnapshots, i11, min, min2);
            Timeline createMaskingTimeline = createMaskingTimeline();
            PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionUsAfterTimelineChanged(currentTimeline, createMaskingTimeline));
            this.internalPlayer.moveMediaSources(i11, min, min2, this.shuffleOrder);
            updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, C.TIME_UNSET, -1, false);
        }
    }

    public void prepare() {
        verifyApplicationThread();
        boolean playWhenReady = getPlayWhenReady();
        int i11 = 2;
        int updateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, 2);
        updatePlayWhenReady(playWhenReady, updateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, updateAudioFocus));
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.playbackState == 1) {
            PlaybackInfo copyWithPlaybackError = playbackInfo2.copyWithPlaybackError((ExoPlaybackException) null);
            if (copyWithPlaybackError.timeline.isEmpty()) {
                i11 = 4;
            }
            PlaybackInfo copyWithPlaybackState = copyWithPlaybackError.copyWithPlaybackState(i11);
            this.pendingOperationAcks++;
            this.internalPlayer.prepare();
            updatePlaybackInfo(copyWithPlaybackState, 1, 1, false, false, 5, C.TIME_UNSET, -1, false);
        }
    }

    public void release() {
        AudioTrack audioTrack;
        Log.i(TAG, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + "]");
        verifyApplicationThread();
        if (Util.SDK_INT < 21 && (audioTrack = this.keepSessionIdAudioTrack) != null) {
            audioTrack.release();
            this.keepSessionIdAudioTrack = null;
        }
        this.audioBecomingNoisyManager.setEnabled(false);
        this.streamVolumeManager.release();
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
        this.audioFocusManager.release();
        if (!this.internalPlayer.release()) {
            this.listeners.sendEvent(10, new d0());
        }
        this.listeners.release();
        this.playbackInfoUpdateHandler.removeCallbacksAndMessages((Object) null);
        this.bandwidthMeter.removeEventListener(this.analyticsCollector);
        PlaybackInfo copyWithPlaybackState = this.playbackInfo.copyWithPlaybackState(1);
        this.playbackInfo = copyWithPlaybackState;
        PlaybackInfo copyWithLoadingMediaPeriodId = copyWithPlaybackState.copyWithLoadingMediaPeriodId(copyWithPlaybackState.periodId);
        this.playbackInfo = copyWithLoadingMediaPeriodId;
        copyWithLoadingMediaPeriodId.bufferedPositionUs = copyWithLoadingMediaPeriodId.positionUs;
        this.playbackInfo.totalBufferedDurationUs = 0;
        this.analyticsCollector.release();
        this.trackSelector.release();
        removeSurfaceCallbacks();
        Surface surface = this.ownedSurface;
        if (surface != null) {
            surface.release();
            this.ownedSurface = null;
        }
        if (this.isPriorityTaskManagerRegistered) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            this.isPriorityTaskManagerRegistered = false;
        }
        this.currentCueGroup = CueGroup.EMPTY_TIME_ZERO;
        this.playerReleased = true;
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        verifyApplicationThread();
        this.analyticsCollector.removeListener((AnalyticsListener) Assertions.checkNotNull(analyticsListener));
    }

    public void removeAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        verifyApplicationThread();
        this.audioOffloadListeners.remove(audioOffloadListener);
    }

    public void removeListener(Player.Listener listener) {
        verifyApplicationThread();
        this.listeners.remove((Player.Listener) Assertions.checkNotNull(listener));
    }

    public void removeMediaItems(int i11, int i12) {
        boolean z11;
        verifyApplicationThread();
        if (i11 < 0 || i12 < i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        int size = this.mediaSourceHolderSnapshots.size();
        int min = Math.min(i12, size);
        if (i11 < size && i11 != min) {
            PlaybackInfo removeMediaItemsInternal = removeMediaItemsInternal(i11, min);
            updatePlaybackInfo(removeMediaItemsInternal, 0, 1, false, !removeMediaItemsInternal.periodId.periodUid.equals(this.playbackInfo.periodId.periodUid), 4, getCurrentPositionUsInternal(removeMediaItemsInternal), -1, false);
        }
    }

    @Deprecated
    public void retry() {
        verifyApplicationThread();
        prepare();
    }

    public void seekTo(int i11, long j11, int i12, boolean z11) {
        boolean z12;
        int i13 = i11;
        verifyApplicationThread();
        int i14 = 1;
        if (i13 >= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Assertions.checkArgument(z12);
        this.analyticsCollector.notifySeekStarted();
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty() || i13 < timeline.getWindowCount()) {
            this.pendingOperationAcks++;
            if (isPlayingAd()) {
                Log.w(TAG, "seekTo ignored because an ad is playing");
                ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(this.playbackInfo);
                playbackInfoUpdate.incrementPendingOperationAcks(1);
                this.playbackInfoUpdateListener.onPlaybackInfoUpdate(playbackInfoUpdate);
                return;
            }
            if (getPlaybackState() != 1) {
                i14 = 2;
            }
            int currentMediaItemIndex = getCurrentMediaItemIndex();
            long j12 = j11;
            PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo.copyWithPlaybackState(i14), timeline, maskWindowPositionMsOrGetPeriodPositionUs(timeline, i11, j11));
            this.internalPlayer.seekTo(timeline, i11, Util.msToUs(j11));
            updatePlaybackInfo(maskTimelineAndPosition, 0, 1, true, true, 1, getCurrentPositionUsInternal(maskTimelineAndPosition), currentMediaItemIndex, z11);
        }
    }

    public void setAudioAttributes(AudioAttributes audioAttributes2, boolean z11) {
        AudioAttributes audioAttributes3;
        verifyApplicationThread();
        if (!this.playerReleased) {
            if (!Util.areEqual(this.audioAttributes, audioAttributes2)) {
                this.audioAttributes = audioAttributes2;
                sendRendererMessage(1, 3, audioAttributes2);
                this.streamVolumeManager.setStreamType(Util.getStreamTypeForAudioUsage(audioAttributes2.usage));
                this.listeners.queueEvent(20, new y(audioAttributes2));
            }
            AudioFocusManager audioFocusManager2 = this.audioFocusManager;
            if (z11) {
                audioAttributes3 = audioAttributes2;
            } else {
                audioAttributes3 = null;
            }
            audioFocusManager2.setAudioAttributes(audioAttributes3);
            this.trackSelector.setAudioAttributes(audioAttributes2);
            boolean playWhenReady = getPlayWhenReady();
            int updateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, getPlaybackState());
            updatePlayWhenReady(playWhenReady, updateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, updateAudioFocus));
            this.listeners.flushEvents();
        }
    }

    public void setAudioSessionId(int i11) {
        verifyApplicationThread();
        if (this.audioSessionId != i11) {
            if (i11 == 0) {
                if (Util.SDK_INT < 21) {
                    i11 = initializeKeepSessionIdAudioTrack(0);
                } else {
                    i11 = Util.generateAudioSessionIdV21(this.applicationContext);
                }
            } else if (Util.SDK_INT < 21) {
                initializeKeepSessionIdAudioTrack(i11);
            }
            this.audioSessionId = i11;
            sendRendererMessage(1, 10, Integer.valueOf(i11));
            sendRendererMessage(2, 10, Integer.valueOf(i11));
            this.listeners.sendEvent(21, new a0(i11));
        }
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        verifyApplicationThread();
        sendRendererMessage(1, 6, auxEffectInfo);
    }

    public void setCameraMotionListener(CameraMotionListener cameraMotionListener2) {
        verifyApplicationThread();
        this.cameraMotionListener = cameraMotionListener2;
        createMessageInternal(this.frameMetadataListener).setType(8).setPayload(cameraMotionListener2).send();
    }

    public void setDeviceMuted(boolean z11) {
        verifyApplicationThread();
        this.streamVolumeManager.setMuted(z11);
    }

    public void setDeviceVolume(int i11) {
        verifyApplicationThread();
        this.streamVolumeManager.setVolume(i11);
    }

    public void setForegroundMode(boolean z11) {
        verifyApplicationThread();
        if (this.foregroundMode != z11) {
            this.foregroundMode = z11;
            if (!this.internalPlayer.setForegroundMode(z11)) {
                stopInternal(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(2), 1003));
            }
        }
    }

    public void setHandleAudioBecomingNoisy(boolean z11) {
        verifyApplicationThread();
        if (!this.playerReleased) {
            this.audioBecomingNoisyManager.setEnabled(z11);
        }
    }

    public void setHandleWakeLock(boolean z11) {
        verifyApplicationThread();
        setWakeMode(z11 ? 1 : 0);
    }

    public void setMediaItems(List<MediaItem> list, boolean z11) {
        verifyApplicationThread();
        setMediaSources(createMediaSources(list), z11);
    }

    public void setMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        setMediaSources(Collections.singletonList(mediaSource));
    }

    public void setMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        setMediaSources(list, true);
    }

    public void setPauseAtEndOfMediaItems(boolean z11) {
        verifyApplicationThread();
        if (this.pauseAtEndOfMediaItems != z11) {
            this.pauseAtEndOfMediaItems = z11;
            this.internalPlayer.setPauseAtEndOfWindow(z11);
        }
    }

    public void setPlayWhenReady(boolean z11) {
        verifyApplicationThread();
        int updateAudioFocus = this.audioFocusManager.updateAudioFocus(z11, getPlaybackState());
        updatePlayWhenReady(z11, updateAudioFocus, getPlayWhenReadyChangeReason(z11, updateAudioFocus));
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        if (!this.playbackInfo.playbackParameters.equals(playbackParameters)) {
            PlaybackInfo copyWithPlaybackParameters = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
            this.pendingOperationAcks++;
            this.internalPlayer.setPlaybackParameters(playbackParameters);
            updatePlaybackInfo(copyWithPlaybackParameters, 0, 1, false, false, 5, C.TIME_UNSET, -1, false);
        }
    }

    public void setPlaylistMetadata(MediaMetadata mediaMetadata2) {
        verifyApplicationThread();
        Assertions.checkNotNull(mediaMetadata2);
        if (!mediaMetadata2.equals(this.playlistMetadata)) {
            this.playlistMetadata = mediaMetadata2;
            this.listeners.sendEvent(15, new b0(this));
        }
    }

    @RequiresApi(23)
    public void setPreferredAudioDevice(@Nullable AudioDeviceInfo audioDeviceInfo) {
        verifyApplicationThread();
        sendRendererMessage(1, 12, audioDeviceInfo);
    }

    public void setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager2) {
        verifyApplicationThread();
        if (!Util.areEqual(this.priorityTaskManager, priorityTaskManager2)) {
            if (this.isPriorityTaskManagerRegistered) {
                ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            }
            if (priorityTaskManager2 == null || !isLoading()) {
                this.isPriorityTaskManagerRegistered = false;
            } else {
                priorityTaskManager2.add(0);
                this.isPriorityTaskManagerRegistered = true;
            }
            this.priorityTaskManager = priorityTaskManager2;
        }
    }

    public void setRepeatMode(int i11) {
        verifyApplicationThread();
        if (this.repeatMode != i11) {
            this.repeatMode = i11;
            this.internalPlayer.setRepeatMode(i11);
            this.listeners.queueEvent(8, new e(i11));
            updateAvailableCommands();
            this.listeners.flushEvents();
        }
    }

    public void setSeekParameters(@Nullable SeekParameters seekParameters2) {
        verifyApplicationThread();
        if (seekParameters2 == null) {
            seekParameters2 = SeekParameters.DEFAULT;
        }
        if (!this.seekParameters.equals(seekParameters2)) {
            this.seekParameters = seekParameters2;
            this.internalPlayer.setSeekParameters(seekParameters2);
        }
    }

    public void setShuffleModeEnabled(boolean z11) {
        verifyApplicationThread();
        if (this.shuffleModeEnabled != z11) {
            this.shuffleModeEnabled = z11;
            this.internalPlayer.setShuffleModeEnabled(z11);
            this.listeners.queueEvent(9, new c0(z11));
            updateAvailableCommands();
            this.listeners.flushEvents();
        }
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder2) {
        verifyApplicationThread();
        this.shuffleOrder = shuffleOrder2;
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, maskWindowPositionMsOrGetPeriodPositionUs(createMaskingTimeline, getCurrentMediaItemIndex(), getCurrentPosition()));
        this.pendingOperationAcks++;
        this.internalPlayer.setShuffleOrder(shuffleOrder2);
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, C.TIME_UNSET, -1, false);
    }

    public void setSkipSilenceEnabled(boolean z11) {
        verifyApplicationThread();
        if (this.skipSilenceEnabled != z11) {
            this.skipSilenceEnabled = z11;
            sendRendererMessage(1, 9, Boolean.valueOf(z11));
            this.listeners.sendEvent(23, new x(z11));
        }
    }

    public void setThrowsWhenUsingWrongThread(boolean z11) {
        this.throwsWhenUsingWrongThread = z11;
        this.listeners.setThrowsWhenUsingWrongThread(z11);
        AnalyticsCollector analyticsCollector2 = this.analyticsCollector;
        if (analyticsCollector2 instanceof DefaultAnalyticsCollector) {
            ((DefaultAnalyticsCollector) analyticsCollector2).setThrowsWhenUsingWrongThread(z11);
        }
    }

    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        verifyApplicationThread();
        if (this.trackSelector.isSetParametersSupported() && !trackSelectionParameters.equals(this.trackSelector.getParameters())) {
            this.trackSelector.setParameters(trackSelectionParameters);
            this.listeners.sendEvent(19, new f(trackSelectionParameters));
        }
    }

    public void setVideoChangeFrameRateStrategy(int i11) {
        verifyApplicationThread();
        if (this.videoChangeFrameRateStrategy != i11) {
            this.videoChangeFrameRateStrategy = i11;
            sendRendererMessage(2, 5, Integer.valueOf(i11));
        }
    }

    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener2) {
        verifyApplicationThread();
        this.videoFrameMetadataListener = videoFrameMetadataListener2;
        createMessageInternal(this.frameMetadataListener).setType(7).setPayload(videoFrameMetadataListener2).send();
    }

    public void setVideoScalingMode(int i11) {
        verifyApplicationThread();
        this.videoScalingMode = i11;
        sendRendererMessage(2, 4, Integer.valueOf(i11));
    }

    public void setVideoSurface(@Nullable Surface surface) {
        int i11;
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoOutputInternal(surface);
        if (surface == null) {
            i11 = 0;
        } else {
            i11 = -1;
        }
        maybeNotifySurfaceSizeChanged(i11, i11);
    }

    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder2) {
        verifyApplicationThread();
        if (surfaceHolder2 == null) {
            clearVideoSurface();
            return;
        }
        removeSurfaceCallbacks();
        this.surfaceHolderSurfaceIsVideoOutput = true;
        this.surfaceHolder = surfaceHolder2;
        surfaceHolder2.addCallback(this.componentListener);
        Surface surface = surfaceHolder2.getSurface();
        if (surface == null || !surface.isValid()) {
            setVideoOutputInternal((Object) null);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        setVideoOutputInternal(surface);
        Rect surfaceFrame = surfaceHolder2.getSurfaceFrame();
        maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
    }

    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder2;
        verifyApplicationThread();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            removeSurfaceCallbacks();
            setVideoOutputInternal(surfaceView);
            setNonVideoOutputSurfaceHolderInternal(surfaceView.getHolder());
        } else if (surfaceView instanceof SphericalGLSurfaceView) {
            removeSurfaceCallbacks();
            this.sphericalGLSurfaceView = (SphericalGLSurfaceView) surfaceView;
            createMessageInternal(this.frameMetadataListener).setType(10000).setPayload(this.sphericalGLSurfaceView).send();
            this.sphericalGLSurfaceView.addVideoSurfaceListener(this.componentListener);
            setVideoOutputInternal(this.sphericalGLSurfaceView.getVideoSurface());
            setNonVideoOutputSurfaceHolderInternal(surfaceView.getHolder());
        } else {
            if (surfaceView == null) {
                surfaceHolder2 = null;
            } else {
                surfaceHolder2 = surfaceView.getHolder();
            }
            setVideoSurfaceHolder(surfaceHolder2);
        }
    }

    public void setVideoTextureView(@Nullable TextureView textureView2) {
        SurfaceTexture surfaceTexture;
        verifyApplicationThread();
        if (textureView2 == null) {
            clearVideoSurface();
            return;
        }
        removeSurfaceCallbacks();
        this.textureView = textureView2;
        if (textureView2.getSurfaceTextureListener() != null) {
            Log.w(TAG, "Replacing existing SurfaceTextureListener.");
        }
        textureView2.setSurfaceTextureListener(this.componentListener);
        if (textureView2.isAvailable()) {
            surfaceTexture = textureView2.getSurfaceTexture();
        } else {
            surfaceTexture = null;
        }
        if (surfaceTexture == null) {
            setVideoOutputInternal((Object) null);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        setSurfaceTextureInternal(surfaceTexture);
        maybeNotifySurfaceSizeChanged(textureView2.getWidth(), textureView2.getHeight());
    }

    public void setVolume(float f11) {
        verifyApplicationThread();
        float constrainValue = Util.constrainValue(f11, 0.0f, 1.0f);
        if (this.volume != constrainValue) {
            this.volume = constrainValue;
            sendVolumeToRenderers();
            this.listeners.sendEvent(22, new d(constrainValue));
        }
    }

    public void setWakeMode(int i11) {
        verifyApplicationThread();
        if (i11 == 0) {
            this.wakeLockManager.setEnabled(false);
            this.wifiLockManager.setEnabled(false);
        } else if (i11 == 1) {
            this.wakeLockManager.setEnabled(true);
            this.wifiLockManager.setEnabled(false);
        } else if (i11 == 2) {
            this.wakeLockManager.setEnabled(true);
            this.wifiLockManager.setEnabled(true);
        }
    }

    public void stop() {
        verifyApplicationThread();
        stop(false);
    }

    @Nullable
    public ExoPlaybackException getPlayerError() {
        verifyApplicationThread();
        return this.playbackInfo.playbackError;
    }

    public void addMediaSource(int i11, MediaSource mediaSource) {
        verifyApplicationThread();
        addMediaSources(i11, Collections.singletonList(mediaSource));
    }

    public void addMediaSources(int i11, List<MediaSource> list) {
        verifyApplicationThread();
        Assertions.checkArgument(i11 >= 0);
        int min = Math.min(i11, this.mediaSourceHolderSnapshots.size());
        Timeline currentTimeline = getCurrentTimeline();
        this.pendingOperationAcks++;
        List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders = addMediaSourceHolders(min, list);
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionUsAfterTimelineChanged(currentTimeline, createMaskingTimeline));
        this.internalPlayer.addMediaSources(min, addMediaSourceHolders, this.shuffleOrder);
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, C.TIME_UNSET, -1, false);
    }

    public void setMediaItems(List<MediaItem> list, int i11, long j11) {
        verifyApplicationThread();
        setMediaSources(createMediaSources(list), i11, j11);
    }

    public void setMediaSource(MediaSource mediaSource, long j11) {
        verifyApplicationThread();
        setMediaSources(Collections.singletonList(mediaSource), 0, j11);
    }

    public void setMediaSources(List<MediaSource> list, boolean z11) {
        verifyApplicationThread();
        setMediaSourcesInternal(list, -1, C.TIME_UNSET, z11);
    }

    public void stop(boolean z11) {
        verifyApplicationThread();
        this.audioFocusManager.updateAudioFocus(getPlayWhenReady(), 1);
        stopInternal(z11, (ExoPlaybackException) null);
        this.currentCueGroup = new CueGroup(ImmutableList.of(), this.playbackInfo.positionUs);
    }

    public void clearVideoSurface(@Nullable Surface surface) {
        verifyApplicationThread();
        if (surface != null && surface == this.videoOutput) {
            clearVideoSurface();
        }
    }

    public void setMediaSources(List<MediaSource> list, int i11, long j11) {
        verifyApplicationThread();
        setMediaSourcesInternal(list, i11, j11, false);
    }

    public void setMediaSource(MediaSource mediaSource, boolean z11) {
        verifyApplicationThread();
        setMediaSources(Collections.singletonList(mediaSource), z11);
    }

    @Deprecated
    public void prepare(MediaSource mediaSource) {
        verifyApplicationThread();
        setMediaSource(mediaSource);
        prepare();
    }

    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z11, boolean z12) {
        verifyApplicationThread();
        setMediaSource(mediaSource, z11);
        prepare();
    }
}
