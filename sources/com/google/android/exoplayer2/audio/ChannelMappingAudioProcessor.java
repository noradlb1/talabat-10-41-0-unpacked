package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;

final class ChannelMappingAudioProcessor extends BaseAudioProcessor {
    @Nullable
    private int[] outputChannels;
    @Nullable
    private int[] pendingOutputChannels;

    @CanIgnoreReturnValue
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        boolean z11;
        boolean z12;
        int[] iArr = this.pendingOutputChannels;
        if (iArr == null) {
            return AudioProcessor.AudioFormat.NOT_SET;
        }
        if (audioFormat.encoding == 2) {
            if (audioFormat.channelCount != iArr.length) {
                z11 = true;
            } else {
                z11 = false;
            }
            int i11 = 0;
            while (i11 < iArr.length) {
                int i12 = iArr[i11];
                if (i12 < audioFormat.channelCount) {
                    if (i12 != i11) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z11 |= z12;
                    i11++;
                } else {
                    throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
                }
            }
            if (z11) {
                return new AudioProcessor.AudioFormat(audioFormat.sampleRate, iArr.length, 2);
            }
            return AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    public void onFlush() {
        this.outputChannels = this.pendingOutputChannels;
    }

    public void onReset() {
        this.outputChannels = null;
        this.pendingOutputChannels = null;
    }

    public void queueInput(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) Assertions.checkNotNull(this.outputChannels);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer replaceOutputBuffer = replaceOutputBuffer(((limit - position) / this.inputAudioFormat.bytesPerFrame) * this.outputAudioFormat.bytesPerFrame);
        while (position < limit) {
            for (int i11 : iArr) {
                replaceOutputBuffer.putShort(byteBuffer.getShort((i11 * 2) + position));
            }
            position += this.inputAudioFormat.bytesPerFrame;
        }
        byteBuffer.position(limit);
        replaceOutputBuffer.flip();
    }

    public void setChannelMap(@Nullable int[] iArr) {
        this.pendingOutputChannels = iArr;
    }
}
