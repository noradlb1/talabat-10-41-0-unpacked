package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.Checksum;

public class ChecksumCalculatingInputStream extends InputStream {
    private final Checksum checksum;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f27774in;

    public ChecksumCalculatingInputStream(Checksum checksum2, InputStream inputStream) {
        Objects.requireNonNull(checksum2, "checksum");
        Objects.requireNonNull(inputStream, "in");
        this.checksum = checksum2;
        this.f27774in = inputStream;
    }

    public long getValue() {
        return this.checksum.getValue();
    }

    public int read() throws IOException {
        int read = this.f27774in.read();
        if (read >= 0) {
            this.checksum.update(read);
        }
        return read;
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
        int read = this.f27774in.read(bArr, i11, i12);
        if (read >= 0) {
            this.checksum.update(bArr, i11, read);
        }
        return read;
    }
}
