package androidx.constraintlayout.core.motion.utils;

public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";

    /* renamed from: a  reason: collision with root package name */
    public double[] f10595a;
    private boolean mExtrapolate = true;
    private double[] mT;
    private double mTotalLength = Double.NaN;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f10595a = new double[length2];
        this.mT = dArr;
        this.mY = dArr2;
        if (length2 > 2) {
            int i11 = 0;
            double d11 = 0.0d;
            while (true) {
                double d12 = d11;
                if (i11 < dArr.length) {
                    double d13 = dArr2[i11][0];
                    if (i11 > 0) {
                        Math.hypot(d13 - d11, d13 - d12);
                    }
                    i11++;
                    d11 = d13;
                } else {
                    this.mTotalLength = 0.0d;
                    return;
                }
            }
        }
    }

    private double getLength2D(double d11) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d11 <= dArr[0]) {
            return 0.0d;
        }
        int i11 = length - 1;
        if (d11 >= dArr[i11]) {
            return this.mTotalLength;
        }
        double d12 = 0.0d;
        double d13 = 0.0d;
        double d14 = 0.0d;
        int i12 = 0;
        while (i12 < i11) {
            double[] dArr2 = this.mY[i12];
            double d15 = dArr2[0];
            double d16 = dArr2[1];
            if (i12 > 0) {
                d12 += Math.hypot(d15 - d13, d16 - d14);
            }
            double[] dArr3 = this.mT;
            double d17 = dArr3[i12];
            if (d11 == d17) {
                return d12;
            }
            int i13 = i12 + 1;
            double d18 = dArr3[i13];
            if (d11 < d18) {
                double d19 = (d11 - d17) / (d18 - d17);
                double[][] dArr4 = this.mY;
                double[] dArr5 = dArr4[i12];
                double d21 = dArr5[0];
                double[] dArr6 = dArr4[i13];
                double d22 = 1.0d - d19;
                return d12 + Math.hypot(d16 - ((dArr5[1] * d22) + (dArr6[1] * d19)), d15 - ((d21 * d22) + (dArr6[0] * d19)));
            }
            i12 = i13;
            d13 = d15;
            d14 = d16;
        }
        return 0.0d;
    }

    public void getPos(double d11, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i11 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d12 = dArr2[0];
            if (d11 <= d12) {
                getSlope(d12, this.f10595a);
                for (int i12 = 0; i12 < length2; i12++) {
                    dArr[i12] = this.mY[0][i12] + ((d11 - this.mT[0]) * this.f10595a[i12]);
                }
                return;
            }
            int i13 = length - 1;
            double d13 = dArr2[i13];
            if (d11 >= d13) {
                getSlope(d13, this.f10595a);
                while (i11 < length2) {
                    dArr[i11] = this.mY[i13][i11] + ((d11 - this.mT[i13]) * this.f10595a[i11]);
                    i11++;
                }
                return;
            }
        } else if (d11 <= dArr2[0]) {
            for (int i14 = 0; i14 < length2; i14++) {
                dArr[i14] = this.mY[0][i14];
            }
            return;
        } else {
            int i15 = length - 1;
            if (d11 >= dArr2[i15]) {
                while (i11 < length2) {
                    dArr[i11] = this.mY[i15][i11];
                    i11++;
                }
                return;
            }
        }
        int i16 = 0;
        while (i16 < length - 1) {
            if (d11 == this.mT[i16]) {
                for (int i17 = 0; i17 < length2; i17++) {
                    dArr[i17] = this.mY[i16][i17];
                }
            }
            double[] dArr3 = this.mT;
            int i18 = i16 + 1;
            double d14 = dArr3[i18];
            if (d11 < d14) {
                double d15 = dArr3[i16];
                double d16 = (d11 - d15) / (d14 - d15);
                while (i11 < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i11] = (dArr4[i16][i11] * (1.0d - d16)) + (dArr4[i18][i11] * d16);
                    i11++;
                }
                return;
            }
            i16 = i18;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        if (r13 >= r4) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getSlope(double r13, double[] r15) {
        /*
            r12 = this;
            double[] r0 = r12.mT
            int r1 = r0.length
            double[][] r2 = r12.mY
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0011
        L_0x000f:
            r13 = r4
            goto L_0x001a
        L_0x0011:
            int r4 = r1 + -1
            r4 = r0[r4]
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x001a
            goto L_0x000f
        L_0x001a:
            r0 = r3
        L_0x001b:
            int r4 = r1 + -1
            if (r0 >= r4) goto L_0x0041
            double[] r4 = r12.mT
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x003f
            r13 = r4[r0]
            double r6 = r6 - r13
        L_0x002c:
            if (r3 >= r2) goto L_0x0041
            double[][] r13 = r12.mY
            r14 = r13[r0]
            r8 = r14[r3]
            r13 = r13[r5]
            r10 = r13[r3]
            double r10 = r10 - r8
            double r10 = r10 / r6
            r15[r3] = r10
            int r3 = r3 + 1
            goto L_0x002c
        L_0x003f:
            r0 = r5
            goto L_0x001b
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, double[]):void");
    }

    public double[] getTimePoints() {
        return this.mT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        if (r8 >= r3) goto L_0x000a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double getSlope(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.mT
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x000c
        L_0x000a:
            r8 = r3
            goto L_0x0015
        L_0x000c:
            int r3 = r1 + -1
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0015
            goto L_0x000a
        L_0x0015:
            int r0 = r1 + -1
            if (r2 >= r0) goto L_0x0035
            double[] r0 = r7.mT
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0033
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r8 = r7.mY
            r9 = r8[r2]
            r0 = r9[r10]
            r8 = r8[r3]
            r9 = r8[r10]
            double r9 = r9 - r0
            double r9 = r9 / r4
            return r9
        L_0x0033:
            r2 = r3
            goto L_0x0015
        L_0x0035:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, int):double");
    }

    public void getPos(double d11, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i11 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d12 = dArr[0];
            if (d11 <= d12) {
                getSlope(d12, this.f10595a);
                for (int i12 = 0; i12 < length2; i12++) {
                    fArr[i12] = (float) (this.mY[0][i12] + ((d11 - this.mT[0]) * this.f10595a[i12]));
                }
                return;
            }
            int i13 = length - 1;
            double d13 = dArr[i13];
            if (d11 >= d13) {
                getSlope(d13, this.f10595a);
                while (i11 < length2) {
                    fArr[i11] = (float) (this.mY[i13][i11] + ((d11 - this.mT[i13]) * this.f10595a[i11]));
                    i11++;
                }
                return;
            }
        } else if (d11 <= dArr[0]) {
            for (int i14 = 0; i14 < length2; i14++) {
                fArr[i14] = (float) this.mY[0][i14];
            }
            return;
        } else {
            int i15 = length - 1;
            if (d11 >= dArr[i15]) {
                while (i11 < length2) {
                    fArr[i11] = (float) this.mY[i15][i11];
                    i11++;
                }
                return;
            }
        }
        int i16 = 0;
        while (i16 < length - 1) {
            if (d11 == this.mT[i16]) {
                for (int i17 = 0; i17 < length2; i17++) {
                    fArr[i17] = (float) this.mY[i16][i17];
                }
            }
            double[] dArr2 = this.mT;
            int i18 = i16 + 1;
            double d14 = dArr2[i18];
            if (d11 < d14) {
                double d15 = dArr2[i16];
                double d16 = (d11 - d15) / (d14 - d15);
                while (i11 < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i11] = (float) ((dArr3[i16][i11] * (1.0d - d16)) + (dArr3[i18][i11] * d16));
                    i11++;
                }
                return;
            }
            i16 = i18;
        }
    }

    public double getPos(double d11, int i11) {
        double d12;
        double d13;
        double slope;
        double[] dArr = this.mT;
        int length = dArr.length;
        int i12 = 0;
        if (this.mExtrapolate) {
            double d14 = dArr[0];
            if (d11 <= d14) {
                d12 = this.mY[0][i11];
                d13 = d11 - d14;
                slope = getSlope(d14, i11);
            } else {
                int i13 = length - 1;
                double d15 = dArr[i13];
                if (d11 >= d15) {
                    d12 = this.mY[i13][i11];
                    d13 = d11 - d15;
                    slope = getSlope(d15, i11);
                }
            }
            return d12 + (d13 * slope);
        } else if (d11 <= dArr[0]) {
            return this.mY[0][i11];
        } else {
            int i14 = length - 1;
            if (d11 >= dArr[i14]) {
                return this.mY[i14][i11];
            }
        }
        while (i12 < length - 1) {
            double[] dArr2 = this.mT;
            double d16 = dArr2[i12];
            if (d11 == d16) {
                return this.mY[i12][i11];
            }
            int i15 = i12 + 1;
            double d17 = dArr2[i15];
            if (d11 < d17) {
                double d18 = (d11 - d16) / (d17 - d16);
                double[][] dArr3 = this.mY;
                return (dArr3[i12][i11] * (1.0d - d18)) + (dArr3[i15][i11] * d18);
            }
            i12 = i15;
        }
        return 0.0d;
    }
}
