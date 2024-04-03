package org.apache.commons.compress.compressors;

import java.io.InputStream;

public abstract class CompressorInputStream extends InputStream {
    private long bytesRead;

    public void count(int i11) {
        count((long) i11);
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesRead;
    }

    public long getUncompressedCount() {
        return getBytesRead();
    }

    public void pushedBackBytes(long j11) {
        this.bytesRead -= j11;
    }

    public void count(long j11) {
        if (j11 != -1) {
            this.bytesRead += j11;
        }
    }
}
