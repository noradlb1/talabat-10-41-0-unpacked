package org.tukaani.xz.rangecoder;

import com.checkout.frames.utils.constants.CountryPickerScreenConstants;
import java.io.IOException;

public abstract class RangeEncoder extends RangeCoder {
    private static final int BIT_PRICE_SHIFT_BITS = 4;
    private static final int MOVE_REDUCING_BITS = 4;
    private static final int[] prices = new int[128];

    /* renamed from: a  reason: collision with root package name */
    public long f63485a;
    private byte cache;
    private long low;
    private int range;

    static {
        for (int i11 = 8; i11 < 2048; i11 += 16) {
            int i12 = i11;
            int i13 = 0;
            for (int i14 = 0; i14 < 4; i14++) {
                i12 *= i12;
                i13 <<= 1;
                while ((-65536 & i12) != 0) {
                    i12 >>>= 1;
                    i13++;
                }
            }
            prices[i11 >> 4] = 161 - i13;
        }
    }

    public static int getBitPrice(int i11, int i12) {
        return prices[(i11 ^ ((-i12) & 2047)) >>> 4];
    }

    public static int getBitTreePrice(short[] sArr, int i11) {
        int length = i11 | sArr.length;
        int i12 = 0;
        do {
            int i13 = length & 1;
            length >>>= 1;
            i12 += getBitPrice(sArr[length], i13);
        } while (length != 1);
        return i12;
    }

    public static int getDirectBitsPrice(int i11) {
        return i11 << 4;
    }

    public static int getReverseBitTreePrice(short[] sArr, int i11) {
        int length = i11 | sArr.length;
        int i12 = 0;
        int i13 = 1;
        do {
            int i14 = length & 1;
            length >>>= 1;
            i12 += getBitPrice(sArr[i13], i14);
            i13 = (i13 << 1) | i14;
        } while (length != 1);
        return i12;
    }

    private void shiftLow() throws IOException {
        long j11 = this.low;
        int i11 = (int) (j11 >>> 32);
        if (i11 != 0 || j11 < CountryPickerScreenConstants.focusedBorderColor) {
            byte b11 = this.cache;
            while (true) {
                a(b11 + i11);
                long j12 = this.f63485a - 1;
                this.f63485a = j12;
                if (j12 == 0) {
                    break;
                }
                b11 = 255;
            }
            this.cache = (byte) ((int) (this.low >>> 24));
        }
        this.f63485a++;
        this.low = (this.low & 16777215) << 8;
    }

    public abstract void a(int i11) throws IOException;

    public void encodeBit(short[] sArr, int i11, int i12) throws IOException {
        short s11 = sArr[i11];
        int i13 = this.range;
        int i14 = (i13 >>> 11) * s11;
        if (i12 == 0) {
            this.range = i14;
            sArr[i11] = (short) (s11 + ((2048 - s11) >>> 5));
        } else {
            this.low += ((long) i14) & 4294967295L;
            this.range = i13 - i14;
            sArr[i11] = (short) (s11 - (s11 >>> 5));
        }
        int i15 = this.range;
        if ((-16777216 & i15) == 0) {
            this.range = i15 << 8;
            shiftLow();
        }
    }

    public void encodeBitTree(short[] sArr, int i11) throws IOException {
        int length = sArr.length;
        int i12 = 1;
        do {
            length >>>= 1;
            int i13 = i11 & length;
            encodeBit(sArr, i12, i13);
            i12 <<= 1;
            if (i13 != 0) {
                i12 |= 1;
                continue;
            }
        } while (length != 1);
    }

    public void encodeDirectBits(int i11, int i12) throws IOException {
        do {
            int i13 = this.range >>> 1;
            this.range = i13;
            i12--;
            this.low += (long) ((0 - ((i11 >>> i12) & 1)) & i13);
            if ((-16777216 & i13) == 0) {
                this.range = i13 << 8;
                shiftLow();
                continue;
            }
        } while (i12 != 0);
    }

    public void encodeReverseBitTree(short[] sArr, int i11) throws IOException {
        int length = i11 | sArr.length;
        int i12 = 1;
        do {
            int i13 = length & 1;
            length >>>= 1;
            encodeBit(sArr, i12, i13);
            i12 = (i12 << 1) | i13;
        } while (length != 1);
    }

    public int finish() throws IOException {
        for (int i11 = 0; i11 < 5; i11++) {
            shiftLow();
        }
        return -1;
    }

    public int getPendingSize() {
        throw new Error();
    }

    public void reset() {
        this.low = 0;
        this.range = -1;
        this.cache = 0;
        this.f63485a = 1;
    }
}
