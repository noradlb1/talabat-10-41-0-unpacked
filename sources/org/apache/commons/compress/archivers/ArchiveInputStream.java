package org.apache.commons.compress.archivers;

import java.io.IOException;
import java.io.InputStream;

public abstract class ArchiveInputStream extends InputStream {
    private static final int BYTE_MASK = 255;
    private long bytesRead;
    private final byte[] single = new byte[1];

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        return true;
    }

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

    public abstract ArchiveEntry getNextEntry() throws IOException;

    public void pushedBackBytes(long j11) {
        this.bytesRead -= j11;
    }

    public int read() throws IOException {
        if (read(this.single, 0, 1) == -1) {
            return -1;
        }
        return this.single[0] & 255;
    }

    public void count(long j11) {
        if (j11 != -1) {
            this.bytesRead += j11;
        }
    }
}
