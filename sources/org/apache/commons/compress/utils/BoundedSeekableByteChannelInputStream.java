package org.apache.commons.compress.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

public class BoundedSeekableByteChannelInputStream extends BoundedArchiveInputStream {
    private final SeekableByteChannel channel;

    public BoundedSeekableByteChannelInputStream(long j11, long j12, SeekableByteChannel seekableByteChannel) {
        super(j11, j12);
        this.channel = seekableByteChannel;
    }

    public int read(long j11, ByteBuffer byteBuffer) throws IOException {
        int a11;
        synchronized (this.channel) {
            SeekableByteChannel unused = this.channel.position(j11);
            a11 = this.channel.read(byteBuffer);
        }
        byteBuffer.flip();
        return a11;
    }
}
