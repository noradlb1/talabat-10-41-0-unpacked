package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;

class CountingInputStream extends CloseIgnoringInputStream {
    private long size = 0;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public long getSize() {
        return this.size;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            long j11 = this.size;
            if (j11 >= 0) {
                this.size = j11 + 1;
            }
        }
        return read;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = this.in.read(bArr, i11, i12);
        if (read > 0) {
            long j11 = this.size;
            if (j11 >= 0) {
                this.size = j11 + ((long) read);
            }
        }
        return read;
    }
}
