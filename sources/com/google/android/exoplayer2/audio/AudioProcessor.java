package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public interface AudioProcessor {
    public static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class AudioFormat {
        public static final AudioFormat NOT_SET = new AudioFormat(-1, -1, -1);
        public final int bytesPerFrame;
        public final int channelCount;
        public final int encoding;
        public final int sampleRate;

        public AudioFormat(int i11, int i12, int i13) {
            int i14;
            this.sampleRate = i11;
            this.channelCount = i12;
            this.encoding = i13;
            if (Util.isEncodingLinearPcm(i13)) {
                i14 = Util.getPcmFrameSize(i13, i12);
            } else {
                i14 = -1;
            }
            this.bytesPerFrame = i14;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioFormat)) {
                return false;
            }
            AudioFormat audioFormat = (AudioFormat) obj;
            if (this.sampleRate == audioFormat.sampleRate && this.channelCount == audioFormat.channelCount && this.encoding == audioFormat.encoding) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.sampleRate), Integer.valueOf(this.channelCount), Integer.valueOf(this.encoding));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", encoding=" + this.encoding + AbstractJsonLexerKt.END_LIST;
        }
    }

    public static final class UnhandledAudioFormatException extends Exception {
        public UnhandledAudioFormatException(AudioFormat audioFormat) {
            super("Unhandled format: " + audioFormat);
        }
    }

    @CanIgnoreReturnValue
    AudioFormat configure(AudioFormat audioFormat) throws UnhandledAudioFormatException;

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer byteBuffer);

    void reset();
}
