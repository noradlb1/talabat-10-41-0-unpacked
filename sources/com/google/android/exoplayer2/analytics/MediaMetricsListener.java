package com.google.android.exoplayer2.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import h7.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@RequiresApi(31)
public final class MediaMetricsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    @Nullable
    private String activeSessionId;
    private int audioUnderruns;
    private final HashMap<String, Long> bandwidthBytes = new HashMap<>();
    private final HashMap<String, Long> bandwidthTimeMs = new HashMap<>();
    private final Context context;
    @Nullable
    private Format currentAudioFormat;
    private int currentNetworkType = 0;
    private int currentPlaybackState = 0;
    @Nullable
    private Format currentTextFormat;
    @Nullable
    private Format currentVideoFormat;
    private int discontinuityReason;
    private int droppedFrames;
    private boolean hasFatalError;
    private int ioErrorType;
    private boolean isSeeking;
    @Nullable
    private PlaybackMetrics.Builder metricsBuilder;
    @Nullable
    private PendingFormatUpdate pendingAudioFormat;
    @Nullable
    private PlaybackException pendingPlayerError;
    @Nullable
    private PendingFormatUpdate pendingTextFormat;
    @Nullable
    private PendingFormatUpdate pendingVideoFormat;
    private final Timeline.Period period = new Timeline.Period();
    private final PlaybackSession playbackSession;
    private int playedFrames;
    private boolean reportedEventsForCurrentSession;
    private final PlaybackSessionManager sessionManager;
    private final long startTimeMs = SystemClock.elapsedRealtime();
    private final Timeline.Window window = new Timeline.Window();

    public static final class ErrorInfo {
        public final int errorCode;
        public final int subErrorCode;

        public ErrorInfo(int i11, int i12) {
            this.errorCode = i11;
            this.subErrorCode = i12;
        }
    }

    public static final class PendingFormatUpdate {
        public final Format format;
        public final int selectionReason;
        public final String sessionId;

        public PendingFormatUpdate(Format format2, int i11, String str) {
            this.format = format2;
            this.selectionReason = i11;
            this.sessionId = str;
        }
    }

    private MediaMetricsListener(Context context2, PlaybackSession playbackSession2) {
        this.context = context2.getApplicationContext();
        this.playbackSession = playbackSession2;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.sessionManager = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.setListener(this);
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private boolean canReportPendingFormatUpdate(@Nullable PendingFormatUpdate pendingFormatUpdate) {
        if (pendingFormatUpdate == null || !pendingFormatUpdate.sessionId.equals(this.sessionManager.getActiveSessionId())) {
            return false;
        }
        return true;
    }

    @Nullable
    public static MediaMetricsListener create(Context context2) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context2.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new MediaMetricsListener(context2, mediaMetricsManager.createPlaybackSession());
    }

    private void finishCurrentSession() {
        long j11;
        long j12;
        int i11;
        PlaybackMetrics.Builder builder = this.metricsBuilder;
        if (builder != null && this.reportedEventsForCurrentSession) {
            PlaybackMetrics.Builder unused = builder.setAudioUnderrunCount(this.audioUnderruns);
            PlaybackMetrics.Builder unused2 = this.metricsBuilder.setVideoFramesDropped(this.droppedFrames);
            PlaybackMetrics.Builder unused3 = this.metricsBuilder.setVideoFramesPlayed(this.playedFrames);
            Long l11 = this.bandwidthTimeMs.get(this.activeSessionId);
            PlaybackMetrics.Builder builder2 = this.metricsBuilder;
            if (l11 == null) {
                j11 = 0;
            } else {
                j11 = l11.longValue();
            }
            PlaybackMetrics.Builder unused4 = builder2.setNetworkTransferDurationMillis(j11);
            Long l12 = this.bandwidthBytes.get(this.activeSessionId);
            PlaybackMetrics.Builder builder3 = this.metricsBuilder;
            if (l12 == null) {
                j12 = 0;
            } else {
                j12 = l12.longValue();
            }
            PlaybackMetrics.Builder unused5 = builder3.setNetworkBytesRead(j12);
            PlaybackMetrics.Builder builder4 = this.metricsBuilder;
            if (l12 == null || l12.longValue() <= 0) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            PlaybackMetrics.Builder unused6 = builder4.setStreamSource(i11);
            this.playbackSession.reportPlaybackMetrics(this.metricsBuilder.build());
        }
        this.metricsBuilder = null;
        this.activeSessionId = null;
        this.audioUnderruns = 0;
        this.droppedFrames = 0;
        this.playedFrames = 0;
        this.currentVideoFormat = null;
        this.currentAudioFormat = null;
        this.currentTextFormat = null;
        this.reportedEventsForCurrentSession = false;
    }

    @SuppressLint({"SwitchIntDef"})
    private static int getDrmErrorCode(int i11) {
        switch (Util.getErrorCodeForMediaDrmErrorCode(i11)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    @Nullable
    private static DrmInitData getDrmInitData(ImmutableList<Tracks.Group> immutableList) {
        DrmInitData drmInitData;
        UnmodifiableIterator<Tracks.Group> it = immutableList.iterator();
        while (it.hasNext()) {
            Tracks.Group next = it.next();
            int i11 = 0;
            while (true) {
                if (i11 < next.length) {
                    if (next.isTrackSelected(i11) && (drmInitData = next.getTrackFormat(i11).drmInitData) != null) {
                        return drmInitData;
                    }
                    i11++;
                }
            }
        }
        return null;
    }

    private static int getDrmType(DrmInitData drmInitData) {
        for (int i11 = 0; i11 < drmInitData.schemeDataCount; i11++) {
            UUID uuid = drmInitData.get(i11).uuid;
            if (uuid.equals(C.WIDEVINE_UUID)) {
                return 3;
            }
            if (uuid.equals(C.PLAYREADY_UUID)) {
                return 2;
            }
            if (uuid.equals(C.CLEARKEY_UUID)) {
                return 6;
            }
        }
        return 1;
    }

    private static ErrorInfo getErrorInfo(PlaybackException playbackException, Context context2, boolean z11) {
        boolean z12;
        int i11;
        int i12;
        if (playbackException.errorCode == 1001) {
            return new ErrorInfo(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            if (exoPlaybackException.type == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            i11 = exoPlaybackException.rendererFormatSupport;
        } else {
            i11 = 0;
            z12 = false;
        }
        Throwable th2 = (Throwable) Assertions.checkNotNull(playbackException.getCause());
        if (th2 instanceof IOException) {
            if (th2 instanceof HttpDataSource.InvalidResponseCodeException) {
                return new ErrorInfo(5, ((HttpDataSource.InvalidResponseCodeException) th2).responseCode);
            }
            if ((th2 instanceof HttpDataSource.InvalidContentTypeException) || (th2 instanceof ParserException)) {
                if (z11) {
                    i12 = 10;
                } else {
                    i12 = 11;
                }
                return new ErrorInfo(i12, 0);
            } else if ((th2 instanceof HttpDataSource.HttpDataSourceException) || (th2 instanceof UdpDataSource.UdpDataSourceException)) {
                if (NetworkTypeObserver.getInstance(context2).getNetworkType() == 1) {
                    return new ErrorInfo(3, 0);
                }
                Throwable cause = th2.getCause();
                if (cause instanceof UnknownHostException) {
                    return new ErrorInfo(6, 0);
                }
                if (cause instanceof SocketTimeoutException) {
                    return new ErrorInfo(7, 0);
                }
                if (!(th2 instanceof HttpDataSource.HttpDataSourceException) || ((HttpDataSource.HttpDataSourceException) th2).type != 1) {
                    return new ErrorInfo(8, 0);
                }
                return new ErrorInfo(4, 0);
            } else if (playbackException.errorCode == 1002) {
                return new ErrorInfo(21, 0);
            } else {
                if (th2 instanceof DrmSession.DrmSessionException) {
                    Throwable th3 = (Throwable) Assertions.checkNotNull(th2.getCause());
                    int i13 = Util.SDK_INT;
                    if (i13 >= 21 && (th3 instanceof MediaDrm.MediaDrmStateException)) {
                        int errorCodeFromPlatformDiagnosticsInfo = Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaDrm.MediaDrmStateException) th3).getDiagnosticInfo());
                        return new ErrorInfo(getDrmErrorCode(errorCodeFromPlatformDiagnosticsInfo), errorCodeFromPlatformDiagnosticsInfo);
                    } else if (i13 >= 23 && (th3 instanceof MediaDrmResetException)) {
                        return new ErrorInfo(27, 0);
                    } else {
                        if (i13 >= 18 && (th3 instanceof NotProvisionedException)) {
                            return new ErrorInfo(24, 0);
                        }
                        if (i13 >= 18 && (th3 instanceof DeniedByServerException)) {
                            return new ErrorInfo(29, 0);
                        }
                        if (th3 instanceof UnsupportedDrmException) {
                            return new ErrorInfo(23, 0);
                        }
                        if (th3 instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
                            return new ErrorInfo(28, 0);
                        }
                        return new ErrorInfo(30, 0);
                    }
                } else if (!(th2 instanceof FileDataSource.FileDataSourceException) || !(th2.getCause() instanceof FileNotFoundException)) {
                    return new ErrorInfo(9, 0);
                } else {
                    Throwable cause2 = ((Throwable) Assertions.checkNotNull(th2.getCause())).getCause();
                    if (Util.SDK_INT < 21 || !(cause2 instanceof ErrnoException) || ((ErrnoException) cause2).errno != OsConstants.EACCES) {
                        return new ErrorInfo(31, 0);
                    }
                    return new ErrorInfo(32, 0);
                }
            }
        } else if (z12 && (i11 == 0 || i11 == 1)) {
            return new ErrorInfo(35, 0);
        } else {
            if (z12 && i11 == 3) {
                return new ErrorInfo(15, 0);
            }
            if (z12 && i11 == 2) {
                return new ErrorInfo(23, 0);
            }
            if (th2 instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new ErrorInfo(13, Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaCodecRenderer.DecoderInitializationException) th2).diagnosticInfo));
            }
            if (th2 instanceof MediaCodecDecoderException) {
                return new ErrorInfo(14, Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaCodecDecoderException) th2).diagnosticInfo));
            }
            if (th2 instanceof OutOfMemoryError) {
                return new ErrorInfo(14, 0);
            }
            if (th2 instanceof AudioSink.InitializationException) {
                return new ErrorInfo(17, ((AudioSink.InitializationException) th2).audioTrackState);
            }
            if (th2 instanceof AudioSink.WriteException) {
                return new ErrorInfo(18, ((AudioSink.WriteException) th2).errorCode);
            }
            if (Util.SDK_INT < 16 || !(th2 instanceof MediaCodec.CryptoException)) {
                return new ErrorInfo(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th2).getErrorCode();
            return new ErrorInfo(getDrmErrorCode(errorCode), errorCode);
        }
    }

    private static Pair<String, String> getLanguageAndRegion(String str) {
        String str2;
        String[] split = Util.split(str, SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
        String str3 = split[0];
        if (split.length >= 2) {
            str2 = split[1];
        } else {
            str2 = null;
        }
        return Pair.create(str3, str2);
    }

    private static int getNetworkType(Context context2) {
        switch (NetworkTypeObserver.getInstance(context2).getNetworkType()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
            default:
                return 1;
        }
    }

    private static int getStreamType(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
        if (localConfiguration == null) {
            return 0;
        }
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(localConfiguration.uri, localConfiguration.mimeType);
        if (inferContentTypeForUriAndMimeType == 0) {
            return 3;
        }
        if (inferContentTypeForUriAndMimeType == 1) {
            return 5;
        }
        if (inferContentTypeForUriAndMimeType != 2) {
            return 1;
        }
        return 4;
    }

    private static int getTrackChangeReason(int i11) {
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? 1 : 4;
        }
        return 3;
    }

    private void maybeAddSessions(AnalyticsListener.Events events) {
        for (int i11 = 0; i11 < events.size(); i11++) {
            int i12 = events.get(i11);
            AnalyticsListener.EventTime eventTime = events.getEventTime(i12);
            if (i12 == 0) {
                this.sessionManager.updateSessionsWithTimelineChange(eventTime);
            } else if (i12 == 11) {
                this.sessionManager.updateSessionsWithDiscontinuity(eventTime, this.discontinuityReason);
            } else {
                this.sessionManager.updateSessions(eventTime);
            }
        }
    }

    private void maybeReportNetworkChange(long j11) {
        int networkType = getNetworkType(this.context);
        if (networkType != this.currentNetworkType) {
            this.currentNetworkType = networkType;
            this.playbackSession.reportNetworkEvent(new NetworkEvent.Builder().setNetworkType(networkType).setTimeSinceCreatedMillis(j11 - this.startTimeMs).build());
        }
    }

    private void maybeReportPlaybackError(long j11) {
        boolean z11;
        PlaybackException playbackException = this.pendingPlayerError;
        if (playbackException != null) {
            Context context2 = this.context;
            if (this.ioErrorType == 4) {
                z11 = true;
            } else {
                z11 = false;
            }
            ErrorInfo errorInfo = getErrorInfo(playbackException, context2, z11);
            this.playbackSession.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(j11 - this.startTimeMs).setErrorCode(errorInfo.errorCode).setSubErrorCode(errorInfo.subErrorCode).setException(playbackException).build());
            this.reportedEventsForCurrentSession = true;
            this.pendingPlayerError = null;
        }
    }

    private void maybeReportPlaybackStateChange(Player player, AnalyticsListener.Events events, long j11) {
        if (player.getPlaybackState() != 2) {
            this.isSeeking = false;
        }
        if (player.getPlayerError() == null) {
            this.hasFatalError = false;
        } else if (events.contains(10)) {
            this.hasFatalError = true;
        }
        int resolveNewPlaybackState = resolveNewPlaybackState(player);
        if (this.currentPlaybackState != resolveNewPlaybackState) {
            this.currentPlaybackState = resolveNewPlaybackState;
            this.reportedEventsForCurrentSession = true;
            this.playbackSession.reportPlaybackStateEvent(new PlaybackStateEvent.Builder().setState(this.currentPlaybackState).setTimeSinceCreatedMillis(j11 - this.startTimeMs).build());
        }
    }

    private void maybeReportTrackChanges(Player player, AnalyticsListener.Events events, long j11) {
        if (events.contains(2)) {
            Tracks currentTracks = player.getCurrentTracks();
            boolean isTypeSelected = currentTracks.isTypeSelected(2);
            boolean isTypeSelected2 = currentTracks.isTypeSelected(1);
            boolean isTypeSelected3 = currentTracks.isTypeSelected(3);
            if (isTypeSelected || isTypeSelected2 || isTypeSelected3) {
                if (!isTypeSelected) {
                    maybeUpdateVideoFormat(j11, (Format) null, 0);
                }
                if (!isTypeSelected2) {
                    maybeUpdateAudioFormat(j11, (Format) null, 0);
                }
                if (!isTypeSelected3) {
                    maybeUpdateTextFormat(j11, (Format) null, 0);
                }
            }
        }
        if (canReportPendingFormatUpdate(this.pendingVideoFormat)) {
            PendingFormatUpdate pendingFormatUpdate = this.pendingVideoFormat;
            Format format = pendingFormatUpdate.format;
            if (format.height != -1) {
                maybeUpdateVideoFormat(j11, format, pendingFormatUpdate.selectionReason);
                this.pendingVideoFormat = null;
            }
        }
        if (canReportPendingFormatUpdate(this.pendingAudioFormat)) {
            PendingFormatUpdate pendingFormatUpdate2 = this.pendingAudioFormat;
            maybeUpdateAudioFormat(j11, pendingFormatUpdate2.format, pendingFormatUpdate2.selectionReason);
            this.pendingAudioFormat = null;
        }
        if (canReportPendingFormatUpdate(this.pendingTextFormat)) {
            PendingFormatUpdate pendingFormatUpdate3 = this.pendingTextFormat;
            maybeUpdateTextFormat(j11, pendingFormatUpdate3.format, pendingFormatUpdate3.selectionReason);
            this.pendingTextFormat = null;
        }
    }

    private void maybeUpdateAudioFormat(long j11, @Nullable Format format, int i11) {
        if (!Util.areEqual(this.currentAudioFormat, format)) {
            if (this.currentAudioFormat == null && i11 == 0) {
                i11 = 1;
            }
            this.currentAudioFormat = format;
            reportTrackChangeEvent(0, j11, format, i11);
        }
    }

    private void maybeUpdateMetricsBuilderValues(Player player, AnalyticsListener.Events events) {
        DrmInitData drmInitData;
        if (events.contains(0)) {
            AnalyticsListener.EventTime eventTime = events.getEventTime(0);
            if (this.metricsBuilder != null) {
                maybeUpdateTimelineMetadata(eventTime.timeline, eventTime.mediaPeriodId);
            }
        }
        if (!(!events.contains(2) || this.metricsBuilder == null || (drmInitData = getDrmInitData(player.getCurrentTracks().getGroups())) == null)) {
            PlaybackMetrics.Builder unused = ((PlaybackMetrics.Builder) Util.castNonNull(this.metricsBuilder)).setDrmType(getDrmType(drmInitData));
        }
        if (events.contains(1011)) {
            this.audioUnderruns++;
        }
    }

    private void maybeUpdateTextFormat(long j11, @Nullable Format format, int i11) {
        if (!Util.areEqual(this.currentTextFormat, format)) {
            if (this.currentTextFormat == null && i11 == 0) {
                i11 = 1;
            }
            this.currentTextFormat = format;
            reportTrackChangeEvent(2, j11, format, i11);
        }
    }

    @RequiresNonNull({"metricsBuilder"})
    private void maybeUpdateTimelineMetadata(Timeline timeline, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        int indexOfPeriod;
        int i11;
        PlaybackMetrics.Builder builder = this.metricsBuilder;
        if (mediaPeriodId != null && (indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) != -1) {
            timeline.getPeriod(indexOfPeriod, this.period);
            timeline.getWindow(this.period.windowIndex, this.window);
            PlaybackMetrics.Builder unused = builder.setStreamType(getStreamType(this.window.mediaItem));
            Timeline.Window window2 = this.window;
            if (window2.durationUs != C.TIME_UNSET && !window2.isPlaceholder && !window2.isDynamic && !window2.isLive()) {
                PlaybackMetrics.Builder unused2 = builder.setMediaDurationMillis(this.window.getDurationMs());
            }
            if (this.window.isLive()) {
                i11 = 2;
            } else {
                i11 = 1;
            }
            PlaybackMetrics.Builder unused3 = builder.setPlaybackType(i11);
            this.reportedEventsForCurrentSession = true;
        }
    }

    private void maybeUpdateVideoFormat(long j11, @Nullable Format format, int i11) {
        if (!Util.areEqual(this.currentVideoFormat, format)) {
            if (this.currentVideoFormat == null && i11 == 0) {
                i11 = 1;
            }
            this.currentVideoFormat = format;
            reportTrackChangeEvent(1, j11, format, i11);
        }
    }

    private void reportTrackChangeEvent(int i11, long j11, @Nullable Format format, int i12) {
        TrackChangeEvent.Builder a11 = new TrackChangeEvent.Builder(i11).setTimeSinceCreatedMillis(j11 - this.startTimeMs);
        if (format != null) {
            TrackChangeEvent.Builder unused = a11.setTrackState(1);
            TrackChangeEvent.Builder unused2 = a11.setTrackChangeReason(getTrackChangeReason(i12));
            String str = format.containerMimeType;
            if (str != null) {
                TrackChangeEvent.Builder unused3 = a11.setContainerMimeType(str);
            }
            String str2 = format.sampleMimeType;
            if (str2 != null) {
                TrackChangeEvent.Builder unused4 = a11.setSampleMimeType(str2);
            }
            String str3 = format.codecs;
            if (str3 != null) {
                TrackChangeEvent.Builder unused5 = a11.setCodecName(str3);
            }
            int i13 = format.bitrate;
            if (i13 != -1) {
                TrackChangeEvent.Builder unused6 = a11.setBitrate(i13);
            }
            int i14 = format.width;
            if (i14 != -1) {
                TrackChangeEvent.Builder unused7 = a11.setWidth(i14);
            }
            int i15 = format.height;
            if (i15 != -1) {
                TrackChangeEvent.Builder unused8 = a11.setHeight(i15);
            }
            int i16 = format.channelCount;
            if (i16 != -1) {
                TrackChangeEvent.Builder unused9 = a11.setChannelCount(i16);
            }
            int i17 = format.sampleRate;
            if (i17 != -1) {
                TrackChangeEvent.Builder unused10 = a11.setAudioSampleRate(i17);
            }
            String str4 = format.language;
            if (str4 != null) {
                Pair<String, String> languageAndRegion = getLanguageAndRegion(str4);
                TrackChangeEvent.Builder unused11 = a11.setLanguage((String) languageAndRegion.first);
                Object obj = languageAndRegion.second;
                if (obj != null) {
                    TrackChangeEvent.Builder unused12 = a11.setLanguageRegion((String) obj);
                }
            }
            float f11 = format.frameRate;
            if (f11 != -1.0f) {
                TrackChangeEvent.Builder unused13 = a11.setVideoFrameRate(f11);
            }
        } else {
            TrackChangeEvent.Builder unused14 = a11.setTrackState(0);
        }
        this.reportedEventsForCurrentSession = true;
        this.playbackSession.reportTrackChangeEvent(a11.build());
    }

    private int resolveNewPlaybackState(Player player) {
        int playbackState = player.getPlaybackState();
        if (this.isSeeking) {
            return 5;
        }
        if (this.hasFatalError) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i11 = this.currentPlaybackState;
            if (i11 == 0 || i11 == 2) {
                return 2;
            }
            if (!player.getPlayWhenReady()) {
                return 7;
            }
            if (player.getPlaybackSuppressionReason() != 0) {
                return 10;
            }
            return 6;
        } else if (playbackState == 3) {
            if (!player.getPlayWhenReady()) {
                return 4;
            }
            if (player.getPlaybackSuppressionReason() != 0) {
                return 9;
            }
            return 3;
        } else if (playbackState != 1 || this.currentPlaybackState == 0) {
            return this.currentPlaybackState;
        } else {
            return 12;
        }
    }

    public LogSessionId getLogSessionId() {
        return this.playbackSession.getSessionId();
    }

    public void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String str, String str2) {
    }

    public /* synthetic */ void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        a.a(this, eventTime, audioAttributes);
    }

    public /* synthetic */ void onAudioCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.b(this, eventTime, exc);
    }

    public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11) {
        a.c(this, eventTime, str, j11);
    }

    public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        a.d(this, eventTime, str, j11, j12);
    }

    public /* synthetic */ void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        a.e(this, eventTime, str);
    }

    public /* synthetic */ void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        a.f(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        a.g(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        a.h(this, eventTime, format);
    }

    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        a.i(this, eventTime, format, decoderReuseEvaluation);
    }

    public /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j11) {
        a.j(this, eventTime, j11);
    }

    public /* synthetic */ void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i11) {
        a.k(this, eventTime, i11);
    }

    public /* synthetic */ void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.l(this, eventTime, exc);
    }

    public /* synthetic */ void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
        a.m(this, eventTime, i11, j11, j12);
    }

    public /* synthetic */ void onAvailableCommandsChanged(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        a.n(this, eventTime, commands);
    }

    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
        long j13;
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId != null) {
            String sessionForMediaPeriodId = this.sessionManager.getSessionForMediaPeriodId(eventTime.timeline, (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId));
            Long l11 = this.bandwidthBytes.get(sessionForMediaPeriodId);
            Long l12 = this.bandwidthTimeMs.get(sessionForMediaPeriodId);
            HashMap<String, Long> hashMap = this.bandwidthBytes;
            long j14 = 0;
            if (l11 == null) {
                j13 = 0;
            } else {
                j13 = l11.longValue();
            }
            hashMap.put(sessionForMediaPeriodId, Long.valueOf(j13 + j11));
            HashMap<String, Long> hashMap2 = this.bandwidthTimeMs;
            if (l12 != null) {
                j14 = l12.longValue();
            }
            hashMap2.put(sessionForMediaPeriodId, Long.valueOf(j14 + ((long) i11)));
        }
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
        if (eventTime.mediaPeriodId != null) {
            PendingFormatUpdate pendingFormatUpdate = new PendingFormatUpdate((Format) Assertions.checkNotNull(mediaLoadData.trackFormat), mediaLoadData.trackSelectionReason, this.sessionManager.getSessionForMediaPeriodId(eventTime.timeline, (MediaSource.MediaPeriodId) Assertions.checkNotNull(eventTime.mediaPeriodId)));
            int i11 = mediaLoadData.trackType;
            if (i11 != 0) {
                if (i11 == 1) {
                    this.pendingAudioFormat = pendingFormatUpdate;
                    return;
                } else if (i11 != 2) {
                    if (i11 == 3) {
                        this.pendingTextFormat = pendingFormatUpdate;
                        return;
                    }
                    return;
                }
            }
            this.pendingVideoFormat = pendingFormatUpdate;
        }
    }

    public /* synthetic */ void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        a.y(this, eventTime);
    }

    public /* synthetic */ void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        a.z(this, eventTime);
    }

    public /* synthetic */ void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        a.A(this, eventTime);
    }

    public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        a.B(this, eventTime);
    }

    public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime, int i11) {
        a.C(this, eventTime, i11);
    }

    public /* synthetic */ void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.D(this, eventTime, exc);
    }

    public /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        a.E(this, eventTime);
    }

    public /* synthetic */ void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i11, long j11) {
        a.F(this, eventTime, i11, j11);
    }

    public void onEvents(Player player, AnalyticsListener.Events events) {
        if (events.size() != 0) {
            maybeAddSessions(events);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            maybeUpdateMetricsBuilderValues(player, events);
            maybeReportPlaybackError(elapsedRealtime);
            maybeReportTrackChanges(player, events, elapsedRealtime);
            maybeReportNetworkChange(elapsedRealtime);
            maybeReportPlaybackStateChange(player, events, elapsedRealtime);
            if (events.contains(1028)) {
                this.sessionManager.finishAllSessions(events.getEventTime(1028));
            }
        }
    }

    public /* synthetic */ void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        a.H(this, eventTime, z11);
    }

    public /* synthetic */ void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        a.I(this, eventTime, z11);
    }

    public /* synthetic */ void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        a.J(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        a.K(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        this.ioErrorType = mediaLoadData.dataType;
    }

    public /* synthetic */ void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        a.M(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        a.N(this, eventTime, z11);
    }

    public /* synthetic */ void onMaxSeekToPreviousPositionChanged(AnalyticsListener.EventTime eventTime, long j11) {
        a.O(this, eventTime, j11);
    }

    public /* synthetic */ void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i11) {
        a.P(this, eventTime, mediaItem, i11);
    }

    public /* synthetic */ void onMediaMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        a.Q(this, eventTime, mediaMetadata);
    }

    public /* synthetic */ void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        a.R(this, eventTime, metadata);
    }

    public /* synthetic */ void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z11, int i11) {
        a.S(this, eventTime, z11, i11);
    }

    public /* synthetic */ void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        a.T(this, eventTime, playbackParameters);
    }

    public /* synthetic */ void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i11) {
        a.U(this, eventTime, i11);
    }

    public /* synthetic */ void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i11) {
        a.V(this, eventTime, i11);
    }

    public void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.pendingPlayerError = playbackException;
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
        if (i11 == 1) {
            this.isSeeking = true;
        }
        this.discontinuityReason = i11;
    }

    public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Object obj, long j11) {
        a.d0(this, eventTime, obj, j11);
    }

    public /* synthetic */ void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i11) {
        a.e0(this, eventTime, i11);
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

    public void onSessionActive(AnalyticsListener.EventTime eventTime, String str) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId == null || !mediaPeriodId.isAd()) {
            finishCurrentSession();
            this.activeSessionId = str;
            this.metricsBuilder = new PlaybackMetrics.Builder().setPlayerName(ExoPlayerLibraryInfo.TAG).setPlayerVersion(ExoPlayerLibraryInfo.VERSION);
            maybeUpdateTimelineMetadata(eventTime.timeline, eventTime.mediaPeriodId);
        }
    }

    public void onSessionCreated(AnalyticsListener.EventTime eventTime, String str) {
    }

    public void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z11) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if ((mediaPeriodId == null || !mediaPeriodId.isAd()) && str.equals(this.activeSessionId)) {
            finishCurrentSession();
        }
        this.bandwidthTimeMs.remove(str);
        this.bandwidthBytes.remove(str);
    }

    public /* synthetic */ void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        a.j0(this, eventTime, z11);
    }

    public /* synthetic */ void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        a.k0(this, eventTime, z11);
    }

    public /* synthetic */ void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i11, int i12) {
        a.l0(this, eventTime, i11, i12);
    }

    public /* synthetic */ void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i11) {
        a.m0(this, eventTime, i11);
    }

    public /* synthetic */ void onTrackSelectionParametersChanged(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        a.n0(this, eventTime, trackSelectionParameters);
    }

    public /* synthetic */ void onTracksChanged(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        a.o0(this, eventTime, tracks);
    }

    public /* synthetic */ void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        a.p0(this, eventTime, mediaLoadData);
    }

    public /* synthetic */ void onVideoCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.q0(this, eventTime, exc);
    }

    public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11) {
        a.r0(this, eventTime, str, j11);
    }

    public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        a.s0(this, eventTime, str, j11, j12);
    }

    public /* synthetic */ void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        a.t0(this, eventTime, str);
    }

    public void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.droppedFrames += decoderCounters.droppedBufferCount;
        this.playedFrames += decoderCounters.renderedOutputBufferCount;
    }

    public /* synthetic */ void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        a.v0(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j11, int i11) {
        a.w0(this, eventTime, j11, i11);
    }

    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        a.x0(this, eventTime, format);
    }

    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        a.y0(this, eventTime, format, decoderReuseEvaluation);
    }

    public /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i11, int i12, int i13, float f11) {
        a.z0(this, eventTime, i11, i12, i13, f11);
    }

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        PendingFormatUpdate pendingFormatUpdate = this.pendingVideoFormat;
        if (pendingFormatUpdate != null) {
            Format format = pendingFormatUpdate.format;
            if (format.height == -1) {
                this.pendingVideoFormat = new PendingFormatUpdate(format.buildUpon().setWidth(videoSize.width).setHeight(videoSize.height).build(), pendingFormatUpdate.selectionReason, pendingFormatUpdate.sessionId);
            }
        }
    }

    public /* synthetic */ void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f11) {
        a.B0(this, eventTime, f11);
    }
}
