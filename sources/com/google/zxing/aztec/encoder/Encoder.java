package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    private static int[] bitsToWords(BitArray bitArray, int i11, int i12) {
        int i13;
        int[] iArr = new int[i12];
        int size = bitArray.getSize() / i11;
        for (int i14 = 0; i14 < size; i14++) {
            int i15 = 0;
            for (int i16 = 0; i16 < i11; i16++) {
                if (bitArray.get((i14 * i11) + i16)) {
                    i13 = 1 << ((i11 - i16) - 1);
                } else {
                    i13 = 0;
                }
                i15 |= i13;
            }
            iArr[i14] = i15;
        }
        return iArr;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13 += 2) {
            int i14 = i11 - i13;
            int i15 = i14;
            while (true) {
                int i16 = i11 + i13;
                if (i15 > i16) {
                    break;
                }
                bitMatrix.set(i15, i14);
                bitMatrix.set(i15, i16);
                bitMatrix.set(i14, i15);
                bitMatrix.set(i16, i15);
                i15++;
            }
        }
        int i17 = i11 - i12;
        bitMatrix.set(i17, i17);
        int i18 = i17 + 1;
        bitMatrix.set(i18, i17);
        bitMatrix.set(i17, i18);
        int i19 = i11 + i12;
        bitMatrix.set(i19, i17);
        bitMatrix.set(i19, i18);
        bitMatrix.set(i19, i19 - 1);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z11, int i11, BitArray bitArray) {
        int i12 = i11 / 2;
        int i13 = 0;
        if (z11) {
            while (i13 < 7) {
                int i14 = (i12 - 3) + i13;
                if (bitArray.get(i13)) {
                    bitMatrix.set(i14, i12 - 5);
                }
                if (bitArray.get(i13 + 7)) {
                    bitMatrix.set(i12 + 5, i14);
                }
                if (bitArray.get(20 - i13)) {
                    bitMatrix.set(i14, i12 + 5);
                }
                if (bitArray.get(27 - i13)) {
                    bitMatrix.set(i12 - 5, i14);
                }
                i13++;
            }
            return;
        }
        while (i13 < 10) {
            int i15 = (i12 - 5) + i13 + (i13 / 5);
            if (bitArray.get(i13)) {
                bitMatrix.set(i15, i12 - 7);
            }
            if (bitArray.get(i13 + 10)) {
                bitMatrix.set(i12 + 7, i15);
            }
            if (bitArray.get(29 - i13)) {
                bitMatrix.set(i15, i12 + 7);
            }
            if (bitArray.get(39 - i13)) {
                bitMatrix.set(i12 - 7, i15);
            }
            i13++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i11, int i12) {
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i12));
        int i13 = i11 / i12;
        int[] bitsToWords = bitsToWords(bitArray, i12, i13);
        reedSolomonEncoder.encode(bitsToWords, i13 - (bitArray.getSize() / i12));
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i11 % i12);
        for (int appendBits : bitsToWords) {
            bitArray2.appendBits(appendBits, i12);
        }
        return bitArray2;
    }

    public static BitArray generateModeMessage(boolean z11, int i11, int i12) {
        BitArray bitArray = new BitArray();
        if (z11) {
            bitArray.appendBits(i11 - 1, 2);
            bitArray.appendBits(i12 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i11 - 1, 5);
        bitArray.appendBits(i12 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static GenericGF getGF(int i11) {
        if (i11 == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i11 == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i11 == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i11 == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i11 == 12) {
            return GenericGF.AZTEC_DATA_12;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i11)));
    }

    public static BitArray stuffBits(BitArray bitArray, int i11) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i12 = (1 << i11) - 2;
        int i13 = 0;
        while (i13 < size) {
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                int i16 = i13 + i15;
                if (i16 >= size || bitArray.get(i16)) {
                    i14 |= 1 << ((i11 - 1) - i15);
                }
            }
            int i17 = i14 & i12;
            if (i17 == i12) {
                bitArray2.appendBits(i17, i11);
            } else if (i17 == 0) {
                bitArray2.appendBits(i14 | 1, i11);
            } else {
                bitArray2.appendBits(i14, i11);
                i13 += i11;
            }
            i13--;
            i13 += i11;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i11, boolean z11) {
        return ((z11 ? 88 : 112) + (i11 << 4)) * i11;
    }

    public static AztecCode encode(byte[] bArr, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        boolean z11;
        BitArray bitArray;
        int i16;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int i17 = 11;
        int size = ((encode.getSize() * i11) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i18 = 32;
        boolean z12 = 0;
        boolean z13 = true;
        if (i12 != 0) {
            z11 = i12 < 0;
            i14 = Math.abs(i12);
            if (z11) {
                i18 = 4;
            }
            if (i14 <= i18) {
                i15 = totalBitsInLayer(i14, z11);
                i13 = WORD_SIZE[i14];
                int i19 = i15 - (i15 % i13);
                bitArray = stuffBits(encode, i13);
                if (bitArray.getSize() + size > i19) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (z11 && bitArray.getSize() > (i13 << 6)) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i12)}));
            }
        } else {
            BitArray bitArray2 = null;
            int i21 = 0;
            int i22 = 0;
            while (i21 <= 32) {
                boolean z14 = i21 <= 3 ? z13 : z12;
                int i23 = z14 ? i21 + 1 : i21;
                int i24 = totalBitsInLayer(i23, z14);
                if (size2 <= i24) {
                    if (bitArray2 == null || i22 != WORD_SIZE[i23]) {
                        int i25 = WORD_SIZE[i23];
                        i22 = i25;
                        bitArray2 = stuffBits(encode, i25);
                    }
                    int i26 = i24 - (i24 % i22);
                    if ((!z14 || bitArray2.getSize() <= (i22 << 6)) && bitArray2.getSize() + size <= i26) {
                        bitArray = bitArray2;
                        i13 = i22;
                        z11 = z14;
                        i14 = i23;
                        i15 = i24;
                    }
                }
                i21++;
                z13 = z13;
                z12 = 0;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i15, i13);
        int size3 = bitArray.getSize() / i13;
        BitArray generateModeMessage = generateModeMessage(z11, i14, size3);
        if (!z11) {
            i17 = 14;
        }
        int i27 = i17 + (i14 << 2);
        int[] iArr = new int[i27];
        int i28 = 2;
        if (z11) {
            for (int i29 = z12; i29 < i27; i29++) {
                iArr[i29] = i29;
            }
            i16 = i27;
        } else {
            int i31 = i27 / 2;
            i16 = i27 + 1 + (((i31 - 1) / 15) * 2);
            int i32 = i16 / 2;
            for (int i33 = z12; i33 < i31; i33++) {
                int i34 = (i33 / 15) + i33;
                iArr[(i31 - i33) - (z13 ? 1 : 0)] = (i32 - i34) - 1;
                iArr[i31 + i33] = i34 + i32 + z13;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i16);
        int i35 = z12;
        int i36 = i35;
        while (i35 < i14) {
            int i37 = ((i14 - i35) << i28) + (z11 ? 9 : 12);
            int i38 = z12;
            while (i38 < i37) {
                int i39 = i38 << 1;
                while (z12 < i28) {
                    if (generateCheckWords.get(i36 + i39 + z12)) {
                        int i41 = i35 << 1;
                        bitMatrix.set(iArr[i41 + z12], iArr[i41 + i38]);
                    }
                    if (generateCheckWords.get((i37 << 1) + i36 + i39 + z12)) {
                        int i42 = i35 << 1;
                        bitMatrix.set(iArr[i42 + i38], iArr[((i27 - 1) - i42) - z12]);
                    }
                    if (generateCheckWords.get((i37 << 2) + i36 + i39 + z12)) {
                        int i43 = (i27 - 1) - (i35 << 1);
                        bitMatrix.set(iArr[i43 - z12], iArr[i43 - i38]);
                    }
                    if (generateCheckWords.get((i37 * 6) + i36 + i39 + z12)) {
                        int i44 = i35 << 1;
                        bitMatrix.set(iArr[((i27 - 1) - i44) - i38], iArr[i44 + z12]);
                    }
                    z12++;
                    i28 = 2;
                }
                i38++;
                z12 = 0;
                i28 = 2;
            }
            i36 += i37 << 3;
            i35++;
            z12 = 0;
            i28 = 2;
        }
        drawModeMessage(bitMatrix, z11, i16, generateModeMessage);
        if (z11) {
            drawBullsEye(bitMatrix, i16 / 2, 5);
        } else {
            int i45 = i16 / 2;
            drawBullsEye(bitMatrix, i45, 7);
            int i46 = 0;
            int i47 = 0;
            while (i47 < (i27 / 2) - 1) {
                for (int i48 = i45 & 1; i48 < i16; i48 += 2) {
                    int i49 = i45 - i46;
                    bitMatrix.set(i49, i48);
                    int i50 = i45 + i46;
                    bitMatrix.set(i50, i48);
                    bitMatrix.set(i48, i49);
                    bitMatrix.set(i48, i50);
                }
                i47 += 15;
                i46 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z11);
        aztecCode.setSize(i16);
        aztecCode.setLayers(i14);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }
}
