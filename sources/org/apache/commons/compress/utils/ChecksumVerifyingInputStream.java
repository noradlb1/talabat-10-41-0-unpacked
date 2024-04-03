package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Checksum;

public class ChecksumVerifyingInputStream extends InputStream {
    private long bytesRemaining;
    private final Checksum checksum;
    private final long expectedChecksum;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f27775in;

    public ChecksumVerifyingInputStream(Checksum checksum2, InputStream inputStream, long j11, long j12) {
        this.checksum = checksum2;
        this.f27775in = inputStream;
        this.expectedChecksum = j12;
        this.bytesRemaining = j11;
    }

    public void close() throws IOException {
        this.f27775in.close();
    }

    public long getBytesRemaining() {
        return this.bytesRemaining;
    }

    public int read() throws IOException {
        if (this.bytesRemaining <= 0) {
            return -1;
        }
        int read = this.f27775in.read();
        if (read >= 0) {
            this.checksum.update(read);
            this.bytesRemaining--;
        }
        if (this.bytesRemaining != 0 || this.expectedChecksum == this.checksum.getValue()) {
            return read;
        }
        throw new IOException("Checksum verification failed");
    }

    public long skip(long j11) throws IOException {
        return read() >= 0 ? 1 : 0;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        int read = this.f27775in.read(bArr, i11, i12);
        if (read >= 0) {
            this.checksum.update(bArr, i11, read);
            this.bytesRemaining -= (long) read;
        }
        if (this.bytesRemaining > 0 || this.expectedChecksum == this.checksum.getValue()) {
            return read;
        }
        throw new IOException("Checksum verification failed");
    }
}
