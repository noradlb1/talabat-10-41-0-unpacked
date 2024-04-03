package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            resultPointArr[iArr[i11]] = resultPointArr2[i11];
        }
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z11) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> detect = detect(z11, blackMatrix);
        if (detect.isEmpty()) {
            blackMatrix = blackMatrix.clone();
            blackMatrix.rotate180();
            detect = detect(z11, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, detect);
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i11, int i12, int i13, boolean z11, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i14 = 0;
        while (bitMatrix.get(i11, i12) && i11 > 0) {
            int i15 = i14 + 1;
            if (i14 >= 3) {
                break;
            }
            i11--;
            i14 = i15;
        }
        int length = iArr.length;
        boolean z12 = z11;
        int i16 = 0;
        int i17 = i11;
        while (i11 < i13) {
            if (bitMatrix.get(i11, i12) != z12) {
                iArr2[i16] = iArr2[i16] + 1;
            } else {
                if (i16 != length - 1) {
                    i16++;
                } else if (patternMatchVariance(iArr2, iArr, 0.8f) < 0.42f) {
                    return new int[]{i17, i11};
                } else {
                    i17 += iArr2[0] + iArr2[1];
                    int i18 = i16 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i18);
                    iArr2[i18] = 0;
                    iArr2[i16] = 0;
                    i16--;
                }
                iArr2[i16] = 1;
                z12 = !z12;
            }
            i11++;
        }
        if (i16 != length - 1 || patternMatchVariance(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i17, i11 - 1};
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i11, int i12, int i13, int i14, int[] iArr) {
        boolean z11;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i19 = i13;
        while (true) {
            if (i19 >= i18) {
                z11 = false;
                break;
            }
            int[] findGuardPattern = findGuardPattern(bitMatrix, i14, i19, i12, false, iArr, iArr2);
            if (findGuardPattern != null) {
                int i21 = i19;
                int[] iArr3 = findGuardPattern;
                int i22 = i21;
                while (true) {
                    if (i22 <= 0) {
                        i17 = i22;
                        break;
                    }
                    int i23 = i22 - 1;
                    int[] findGuardPattern2 = findGuardPattern(bitMatrix, i14, i23, i12, false, iArr, iArr2);
                    if (findGuardPattern2 == null) {
                        i17 = i23 + 1;
                        break;
                    }
                    iArr3 = findGuardPattern2;
                    i22 = i23;
                }
                float f11 = (float) i17;
                resultPointArr[0] = new ResultPoint((float) iArr3[0], f11);
                resultPointArr[1] = new ResultPoint((float) iArr3[1], f11);
                z11 = true;
                i19 = i17;
            } else {
                i19 += 5;
            }
        }
        int i24 = i19 + 1;
        if (z11) {
            int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i25 = i24;
            int i26 = 0;
            while (true) {
                if (i25 >= i18) {
                    i15 = i26;
                    i16 = i25;
                    break;
                }
                i15 = i26;
                i16 = i25;
                int[] findGuardPattern3 = findGuardPattern(bitMatrix, iArr4[0], i25, i12, false, iArr, iArr2);
                if (findGuardPattern3 == null || Math.abs(iArr4[0] - findGuardPattern3[0]) >= 5 || Math.abs(iArr4[1] - findGuardPattern3[1]) >= 5) {
                    if (i15 > 25) {
                        break;
                    }
                    i26 = i15 + 1;
                } else {
                    iArr4 = findGuardPattern3;
                    i26 = 0;
                }
                i25 = i16 + 1;
            }
            i24 = i16 - (i15 + 1);
            float f12 = (float) i24;
            resultPointArr[2] = new ResultPoint((float) iArr4[0], f12);
            resultPointArr[3] = new ResultPoint((float) iArr4[1], f12);
        }
        if (i24 - i19 < 10) {
            Arrays.fill(resultPointArr, (Object) null);
        }
        return resultPointArr;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i11, int i12) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i11, i12, START_PATTERN), INDEXES_START_PATTERN);
        ResultPoint resultPoint = resultPointArr[4];
        if (resultPoint != null) {
            i12 = (int) resultPoint.getX();
            i11 = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i11, i12, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2, float f11) {
        float f12;
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            i11 += iArr[i13];
            i12 += iArr2[i13];
        }
        if (i11 < i12) {
            return Float.POSITIVE_INFINITY;
        }
        float f13 = (float) i11;
        float f14 = f13 / ((float) i12);
        float f15 = f11 * f14;
        float f16 = 0.0f;
        for (int i14 = 0; i14 < length; i14++) {
            int i15 = iArr[i14];
            float f17 = ((float) iArr2[i14]) * f14;
            float f18 = (float) i15;
            if (f18 > f17) {
                f12 = f18 - f17;
            } else {
                f12 = f17 - f18;
            }
            if (f12 > f15) {
                return Float.POSITIVE_INFINITY;
            }
            f16 += f12;
        }
        return f16 / f13;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r3.hasNext() == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r4 = (com.google.zxing.ResultPoint[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r7 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r2 = (int) java.lang.Math.max((float) r2, r7.getY());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r4 = r4[3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r4 == null) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r2 = java.lang.Math.max(r2, (int) r4.getY());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r4 == 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r3 = r0.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.zxing.ResultPoint[]> detect(boolean r8, com.google.zxing.common.BitMatrix r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0008:
            r4 = r3
        L_0x0009:
            int r5 = r9.getHeight()
            if (r2 >= r5) goto L_0x0077
            com.google.zxing.ResultPoint[] r3 = findVertices(r9, r2, r3)
            r5 = r3[r1]
            r6 = 1
            if (r5 != 0) goto L_0x004f
            r5 = 3
            r7 = r3[r5]
            if (r7 != 0) goto L_0x004f
            if (r4 == 0) goto L_0x0077
            java.util.Iterator r3 = r0.iterator()
        L_0x0023:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x004b
            java.lang.Object r4 = r3.next()
            com.google.zxing.ResultPoint[] r4 = (com.google.zxing.ResultPoint[]) r4
            r7 = r4[r6]
            if (r7 == 0) goto L_0x003d
            float r2 = (float) r2
            float r7 = r7.getY()
            float r2 = java.lang.Math.max(r2, r7)
            int r2 = (int) r2
        L_0x003d:
            r4 = r4[r5]
            if (r4 == 0) goto L_0x0023
            float r4 = r4.getY()
            int r4 = (int) r4
            int r2 = java.lang.Math.max(r2, r4)
            goto L_0x0023
        L_0x004b:
            int r2 = r2 + 5
            r3 = r1
            goto L_0x0008
        L_0x004f:
            r0.add(r3)
            if (r8 == 0) goto L_0x0077
            r2 = 2
            r4 = r3[r2]
            if (r4 == 0) goto L_0x0065
            float r4 = r4.getX()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.getY()
            goto L_0x0073
        L_0x0065:
            r2 = 4
            r4 = r3[r2]
            float r4 = r4.getX()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.getY()
        L_0x0073:
            int r2 = (int) r2
            r3 = r4
            r4 = r6
            goto L_0x0009
        L_0x0077:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.detector.Detector.detect(boolean, com.google.zxing.common.BitMatrix):java.util.List");
    }
}
