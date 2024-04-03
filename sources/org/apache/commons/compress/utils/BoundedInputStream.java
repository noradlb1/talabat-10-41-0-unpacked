package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;

public class BoundedInputStream extends InputStream {
    private long bytesRemaining;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f27771in;

    public BoundedInputStream(InputStream inputStream, long j11) {
        this.f27771in = inputStream;
        this.bytesRemaining = j11;
    }

    public void close() {
    }

    public long getBytesRemaining() {
        return this.bytesRemaining;
    }

    public int read() throws IOException {
        long j11 = this.bytesRemaining;
        if (j11 <= 0) {
            return -1;
        }
        this.bytesRemaining = j11 - 1;
        return this.f27771in.read();
    }

    public long skip(long j11) throws IOException {
        long skip = this.f27771in.skip(Math.min(this.bytesRemaining, j11));
        this.bytesRemaining -= skip;
        return skip;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.bytesRemaining;
        if (j11 == 0) {
            return -1;
        }
        if (((long) i12) > j11) {
            i12 = (int) j11;
        }
        int read = this.f27771in.read(bArr, i11, i12);
        if (read >= 0) {
            this.bytesRemaining -= (long) read;
        }
        return read;
    }
}
