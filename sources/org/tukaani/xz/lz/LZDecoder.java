package org.tukaani.xz.lz;

import java.io.DataInputStream;
import java.io.IOException;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.CorruptedInputException;

public final class LZDecoder {
    private final byte[] buf;
    private final int bufSize;
    private int full = 0;
    private int limit = 0;
    private int pendingDist = 0;
    private int pendingLen = 0;
    private int pos = 0;
    private int start = 0;

    public LZDecoder(int i11, byte[] bArr, ArrayCache arrayCache) {
        this.bufSize = i11;
        byte[] byteArray = arrayCache.getByteArray(i11, false);
        this.buf = byteArray;
        if (bArr != null) {
            int min = Math.min(bArr.length, i11);
            this.pos = min;
            this.full = min;
            this.start = min;
            System.arraycopy(bArr, bArr.length - min, byteArray, 0, min);
        }
    }

    public void copyUncompressed(DataInputStream dataInputStream, int i11) throws IOException {
        int min = Math.min(this.bufSize - this.pos, i11);
        dataInputStream.readFully(this.buf, this.pos, min);
        int i12 = this.pos + min;
        this.pos = i12;
        if (this.full < i12) {
            this.full = i12;
        }
    }

    public int flush(byte[] bArr, int i11) {
        int i12 = this.pos;
        int i13 = this.start;
        int i14 = i12 - i13;
        if (i12 == this.bufSize) {
            this.pos = 0;
        }
        System.arraycopy(this.buf, i13, bArr, i11, i14);
        this.start = this.pos;
        return i14;
    }

    public int getByte(int i11) {
        int i12 = this.pos;
        int i13 = (i12 - i11) - 1;
        if (i11 >= i12) {
            i13 += this.bufSize;
        }
        return this.buf[i13] & 255;
    }

    public int getPos() {
        return this.pos;
    }

    public boolean hasPending() {
        return this.pendingLen > 0;
    }

    public boolean hasSpace() {
        return this.pos < this.limit;
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.buf);
    }

    public void putByte(byte b11) {
        byte[] bArr = this.buf;
        int i11 = this.pos;
        int i12 = i11 + 1;
        this.pos = i12;
        bArr[i11] = b11;
        if (this.full < i12) {
            this.full = i12;
        }
    }

    public void repeat(int i11, int i12) throws IOException {
        int i13;
        if (i11 < 0 || i11 >= this.full) {
            throw new CorruptedInputException();
        }
        int min = Math.min(this.limit - this.pos, i12);
        this.pendingLen = i12 - min;
        this.pendingDist = i11;
        int i14 = (this.pos - i11) - 1;
        if (i14 < 0) {
            int i15 = this.bufSize;
            int i16 = i14 + i15;
            int min2 = Math.min(i15 - i16, min);
            byte[] bArr = this.buf;
            System.arraycopy(bArr, i16, bArr, this.pos, min2);
            this.pos += min2;
            min -= min2;
            if (min != 0) {
                i14 = 0;
            } else {
                return;
            }
        }
        do {
            int min3 = Math.min(min, this.pos - i14);
            byte[] bArr2 = this.buf;
            System.arraycopy(bArr2, i14, bArr2, this.pos, min3);
            i13 = this.pos + min3;
            this.pos = i13;
            min -= min3;
        } while (min > 0);
        if (this.full < i13) {
            this.full = i13;
        }
    }

    public void repeatPending() throws IOException {
        int i11 = this.pendingLen;
        if (i11 > 0) {
            repeat(this.pendingDist, i11);
        }
    }

    public void reset() {
        this.start = 0;
        this.pos = 0;
        this.full = 0;
        this.limit = 0;
        this.buf[this.bufSize - 1] = 0;
    }

    public void setLimit(int i11) {
        int i12 = this.bufSize;
        int i13 = this.pos;
        if (i12 - i13 <= i11) {
            this.limit = i12;
        } else {
            this.limit = i13 + i11;
        }
    }
}
