package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Method;

final class AudioTrackPositionTracker {
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final long MODE_SWITCH_SMOOTHING_DURATION_US = 1000000;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private static final long RAW_PLAYBACK_HEAD_POSITION_UPDATE_INTERVAL_MS = 5;
    @Nullable
    private AudioTimestampPoller audioTimestampPoller;
    @Nullable
    private AudioTrack audioTrack;
    private float audioTrackPlaybackSpeed;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;
    @Nullable
    private Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastPositionUs;
    private long lastRawPlaybackHeadPositionSampleTimeMs;
    private boolean lastSampleUsedGetTimestampMode;
    private long lastSystemTimeUs;
    private long latencyUs;
    private final Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private boolean notifiedPositionIncreasing;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long previousModePositionUs;
    private long previousModeSystemTimeUs;
    private long rawPlaybackHeadPosition;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    public interface Listener {
        void onInvalidLatency(long j11);

        void onPositionAdvancing(long j11);

        void onPositionFramesMismatch(long j11, long j12, long j13, long j14);

        void onSystemTimeUsMismatch(long j11, long j12, long j13, long j14);

        void onUnderrun(int i11, long j11);
    }

    public AudioTrackPositionTracker(Listener listener2) {
        this.listener = (Listener) Assertions.checkNotNull(listener2);
        if (Util.SDK_INT >= 18) {
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.playheadOffsets = new long[10];
    }

    private boolean forceHasPendingData() {
        if (this.needsPassthroughWorkarounds && ((AudioTrack) Assertions.checkNotNull(this.audioTrack)).getPlayState() == 2 && getPlaybackHeadPosition() == 0) {
            return true;
        }
        return false;
    }

    private long framesToDurationUs(long j11) {
        return (j11 * 1000000) / ((long) this.outputSampleRate);
    }

    private long getPlaybackHeadPosition() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = this.stopTimestampUs;
        if (j11 != C.TIME_UNSET) {
            return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + ((Util.getMediaDurationForPlayoutDuration((elapsedRealtime * 1000) - j11, this.audioTrackPlaybackSpeed) * ((long) this.outputSampleRate)) / 1000000));
        }
        if (elapsedRealtime - this.lastRawPlaybackHeadPositionSampleTimeMs >= 5) {
            updateRawPlaybackHeadPosition(elapsedRealtime);
            this.lastRawPlaybackHeadPositionSampleTimeMs = elapsedRealtime;
        }
        return this.rawPlaybackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
    }

    private long getPlaybackHeadPositionUs() {
        return framesToDurationUs(getPlaybackHeadPosition());
    }

    private void maybePollAndCheckTimestamp(long j11) {
        AudioTimestampPoller audioTimestampPoller2 = (AudioTimestampPoller) Assertions.checkNotNull(this.audioTimestampPoller);
        if (audioTimestampPoller2.maybePollTimestamp(j11)) {
            long timestampSystemTimeUs = audioTimestampPoller2.getTimestampSystemTimeUs();
            long timestampPositionFrames = audioTimestampPoller2.getTimestampPositionFrames();
            long playbackHeadPositionUs = getPlaybackHeadPositionUs();
            if (Math.abs(timestampSystemTimeUs - j11) > 5000000) {
                this.listener.onSystemTimeUsMismatch(timestampPositionFrames, timestampSystemTimeUs, j11, playbackHeadPositionUs);
                audioTimestampPoller2.rejectTimestamp();
            } else if (Math.abs(framesToDurationUs(timestampPositionFrames) - playbackHeadPositionUs) > 5000000) {
                this.listener.onPositionFramesMismatch(timestampPositionFrames, timestampSystemTimeUs, j11, playbackHeadPositionUs);
                audioTimestampPoller2.rejectTimestamp();
            } else {
                audioTimestampPoller2.acceptTimestamp();
            }
        }
    }

    private void maybeSampleSyncParams() {
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.lastPlayheadSampleTimeUs >= 30000) {
            long playbackHeadPositionUs = getPlaybackHeadPositionUs();
            if (playbackHeadPositionUs != 0) {
                this.playheadOffsets[this.nextPlayheadOffsetIndex] = Util.getPlayoutDurationForMediaDuration(playbackHeadPositionUs, this.audioTrackPlaybackSpeed) - nanoTime;
                this.nextPlayheadOffsetIndex = (this.nextPlayheadOffsetIndex + 1) % 10;
                int i11 = this.playheadOffsetCount;
                if (i11 < 10) {
                    this.playheadOffsetCount = i11 + 1;
                }
                this.lastPlayheadSampleTimeUs = nanoTime;
                this.smoothedPlayheadOffsetUs = 0;
                int i12 = 0;
                while (true) {
                    int i13 = this.playheadOffsetCount;
                    if (i12 >= i13) {
                        break;
                    }
                    this.smoothedPlayheadOffsetUs += this.playheadOffsets[i12] / ((long) i13);
                    i12++;
                }
            } else {
                return;
            }
        }
        if (!this.needsPassthroughWorkarounds) {
            maybePollAndCheckTimestamp(nanoTime);
            maybeUpdateLatency(nanoTime);
        }
    }

    private void maybeUpdateLatency(long j11) {
        Method method;
        if (this.isOutputPcm && (method = this.getLatencyMethod) != null && j11 - this.lastLatencySampleTimeUs >= 500000) {
            try {
                long intValue = (((long) ((Integer) Util.castNonNull((Integer) method.invoke(Assertions.checkNotNull(this.audioTrack), new Object[0]))).intValue()) * 1000) - this.bufferSizeUs;
                this.latencyUs = intValue;
                long max = Math.max(intValue, 0);
                this.latencyUs = max;
                if (max > 5000000) {
                    this.listener.onInvalidLatency(max);
                    this.latencyUs = 0;
                }
            } catch (Exception unused) {
                this.getLatencyMethod = null;
            }
            this.lastLatencySampleTimeUs = j11;
        }
    }

    private static boolean needsPassthroughWorkarounds(int i11) {
        return Util.SDK_INT < 23 && (i11 == 5 || i11 == 6);
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0;
        this.lastSystemTimeUs = 0;
        this.previousModeSystemTimeUs = 0;
        this.notifiedPositionIncreasing = false;
    }

    private void updateRawPlaybackHeadPosition(long j11) {
        AudioTrack audioTrack2 = (AudioTrack) Assertions.checkNotNull(this.audioTrack);
        int playState = audioTrack2.getPlayState();
        if (playState != 1) {
            long playbackHeadPosition = ((long) audioTrack2.getPlaybackHeadPosition()) & 4294967295L;
            if (this.needsPassthroughWorkarounds) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.passthroughWorkaroundPauseOffset = this.rawPlaybackHeadPosition;
                }
                playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
            }
            if (Util.SDK_INT <= 29) {
                if (playbackHeadPosition != 0 || this.rawPlaybackHeadPosition <= 0 || playState != 3) {
                    this.forceResetWorkaroundTimeMs = C.TIME_UNSET;
                } else if (this.forceResetWorkaroundTimeMs == C.TIME_UNSET) {
                    this.forceResetWorkaroundTimeMs = j11;
                    return;
                } else {
                    return;
                }
            }
            if (this.rawPlaybackHeadPosition > playbackHeadPosition) {
                this.rawPlaybackHeadWrapCount++;
            }
            this.rawPlaybackHeadPosition = playbackHeadPosition;
        }
    }

    public int getAvailableBufferSize(long j11) {
        return this.bufferSize - ((int) (j11 - (getPlaybackHeadPosition() * ((long) this.outputPcmFrameSize))));
    }

    public long getCurrentPositionUs(boolean z11) {
        long j11;
        if (((AudioTrack) Assertions.checkNotNull(this.audioTrack)).getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long nanoTime = System.nanoTime() / 1000;
        AudioTimestampPoller audioTimestampPoller2 = (AudioTimestampPoller) Assertions.checkNotNull(this.audioTimestampPoller);
        boolean hasAdvancingTimestamp = audioTimestampPoller2.hasAdvancingTimestamp();
        if (hasAdvancingTimestamp) {
            j11 = framesToDurationUs(audioTimestampPoller2.getTimestampPositionFrames()) + Util.getMediaDurationForPlayoutDuration(nanoTime - audioTimestampPoller2.getTimestampSystemTimeUs(), this.audioTrackPlaybackSpeed);
        } else {
            if (this.playheadOffsetCount == 0) {
                j11 = getPlaybackHeadPositionUs();
            } else {
                j11 = Util.getMediaDurationForPlayoutDuration(this.smoothedPlayheadOffsetUs + nanoTime, this.audioTrackPlaybackSpeed);
            }
            if (!z11) {
                j11 = Math.max(0, j11 - this.latencyUs);
            }
        }
        if (this.lastSampleUsedGetTimestampMode != hasAdvancingTimestamp) {
            this.previousModeSystemTimeUs = this.lastSystemTimeUs;
            this.previousModePositionUs = this.lastPositionUs;
        }
        long j12 = nanoTime - this.previousModeSystemTimeUs;
        if (j12 < 1000000) {
            long j13 = (j12 * 1000) / 1000000;
            j11 = ((j11 * j13) + ((1000 - j13) * (this.previousModePositionUs + Util.getMediaDurationForPlayoutDuration(j12, this.audioTrackPlaybackSpeed)))) / 1000;
        }
        if (!this.notifiedPositionIncreasing) {
            long j14 = this.lastPositionUs;
            if (j11 > j14) {
                this.notifiedPositionIncreasing = true;
                this.listener.onPositionAdvancing(System.currentTimeMillis() - Util.usToMs(Util.getPlayoutDurationForMediaDuration(Util.usToMs(j11 - j14), this.audioTrackPlaybackSpeed)));
            }
        }
        this.lastSystemTimeUs = nanoTime;
        this.lastPositionUs = j11;
        this.lastSampleUsedGetTimestampMode = hasAdvancingTimestamp;
        return j11;
    }

    public void handleEndOfStream(long j11) {
        this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
        this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
        this.endPlaybackHeadPosition = j11;
    }

    public boolean hasPendingData(long j11) {
        return j11 > getPlaybackHeadPosition() || forceHasPendingData();
    }

    public boolean isPlaying() {
        return ((AudioTrack) Assertions.checkNotNull(this.audioTrack)).getPlayState() == 3;
    }

    public boolean isStalled(long j11) {
        if (this.forceResetWorkaroundTimeMs == C.TIME_UNSET || j11 <= 0 || SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs < 200) {
            return false;
        }
        return true;
    }

    public boolean mayHandleBuffer(long j11) {
        int playState = ((AudioTrack) Assertions.checkNotNull(this.audioTrack)).getPlayState();
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2) {
                this.hasData = false;
                return false;
            } else if (playState == 1 && getPlaybackHeadPosition() == 0) {
                return false;
            }
        }
        boolean z11 = this.hasData;
        boolean hasPendingData = hasPendingData(j11);
        this.hasData = hasPendingData;
        if (z11 && !hasPendingData && playState != 1) {
            this.listener.onUnderrun(this.bufferSize, Util.usToMs(this.bufferSizeUs));
        }
        return true;
    }

    public boolean pause() {
        resetSyncParams();
        if (this.stopTimestampUs != C.TIME_UNSET) {
            return false;
        }
        ((AudioTimestampPoller) Assertions.checkNotNull(this.audioTimestampPoller)).reset();
        return true;
    }

    public void reset() {
        resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }

    public void setAudioTrack(AudioTrack audioTrack2, boolean z11, int i11, int i12, int i13) {
        boolean z12;
        long j11;
        this.audioTrack = audioTrack2;
        this.outputPcmFrameSize = i12;
        this.bufferSize = i13;
        this.audioTimestampPoller = new AudioTimestampPoller(audioTrack2);
        this.outputSampleRate = audioTrack2.getSampleRate();
        if (!z11 || !needsPassthroughWorkarounds(i11)) {
            z12 = false;
        } else {
            z12 = true;
        }
        this.needsPassthroughWorkarounds = z12;
        boolean isEncodingLinearPcm = Util.isEncodingLinearPcm(i11);
        this.isOutputPcm = isEncodingLinearPcm;
        if (isEncodingLinearPcm) {
            j11 = framesToDurationUs((long) (i13 / i12));
        } else {
            j11 = -9223372036854775807L;
        }
        this.bufferSizeUs = j11;
        this.rawPlaybackHeadPosition = 0;
        this.rawPlaybackHeadWrapCount = 0;
        this.passthroughWorkaroundPauseOffset = 0;
        this.hasData = false;
        this.stopTimestampUs = C.TIME_UNSET;
        this.forceResetWorkaroundTimeMs = C.TIME_UNSET;
        this.lastLatencySampleTimeUs = 0;
        this.latencyUs = 0;
        this.audioTrackPlaybackSpeed = 1.0f;
    }

    public void setAudioTrackPlaybackSpeed(float f11) {
        this.audioTrackPlaybackSpeed = f11;
        AudioTimestampPoller audioTimestampPoller2 = this.audioTimestampPoller;
        if (audioTimestampPoller2 != null) {
            audioTimestampPoller2.reset();
        }
        resetSyncParams();
    }

    public void start() {
        ((AudioTimestampPoller) Assertions.checkNotNull(this.audioTimestampPoller)).reset();
    }
}
