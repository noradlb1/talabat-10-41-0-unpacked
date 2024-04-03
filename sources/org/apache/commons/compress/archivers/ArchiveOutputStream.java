package org.apache.commons.compress.archivers;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.LinkOption;
import java.nio.file.Path;

public abstract class ArchiveOutputStream extends OutputStream {
    static final int BYTE_MASK = 255;
    private long bytesWritten;
    private final byte[] oneByte = new byte[1];

    public boolean canWriteEntryData(ArchiveEntry archiveEntry) {
        return true;
    }

    public abstract void closeArchiveEntry() throws IOException;

    public void count(int i11) {
        count((long) i11);
    }

    public abstract ArchiveEntry createArchiveEntry(File file, String str) throws IOException;

    public ArchiveEntry createArchiveEntry(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        return createArchiveEntry(path.toFile(), str);
    }

    public abstract void finish() throws IOException;

    public long getBytesWritten() {
        return this.bytesWritten;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesWritten;
    }

    public abstract void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException;

    public void write(int i11) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i11 & 255);
        write(bArr, 0, 1);
    }

    public void count(long j11) {
        if (j11 != -1) {
            this.bytesWritten += j11;
        }
    }
}
