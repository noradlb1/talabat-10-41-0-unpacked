package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;

class CountingOutputStream extends FinishableOutputStream {
    private final OutputStream out;
    private long size = 0;

    public CountingOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public long getSize() {
        return this.size;
    }

    public void write(int i11) throws IOException {
        this.out.write(i11);
        long j11 = this.size;
        if (j11 >= 0) {
            this.size = j11 + 1;
        }
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.out.write(bArr, i11, i12);
        long j11 = this.size;
        if (j11 >= 0) {
            this.size = j11 + ((long) i12);
        }
    }
}
