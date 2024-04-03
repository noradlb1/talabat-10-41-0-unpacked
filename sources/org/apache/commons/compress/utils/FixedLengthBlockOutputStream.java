package org.apache.commons.compress.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedLengthBlockOutputStream extends OutputStream implements WritableByteChannel {
    private final int blockSize;
    private final ByteBuffer buffer;
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final WritableByteChannel out;

    public static class BufferAtATimeOutputChannel implements WritableByteChannel {
        private final AtomicBoolean closed;
        private final OutputStream out;

        public void close() throws IOException {
            if (this.closed.compareAndSet(false, true)) {
                this.out.close();
            }
        }

        public boolean isOpen() {
            return !this.closed.get();
        }

        public int write(ByteBuffer byteBuffer) throws IOException {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (byteBuffer.hasArray()) {
                try {
                    int position = byteBuffer.position();
                    int limit = byteBuffer.limit() - position;
                    this.out.write(byteBuffer.array(), byteBuffer.arrayOffset() + position, limit);
                    byteBuffer.position(byteBuffer.limit());
                    return limit;
                } catch (IOException e11) {
                    try {
                        close();
                    } catch (IOException unused) {
                    }
                    throw e11;
                }
            } else {
                throw new IOException("Direct buffer somehow written to BufferAtATimeOutputChannel");
            }
        }

        private BufferAtATimeOutputChannel(OutputStream outputStream) {
            this.closed = new AtomicBoolean(false);
            this.out = outputStream;
        }
    }

    public FixedLengthBlockOutputStream(OutputStream outputStream, int i11) {
        if (outputStream instanceof FileOutputStream) {
            this.out = ((FileOutputStream) outputStream).getChannel();
            this.buffer = ByteBuffer.allocateDirect(i11);
        } else {
            this.out = new BufferAtATimeOutputChannel(outputStream);
            this.buffer = ByteBuffer.allocate(i11);
        }
        this.blockSize = i11;
    }

    private void maybeFlush() throws IOException {
        if (!this.buffer.hasRemaining()) {
            writeBlock();
        }
    }

    private void padBlock() {
        this.buffer.order(ByteOrder.nativeOrder());
        int remaining = this.buffer.remaining();
        if (remaining > 8) {
            int position = this.buffer.position() & 7;
            if (position != 0) {
                int i11 = 8 - position;
                for (int i12 = 0; i12 < i11; i12++) {
                    this.buffer.put((byte) 0);
                }
                remaining -= i11;
            }
            while (remaining >= 8) {
                this.buffer.putLong(0);
                remaining -= 8;
            }
        }
        while (this.buffer.hasRemaining()) {
            this.buffer.put((byte) 0);
        }
    }

    private void writeBlock() throws IOException {
        this.buffer.flip();
        int write = this.out.write(this.buffer);
        boolean hasRemaining = this.buffer.hasRemaining();
        int i11 = this.blockSize;
        if (write != i11 || hasRemaining) {
            throw new IOException(String.format("Failed to write %,d bytes atomically. Only wrote  %,d", new Object[]{Integer.valueOf(i11), Integer.valueOf(write)}));
        } else {
            this.buffer.clear();
        }
    }

    public void close() throws IOException {
        if (this.closed.compareAndSet(false, true)) {
            try {
                flushBlock();
            } finally {
                this.out.close();
            }
        }
    }

    public void flushBlock() throws IOException {
        if (this.buffer.position() != 0) {
            padBlock();
            writeBlock();
        }
    }

    public boolean isOpen() {
        if (!this.out.isOpen()) {
            this.closed.set(true);
        }
        return !this.closed.get();
    }

    public void write(int i11) throws IOException {
        if (isOpen()) {
            this.buffer.put((byte) i11);
            maybeFlush();
            return;
        }
        throw new ClosedChannelException();
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        if (isOpen()) {
            while (i12 > 0) {
                int min = Math.min(i12, this.buffer.remaining());
                this.buffer.put(bArr, i11, min);
                maybeFlush();
                i12 -= min;
                i11 += min;
            }
            return;
        }
        throw new ClosedChannelException();
    }

    public FixedLengthBlockOutputStream(WritableByteChannel writableByteChannel, int i11) {
        this.out = writableByteChannel;
        this.blockSize = i11;
        this.buffer = ByteBuffer.allocateDirect(i11);
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        int i11;
        if (isOpen()) {
            int remaining = byteBuffer.remaining();
            if (remaining < this.buffer.remaining()) {
                this.buffer.put(byteBuffer);
            } else {
                int limit = byteBuffer.limit();
                if (this.buffer.position() != 0) {
                    int remaining2 = this.buffer.remaining();
                    byteBuffer.limit(byteBuffer.position() + remaining2);
                    this.buffer.put(byteBuffer);
                    writeBlock();
                    i11 = remaining - remaining2;
                } else {
                    i11 = remaining;
                }
                while (i11 >= this.blockSize) {
                    byteBuffer.limit(byteBuffer.position() + this.blockSize);
                    this.out.write(byteBuffer);
                    i11 -= this.blockSize;
                }
                byteBuffer.limit(limit);
                this.buffer.put(byteBuffer);
            }
            return remaining;
        }
        throw new ClosedChannelException();
    }
}
