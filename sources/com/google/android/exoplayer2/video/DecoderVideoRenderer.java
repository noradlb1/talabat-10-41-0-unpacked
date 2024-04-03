package com.google.android.exoplayer2.video;

import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import k7.d;

public abstract class DecoderVideoRenderer extends BaseRenderer {
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "DecoderVideoRenderer";
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private int consecutiveDroppedFrameCount;
    @Nullable
    private Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder;
    protected DecoderCounters decoderCounters;
    @Nullable
    private DrmSession decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private final TimedValueQueue<Format> formatQueue;
    @Nullable
    private VideoFrameMetadataListener frameMetadataListener;
    private long initialPositionUs;
    private DecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs = C.TIME_UNSET;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    @Nullable
    private Object output;
    private VideoDecoderOutputBuffer outputBuffer;
    @Nullable
    private VideoDecoderOutputBufferRenderer outputBufferRenderer;
    private Format outputFormat;
    private int outputMode;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    @Nullable
    private Surface outputSurface;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    @Nullable
    private VideoSize reportedVideoSize;
    @Nullable
    private DrmSession sourceDrmSession;
    private boolean waitingForFirstSampleInFormat;

    public DecoderVideoRenderer(long j11, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i11) {
        super(2);
        this.allowedJoiningTimeMs = j11;
        this.maxDroppedFramesToNotify = i11;
        clearReportedVideoSize();
        this.formatQueue = new TimedValueQueue<>();
        this.flagsOnlyBuffer = DecoderInputBuffer.newNoDataInstance();
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.decoderReinitializationState = 0;
        this.outputMode = -1;
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrameAfterReset = false;
    }

    private void clearReportedVideoSize() {
        this.reportedVideoSize = null;
    }

