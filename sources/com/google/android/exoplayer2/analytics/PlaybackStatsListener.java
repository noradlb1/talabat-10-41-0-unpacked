package com.google.android.exoplayer2.analytics;

import android.os.SystemClock;
import android.util.Pair;
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
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.analytics.PlaybackStats;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import h7.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    @Nullable
    private Format audioFormat;
    private long bandwidthBytes;
    private long bandwidthTimeMs;
    @Nullable
    private final Callback callback;
    private long discontinuityFromPositionMs;
    @Nullable
    private String discontinuityFromSession;
    private int discontinuityReason;
    private int droppedFrames;
    private PlaybackStats finishedPlaybackStats = PlaybackStats.EMPTY;
    private final boolean keepHistory;
    @Nullable
    private Exception nonFatalException;
    private final Timeline.Period period = new Timeline.Period();
    private final Map<String, PlaybackStatsTracker> playbackStatsTrackers = new HashMap();
    private final PlaybackSessionManager sessionManager;
    private final Map<String, AnalyticsListener.EventTime> sessionStartEventTimes = new HashMap();
    @Nullable
    private Format videoFormat;
    private VideoSize videoSize = VideoSize.UNKNOWN;

    public interface Callback {
        void onPlaybackStatsReady(AnalyticsListener.EventTime eventTime, PlaybackStats playbackStats);
    }

    public static final class PlaybackStatsTracker {
        private long audioFormatBitrateTimeProduct;
        private final List<PlaybackStats.EventTimeAndFormat> audioFormatHistory;
        private long audioFormatTimeMs;
        private long audioUnderruns;
        private long bandwidthBytes;
        private long bandwidthTimeMs;
        @Nullable
        private Format currentAudioFormat;
        private float currentPlaybackSpeed;
        private int currentPlaybackState;
        private long currentPlaybackStateStartTimeMs;
        @Nullable
        private Format currentVideoFormat;
        private long droppedFrames;
        private int fatalErrorCount;
        private final List<PlaybackStats.EventTimeAndException> fatalErrorHistory;
        private long firstReportedTimeMs;
        private boolean hasBeenReady;
        private boolean hasEnded;
        private boolean hasFatalError;
        private long initialAudioFormatBitrate;
        private long initialVideoFormatBitrate;
        private int initialVideoFormatHeight;
        private final boolean isAd;
        private boolean isForeground;
        private boolean isInterruptedByAd;
        private boolean isJoinTimeInvalid;
        private boolean isSeeking;
        private final boolean keepHistory;
        private long lastAudioFormatStartTimeMs;
        private long lastRebufferStartTimeMs;
        private long lastVideoFormatStartTimeMs;
        private long maxRebufferTimeMs;
        private final List<long[]> mediaTimeHistory;
        private int nonFatalErrorCount;
        private final List<PlaybackStats.EventTimeAndException> nonFatalErrorHistory;
        private int pauseBufferCount;
        private int pauseCount;
        private final long[] playbackStateDurationsMs = new long[16];
        private final List<PlaybackStats.EventTimeAndPlaybackState> playbackStateHistory;
        private int rebufferCount;
        private int seekCount;
        private boolean startedLoading;
        private long videoFormatBitrateTimeMs;
        private long videoFormatBitrateTimeProduct;
        private long videoFormatHeightTimeMs;
        private long videoFormatHeightTimeProduct;
        private final List<PlaybackStats.EventTimeAndFormat> videoFormatHistory;

        public PlaybackStatsTracker(boolean z11, AnalyticsListener.EventTime eventTime) {
            List<PlaybackStats.EventTimeAndPlaybackState> list;
            List<long[]> list2;
            List<PlaybackStats.EventTimeAndFormat> list3;
            List<PlaybackStats.EventTimeAndFormat> list4;
            List<PlaybackStats.EventTimeAndException> list5;
            List<PlaybackStats.EventTimeAndException> list6;
            this.keepHistory = z11;
            if (z11) {
                list = new ArrayList<>();
            } else {
                list = Collections.emptyList();
            }
            this.playbackStateHistory = list;
            if (z11) {
                list2 = new ArrayList<>();
            } else {
                list2 = Collections.emptyList();
            }
            this.mediaTimeHistory = list2;
            if (z11) {
                list3 = new ArrayList<>();
            } else {
                list3 = Collections.emptyList();
            }
            this.videoFormatHistory = list3;
            if (z11) {
                list4 = new ArrayList<>();
            } else {
                list4 = Collections.emptyList();
            }
            this.audioFormatHistory = list4;
            if (z11) {
                list5 = new ArrayList<>();
            } else {
                list5 = Collections.emptyList();
            }
            this.fatalErrorHistory = list5;
            if (z11) {
                list6 = new ArrayList<>();
            } else {
                list6 = Collections.emptyList();
            }
            this.nonFatalErrorHistory = list6;
            boolean z12 = false;
            this.currentPlaybackState = 0;
            this.currentPlaybackStateStartTimeMs = eventTime.realtimeMs;
            this.firstReportedTimeMs = C.TIME_UNSET;
            this.maxRebufferTimeMs = C.TIME_UNSET;
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
            if (mediaPeriodId != null && mediaPeriodId.isAd()) {
                z12 = true;
            }
            this.isAd = z12;
            this.initialAudioFormatBitrate = -1;
            this.initialVideoFormatBitrate = -1;
            this.initialVideoFormatHeight = -1;
            this.currentPlaybackSpeed = 1.0f;
        }

        private long[] guessMediaTimeBasedOnElapsedRealtime(long j11) {
            List<long[]> list = this.mediaTimeHistory;
            long[] jArr = list.get(list.size() - 1);
            return new long[]{j11, jArr[1] + ((long) (((float) (j11 - jArr[0])) * this.currentPlaybackSpeed))};
        }

        private static boolean isInvalidJoinTransition(int i11, int i12) {
            return ((i11 != 1 && i11 != 2 && i11 != 14) || i12 == 1 || i12 == 2 || i12 == 14 || i12 == 3 || i12 == 4 || i12 == 9 || i12 == 11) ? false : true;
        }

        private static boolean isPausedState(int i11) {
            return i11 == 4 || i11 == 7;
        }

        private static boolean isReadyState(int i11) {
            return i11 == 3 || i11 == 4 || i11 == 9;
        }

        private static boolean isRebufferingState(int i11) {
            return i11 == 6 || i11 == 7 || i11 == 10;
        }

        private void maybeRecordAudioFormatTime(long j11) {
            Format format;
            int i11;
            if (!(this.currentPlaybackState != 3 || (format = this.currentAudioFormat) == null || (i11 = format.bitrate) == -1)) {
                long j12 = (long) (((float) (j11 - this.lastAudioFormatStartTimeMs)) * this.currentPlaybackSpeed);
                this.audioFormatTimeMs += j12;
                this.audioFormatBitrateTimeProduct += j12 * ((long) i11);
            }
            this.lastAudioFormatStartTimeMs = j11;
        }

        private void maybeRecordVideoFormatTime(long j11) {
            Format format;
            if (this.currentPlaybackState == 3 && (format = this.currentVideoFormat) != null) {
                long j12 = (long) (((float) (j11 - this.lastVideoFormatStartTimeMs)) * this.currentPlaybackSpeed);
                int i11 = format.height;
                if (i11 != -1) {
                    this.videoFormatHeightTimeMs += j12;
                    this.videoFormatHeightTimeProduct += ((long) i11) * j12;
                }
                int i12 = format.bitrate;
                if (i12 != -1) {
                    this.videoFormatBitrateTimeMs += j12;
                    this.videoFormatBitrateTimeProduct += j12 * ((long) i12);
                }
            }
            this.lastVideoFormatStartTimeMs = j11;
        }

        private void maybeUpdateAudioFormat(AnalyticsListener.EventTime eventTime, @Nullable Format format) {
            int i11;
            if (!Util.areEqual(this.currentAudioFormat, format)) {
                maybeRecordAudioFormatTime(eventTime.realtimeMs);
                if (!(format == null || this.initialAudioFormatBitrate != -1 || (i11 = format.bitrate) == -1)) {
                    this.initialAudioFormatBitrate = (long) i11;
                }
                this.currentAudioFormat = format;
                if (this.keepHistory) {
                    this.audioFormatHistory.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
                }
            }
        }

        private void maybeUpdateMaxRebufferTimeMs(long j11) {
            if (isRebufferingState(this.currentPlaybackState)) {
                long j12 = j11 - this.lastRebufferStartTimeMs;
                long j13 = this.maxRebufferTimeMs;
                if (j13 == C.TIME_UNSET || j12 > j13) {
                    this.maxRebufferTimeMs = j12;
                }
            }
        }

        private void maybeUpdateMediaTimeHistory(long j11, long j12) {
            if (this.keepHistory) {
                if (this.currentPlaybackState != 3) {
                    if (j12 != C.TIME_UNSET) {
                        if (!this.mediaTimeHistory.isEmpty()) {
                            List<long[]> list = this.mediaTimeHistory;
                            long j13 = list.get(list.size() - 1)[1];
                            if (j13 != j12) {
                                this.mediaTimeHistory.add(new long[]{j11, j13});
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (j12 != C.TIME_UNSET) {
                    this.mediaTimeHistory.add(new long[]{j11, j12});
                } else if (!this.mediaTimeHistory.isEmpty()) {
                    this.mediaTimeHistory.add(guessMediaTimeBasedOnElapsedRealtime(j11));
                }
            }
        }

        private void maybeUpdateVideoFormat(AnalyticsListener.EventTime eventTime, @Nullable Format format) {
            int i11;
            int i12;
            if (!Util.areEqual(this.currentVideoFormat, format)) {
                maybeRecordVideoFormatTime(eventTime.realtimeMs);
                if (format != null) {
                    if (this.initialVideoFormatHeight == -1 && (i12 = format.height) != -1) {
                        this.initialVideoFormatHeight = i12;
                    }
                    if (this.initialVideoFormatBitrate == -1 && (i11 = format.bitrate) != -1) {
                        this.initialVideoFormatBitrate = (long) i11;
                    }
                }
                this.currentVideoFormat = format;
                if (this.keepHistory) {
                    this.videoFormatHistory.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
                }
            }
        }

        private int resolveNewPlaybackState(Player player) {
            int playbackState = player.getPlaybackState();
            if (this.isSeeking && this.isForeground) {
                return 5;
            }
            if (this.hasFatalError) {
                return 13;
            }
            if (!this.isForeground) {
                return this.startedLoading ? 1 : 0;
            }
            if (this.isInterruptedByAd) {
                return 14;
            }
            if (playbackState == 4) {
                return 11;
            }
            if (playbackState == 2) {
                int i11 = this.currentPlaybackState;
                if (i11 == 0 || i11 == 1 || i11 == 2 || i11 == 14) {
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

        private void updatePlaybackState(int i11, AnalyticsListener.EventTime eventTime) {
            boolean z11;
            boolean z12 = false;
            if (eventTime.realtimeMs >= this.currentPlaybackStateStartTimeMs) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkArgument(z11);
            long j11 = eventTime.realtimeMs;
            long[] jArr = this.playbackStateDurationsMs;
            int i12 = this.currentPlaybackState;
            jArr[i12] = jArr[i12] + (j11 - this.currentPlaybackStateStartTimeMs);
            if (this.firstReportedTimeMs == C.TIME_UNSET) {
                this.firstReportedTimeMs = j11;
            }
            this.isJoinTimeInvalid |= isInvalidJoinTransition(i12, i11);
            this.hasBeenReady |= isReadyState(i11);
            boolean z13 = this.hasEnded;
            if (i11 == 11) {
                z12 = true;
            }
            this.hasEnded = z13 | z12;
            if (!isPausedState(this.currentPlaybackState) && isPausedState(i11)) {
                this.pauseCount++;
            }
            if (i11 == 5) {
                this.seekCount++;
            }
            if (!isRebufferingState(this.currentPlaybackState) && isRebufferingState(i11)) {
                this.rebufferCount++;
                this.lastRebufferStartTimeMs = eventTime.realtimeMs;
            }
            if (isRebufferingState(this.currentPlaybackState) && this.currentPlaybackState != 7 && i11 == 7) {
                this.pauseBufferCount++;
            }
            maybeUpdateMaxRebufferTimeMs(eventTime.realtimeMs);
            this.currentPlaybackState = i11;
            this.currentPlaybackStateStartTimeMs = eventTime.realtimeMs;
            if (this.keepHistory) {
                this.playbackStateHistory.add(new PlaybackStats.EventTimeAndPlaybackState(eventTime, i11));
            }
        }

        public PlaybackStats build(boolean z11) {
            ArrayList arrayList;
            long[] jArr;
            int i11;
            long j11;
            int i12;
            List list;
            List list2;
            List list3;
            int i13;
            int i14;
            int i15;
            int i16;
            long[] jArr2 = this.playbackStateDurationsMs;
            List<long[]> list4 = this.mediaTimeHistory;
            if (!z11) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long[] copyOf = Arrays.copyOf(this.playbackStateDurationsMs, 16);
                long max = Math.max(0, elapsedRealtime - this.currentPlaybackStateStartTimeMs);
                int i17 = this.currentPlaybackState;
                copyOf[i17] = copyOf[i17] + max;
                maybeUpdateMaxRebufferTimeMs(elapsedRealtime);
                maybeRecordVideoFormatTime(elapsedRealtime);
                maybeRecordAudioFormatTime(elapsedRealtime);
                ArrayList arrayList2 = new ArrayList(this.mediaTimeHistory);
                if (this.keepHistory && this.currentPlaybackState == 3) {
                    arrayList2.add(guessMediaTimeBasedOnElapsedRealtime(elapsedRealtime));
                }
                jArr = copyOf;
                arrayList = arrayList2;
            } else {
                jArr = jArr2;
                arrayList = list4;
            }
            if (this.isJoinTimeInvalid || !this.hasBeenReady) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            if (i11 != 0) {
                j11 = C.TIME_UNSET;
            } else {
                j11 = jArr[2];
            }
            long j12 = j11;
            if (jArr[1] > 0) {
                i12 = 1;
            } else {
                i12 = 0;
            }
            if (z11) {
                list = this.videoFormatHistory;
            } else {
                list = new ArrayList(this.videoFormatHistory);
            }
            List list5 = list;
            if (z11) {
                list2 = this.audioFormatHistory;
            } else {
                list2 = new ArrayList(this.audioFormatHistory);
            }
            List list6 = list2;
            if (z11) {
                list3 = this.playbackStateHistory;
            } else {
                list3 = new ArrayList(this.playbackStateHistory);
            }
            List list7 = list3;
            long j13 = this.firstReportedTimeMs;
            boolean z12 = this.isForeground;
            boolean z13 = !this.hasBeenReady;
            boolean z14 = this.hasEnded;
            int i18 = i11 ^ 1;
            int i19 = this.pauseCount;
            int i21 = this.pauseBufferCount;
            int i22 = this.seekCount;
            int i23 = this.rebufferCount;
            int i24 = i21;
            long j14 = this.maxRebufferTimeMs;
            boolean z15 = this.isAd;
            long[] jArr3 = jArr;
            long j15 = this.videoFormatHeightTimeMs;
            long j16 = this.videoFormatHeightTimeProduct;
            long j17 = this.videoFormatBitrateTimeMs;
            long j18 = this.videoFormatBitrateTimeProduct;
            long j19 = this.audioFormatTimeMs;
            long j21 = this.audioFormatBitrateTimeProduct;
            int i25 = this.initialVideoFormatHeight;
            int i26 = i25;
            if (i25 == -1) {
                i13 = 0;
            } else {
                i13 = 1;
            }
            long j22 = this.initialVideoFormatBitrate;
            long j23 = j22;
            if (j22 == -1) {
                i14 = 0;
            } else {
                i14 = 1;
            }
            long j24 = this.initialAudioFormatBitrate;
            long j25 = j24;
            if (j24 == -1) {
                i15 = 0;
            } else {
                i15 = 1;
            }
            long j26 = this.bandwidthTimeMs;
            long j27 = this.bandwidthBytes;
            long j28 = this.droppedFrames;
            long j29 = this.audioUnderruns;
            int i27 = this.fatalErrorCount;
            if (i27 > 0) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            int i28 = this.nonFatalErrorCount;
            List<PlaybackStats.EventTimeAndException> list8 = this.fatalErrorHistory;
            List<PlaybackStats.EventTimeAndException> list9 = this.nonFatalErrorHistory;
            long j31 = j28;
            long j32 = j29;
            long j33 = j26;
            long j34 = j27;
            long j35 = j25;
            long j36 = j23;
            long j37 = j21;
            int i29 = i26;
            long j38 = j19;
            long j39 = j18;
            long j41 = j17;
            long j42 = j16;
            long j43 = j15;
            boolean z16 = z15;
            long[] jArr4 = jArr3;
            int i31 = i19;
            int i32 = i22;
            int i33 = i23;
            long j44 = j14;
            long j45 = j37;
            int i34 = i14;
            int i35 = i29;
            long j46 = j36;
            int i36 = i15;
            long j47 = j35;
            long j48 = j33;
            long j49 = j34;
            long j50 = j31;
            long j51 = j32;
            return new PlaybackStats(1, jArr4, list7, arrayList, j13, z12 ? 1 : 0, z13 ? 1 : 0, z14 ? 1 : 0, i12, j12, i18, i31, i24, i32, i33, j44, z16 ? 1 : 0, list5, list6, j43, j42, j41, j39, j38, j45, i13, i34, i35, j46, i36, j47, j48, j49, j50, j51, i16, i27, i28, list8, list9);
        }

        public void onEvents(Player player, AnalyticsListener.EventTime eventTime, boolean z11, long j11, boolean z12, int i11, boolean z13, boolean z14, @Nullable PlaybackException playbackException, @Nullable Exception exc, long j12, long j13, @Nullable Format format, @Nullable Format format2, @Nullable VideoSize videoSize) {
            AnalyticsListener.EventTime eventTime2 = eventTime;
            long j14 = j11;
            PlaybackException playbackException2 = playbackException;
            Exception exc2 = exc;
            Format format3 = format;
            Format format4 = format2;
            VideoSize videoSize2 = videoSize;
            long j15 = C.TIME_UNSET;
            if (j14 != C.TIME_UNSET) {
                maybeUpdateMediaTimeHistory(eventTime2.realtimeMs, j14);
                this.isSeeking = true;
            }
            if (player.getPlaybackState() != 2) {
                this.isSeeking = false;
            }
            int playbackState = player.getPlaybackState();
            if (playbackState == 1 || playbackState == 4 || z12) {
                this.isInterruptedByAd = false;
            }
            if (playbackException2 != null) {
                this.hasFatalError = true;
                this.fatalErrorCount++;
                if (this.keepHistory) {
                    this.fatalErrorHistory.add(new PlaybackStats.EventTimeAndException(eventTime2, playbackException2));
                }
            } else if (player.getPlayerError() == null) {
                this.hasFatalError = false;
            }
            if (this.isForeground && !this.isInterruptedByAd) {
                Tracks currentTracks = player.getCurrentTracks();
                if (!currentTracks.isTypeSelected(2)) {
                    maybeUpdateVideoFormat(eventTime2, (Format) null);
                }
                if (!currentTracks.isTypeSelected(1)) {
                    maybeUpdateAudioFormat(eventTime2, (Format) null);
                }
            }
            if (format3 != null) {
                maybeUpdateVideoFormat(eventTime2, format3);
            }
            if (format4 != null) {
                maybeUpdateAudioFormat(eventTime2, format4);
            }
            Format format5 = this.currentVideoFormat;
            if (!(format5 == null || format5.height != -1 || videoSize2 == null)) {
                maybeUpdateVideoFormat(eventTime2, format5.buildUpon().setWidth(videoSize2.width).setHeight(videoSize2.height).build());
            }
            if (z14) {
                this.startedLoading = true;
            }
            if (z13) {
                this.audioUnderruns++;
            }
            this.droppedFrames += (long) i11;
            this.bandwidthTimeMs += j12;
            this.bandwidthBytes += j13;
            if (exc2 != null) {
                this.nonFatalErrorCount++;
                if (this.keepHistory) {
                    this.nonFatalErrorHistory.add(new PlaybackStats.EventTimeAndException(eventTime2, exc2));
                }
            }
            int resolveNewPlaybackState = resolveNewPlaybackState(player);
            float f11 = player.getPlaybackParameters().speed;
            if (!(this.currentPlaybackState == resolveNewPlaybackState && this.currentPlaybackSpeed == f11)) {
                long j16 = eventTime2.realtimeMs;
                if (z11) {
                    j15 = eventTime2.eventPlaybackPositionMs;
                }
                maybeUpdateMediaTimeHistory(j16, j15);
                maybeRecordVideoFormatTime(eventTime2.realtimeMs);
                maybeRecordAudioFormatTime(eventTime2.realtimeMs);
            }
            this.currentPlaybackSpeed = f11;
            if (this.currentPlaybackState != resolveNewPlaybackState) {
                updatePlaybackState(resolveNewPlaybackState, eventTime2);
            }
        }

        public void onFinished(AnalyticsListener.EventTime eventTime, boolean z11, long j11) {
            int i11 = 11;
            if (this.currentPlaybackState != 11 && !z11) {
                i11 = 15;
            }
            maybeUpdateMediaTimeHistory(eventTime.realtimeMs, j11);
            maybeRecordVideoFormatTime(eventTime.realtimeMs);
            maybeRecordAudioFormatTime(eventTime.realtimeMs);
            updatePlaybackState(i11, eventTime);
        }

        public void onForeground() {
            this.isForeground = true;
        }

        public void onInterruptedByAd() {
            this.isInterruptedByAd = true;
            this.isSeeking = false;
        }
    }

    public PlaybackStatsListener(boolean z11, @Nullable Callback callback2) {
        this.callback = callback2;
        this.keepHistory = z11;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.sessionManager = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.setListener(this);
    }

    private Pair<AnalyticsListener.EventTime, Boolean> findBestEventTime(AnalyticsListener.Events events, String str) {
        MediaSource.MediaPeriodId mediaPeriodId;
        AnalyticsListener.Events events2 = events;
        String str2 = str;
        AnalyticsListener.EventTime eventTime = null;
        boolean z11 = false;
        for (int i11 = 0; i11 < events.size(); i11++) {
            AnalyticsListener.EventTime eventTime2 = events2.getEventTime(events2.get(i11));
            boolean belongsToSession = this.sessionManager.belongsToSession(eventTime2, str2);
            if (eventTime == null || ((belongsToSession && !z11) || (belongsToSession == z11 && eventTime2.realtimeMs > eventTime.realtimeMs))) {
                eventTime = eventTime2;
                z11 = belongsToSession;
            }
        }
        Assertions.checkNotNull(eventTime);
        if (!z11 && (mediaPeriodId = eventTime.mediaPeriodId) != null && mediaPeriodId.isAd()) {
            long adGroupTimeUs = eventTime.timeline.getPeriodByUid(eventTime.mediaPeriodId.periodUid, this.period).getAdGroupTimeUs(eventTime.mediaPeriodId.adGroupIndex);
            if (adGroupTimeUs == Long.MIN_VALUE) {
                adGroupTimeUs = this.period.durationUs;
            }
            long positionInWindowUs = adGroupTimeUs + this.period.getPositionInWindowUs();
            long j11 = eventTime.realtimeMs;
            Timeline timeline = eventTime.timeline;
            int i12 = eventTime.windowIndex;
            MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
            AnalyticsListener.EventTime eventTime3 = new AnalyticsListener.EventTime(j11, timeline, i12, new MediaSource.MediaPeriodId(mediaPeriodId2.periodUid, mediaPeriodId2.windowSequenceNumber, mediaPeriodId2.adGroupIndex), Util.usToMs(positionInWindowUs), eventTime.timeline, eventTime.currentWindowIndex, eventTime.currentMediaPeriodId, eventTime.currentPlaybackPositionMs, eventTime.totalBufferedDurationMs);
            z11 = this.sessionManager.belongsToSession(eventTime3, str);
            eventTime = eventTime3;
        }
        return Pair.create(eventTime, Boolean.valueOf(z11));
    }

    private boolean hasEvent(AnalyticsListener.Events events, String str, int i11) {
        if (!events.contains(i11) || !this.sessionManager.belongsToSession(events.getEventTime(i11), str)) {
            return false;
        }
        return true;
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

    public PlaybackStats getCombinedPlaybackStats() {
        int i11 = 1;
        PlaybackStats[] playbackStatsArr = new PlaybackStats[(this.playbackStatsTrackers.size() + 1)];
        playbackStatsArr[0] = this.finishedPlaybackStats;
        for (PlaybackStatsTracker build : this.playbackStatsTrackers.values()) {
            playbackStatsArr[i11] = build.build(false);
            i11++;
        }
        return PlaybackStats.merge(playbackStatsArr);
    }

    @Nullable
    public PlaybackStats getPlaybackStats() {
        PlaybackStatsTracker playbackStatsTracker;
        String activeSessionId = this.sessionManager.getActiveSessionId();
        if (activeSessionId == null) {
            playbackStatsTracker = null;
        } else {
            playbackStatsTracker = this.playbackStatsTrackers.get(activeSessionId);
        }
        if (playbackStatsTracker == null) {
            return null;
        }
        return playbackStatsTracker.build(false);
    }

    public void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String str, String str2) {
        ((PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.get(str))).onInterruptedByAd();
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
        this.bandwidthTimeMs = (long) i11;
        this.bandwidthBytes = j11;
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
        int i11 = mediaLoadData.trackType;
        if (i11 == 2 || i11 == 0) {
            this.videoFormat = mediaLoadData.trackFormat;
        } else if (i11 == 1) {
            this.audioFormat = mediaLoadData.trackFormat;
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

    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.nonFatalException = exc;
    }

    public /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        a.E(this, eventTime);
    }

    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i11, long j11) {
        this.droppedFrames = i11;
    }

    public void onEvents(Player player, AnalyticsListener.Events events) {
        boolean z11;
        long j11;
        int i11;
        PlaybackException playbackException;
        Exception exc;
        long j12;
        long j13;
        Format format;
        Format format2;
        VideoSize videoSize2;
        AnalyticsListener.Events events2 = events;
        if (events.size() != 0) {
            maybeAddSessions(events2);
            for (String next : this.playbackStatsTrackers.keySet()) {
                Pair<AnalyticsListener.EventTime, Boolean> findBestEventTime = findBestEventTime(events2, next);
                PlaybackStatsTracker playbackStatsTracker = this.playbackStatsTrackers.get(next);
                boolean hasEvent = hasEvent(events2, next, 11);
                boolean hasEvent2 = hasEvent(events2, next, 1018);
                boolean hasEvent3 = hasEvent(events2, next, 1011);
                boolean hasEvent4 = hasEvent(events2, next, 1000);
                boolean hasEvent5 = hasEvent(events2, next, 10);
                if (hasEvent(events2, next, 1003) || hasEvent(events2, next, 1024)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean hasEvent6 = hasEvent(events2, next, 1006);
                boolean hasEvent7 = hasEvent(events2, next, 1004);
                boolean hasEvent8 = hasEvent(events2, next, 25);
                AnalyticsListener.EventTime eventTime = (AnalyticsListener.EventTime) findBestEventTime.first;
                boolean booleanValue = ((Boolean) findBestEventTime.second).booleanValue();
                if (next.equals(this.discontinuityFromSession)) {
                    j11 = this.discontinuityFromPositionMs;
                } else {
                    j11 = C.TIME_UNSET;
                }
                if (hasEvent2) {
                    i11 = this.droppedFrames;
                } else {
                    i11 = 0;
                }
                if (hasEvent5) {
                    playbackException = player.getPlayerError();
                } else {
                    playbackException = null;
                }
                if (z11) {
                    exc = this.nonFatalException;
                } else {
                    exc = null;
                }
                if (hasEvent6) {
                    j12 = this.bandwidthTimeMs;
                } else {
                    j12 = 0;
                }
                if (hasEvent6) {
                    j13 = this.bandwidthBytes;
                } else {
                    j13 = 0;
                }
                if (hasEvent7) {
                    format = this.videoFormat;
                } else {
                    format = null;
                }
                if (hasEvent7) {
                    format2 = this.audioFormat;
                } else {
                    format2 = null;
                }
                if (hasEvent8) {
                    videoSize2 = this.videoSize;
                } else {
                    videoSize2 = null;
                }
                playbackStatsTracker.onEvents(player, eventTime, booleanValue, j11, hasEvent, i11, hasEvent3, hasEvent4, playbackException, exc, j12, j13, format, format2, videoSize2);
            }
            this.videoFormat = null;
            this.audioFormat = null;
            this.discontinuityFromSession = null;
            if (events2.contains(1028)) {
                this.sessionManager.finishAllSessions(events2.getEventTime(1028));
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
        this.nonFatalException = iOException;
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

    public /* synthetic */ void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        a.W(this, eventTime, playbackException);
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
        if (this.discontinuityFromSession == null) {
            this.discontinuityFromSession = this.sessionManager.getActiveSessionId();
            this.discontinuityFromPositionMs = positionInfo.positionMs;
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
        ((PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.get(str))).onForeground();
    }

    public void onSessionCreated(AnalyticsListener.EventTime eventTime, String str) {
        this.playbackStatsTrackers.put(str, new PlaybackStatsTracker(this.keepHistory, eventTime));
        this.sessionStartEventTimes.put(str, eventTime);
    }

    public void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z11) {
        long j11;
        PlaybackStatsTracker playbackStatsTracker = (PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.remove(str));
        AnalyticsListener.EventTime eventTime2 = (AnalyticsListener.EventTime) Assertions.checkNotNull(this.sessionStartEventTimes.remove(str));
        if (str.equals(this.discontinuityFromSession)) {
            j11 = this.discontinuityFromPositionMs;
        } else {
            j11 = C.TIME_UNSET;
        }
        playbackStatsTracker.onFinished(eventTime, z11, j11);
        PlaybackStats build = playbackStatsTracker.build(true);
        this.finishedPlaybackStats = PlaybackStats.merge(this.finishedPlaybackStats, build);
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onPlaybackStatsReady(eventTime2, build);
        }
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

    public /* synthetic */ void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        a.u0(this, eventTime, decoderCounters);
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

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize2) {
        this.videoSize = videoSize2;
    }

    public /* synthetic */ void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f11) {
        a.B0(this, eventTime, f11);
    }
}
