package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.ImmutableList;
import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.survey.models.State;
import com.visa.checkout.Profile;
import h7.a;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import net.bytebuddy.description.type.TypeDescription;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class EventLogger implements AnalyticsListener {
    private static final String DEFAULT_TAG = "EventLogger";
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final NumberFormat TIME_FORMAT;
    private final Timeline.Period period;
    private final long startTimeMs;
    private final String tag;
    private final Timeline.Window window;

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = instance;
        instance.setMinimumFractionDigits(2);
        instance.setMaximumFractionDigits(2);
        instance.setGroupingUsed(false);
    }

    public EventLogger() {
        this(DEFAULT_TAG);
    }

    private static String getDiscontinuityReasonString(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? TypeDescription.Generic.OfWildcardType.SYMBOL : "INTERNAL" : "REMOVE" : "SKIP" : "SEEK_ADJUSTMENT" : "SEEK" : "AUTO_TRANSITION";
    }

    private String getEventString(AnalyticsListener.EventTime eventTime, String str, @Nullable String str2, @Nullable Throwable th2) {
        String str3 = str + " [" + getEventTimeString(eventTime);
        if (th2 instanceof PlaybackException) {
            str3 = str3 + ", errorCode=" + ((PlaybackException) th2).getErrorCodeName();
        }
        if (str2 != null) {
            str3 = str3 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str2;
        }
        String throwableString = Log.getThrowableString(th2);
        if (!TextUtils.isEmpty(throwableString)) {
            str3 = str3 + "\n  " + throwableString.replace(StringUtils.LF, "\n  ") + 10;
        }
        return str3 + "]";
    }

    private String getEventTimeString(AnalyticsListener.EventTime eventTime) {
        String str = "window=" + eventTime.windowIndex;
        if (eventTime.mediaPeriodId != null) {
            str = str + ", period=" + eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid);
            if (eventTime.mediaPeriodId.isAd()) {
                str = (str + ", adGroup=" + eventTime.mediaPeriodId.adGroupIndex) + ", ad=" + eventTime.mediaPeriodId.adIndexInAdGroup;
            }
        }
        return "eventTime=" + getTimeString(eventTime.realtimeMs - this.startTimeMs) + ", mediaPos=" + getTimeString(eventTime.eventPlaybackPositionMs) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str;
    }

    private static String getMediaItemTransitionReasonString(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? TypeDescription.Generic.OfWildcardType.SYMBOL : "PLAYLIST_CHANGED" : "SEEK" : "AUTO" : "REPEAT";
    }

    private static String getPlayWhenReadyChangeReasonString(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? TypeDescription.Generic.OfWildcardType.SYMBOL : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST";
    }

    private static String getPlaybackSuppressionReasonString(int i11) {
        return i11 != 0 ? i11 != 1 ? TypeDescription.Generic.OfWildcardType.SYMBOL : "TRANSIENT_AUDIO_FOCUS_LOSS" : Profile.DataLevel.NONE;
    }

    private static String getRepeatModeString(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? TypeDescription.Generic.OfWildcardType.SYMBOL : "ALL" : "ONE" : "OFF";
    }

    private static String getStateString(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? TypeDescription.Generic.OfWildcardType.SYMBOL : State.ENDED : "READY" : "BUFFERING" : "IDLE";
    }

    private static String getTimeString(long j11) {
        if (j11 == C.TIME_UNSET) {
            return TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
        return TIME_FORMAT.format((double) (((float) j11) / 1000.0f));
    }

    private static String getTimelineChangeReasonString(int i11) {
        return i11 != 0 ? i11 != 1 ? TypeDescription.Generic.OfWildcardType.SYMBOL : "SOURCE_UPDATE" : "PLAYLIST_CHANGED";
    }

    private static String getTrackStatusString(boolean z11) {
        return z11 ? "[X]" : "[ ]";
    }

    private void printInternalError(AnalyticsListener.EventTime eventTime, String str, Exception exc) {
        loge(eventTime, "internalError", str, exc);
    }

    private void printMetadata(Metadata metadata, String str) {
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            logd(str + metadata.get(i11));
        }
    }

    public void logd(String str) {
        Log.d(this.tag, str);
    }

    public void loge(String str) {
        Log.e(this.tag, str);
    }

    public void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        logd(eventTime, "audioAttributes", audioAttributes.contentType + "," + audioAttributes.flags + "," + audioAttributes.usage + "," + audioAttributes.allowedCapturePolicy);
    }

    public /* synthetic */ void onAudioCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.b(this, eventTime, exc);
    }

    public void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11) {
        logd(eventTime, "audioDecoderInitialized", str);
    }

    public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        a.d(this, eventTime, str, j11, j12);
    }

    public void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        logd(eventTime, "audioDecoderReleased", str);
    }

    public void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "audioDisabled");
    }

    public void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "audioEnabled");
    }

    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        a.h(this, eventTime, format);
    }

    public void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        logd(eventTime, "audioInputFormat", Format.toLogString(format));
    }

    public /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j11) {
        a.j(this, eventTime, j11);
    }

    public void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i11) {
        logd(eventTime, "audioSessionId", Integer.toString(i11));
    }

    public /* synthetic */ void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.l(this, eventTime, exc);
    }

    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
        loge(eventTime, "audioTrackUnderrun", i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + j11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + j12, (Throwable) null);
    }

    public /* synthetic */ void onAvailableCommandsChanged(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        a.n(this, eventTime, commands);
    }

    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
    }

    public /* synthetic */ void onCues(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        a.p(this, eventTime, cueGroup);
    }

    public /* synthetic */ void onCues(AnalyticsListener.EventTime eventTime, List list) {
        a.q(this, eventTime, list);
    }

    public /* synthetic */ void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i11, DecoderCounters decoderCounters) {
        a.r(this, eventTime, i11, decoderCounters);
    }

    public /* synthetic */ void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i11, DecoderCounters decoderCounters) {
        a.s(this, eventTime, i11, decoderCounters);
    }

    public /* synthetic */ void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i11, String str, long j11) {
        a.t(this, eventTime, i11, str, j11);
    }

    public /* synthetic */ void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i11, Format format) {
        a.u(this, eventTime, i11, format);
    }

    public /* synthetic */ void onDeviceInfoChanged(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
        a.v(this, eventTime, deviceInfo);
    }

    public /* synthetic */ void onDeviceVolumeChanged(AnalyticsListener.EventTime eventTime, int i11, boolean z11) {
        a.w(this, eventTime, i11, z11);
    }

    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        logd(eventTime, "downstreamFormat", Format.toLogString(mediaLoadData.trackFormat));
    }

    public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysLoaded");
    }

    public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRemoved");
    }

    public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRestored");
    }

    public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        a.B(this, eventTime);
    }

    public void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime, int i11) {
        logd(eventTime, "drmSessionAcquired", "state=" + i11);
    }

    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        printInternalError(eventTime, "drmSessionManagerError", exc);
    }

    public void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmSessionReleased");
    }

    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i11, long j11) {
        logd(eventTime, "droppedFrames", Integer.toString(i11));
    }

    public /* synthetic */ void onEvents(Player player, AnalyticsListener.Events events) {
        a.G(this, player, events);
    }

    public void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        logd(eventTime, "loading", Boolean.toString(z11));
    }

    public void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        logd(eventTime, "isPlaying", Boolean.toString(z11));
    }

    public void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        printInternalError(eventTime, "loadError", iOException);
    }

    public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        a.N(this, eventTime, z11);
    }

    public /* synthetic */ void onMaxSeekToPreviousPositionChanged(AnalyticsListener.EventTime eventTime, long j11) {
        a.O(this, eventTime, j11);
    }

    public void onMediaItemTransition(AnalyticsListener.EventTime eventTime, @Nullable MediaItem mediaItem, int i11) {
        logd("mediaItem [" + getEventTimeString(eventTime) + ", reason=" + getMediaItemTransitionReasonString(i11) + "]");
    }

    public /* synthetic */ void onMediaMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        a.Q(this, eventTime, mediaMetadata);
    }

    public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        logd("metadata [" + getEventTimeString(eventTime));
        printMetadata(metadata, "  ");
        logd("]");
    }

    public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z11, int i11) {
        logd(eventTime, "playWhenReady", z11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + getPlayWhenReadyChangeReasonString(i11));
    }

    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        logd(eventTime, "playbackParameters", playbackParameters.toString());
    }

    public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i11) {
        logd(eventTime, "state", getStateString(i11));
    }

    public void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i11) {
        logd(eventTime, "playbackSuppressionReason", getPlaybackSuppressionReasonString(i11));
    }

    public void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        loge(eventTime, "playerFailed", playbackException);
    }

    public /* synthetic */ void onPlayerErrorChanged(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        a.X(this, eventTime, playbackException);
    }

    public /* synthetic */ void onPlayerReleased(AnalyticsListener.EventTime eventTime) {
        a.Y(this, eventTime);
    }

    public /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z11, int i11) {
        a.Z(this, eventTime, z11, i11);
    }

    public /* synthetic */ void onPlaylistMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        a.a0(this, eventTime, mediaMetadata);
    }

    public /* synthetic */ void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i11) {
        a.b0(this, eventTime, i11);
    }

    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reason=");
        sb2.append(getDiscontinuityReasonString(i11));
        sb2.append(", PositionInfo:old [");
        sb2.append("mediaItem=");
        sb2.append(positionInfo.mediaItemIndex);
        sb2.append(", period=");
        sb2.append(positionInfo.periodIndex);
        sb2.append(", pos=");
        sb2.append(positionInfo.positionMs);
        if (positionInfo.adGroupIndex != -1) {
            sb2.append(", contentPos=");
            sb2.append(positionInfo.contentPositionMs);
            sb2.append(", adGroup=");
            sb2.append(positionInfo.adGroupIndex);
            sb2.append(", ad=");
            sb2.append(positionInfo.adIndexInAdGroup);
        }
        sb2.append("], PositionInfo:new [");
        sb2.append("mediaItem=");
        sb2.append(positionInfo2.mediaItemIndex);
        sb2.append(", period=");
        sb2.append(positionInfo2.periodIndex);
        sb2.append(", pos=");
        sb2.append(positionInfo2.positionMs);
        if (positionInfo2.adGroupIndex != -1) {
            sb2.append(", contentPos=");
            sb2.append(positionInfo2.contentPositionMs);
            sb2.append(", adGroup=");
            sb2.append(positionInfo2.adGroupIndex);
            sb2.append(", ad=");
            sb2.append(positionInfo2.adIndexInAdGroup);
        }
        sb2.append("]");
        logd(eventTime, "positionDiscontinuity", sb2.toString());
    }

    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Object obj, long j11) {
        logd(eventTime, "renderedFirstFrame", String.valueOf(obj));
    }

    public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i11) {
        logd(eventTime, Param.REPEAT_MODE, getRepeatModeString(i11));
    }

    public /* synthetic */ void onSeekBackIncrementChanged(AnalyticsListener.EventTime eventTime, long j11) {
        a.f0(this, eventTime, j11);
    }

    public /* synthetic */ void onSeekForwardIncrementChanged(AnalyticsListener.EventTime eventTime, long j11) {
        a.g0(this, eventTime, j11);
    }

    public /* synthetic */ void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        a.h0(this, eventTime);
    }

    public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        a.i0(this, eventTime);
    }

    public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        logd(eventTime, "shuffleModeEnabled", Boolean.toString(z11));
    }

    public void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        logd(eventTime, "skipSilenceEnabled", Boolean.toString(z11));
    }

    public void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i11, int i12) {
        logd(eventTime, "surfaceSize", i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12);
    }

    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i11) {
        int periodCount = eventTime.timeline.getPeriodCount();
        int windowCount = eventTime.timeline.getWindowCount();
        logd("timeline [" + getEventTimeString(eventTime) + ", periodCount=" + periodCount + ", windowCount=" + windowCount + ", reason=" + getTimelineChangeReasonString(i11));
        for (int i12 = 0; i12 < Math.min(periodCount, 3); i12++) {
            eventTime.timeline.getPeriod(i12, this.period);
            logd("  period [" + getTimeString(this.period.getDurationMs()) + "]");
        }
        if (periodCount > 3) {
            logd("  ...");
        }
        for (int i13 = 0; i13 < Math.min(windowCount, 3); i13++) {
            eventTime.timeline.getWindow(i13, this.window);
            logd("  window [" + getTimeString(this.window.getDurationMs()) + ", seekable=" + this.window.isSeekable + ", dynamic=" + this.window.isDynamic + "]");
        }
        if (windowCount > 3) {
            logd("  ...");
        }
        logd("]");
    }

    public /* synthetic */ void onTrackSelectionParametersChanged(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        a.n0(this, eventTime, trackSelectionParameters);
    }

    public void onTracksChanged(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        Metadata metadata;
        logd("tracks [" + getEventTimeString(eventTime));
        ImmutableList<Tracks.Group> groups = tracks.getGroups();
        for (int i11 = 0; i11 < groups.size(); i11++) {
            Tracks.Group group = groups.get(i11);
            logd("  group [");
            for (int i12 = 0; i12 < group.length; i12++) {
                logd("    " + getTrackStatusString(group.isTrackSelected(i12)) + " Track:" + i12 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Format.toLogString(group.getTrackFormat(i12)) + ", supported=" + Util.getFormatSupportString(group.getTrackSupport(i12)));
            }
            logd("  ]");
        }
        boolean z11 = false;
        int i13 = 0;
        while (!z11 && i13 < groups.size()) {
            Tracks.Group group2 = groups.get(i13);
            int i14 = 0;
            while (!z11 && i14 < group2.length) {
                if (group2.isTrackSelected(i14) && (metadata = group2.getTrackFormat(i14).metadata) != null && metadata.length() > 0) {
                    logd("  Metadata [");
                    printMetadata(metadata, "    ");
                    logd("  ]");
                    z11 = true;
                }
                i14++;
            }
            i13++;
        }
        logd("]");
    }

    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        logd(eventTime, "upstreamDiscarded", Format.toLogString(mediaLoadData.trackFormat));
    }

    public /* synthetic */ void onVideoCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.q0(this, eventTime, exc);
    }

    public void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11) {
        logd(eventTime, "videoDecoderInitialized", str);
    }

    public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        a.s0(this, eventTime, str, j11, j12);
    }

    public void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        logd(eventTime, "videoDecoderReleased", str);
    }

    public void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "videoDisabled");
    }

    public void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "videoEnabled");
    }

    public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j11, int i11) {
        a.w0(this, eventTime, j11, i11);
    }

    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        a.x0(this, eventTime, format);
    }

    public void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        logd(eventTime, "videoInputFormat", Format.toLogString(format));
    }

    public /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i11, int i12, int i13, float f11) {
        a.z0(this, eventTime, i11, i12, i13, f11);
    }

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        logd(eventTime, "videoSize", videoSize.width + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + videoSize.height);
    }

    public void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f11) {
        logd(eventTime, "volume", Float.toString(f11));
    }

    public EventLogger(String str) {
        this.tag = str;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.startTimeMs = SystemClock.elapsedRealtime();
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str) {
        logd(getEventString(eventTime, str, (String) null, (Throwable) null));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, @Nullable Throwable th2) {
        loge(getEventString(eventTime, str, (String) null, th2));
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str, String str2) {
        logd(getEventString(eventTime, str, str2, (Throwable) null));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, String str2, @Nullable Throwable th2) {
        loge(getEventString(eventTime, str, str2, th2));
    }

    @Deprecated
    public EventLogger(@Nullable MappingTrackSelector mappingTrackSelector) {
        this(DEFAULT_TAG);
    }

    @Deprecated
    public EventLogger(@Nullable MappingTrackSelector mappingTrackSelector, String str) {
        this(str);
    }
}
