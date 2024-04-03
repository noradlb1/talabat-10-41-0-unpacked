package io.flutter.plugins.videoplayer;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.video.VideoSize;
import g7.y0;
import io.flutter.plugin.common.EventChannel;
import io.flutter.view.TextureRegistry;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tracking.gtm.TalabatGTM;

final class VideoPlayer {
    private static final String FORMAT_DASH = "dash";
    private static final String FORMAT_HLS = "hls";
    private static final String FORMAT_OTHER = "other";
    private static final String FORMAT_SS = "ss";
    private static final String USER_AGENT = "User-Agent";
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public boolean f14391a = false;
    private final EventChannel eventChannel;
    private QueuingEventSink eventSink;
    private ExoPlayer exoPlayer;
    private DefaultHttpDataSource.Factory httpDataSourceFactory = new DefaultHttpDataSource.Factory();
    private final VideoPlayerOptions options;
    private Surface surface;
    private final TextureRegistry.SurfaceTextureEntry textureEntry;

    public VideoPlayer(Context context, EventChannel eventChannel2, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, String str, String str2, @NonNull Map<String, String> map, VideoPlayerOptions videoPlayerOptions) {
        this.eventChannel = eventChannel2;
        this.textureEntry = surfaceTextureEntry;
        this.options = videoPlayerOptions;
        ExoPlayer build = new ExoPlayer.Builder(context).build();
        Uri parse = Uri.parse(str);
        buildHttpDataSourceFactory(map);
        build.setMediaSource(buildMediaSource(parse, new DefaultDataSource.Factory(context, this.httpDataSourceFactory), str2));
        build.prepare();
        setUpVideoPlayer(build, new QueuingEventSink());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.source.MediaSource buildMediaSource(android.net.Uri r7, com.google.android.exoplayer2.upstream.DataSource.Factory r8, java.lang.String r9) {
        /*
            r6 = this;
            r0 = 4
            r1 = 2
            r2 = 1
            if (r9 != 0) goto L_0x000a
            int r9 = com.google.android.exoplayer2.util.Util.inferContentType((android.net.Uri) r7)
            goto L_0x004c
        L_0x000a:
            int r3 = r9.hashCode()
            r4 = 0
            r5 = -1
            switch(r3) {
                case 3680: goto L_0x0036;
                case 103407: goto L_0x002b;
                case 3075986: goto L_0x0020;
                case 106069776: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            r9 = r5
            goto L_0x0040
        L_0x0015:
            java.lang.String r3 = "other"
            boolean r9 = r9.equals(r3)
            if (r9 != 0) goto L_0x001e
            goto L_0x0013
        L_0x001e:
            r9 = 3
            goto L_0x0040
        L_0x0020:
            java.lang.String r3 = "dash"
            boolean r9 = r9.equals(r3)
            if (r9 != 0) goto L_0x0029
            goto L_0x0013
        L_0x0029:
            r9 = r1
            goto L_0x0040
        L_0x002b:
            java.lang.String r3 = "hls"
            boolean r9 = r9.equals(r3)
            if (r9 != 0) goto L_0x0034
            goto L_0x0013
        L_0x0034:
            r9 = r2
            goto L_0x0040
        L_0x0036:
            java.lang.String r3 = "ss"
            boolean r9 = r9.equals(r3)
            if (r9 != 0) goto L_0x003f
            goto L_0x0013
        L_0x003f:
            r9 = r4
        L_0x0040:
            switch(r9) {
                case 0: goto L_0x004b;
                case 1: goto L_0x0049;
                case 2: goto L_0x0047;
                case 3: goto L_0x0045;
                default: goto L_0x0043;
            }
        L_0x0043:
            r9 = r5
            goto L_0x004c
        L_0x0045:
            r9 = r0
            goto L_0x004c
        L_0x0047:
            r9 = r4
            goto L_0x004c
        L_0x0049:
            r9 = r1
            goto L_0x004c
        L_0x004b:
            r9 = r2
        L_0x004c:
            if (r9 == 0) goto L_0x009a
            if (r9 == r2) goto L_0x0087
            if (r9 == r1) goto L_0x0079
            if (r9 != r0) goto L_0x0062
            com.google.android.exoplayer2.source.ProgressiveMediaSource$Factory r9 = new com.google.android.exoplayer2.source.ProgressiveMediaSource$Factory
            r9.<init>(r8)
            com.google.android.exoplayer2.MediaItem r7 = com.google.android.exoplayer2.MediaItem.fromUri((android.net.Uri) r7)
            com.google.android.exoplayer2.source.ProgressiveMediaSource r7 = r9.createMediaSource((com.google.android.exoplayer2.MediaItem) r7)
            return r7
        L_0x0062:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unsupported type: "
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0079:
            com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory r9 = new com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory
            r9.<init>((com.google.android.exoplayer2.upstream.DataSource.Factory) r8)
            com.google.android.exoplayer2.MediaItem r7 = com.google.android.exoplayer2.MediaItem.fromUri((android.net.Uri) r7)
            com.google.android.exoplayer2.source.hls.HlsMediaSource r7 = r9.createMediaSource((com.google.android.exoplayer2.MediaItem) r7)
            return r7
        L_0x0087:
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory r9 = new com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory
            com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory r0 = new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory
            r0.<init>(r8)
            r9.<init>(r0, r8)
            com.google.android.exoplayer2.MediaItem r7 = com.google.android.exoplayer2.MediaItem.fromUri((android.net.Uri) r7)
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource r7 = r9.createMediaSource((com.google.android.exoplayer2.MediaItem) r7)
            return r7
        L_0x009a:
            com.google.android.exoplayer2.source.dash.DashMediaSource$Factory r9 = new com.google.android.exoplayer2.source.dash.DashMediaSource$Factory
            com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory r0 = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory
            r0.<init>(r8)
            r9.<init>(r0, r8)
            com.google.android.exoplayer2.MediaItem r7 = com.google.android.exoplayer2.MediaItem.fromUri((android.net.Uri) r7)
            com.google.android.exoplayer2.source.dash.DashMediaSource r7 = r9.createMediaSource((com.google.android.exoplayer2.MediaItem) r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.videoplayer.VideoPlayer.buildMediaSource(android.net.Uri, com.google.android.exoplayer2.upstream.DataSource$Factory, java.lang.String):com.google.android.exoplayer2.source.MediaSource");
    }

    private static void setAudioAttributes(ExoPlayer exoPlayer2, boolean z11) {
        exoPlayer2.setAudioAttributes(new AudioAttributes.Builder().setContentType(3).build(), !z11);
    }

    private void setUpVideoPlayer(ExoPlayer exoPlayer2, final QueuingEventSink queuingEventSink) {
        this.exoPlayer = exoPlayer2;
        this.eventSink = queuingEventSink;
        this.eventChannel.setStreamHandler(new EventChannel.StreamHandler() {
            public void onCancel(Object obj) {
                queuingEventSink.setDelegate((EventChannel.EventSink) null);
            }

            public void onListen(Object obj, EventChannel.EventSink eventSink) {
                queuingEventSink.setDelegate(eventSink);
            }
        });
        Surface surface2 = new Surface(this.textureEntry.surfaceTexture());
        this.surface = surface2;
        exoPlayer2.setVideoSurface(surface2);
        setAudioAttributes(exoPlayer2, this.options.mixWithOthers);
        exoPlayer2.addListener(new Player.Listener() {
            private boolean isBuffering = false;

            public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                y0.a(this, audioAttributes);
            }

            public /* synthetic */ void onAudioSessionIdChanged(int i11) {
                y0.b(this, i11);
            }

            public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
                y0.c(this, commands);
            }

            public /* synthetic */ void onCues(CueGroup cueGroup) {
                y0.d(this, cueGroup);
            }

            public /* synthetic */ void onCues(List list) {
                y0.e(this, list);
            }

            public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                y0.f(this, deviceInfo);
            }

