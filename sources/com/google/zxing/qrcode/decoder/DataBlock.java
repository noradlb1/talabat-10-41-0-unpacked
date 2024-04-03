package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i11, byte[] bArr) {
        this.numDataCodewords = i11;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        int i11;
        if (bArr.length == version.getTotalCodewords()) {
            Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
            Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
            int i12 = 0;
            for (Version.ECB count : eCBlocks) {
                i12 += count.getCount();
            }
            DataBlock[] dataBlockArr = new DataBlock[i12];
            int i13 = 0;
            for (Version.ECB ecb : eCBlocks) {
                int i14 = 0;
                while (i14 < ecb.getCount()) {
                    int dataCodewords = ecb.getDataCodewords();
                    dataBlockArr[i13] = new DataBlock(dataCodewords, new byte[(eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords)]);
                    i14++;
                    i13++;
                }
            }
            int length = dataBlockArr[0].codewords.length;
            int i15 = i12 - 1;
            while (i15 >= 0 && dataBlockArr[i15].codewords.length != length) {
                i15--;
            }
            int i16 = i15 + 1;
            int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
            int i17 = 0;
            for (int i18 = 0; i18 < eCCodewordsPerBlock; i18++) {
                int i19 = 0;
                while (i19 < i13) {
                    dataBlockArr[i19].codewords[i18] = bArr[i17];
                    i19++;
                    i17++;
                }
            }
            int i21 = i16;
            while (i21 < i13) {
                dataBlockArr[i21].codewords[eCCodewordsPerBlock] = bArr[i17];
                i21++;
                i17++;
            }
            int length2 = dataBlockArr[0].codewords.length;
            while (eCCodewordsPerBlock < length2) {
                int i22 = 0;
                while (i22 < i13) {
                    if (i22 < i16) {
                        i11 = eCCodewordsPerBlock;
                    } else {
                        i11 = eCCodewordsPerBlock + 1;
                    }
                    dataBlockArr[i22].codewords[i11] = bArr[i17];
                    i22++;
                    i17++;
                }
                eCCodewordsPerBlock++;
            }
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
