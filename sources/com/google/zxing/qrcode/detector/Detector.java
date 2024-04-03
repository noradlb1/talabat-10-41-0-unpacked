package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import java.util.Map;

public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float sizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float sizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays)) {
            return sizeOfBlackWhiteBlackRunBothWays2 / 7.0f;
        }
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2)) {
            return sizeOfBlackWhiteBlackRunBothWays / 7.0f;
        }
        return (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f11) throws NotFoundException {
        int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f11) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f11)) / 2) + 7;
        int i11 = round & 3;
        if (i11 == 0) {
            return round + 1;
        }
        if (i11 == 2) {
            return round - 1;
        }
        if (i11 != 3) {
            return round;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i11) {
        float f11;
        float f12;
        float f13;
        float f14 = ((float) i11) - 3.5f;
        if (resultPoint4 != null) {
            f12 = resultPoint4.getX();
            f11 = resultPoint4.getY();
            f13 = f14 - 3.0f;
        } else {
            f12 = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            f11 = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f13 = f14;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f14, 3.5f, f13, f13, 3.5f, f14, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), f12, f11, resultPoint3.getX(), resultPoint3.getY());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i11) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i11, i11, perspectiveTransform);
    }

    private float sizeOfBlackWhiteBlackRun(int i11, int i12, int i13, int i14) {
        boolean z11;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z12;
        Detector detector;
        boolean z13;
        boolean z14 = true;
        if (Math.abs(i14 - i12) > Math.abs(i13 - i11)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i17 = i11;
            i18 = i12;
            i15 = i13;
            i16 = i14;
        } else {
            i18 = i11;
            i17 = i12;
            i16 = i13;
            i15 = i14;
        }
        int abs = Math.abs(i16 - i18);
        int abs2 = Math.abs(i15 - i17);
        int i25 = 2;
        int i26 = (-abs) / 2;
        int i27 = -1;
        if (i18 < i16) {
            i19 = 1;
        } else {
            i19 = -1;
        }
        if (i17 < i15) {
            i27 = 1;
        }
        int i28 = i16 + i19;
        int i29 = i18;
        int i31 = i17;
        int i32 = 0;
        while (true) {
            if (i29 == i28) {
                i21 = i28;
                i22 = i25;
                break;
            }
            if (z11) {
                i23 = i31;
            } else {
                i23 = i29;
            }
            if (z11) {
                i24 = i29;
            } else {
                i24 = i31;
            }
            if (i32 == z14) {
                z12 = z11;
                z13 = z14;
                i21 = i28;
                detector = this;
            } else {
                detector = this;
                z12 = z11;
                i21 = i28;
                z13 = false;
            }
            if (z13 == detector.image.get(i23, i24)) {
                if (i32 == 2) {
                    return MathUtils.distance(i29, i31, i18, i17);
                }
                i32++;
            }
            i26 += abs2;
            if (i26 > 0) {
                if (i31 == i15) {
                    i22 = 2;
                    break;
                }
                i31 += i27;
                i26 -= abs;
            }
            i29 += i19;
            i28 = i21;
            z11 = z12;
            z14 = true;
            i25 = 2;
        }
        if (i32 == i22) {
            return MathUtils.distance(i21, i15, i18, i17);
        }
        return Float.NaN;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i11, int i12, int i13, int i14) {
        float f11;
        float f12;
        float sizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i11, i12, i13, i14);
        int i15 = i11 - (i13 - i11);
        int i16 = 0;
        if (i15 < 0) {
            f11 = ((float) i11) / ((float) (i11 - i15));
            i15 = 0;
        } else if (i15 >= this.image.getWidth()) {
            f11 = ((float) ((this.image.getWidth() - 1) - i11)) / ((float) (i15 - i11));
            i15 = this.image.getWidth() - 1;
        } else {
            f11 = 1.0f;
        }
        float f13 = (float) i12;
        int i17 = (int) (f13 - (((float) (i14 - i12)) * f11));
        if (i17 < 0) {
            f12 = f13 / ((float) (i12 - i17));
        } else if (i17 >= this.image.getHeight()) {
            f12 = ((float) ((this.image.getHeight() - 1) - i12)) / ((float) (i17 - i12));
            i16 = this.image.getHeight() - 1;
        } else {
            i16 = i17;
            f12 = 1.0f;
        }
        return (sizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i11, i12, (int) (((float) i11) + (((float) (i15 - i11)) * f12)), i16)) - 1.0f;
    }

    public final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect((Map<DecodeHintType, ?>) null);
    }

    public final AlignmentPattern findAlignmentInRegion(float f11, int i11, int i12, float f12) throws NotFoundException {
        int i13 = (int) (f12 * f11);
        int max = Math.max(0, i11 - i13);
        int min = Math.min(this.image.getWidth() - 1, i11 + i13) - max;
        float f13 = 3.0f * f11;
        if (((float) min) >= f13) {
            int max2 = Math.max(0, i12 - i13);
            int min2 = Math.min(this.image.getHeight() - 1, i12 + i13) - max2;
            if (((float) min2) >= f13) {
                return new AlignmentPatternFinder(this.image, max, max2, min, min2, f11, this.resultPointCallback).find();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.common.DetectorResult processFinderPatternInfo(com.google.zxing.qrcode.detector.FinderPatternInfo r11) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        /*
            r10 = this;
            com.google.zxing.qrcode.detector.FinderPattern r0 = r11.getTopLeft()
            com.google.zxing.qrcode.detector.FinderPattern r1 = r11.getTopRight()
            com.google.zxing.qrcode.detector.FinderPattern r11 = r11.getBottomLeft()
            float r2 = r10.calculateModuleSize(r0, r1, r11)
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 < 0) goto L_0x009e
            int r4 = computeDimension(r0, r1, r11, r2)
            com.google.zxing.qrcode.decoder.Version r5 = com.google.zxing.qrcode.decoder.Version.getProvisionalVersionForDimension(r4)
            int r6 = r5.getDimensionForVersion()
            int r6 = r6 + -7
            int[] r5 = r5.getAlignmentPatternCenters()
            int r5 = r5.length
            r7 = 4
            if (r5 <= 0) goto L_0x0073
            float r5 = r1.getX()
            float r8 = r0.getX()
            float r5 = r5 - r8
            float r8 = r11.getX()
            float r5 = r5 + r8
            float r8 = r1.getY()
            float r9 = r0.getY()
            float r8 = r8 - r9
            float r9 = r11.getY()
            float r8 = r8 + r9
            r9 = 1077936128(0x40400000, float:3.0)
            float r6 = (float) r6
            float r9 = r9 / r6
            float r3 = r3 - r9
            float r6 = r0.getX()
            float r9 = r0.getX()
            float r5 = r5 - r9
            float r5 = r5 * r3
            float r6 = r6 + r5
            int r5 = (int) r6
            float r6 = r0.getY()
            float r9 = r0.getY()
            float r8 = r8 - r9
            float r3 = r3 * r8
            float r6 = r6 + r3
            int r3 = (int) r6
            r6 = r7
        L_0x0066:
            r8 = 16
            if (r6 > r8) goto L_0x0073
            float r8 = (float) r6
            com.google.zxing.qrcode.detector.AlignmentPattern r2 = r10.findAlignmentInRegion(r2, r5, r3, r8)     // Catch:{ NotFoundException -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            int r6 = r6 << 1
            goto L_0x0066
        L_0x0073:
            r2 = 0
        L_0x0074:
            com.google.zxing.common.PerspectiveTransform r3 = createTransform(r0, r1, r11, r2, r4)
            com.google.zxing.common.BitMatrix r5 = r10.image
            com.google.zxing.common.BitMatrix r3 = sampleGrid(r5, r3, r4)
            r4 = 3
            r5 = 2
            r6 = 0
            r8 = 1
            if (r2 != 0) goto L_0x008d
            com.google.zxing.ResultPoint[] r2 = new com.google.zxing.ResultPoint[r4]
            r2[r6] = r11
            r2[r8] = r0
            r2[r5] = r1
            goto L_0x0098
        L_0x008d:
            com.google.zxing.ResultPoint[] r7 = new com.google.zxing.ResultPoint[r7]
            r7[r6] = r11
            r7[r8] = r0
            r7[r5] = r1
            r7[r4] = r2
            r2 = r7
        L_0x0098:
            com.google.zxing.common.DetectorResult r11 = new com.google.zxing.common.DetectorResult
            r11.<init>(r3, r2)
            return r11
        L_0x009e:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.Detector.processFinderPatternInfo(com.google.zxing.qrcode.detector.FinderPatternInfo):com.google.zxing.common.DetectorResult");
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPointCallback resultPointCallback2;
        if (map == null) {
            resultPointCallback2 = null;
        } else {
            resultPointCallback2 = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        this.resultPointCallback = resultPointCallback2;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, resultPointCallback2).find(map));
    }
}
