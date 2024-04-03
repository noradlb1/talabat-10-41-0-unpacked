package com.google.android.exoplayer2.audio;

import android.media.AudioDeviceInfo;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.decoder.SimpleDecoderOutputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.ForOverride;
import g7.c1;
import i7.p;
import k7.d;

public abstract class DecoderAudioRenderer<T extends Decoder<DecoderInputBuffer, ? extends SimpleDecoderOutputBuffer, ? extends DecoderException>> extends BaseRenderer implements MediaClock {
    private static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "DecoderAudioRenderer";
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private boolean audioTrackNeedsConfigure;
    private long currentPositionUs;
    @Nullable
    private T decoder;
    private DecoderCounters decoderCounters;
    @Nullable
    private DrmSession decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private int encoderDelay;
    private int encoderPadding;
    /* access modifiers changed from: private */
    public final AudioRendererEventListener.EventDispatcher eventDispatcher;
    private boolean experimentalKeepAudioTrackOnSeek;
    private boolean firstStreamSampleRead;
    private final DecoderInputBuffer flagsOnlyBuffer;
    @Nullable
    private DecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    @Nullable
    private SimpleDecoderOutputBuffer outputBuffer;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    @Nullable
    private DrmSession sourceDrmSession;

    @RequiresApi(23)
    public static final class Api23 {
        private Api23() {
        }

        @DoNotInline
        public static void setAudioSinkPreferredDevice(AudioSink audioSink, @Nullable Object obj) {
            audioSink.setPreferredDevice((AudioDeviceInfo) obj);
        }
    }

    public final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        public void onAudioSinkError(Exception exc) {
            Log.e(DecoderAudioRenderer.TAG, "Audio sink error", exc);
            DecoderAudioRenderer.this.eventDispatcher.audioSinkError(exc);
        }

        public /* synthetic */ void onOffloadBufferEmptying() {
            p.b(this);
        }

        public /* synthetic */ void onOffloadBufferFull() {
            p.c(this);
        }

        public void onPositionAdvancing(long j11) {
            DecoderAudioRenderer.this.eventDispatcher.positionAdvancing(j11);
        }

        public void onPositionDiscontinuity() {
            DecoderAudioRenderer.this.onPositionDiscontinuity();
        }

        public void onSkipSilenceEnabledChanged(boolean z11) {
            DecoderAudioRenderer.this.eventDispatcher.skipSilenceEnabledChanged(z11);
        }

