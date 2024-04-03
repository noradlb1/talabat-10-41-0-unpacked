package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.AudioTrackPositionTracker;
import com.google.android.exoplayer2.audio.DefaultAudioTrackBufferSizeProvider;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.InlineMeValidationDisabled;
import i7.o;
import i7.t;
import i7.v;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import y1.a;

public final class DefaultAudioSink implements AudioSink {
    private static final int AUDIO_TRACK_RETRY_DURATION_MS = 100;
    private static final int AUDIO_TRACK_SMALLER_BUFFER_RETRY_SIZE = 1000000;
    public static final float DEFAULT_PLAYBACK_SPEED = 1.0f;
    private static final boolean DEFAULT_SKIP_SILENCE = false;
    private static final int ERROR_NATIVE_DEAD_OBJECT = -32;
    public static final float MAX_PITCH = 8.0f;
    public static final float MAX_PLAYBACK_SPEED = 8.0f;
    public static final float MIN_PITCH = 0.1f;
    public static final float MIN_PLAYBACK_SPEED = 0.1f;
    public static final int OFFLOAD_MODE_DISABLED = 0;
    public static final int OFFLOAD_MODE_ENABLED_GAPLESS_DISABLED = 3;
    public static final int OFFLOAD_MODE_ENABLED_GAPLESS_NOT_REQUIRED = 2;
    public static final int OFFLOAD_MODE_ENABLED_GAPLESS_REQUIRED = 1;
    public static final int OUTPUT_MODE_OFFLOAD = 1;
    public static final int OUTPUT_MODE_PASSTHROUGH = 2;
    public static final int OUTPUT_MODE_PCM = 0;
    private static final String TAG = "DefaultAudioSink";
    public static boolean failOnSpuriousAudioTimestamp = false;
    @GuardedBy("releaseExecutorLock")
    private static int pendingReleaseCount;
    @GuardedBy("releaseExecutorLock")
    @Nullable
    private static ExecutorService releaseExecutor;
    private static final Object releaseExecutorLock = new Object();
    private AudioProcessor[] activeAudioProcessors;
    @Nullable
    private MediaPositionParameters afterDrainParameters;
    private AudioAttributes audioAttributes;
    private final AudioCapabilities audioCapabilities;
    @Nullable
    private final ExoPlayer.AudioOffloadListener audioOffloadListener;
    private final AudioProcessorChain audioProcessorChain;
    private int audioSessionId;
    /* access modifiers changed from: private */
    @Nullable
    public AudioTrack audioTrack;
    private final AudioTrackBufferSizeProvider audioTrackBufferSizeProvider;
    private PlaybackParameters audioTrackPlaybackParameters;
    private final AudioTrackPositionTracker audioTrackPositionTracker;
    private AuxEffectInfo auxEffectInfo;
    @Nullable
    private ByteBuffer avSyncHeader;
    private int bytesUntilNextAvSync;
    private final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    private Configuration configuration;
    private int drainingAudioProcessorIndex;
    private final boolean enableAudioTrackPlaybackParams;
    private final boolean enableFloatOutput;
    private boolean externalAudioSessionIdProvided;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    private final PendingExceptionHolder<AudioSink.InitializationException> initializationExceptionPendingExceptionHolder;
    @Nullable
    private ByteBuffer inputBuffer;
    private int inputBufferAccessUnitCount;
    private boolean isWaitingForOffloadEndOfStreamHandled;
    /* access modifiers changed from: private */
    public long lastFeedElapsedRealtimeMs;
    /* access modifiers changed from: private */
    @Nullable
    public AudioSink.Listener listener;
    private MediaPositionParameters mediaPositionParameters;
    private final ArrayDeque<MediaPositionParameters> mediaPositionParametersCheckpoints;
    private boolean offloadDisabledUntilNextConfiguration;
    private final int offloadMode;
    private StreamEventCallbackV29 offloadStreamEventCallbackV29;
    @Nullable
    private ByteBuffer outputBuffer;
    private ByteBuffer[] outputBuffers;
    @Nullable
    private Configuration pendingConfiguration;
    @Nullable
    private PlayerId playerId;
    /* access modifiers changed from: private */
    public boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;
    @Nullable
    private AudioDeviceInfoApi23 preferredDevice;
    private final ConditionVariable releasingConditionVariable;
    private long startMediaTimeUs;
    private boolean startMediaTimeUsNeedsInit;
    private boolean startMediaTimeUsNeedsSync;
    private boolean stoppedAudioTrack;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final AudioProcessor[] toFloatPcmAvailableAudioProcessors;
    private final AudioProcessor[] toIntPcmAvailableAudioProcessors;
    private final TrimmingAudioProcessor trimmingAudioProcessor;
    private boolean tunneling;
    private float volume;
    private final PendingExceptionHolder<AudioSink.WriteException> writeExceptionPendingExceptionHolder;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    @RequiresApi(23)
    public static final class Api23 {
        private Api23() {
        }

        @DoNotInline
        public static void setPreferredDeviceOnAudioTrack(AudioTrack audioTrack, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            AudioDeviceInfo audioDeviceInfo;
            if (audioDeviceInfoApi23 == null) {
                audioDeviceInfo = null;
            } else {
                audioDeviceInfo = audioDeviceInfoApi23.audioDeviceInfo;
            }
            audioTrack.setPreferredDevice(audioDeviceInfo);
        }
    }

    @RequiresApi(31)
    public static final class Api31 {
        private Api31() {
        }

        @DoNotInline
        public static void setLogSessionIdOnAudioTrack(AudioTrack audioTrack, PlayerId playerId) {
            LogSessionId logSessionId = playerId.getLogSessionId();
            if (!logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                audioTrack.setLogSessionId(logSessionId);
            }
        }
    }

    @RequiresApi(23)
    public static final class AudioDeviceInfoApi23 {
        public final AudioDeviceInfo audioDeviceInfo;

        public AudioDeviceInfoApi23(AudioDeviceInfo audioDeviceInfo2) {
            this.audioDeviceInfo = audioDeviceInfo2;
        }
    }

    @Deprecated
    public interface AudioProcessorChain extends AudioProcessorChain {
    }

    public interface AudioTrackBufferSizeProvider {
        public static final AudioTrackBufferSizeProvider DEFAULT = new DefaultAudioTrackBufferSizeProvider.Builder().build();

        int getBufferSizeInBytes(int i11, int i12, int i13, int i14, int i15, int i16, double d11);
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public AudioCapabilities audioCapabilities = AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES;
        @Nullable
        ExoPlayer.AudioOffloadListener audioOffloadListener;
        /* access modifiers changed from: private */
        @Nullable
        public AudioProcessorChain audioProcessorChain;
        AudioTrackBufferSizeProvider audioTrackBufferSizeProvider = AudioTrackBufferSizeProvider.DEFAULT;
        /* access modifiers changed from: private */
        public boolean enableAudioTrackPlaybackParams;
        /* access modifiers changed from: private */
        public boolean enableFloatOutput;
        /* access modifiers changed from: private */
        public int offloadMode = 0;

        public DefaultAudioSink build() {
            if (this.audioProcessorChain == null) {
                this.audioProcessorChain = new DefaultAudioProcessorChain(new AudioProcessor[0]);
            }
            return new DefaultAudioSink(this);
        }

