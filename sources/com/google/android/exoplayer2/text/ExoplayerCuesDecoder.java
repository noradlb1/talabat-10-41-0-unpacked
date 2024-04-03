package com.google.android.exoplayer2.text;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public final class ExoplayerCuesDecoder implements SubtitleDecoder {
    private static final int INPUT_BUFFER_AVAILABLE = 0;
    private static final int INPUT_BUFFER_DEQUEUED = 1;
    private static final int INPUT_BUFFER_QUEUED = 2;
    private static final int OUTPUT_BUFFERS_COUNT = 2;
    private final Deque<SubtitleOutputBuffer> availableOutputBuffers = new ArrayDeque();
    private final CueDecoder cueDecoder = new CueDecoder();
    private final SubtitleInputBuffer inputBuffer = new SubtitleInputBuffer();
    private int inputBufferState;
    private boolean released;

    public static final class SingleEventSubtitle implements Subtitle {
        private final ImmutableList<Cue> cues;
        private final long timeUs;

        public SingleEventSubtitle(long j11, ImmutableList<Cue> immutableList) {
            this.timeUs = j11;
            this.cues = immutableList;
        }

        public List<Cue> getCues(long j11) {
            return j11 >= this.timeUs ? this.cues : ImmutableList.of();
        }

        public long getEventTime(int i11) {
            boolean z11;
            if (i11 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkArgument(z11);
            return this.timeUs;
        }

        public int getEventTimeCount() {
            return 1;
        }

        public int getNextEventTimeIndex(long j11) {
            return this.timeUs > j11 ? 0 : -1;
        }
    }

    public ExoplayerCuesDecoder() {
        for (int i11 = 0; i11 < 2; i11++) {
            this.availableOutputBuffers.addFirst(new SubtitleOutputBuffer() {
                public void release() {
                    ExoplayerCuesDecoder.this.releaseOutputBuffer(this);
                }
            });
        }
        this.inputBufferState = 0;
    }

    /* access modifiers changed from: private */
    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        boolean z11;
        if (this.availableOutputBuffers.size() < 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        Assertions.checkArgument(!this.availableOutputBuffers.contains(subtitleOutputBuffer));
        subtitleOutputBuffer.clear();
        this.availableOutputBuffers.addFirst(subtitleOutputBuffer);
    }

    public void flush() {
        Assertions.checkState(!this.released);
        this.inputBuffer.clear();
        this.inputBufferState = 0;
    }

    public String getName() {
        return "ExoplayerCuesDecoder";
    }

    public void release() {
        this.released = true;
    }

    public void setPositionUs(long j11) {
    }

    @Nullable
    public SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        Assertions.checkState(!this.released);
        if (this.inputBufferState != 0) {
            return null;
        }
        this.inputBufferState = 1;
        return this.inputBuffer;
    }

    @Nullable
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        Assertions.checkState(!this.released);
        if (this.inputBufferState != 2 || this.availableOutputBuffers.isEmpty()) {
            return null;
        }
        SubtitleOutputBuffer removeFirst = this.availableOutputBuffers.removeFirst();
        if (this.inputBuffer.isEndOfStream()) {
            removeFirst.addFlag(4);
        } else {
            SubtitleInputBuffer subtitleInputBuffer = this.inputBuffer;
            SingleEventSubtitle singleEventSubtitle = new SingleEventSubtitle(subtitleInputBuffer.timeUs, this.cueDecoder.decode(((ByteBuffer) Assertions.checkNotNull(subtitleInputBuffer.data)).array()));
            removeFirst.setContent(this.inputBuffer.timeUs, singleEventSubtitle, 0);
        }
        this.inputBuffer.clear();
        this.inputBufferState = 0;
        return removeFirst;
    }

    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        boolean z11 = true;
        Assertions.checkState(!this.released);
        Assertions.checkState(this.inputBufferState == 1);
        if (this.inputBuffer != subtitleInputBuffer) {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        this.inputBufferState = 2;
    }
}
