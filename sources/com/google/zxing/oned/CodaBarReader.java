package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class CodaBarReader extends OneDReader {
    static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
    static final int[] CHARACTER_ENCODINGS = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final float MAX_ACCEPTABLE = 2.0f;
    private static final int MIN_CHARACTER_LENGTH = 3;
    private static final float PADDING = 1.5f;
    private static final char[] STARTEND_ENCODING = {'A', 'B', 'C', 'D'};
    private int counterLength = 0;
    private int[] counters = new int[80];
    private final StringBuilder decodeRowResult = new StringBuilder(20);

    public static boolean arrayContains(char[] cArr, char c11) {
        if (cArr != null) {
            for (char c12 : cArr) {
                if (c12 == c11) {
                    return true;
                }
            }
        }
        return false;
    }

    private void counterAppend(int i11) {
        int[] iArr = this.counters;
        int i12 = this.counterLength;
        iArr[i12] = i11;
        int i13 = i12 + 1;
        this.counterLength = i13;
        if (i13 >= iArr.length) {
            int[] iArr2 = new int[(i13 << 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i13);
            this.counters = iArr2;
        }
    }

    private int findStartPattern() throws NotFoundException {
        for (int i11 = 1; i11 < this.counterLength; i11 += 2) {
            int narrowWidePattern = toNarrowWidePattern(i11);
            if (narrowWidePattern != -1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                int i12 = 0;
                for (int i13 = i11; i13 < i11 + 7; i13++) {
                    i12 += this.counters[i13];
                }
                if (i11 == 1 || this.counters[i11 - 1] >= i12 / 2) {
                    return i11;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void setCounters(BitArray bitArray) throws NotFoundException {
        int i11 = 0;
        this.counterLength = 0;
        int nextUnset = bitArray.getNextUnset(0);
        int size = bitArray.getSize();
        if (nextUnset < size) {
            boolean z11 = true;
            while (nextUnset < size) {
                if (bitArray.get(nextUnset) != z11) {
                    i11++;
                } else {
                    counterAppend(i11);
                    z11 = !z11;
                    i11 = 1;
                }
                nextUnset++;
            }
            counterAppend(i11);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int toNarrowWidePattern(int i11) {
        int i12;
        int i13 = i11 + 7;
        if (i13 >= this.counterLength) {
            return -1;
        }
        int[] iArr = this.counters;
        int i14 = Integer.MAX_VALUE;
        int i15 = 0;
        int i16 = Integer.MAX_VALUE;
        int i17 = 0;
        for (int i18 = i11; i18 < i13; i18 += 2) {
            int i19 = iArr[i18];
            if (i19 < i16) {
                i16 = i19;
            }
            if (i19 > i17) {
                i17 = i19;
            }
        }
        int i21 = (i16 + i17) / 2;
        int i22 = 0;
        for (int i23 = i11 + 1; i23 < i13; i23 += 2) {
            int i24 = iArr[i23];
            if (i24 < i14) {
                i14 = i24;
            }
            if (i24 > i22) {
                i22 = i24;
            }
        }
        int i25 = (i14 + i22) / 2;
        int i26 = 128;
        int i27 = 0;
        for (int i28 = 0; i28 < 7; i28++) {
            if ((i28 & 1) == 0) {
                i12 = i21;
            } else {
                i12 = i25;
            }
            i26 >>= 1;
            if (iArr[i11 + i28] > i12) {
                i27 |= i26;
            }
        }
        while (true) {
            int[] iArr2 = CHARACTER_ENCODINGS;
            if (i15 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i15] == i27) {
                return i15;
            }
            i15++;
        }
    }

    private void validatePattern(int i11) throws NotFoundException {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.decodeRowResult.length() - 1;
        int i12 = 0;
        int i13 = i11;
        int i14 = 0;
        while (true) {
            int i15 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i14)];
            for (int i16 = 6; i16 >= 0; i16--) {
                int i17 = (i16 & 1) + ((i15 & 1) << 1);
                iArr[i17] = iArr[i17] + this.counters[i13 + i16];
                iArr2[i17] = iArr2[i17] + 1;
                i15 >>= 1;
            }
            if (i14 >= length) {
                break;
            }
            i13 += 8;
            i14++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i18 = 0; i18 < 2; i18++) {
            fArr2[i18] = 0.0f;
            int i19 = i18 + 2;
            float f11 = ((float) iArr[i18]) / ((float) iArr2[i18]);
            int i21 = iArr[i19];
            int i22 = iArr2[i19];
            float f12 = (f11 + (((float) i21) / ((float) i22))) / 2.0f;
            fArr2[i19] = f12;
            fArr[i18] = f12;
            fArr[i19] = ((((float) i21) * 2.0f) + PADDING) / ((float) i22);
        }
        loop3:
        while (true) {
            int i23 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i12)];
            int i24 = 6;
            while (i24 >= 0) {
                int i25 = (i24 & 1) + ((i23 & 1) << 1);
                float f13 = (float) this.counters[i11 + i24];
                if (f13 >= fArr2[i25] && f13 <= fArr[i25]) {
                    i23 >>= 1;
                    i24--;
                }
            }
            if (i12 < length) {
                i11 += 8;
                i12++;
            } else {
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0101 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result decodeRow(int r11, com.google.zxing.common.BitArray r12, java.util.Map<com.google.zxing.DecodeHintType, ?> r13) throws com.google.zxing.NotFoundException {
        /*
            r10 = this;
            int[] r0 = r10.counters
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            r10.setCounters(r12)
            int r12 = r10.findStartPattern()
            java.lang.StringBuilder r0 = r10.decodeRowResult
            r0.setLength(r1)
            r0 = r12
        L_0x0013:
            int r2 = r10.toNarrowWidePattern(r0)
            r3 = -1
            if (r2 == r3) goto L_0x0101
            java.lang.StringBuilder r4 = r10.decodeRowResult
            char r5 = (char) r2
            r4.append(r5)
            int r0 = r0 + 8
            java.lang.StringBuilder r4 = r10.decodeRowResult
            int r4 = r4.length()
            r5 = 1
            if (r4 <= r5) goto L_0x0037
            char[] r4 = STARTEND_ENCODING
            char[] r6 = ALPHABET
            char r2 = r6[r2]
            boolean r2 = arrayContains(r4, r2)
            if (r2 != 0) goto L_0x003b
        L_0x0037:
            int r2 = r10.counterLength
            if (r0 < r2) goto L_0x0013
        L_0x003b:
            int[] r2 = r10.counters
            int r4 = r0 + -1
            r2 = r2[r4]
            r6 = -8
            r7 = r1
        L_0x0043:
            if (r6 >= r3) goto L_0x004f
            int[] r8 = r10.counters
            int r9 = r0 + r6
            r8 = r8[r9]
            int r7 = r7 + r8
            int r6 = r6 + 1
            goto L_0x0043
        L_0x004f:
            int r3 = r10.counterLength
            r6 = 2
            if (r0 >= r3) goto L_0x005d
            int r7 = r7 / r6
            if (r2 < r7) goto L_0x0058
            goto L_0x005d
        L_0x0058:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x005d:
            r10.validatePattern(r12)
            r0 = r1
        L_0x0061:
            java.lang.StringBuilder r2 = r10.decodeRowResult
            int r2 = r2.length()
            if (r0 >= r2) goto L_0x0079
            java.lang.StringBuilder r2 = r10.decodeRowResult
            char[] r3 = ALPHABET
            char r7 = r2.charAt(r0)
            char r3 = r3[r7]
            r2.setCharAt(r0, r3)
            int r0 = r0 + 1
            goto L_0x0061
        L_0x0079:
            java.lang.StringBuilder r0 = r10.decodeRowResult
            char r0 = r0.charAt(r1)
            char[] r2 = STARTEND_ENCODING
            boolean r0 = arrayContains(r2, r0)
            if (r0 == 0) goto L_0x00fc
            java.lang.StringBuilder r0 = r10.decodeRowResult
            int r3 = r0.length()
            int r3 = r3 - r5
            char r0 = r0.charAt(r3)
            boolean r0 = arrayContains(r2, r0)
            if (r0 == 0) goto L_0x00f7
            java.lang.StringBuilder r0 = r10.decodeRowResult
            int r0 = r0.length()
            r2 = 3
            if (r0 <= r2) goto L_0x00f2
            if (r13 == 0) goto L_0x00ab
            com.google.zxing.DecodeHintType r0 = com.google.zxing.DecodeHintType.RETURN_CODABAR_START_END
            boolean r13 = r13.containsKey(r0)
            if (r13 != 0) goto L_0x00ba
        L_0x00ab:
            java.lang.StringBuilder r13 = r10.decodeRowResult
            int r0 = r13.length()
            int r0 = r0 - r5
            r13.deleteCharAt(r0)
            java.lang.StringBuilder r13 = r10.decodeRowResult
            r13.deleteCharAt(r1)
        L_0x00ba:
            r13 = r1
            r0 = r13
        L_0x00bc:
            if (r13 >= r12) goto L_0x00c6
            int[] r2 = r10.counters
            r2 = r2[r13]
            int r0 = r0 + r2
            int r13 = r13 + 1
            goto L_0x00bc
        L_0x00c6:
            float r13 = (float) r0
        L_0x00c7:
            if (r12 >= r4) goto L_0x00d1
            int[] r2 = r10.counters
            r2 = r2[r12]
            int r0 = r0 + r2
            int r12 = r12 + 1
            goto L_0x00c7
        L_0x00d1:
            float r12 = (float) r0
            com.google.zxing.Result r0 = new com.google.zxing.Result
            java.lang.StringBuilder r2 = r10.decodeRowResult
            java.lang.String r2 = r2.toString()
            com.google.zxing.ResultPoint[] r3 = new com.google.zxing.ResultPoint[r6]
            com.google.zxing.ResultPoint r4 = new com.google.zxing.ResultPoint
            float r11 = (float) r11
            r4.<init>(r13, r11)
            r3[r1] = r4
            com.google.zxing.ResultPoint r13 = new com.google.zxing.ResultPoint
            r13.<init>(r12, r11)
            r3[r5] = r13
            com.google.zxing.BarcodeFormat r11 = com.google.zxing.BarcodeFormat.CODABAR
            r12 = 0
            r0.<init>(r2, r12, r3, r11)
            return r0
        L_0x00f2:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00f7:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00fc:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0101:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.CodaBarReader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
