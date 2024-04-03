package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@ElementTypesAreNonnullByDefault
abstract class AbstractStreamingHasher extends AbstractHasher {
    private final ByteBuffer buffer;
    private final int bufferSize;
    private final int chunkSize;

    public AbstractStreamingHasher(int i11) {
        this(i11, i11);
    }

    private void munch() {
        Java8Compatibility.flip(this.buffer);
        while (this.buffer.remaining() >= this.chunkSize) {
            process(this.buffer);
        }
        this.buffer.compact();
    }

    private void munchIfFull() {
        if (this.buffer.remaining() < 8) {
            munch();
        }
    }

    @CanIgnoreReturnValue
    private Hasher putBytesInternal(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.buffer.remaining()) {
            this.buffer.put(byteBuffer);
            munchIfFull();
            return this;
        }
        int position = this.bufferSize - this.buffer.position();
        for (int i11 = 0; i11 < position; i11++) {
            this.buffer.put(byteBuffer.get());
        }
        munch();
        while (byteBuffer.remaining() >= this.chunkSize) {
            process(byteBuffer);
        }
        this.buffer.put(byteBuffer);
        return this;
    }

    public final HashCode hash() {
        munch();
        Java8Compatibility.flip(this.buffer);
        if (this.buffer.remaining() > 0) {
            processRemaining(this.buffer);
            ByteBuffer byteBuffer = this.buffer;
            Java8Compatibility.position(byteBuffer, byteBuffer.limit());
        }
        return makeHash();
    }

    public abstract HashCode makeHash();

    public abstract void process(ByteBuffer byteBuffer);

    public void processRemaining(ByteBuffer byteBuffer) {
        Java8Compatibility.position(byteBuffer, byteBuffer.limit());
        Java8Compatibility.limit(byteBuffer, this.chunkSize + 7);
        while (true) {
            int position = byteBuffer.position();
            int i11 = this.chunkSize;
            if (position < i11) {
                byteBuffer.putLong(0);
            } else {
                Java8Compatibility.limit(byteBuffer, i11);
                Java8Compatibility.flip(byteBuffer);
                process(byteBuffer);
                return;
            }
        }
    }

    public AbstractStreamingHasher(int i11, int i12) {
        Preconditions.checkArgument(i12 % i11 == 0);
        this.buffer = ByteBuffer.allocate(i12 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.bufferSize = i12;
        this.chunkSize = i11;
    }

    @CanIgnoreReturnValue
    public final Hasher putByte(byte b11) {
        this.buffer.put(b11);
        munchIfFull();
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher putChar(char c11) {
        this.buffer.putChar(c11);
        munchIfFull();
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher putInt(int i11) {
        this.buffer.putInt(i11);
        munchIfFull();
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher putLong(long j11) {
        this.buffer.putLong(j11);
        munchIfFull();
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher putShort(short s11) {
        this.buffer.putShort(s11);
        munchIfFull();
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher putBytes(byte[] bArr, int i11, int i12) {
        return putBytesInternal(ByteBuffer.wrap(bArr, i11, i12).order(ByteOrder.LITTLE_ENDIAN));
    }

    /* JADX INFO: finally extract failed */
    @CanIgnoreReturnValue
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            Hasher putBytesInternal = putBytesInternal(byteBuffer);
            byteBuffer.order(order);
            return putBytesInternal;
        } catch (Throwable th2) {
            byteBuffer.order(order);
            throw th2;
        }
    }
}
