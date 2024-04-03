package org.apache.commons.compress.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

public class BitInputStream implements Closeable {
    private static final long[] MASKS = new long[64];
    private static final int MAXIMUM_CACHE_SIZE = 63;
    private long bitsCached;
    private int bitsCachedSize;
    private final ByteOrder byteOrder;

    /* renamed from: in  reason: collision with root package name */
    private final CountingInputStream f27770in;

    static {
        for (int i11 = 1; i11 <= 63; i11++) {
            long[] jArr = MASKS;
            jArr[i11] = (jArr[i11 - 1] << 1) + 1;
        }
    }

    public BitInputStream(InputStream inputStream, ByteOrder byteOrder2) {
        this.f27770in = new CountingInputStream(inputStream);
        this.byteOrder = byteOrder2;
    }

    private boolean ensureCache(int i11) throws IOException {
        while (true) {
            int i12 = this.bitsCachedSize;
            if (i12 >= i11 || i12 >= 57) {
                return false;
            }
            long read = (long) this.f27770in.read();
            if (read < 0) {
                return true;
            }
            if (this.byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.bitsCached = (read << this.bitsCachedSize) | this.bitsCached;
            } else {
                this.bitsCached = read | (this.bitsCached << 8);
            }
            this.bitsCachedSize += 8;
        }
    }

    private long processBitsGreater57(int i11) throws IOException {
        long j11;
        int i12 = i11 - this.bitsCachedSize;
        int i13 = 8 - i12;
        long read = (long) this.f27770in.read();
        if (read < 0) {
            return read;
        }
        if (this.byteOrder == ByteOrder.LITTLE_ENDIAN) {
            long[] jArr = MASKS;
            this.bitsCached = ((jArr[i12] & read) << this.bitsCachedSize) | this.bitsCached;
            j11 = (read >>> i12) & jArr[i13];
        } else {
            long[] jArr2 = MASKS;
            this.bitsCached = (this.bitsCached << i12) | ((read >>> i13) & jArr2[i12]);
            j11 = read & jArr2[i13];
        }
        long j12 = this.bitsCached & MASKS[i11];
        this.bitsCached = j11;
        this.bitsCachedSize = i13;
        return j12;
    }

    private long readCachedBits(int i11) {
        long j11;
        if (this.byteOrder == ByteOrder.LITTLE_ENDIAN) {
            long j12 = this.bitsCached;
            j11 = j12 & MASKS[i11];
            this.bitsCached = j12 >>> i11;
        } else {
            j11 = (this.bitsCached >> (this.bitsCachedSize - i11)) & MASKS[i11];
        }
        this.bitsCachedSize -= i11;
        return j11;
    }

    public void alignWithByteBoundary() {
        int i11 = this.bitsCachedSize % 8;
        if (i11 > 0) {
            readCachedBits(i11);
        }
    }

    public long bitsAvailable() throws IOException {
        return ((long) this.bitsCachedSize) + (((long) this.f27770in.available()) * 8);
    }

    public int bitsCached() {
        return this.bitsCachedSize;
    }

    public void clearBitCache() {
        this.bitsCached = 0;
        this.bitsCachedSize = 0;
    }

    public void close() throws IOException {
        this.f27770in.close();
    }

    public long getBytesRead() {
        return this.f27770in.getBytesRead();
    }

    public long readBits(int i11) throws IOException {
        if (i11 < 0 || i11 > 63) {
            throw new IOException("count must not be negative or greater than 63");
        } else if (ensureCache(i11)) {
            return -1;
        } else {
            if (this.bitsCachedSize < i11) {
                return processBitsGreater57(i11);
            }
            return readCachedBits(i11);
        }
    }
}