    private boolean drainOutputBuffer(long j11, long j12) throws ExoPlaybackException, DecoderException {
        if (this.outputBuffer == null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) this.decoder.dequeueOutputBuffer();
            this.outputBuffer = videoDecoderOutputBuffer;
            if (videoDecoderOutputBuffer == null) {
                return false;
            }
            DecoderCounters decoderCounters2 = this.decoderCounters;
            int i11 = decoderCounters2.skippedOutputBufferCount;
            int i12 = videoDecoderOutputBuffer.skippedOutputBufferCount;
            decoderCounters2.skippedOutputBufferCount = i11 + i12;
            this.buffersInCodecCount -= i12;
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                this.outputStreamEnded = true;
            }
            return false;
        }
        boolean processOutputBuffer = processOutputBuffer(j11, j12);
        if (processOutputBuffer) {
            onProcessedOutputBuffer(this.outputBuffer.timeUs);
            this.outputBuffer = null;
        }
        return processOutputBuffer;
    }

    private boolean feedInputBuffer() throws DecoderException, ExoPlaybackException {
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder2 = this.decoder;
        if (decoder2 == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            DecoderInputBuffer dequeueInputBuffer = decoder2.dequeueInputBuffer();
            this.inputBuffer = dequeueInputBuffer;
            if (dequeueInputBuffer == null) {
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
            if (this.waitingForFirstSampleInFormat) {
                this.formatQueue.add(this.inputBuffer.timeUs, this.inputFormat);
                this.waitingForFirstSampleInFormat = false;
            }
            this.inputBuffer.flip();
            DecoderInputBuffer decoderInputBuffer = this.inputBuffer;
            decoderInputBuffer.format = this.inputFormat;
            onQueueInputBuffer(decoderInputBuffer);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.buffersInCodecCount++;
            this.decoderReceivedBuffers = true;
            this.decoderCounters.queuedInputBufferCount++;
            this.inputBuffer = null;
            return true;
        }
    }

    private boolean hasOutput() {
        return this.outputMode != -1;
    }

    private static boolean isBufferLate(long j11) {
        return j11 < -30000;
    }

    private static boolean isBufferVeryLate(long j11) {
        return j11 < -500000;
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
                this.decoder = createDecoder(this.inputFormat, cryptoConfig);
                setDecoderOutputMode(this.outputMode);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                this.eventDispatcher.decoderInitialized(this.decoder.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.decoderCounters.decoderInitCount++;
            } catch (DecoderException e11) {
                Log.e(TAG, "Video codec error", e11);
                this.eventDispatcher.videoCodecError(e11);
                throw createRendererException(e11, this.inputFormat, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
            } catch (OutOfMemoryError e12) {
                throw createRendererException(e12, this.inputFormat, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
            }
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (!this.renderedFirstFrameAfterReset) {
            this.renderedFirstFrameAfterReset = true;
            this.eventDispatcher.renderedFirstFrame(this.output);
        }
    }

    private void maybeNotifyVideoSizeChanged(int i11, int i12) {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize == null || videoSize.width != i11 || videoSize.height != i12) {
            VideoSize videoSize2 = new VideoSize(i11, i12);
            this.reportedVideoSize = videoSize2;
            this.eventDispatcher.videoSizeChanged(videoSize2);
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrameAfterReset) {
            this.eventDispatcher.renderedFirstFrame(this.output);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void onOutputChanged() {
        maybeRenotifyVideoSizeChanged();
        clearRenderedFirstFrame();
        if (getState() == 2) {
            setJoiningDeadlineMs();
        }
    }

    private void onOutputRemoved() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
    }

    private void onOutputReset() {
        maybeRenotifyVideoSizeChanged();
        maybeRenotifyRenderedFirstFrame();
    }

    private boolean processOutputBuffer(long j11, long j12) throws ExoPlaybackException, DecoderException {
        boolean z11;
        boolean z12;
        if (this.initialPositionUs == C.TIME_UNSET) {
            this.initialPositionUs = j11;
        }
        long j13 = this.outputBuffer.timeUs - j11;
        if (hasOutput()) {
            long j14 = this.outputBuffer.timeUs - this.outputStreamOffsetUs;
            Format pollFloor = this.formatQueue.pollFloor(j14);
            if (pollFloor != null) {
                this.outputFormat = pollFloor;
            }
            long elapsedRealtime = (SystemClock.elapsedRealtime() * 1000) - this.lastRenderTimeUs;
            if (getState() == 2) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (this.renderedFirstFrameAfterEnable ? this.renderedFirstFrameAfterReset : !z11 && !this.mayRenderFirstFrameAfterEnableIfNotStarted) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12 || (z11 && shouldForceRenderOutputBuffer(j13, elapsedRealtime))) {
                renderOutputBuffer(this.outputBuffer, j14, this.outputFormat);
                return true;
            } else if (!z11 || j11 == this.initialPositionUs || (shouldDropBuffersToKeyframe(j13, j12) && maybeDropBuffersToKeyframe(j11))) {
                return false;
            } else {
                if (shouldDropOutputBuffer(j13, j12)) {
                    dropOutputBuffer(this.outputBuffer);
                    return true;
                }
                if (j13 < 30000) {
                    renderOutputBuffer(this.outputBuffer, j14, this.outputFormat);
                    return true;
                }
                return false;
            }
        } else if (!isBufferLate(j13)) {
            return false;
        } else {
            skipOutputBuffer(this.outputBuffer);
            return true;
        }
    }

    private void setDecoderDrmSession(@Nullable DrmSession drmSession) {
        d.b(this.decoderDrmSession, drmSession);
        this.decoderDrmSession = drmSession;
    }

    private void setJoiningDeadlineMs() {
        long j11;
        if (this.allowedJoiningTimeMs > 0) {
            j11 = SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs;
        } else {
            j11 = C.TIME_UNSET;
        }
        this.joiningDeadlineMs = j11;
    }

    private void setSourceDrmSession(@Nullable DrmSession drmSession) {
        d.b(this.sourceDrmSession, drmSession);
        this.sourceDrmSession = drmSession;
    }

    public DecoderReuseEvaluation canReuseDecoder(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    public abstract Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> createDecoder(Format format, @Nullable CryptoConfig cryptoConfig) throws DecoderException;

    public void dropOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        updateDroppedBufferCounters(0, 1);
        videoDecoderOutputBuffer.release();
    }

    @CallSuper
    public void flushDecoder() throws ExoPlaybackException {
        this.buffersInCodecCount = 0;
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.outputBuffer;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        if (i11 == 1) {
            setOutput(obj);
        } else if (i11 == 7) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i11, obj);
        }
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        if (this.inputFormat != null && ((isSourceReady() || this.outputBuffer != null) && (this.renderedFirstFrameAfterReset || !hasOutput()))) {
            this.joiningDeadlineMs = C.TIME_UNSET;
            return true;
        } else if (this.joiningDeadlineMs == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = C.TIME_UNSET;
            return false;
        }
    }

    public boolean maybeDropBuffersToKeyframe(long j11) throws ExoPlaybackException {
        int skipSource = skipSource(j11);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(skipSource, this.buffersInCodecCount);
        flushDecoder();
        return true;
    }

    public void onDisabled() {
        this.inputFormat = null;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        try {
            setSourceDrmSession((DrmSession) null);
            releaseDecoder();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    public void onEnabled(boolean z11, boolean z12) throws ExoPlaybackException {
        DecoderCounters decoderCounters2 = new DecoderCounters();
        this.decoderCounters = decoderCounters2;
        this.eventDispatcher.enabled(decoderCounters2);
        this.mayRenderFirstFrameAfterEnableIfNotStarted = z12;
        this.renderedFirstFrameAfterEnable = false;
    }

    @CallSuper
    public void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluation;
        this.waitingForFirstSampleInFormat = true;
        Format format = (Format) Assertions.checkNotNull(formatHolder.format);
        setSourceDrmSession(formatHolder.drmSession);
        Format format2 = this.inputFormat;
        this.inputFormat = format;
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder2 = this.decoder;
        if (decoder2 == null) {
            maybeInitDecoder();
            this.eventDispatcher.inputFormatChanged(this.inputFormat, (DecoderReuseEvaluation) null);
            return;
        }
        if (this.sourceDrmSession != this.decoderDrmSession) {
            decoderReuseEvaluation = new DecoderReuseEvaluation(decoder2.getName(), format2, format, 0, 128);
        } else {
            decoderReuseEvaluation = canReuseDecoder(decoder2.getName(), format2, format);
        }
        if (decoderReuseEvaluation.result == 0) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
            }
        }
        this.eventDispatcher.inputFormatChanged(this.inputFormat, decoderReuseEvaluation);
    }

    public void onPositionReset(long j11, boolean z11) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        clearRenderedFirstFrame();
        this.initialPositionUs = C.TIME_UNSET;
        this.consecutiveDroppedFrameCount = 0;
        if (this.decoder != null) {
            flushDecoder();
        }
        if (z11) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = C.TIME_UNSET;
        }
        this.formatQueue.clear();
    }

    @CallSuper
    public void onProcessedOutputBuffer(long j11) {
        this.buffersInCodecCount--;
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    public void onStarted() {
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
    }

    public void onStopped() {
        this.joiningDeadlineMs = C.TIME_UNSET;
        maybeNotifyDroppedFrames();
    }

    public void onStreamChanged(Format[] formatArr, long j11, long j12) throws ExoPlaybackException {
        this.outputStreamOffsetUs = j12;
        super.onStreamChanged(formatArr, j11, j12);
    }

    @CallSuper
    public void releaseDecoder() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.buffersInCodecCount = 0;
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder2 = this.decoder;
        if (decoder2 != null) {
            this.decoderCounters.decoderReleaseCount++;
            decoder2.release();
            this.eventDispatcher.decoderReleased(this.decoder.getName());
            this.decoder = null;
        }
        setDecoderDrmSession((DrmSession) null);
    }

    public void render(long j11, long j12) throws ExoPlaybackException {
        if (!this.outputStreamEnded) {
            if (this.inputFormat == null) {
                FormatHolder formatHolder = getFormatHolder();
                this.flagsOnlyBuffer.clear();
                int readSource = readSource(formatHolder, this.flagsOnlyBuffer, 2);
                if (readSource == -5) {
                    onInputFormatChanged(formatHolder);
                } else if (readSource == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                    return;
                } else {
                    return;
                }
            }
            maybeInitDecoder();
            if (this.decoder != null) {
                try {
                    TraceUtil.beginSection("drainAndFeed");
                    while (drainOutputBuffer(j11, j12)) {
                    }
                    while (feedInputBuffer()) {
                    }
                    TraceUtil.endSection();
                    this.decoderCounters.ensureUpdated();
                } catch (DecoderException e11) {
                    Log.e(TAG, "Video codec error", e11);
                    this.eventDispatcher.videoCodecError(e11);
                    throw createRendererException(e11, this.inputFormat, PlaybackException.ERROR_CODE_DECODING_FAILED);
                }
            }
        }
    }

    public void renderOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j11, Format format) throws DecoderException {
        boolean z11;
        boolean z12;
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j11, System.nanoTime(), format, (MediaFormat) null);
        }
        this.lastRenderTimeUs = Util.msToUs(SystemClock.elapsedRealtime() * 1000);
        int i11 = videoDecoderOutputBuffer.mode;
        if (i11 != 1 || this.outputSurface == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i11 != 0 || this.outputBufferRenderer == null) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12 || z11) {
            maybeNotifyVideoSizeChanged(videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height);
            if (z12) {
                this.outputBufferRenderer.setOutputBuffer(videoDecoderOutputBuffer);
            } else {
                renderOutputBufferToSurface(videoDecoderOutputBuffer, this.outputSurface);
            }
            this.consecutiveDroppedFrameCount = 0;
            this.decoderCounters.renderedOutputBufferCount++;
            maybeNotifyRenderedFirstFrame();
            return;
        }
        dropOutputBuffer(videoDecoderOutputBuffer);
    }

    public abstract void renderOutputBufferToSurface(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws DecoderException;

    public abstract void setDecoderOutputMode(int i11);

    public final void setOutput(@Nullable Object obj) {
        if (obj instanceof Surface) {
            this.outputSurface = (Surface) obj;
            this.outputBufferRenderer = null;
            this.outputMode = 1;
        } else if (obj instanceof VideoDecoderOutputBufferRenderer) {
            this.outputSurface = null;
            this.outputBufferRenderer = (VideoDecoderOutputBufferRenderer) obj;
            this.outputMode = 0;
        } else {
            this.outputSurface = null;
            this.outputBufferRenderer = null;
            this.outputMode = -1;
            obj = null;
        }
        if (this.output != obj) {
            this.output = obj;
            if (obj != null) {
                if (this.decoder != null) {
                    setDecoderOutputMode(this.outputMode);
                }
                onOutputChanged();
                return;
            }
            onOutputRemoved();
        } else if (obj != null) {
            onOutputReset();
        }
    }

    public boolean shouldDropBuffersToKeyframe(long j11, long j12) {
        return isBufferVeryLate(j11);
    }

    public boolean shouldDropOutputBuffer(long j11, long j12) {
        return isBufferLate(j11);
    }

    public boolean shouldForceRenderOutputBuffer(long j11, long j12) {
        return isBufferLate(j11) && j12 > 100000;
    }

    public void skipOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.decoderCounters.skippedOutputBufferCount++;
        videoDecoderOutputBuffer.release();
    }

    public void updateDroppedBufferCounters(int i11, int i12) {
        DecoderCounters decoderCounters2 = this.decoderCounters;
        decoderCounters2.droppedInputBufferCount += i11;
        int i13 = i11 + i12;
        decoderCounters2.droppedBufferCount += i13;
        this.droppedFrames += i13;
        int i14 = this.consecutiveDroppedFrameCount + i13;
        this.consecutiveDroppedFrameCount = i14;
        decoderCounters2.maxConsecutiveDroppedBufferCount = Math.max(i14, decoderCounters2.maxConsecutiveDroppedBufferCount);
        int i15 = this.maxDroppedFramesToNotify;
        if (i15 > 0 && this.droppedFrames >= i15) {
            maybeNotifyDroppedFrames();
        }
    }
}
