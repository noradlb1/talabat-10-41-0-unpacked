package org.apache.commons.compress.compressors.lz77support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import r20.a;

public abstract class AbstractLZ77CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private int backReferenceOffset;
    private final byte[] buf;
    private long bytesRemaining;

    /* renamed from: in  reason: collision with root package name */
    private final CountingInputStream f27716in;
    private final byte[] oneByte = new byte[1];
    private int readIndex;
    private int size;
    protected final ByteUtils.ByteSupplier supplier = new a(this);
    private final int windowSize;
    private int writeIndex;

    public AbstractLZ77CompressorInputStream(InputStream inputStream, int i11) throws IOException {
        this.f27716in = new CountingInputStream(inputStream);
        if (i11 > 0) {
            this.windowSize = i11;
            this.buf = new byte[(i11 * 3)];
            this.readIndex = 0;
            this.writeIndex = 0;
            this.bytesRemaining = 0;
            return;
        }
        throw new IllegalArgumentException("windowSize must be bigger than 0");
    }

    private int readFromBuffer(byte[] bArr, int i11, int i12) {
        int min = Math.min(i12, available());
        if (min > 0) {
            System.arraycopy(this.buf, this.readIndex, bArr, i11, min);
            int i13 = this.readIndex + min;
            this.readIndex = i13;
            if (i13 > this.windowSize * 2) {
                slideBuffer();
            }
        }
        this.size += min;
        return min;
    }

    private void slideBuffer() {
        byte[] bArr = this.buf;
        int i11 = this.windowSize;
        System.arraycopy(bArr, i11, bArr, 0, i11 * 2);
        int i12 = this.writeIndex;
        int i13 = this.windowSize;
        this.writeIndex = i12 - i13;
        this.readIndex -= i13;
    }

    private void tryToCopy(int i11) {
        int min = Math.min((int) Math.min((long) i11, this.bytesRemaining), this.buf.length - this.writeIndex);
        if (min != 0) {
            int i12 = this.backReferenceOffset;
            if (i12 == 1) {
                byte[] bArr = this.buf;
                int i13 = this.writeIndex;
                Arrays.fill(bArr, i13, i13 + min, bArr[i13 - 1]);
                this.writeIndex += min;
            } else if (min < i12) {
                byte[] bArr2 = this.buf;
                int i14 = this.writeIndex;
                System.arraycopy(bArr2, i14 - i12, bArr2, i14, min);
                this.writeIndex += min;
            } else {
                int i15 = min / i12;
                for (int i16 = 0; i16 < i15; i16++) {
                    byte[] bArr3 = this.buf;
                    int i17 = this.writeIndex;
                    int i18 = this.backReferenceOffset;
                    System.arraycopy(bArr3, i17 - i18, bArr3, i17, i18);
                    this.writeIndex += this.backReferenceOffset;
                }
                int i19 = this.backReferenceOffset;
                int i21 = min - (i15 * i19);
                if (i21 > 0) {
                    byte[] bArr4 = this.buf;
                    int i22 = this.writeIndex;
                    System.arraycopy(bArr4, i22 - i19, bArr4, i22, i21);
                    this.writeIndex += i21;
                }
            }
        }
        this.bytesRemaining -= (long) min;
    }

    private void tryToReadLiteral(int i11) throws IOException {
        int i12;
        int min = Math.min((int) Math.min((long) i11, this.bytesRemaining), this.buf.length - this.writeIndex);
        if (min > 0) {
            i12 = IOUtils.readFully(this.f27716in, this.buf, this.writeIndex, min);
        } else {
            i12 = 0;
        }
        count(i12);
        if (min == i12) {
            this.writeIndex += min;
            this.bytesRemaining -= (long) min;
            return;
        }
        throw new IOException("Premature end of stream reading literal");
    }

    public int available() {
        return this.writeIndex - this.readIndex;
    }

    public void close() throws IOException {
        this.f27716in.close();
    }

    public long getCompressedCount() {
        return this.f27716in.getBytesRead();
    }

    public int getSize() {
        return this.size;
    }

    public final boolean hasMoreDataInBlock() {
        return this.bytesRemaining > 0;
    }

    public void prefill(byte[] bArr) {
        if (this.writeIndex == 0) {
            int min = Math.min(this.windowSize, bArr.length);
            System.arraycopy(bArr, bArr.length - min, this.buf, 0, min);
            this.writeIndex += min;
            this.readIndex += min;
            return;
        }
        throw new IllegalStateException("The stream has already been read from, can't prefill anymore");
    }

    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) == -1) {
            return -1;
        }
        return this.oneByte[0] & 255;
    }

    public final int readBackReference(byte[] bArr, int i11, int i12) {
        int available = available();
        if (i12 > available) {
            tryToCopy(i12 - available);
        }
        return readFromBuffer(bArr, i11, i12);
    }

    public final int readLiteral(byte[] bArr, int i11, int i12) throws IOException {
        int available = available();
        if (i12 > available) {
            tryToReadLiteral(i12 - available);
        }
        return readFromBuffer(bArr, i11, i12);
    }

    public final int readOneByte() throws IOException {
        int read = this.f27716in.read();
        if (read == -1) {
            return -1;
        }
        count(1);
        return read & 255;
    }

    public final void startBackReference(int i11, long j11) {
        if (i11 <= 0 || i11 > this.writeIndex) {
            throw new IllegalArgumentException("offset must be bigger than 0 but not bigger than the number of bytes available for back-references");
        } else if (j11 >= 0) {
            this.backReferenceOffset = i11;
            this.bytesRemaining = j11;
        } else {
            throw new IllegalArgumentException("length must not be negative");
        }
    }

    public final void startLiteral(long j11) {
        if (j11 >= 0) {
            this.bytesRemaining = j11;
            return;
        }
        throw new IllegalArgumentException("length must not be negative");
    }
}
