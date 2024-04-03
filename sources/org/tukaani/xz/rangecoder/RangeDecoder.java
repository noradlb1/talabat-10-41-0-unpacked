package org.tukaani.xz.rangecoder;

import java.io.IOException;

public abstract class RangeDecoder extends RangeCoder {

    /* renamed from: a  reason: collision with root package name */
    public int f63483a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f63484b = 0;

    public int decodeBit(short[] sArr, int i11) throws IOException {
        normalize();
        short s11 = sArr[i11];
        int i12 = this.f63483a;
        int i13 = (i12 >>> 11) * s11;
        int i14 = this.f63484b;
        if ((i14 ^ Integer.MIN_VALUE) < (Integer.MIN_VALUE ^ i13)) {
            this.f63483a = i13;
            sArr[i11] = (short) (s11 + ((2048 - s11) >>> 5));
            return 0;
        }
        this.f63483a = i12 - i13;
        this.f63484b = i14 - i13;
        sArr[i11] = (short) (s11 - (s11 >>> 5));
        return 1;
    }

    public int decodeBitTree(short[] sArr) throws IOException {
        int i11 = 1;
        do {
            i11 = decodeBit(sArr, i11) | (i11 << 1);
        } while (i11 < sArr.length);
        return i11 - sArr.length;
    }

    public int decodeDirectBits(int i11) throws IOException {
        int i12 = 0;
        do {
            normalize();
            int i13 = this.f63483a >>> 1;
            this.f63483a = i13;
            int i14 = this.f63484b;
            int i15 = (i14 - i13) >>> 31;
            this.f63484b = i14 - (i13 & (i15 - 1));
            i12 = (i12 << 1) | (1 - i15);
            i11--;
        } while (i11 != 0);
        return i12;
    }

    public int decodeReverseBitTree(short[] sArr) throws IOException {
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (true) {
            int decodeBit = decodeBit(sArr, i12);
            i12 = (i12 << 1) | decodeBit;
            int i14 = i13 + 1;
            i11 |= decodeBit << i13;
            if (i12 >= sArr.length) {
                return i11;
            }
            i13 = i14;
        }
    }

    public abstract void normalize() throws IOException;
}
