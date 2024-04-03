package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;

public abstract class SeekableInputStream extends InputStream {
    public abstract long length() throws IOException;

    public abstract long position() throws IOException;

    public abstract void seek(long j11) throws IOException;

    public long skip(long j11) throws IOException {
        if (j11 <= 0) {
            return 0;
        }
        long length = length();
        long position = position();
        if (position >= length) {
            return 0;
        }
        long j12 = length - position;
        if (j12 < j11) {
            j11 = j12;
        }
        seek(position + j11);
        return j11;
    }
}
