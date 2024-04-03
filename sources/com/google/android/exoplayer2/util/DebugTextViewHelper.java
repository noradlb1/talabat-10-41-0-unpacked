package com.google.android.exoplayer2.util;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.widget.TextView;
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
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import com.huawei.hms.flutter.map.constants.Param;
import g7.y0;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class DebugTextViewHelper {
    private static final int REFRESH_INTERVAL_MS = 1000;
    private final ExoPlayer player;
    private boolean started;
    private final TextView textView;
    private final Updater updater;

    public final class Updater implements Player.Listener, Runnable {
        private Updater() {
        }

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

        public /* synthetic */ void onIsPlayingChanged(boolean z11) {
            y0.j(this, z11);
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

        public void onPlayWhenReadyChanged(boolean z11, int i11) {
            DebugTextViewHelper.this.updateAndPost();
        }

        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            y0.q(this, playbackParameters);
        }

        public void onPlaybackStateChanged(int i11) {
            DebugTextViewHelper.this.updateAndPost();
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
            y0.s(this, i11);
        }

        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            y0.t(this, playbackException);
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

        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) {
            DebugTextViewHelper.this.updateAndPost();
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

        public void run() {
            DebugTextViewHelper.this.updateAndPost();
        }
    }

    public DebugTextViewHelper(ExoPlayer exoPlayer, TextView textView2) {
        boolean z11;
        if (exoPlayer.getApplicationLooper() == Looper.getMainLooper()) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        this.player = exoPlayer;
        this.textView = textView2;
        this.updater = new Updater();
    }

    private static String getDecoderCountersBufferCountString(DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return "";
        }
        decoderCounters.ensureUpdated();
        return " sib:" + decoderCounters.skippedInputBufferCount + " sb:" + decoderCounters.skippedOutputBufferCount + " rb:" + decoderCounters.renderedOutputBufferCount + " db:" + decoderCounters.droppedBufferCount + " mcdb:" + decoderCounters.maxConsecutiveDroppedBufferCount + " dk:" + decoderCounters.droppedToKeyframeCount;
    }

    private static String getPixelAspectRatioString(float f11) {
        if (f11 == -1.0f || f11 == 1.0f) {
            return "";
        }
        return " par:" + String.format(Locale.US, "%.02f", new Object[]{Float.valueOf(f11)});
    }

    private static String getVideoFrameProcessingOffsetAverageString(long j11, int i11) {
        if (i11 == 0) {
            return "N/A";
        }
        return String.valueOf((long) (((double) j11) / ((double) i11)));
    }

    public String getAudioString() {
        Format audioFormat = this.player.getAudioFormat();
        DecoderCounters audioDecoderCounters = this.player.getAudioDecoderCounters();
        if (audioFormat == null || audioDecoderCounters == null) {
            return "";
        }
        return StringUtils.LF + audioFormat.sampleMimeType + "(id:" + audioFormat.f34900id + " hz:" + audioFormat.sampleRate + " ch:" + audioFormat.channelCount + getDecoderCountersBufferCountString(audioDecoderCounters) + ")";
    }

    public String getDebugString() {
        return getPlayerStateString() + getVideoString() + getAudioString();
    }

    public String getPlayerStateString() {
        String str;
        int playbackState = this.player.getPlaybackState();
        if (playbackState == 1) {
            str = "idle";
        } else if (playbackState == 2) {
            str = "buffering";
        } else if (playbackState == 3) {
            str = "ready";
        } else if (playbackState != 4) {
            str = "unknown";
        } else {
            str = "ended";
        }
        return String.format("playWhenReady:%s playbackState:%s item:%s", new Object[]{Boolean.valueOf(this.player.getPlayWhenReady()), str, Integer.valueOf(this.player.getCurrentMediaItemIndex())});
    }

    public String getVideoString() {
        Format videoFormat = this.player.getVideoFormat();
        DecoderCounters videoDecoderCounters = this.player.getVideoDecoderCounters();
        if (videoFormat == null || videoDecoderCounters == null) {
            return "";
        }
        return StringUtils.LF + videoFormat.sampleMimeType + "(id:" + videoFormat.f34900id + " r:" + videoFormat.width + Param.X + videoFormat.height + getPixelAspectRatioString(videoFormat.pixelWidthHeightRatio) + getDecoderCountersBufferCountString(videoDecoderCounters) + " vfpo: " + getVideoFrameProcessingOffsetAverageString(videoDecoderCounters.totalVideoFrameProcessingOffsetUs, videoDecoderCounters.videoFrameProcessingOffsetCount) + ")";
    }

    public final void start() {
        if (!this.started) {
            this.started = true;
            this.player.addListener(this.updater);
            updateAndPost();
        }
    }

    public final void stop() {
        if (this.started) {
            this.started = false;
            this.player.removeListener(this.updater);
            this.textView.removeCallbacks(this.updater);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void updateAndPost() {
        this.textView.setText(getDebugString());
        this.textView.removeCallbacks(this.updater);
        this.textView.postDelayed(this.updater, 1000);
    }
}
