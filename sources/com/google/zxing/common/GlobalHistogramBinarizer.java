package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

public class GlobalHistogramBinarizer extends Binarizer {
    private static final byte[] EMPTY = new byte[0];
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets = new int[32];
    private byte[] luminances = EMPTY;

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private static int estimateBlackPoint(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            int i15 = iArr[i14];
            if (i15 > i11) {
                i13 = i14;
                i11 = i15;
            }
            if (i15 > i12) {
                i12 = i15;
            }
        }
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < length; i18++) {
            int i19 = i18 - i13;
            int i21 = iArr[i18] * i19 * i19;
            if (i21 > i17) {
                i16 = i18;
                i17 = i21;
            }
        }
        if (i13 <= i16) {
            int i22 = i13;
            i13 = i16;
            i16 = i22;
        }
        if (i13 - i16 > length / 16) {
            int i23 = i13 - 1;
            int i24 = -1;
            int i25 = i23;
            while (i23 > i16) {
                int i26 = i23 - i16;
                int i27 = i26 * i26 * (i13 - i23) * (i12 - iArr[i23]);
                if (i27 > i24) {
                    i25 = i23;
                    i24 = i27;
                }
                i23--;
            }
            return i25 << 3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void initArrays(int i11) {
        if (this.luminances.length < i11) {
            this.luminances = new byte[i11];
        }
        for (int i12 = 0; i12 < 32; i12++) {
            this.buckets[i12] = 0;
        }
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        for (int i11 = 1; i11 < 5; i11++) {
            byte[] row = luminanceSource.getRow((height * i11) / 5, this.luminances);
            int i12 = (width << 2) / 5;
            for (int i13 = width / 5; i13 < i12; i13++) {
                int i14 = (row[i13] & 255) >> 3;
                iArr[i14] = iArr[i14] + 1;
            }
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (int i15 = 0; i15 < height; i15++) {
            int i16 = i15 * width;
            for (int i17 = 0; i17 < width; i17++) {
                if ((matrix[i16 + i17] & 255) < estimateBlackPoint) {
                    bitMatrix.set(i17, i15);
                }
            }
        }
        return bitMatrix;
    }

    public BitArray getBlackRow(int i11, BitArray bitArray) throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new BitArray(width);
        } else {
            bitArray.clear();
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i11, this.luminances);
        int[] iArr = this.buckets;
        for (int i12 = 0; i12 < width; i12++) {
            int i13 = (row[i12] & 255) >> 3;
            iArr[i13] = iArr[i13] + 1;
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        if (width < 3) {
            for (int i14 = 0; i14 < width; i14++) {
                if ((row[i14] & 255) < estimateBlackPoint) {
                    bitArray.set(i14);
                }
            }
        } else {
            int i15 = 1;
            byte b11 = row[1] & 255;
            byte b12 = row[0] & 255;
            byte b13 = b11;
            while (i15 < width - 1) {
                int i16 = i15 + 1;
                byte b14 = row[i16] & 255;
                if ((((b13 << 2) - b12) - b14) / 2 < estimateBlackPoint) {
                    bitArray.set(i15);
                }
                b12 = b13;
                i15 = i16;
                b13 = b14;
            }
        }
        return bitArray;
    }
}
