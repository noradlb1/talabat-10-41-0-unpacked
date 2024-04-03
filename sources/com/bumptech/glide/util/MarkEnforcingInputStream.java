package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes = Integer.MIN_VALUE;

    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
    }

    private long getBytesToRead(long j11) {
        int i11 = this.availableBytes;
        if (i11 == 0) {
            return -1;
        }
        return (i11 == Integer.MIN_VALUE || j11 <= ((long) i11)) ? j11 : (long) i11;
    }

    private void updateAvailableBytesAfterRead(long j11) {
        int i11 = this.availableBytes;
        if (i11 != Integer.MIN_VALUE && j11 != -1) {
            this.availableBytes = (int) (((long) i11) - j11);
        }
    }

    public int available() throws IOException {
        int i11 = this.availableBytes;
        if (i11 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i11, super.available());
    }

    public synchronized void mark(int i11) {
        super.mark(i11);
        this.availableBytes = i11;
    }

    public int read() throws IOException {
        if (getBytesToRead(1) == -1) {
            return -1;
        }
        int read = super.read();
        updateAvailableBytesAfterRead(1);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.availableBytes = Integer.MIN_VALUE;
    }

    public long skip(long j11) throws IOException {
        long bytesToRead = getBytesToRead(j11);
        if (bytesToRead == -1) {
            return 0;
        }
        long skip = super.skip(bytesToRead);
        updateAvailableBytesAfterRead(skip);
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i11, int i12) throws IOException {
        int bytesToRead = (int) getBytesToRead((long) i12);
        if (bytesToRead == -1) {
            return -1;
        }
        int read = super.read(bArr, i11, bytesToRead);
        updateAvailableBytesAfterRead((long) read);
        return read;
    }
}
