package com.google.zxing.datamatrix.decoder;

import com.google.zxing.datamatrix.decoder.Version;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i11, byte[] bArr) {
        this.numDataCodewords = i11;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        boolean z11;
        int i11;
        int i12;
        int i13;
        Version.ECBlocks eCBlocks = version.getECBlocks();
        Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int i14 = 0;
        for (Version.ECB count : eCBlocks2) {
            i14 += count.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i14];
        int i15 = 0;
        for (Version.ECB ecb : eCBlocks2) {
            int i16 = 0;
            while (i16 < ecb.getCount()) {
                int dataCodewords = ecb.getDataCodewords();
                dataBlockArr[i15] = new DataBlock(dataCodewords, new byte[(eCBlocks.getECCodewords() + dataCodewords)]);
                i16++;
                i15++;
            }
        }
        int length = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i17 = length - 1;
        int i18 = 0;
        for (int i19 = 0; i19 < i17; i19++) {
            int i21 = 0;
            while (i21 < i15) {
                dataBlockArr[i21].codewords[i19] = bArr[i18];
                i21++;
                i18++;
            }
        }
        if (version.getVersionNumber() == 24) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 8;
        } else {
            i11 = i15;
        }
        int i22 = 0;
        while (i22 < i11) {
            dataBlockArr[i22].codewords[i17] = bArr[i18];
            i22++;
            i18++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (length < length2) {
            int i23 = 0;
            while (i23 < i15) {
                if (z11) {
                    i12 = (i23 + 8) % i15;
                } else {
                    i12 = i23;
                }
                if (!z11 || i12 <= 7) {
                    i13 = length;
                } else {
                    i13 = length - 1;
                }
                dataBlockArr[i12].codewords[i13] = bArr[i18];
                i23++;
                i18++;
            }
            length++;
        }
        if (i18 == bArr.length) {
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] getCodewords() {
        return this.codewords;
    }

    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
