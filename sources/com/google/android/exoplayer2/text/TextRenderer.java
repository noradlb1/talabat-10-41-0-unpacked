package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import g7.c1;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    private static final int MSG_UPDATE_OUTPUT = 0;
    private static final int REPLACEMENT_STATE_NONE = 0;
    private static final int REPLACEMENT_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REPLACEMENT_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "TextRenderer";
    @Nullable
    private SubtitleDecoder decoder;
    private final SubtitleDecoderFactory decoderFactory;
    private int decoderReplacementState;
    private long finalStreamEndPositionUs;
    private final FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private long lastRendererPositionUs;
    @Nullable
    private SubtitleInputBuffer nextInputBuffer;
    @Nullable
    private SubtitleOutputBuffer nextSubtitle;
    private int nextSubtitleEventIndex;
    private final TextOutput output;
    @Nullable
    private final Handler outputHandler;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    @Nullable
    private Format streamFormat;
    @Nullable
    private SubtitleOutputBuffer subtitle;
    private boolean waitingForKeyFrame;

    public TextRenderer(TextOutput textOutput, @Nullable Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.DEFAULT);
    }

    private void clearOutput() {
        updateOutput(new CueGroup(ImmutableList.of(), getPresentationTimeUs(this.lastRendererPositionUs)));
    }

    @SideEffectFree
    @RequiresNonNull({"subtitle"})
    private long getCurrentEventTimeUs(long j11) {
        int nextEventTimeIndex = this.subtitle.getNextEventTimeIndex(j11);
        if (nextEventTimeIndex == 0 || this.subtitle.getEventTimeCount() == 0) {
            return this.subtitle.timeUs;
        }
        if (nextEventTimeIndex != -1) {
            return this.subtitle.getEventTime(nextEventTimeIndex - 1);
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.subtitle;
        return subtitleOutputBuffer.getEventTime(subtitleOutputBuffer.getEventTimeCount() - 1);
    }

    private long getNextEventTime() {
        if (this.nextSubtitleEventIndex == -1) {
            return Long.MAX_VALUE;
        }
        Assertions.checkNotNull(this.subtitle);
        if (this.nextSubtitleEventIndex >= this.subtitle.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.subtitle.getEventTime(this.nextSubtitleEventIndex);
    }

    @SideEffectFree
    private long getPresentationTimeUs(long j11) {
        boolean z11;
        boolean z12 = true;
        if (j11 != C.TIME_UNSET) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        if (this.outputStreamOffsetUs == C.TIME_UNSET) {
            z12 = false;
        }
        Assertions.checkState(z12);
        return j11 - this.outputStreamOffsetUs;
    }

    private void handleDecoderError(SubtitleDecoderException subtitleDecoderException) {
        Log.e(TAG, "Subtitle decoding failed. streamFormat=" + this.streamFormat, subtitleDecoderException);
        clearOutput();
        replaceDecoder();
    }

    private void initDecoder() {
        this.waitingForKeyFrame = true;
        this.decoder = this.decoderFactory.createDecoder((Format) Assertions.checkNotNull(this.streamFormat));
    }

    private void invokeUpdateOutputInternal(CueGroup cueGroup) {
        this.output.onCues((List<Cue>) cueGroup.cues);
        this.output.onCues(cueGroup);
    }

    private void releaseBuffers() {
        this.nextInputBuffer = null;
        this.nextSubtitleEventIndex = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.subtitle;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.release();
            this.subtitle = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.nextSubtitle;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.release();
            this.nextSubtitle = null;
        }
    }

    private void releaseDecoder() {
        releaseBuffers();
        ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).release();
        this.decoder = null;
        this.decoderReplacementState = 0;
    }

    private void replaceDecoder() {
        releaseDecoder();
        initDecoder();
    }

    private void updateOutput(CueGroup cueGroup) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, cueGroup).sendToTarget();
        } else {
            invokeUpdateOutputInternal(cueGroup);
        }
    }

    public String getName() {
        return TAG;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            invokeUpdateOutputInternal((CueGroup) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        return true;
    }

    public void onDisabled() {
        this.streamFormat = null;
        this.finalStreamEndPositionUs = C.TIME_UNSET;
        clearOutput();
        this.outputStreamOffsetUs = C.TIME_UNSET;
        this.lastRendererPositionUs = C.TIME_UNSET;
        releaseDecoder();
    }

    public void onPositionReset(long j11, boolean z11) {
        this.lastRendererPositionUs = j11;
        clearOutput();
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.finalStreamEndPositionUs = C.TIME_UNSET;
        if (this.decoderReplacementState != 0) {
            replaceDecoder();
            return;
        }
        releaseBuffers();
        ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).flush();
    }

    public void onStreamChanged(Format[] formatArr, long j11, long j12) {
        this.outputStreamOffsetUs = j12;
        this.streamFormat = formatArr[0];
        if (this.decoder != null) {
            this.decoderReplacementState = 1;
        } else {
            initDecoder();
        }
    }

    public void render(long j11, long j12) {
        boolean z11;
        boolean z12;
        this.lastRendererPositionUs = j11;
        if (isCurrentStreamFinal()) {
            long j13 = this.finalStreamEndPositionUs;
            if (j13 != C.TIME_UNSET && j11 >= j13) {
                releaseBuffers();
                this.outputStreamEnded = true;
            }
        }
        if (!this.outputStreamEnded) {
            if (this.nextSubtitle == null) {
                ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).setPositionUs(j11);
                try {
                    this.nextSubtitle = (SubtitleOutputBuffer) ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).dequeueOutputBuffer();
                } catch (SubtitleDecoderException e11) {
                    handleDecoderError(e11);
                    return;
                }
            }
            if (getState() == 2) {
                if (this.subtitle != null) {
                    long nextEventTime = getNextEventTime();
                    z11 = false;
                    while (nextEventTime <= j11) {
                        this.nextSubtitleEventIndex++;
                        nextEventTime = getNextEventTime();
                        z11 = true;
                    }
                } else {
                    z11 = false;
                }
                SubtitleOutputBuffer subtitleOutputBuffer = this.nextSubtitle;
                if (subtitleOutputBuffer != null) {
                    if (subtitleOutputBuffer.isEndOfStream()) {
                        if (!z11 && getNextEventTime() == Long.MAX_VALUE) {
                            if (this.decoderReplacementState == 2) {
                                replaceDecoder();
                            } else {
                                releaseBuffers();
                                this.outputStreamEnded = true;
                            }
                        }
                    } else if (subtitleOutputBuffer.timeUs <= j11) {
                        SubtitleOutputBuffer subtitleOutputBuffer2 = this.subtitle;
                        if (subtitleOutputBuffer2 != null) {
                            subtitleOutputBuffer2.release();
                        }
                        this.nextSubtitleEventIndex = subtitleOutputBuffer.getNextEventTimeIndex(j11);
                        this.subtitle = subtitleOutputBuffer;
                        this.nextSubtitle = null;
                        z11 = true;
                    }
                }
                if (z11) {
                    Assertions.checkNotNull(this.subtitle);
                    updateOutput(new CueGroup(this.subtitle.getCues(j11), getPresentationTimeUs(getCurrentEventTimeUs(j11))));
                }
                if (this.decoderReplacementState != 2) {
                    while (!this.inputStreamEnded) {
                        try {
                            SubtitleInputBuffer subtitleInputBuffer = this.nextInputBuffer;
                            if (subtitleInputBuffer == null) {
                                subtitleInputBuffer = (SubtitleInputBuffer) ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).dequeueInputBuffer();
                                if (subtitleInputBuffer != null) {
                                    this.nextInputBuffer = subtitleInputBuffer;
                                } else {
                                    return;
                                }
                            }
                            if (this.decoderReplacementState == 1) {
                                subtitleInputBuffer.setFlags(4);
                                ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).queueInputBuffer(subtitleInputBuffer);
                                this.nextInputBuffer = null;
                                this.decoderReplacementState = 2;
                                return;
                            }
                            int readSource = readSource(this.formatHolder, subtitleInputBuffer, 0);
                            if (readSource == -4) {
                                if (subtitleInputBuffer.isEndOfStream()) {
                                    this.inputStreamEnded = true;
                                    this.waitingForKeyFrame = false;
                                } else {
                                    Format format = this.formatHolder.format;
                                    if (format != null) {
                                        subtitleInputBuffer.subsampleOffsetUs = format.subsampleOffsetUs;
                                        subtitleInputBuffer.flip();
                                        boolean z13 = this.waitingForKeyFrame;
                                        if (!subtitleInputBuffer.isKeyFrame()) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                        this.waitingForKeyFrame = z13 & z12;
                                    } else {
                                        return;
                                    }
                                }
                                if (!this.waitingForKeyFrame) {
                                    ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).queueInputBuffer(subtitleInputBuffer);
                                    this.nextInputBuffer = null;
                                }
                            } else if (readSource == -3) {
                                return;
                            }
                        } catch (SubtitleDecoderException e12) {
                            handleDecoderError(e12);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void setFinalStreamEndPositionUs(long j11) {
        Assertions.checkState(isCurrentStreamFinal());
        this.finalStreamEndPositionUs = j11;
    }

    public int supportsFormat(Format format) {
        int i11;
        if (this.decoderFactory.supportsFormat(format)) {
            if (format.cryptoType == 0) {
                i11 = 4;
            } else {
                i11 = 2;
            }
            return c1.a(i11);
        } else if (MimeTypes.isText(format.sampleMimeType)) {
            return c1.a(1);
        } else {
            return c1.a(0);
        }
    }

    public TextRenderer(TextOutput textOutput, @Nullable Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        Handler handler;
        this.output = (TextOutput) Assertions.checkNotNull(textOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = Util.createHandler(looper, this);
        }
        this.outputHandler = handler;
        this.decoderFactory = subtitleDecoderFactory;
        this.formatHolder = new FormatHolder();
        this.finalStreamEndPositionUs = C.TIME_UNSET;
        this.outputStreamOffsetUs = C.TIME_UNSET;
        this.lastRendererPositionUs = C.TIME_UNSET;
    }
}
