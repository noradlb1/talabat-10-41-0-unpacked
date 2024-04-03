package org.apache.commons.compress.harmony.pack200;

import java.io.IOException;
import java.io.InputStream;

public abstract class Codec {
    public static final BHSDCodec BCI5 = new BHSDCodec(5, 4);
    public static final BHSDCodec BRANCH5 = new BHSDCodec(5, 4, 2);
    public static final BHSDCodec BYTE1 = new BHSDCodec(1, 256);
    public static final BHSDCodec CHAR3 = new BHSDCodec(3, 128);
    public static final BHSDCodec DELTA5 = new BHSDCodec(5, 64, 1, 1);
    public static final BHSDCodec MDELTA5 = new BHSDCodec(5, 64, 2, 1);
    public static final BHSDCodec SIGNED5 = new BHSDCodec(5, 64, 1);
    public static final BHSDCodec UDELTA5 = new BHSDCodec(5, 64, 0, 1);
    public static final BHSDCodec UNSIGNED5 = new BHSDCodec(5, 64);
    public int lastBandLength;

    public abstract int decode(InputStream inputStream) throws IOException, Pack200Exception;

    public abstract int decode(InputStream inputStream, long j11) throws IOException, Pack200Exception;

    public int[] decodeInts(int i11, InputStream inputStream) throws IOException, Pack200Exception {
        this.lastBandLength = 0;
        int[] iArr = new int[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 = decode(inputStream, (long) i12);
            iArr[i13] = i12;
        }
        return iArr;
    }

    public abstract byte[] encode(int i11) throws Pack200Exception;

    public abstract byte[] encode(int i11, int i12) throws Pack200Exception;

    public byte[] encode(int[] iArr) throws Pack200Exception {
        int i11;
        int length = iArr.length;
        byte[][] bArr = new byte[length][];
        int i12 = 0;
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            if (i13 > 0) {
                i11 = iArr[i13 - 1];
            } else {
                i11 = 0;
            }
            byte[] encode = encode(i14, i11);
            bArr[i13] = encode;
            i12 += encode.length;
        }
        byte[] bArr2 = new byte[i12];
        int i15 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            byte[] bArr3 = bArr[i16];
            System.arraycopy(bArr3, 0, bArr2, i15, bArr3.length);
            i15 += bArr[i16].length;
        }
        return bArr2;
    }

    public int[] decodeInts(int i11, InputStream inputStream, int i12) throws IOException, Pack200Exception {
        int i13 = i11 + 1;
        int[] iArr = new int[i13];
        iArr[0] = i12;
        for (int i14 = 1; i14 < i13; i14++) {
            i12 = decode(inputStream, (long) i12);
            iArr[i14] = i12;
        }
        return iArr;
    }
}
