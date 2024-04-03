package org.apache.commons.compress.archivers.sevenz;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

class BoundedSeekableByteChannelInputStream extends InputStream {
    private static final int MAX_BUF_LEN = 8192;
    private final ByteBuffer buffer;
    private long bytesRemaining;
    private final SeekableByteChannel channel;

    public BoundedSeekableByteChannelInputStream(SeekableByteChannel seekableByteChannel, long j11) {
        this.channel = seekableByteChannel;
        this.bytesRemaining = j11;
        if (j11 >= PlaybackStateCompat.ACTION_PLAY_FROM_URI || j11 <= 0) {
            this.buffer = ByteBuffer.allocate(8192);
        } else {
            this.buffer = ByteBuffer.allocate((int) j11);
        }
    }

    public void close() {
    }

    public int read() throws IOException {
        long j11 = this.bytesRemaining;
        if (j11 <= 0) {
            return -1;
        }
        this.bytesRemaining = j11 - 1;
        int read = read(1);
        if (read < 0) {
            return read;
        }
        return this.buffer.get() & 255;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        ByteBuffer byteBuffer;
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.bytesRemaining;
        if (j11 <= 0) {
            return -1;
        }
        if (((long) i12) > j11) {
            i12 = (int) j11;
        }
        if (i12 <= this.buffer.capacity()) {
            byteBuffer = this.buffer;
            i13 = read(i12);
        } else {
            byteBuffer = ByteBuffer.allocate(i12);
            i13 = this.channel.read(byteBuffer);
            byteBuffer.flip();
        }
        if (i13 >= 0) {
            byteBuffer.get(bArr, i11, i13);
            this.bytesRemaining -= (long) i13;
        }
        return i13;
    }

    private int read(int i11) throws IOException {
        this.buffer.rewind().limit(i11);
        int a11 = this.channel.read(this.buffer);
        this.buffer.flip();
        return a11;
    }
}