        public void onUnderrun(int i11, long j11, long j12) {
            DecoderAudioRenderer.this.eventDispatcher.underrun(i11, j11, j12);
        }
    }

    public DecoderAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
    }

    private boolean drainOutputBuffer() throws ExoPlaybackException, DecoderException, AudioSink.ConfigurationException, AudioSink.InitializationException, AudioSink.WriteException {
        if (this.outputBuffer == null) {
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = (SimpleDecoderOutputBuffer) this.decoder.dequeueOutputBuffer();
            this.outputBuffer = simpleDecoderOutputBuffer;
            if (simpleDecoderOutputBuffer == null) {
                return false;
            }
            int i11 = simpleDecoderOutputBuffer.skippedOutputBufferCount;
            if (i11 > 0) {
                this.decoderCounters.skippedOutputBufferCount += i11;
                this.audioSink.handleDiscontinuity();
            }
            if (this.outputBuffer.isFirstSample()) {
                processFirstSampleOfStream();
            }
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
                this.audioTrackNeedsConfigure = true;
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                try {
                    processEndOfStream();
                } catch (AudioSink.WriteException e11) {
                    throw createRendererException(e11, e11.format, e11.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
                }
            }
            return false;
        }
        if (this.audioTrackNeedsConfigure) {
            this.audioSink.configure(getOutputFormat(this.decoder).buildUpon().setEncoderDelay(this.encoderDelay).setEncoderPadding(this.encoderPadding).build(), 0, (int[]) null);
            this.audioTrackNeedsConfigure = false;
        }
        AudioSink audioSink2 = this.audioSink;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer2 = this.outputBuffer;
        if (!audioSink2.handleBuffer(simpleDecoderOutputBuffer2.data, simpleDecoderOutputBuffer2.timeUs, 1)) {
            return false;
        }
        this.decoderCounters.renderedOutputBufferCount++;
        this.outputBuffer.release();
        this.outputBuffer = null;
        return true;
    }

    private boolean feedInputBuffer() throws DecoderException, ExoPlaybackException {
        T t11 = this.decoder;
        if (t11 == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) t11.dequeueInputBuffer();
            this.inputBuffer = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        FormatHolder formatHolder = getFormatHolder();
        int readSource = readSource(formatHolder, this.inputBuffer, 0);
        if (readSource == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        } else if (readSource != -4) {
            if (readSource == -3) {
                return false;
            }
            throw new IllegalStateException();
        } else if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            return false;
        } else {
            if (!this.firstStreamSampleRead) {
                this.firstStreamSampleRead = true;
                this.inputBuffer.addFlag(C.BUFFER_FLAG_FIRST_SAMPLE);
            }
            this.inputBuffer.flip();
            DecoderInputBuffer decoderInputBuffer2 = this.inputBuffer;
            decoderInputBuffer2.format = this.inputFormat;
            onQueueInputBuffer(decoderInputBuffer2);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.decoderReceivedBuffers = true;
            this.decoderCounters.queuedInputBufferCount++;
            this.inputBuffer = null;
            return true;
        }
    }

    private void flushDecoder() throws ExoPlaybackException {
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = this.outputBuffer;
        if (simpleDecoderOutputBuffer != null) {
            simpleDecoderOutputBuffer.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    private void maybeInitDecoder() throws ExoPlaybackException {
        CryptoConfig cryptoConfig;
        if (this.decoder == null) {
            setDecoderDrmSession(this.sourceDrmSession);
            DrmSession drmSession = this.decoderDrmSession;
            if (drmSession != null) {
                cryptoConfig = drmSession.getCryptoConfig();
                if (cryptoConfig == null && this.decoderDrmSession.getError() == null) {
                    return;
                }
            } else {
                cryptoConfig = null;
            }
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                TraceUtil.beginSection("createAudioDecoder");
                this.decoder = createDecoder(this.inputFormat, cryptoConfig);
                TraceUtil.endSection();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                this.eventDispatcher.decoderInitialized(this.decoder.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.decoderCounters.decoderInitCount++;
            } catch (DecoderException e11) {
                Log.e(TAG, "Audio codec error", e11);
                this.eventDispatcher.audioCodecError(e11);
                throw createRendererException(e11, this.inputFormat, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
            } catch (OutOfMemoryError e12) {
                throw createRendererException(e12, this.inputFormat, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
            }
        }
    }

    private void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluation;
        Format format = (Format) Assertions.checkNotNull(formatHolder.format);
        setSourceDrmSession(formatHolder.drmSession);
        Format format2 = this.inputFormat;
        this.inputFormat = format;
        this.encoderDelay = format.encoderDelay;
        this.encoderPadding = format.encoderPadding;
        T t11 = this.decoder;
        if (t11 == null) {
            maybeInitDecoder();
            this.eventDispatcher.inputFormatChanged(this.inputFormat, (DecoderReuseEvaluation) null);
            return;
        }
        if (this.sourceDrmSession != this.decoderDrmSession) {
            decoderReuseEvaluation = new DecoderReuseEvaluation(t11.getName(), format2, format, 0, 128);
        } else {
            decoderReuseEvaluation = canReuseDecoder(t11.getName(), format2, format);
        }
        if (decoderReuseEvaluation.result == 0) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
                this.audioTrackNeedsConfigure = true;
            }
        }
        this.eventDispatcher.inputFormatChanged(this.inputFormat, decoderReuseEvaluation);
    }

    private void processEndOfStream() throws AudioSink.WriteException {
        this.outputStreamEnded = true;
        this.audioSink.playToEndOfStream();
    }

    private void processFirstSampleOfStream() {
        this.audioSink.handleDiscontinuity();
        if (this.pendingOutputStreamOffsetCount != 0) {
            setOutputStreamOffsetUs(this.pendingOutputStreamOffsetsUs[0]);
            int i11 = this.pendingOutputStreamOffsetCount - 1;
            this.pendingOutputStreamOffsetCount = i11;
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            System.arraycopy(jArr, 1, jArr, 0, i11);
        }
    }

    private void releaseDecoder() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        T t11 = this.decoder;
        if (t11 != null) {
            this.decoderCounters.decoderReleaseCount++;
            t11.release();
            this.eventDispatcher.decoderReleased(this.decoder.getName());
            this.decoder = null;
        }
        setDecoderDrmSession((DrmSession) null);
    }

    private void setDecoderDrmSession(@Nullable DrmSession drmSession) {
        d.b(this.decoderDrmSession, drmSession);
        this.decoderDrmSession = drmSession;
    }

    private void setOutputStreamOffsetUs(long j11) {
        this.outputStreamOffsetUs = j11;
        if (j11 != C.TIME_UNSET) {
            this.audioSink.setOutputStreamOffsetUs(j11);
        }
    }

    private void setSourceDrmSession(@Nullable DrmSession drmSession) {
        d.b(this.sourceDrmSession, drmSession);
        this.sourceDrmSession = drmSession;
    }

    private void updateCurrentPosition() {
        long currentPositionUs2 = this.audioSink.getCurrentPositionUs(isEnded());
        if (currentPositionUs2 != Long.MIN_VALUE) {
            if (!this.allowPositionDiscontinuity) {
                currentPositionUs2 = Math.max(this.currentPositionUs, currentPositionUs2);
            }
            this.currentPositionUs = currentPositionUs2;
            this.allowPositionDiscontinuity = false;
        }
    }

    @ForOverride
    public DecoderReuseEvaluation canReuseDecoder(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    @ForOverride
    public abstract T createDecoder(Format format, @Nullable CryptoConfig cryptoConfig) throws DecoderException;

    public void experimentalSetEnableKeepAudioTrackOnSeek(boolean z11) {
        this.experimentalKeepAudioTrackOnSeek = z11;
    }

    @Nullable
    public MediaClock getMediaClock() {
        return this;
    }

    @ForOverride
    public abstract Format getOutputFormat(T t11);

    public PlaybackParameters getPlaybackParameters() {
        return this.audioSink.getPlaybackParameters();
    }

    public long getPositionUs() {
        if (getState() == 2) {
            updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    public final int getSinkFormatSupport(Format format) {
        return this.audioSink.getFormatSupport(format);
    }

    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        if (i11 == 2) {
            this.audioSink.setVolume(((Float) obj).floatValue());
        } else if (i11 == 3) {
            this.audioSink.setAudioAttributes((AudioAttributes) obj);
        } else if (i11 == 6) {
            this.audioSink.setAuxEffectInfo((AuxEffectInfo) obj);
        } else if (i11 != 12) {
            if (i11 == 9) {
                this.audioSink.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
            } else if (i11 != 10) {
                super.handleMessage(i11, obj);
            } else {
                this.audioSink.setAudioSessionId(((Integer) obj).intValue());
            }
        } else if (Util.SDK_INT >= 23) {
            Api23.setAudioSinkPreferredDevice(this.audioSink, obj);
        }
    }

    public boolean isEnded() {
        return this.outputStreamEnded && this.audioSink.isEnded();
    }

    public boolean isReady() {
        if (this.audioSink.hasPendingData() || (this.inputFormat != null && (isSourceReady() || this.outputBuffer != null))) {
            return true;
        }
        return false;
    }

    public void onDisabled() {
        this.inputFormat = null;
        this.audioTrackNeedsConfigure = true;
        setOutputStreamOffsetUs(C.TIME_UNSET);
        try {
            setSourceDrmSession((DrmSession) null);
            releaseDecoder();
            this.audioSink.reset();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    public void onEnabled(boolean z11, boolean z12) throws ExoPlaybackException {
        DecoderCounters decoderCounters2 = new DecoderCounters();
        this.decoderCounters = decoderCounters2;
        this.eventDispatcher.enabled(decoderCounters2);
        if (getConfiguration().tunneling) {
            this.audioSink.enableTunnelingV21();
        } else {
            this.audioSink.disableTunneling();
        }
        this.audioSink.setPlayerId(getPlayerId());
    }

    @ForOverride
    @CallSuper
    public void onPositionDiscontinuity() {
        this.allowPositionDiscontinuity = true;
    }

    public void onPositionReset(long j11, boolean z11) throws ExoPlaybackException {
        if (this.experimentalKeepAudioTrackOnSeek) {
            this.audioSink.experimentalFlushWithoutAudioTrackRelease();
        } else {
            this.audioSink.flush();
        }
        this.currentPositionUs = j11;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.decoder != null) {
            flushDecoder();
        }
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.allowFirstBufferPositionDiscontinuity && !decoderInputBuffer.isDecodeOnly()) {
            if (Math.abs(decoderInputBuffer.timeUs - this.currentPositionUs) > 500000) {
                this.currentPositionUs = decoderInputBuffer.timeUs;
            }
            this.allowFirstBufferPositionDiscontinuity = false;
        }
    }

    public void onStarted() {
        this.audioSink.play();
    }

    public void onStopped() {
        updateCurrentPosition();
        this.audioSink.pause();
    }

    public void onStreamChanged(Format[] formatArr, long j11, long j12) throws ExoPlaybackException {
        super.onStreamChanged(formatArr, j11, j12);
        this.firstStreamSampleRead = false;
        if (this.outputStreamOffsetUs == C.TIME_UNSET) {
            setOutputStreamOffsetUs(j12);
            return;
        }
        int i11 = this.pendingOutputStreamOffsetCount;
        if (i11 == this.pendingOutputStreamOffsetsUs.length) {
            Log.w(TAG, "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
        } else {
            this.pendingOutputStreamOffsetCount = i11 + 1;
        }
        this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1] = j12;
    }

    public void render(long j11, long j12) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            try {
                this.audioSink.playToEndOfStream();
            } catch (AudioSink.WriteException e11) {
                throw createRendererException(e11, e11.format, e11.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
            }
        } else {
            if (this.inputFormat == null) {
                FormatHolder formatHolder = getFormatHolder();
                this.flagsOnlyBuffer.clear();
                int readSource = readSource(formatHolder, this.flagsOnlyBuffer, 2);
                if (readSource == -5) {
                    onInputFormatChanged(formatHolder);
                } else if (readSource == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    try {
                        processEndOfStream();
                        return;
                    } catch (AudioSink.WriteException e12) {
                        throw createRendererException(e12, (Format) null, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
                    }
                } else {
                    return;
                }
            }
            maybeInitDecoder();
            if (this.decoder != null) {
                try {
                    TraceUtil.beginSection("drainAndFeed");
                    while (drainOutputBuffer()) {
                    }
                    while (feedInputBuffer()) {
                    }
                    TraceUtil.endSection();
                    this.decoderCounters.ensureUpdated();
                } catch (DecoderException e13) {
                    Log.e(TAG, "Audio codec error", e13);
                    this.eventDispatcher.audioCodecError(e13);
                    throw createRendererException(e13, this.inputFormat, PlaybackException.ERROR_CODE_DECODING_FAILED);
                } catch (AudioSink.ConfigurationException e14) {
                    throw createRendererException(e14, e14.format, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
                } catch (AudioSink.InitializationException e15) {
                    throw createRendererException(e15, e15.format, e15.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
                } catch (AudioSink.WriteException e16) {
                    throw createRendererException(e16, e16.format, e16.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
                }
            }
        }
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.audioSink.setPlaybackParameters(playbackParameters);
    }

    public final boolean sinkSupportsFormat(Format format) {
        return this.audioSink.supportsFormat(format);
    }

    public final int supportsFormat(Format format) {
        int i11 = 0;
        if (!MimeTypes.isAudio(format.sampleMimeType)) {
            return c1.a(0);
        }
        int supportsFormatInternal = supportsFormatInternal(format);
        if (supportsFormatInternal <= 2) {
            return c1.a(supportsFormatInternal);
        }
        if (Util.SDK_INT >= 21) {
            i11 = 32;
        }
        return c1.b(supportsFormatInternal, 8, i11);
    }

    @ForOverride
    public abstract int supportsFormatInternal(Format format);

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, (AudioCapabilities) null, audioProcessorArr);
    }

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, (AudioSink) new DefaultAudioSink.Builder().setAudioCapabilities((AudioCapabilities) MoreObjects.firstNonNull(audioCapabilities, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES)).setAudioProcessors(audioProcessorArr).build());
    }

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink2) {
        super(1);
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.audioSink = audioSink2;
        audioSink2.setListener(new AudioSinkListener());
        this.flagsOnlyBuffer = DecoderInputBuffer.newNoDataInstance();
        this.decoderReinitializationState = 0;
        this.audioTrackNeedsConfigure = true;
        setOutputStreamOffsetUs(C.TIME_UNSET);
        this.pendingOutputStreamOffsetsUs = new long[10];
    }
}