            public /* synthetic */ void onDeviceVolumeChanged(int i11, boolean z11) {
                y0.g(this, i11, z11);
            }

            public /* synthetic */ void onEvents(Player player, Player.Events events) {
                y0.h(this, player, events);
            }

            public /* synthetic */ void onIsLoadingChanged(boolean z11) {
                y0.i(this, z11);
            }

            public void onIsPlayingChanged(boolean z11) {
                if (queuingEventSink != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", "isPlayingStateUpdate");
                    hashMap.put("isPlaying", Boolean.valueOf(z11));
                    queuingEventSink.success(hashMap);
                }
            }

            public /* synthetic */ void onLoadingChanged(boolean z11) {
                y0.k(this, z11);
            }

            public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j11) {
                y0.l(this, j11);
            }

            public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i11) {
                y0.m(this, mediaItem, i11);
            }

            public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                y0.n(this, mediaMetadata);
            }

            public /* synthetic */ void onMetadata(Metadata metadata) {
                y0.o(this, metadata);
            }

            public /* synthetic */ void onPlayWhenReadyChanged(boolean z11, int i11) {
                y0.p(this, z11, i11);
            }

            public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                y0.q(this, playbackParameters);
            }

            public void onPlaybackStateChanged(int i11) {
                if (i11 == 2) {
                    setBuffering(true);
                    VideoPlayer.this.f();
                } else if (i11 == 3) {
                    VideoPlayer videoPlayer = VideoPlayer.this;
                    if (!videoPlayer.f14391a) {
                        videoPlayer.f14391a = true;
                        videoPlayer.g();
                    }
                } else if (i11 == 4) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", TalabatGTM.COMPLETED);
                    queuingEventSink.success(hashMap);
                }
                if (i11 != 2) {
                    setBuffering(false);
                }
            }

            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
                y0.s(this, i11);
            }

            public void onPlayerError(@NonNull PlaybackException playbackException) {
                setBuffering(false);
                QueuingEventSink queuingEventSink = queuingEventSink;
                if (queuingEventSink != null) {
                    queuingEventSink.error("VideoError", "Video player had error " + playbackException, (Object) null);
                }
            }

            public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
                y0.u(this, playbackException);
            }

            public /* synthetic */ void onPlayerStateChanged(boolean z11, int i11) {
                y0.v(this, z11, i11);
            }

            public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                y0.w(this, mediaMetadata);
            }

            public /* synthetic */ void onPositionDiscontinuity(int i11) {
                y0.x(this, i11);
            }

            public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) {
                y0.y(this, positionInfo, positionInfo2, i11);
            }

            public /* synthetic */ void onRenderedFirstFrame() {
                y0.z(this);
            }

            public /* synthetic */ void onRepeatModeChanged(int i11) {
                y0.A(this, i11);
            }

            public /* synthetic */ void onSeekBackIncrementChanged(long j11) {
                y0.B(this, j11);
            }

            public /* synthetic */ void onSeekForwardIncrementChanged(long j11) {
                y0.C(this, j11);
            }

            public /* synthetic */ void onSeekProcessed() {
                y0.D(this);
            }

            public /* synthetic */ void onShuffleModeEnabledChanged(boolean z11) {
                y0.E(this, z11);
            }

            public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z11) {
                y0.F(this, z11);
            }

            public /* synthetic */ void onSurfaceSizeChanged(int i11, int i12) {
                y0.G(this, i11, i12);
            }

            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i11) {
                y0.H(this, timeline, i11);
            }

            public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                y0.I(this, trackSelectionParameters);
            }

            public /* synthetic */ void onTracksChanged(Tracks tracks) {
                y0.J(this, tracks);
            }

            public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
                y0.K(this, videoSize);
            }

            public /* synthetic */ void onVolumeChanged(float f11) {
                y0.L(this, f11);
            }

            public void setBuffering(boolean z11) {
                String str;
                if (this.isBuffering != z11) {
                    this.isBuffering = z11;
                    HashMap hashMap = new HashMap();
                    if (this.isBuffering) {
                        str = "bufferingStart";
                    } else {
                        str = "bufferingEnd";
                    }
                    hashMap.put("event", str);
                    queuingEventSink.success(hashMap);
                }
            }
        });
    }

    public void a() {
        if (this.f14391a) {
            this.exoPlayer.stop();
        }
        this.textureEntry.release();
        this.eventChannel.setStreamHandler((EventChannel.StreamHandler) null);
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
        }
        ExoPlayer exoPlayer2 = this.exoPlayer;
        if (exoPlayer2 != null) {
            exoPlayer2.release();
        }
    }

    public long b() {
        return this.exoPlayer.getCurrentPosition();
    }

    @VisibleForTesting
    public void buildHttpDataSourceFactory(@NonNull Map<String, String> map) {
        String str;
        boolean z11 = !map.isEmpty();
        if (!z11 || !map.containsKey("User-Agent")) {
            str = DatabaseProvider.TABLE_PREFIX;
        } else {
            str = map.get("User-Agent");
        }
        this.httpDataSourceFactory.setUserAgent(str).setAllowCrossProtocolRedirects(true);
        if (z11) {
            this.httpDataSourceFactory.setDefaultRequestProperties(map);
        }
    }

    public void c() {
        this.exoPlayer.setPlayWhenReady(false);
    }

    public void d() {
        this.exoPlayer.setPlayWhenReady(true);
    }

    public void e(int i11) {
        this.exoPlayer.seekTo((long) i11);
    }

    public void f() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "bufferingUpdate");
        hashMap.put("values", Collections.singletonList(Arrays.asList(new Number[]{0, Long.valueOf(this.exoPlayer.getBufferedPosition())})));
        this.eventSink.success(hashMap);
    }

    @VisibleForTesting
    public void g() {
        if (this.f14391a) {
            HashMap hashMap = new HashMap();
            hashMap.put("event", "initialized");
            hashMap.put("duration", Long.valueOf(this.exoPlayer.getDuration()));
            if (this.exoPlayer.getVideoFormat() != null) {
                Format videoFormat = this.exoPlayer.getVideoFormat();
                int i11 = videoFormat.width;
                int i12 = videoFormat.height;
                int i13 = videoFormat.rotationDegrees;
                if (i13 == 90 || i13 == 270) {
                    i11 = this.exoPlayer.getVideoFormat().height;
                    i12 = this.exoPlayer.getVideoFormat().width;
                }
                hashMap.put("width", Integer.valueOf(i11));
                hashMap.put("height", Integer.valueOf(i12));
                if (i13 == 180) {
                    hashMap.put("rotationCorrection", Integer.valueOf(i13));
                }
            }
            this.eventSink.success(hashMap);
        }
    }

    public void h(boolean z11) {
        this.exoPlayer.setRepeatMode(z11 ? 2 : 0);
    }

    public void i(double d11) {
        this.exoPlayer.setPlaybackParameters(new PlaybackParameters((float) d11));
    }

    public void j(double d11) {
        this.exoPlayer.setVolume((float) Math.max(0.0d, Math.min(1.0d, d11)));
    }
}