        @CanIgnoreReturnValue
        public Builder setAudioCapabilities(AudioCapabilities audioCapabilities2) {
            Assertions.checkNotNull(audioCapabilities2);
            this.audioCapabilities = audioCapabilities2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setAudioProcessorChain(AudioProcessorChain audioProcessorChain2) {
            Assertions.checkNotNull(audioProcessorChain2);
            this.audioProcessorChain = audioProcessorChain2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setAudioProcessors(AudioProcessor[] audioProcessorArr) {
            Assertions.checkNotNull(audioProcessorArr);
            return setAudioProcessorChain(new DefaultAudioProcessorChain(audioProcessorArr));
        }

        @CanIgnoreReturnValue
        public Builder setAudioTrackBufferSizeProvider(AudioTrackBufferSizeProvider audioTrackBufferSizeProvider2) {
            this.audioTrackBufferSizeProvider = audioTrackBufferSizeProvider2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setEnableAudioTrackPlaybackParams(boolean z11) {
            this.enableAudioTrackPlaybackParams = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setEnableFloatOutput(boolean z11) {
            this.enableFloatOutput = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setExperimentalAudioOffloadListener(@Nullable ExoPlayer.AudioOffloadListener audioOffloadListener2) {
            this.audioOffloadListener = audioOffloadListener2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setOffloadMode(int i11) {
            this.offloadMode = i11;
            return this;
        }
    }

    public static final class Configuration {
        public final AudioProcessor[] availableAudioProcessors;
        public final int bufferSize;
        public final Format inputFormat;
        public final int inputPcmFrameSize;
        public final int outputChannelConfig;
        public final int outputEncoding;
        public final int outputMode;
        public final int outputPcmFrameSize;
        public final int outputSampleRate;

        public Configuration(Format format, int i11, int i12, int i13, int i14, int i15, int i16, int i17, AudioProcessor[] audioProcessorArr) {
            this.inputFormat = format;
            this.inputPcmFrameSize = i11;
            this.outputMode = i12;
            this.outputPcmFrameSize = i13;
            this.outputSampleRate = i14;
            this.outputChannelConfig = i15;
            this.outputEncoding = i16;
            this.bufferSize = i17;
            this.availableAudioProcessors = audioProcessorArr;
        }

        private AudioTrack createAudioTrack(boolean z11, AudioAttributes audioAttributes, int i11) {
            int i12 = Util.SDK_INT;
            if (i12 >= 29) {
                return createAudioTrackV29(z11, audioAttributes, i11);
            }
            if (i12 >= 21) {
                return createAudioTrackV21(z11, audioAttributes, i11);
            }
            return createAudioTrackV9(audioAttributes, i11);
        }

        @RequiresApi(21)
        private AudioTrack createAudioTrackV21(boolean z11, AudioAttributes audioAttributes, int i11) {
            return new AudioTrack(getAudioTrackAttributesV21(audioAttributes, z11), DefaultAudioSink.getAudioFormat(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding), this.bufferSize, 1, i11);
        }

        @RequiresApi(29)
        private AudioTrack createAudioTrackV29(boolean z11, AudioAttributes audioAttributes, int i11) {
            AudioFormat access$1500 = DefaultAudioSink.getAudioFormat(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding);
            AudioAttributes audioTrackAttributesV21 = getAudioTrackAttributesV21(audioAttributes, z11);
            boolean z12 = true;
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(audioTrackAttributesV21).setAudioFormat(access$1500).setTransferMode(1).setBufferSizeInBytes(this.bufferSize).setSessionId(i11);
            if (this.outputMode != 1) {
                z12 = false;
            }
            return sessionId.setOffloadedPlayback(z12).build();
        }

        private AudioTrack createAudioTrackV9(AudioAttributes audioAttributes, int i11) {
            int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(audioAttributes.usage);
            if (i11 == 0) {
                return new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1);
            }
            return new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1, i11);
        }

        @RequiresApi(21)
        private static AudioAttributes getAudioTrackAttributesV21(AudioAttributes audioAttributes, boolean z11) {
            if (z11) {
                return getAudioTrackTunnelingAttributesV21();
            }
            return audioAttributes.getAudioAttributesV21().audioAttributes;
        }

        @RequiresApi(21)
        private static AudioAttributes getAudioTrackTunnelingAttributesV21() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack buildAudioTrack(boolean z11, AudioAttributes audioAttributes, int i11) throws AudioSink.InitializationException {
            try {
                AudioTrack createAudioTrack = createAudioTrack(z11, audioAttributes, i11);
                int state = createAudioTrack.getState();
                if (state == 1) {
                    return createAudioTrack;
                }
                try {
                    createAudioTrack.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.outputSampleRate, this.outputChannelConfig, this.bufferSize, this.inputFormat, outputModeIsOffload(), (Exception) null);
            } catch (IllegalArgumentException | UnsupportedOperationException e11) {
                throw new AudioSink.InitializationException(0, this.outputSampleRate, this.outputChannelConfig, this.bufferSize, this.inputFormat, outputModeIsOffload(), e11);
            }
        }

        public boolean canReuseAudioTrack(Configuration configuration) {
            return configuration.outputMode == this.outputMode && configuration.outputEncoding == this.outputEncoding && configuration.outputSampleRate == this.outputSampleRate && configuration.outputChannelConfig == this.outputChannelConfig && configuration.outputPcmFrameSize == this.outputPcmFrameSize;
        }

        public Configuration copyWithBufferSize(int i11) {
            return new Configuration(this.inputFormat, this.inputPcmFrameSize, this.outputMode, this.outputPcmFrameSize, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, i11, this.availableAudioProcessors);
        }

        public long framesToDurationUs(long j11) {
            return (j11 * 1000000) / ((long) this.outputSampleRate);
        }

        public long inputFramesToDurationUs(long j11) {
            return (j11 * 1000000) / ((long) this.inputFormat.sampleRate);
        }

        public boolean outputModeIsOffload() {
            return this.outputMode == 1;
        }
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {
        private final AudioProcessor[] audioProcessors;
        private final SilenceSkippingAudioProcessor silenceSkippingAudioProcessor;
        private final SonicAudioProcessor sonicAudioProcessor;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new SilenceSkippingAudioProcessor(), new SonicAudioProcessor());
        }

        public PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters) {
            this.sonicAudioProcessor.setSpeed(playbackParameters.speed);
            this.sonicAudioProcessor.setPitch(playbackParameters.pitch);
            return playbackParameters;
        }

        public boolean applySkipSilenceEnabled(boolean z11) {
            this.silenceSkippingAudioProcessor.setEnabled(z11);
            return z11;
        }

        public AudioProcessor[] getAudioProcessors() {
            return this.audioProcessors;
        }

        public long getMediaDuration(long j11) {
            return this.sonicAudioProcessor.getMediaDuration(j11);
        }

        public long getSkippedOutputFrameCount() {
            return this.silenceSkippingAudioProcessor.getSkippedFrames();
        }

        public DefaultAudioProcessorChain(AudioProcessor[] audioProcessorArr, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor2, SonicAudioProcessor sonicAudioProcessor2) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[(audioProcessorArr.length + 2)];
            this.audioProcessors = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.silenceSkippingAudioProcessor = silenceSkippingAudioProcessor2;
            this.sonicAudioProcessor = sonicAudioProcessor2;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor2;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor2;
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public static final class MediaPositionParameters {
        public final long audioTrackPositionUs;
        public final long mediaTimeUs;
        public final PlaybackParameters playbackParameters;
        public final boolean skipSilence;

        private MediaPositionParameters(PlaybackParameters playbackParameters2, boolean z11, long j11, long j12) {
            this.playbackParameters = playbackParameters2;
            this.skipSilence = z11;
            this.mediaTimeUs = j11;
            this.audioTrackPositionUs = j12;
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffloadMode {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputMode {
    }

    public static final class PendingExceptionHolder<T extends Exception> {
        @Nullable
        private T pendingException;
        private long throwDeadlineMs;
        private final long throwDelayMs;

        public PendingExceptionHolder(long j11) {
            this.throwDelayMs = j11;
        }

        public void clear() {
            this.pendingException = null;
        }

        public void throwExceptionIfDeadlineIsReached(T t11) throws Exception {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.pendingException == null) {
                this.pendingException = t11;
                this.throwDeadlineMs = this.throwDelayMs + elapsedRealtime;
            }
            if (elapsedRealtime >= this.throwDeadlineMs) {
                T t12 = this.pendingException;
                if (t12 != t11) {
                    t12.addSuppressed(t11);
                }
                T t13 = this.pendingException;
                clear();
                throw t13;
            }
        }
    }

    public final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        public void onInvalidLatency(long j11) {
            Log.w(DefaultAudioSink.TAG, "Ignoring impossibly large audio latency: " + j11);
        }

        public void onPositionAdvancing(long j11) {
            if (DefaultAudioSink.this.listener != null) {
                DefaultAudioSink.this.listener.onPositionAdvancing(j11);
            }
        }

        public void onPositionFramesMismatch(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + j12 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + j13 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + j14 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + DefaultAudioSink.this.getSubmittedFrames() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + DefaultAudioSink.this.getWrittenFrames();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w(DefaultAudioSink.TAG, str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }

        public void onSystemTimeUsMismatch(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + j12 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + j13 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + j14 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + DefaultAudioSink.this.getSubmittedFrames() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + DefaultAudioSink.this.getWrittenFrames();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w(DefaultAudioSink.TAG, str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }

        public void onUnderrun(int i11, long j11) {
            if (DefaultAudioSink.this.listener != null) {
                DefaultAudioSink.this.listener.onUnderrun(i11, j11, SystemClock.elapsedRealtime() - DefaultAudioSink.this.lastFeedElapsedRealtimeMs);
            }
        }
    }

    @RequiresApi(29)
    public final class StreamEventCallbackV29 {
        private final AudioTrack.StreamEventCallback callback;
        private final Handler handler = new Handler(Looper.myLooper());

        public StreamEventCallbackV29() {
            this.callback = new AudioTrack.StreamEventCallback(DefaultAudioSink.this) {
                public void onDataRequest(AudioTrack audioTrack, int i11) {
                    if (audioTrack.equals(DefaultAudioSink.this.audioTrack) && DefaultAudioSink.this.listener != null && DefaultAudioSink.this.playing) {
                        DefaultAudioSink.this.listener.onOffloadBufferEmptying();
                    }
                }

                public void onTearDown(AudioTrack audioTrack) {
                    if (audioTrack.equals(DefaultAudioSink.this.audioTrack) && DefaultAudioSink.this.listener != null && DefaultAudioSink.this.playing) {
                        DefaultAudioSink.this.listener.onOffloadBufferEmptying();
                    }
                }
            };
        }

        public void register(AudioTrack audioTrack) {
            Handler handler2 = this.handler;
            Objects.requireNonNull(handler2);
            audioTrack.registerStreamEventCallback(new a(handler2), this.callback);
        }

        public void unregister(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.callback);
            this.handler.removeCallbacksAndMessages((Object) null);
        }
    }

    private void applyAudioProcessorPlaybackParametersAndSkipSilence(long j11) {
        PlaybackParameters playbackParameters;
        boolean z11;
        if (shouldApplyAudioProcessorPlaybackParameters()) {
            playbackParameters = this.audioProcessorChain.applyPlaybackParameters(getAudioProcessorPlaybackParameters());
        } else {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        PlaybackParameters playbackParameters2 = playbackParameters;
        if (shouldApplyAudioProcessorPlaybackParameters()) {
            z11 = this.audioProcessorChain.applySkipSilenceEnabled(getSkipSilenceEnabled());
        } else {
            z11 = false;
        }
        this.mediaPositionParametersCheckpoints.add(new MediaPositionParameters(playbackParameters2, z11, Math.max(0, j11), this.configuration.framesToDurationUs(getWrittenFrames())));
        setupAudioProcessors();
        AudioSink.Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onSkipSilenceEnabledChanged(z11);
        }
    }

    private long applyMediaPositionParameters(long j11) {
        while (!this.mediaPositionParametersCheckpoints.isEmpty() && j11 >= this.mediaPositionParametersCheckpoints.getFirst().audioTrackPositionUs) {
            this.mediaPositionParameters = this.mediaPositionParametersCheckpoints.remove();
        }
        MediaPositionParameters mediaPositionParameters2 = this.mediaPositionParameters;
        long j12 = j11 - mediaPositionParameters2.audioTrackPositionUs;
        if (mediaPositionParameters2.playbackParameters.equals(PlaybackParameters.DEFAULT)) {
            return this.mediaPositionParameters.mediaTimeUs + j12;
        }
        if (this.mediaPositionParametersCheckpoints.isEmpty()) {
            return this.mediaPositionParameters.mediaTimeUs + this.audioProcessorChain.getMediaDuration(j12);
        }
        MediaPositionParameters first = this.mediaPositionParametersCheckpoints.getFirst();
        return first.mediaTimeUs - Util.getMediaDurationForPlayoutDuration(first.audioTrackPositionUs - j11, this.mediaPositionParameters.playbackParameters.speed);
    }

    private long applySkipping(long j11) {
        return j11 + this.configuration.framesToDurationUs(this.audioProcessorChain.getSkippedOutputFrameCount());
    }

    private AudioTrack buildAudioTrack(Configuration configuration2) throws AudioSink.InitializationException {
        try {
            AudioTrack buildAudioTrack = configuration2.buildAudioTrack(this.tunneling, this.audioAttributes, this.audioSessionId);
            ExoPlayer.AudioOffloadListener audioOffloadListener2 = this.audioOffloadListener;
            if (audioOffloadListener2 != null) {
                audioOffloadListener2.onExperimentalOffloadedPlayback(isOffloadedPlayback(buildAudioTrack));
            }
            return buildAudioTrack;
        } catch (AudioSink.InitializationException e11) {
            AudioSink.Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onAudioSinkError(e11);
            }
            throw e11;
        }
    }

    private AudioTrack buildAudioTrackWithRetry() throws AudioSink.InitializationException {
        try {
            return buildAudioTrack((Configuration) Assertions.checkNotNull(this.configuration));
        } catch (AudioSink.InitializationException e11) {
            Configuration configuration2 = this.configuration;
            if (configuration2.bufferSize > 1000000) {
                Configuration copyWithBufferSize = configuration2.copyWithBufferSize(1000000);
                try {
                    AudioTrack buildAudioTrack = buildAudioTrack(copyWithBufferSize);
                    this.configuration = copyWithBufferSize;
                    return buildAudioTrack;
                } catch (AudioSink.InitializationException e12) {
                    e11.addSuppressed(e12);
                    maybeDisableOffload();
                    throw e11;
                }
            }
            maybeDisableOffload();
            throw e11;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean drainToEndOfStream() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.drainingAudioProcessorIndex
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L_0x000b
            r9.drainingAudioProcessorIndex = r2
        L_0x0009:
            r0 = r1
            goto L_0x000c
        L_0x000b:
            r0 = r2
        L_0x000c:
            int r4 = r9.drainingAudioProcessorIndex
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.activeAudioProcessors
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x002f
            r4 = r5[r4]
            if (r0 == 0) goto L_0x001f
            r4.queueEndOfStream()
        L_0x001f:
            r9.processBuffers(r7)
            boolean r0 = r4.isEnded()
            if (r0 != 0) goto L_0x0029
            return r2
        L_0x0029:
            int r0 = r9.drainingAudioProcessorIndex
            int r0 = r0 + r1
            r9.drainingAudioProcessorIndex = r0
            goto L_0x0009
        L_0x002f:
            java.nio.ByteBuffer r0 = r9.outputBuffer
            if (r0 == 0) goto L_0x003b
            r9.writeBuffer(r0, r7)
            java.nio.ByteBuffer r0 = r9.outputBuffer
            if (r0 == 0) goto L_0x003b
            return r2
        L_0x003b:
            r9.drainingAudioProcessorIndex = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.drainToEndOfStream():boolean");
    }

    private void flushAudioProcessors() {
        int i11 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.activeAudioProcessors;
            if (i11 < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i11];
                audioProcessor.flush();
                this.outputBuffers[i11] = audioProcessor.getOutput();
                i11++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    @RequiresApi(21)
    public static AudioFormat getAudioFormat(int i11, int i12, int i13) {
        return new AudioFormat.Builder().setSampleRate(i11).setChannelMask(i12).setEncoding(i13).build();
    }

    private PlaybackParameters getAudioProcessorPlaybackParameters() {
        return getMediaPositionParameters().playbackParameters;
    }

    private static int getAudioTrackMinBufferSize(int i11, int i12, int i13) {
        boolean z11;
        int minBufferSize = AudioTrack.getMinBufferSize(i11, i12, i13);
        if (minBufferSize != -2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        return minBufferSize;
    }

    private static int getFramesPerEncodedSample(int i11, ByteBuffer byteBuffer) {
        switch (i11) {
            case 5:
            case 6:
            case 18:
                return Ac3Util.parseAc3SyncframeAudioSampleCount(byteBuffer);
            case 7:
            case 8:
                return DtsUtil.parseDtsAudioSampleCount(byteBuffer);
            case 9:
                int parseMpegAudioFrameSampleCount = MpegAudioUtil.parseMpegAudioFrameSampleCount(Util.getBigEndianInt(byteBuffer, byteBuffer.position()));
                if (parseMpegAudioFrameSampleCount != -1) {
                    return parseMpegAudioFrameSampleCount;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 14:
                int findTrueHdSyncframeOffset = Ac3Util.findTrueHdSyncframeOffset(byteBuffer);
                if (findTrueHdSyncframeOffset == -1) {
                    return 0;
                }
                return Ac3Util.parseTrueHdSyncframeAudioSampleCount(byteBuffer, findTrueHdSyncframeOffset) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return Ac4Util.parseAc4SyncframeAudioSampleCount(byteBuffer);
            case 20:
                return OpusUtil.parsePacketAudioSampleCount(byteBuffer);
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i11);
        }
    }

    private MediaPositionParameters getMediaPositionParameters() {
        MediaPositionParameters mediaPositionParameters2 = this.afterDrainParameters;
        if (mediaPositionParameters2 != null) {
            return mediaPositionParameters2;
        }
        if (!this.mediaPositionParametersCheckpoints.isEmpty()) {
            return this.mediaPositionParametersCheckpoints.getLast();
        }
        return this.mediaPositionParameters;
    }

    @RequiresApi(29)
    @SuppressLint({"InlinedApi"})
    private int getOffloadedPlaybackSupport(AudioFormat audioFormat, AudioAttributes audioAttributes2) {
        int i11 = Util.SDK_INT;
        if (i11 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes2);
        }
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes2)) {
            return 0;
        }
        if (i11 != 30 || !Util.MODEL.startsWith("Pixel")) {
            return 1;
        }
        return 2;
    }

    /* access modifiers changed from: private */
    public long getSubmittedFrames() {
        Configuration configuration2 = this.configuration;
        if (configuration2.outputMode == 0) {
            return this.submittedPcmBytes / ((long) configuration2.inputPcmFrameSize);
        }
        return this.submittedEncodedFrames;
    }

    /* access modifiers changed from: private */
    public long getWrittenFrames() {
        Configuration configuration2 = this.configuration;
        if (configuration2.outputMode == 0) {
            return this.writtenPcmBytes / ((long) configuration2.outputPcmFrameSize);
        }
        return this.writtenEncodedFrames;
    }

    private boolean initializeAudioTrack() throws AudioSink.InitializationException {
        boolean z11;
        PlayerId playerId2;
        if (!this.releasingConditionVariable.isOpen()) {
            return false;
        }
        AudioTrack buildAudioTrackWithRetry = buildAudioTrackWithRetry();
        this.audioTrack = buildAudioTrackWithRetry;
        if (isOffloadedPlayback(buildAudioTrackWithRetry)) {
            registerStreamEventCallbackV29(this.audioTrack);
            if (this.offloadMode != 3) {
                AudioTrack audioTrack2 = this.audioTrack;
                Format format = this.configuration.inputFormat;
                audioTrack2.setOffloadDelayPadding(format.encoderDelay, format.encoderPadding);
            }
        }
        int i11 = Util.SDK_INT;
        if (i11 >= 31 && (playerId2 = this.playerId) != null) {
            Api31.setLogSessionIdOnAudioTrack(this.audioTrack, playerId2);
        }
        this.audioSessionId = this.audioTrack.getAudioSessionId();
        AudioTrackPositionTracker audioTrackPositionTracker2 = this.audioTrackPositionTracker;
        AudioTrack audioTrack3 = this.audioTrack;
        Configuration configuration2 = this.configuration;
        if (configuration2.outputMode == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        audioTrackPositionTracker2.setAudioTrack(audioTrack3, z11, configuration2.outputEncoding, configuration2.outputPcmFrameSize, configuration2.bufferSize);
        setVolumeInternal();
        int i12 = this.auxEffectInfo.effectId;
        if (i12 != 0) {
            this.audioTrack.attachAuxEffect(i12);
            this.audioTrack.setAuxEffectSendLevel(this.auxEffectInfo.sendLevel);
        }
        AudioDeviceInfoApi23 audioDeviceInfoApi23 = this.preferredDevice;
        if (audioDeviceInfoApi23 != null && i11 >= 23) {
            Api23.setPreferredDeviceOnAudioTrack(this.audioTrack, audioDeviceInfoApi23);
        }
        this.startMediaTimeUsNeedsInit = true;
        return true;
    }

    private static boolean isAudioTrackDeadObject(int i11) {
        return (Util.SDK_INT >= 24 && i11 == -6) || i11 == ERROR_NATIVE_DEAD_OBJECT;
    }

    private boolean isAudioTrackInitialized() {
        return this.audioTrack != null;
    }

    private static boolean isOffloadedPlayback(AudioTrack audioTrack2) {
        return Util.SDK_INT >= 29 && t.a(audioTrack2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$releaseAudioTrackAsync$0(AudioTrack audioTrack2, ConditionVariable conditionVariable) {
        try {
            audioTrack2.flush();
            audioTrack2.release();
            conditionVariable.open();
            synchronized (releaseExecutorLock) {
                int i11 = pendingReleaseCount - 1;
                pendingReleaseCount = i11;
                if (i11 == 0) {
                    releaseExecutor.shutdown();
                    releaseExecutor = null;
                }
            }
        } catch (Throwable th2) {
            conditionVariable.open();
            synchronized (releaseExecutorLock) {
                int i12 = pendingReleaseCount - 1;
                pendingReleaseCount = i12;
                if (i12 == 0) {
                    releaseExecutor.shutdown();
                    releaseExecutor = null;
                }
                throw th2;
            }
        }
    }

    private void maybeDisableOffload() {
        if (this.configuration.outputModeIsOffload()) {
            this.offloadDisabledUntilNextConfiguration = true;
        }
    }

    private void playPendingData() {
        if (!this.stoppedAudioTrack) {
            this.stoppedAudioTrack = true;
            this.audioTrackPositionTracker.handleEndOfStream(getWrittenFrames());
            this.audioTrack.stop();
            this.bytesUntilNextAvSync = 0;
        }
    }

    private void processBuffers(long j11) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.activeAudioProcessors.length;
        int i11 = length;
        while (i11 >= 0) {
            if (i11 > 0) {
                byteBuffer = this.outputBuffers[i11 - 1];
            } else {
                byteBuffer = this.inputBuffer;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i11 == length) {
                writeBuffer(byteBuffer, j11);
            } else {
                AudioProcessor audioProcessor = this.activeAudioProcessors[i11];
                if (i11 > this.drainingAudioProcessorIndex) {
                    audioProcessor.queueInput(byteBuffer);
                }
                ByteBuffer output = audioProcessor.getOutput();
                this.outputBuffers[i11] = output;
                if (output.hasRemaining()) {
                    i11++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i11--;
            } else {
                return;
            }
        }
    }

    @RequiresApi(29)
    private void registerStreamEventCallbackV29(AudioTrack audioTrack2) {
        if (this.offloadStreamEventCallbackV29 == null) {
            this.offloadStreamEventCallbackV29 = new StreamEventCallbackV29();
        }
        this.offloadStreamEventCallbackV29.register(audioTrack2);
    }

    private static void releaseAudioTrackAsync(AudioTrack audioTrack2, ConditionVariable conditionVariable) {
        conditionVariable.close();
        synchronized (releaseExecutorLock) {
            if (releaseExecutor == null) {
                releaseExecutor = Util.newSingleThreadExecutor("ExoPlayer:AudioTrackReleaseThread");
            }
            pendingReleaseCount++;
            releaseExecutor.execute(new v(audioTrack2, conditionVariable));
        }
    }

    private void resetSinkStateForFlush() {
        this.submittedPcmBytes = 0;
        this.submittedEncodedFrames = 0;
        this.writtenPcmBytes = 0;
        this.writtenEncodedFrames = 0;
        this.isWaitingForOffloadEndOfStreamHandled = false;
        this.framesPerEncodedSample = 0;
        this.mediaPositionParameters = new MediaPositionParameters(getAudioProcessorPlaybackParameters(), getSkipSilenceEnabled(), 0, 0);
        this.startMediaTimeUs = 0;
        this.afterDrainParameters = null;
        this.mediaPositionParametersCheckpoints.clear();
        this.inputBuffer = null;
        this.inputBufferAccessUnitCount = 0;
        this.outputBuffer = null;
        this.stoppedAudioTrack = false;
        this.handledEndOfStream = false;
        this.drainingAudioProcessorIndex = -1;
        this.avSyncHeader = null;
        this.bytesUntilNextAvSync = 0;
        this.trimmingAudioProcessor.resetTrimmedFrameCount();
        flushAudioProcessors();
    }

    private void setAudioProcessorPlaybackParametersAndSkipSilence(PlaybackParameters playbackParameters, boolean z11) {
        MediaPositionParameters mediaPositionParameters2 = getMediaPositionParameters();
        if (!playbackParameters.equals(mediaPositionParameters2.playbackParameters) || z11 != mediaPositionParameters2.skipSilence) {
            MediaPositionParameters mediaPositionParameters3 = new MediaPositionParameters(playbackParameters, z11, C.TIME_UNSET, C.TIME_UNSET);
            if (isAudioTrackInitialized()) {
                this.afterDrainParameters = mediaPositionParameters3;
            } else {
                this.mediaPositionParameters = mediaPositionParameters3;
            }
        }
    }

    @RequiresApi(23)
    private void setAudioTrackPlaybackParametersV23(PlaybackParameters playbackParameters) {
        if (isAudioTrackInitialized()) {
            try {
                this.audioTrack.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(playbackParameters.speed).setPitch(playbackParameters.pitch).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e11) {
                Log.w(TAG, "Failed to set playback params", e11);
            }
            playbackParameters = new PlaybackParameters(this.audioTrack.getPlaybackParams().getSpeed(), this.audioTrack.getPlaybackParams().getPitch());
            this.audioTrackPositionTracker.setAudioTrackPlaybackSpeed(playbackParameters.speed);
        }
        this.audioTrackPlaybackParameters = playbackParameters;
    }

    private void setVolumeInternal() {
        if (isAudioTrackInitialized()) {
            if (Util.SDK_INT >= 21) {
                setVolumeInternalV21(this.audioTrack, this.volume);
            } else {
                setVolumeInternalV3(this.audioTrack, this.volume);
            }
        }
    }

    @RequiresApi(21)
    private static void setVolumeInternalV21(AudioTrack audioTrack2, float f11) {
        audioTrack2.setVolume(f11);
    }

    private static void setVolumeInternalV3(AudioTrack audioTrack2, float f11) {
        audioTrack2.setStereoVolume(f11, f11);
    }

    private void setupAudioProcessors() {
        AudioProcessor[] audioProcessorArr = this.configuration.availableAudioProcessors;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.activeAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.outputBuffers = new ByteBuffer[size];
        flushAudioProcessors();
    }

    private boolean shouldApplyAudioProcessorPlaybackParameters() {
        if (this.tunneling || !MimeTypes.AUDIO_RAW.equals(this.configuration.inputFormat.sampleMimeType) || shouldUseFloatOutput(this.configuration.inputFormat.pcmEncoding)) {
            return false;
        }
        return true;
    }

    private boolean shouldUseFloatOutput(int i11) {
        return this.enableFloatOutput && Util.isEncodingHighResolutionPcm(i11);
    }

    private boolean useOffloadedPlayback(Format format, AudioAttributes audioAttributes2) {
        int encoding;
        int audioTrackChannelConfig;
        int offloadedPlaybackSupport;
        boolean z11;
        boolean z12;
        if (Util.SDK_INT < 29 || this.offloadMode == 0 || (encoding = MimeTypes.getEncoding((String) Assertions.checkNotNull(format.sampleMimeType), format.codecs)) == 0 || (audioTrackChannelConfig = Util.getAudioTrackChannelConfig(format.channelCount)) == 0 || (offloadedPlaybackSupport = getOffloadedPlaybackSupport(getAudioFormat(format.sampleRate, audioTrackChannelConfig, encoding), audioAttributes2.getAudioAttributesV21().audioAttributes)) == 0) {
            return false;
        }
        if (offloadedPlaybackSupport == 1) {
            if (format.encoderDelay == 0 && format.encoderPadding == 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (this.offloadMode == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z11 || !z12) {
                return true;
            }
            return false;
        } else if (offloadedPlaybackSupport == 2) {
            return true;
        } else {
            throw new IllegalStateException();
        }
    }

    private void writeBuffer(ByteBuffer byteBuffer, long j11) throws AudioSink.WriteException {
        int i11;
        AudioSink.Listener listener2;
        boolean z11;
        boolean z12;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.outputBuffer;
            boolean z13 = true;
            if (byteBuffer2 != null) {
                if (byteBuffer2 == byteBuffer) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                Assertions.checkArgument(z12);
            } else {
                this.outputBuffer = byteBuffer;
                if (Util.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.preV21OutputBuffer;
                    if (bArr == null || bArr.length < remaining) {
                        this.preV21OutputBuffer = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.preV21OutputBuffer, 0, remaining);
                    byteBuffer.position(position);
                    this.preV21OutputBufferOffset = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (Util.SDK_INT < 21) {
                int availableBufferSize = this.audioTrackPositionTracker.getAvailableBufferSize(this.writtenPcmBytes);
                if (availableBufferSize > 0) {
                    i11 = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, Math.min(remaining2, availableBufferSize));
                    if (i11 > 0) {
                        this.preV21OutputBufferOffset += i11;
                        byteBuffer.position(byteBuffer.position() + i11);
                    }
                } else {
                    i11 = 0;
                }
            } else if (this.tunneling) {
                if (j11 != C.TIME_UNSET) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Assertions.checkState(z11);
                i11 = writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer, remaining2, j11);
            } else {
                i11 = writeNonBlockingV21(this.audioTrack, byteBuffer, remaining2);
            }
            this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
            if (i11 < 0) {
                if (!isAudioTrackDeadObject(i11) || this.writtenEncodedFrames <= 0) {
                    z13 = false;
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(i11, this.configuration.inputFormat, z13);
                AudioSink.Listener listener3 = this.listener;
                if (listener3 != null) {
                    listener3.onAudioSinkError(writeException);
                }
                if (!writeException.isRecoverable) {
                    this.writeExceptionPendingExceptionHolder.throwExceptionIfDeadlineIsReached(writeException);
                    return;
                }
                throw writeException;
            }
            this.writeExceptionPendingExceptionHolder.clear();
            if (isOffloadedPlayback(this.audioTrack)) {
                if (this.writtenEncodedFrames > 0) {
                    this.isWaitingForOffloadEndOfStreamHandled = false;
                }
                if (this.playing && (listener2 = this.listener) != null && i11 < remaining2 && !this.isWaitingForOffloadEndOfStreamHandled) {
                    listener2.onOffloadBufferFull();
                }
            }
            int i12 = this.configuration.outputMode;
            if (i12 == 0) {
                this.writtenPcmBytes += (long) i11;
            }
            if (i11 == remaining2) {
                if (i12 != 0) {
                    if (byteBuffer != this.inputBuffer) {
                        z13 = false;
                    }
                    Assertions.checkState(z13);
                    this.writtenEncodedFrames += ((long) this.framesPerEncodedSample) * ((long) this.inputBufferAccessUnitCount);
                }
                this.outputBuffer = null;
            }
        }
    }

    @RequiresApi(21)
    private static int writeNonBlockingV21(AudioTrack audioTrack2, ByteBuffer byteBuffer, int i11) {
        return audioTrack2.write(byteBuffer, i11, 1);
    }

    @RequiresApi(21)
    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack2, ByteBuffer byteBuffer, int i11, long j11) {
        if (Util.SDK_INT >= 26) {
            return audioTrack2.write(byteBuffer, i11, 1, j11 * 1000);
        }
        if (this.avSyncHeader == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.avSyncHeader = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(1431633921);
        }
        if (this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, i11);
            this.avSyncHeader.putLong(8, j11 * 1000);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = i11;
        }
        int remaining = this.avSyncHeader.remaining();
        if (remaining > 0) {
            int write = audioTrack2.write(this.avSyncHeader, remaining, 1);
            if (write < 0) {
                this.bytesUntilNextAvSync = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int writeNonBlockingV21 = writeNonBlockingV21(audioTrack2, byteBuffer, i11);
        if (writeNonBlockingV21 < 0) {
            this.bytesUntilNextAvSync = 0;
            return writeNonBlockingV21;
        }
        this.bytesUntilNextAvSync -= writeNonBlockingV21;
        return writeNonBlockingV21;
    }

    public void configure(Format format, int i11, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessor[] audioProcessorArr;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        double d11;
        AudioProcessor[] audioProcessorArr2;
        int[] iArr2;
        Format format2 = format;
        if (MimeTypes.AUDIO_RAW.equals(format2.sampleMimeType)) {
            Assertions.checkArgument(Util.isEncodingLinearPcm(format2.pcmEncoding));
            i17 = Util.getPcmFrameSize(format2.pcmEncoding, format2.channelCount);
            if (shouldUseFloatOutput(format2.pcmEncoding)) {
                audioProcessorArr2 = this.toFloatPcmAvailableAudioProcessors;
            } else {
                audioProcessorArr2 = this.toIntPcmAvailableAudioProcessors;
            }
            this.trimmingAudioProcessor.setTrimFrameCount(format2.encoderDelay, format2.encoderPadding);
            if (Util.SDK_INT < 21 && format2.channelCount == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i25 = 0; i25 < 6; i25++) {
                    iArr2[i25] = i25;
                }
            } else {
                iArr2 = iArr;
            }
            this.channelMappingAudioProcessor.setChannelMap(iArr2);
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(format2.sampleRate, format2.channelCount, format2.pcmEncoding);
            int length = audioProcessorArr2.length;
            int i26 = 0;
            while (i26 < length) {
                AudioProcessor audioProcessor = audioProcessorArr2[i26];
                try {
                    AudioProcessor.AudioFormat configure = audioProcessor.configure(audioFormat);
                    if (audioProcessor.isActive()) {
                        audioFormat = configure;
                    }
                    i26++;
                } catch (AudioProcessor.UnhandledAudioFormatException e11) {
                    throw new AudioSink.ConfigurationException((Throwable) e11, format2);
                }
            }
            int i27 = audioFormat.encoding;
            int i28 = audioFormat.sampleRate;
            int audioTrackChannelConfig = Util.getAudioTrackChannelConfig(audioFormat.channelCount);
            i12 = 0;
            audioProcessorArr = audioProcessorArr2;
            i14 = Util.getPcmFrameSize(i27, audioFormat.channelCount);
            i16 = i27;
            i13 = i28;
            i15 = audioTrackChannelConfig;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i29 = format2.sampleRate;
            if (useOffloadedPlayback(format2, this.audioAttributes)) {
                audioProcessorArr = audioProcessorArr3;
                i17 = -1;
                i14 = -1;
                i12 = 1;
                i13 = i29;
                i16 = MimeTypes.getEncoding((String) Assertions.checkNotNull(format2.sampleMimeType), format2.codecs);
                i15 = Util.getAudioTrackChannelConfig(format2.channelCount);
            } else {
                Pair<Integer, Integer> encodingAndChannelConfigForPassthrough = this.audioCapabilities.getEncodingAndChannelConfigForPassthrough(format2);
                if (encodingAndChannelConfigForPassthrough != null) {
                    int intValue = ((Integer) encodingAndChannelConfigForPassthrough.first).intValue();
                    audioProcessorArr = audioProcessorArr3;
                    i17 = -1;
                    i14 = -1;
                    i13 = i29;
                    i15 = ((Integer) encodingAndChannelConfigForPassthrough.second).intValue();
                    i16 = intValue;
                    i12 = 2;
                } else {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + format2, format2);
                }
            }
        }
        if (i16 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i12 + ") for: " + format2, format2);
        } else if (i15 != 0) {
            if (i11 != 0) {
                i23 = i11;
                i22 = i16;
                i21 = i15;
                i18 = i14;
                i19 = i13;
            } else {
                AudioTrackBufferSizeProvider audioTrackBufferSizeProvider2 = this.audioTrackBufferSizeProvider;
                int audioTrackMinBufferSize = getAudioTrackMinBufferSize(i13, i15, i16);
                if (i14 != -1) {
                    i24 = i14;
                } else {
                    i24 = 1;
                }
                int i31 = format2.bitrate;
                if (this.enableAudioTrackPlaybackParams) {
                    d11 = 8.0d;
                } else {
                    d11 = 1.0d;
                }
                i22 = i16;
                i21 = i15;
                i18 = i14;
                i19 = i13;
                i23 = audioTrackBufferSizeProvider2.getBufferSizeInBytes(audioTrackMinBufferSize, i16, i12, i24, i13, i31, d11);
            }
            this.offloadDisabledUntilNextConfiguration = false;
            Configuration configuration2 = new Configuration(format, i17, i12, i18, i19, i21, i22, i23, audioProcessorArr);
            if (isAudioTrackInitialized()) {
                this.pendingConfiguration = configuration2;
            } else {
                this.configuration = configuration2;
            }
        } else {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i12 + ") for: " + format2, format2);
        }
    }

    public void disableTunneling() {
        if (this.tunneling) {
            this.tunneling = false;
            flush();
        }
    }

    public void enableTunnelingV21() {
        boolean z11;
        if (Util.SDK_INT >= 21) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        Assertions.checkState(this.externalAudioSessionIdProvided);
        if (!this.tunneling) {
            this.tunneling = true;
            flush();
        }
    }

    public void experimentalFlushWithoutAudioTrackRelease() {
        boolean z11;
        if (Util.SDK_INT < 25) {
            flush();
            return;
        }
        this.writeExceptionPendingExceptionHolder.clear();
        this.initializationExceptionPendingExceptionHolder.clear();
        if (isAudioTrackInitialized()) {
            resetSinkStateForFlush();
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            this.audioTrack.flush();
            this.audioTrackPositionTracker.reset();
            AudioTrackPositionTracker audioTrackPositionTracker2 = this.audioTrackPositionTracker;
            AudioTrack audioTrack2 = this.audioTrack;
            Configuration configuration2 = this.configuration;
            if (configuration2.outputMode == 2) {
                z11 = true;
            } else {
                z11 = false;
            }
            audioTrackPositionTracker2.setAudioTrack(audioTrack2, z11, configuration2.outputEncoding, configuration2.outputPcmFrameSize, configuration2.bufferSize);
            this.startMediaTimeUsNeedsInit = true;
        }
    }

    public void flush() {
        if (isAudioTrackInitialized()) {
            resetSinkStateForFlush();
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            if (isOffloadedPlayback(this.audioTrack)) {
                ((StreamEventCallbackV29) Assertions.checkNotNull(this.offloadStreamEventCallbackV29)).unregister(this.audioTrack);
            }
            if (Util.SDK_INT < 21 && !this.externalAudioSessionIdProvided) {
                this.audioSessionId = 0;
            }
            Configuration configuration2 = this.pendingConfiguration;
            if (configuration2 != null) {
                this.configuration = configuration2;
                this.pendingConfiguration = null;
            }
            this.audioTrackPositionTracker.reset();
            releaseAudioTrackAsync(this.audioTrack, this.releasingConditionVariable);
            this.audioTrack = null;
        }
        this.writeExceptionPendingExceptionHolder.clear();
        this.initializationExceptionPendingExceptionHolder.clear();
    }

    public AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    public long getCurrentPositionUs(boolean z11) {
        if (!isAudioTrackInitialized() || this.startMediaTimeUsNeedsInit) {
            return Long.MIN_VALUE;
        }
        return applySkipping(applyMediaPositionParameters(Math.min(this.audioTrackPositionTracker.getCurrentPositionUs(z11), this.configuration.framesToDurationUs(getWrittenFrames()))));
    }

    public int getFormatSupport(Format format) {
        if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
            if (!Util.isEncodingLinearPcm(format.pcmEncoding)) {
                Log.w(TAG, "Invalid PCM encoding: " + format.pcmEncoding);
                return 0;
            }
            int i11 = format.pcmEncoding;
            if (i11 == 2 || (this.enableFloatOutput && i11 == 4)) {
                return 2;
            }
            return 1;
        } else if ((this.offloadDisabledUntilNextConfiguration || !useOffloadedPlayback(format, this.audioAttributes)) && !this.audioCapabilities.isPassthroughPlaybackSupported(format)) {
            return 0;
        } else {
            return 2;
        }
    }

    public PlaybackParameters getPlaybackParameters() {
        if (this.enableAudioTrackPlaybackParams) {
            return this.audioTrackPlaybackParameters;
        }
        return getAudioProcessorPlaybackParameters();
    }

    public boolean getSkipSilenceEnabled() {
        return getMediaPositionParameters().skipSilence;
    }

    public boolean handleBuffer(ByteBuffer byteBuffer, long j11, int i11) throws AudioSink.InitializationException, AudioSink.WriteException {
        boolean z11;
        boolean z12;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j12 = j11;
        int i12 = i11;
        ByteBuffer byteBuffer3 = this.inputBuffer;
        if (byteBuffer3 == null || byteBuffer2 == byteBuffer3) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        if (this.pendingConfiguration != null) {
            if (!drainToEndOfStream()) {
                return false;
            }
            if (!this.pendingConfiguration.canReuseAudioTrack(this.configuration)) {
                playPendingData();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            } else {
                this.configuration = this.pendingConfiguration;
                this.pendingConfiguration = null;
                if (isOffloadedPlayback(this.audioTrack) && this.offloadMode != 3) {
                    if (this.audioTrack.getPlayState() == 3) {
                        this.audioTrack.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack2 = this.audioTrack;
                    Format format = this.configuration.inputFormat;
                    audioTrack2.setOffloadDelayPadding(format.encoderDelay, format.encoderPadding);
                    this.isWaitingForOffloadEndOfStreamHandled = true;
                }
            }
            applyAudioProcessorPlaybackParametersAndSkipSilence(j12);
        }
        if (!isAudioTrackInitialized()) {
            try {
                if (!initializeAudioTrack()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e11) {
                AudioSink.InitializationException initializationException = e11;
                if (!initializationException.isRecoverable) {
                    this.initializationExceptionPendingExceptionHolder.throwExceptionIfDeadlineIsReached(initializationException);
                    return false;
                }
                throw initializationException;
            }
        }
        this.initializationExceptionPendingExceptionHolder.clear();
        if (this.startMediaTimeUsNeedsInit) {
            this.startMediaTimeUs = Math.max(0, j12);
            this.startMediaTimeUsNeedsSync = false;
            this.startMediaTimeUsNeedsInit = false;
            if (this.enableAudioTrackPlaybackParams && Util.SDK_INT >= 23) {
                setAudioTrackPlaybackParametersV23(this.audioTrackPlaybackParameters);
            }
            applyAudioProcessorPlaybackParametersAndSkipSilence(j12);
            if (this.playing) {
                play();
            }
        }
        if (!this.audioTrackPositionTracker.mayHandleBuffer(getWrittenFrames())) {
            return false;
        }
        if (this.inputBuffer == null) {
            if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                z12 = true;
            } else {
                z12 = false;
            }
            Assertions.checkArgument(z12);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            Configuration configuration2 = this.configuration;
            if (configuration2.outputMode != 0 && this.framesPerEncodedSample == 0) {
                int framesPerEncodedSample2 = getFramesPerEncodedSample(configuration2.outputEncoding, byteBuffer2);
                this.framesPerEncodedSample = framesPerEncodedSample2;
                if (framesPerEncodedSample2 == 0) {
                    return true;
                }
            }
            if (this.afterDrainParameters != null) {
                if (!drainToEndOfStream()) {
                    return false;
                }
                applyAudioProcessorPlaybackParametersAndSkipSilence(j12);
                this.afterDrainParameters = null;
            }
            long inputFramesToDurationUs = this.startMediaTimeUs + this.configuration.inputFramesToDurationUs(getSubmittedFrames() - this.trimmingAudioProcessor.getTrimmedFrameCount());
            if (!this.startMediaTimeUsNeedsSync && Math.abs(inputFramesToDurationUs - j12) > 200000) {
                AudioSink.Listener listener2 = this.listener;
                if (listener2 != null) {
                    listener2.onAudioSinkError(new AudioSink.UnexpectedDiscontinuityException(j12, inputFramesToDurationUs));
                }
                this.startMediaTimeUsNeedsSync = true;
            }
            if (this.startMediaTimeUsNeedsSync) {
                if (!drainToEndOfStream()) {
                    return false;
                }
                long j13 = j12 - inputFramesToDurationUs;
                this.startMediaTimeUs += j13;
                this.startMediaTimeUsNeedsSync = false;
                applyAudioProcessorPlaybackParametersAndSkipSilence(j12);
                AudioSink.Listener listener3 = this.listener;
                if (!(listener3 == null || j13 == 0)) {
                    listener3.onPositionDiscontinuity();
                }
            }
            if (this.configuration.outputMode == 0) {
                this.submittedPcmBytes += (long) byteBuffer.remaining();
            } else {
                this.submittedEncodedFrames += ((long) this.framesPerEncodedSample) * ((long) i12);
            }
            this.inputBuffer = byteBuffer2;
            this.inputBufferAccessUnitCount = i12;
        }
        processBuffers(j12);
        if (!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            this.inputBufferAccessUnitCount = 0;
            return true;
        } else if (!this.audioTrackPositionTracker.isStalled(getWrittenFrames())) {
            return false;
        } else {
            Log.w(TAG, "Resetting stalled audio track");
            flush();
            return true;
        }
    }

    public void handleDiscontinuity() {
        this.startMediaTimeUsNeedsSync = true;
    }

    public boolean hasPendingData() {
        if (!isAudioTrackInitialized() || !this.audioTrackPositionTracker.hasPendingData(getWrittenFrames())) {
            return false;
        }
        return true;
    }

    public boolean isEnded() {
        return !isAudioTrackInitialized() || (this.handledEndOfStream && !hasPendingData());
    }

    public void pause() {
        this.playing = false;
        if (isAudioTrackInitialized() && this.audioTrackPositionTracker.pause()) {
            this.audioTrack.pause();
        }
    }

    public void play() {
        this.playing = true;
        if (isAudioTrackInitialized()) {
            this.audioTrackPositionTracker.start();
            this.audioTrack.play();
        }
    }

    public void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.handledEndOfStream && isAudioTrackInitialized() && drainToEndOfStream()) {
            playPendingData();
            this.handledEndOfStream = true;
        }
    }

    public void reset() {
        flush();
        for (AudioProcessor reset : this.toIntPcmAvailableAudioProcessors) {
            reset.reset();
        }
        for (AudioProcessor reset2 : this.toFloatPcmAvailableAudioProcessors) {
            reset2.reset();
        }
        this.playing = false;
        this.offloadDisabledUntilNextConfiguration = false;
    }

    public void setAudioAttributes(AudioAttributes audioAttributes2) {
        if (!this.audioAttributes.equals(audioAttributes2)) {
            this.audioAttributes = audioAttributes2;
            if (!this.tunneling) {
                flush();
            }
        }
    }

    public void setAudioSessionId(int i11) {
        boolean z11;
        if (this.audioSessionId != i11) {
            this.audioSessionId = i11;
            if (i11 != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.externalAudioSessionIdProvided = z11;
            flush();
        }
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo2) {
        if (!this.auxEffectInfo.equals(auxEffectInfo2)) {
            int i11 = auxEffectInfo2.effectId;
            float f11 = auxEffectInfo2.sendLevel;
            AudioTrack audioTrack2 = this.audioTrack;
            if (audioTrack2 != null) {
                if (this.auxEffectInfo.effectId != i11) {
                    audioTrack2.attachAuxEffect(i11);
                }
                if (i11 != 0) {
                    this.audioTrack.setAuxEffectSendLevel(f11);
                }
            }
            this.auxEffectInfo = auxEffectInfo2;
        }
    }

    public void setListener(AudioSink.Listener listener2) {
        this.listener = listener2;
    }

    public /* synthetic */ void setOutputStreamOffsetUs(long j11) {
        o.a(this, j11);
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        PlaybackParameters playbackParameters2 = new PlaybackParameters(Util.constrainValue(playbackParameters.speed, 0.1f, 8.0f), Util.constrainValue(playbackParameters.pitch, 0.1f, 8.0f));
        if (!this.enableAudioTrackPlaybackParams || Util.SDK_INT < 23) {
            setAudioProcessorPlaybackParametersAndSkipSilence(playbackParameters2, getSkipSilenceEnabled());
        } else {
            setAudioTrackPlaybackParametersV23(playbackParameters2);
        }
    }

    public void setPlayerId(@Nullable PlayerId playerId2) {
        this.playerId = playerId2;
    }

    @RequiresApi(23)
    public void setPreferredDevice(@Nullable AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfoApi23 audioDeviceInfoApi23;
        if (audioDeviceInfo == null) {
            audioDeviceInfoApi23 = null;
        } else {
            audioDeviceInfoApi23 = new AudioDeviceInfoApi23(audioDeviceInfo);
        }
        this.preferredDevice = audioDeviceInfoApi23;
        AudioTrack audioTrack2 = this.audioTrack;
        if (audioTrack2 != null) {
            Api23.setPreferredDeviceOnAudioTrack(audioTrack2, audioDeviceInfoApi23);
        }
    }

    public void setSkipSilenceEnabled(boolean z11) {
        setAudioProcessorPlaybackParametersAndSkipSilence(getAudioProcessorPlaybackParameters(), z11);
    }

    public void setVolume(float f11) {
        if (this.volume != f11) {
            this.volume = f11;
            setVolumeInternal();
        }
    }

    public boolean supportsFormat(Format format) {
        return getFormatSupport(format) != 0;
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.audio.DefaultAudioSink"}, replacement = "new DefaultAudioSink.Builder().setAudioCapabilities(audioCapabilities).setAudioProcessors(audioProcessors).build()")
    @InlineMeValidationDisabled("Migrate constructor to Builder")
    @Deprecated
    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities2, AudioProcessor[] audioProcessorArr) {
        this(new Builder().setAudioCapabilities((AudioCapabilities) MoreObjects.firstNonNull(audioCapabilities2, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES)).setAudioProcessors(audioProcessorArr));
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.audio.DefaultAudioSink"}, replacement = "new DefaultAudioSink.Builder().setAudioCapabilities(audioCapabilities).setAudioProcessors(audioProcessors).setEnableFloatOutput(enableFloatOutput).build()")
    @InlineMeValidationDisabled("Migrate constructor to Builder")
    @Deprecated
    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities2, AudioProcessor[] audioProcessorArr, boolean z11) {
        this(new Builder().setAudioCapabilities((AudioCapabilities) MoreObjects.firstNonNull(audioCapabilities2, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES)).setAudioProcessors(audioProcessorArr).setEnableFloatOutput(z11));
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.audio.DefaultAudioSink"}, replacement = "new DefaultAudioSink.Builder().setAudioCapabilities(audioCapabilities).setAudioProcessorChain(audioProcessorChain).setEnableFloatOutput(enableFloatOutput).setEnableAudioTrackPlaybackParams(enableAudioTrackPlaybackParams).setOffloadMode(offloadMode).build()")
    @InlineMeValidationDisabled("Migrate constructor to Builder")
    @Deprecated
    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities2, AudioProcessorChain audioProcessorChain2, boolean z11, boolean z12, int i11) {
        this(new Builder().setAudioCapabilities((AudioCapabilities) MoreObjects.firstNonNull(audioCapabilities2, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES)).setAudioProcessorChain(audioProcessorChain2).setEnableFloatOutput(z11).setEnableAudioTrackPlaybackParams(z12).setOffloadMode(i11));
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    private DefaultAudioSink(Builder builder) {
        this.audioCapabilities = builder.audioCapabilities;
        AudioProcessorChain access$200 = builder.audioProcessorChain;
        this.audioProcessorChain = access$200;
        int i11 = Util.SDK_INT;
        this.enableFloatOutput = i11 >= 21 && builder.enableFloatOutput;
        this.enableAudioTrackPlaybackParams = i11 >= 23 && builder.enableAudioTrackPlaybackParams;
        this.offloadMode = i11 >= 29 ? builder.offloadMode : 0;
        this.audioTrackBufferSizeProvider = builder.audioTrackBufferSizeProvider;
        ConditionVariable conditionVariable = new ConditionVariable(Clock.DEFAULT);
        this.releasingConditionVariable = conditionVariable;
        conditionVariable.open();
        this.audioTrackPositionTracker = new AudioTrackPositionTracker(new PositionTrackerListener());
        ChannelMappingAudioProcessor channelMappingAudioProcessor2 = new ChannelMappingAudioProcessor();
        this.channelMappingAudioProcessor = channelMappingAudioProcessor2;
        TrimmingAudioProcessor trimmingAudioProcessor2 = new TrimmingAudioProcessor();
        this.trimmingAudioProcessor = trimmingAudioProcessor2;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new BaseAudioProcessor[]{new ResamplingAudioProcessor(), channelMappingAudioProcessor2, trimmingAudioProcessor2});
        Collections.addAll(arrayList, access$200.getAudioProcessors());
        this.toIntPcmAvailableAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.toFloatPcmAvailableAudioProcessors = new AudioProcessor[]{new FloatResamplingAudioProcessor()};
        this.volume = 1.0f;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.auxEffectInfo = new AuxEffectInfo(0, 0.0f);
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        this.mediaPositionParameters = new MediaPositionParameters(playbackParameters, false, 0, 0);
        this.audioTrackPlaybackParameters = playbackParameters;
        this.drainingAudioProcessorIndex = -1;
        this.activeAudioProcessors = new AudioProcessor[0];
        this.outputBuffers = new ByteBuffer[0];
        this.mediaPositionParametersCheckpoints = new ArrayDeque<>();
        this.initializationExceptionPendingExceptionHolder = new PendingExceptionHolder<>(100);
        this.writeExceptionPendingExceptionHolder = new PendingExceptionHolder<>(100);
        this.audioOffloadListener = builder.audioOffloadListener;
    }
}
