package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

final class AlignmentPatternFinder {
    private final int[] crossCheckStateCount;
    private final int height;
    private final BitMatrix image;
    private final float moduleSize;
    private final List<AlignmentPattern> possibleCenters = new ArrayList(5);
    private final ResultPointCallback resultPointCallback;
    private final int startX;
    private final int startY;
    private final int width;

    public AlignmentPatternFinder(BitMatrix bitMatrix, int i11, int i12, int i13, int i14, float f11, ResultPointCallback resultPointCallback2) {
        this.image = bitMatrix;
        this.startX = i11;
        this.startY = i12;
        this.width = i13;
        this.height = i14;
        this.moduleSize = f11;
        this.crossCheckStateCount = new int[3];
        this.resultPointCallback = resultPointCallback2;
    }

    private static float centerFromEnd(int[] iArr, int i11) {
        return ((float) (i11 - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private float crossCheckVertical(int i11, int i12, int i13, int i14) {
        BitMatrix bitMatrix = this.image;
        int height2 = bitMatrix.getHeight();
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i15 = i11;
        while (i15 >= 0 && bitMatrix.get(i12, i15)) {
            int i16 = iArr[1];
            if (i16 > i13) {
                break;
            }
            iArr[1] = i16 + 1;
            i15--;
        }
        if (i15 >= 0 && iArr[1] <= i13) {
            while (i15 >= 0 && !bitMatrix.get(i12, i15)) {
                int i17 = iArr[0];
                if (i17 > i13) {
                    break;
                }
                iArr[0] = i17 + 1;
                i15--;
            }
            if (iArr[0] > i13) {
                return Float.NaN;
            }
            int i18 = i11 + 1;
            while (i18 < height2 && bitMatrix.get(i12, i18)) {
                int i19 = iArr[1];
                if (i19 > i13) {
                    break;
                }
                iArr[1] = i19 + 1;
                i18++;
            }
            if (i18 != height2 && iArr[1] <= i13) {
                while (i18 < height2 && !bitMatrix.get(i12, i18)) {
                    int i21 = iArr[2];
                    if (i21 > i13) {
                        break;
                    }
                    iArr[2] = i21 + 1;
                    i18++;
                }
                int i22 = iArr[2];
                if (i22 <= i13 && Math.abs(((iArr[0] + iArr[1]) + i22) - i14) * 5 < i14 * 2 && foundPatternCross(iArr)) {
                    return centerFromEnd(iArr, i18);
                }
            }
        }
        return Float.NaN;
    }

    private boolean foundPatternCross(int[] iArr) {
        float f11 = this.moduleSize;
        float f12 = f11 / 2.0f;
        for (int i11 = 0; i11 < 3; i11++) {
            if (Math.abs(f11 - ((float) iArr[i11])) >= f12) {
                return false;
            }
        }
        return true;
    }

    private AlignmentPattern handlePossibleCenter(int[] iArr, int i11, int i12) {
        int i13 = iArr[0] + iArr[1] + iArr[2];
        float centerFromEnd = centerFromEnd(iArr, i12);
        float crossCheckVertical = crossCheckVertical(i11, (int) centerFromEnd, iArr[1] * 2, i13);
        if (Float.isNaN(crossCheckVertical)) {
            return null;
        }
        float f11 = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
        for (AlignmentPattern next : this.possibleCenters) {
            if (next.aboutEquals(f11, crossCheckVertical, centerFromEnd)) {
                return next.combineEstimate(crossCheckVertical, centerFromEnd, f11);
            }
        }
        AlignmentPattern alignmentPattern = new AlignmentPattern(centerFromEnd, crossCheckVertical, f11);
        this.possibleCenters.add(alignmentPattern);
        ResultPointCallback resultPointCallback2 = this.resultPointCallback;
        if (resultPointCallback2 == null) {
            return null;
        }
        resultPointCallback2.foundPossibleResultPoint(alignmentPattern);
        return null;
    }

    public AlignmentPattern find() throws NotFoundException {
        int i11;
        AlignmentPattern handlePossibleCenter;
        AlignmentPattern handlePossibleCenter2;
        int i12 = this.startX;
        int i13 = this.height;
        int i14 = this.width + i12;
        int i15 = this.startY + (i13 / 2);
        int[] iArr = new int[3];
        for (int i16 = 0; i16 < i13; i16++) {
            if ((i16 & 1) == 0) {
                i11 = (i16 + 1) / 2;
            } else {
                i11 = -((i16 + 1) / 2);
            }
            int i17 = i11 + i15;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i18 = i12;
            while (i18 < i14 && !this.image.get(i18, i17)) {
                i18++;
            }
            int i19 = 0;
            while (i18 < i14) {
                if (!this.image.get(i18, i17)) {
                    if (i19 == 1) {
                        i19++;
                    }
                    iArr[i19] = iArr[i19] + 1;
                } else if (i19 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i19 != 2) {
                    i19++;
                    iArr[i19] = iArr[i19] + 1;
                } else if (foundPatternCross(iArr) && (handlePossibleCenter2 = handlePossibleCenter(iArr, i17, i18)) != null) {
                    return handlePossibleCenter2;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i19 = 1;
                }
                i18++;
            }
            if (foundPatternCross(iArr) && (handlePossibleCenter = handlePossibleCenter(iArr, i17, i14)) != null) {
                return handlePossibleCenter;
            }
        }
        if (!this.possibleCenters.isEmpty()) {
            return this.possibleCenters.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
