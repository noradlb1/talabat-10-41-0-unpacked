package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Format;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class DecoderInputBuffer extends Buffer {
    public static final int BUFFER_REPLACEMENT_MODE_DIRECT = 2;
    public static final int BUFFER_REPLACEMENT_MODE_DISABLED = 0;
    public static final int BUFFER_REPLACEMENT_MODE_NORMAL = 1;
    private final int bufferReplacementMode;
    public final CryptoInfo cryptoInfo;
    @Nullable
    public ByteBuffer data;
    @Nullable
    public Format format;
    private final int paddingSize;
    @Nullable
    public ByteBuffer supplementalData;
    public long timeUs;
    public boolean waitingForKeys;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BufferReplacementMode {
    }

    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int currentCapacity;
        public final int requiredCapacity;

        public InsufficientCapacityException(int i11, int i12) {
            super("Buffer too small (" + i11 + " < " + i12 + ")");
            this.currentCapacity = i11;
            this.requiredCapacity = i12;
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.decoder");
    }

    public DecoderInputBuffer(int i11) {
        this(i11, 0);
    }

    private ByteBuffer createReplacementByteBuffer(int i11) {
        int i12;
        int i13 = this.bufferReplacementMode;
        if (i13 == 1) {
            return ByteBuffer.allocate(i11);
        }
        if (i13 == 2) {
            return ByteBuffer.allocateDirect(i11);
        }
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            i12 = 0;
        } else {
            i12 = byteBuffer.capacity();
        }
        throw new InsufficientCapacityException(i12, i11);
    }

    public static DecoderInputBuffer newNoDataInstance() {
        return new DecoderInputBuffer(0);
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.supplementalData;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.waitingForKeys = false;
    }

    @EnsuresNonNull({"data"})
    public void ensureSpaceForWrite(int i11) {
        int i12 = i11 + this.paddingSize;
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            this.data = createReplacementByteBuffer(i12);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i13 = i12 + position;
        if (capacity >= i13) {
            this.data = byteBuffer;
            return;
        }
        ByteBuffer createReplacementByteBuffer = createReplacementByteBuffer(i13);
        createReplacementByteBuffer.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            createReplacementByteBuffer.put(byteBuffer);
        }
        this.data = createReplacementByteBuffer;
    }

    public final void flip() {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.supplementalData;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean isEncrypted() {
        return getFlag(1073741824);
    }

    @EnsuresNonNull({"supplementalData"})
    public void resetSupplementalData(int i11) {
        ByteBuffer byteBuffer = this.supplementalData;
        if (byteBuffer == null || byteBuffer.capacity() < i11) {
            this.supplementalData = ByteBuffer.allocate(i11);
        } else {
            this.supplementalData.clear();
        }
    }

    public DecoderInputBuffer(int i11, int i12) {
        this.cryptoInfo = new CryptoInfo();
        this.bufferReplacementMode = i11;
        this.paddingSize = i12;
    }
}
