package org.apache.commons.compress.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CountingOutputStream extends FilterOutputStream {
    private long bytesWritten;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void count(long j11) {
        if (j11 != -1) {
            this.bytesWritten += j11;
        }
    }

    public long getBytesWritten() {
        return this.bytesWritten;
    }

    public void write(int i11) throws IOException {
        this.out.write(i11);
        count(1);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.out.write(bArr, i11, i12);
        count((long) i12);
    }
}
