package org.tukaani.xz.lz;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.ArrayCache;

public abstract class LZEncoder {
    public static final int MF_BT4 = 20;
    public static final int MF_HC4 = 4;

    /* renamed from: a  reason: collision with root package name */
    public final int f63432a;

    /* renamed from: b  reason: collision with root package name */
    public final int f63433b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f63434c;

    /* renamed from: d  reason: collision with root package name */
    public final int f63435d;

    /* renamed from: e  reason: collision with root package name */
    public int f63436e = -1;
    private boolean finishing = false;
    private final int keepSizeAfter;
    private final int keepSizeBefore;
    private int pendingSize = 0;
    private int readLimit = -1;
    private int writePos = 0;

    public LZEncoder(int i11, int i12, int i13, int i14, int i15, ArrayCache arrayCache) {
        int bufSize = getBufSize(i11, i12, i13, i15);
        this.f63435d = bufSize;
        this.f63434c = arrayCache.getByteArray(bufSize, false);
        this.keepSizeBefore = i12 + i11;
        this.keepSizeAfter = i13 + i15;
        this.f63432a = i15;
        this.f63433b = i14;
    }

    public static void b(int[] iArr, int i11, int i12) {
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = iArr[i13];
            if (i14 <= i12) {
                iArr[i13] = 0;
            } else {
                iArr[i13] = i14 - i12;
            }
        }
    }

    private static int getBufSize(int i11, int i12, int i13, int i14) {
        return i12 + i11 + i13 + i14 + Math.min((i11 / 2) + 262144, 536870912);
    }

    public static LZEncoder getInstance(int i11, int i12, int i13, int i14, int i15, int i16, int i17, ArrayCache arrayCache) {
        int i18 = i16;
        if (i18 == 4) {
            return new HC4(i11, i12, i13, i14, i15, i17, arrayCache);
        }
        if (i18 == 20) {
            return new BT4(i11, i12, i13, i14, i15, i17, arrayCache);
        }
        throw new IllegalArgumentException();
    }

    public static int getMemoryUsage(int i11, int i12, int i13, int i14, int i15) {
        int i16;
        int bufSize = (getBufSize(i11, i12, i13, i14) / 1024) + 10;
        if (i15 == 4) {
            i16 = HC4.c(i11);
        } else if (i15 == 20) {
            i16 = BT4.c(i11);
        } else {
            throw new IllegalArgumentException();
        }
        return bufSize + i16;
    }

    private void moveWindow() {
        int i11 = ((this.f63436e + 1) - this.keepSizeBefore) & -16;
        byte[] bArr = this.f63434c;
        System.arraycopy(bArr, i11, bArr, 0, this.writePos - i11);
        this.f63436e -= i11;
        this.readLimit -= i11;
        this.writePos -= i11;
    }

    private void processPendingBytes() {
        int i11;
        int i12 = this.pendingSize;
        if (i12 > 0 && (i11 = this.f63436e) < this.readLimit) {
            this.f63436e = i11 - i12;
            this.pendingSize = 0;
            skip(i12);
        }
    }

    public int a(int i11, int i12) {
        int i13 = this.f63436e + 1;
        this.f63436e = i13;
        int i14 = this.writePos - i13;
        if (i14 >= i11) {
            return i14;
        }
        if (i14 >= i12 && this.finishing) {
            return i14;
        }
        this.pendingSize++;
        return 0;
    }

    public void copyUncompressed(OutputStream outputStream, int i11, int i12) throws IOException {
        outputStream.write(this.f63434c, (this.f63436e + 1) - i11, i12);
    }

    public int fillWindow(byte[] bArr, int i11, int i12) {
        if (this.f63436e >= this.f63435d - this.keepSizeAfter) {
            moveWindow();
        }
        int i13 = this.f63435d;
        int i14 = this.writePos;
        if (i12 > i13 - i14) {
            i12 = i13 - i14;
        }
        System.arraycopy(bArr, i11, this.f63434c, i14, i12);
        int i15 = this.writePos + i12;
        this.writePos = i15;
        int i16 = this.keepSizeAfter;
        if (i15 >= i16) {
            this.readLimit = i15 - i16;
        }
        processPendingBytes();
        return i12;
    }

    public int getAvail() {
        return this.writePos - this.f63436e;
    }

    public int getByte(int i11) {
        return this.f63434c[this.f63436e - i11] & 255;
    }

    public int getByte(int i11, int i12) {
        return this.f63434c[(this.f63436e + i11) - i12] & 255;
    }

    public int getMatchLen(int i11, int i12) {
        int i13 = (this.f63436e - i11) - 1;
        int i14 = 0;
        while (i14 < i12) {
            byte[] bArr = this.f63434c;
            if (bArr[this.f63436e + i14] != bArr[i13 + i14]) {
                break;
            }
            i14++;
        }
        return i14;
    }

    public int getMatchLen(int i11, int i12, int i13) {
        int i14 = this.f63436e + i11;
        int i15 = (i14 - i12) - 1;
        int i16 = 0;
        while (i16 < i13) {
            byte[] bArr = this.f63434c;
            if (bArr[i14 + i16] != bArr[i15 + i16]) {
                break;
            }
            i16++;
        }
        return i16;
    }

    public abstract Matches getMatches();

    public int getPos() {
        return this.f63436e;
    }

    public boolean hasEnoughData(int i11) {
        return this.f63436e - i11 < this.readLimit;
    }

    public boolean isStarted() {
        return this.f63436e != -1;
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.f63434c);
    }

    public void setFinishing() {
        this.readLimit = this.writePos - 1;
        this.finishing = true;
        processPendingBytes();
    }

    public void setFlushing() {
        this.readLimit = this.writePos - 1;
        processPendingBytes();
    }

    public void setPresetDict(int i11, byte[] bArr) {
        if (bArr != null) {
            int min = Math.min(bArr.length, i11);
            System.arraycopy(bArr, bArr.length - min, this.f63434c, 0, min);
            this.writePos += min;
            skip(min);
        }
    }

    public abstract void skip(int i11);

    public boolean verifyMatches(Matches matches) {
        int min = Math.min(getAvail(), this.f63432a);
        for (int i11 = 0; i11 < matches.count; i11++) {
            if (getMatchLen(matches.dist[i11], min) != matches.len[i11]) {
                return false;
            }
        }
        return true;
    }
}
