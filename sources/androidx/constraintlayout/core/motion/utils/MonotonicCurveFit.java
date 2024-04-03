package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";

    /* renamed from: a  reason: collision with root package name */
    public double[] f10596a;
    private boolean mExtrapolate = true;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        double[] dArr3 = dArr;
        double[][] dArr4 = dArr2;
        int length = dArr3.length;
        int length2 = dArr4[0].length;
        this.f10596a = new double[length2];
        int i11 = length - 1;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = i11;
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = length2;
        iArr2[0] = length;
        double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
        for (int i12 = 0; i12 < length2; i12++) {
            int i13 = 0;
            while (i13 < i11) {
                int i14 = i13 + 1;
                double d11 = dArr3[i14] - dArr3[i13];
                double[] dArr7 = dArr5[i13];
                double d12 = (dArr4[i14][i12] - dArr4[i13][i12]) / d11;
                dArr7[i12] = d12;
                if (i13 == 0) {
                    dArr6[i13][i12] = d12;
                } else {
                    dArr6[i13][i12] = (dArr5[i13 - 1][i12] + d12) * 0.5d;
                }
                i13 = i14;
            }
            dArr6[i11][i12] = dArr5[length - 2][i12];
        }
        for (int i15 = 0; i15 < i11; i15++) {
            for (int i16 = 0; i16 < length2; i16++) {
                double d13 = dArr5[i15][i16];
                if (d13 == 0.0d) {
                    dArr6[i15][i16] = 0.0d;
                    dArr6[i15 + 1][i16] = 0.0d;
                } else {
                    double d14 = dArr6[i15][i16] / d13;
                    int i17 = i15 + 1;
                    double d15 = dArr6[i17][i16] / d13;
                    double hypot = Math.hypot(d14, d15);
                    if (hypot > 9.0d) {
                        double d16 = 3.0d / hypot;
                        double[] dArr8 = dArr6[i15];
                        double[] dArr9 = dArr5[i15];
                        dArr8[i16] = d14 * d16 * dArr9[i16];
                        dArr6[i17][i16] = d16 * d15 * dArr9[i16];
                    }
                }
            }
        }
        this.mT = dArr3;
        this.mY = dArr4;
        this.mTangent = dArr6;
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[(str.length() / 2)];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i11 = 0;
        while (indexOf2 != -1) {
            dArr[i11] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i11++;
        }
        dArr[i11] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        return buildWave(Arrays.copyOf(dArr, i11 + 1));
    }

    private static double diff(double d11, double d12, double d13, double d14, double d15, double d16) {
        double d17 = d12 * d12;
        double d18 = d12 * 6.0d;
        double d19 = 3.0d * d11;
        return (((((((((-6.0d * d17) * d14) + (d18 * d14)) + ((6.0d * d17) * d13)) - (d18 * d13)) + ((d19 * d16) * d17)) + ((d19 * d15) * d17)) - (((2.0d * d11) * d16) * d12)) - (((4.0d * d11) * d15) * d12)) + (d11 * d15);
    }

    private static double interpolate(double d11, double d12, double d13, double d14, double d15, double d16) {
        double d17 = d12 * d12;
        double d18 = d17 * d12;
        double d19 = 3.0d * d17;
        double d21 = d11 * d16;
        double d22 = d11 * d15;
        return ((((((((((-2.0d * d18) * d14) + (d19 * d14)) + ((d18 * 2.0d) * d13)) - (d19 * d13)) + d13) + (d21 * d18)) + (d18 * d22)) - (d21 * d17)) - (((d11 * 2.0d) * d15) * d17)) + (d22 * d12);
    }

    public void getPos(double d11, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i11 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d12 = dArr2[0];
            if (d11 <= d12) {
                getSlope(d12, this.f10596a);
                for (int i12 = 0; i12 < length2; i12++) {
                    dArr[i12] = this.mY[0][i12] + ((d11 - this.mT[0]) * this.f10596a[i12]);
                }
                return;
            }
            int i13 = length - 1;
            double d13 = dArr2[i13];
            if (d11 >= d13) {
                getSlope(d13, this.f10596a);
                while (i11 < length2) {
                    dArr[i11] = this.mY[i13][i11] + ((d11 - this.mT[i13]) * this.f10596a[i11]);
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
                double d16 = d14 - d15;
                double d17 = (d11 - d15) / d16;
                while (i11 < length2) {
                    double[][] dArr4 = this.mY;
                    double d18 = dArr4[i16][i11];
                    double d19 = dArr4[i18][i11];
                    double[][] dArr5 = this.mTangent;
                    dArr[i11] = interpolate(d16, d17, d18, d19, dArr5[i16][i11], dArr5[i18][i11]);
                    i11++;
                }
                return;
            }
            i16 = i18;
        }
    }

    public void getSlope(double d11, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d12 = dArr2[0];
        if (d11 > d12) {
            d12 = dArr2[length - 1];
            if (d11 < d12) {
                d12 = d11;
            }
        }
        int i11 = 0;
        while (i11 < length - 1) {
            double[] dArr3 = this.mT;
            int i12 = i11 + 1;
            double d13 = dArr3[i12];
            if (d12 <= d13) {
                double d14 = dArr3[i11];
                double d15 = d13 - d14;
                double d16 = (d12 - d14) / d15;
                for (int i13 = 0; i13 < length2; i13++) {
                    double[][] dArr4 = this.mY;
                    double d17 = dArr4[i11][i13];
                    double d18 = dArr4[i12][i13];
                    double[][] dArr5 = this.mTangent;
                    dArr[i13] = diff(d15, d16, d17, d18, dArr5[i11][i13], dArr5[i12][i13]) / d15;
                }
                return;
            }
            i11 = i12;
        }
    }

    public double[] getTimePoints() {
        return this.mT;
    }

    private static MonotonicCurveFit buildWave(double[] dArr) {
        double[] dArr2 = dArr;
        int length = (dArr2.length * 3) - 2;
        int length2 = dArr2.length - 1;
        double d11 = 1.0d / ((double) length2);
        int[] iArr = new int[2];
        iArr[1] = 1;
        iArr[0] = length;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, iArr);
        double[] dArr4 = new double[length];
        for (int i11 = 0; i11 < dArr2.length; i11++) {
            double d12 = dArr2[i11];
            int i12 = i11 + length2;
            dArr3[i12][0] = d12;
            double d13 = ((double) i11) * d11;
            dArr4[i12] = d13;
            if (i11 > 0) {
                int i13 = (length2 * 2) + i11;
                dArr3[i13][0] = d12 + 1.0d;
                dArr4[i13] = d13 + 1.0d;
                int i14 = i11 - 1;
                dArr3[i14][0] = (d12 - 1.0d) - d11;
                dArr4[i14] = (d13 - 4.0d) - d11;
            }
        }
        return new MonotonicCurveFit(dArr4, dArr3);
    }

    public double getSlope(double d11, int i11) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i12 = 0;
        double d12 = dArr[0];
        if (d11 >= d12) {
            d12 = dArr[length - 1];
            if (d11 < d12) {
                d12 = d11;
            }
        }
        while (i12 < length - 1) {
            double[] dArr2 = this.mT;
            int i13 = i12 + 1;
            double d13 = dArr2[i13];
            if (d12 <= d13) {
                double d14 = dArr2[i12];
                double d15 = d13 - d14;
                double[][] dArr3 = this.mY;
                double d16 = dArr3[i12][i11];
                double d17 = dArr3[i13][i11];
                double[][] dArr4 = this.mTangent;
                return diff(d15, (d12 - d14) / d15, d16, d17, dArr4[i12][i11], dArr4[i13][i11]) / d15;
            }
            i12 = i13;
        }
        return 0.0d;
    }

    public void getPos(double d11, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i11 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d12 = dArr[0];
            if (d11 <= d12) {
                getSlope(d12, this.f10596a);
                for (int i12 = 0; i12 < length2; i12++) {
                    fArr[i12] = (float) (this.mY[0][i12] + ((d11 - this.mT[0]) * this.f10596a[i12]));
                }
                return;
            }
            int i13 = length - 1;
            double d13 = dArr[i13];
            if (d11 >= d13) {
                getSlope(d13, this.f10596a);
                while (i11 < length2) {
                    fArr[i11] = (float) (this.mY[i13][i11] + ((d11 - this.mT[i13]) * this.f10596a[i11]));
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
                double d16 = d14 - d15;
                double d17 = (d11 - d15) / d16;
                while (i11 < length2) {
                    double[][] dArr3 = this.mY;
                    double d18 = dArr3[i16][i11];
                    double d19 = dArr3[i18][i11];
                    double[][] dArr4 = this.mTangent;
                    fArr[i11] = (float) interpolate(d16, d17, d18, d19, dArr4[i16][i11], dArr4[i18][i11]);
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
        int i12 = i11;
        double[] dArr = this.mT;
        int length = dArr.length;
        int i13 = 0;
        if (this.mExtrapolate) {
            double d14 = dArr[0];
            if (d11 <= d14) {
                d12 = this.mY[0][i12];
                d13 = d11 - d14;
                slope = getSlope(d14, i12);
            } else {
                int i14 = length - 1;
                double d15 = dArr[i14];
                if (d11 >= d15) {
                    d12 = this.mY[i14][i12];
                    d13 = d11 - d15;
                    slope = getSlope(d15, i12);
                }
            }
            return d12 + (d13 * slope);
        } else if (d11 <= dArr[0]) {
            return this.mY[0][i12];
        } else {
            int i15 = length - 1;
            if (d11 >= dArr[i15]) {
                return this.mY[i15][i12];
            }
        }
        while (i13 < length - 1) {
            double[] dArr2 = this.mT;
            double d16 = dArr2[i13];
            if (d11 == d16) {
                return this.mY[i13][i12];
            }
            int i16 = i13 + 1;
            double d17 = dArr2[i16];
            if (d11 < d17) {
                double d18 = d17 - d16;
                double d19 = (d11 - d16) / d18;
                double[][] dArr3 = this.mY;
                double d21 = dArr3[i13][i12];
                double d22 = dArr3[i16][i12];
                double[][] dArr4 = this.mTangent;
                return interpolate(d18, d19, d21, d22, dArr4[i13][i12], dArr4[i16][i12]);
            }
            i13 = i16;
        }
        return 0.0d;
    }
}
