package org.apache.commons.compress.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SeekableByteChannel;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class SeekableInMemoryByteChannel implements SeekableByteChannel {
    private static final int NAIVE_RESIZE_LIMIT = 1073741823;
    private final AtomicBoolean closed;
    private byte[] data;
    private int position;
    private int size;

    public SeekableInMemoryByteChannel(byte[] bArr) {
        this.closed = new AtomicBoolean();
        this.data = bArr;
        this.size = bArr.length;
    }

    private void ensureOpen() throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    private void resize(int i11) {
        int length = this.data.length;
        if (length <= 0) {
            length = 1;
        }
        if (i11 < 1073741823) {
            while (length < i11) {
                length <<= 1;
            }
            i11 = length;
        }
        this.data = Arrays.copyOf(this.data, i11);
    }

    public byte[] array() {
        return this.data;
    }

    public void close() {
        this.closed.set(true);
    }

    public boolean isOpen() {
        return !this.closed.get();
    }

    public long position() {
        return (long) this.position;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        ensureOpen();
        int remaining = byteBuffer.remaining();
        int i11 = this.size;
        int i12 = this.position;
        int i13 = i11 - i12;
        if (i13 <= 0) {
            return -1;
        }
        if (remaining > i13) {
            remaining = i13;
        }
        byteBuffer.put(this.data, i12, remaining);
        this.position += remaining;
        return remaining;
    }

    public long size() {
        return (long) this.size;
    }

    public SeekableByteChannel truncate(long j11) {
        if (j11 < 0 || j11 > 2147483647L) {
            throw new IllegalArgumentException("Size has to be in range 0.. 2147483647");
        }
        if (((long) this.size) > j11) {
            this.size = (int) j11;
        }
        if (((long) this.position) > j11) {
            this.position = (int) j11;
        }
        return this;
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        ensureOpen();
        int remaining = byteBuffer.remaining();
        int i11 = this.size;
        int i12 = this.position;
        if (remaining > i11 - i12) {
            int i13 = i12 + remaining;
            if (i13 < 0) {
                resize(Integer.MAX_VALUE);
                remaining = Integer.MAX_VALUE - this.position;
            } else {
                resize(i13);
            }
        }
        byteBuffer.get(this.data, this.position, remaining);
        int i14 = this.position + remaining;
        this.position = i14;
        if (this.size < i14) {
            this.size = i14;
        }
        return remaining;
    }

    public SeekableByteChannel position(long j11) throws IOException {
        ensureOpen();
        if (j11 < 0 || j11 > 2147483647L) {
            throw new IOException("Position has to be in range 0.. 2147483647");
        }
        this.position = (int) j11;
        return this;
    }

    public SeekableInMemoryByteChannel() {
        this(ByteUtils.EMPTY_BYTE_ARRAY);
    }

    public SeekableInMemoryByteChannel(int i11) {
        this(new byte[i11]);
    }
}
