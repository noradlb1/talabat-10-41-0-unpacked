package com.google.android.exoplayer2.analytics;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlaybackException;
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
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import h7.a0;
import h7.a1;
import h7.b;
import h7.b0;
import h7.b1;
import h7.c;
import h7.c0;
import h7.c1;
import h7.d;
import h7.d0;
import h7.d1;
import h7.e0;
import h7.e1;
import h7.f;
import h7.f0;
import h7.f1;
import h7.g;
import h7.g0;
import h7.g1;
import h7.h;
import h7.h0;
import h7.h1;
import h7.i;
import h7.i0;
import h7.i1;
import h7.j;
import h7.j0;
import h7.j1;
import h7.k;
import h7.k0;
import h7.k1;
import h7.l;
import h7.l0;
import h7.l1;
import h7.m;
import h7.m0;
import h7.m1;
import h7.n;
import h7.n0;
import h7.n1;
import h7.o;
import h7.o0;
import h7.o1;
import h7.p;
import h7.p0;
import h7.p1;
import h7.q;
import h7.q0;
import h7.q1;
import h7.r;
import h7.r0;
import h7.r1;
import h7.s;
import h7.s0;
import h7.s1;
import h7.t;
import h7.t0;
import h7.u;
import h7.u0;
import h7.v;
import h7.v0;
import h7.w;
import h7.w0;
import h7.x;
import h7.x0;
import h7.y;
import h7.y0;
import h7.z;
import h7.z0;
import java.io.IOException;
import java.util.List;
import k7.e;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class DefaultAnalyticsCollector implements AnalyticsCollector {
    private final Clock clock;
    private final SparseArray<AnalyticsListener.EventTime> eventTimes;
    private HandlerWrapper handler;
    private boolean isSeeking;
    private ListenerSet<AnalyticsListener> listeners;
    private final MediaPeriodQueueTracker mediaPeriodQueueTracker;
    private final Timeline.Period period;
    private Player player;
    private final Timeline.Window window = new Timeline.Window();

    public static final class MediaPeriodQueueTracker {
        @Nullable
        private MediaSource.MediaPeriodId currentPlayerMediaPeriod;
        /* access modifiers changed from: private */
        public ImmutableList<MediaSource.MediaPeriodId> mediaPeriodQueue = ImmutableList.of();
        private ImmutableMap<MediaSource.MediaPeriodId, Timeline> mediaPeriodTimelines = ImmutableMap.of();
        private final Timeline.Period period;
        private MediaSource.MediaPeriodId playingMediaPeriod;
        private MediaSource.MediaPeriodId readingMediaPeriod;

        public MediaPeriodQueueTracker(Timeline.Period period2) {
            this.period = period2;
        }

        private void addTimelineForMediaPeriodId(ImmutableMap.Builder<MediaSource.MediaPeriodId, Timeline> builder, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId != null) {
                if (timeline.getIndexOfPeriod(mediaPeriodId.periodUid) != -1) {
                    builder.put(mediaPeriodId, timeline);
                    return;
                }
                Timeline timeline2 = this.mediaPeriodTimelines.get(mediaPeriodId);
                if (timeline2 != null) {
                    builder.put(mediaPeriodId, timeline2);
                }
            }
        }

        @Nullable
        private static MediaSource.MediaPeriodId findCurrentPlayerMediaPeriodInQueue(Player player, ImmutableList<MediaSource.MediaPeriodId> immutableList, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period2) {
            Object obj;
            int i11;
            Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            if (currentTimeline.isEmpty()) {
                obj = null;
            } else {
                obj = currentTimeline.getUidOfPeriod(currentPeriodIndex);
            }
            if (player.isPlayingAd() || currentTimeline.isEmpty()) {
                i11 = -1;
            } else {
                i11 = currentTimeline.getPeriod(currentPeriodIndex, period2).getAdGroupIndexAfterPositionUs(Util.msToUs(player.getCurrentPosition()) - period2.getPositionInWindowUs());
            }
            for (int i12 = 0; i12 < immutableList.size(); i12++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = immutableList.get(i12);
                if (isMatchingMediaPeriod(mediaPeriodId2, obj, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), i11)) {
                    return mediaPeriodId2;
                }
            }
            if (immutableList.isEmpty() && mediaPeriodId != null) {
                if (isMatchingMediaPeriod(mediaPeriodId, obj, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), i11)) {
                    return mediaPeriodId;
                }
            }
            return null;
        }

        private static boolean isMatchingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, @Nullable Object obj, boolean z11, int i11, int i12, int i13) {
            if (!mediaPeriodId.periodUid.equals(obj)) {
                return false;
            }
            if ((z11 && mediaPeriodId.adGroupIndex == i11 && mediaPeriodId.adIndexInAdGroup == i12) || (!z11 && mediaPeriodId.adGroupIndex == -1 && mediaPeriodId.nextAdGroupIndex == i13)) {
                return true;
            }
            return false;
        }

        private void updateMediaPeriodTimelines(Timeline timeline) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            if (this.mediaPeriodQueue.isEmpty()) {
                addTimelineForMediaPeriodId(builder, this.playingMediaPeriod, timeline);
                if (!Objects.equal(this.readingMediaPeriod, this.playingMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.readingMediaPeriod, timeline);
                }
                if (!Objects.equal(this.currentPlayerMediaPeriod, this.playingMediaPeriod) && !Objects.equal(this.currentPlayerMediaPeriod, this.readingMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.currentPlayerMediaPeriod, timeline);
                }
            } else {
                for (int i11 = 0; i11 < this.mediaPeriodQueue.size(); i11++) {
                    addTimelineForMediaPeriodId(builder, this.mediaPeriodQueue.get(i11), timeline);
                }
                if (!this.mediaPeriodQueue.contains(this.currentPlayerMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.currentPlayerMediaPeriod, timeline);
                }
            }
            this.mediaPeriodTimelines = builder.buildOrThrow();
        }

        @Nullable
        public MediaSource.MediaPeriodId getCurrentPlayerMediaPeriod() {
            return this.currentPlayerMediaPeriod;
        }

        @Nullable
        public MediaSource.MediaPeriodId getLoadingMediaPeriod() {
            if (this.mediaPeriodQueue.isEmpty()) {
                return null;
            }
            return (MediaSource.MediaPeriodId) Iterables.getLast(this.mediaPeriodQueue);
        }

        @Nullable
        public Timeline getMediaPeriodIdTimeline(MediaSource.MediaPeriodId mediaPeriodId) {
            return this.mediaPeriodTimelines.get(mediaPeriodId);
        }

        @Nullable
        public MediaSource.MediaPeriodId getPlayingMediaPeriod() {
            return this.playingMediaPeriod;
        }

        @Nullable
        public MediaSource.MediaPeriodId getReadingMediaPeriod() {
            return this.readingMediaPeriod;
        }

        public void onPositionDiscontinuity(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
        }

        public void onQueueUpdated(List<MediaSource.MediaPeriodId> list, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            this.mediaPeriodQueue = ImmutableList.copyOf(list);
            if (!list.isEmpty()) {
                this.playingMediaPeriod = list.get(0);
                this.readingMediaPeriod = (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId);
            }
            if (this.currentPlayerMediaPeriod == null) {
                this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            }
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }

        public void onTimelineChanged(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }
    }

    public DefaultAnalyticsCollector(Clock clock2) {
        this.clock = (Clock) Assertions.checkNotNull(clock2);
        this.listeners = new ListenerSet<>(Util.getCurrentOrMainLooper(), clock2, new y0());
        Timeline.Period period2 = new Timeline.Period();
        this.period = period2;
        this.mediaPeriodQueueTracker = new MediaPeriodQueueTracker(period2);
        this.eventTimes = new SparseArray<>();
    }

    private AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLoadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateMediaPeriodEventTime(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.player);
        boolean z11 = true;
        if (mediaPeriodId != null) {
            if (this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId) == null) {
                z11 = false;
            }
            if (z11) {
                return generateEventTime(mediaPeriodId);
            }
            return generateEventTime(Timeline.EMPTY, i11, mediaPeriodId);
        }
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (i11 >= currentTimeline.getWindowCount()) {
            z11 = false;
        }
        if (!z11) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i11, (MediaSource.MediaPeriodId) null);
    }

    private AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getPlayingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateReadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getReadingMediaPeriod());
    }

    private AnalyticsListener.EventTime getEventTimeForErrorEvent(@Nullable PlaybackException playbackException) {
        MediaPeriodId mediaPeriodId;
        if (!(playbackException instanceof ExoPlaybackException) || (mediaPeriodId = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) {
            return generateCurrentPlayerMediaPeriodEventTime();
        }
        return generateEventTime(new MediaSource.MediaPeriodId(mediaPeriodId));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(AnalyticsListener analyticsListener, FlagSet flagSet) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onAudioDecoderInitialized$4(AnalyticsListener.EventTime eventTime, String str, long j11, long j12, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j11);
        long j13 = j11;
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j12, j13);
        analyticsListener.onDecoderInitialized(eventTime, 1, str, j13);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onAudioDisabled$9(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDisabled(eventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(eventTime, 1, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onAudioEnabled$3(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioEnabled(eventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(eventTime, 1, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onAudioInputFormatChanged$5(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioInputFormatChanged(eventTime, format);
        analyticsListener.onAudioInputFormatChanged(eventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(eventTime, 1, format);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDrmSessionAcquired$62(AnalyticsListener.EventTime eventTime, int i11, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmSessionAcquired(eventTime);
        analyticsListener.onDrmSessionAcquired(eventTime, i11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onIsLoadingChanged$32(AnalyticsListener.EventTime eventTime, boolean z11, AnalyticsListener analyticsListener) {
        analyticsListener.onLoadingChanged(eventTime, z11);
        analyticsListener.onIsLoadingChanged(eventTime, z11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onPositionDiscontinuity$43(AnalyticsListener.EventTime eventTime, int i11, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener analyticsListener) {
        analyticsListener.onPositionDiscontinuity(eventTime, i11);
        analyticsListener.onPositionDiscontinuity(eventTime, positionInfo, positionInfo2, i11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onVideoDecoderInitialized$14(AnalyticsListener.EventTime eventTime, String str, long j11, long j12, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j11);
        long j13 = j11;
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j12, j13);
        analyticsListener.onDecoderInitialized(eventTime, 2, str, j13);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onVideoDisabled$18(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDisabled(eventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(eventTime, 2, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onVideoEnabled$13(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoEnabled(eventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(eventTime, 2, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onVideoInputFormatChanged$15(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoInputFormatChanged(eventTime, format);
        analyticsListener.onVideoInputFormatChanged(eventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(eventTime, 2, format);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onVideoSizeChanged$57(AnalyticsListener.EventTime eventTime, VideoSize videoSize, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoSizeChanged(eventTime, videoSize);
        analyticsListener.onVideoSizeChanged(eventTime, videoSize.width, videoSize.height, videoSize.unappliedRotationDegrees, videoSize.pixelWidthHeightRatio);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setPlayer$1(Player player2, AnalyticsListener analyticsListener, FlagSet flagSet) {
        analyticsListener.onEvents(player2, new AnalyticsListener.Events(flagSet, this.eventTimes));
    }

    /* access modifiers changed from: private */
    public void releaseInternal() {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 1028, new b0(generateCurrentPlayerMediaPeriodEventTime));
        this.listeners.release();
    }

    @CallSuper
    public void addListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.listeners.add(analyticsListener);
    }

    public final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod());
    }

    @RequiresNonNull({"player"})
    public final AnalyticsListener.EventTime generateEventTime(Timeline timeline, int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        long j11;
        Timeline timeline2 = timeline;
        int i12 = i11;
        MediaSource.MediaPeriodId mediaPeriodId2 = timeline.isEmpty() ? null : mediaPeriodId;
        long elapsedRealtime = this.clock.elapsedRealtime();
        boolean z11 = true;
        boolean z12 = timeline2.equals(this.player.getCurrentTimeline()) && i12 == this.player.getCurrentMediaItemIndex();
        long j12 = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            if (!(z12 && this.player.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup)) {
                z11 = false;
            }
            if (z11) {
                j12 = this.player.getCurrentPosition();
            }
        } else if (z12) {
            j11 = this.player.getContentPosition();
            return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i11, mediaPeriodId2, j11, this.player.getCurrentTimeline(), this.player.getCurrentMediaItemIndex(), this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
        } else if (!timeline.isEmpty()) {
            j12 = timeline2.getWindow(i12, this.window).getDefaultPositionMs();
        }
        j11 = j12;
        return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i11, mediaPeriodId2, j11, this.player.getCurrentTimeline(), this.player.getCurrentMediaItemIndex(), this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
    }

    public final void notifySeekStarted() {
        if (!this.isSeeking) {
            AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
            this.isSeeking = true;
            sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new s1(generateCurrentPlayerMediaPeriodEventTime));
        }
    }

    public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 20, new e0(generateReadingMediaPeriodEventTime, audioAttributes));
    }

    public final void onAudioCodecError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1029, new z0(generateReadingMediaPeriodEventTime, exc));
    }

    public final void onAudioDecoderInitialized(String str, long j11, long j12) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1008, new p(generateReadingMediaPeriodEventTime, str, j12, j11));
    }

    public final void onAudioDecoderReleased(String str) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1012, new v(generateReadingMediaPeriodEventTime, str));
    }

    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1013, new a1(generatePlayingMediaPeriodEventTime, decoderCounters));
    }

    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1007, new p0(generateReadingMediaPeriodEventTime, decoderCounters));
    }

    public final void onAudioInputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1009, new n0(generateReadingMediaPeriodEventTime, format, decoderReuseEvaluation));
    }

    public final void onAudioPositionAdvancing(long j11) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1010, new w(generateReadingMediaPeriodEventTime, j11));
    }

    public final void onAudioSessionIdChanged(int i11) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 21, new q(generateReadingMediaPeriodEventTime, i11));
    }

    public final void onAudioSinkError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1014, new f0(generateReadingMediaPeriodEventTime, exc));
    }

    public final void onAudioUnderrun(int i11, long j11, long j12) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1011, new i0(generateReadingMediaPeriodEventTime, i11, j11, j12));
    }

    public void onAvailableCommandsChanged(Player.Commands commands) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 13, new r0(generateCurrentPlayerMediaPeriodEventTime, commands));
    }

    public final void onBandwidthSample(int i11, long j11, long j12) {
        AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime = generateLoadingMediaPeriodEventTime();
        sendEvent(generateLoadingMediaPeriodEventTime, 1006, new b1(generateLoadingMediaPeriodEventTime, i11, j11, j12));
    }

    public void onCues(List<Cue> list) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 27, new m1(generateCurrentPlayerMediaPeriodEventTime, list));
    }

    public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 29, new m(generateCurrentPlayerMediaPeriodEventTime, deviceInfo));
    }

    public void onDeviceVolumeChanged(int i11, boolean z11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 30, new h(generateCurrentPlayerMediaPeriodEventTime, i11, z11));
    }

    public final void onDownstreamFormatChanged(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1004, new g0(generateMediaPeriodEventTime, mediaLoadData));
    }

    public final void onDrmKeysLoaded(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1023, new t(generateMediaPeriodEventTime));
    }

    public final void onDrmKeysRemoved(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1026, new d0(generateMediaPeriodEventTime));
    }

    public final void onDrmKeysRestored(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1025, new f1(generateMediaPeriodEventTime));
    }

    public /* synthetic */ void onDrmSessionAcquired(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
        e.d(this, i11, mediaPeriodId);
    }

    public final void onDrmSessionAcquired(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i12) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1022, new d1(generateMediaPeriodEventTime, i12));
    }

    public final void onDrmSessionManagerError(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1024, new j1(generateMediaPeriodEventTime, exc));
    }

    public final void onDrmSessionReleased(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1027, new y(generateMediaPeriodEventTime));
    }

    public final void onDroppedFrames(int i11, long j11) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1018, new l0(generatePlayingMediaPeriodEventTime, i11, j11));
    }

    public void onEvents(Player player2, Player.Events events) {
    }

    public final void onIsLoadingChanged(boolean z11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 3, new g1(generateCurrentPlayerMediaPeriodEventTime, z11));
    }

    public void onIsPlayingChanged(boolean z11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 7, new c0(generateCurrentPlayerMediaPeriodEventTime, z11));
    }

    public final void onLoadCanceled(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1002, new s(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public final void onLoadCompleted(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1001, new o1(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public final void onLoadError(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1003, new x0(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData, iOException, z11));
    }

    public final void onLoadStarted(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1000, new i1(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public void onLoadingChanged(boolean z11) {
    }

    public void onMaxSeekToPreviousPositionChanged(long j11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 18, new r(generateCurrentPlayerMediaPeriodEventTime, j11));
    }

    public final void onMediaItemTransition(@Nullable MediaItem mediaItem, int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 1, new x(generateCurrentPlayerMediaPeriodEventTime, mediaItem, i11));
    }

    public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 14, new p1(generateCurrentPlayerMediaPeriodEventTime, mediaMetadata));
    }

    public final void onMetadata(Metadata metadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 28, new b(generateCurrentPlayerMediaPeriodEventTime, metadata));
    }

    public final void onPlayWhenReadyChanged(boolean z11, int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 5, new u0(generateCurrentPlayerMediaPeriodEventTime, z11, i11));
    }

    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 12, new h1(generateCurrentPlayerMediaPeriodEventTime, playbackParameters));
    }

    public final void onPlaybackStateChanged(int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 4, new e1(generateCurrentPlayerMediaPeriodEventTime, i11));
    }

    public final void onPlaybackSuppressionReasonChanged(int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 6, new j0(generateCurrentPlayerMediaPeriodEventTime, i11));
    }

    public final void onPlayerError(PlaybackException playbackException) {
        AnalyticsListener.EventTime eventTimeForErrorEvent = getEventTimeForErrorEvent(playbackException);
        sendEvent(eventTimeForErrorEvent, 10, new n(eventTimeForErrorEvent, playbackException));
    }

    public void onPlayerErrorChanged(@Nullable PlaybackException playbackException) {
        AnalyticsListener.EventTime eventTimeForErrorEvent = getEventTimeForErrorEvent(playbackException);
        sendEvent(eventTimeForErrorEvent, 10, new h7.e(eventTimeForErrorEvent, playbackException));
    }

    public final void onPlayerStateChanged(boolean z11, int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new k0(generateCurrentPlayerMediaPeriodEventTime, z11, i11));
    }

    public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 15, new v0(generateCurrentPlayerMediaPeriodEventTime, mediaMetadata));
    }

    public void onPositionDiscontinuity(int i11) {
    }

    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) {
        if (i11 == 1) {
            this.isSeeking = false;
        }
        this.mediaPeriodQueueTracker.onPositionDiscontinuity((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 11, new n1(generateCurrentPlayerMediaPeriodEventTime, i11, positionInfo, positionInfo2));
    }

    public void onRenderedFirstFrame() {
    }

    public final void onRenderedFirstFrame(Object obj, long j11) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 26, new i(generateReadingMediaPeriodEventTime, obj, j11));
    }

    public final void onRepeatModeChanged(int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 8, new q0(generateCurrentPlayerMediaPeriodEventTime, i11));
    }

    public void onSeekBackIncrementChanged(long j11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 16, new h0(generateCurrentPlayerMediaPeriodEventTime, j11));
    }

    public void onSeekForwardIncrementChanged(long j11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 17, new l(generateCurrentPlayerMediaPeriodEventTime, j11));
    }

    public final void onSeekProcessed() {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new l1(generateCurrentPlayerMediaPeriodEventTime));
    }

    public final void onShuffleModeEnabledChanged(boolean z11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 9, new g(generateCurrentPlayerMediaPeriodEventTime, z11));
    }

    public final void onSkipSilenceEnabledChanged(boolean z11) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 23, new o(generateReadingMediaPeriodEventTime, z11));
    }

    public final void onSurfaceSizeChanged(int i11, int i12) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 24, new s0(generateReadingMediaPeriodEventTime, i11, i12));
    }

    public final void onTimelineChanged(Timeline timeline, int i11) {
        this.mediaPeriodQueueTracker.onTimelineChanged((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 0, new k1(generateCurrentPlayerMediaPeriodEventTime, i11));
    }

    public void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 19, new c(generateCurrentPlayerMediaPeriodEventTime, trackSelectionParameters));
    }

    public void onTracksChanged(Tracks tracks) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 2, new a0(generateCurrentPlayerMediaPeriodEventTime, tracks));
    }

    public final void onUpstreamDiscarded(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1005, new o0(generateMediaPeriodEventTime, mediaLoadData));
    }

    public final void onVideoCodecError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1030, new q1(generateReadingMediaPeriodEventTime, exc));
    }

    public final void onVideoDecoderInitialized(String str, long j11, long j12) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1016, new d(generateReadingMediaPeriodEventTime, str, j12, j11));
    }

    public final void onVideoDecoderReleased(String str) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1019, new f(generateReadingMediaPeriodEventTime, str));
    }

    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1020, new m0(generatePlayingMediaPeriodEventTime, decoderCounters));
    }

    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1015, new j(generateReadingMediaPeriodEventTime, decoderCounters));
    }

    public final void onVideoFrameProcessingOffset(long j11, int i11) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1021, new r1(generatePlayingMediaPeriodEventTime, j11, i11));
    }

    public final void onVideoInputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1017, new c1(generateReadingMediaPeriodEventTime, format, decoderReuseEvaluation));
    }

    public final void onVideoSizeChanged(VideoSize videoSize) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 25, new z(generateReadingMediaPeriodEventTime, videoSize));
    }

    public final void onVolumeChanged(float f11) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 22, new t0(generateReadingMediaPeriodEventTime, f11));
    }

    @CallSuper
    public void release() {
        ((HandlerWrapper) Assertions.checkStateNotNull(this.handler)).post(new k(this));
    }

    @CallSuper
    public void removeListener(AnalyticsListener analyticsListener) {
        this.listeners.remove(analyticsListener);
    }

    public final void sendEvent(AnalyticsListener.EventTime eventTime, int i11, ListenerSet.Event<AnalyticsListener> event) {
        this.eventTimes.put(i11, eventTime);
        this.listeners.sendEvent(i11, event);
    }

    @CallSuper
    public void setPlayer(Player player2, Looper looper) {
        boolean z11;
        if (this.player == null || this.mediaPeriodQueueTracker.mediaPeriodQueue.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        this.player = (Player) Assertions.checkNotNull(player2);
        this.handler = this.clock.createHandler(looper, (Handler.Callback) null);
        this.listeners = this.listeners.copy(looper, new u(this, player2));
    }

    @Deprecated
    public void setThrowsWhenUsingWrongThread(boolean z11) {
        this.listeners.setThrowsWhenUsingWrongThread(z11);
    }

    public final void updateMediaPeriodQueueInfo(List<MediaSource.MediaPeriodId> list, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onQueueUpdated(list, mediaPeriodId, (Player) Assertions.checkNotNull(this.player));
    }

    public void onCues(CueGroup cueGroup) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 27, new w0(generateCurrentPlayerMediaPeriodEventTime, cueGroup));
    }

    private AnalyticsListener.EventTime generateEventTime(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline;
        Assertions.checkNotNull(this.player);
        if (mediaPeriodId == null) {
            timeline = null;
        } else {
            timeline = this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId);
        }
        if (mediaPeriodId != null && timeline != null) {
            return generateEventTime(timeline, timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, mediaPeriodId);
        }
        int currentMediaItemIndex = this.player.getCurrentMediaItemIndex();
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (!(currentMediaItemIndex < currentTimeline.getWindowCount())) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, currentMediaItemIndex, (MediaSource.MediaPeriodId) null);
    }
}
