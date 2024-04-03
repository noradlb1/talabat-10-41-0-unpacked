package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

public class HyperSpline {

    /* renamed from: a  reason: collision with root package name */
    public int f10552a;

    /* renamed from: b  reason: collision with root package name */
    public Cubic[][] f10553b;

    /* renamed from: c  reason: collision with root package name */
    public int f10554c;

    /* renamed from: d  reason: collision with root package name */
    public double[] f10555d;

    /* renamed from: e  reason: collision with root package name */
    public double f10556e;

    /* renamed from: f  reason: collision with root package name */
    public double[][] f10557f;

    public static class Cubic {

        /* renamed from: a  reason: collision with root package name */
        public double f10558a;

        /* renamed from: b  reason: collision with root package name */
        public double f10559b;

        /* renamed from: c  reason: collision with root package name */
        public double f10560c;

        /* renamed from: d  reason: collision with root package name */
        public double f10561d;

        public Cubic(double d11, double d12, double d13, double d14) {
            this.f10558a = d11;
            this.f10559b = d12;
            this.f10560c = d13;
            this.f10561d = d14;
        }

        public double eval(double d11) {
            return (((((this.f10561d * d11) + this.f10560c) * d11) + this.f10559b) * d11) + this.f10558a;
        }

        public double vel(double d11) {
            return (((this.f10561d * 3.0d * d11) + (this.f10560c * 2.0d)) * d11) + this.f10559b;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public static Cubic[] a(int i11, double[] dArr) {
        int i12 = i11;
        double[] dArr2 = new double[i12];
        double[] dArr3 = new double[i12];
        double[] dArr4 = new double[i12];
        int i13 = i12 - 1;
        int i14 = 0;
        dArr2[0] = 0.5d;
        int i15 = 1;
        for (int i16 = 1; i16 < i13; i16++) {
            dArr2[i16] = 1.0d / (4.0d - dArr2[i16 - 1]);
        }
        int i17 = i13 - 1;
        dArr2[i13] = 1.0d / (2.0d - dArr2[i17]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i15 < i13) {
            int i18 = i15 + 1;
            int i19 = i15 - 1;
            dArr3[i15] = (((dArr[i18] - dArr[i19]) * 3.0d) - dArr3[i19]) * dArr2[i15];
            i15 = i18;
        }
        double d11 = (((dArr[i13] - dArr[i17]) * 3.0d) - dArr3[i17]) * dArr2[i13];
        dArr3[i13] = d11;
        dArr4[i13] = d11;
        while (i17 >= 0) {
            dArr4[i17] = dArr3[i17] - (dArr2[i17] * dArr4[i17 + 1]);
            i17--;
        }
        Cubic[] cubicArr = new Cubic[i13];
        while (i14 < i13) {
            double d12 = dArr[i14];
            double d13 = dArr4[i14];
            int i21 = i14 + 1;
            double d14 = dArr[i21];
            double d15 = dArr4[i21];
            cubicArr[i14] = new Cubic((double) ((float) d12), d13, (((d14 - d12) * 3.0d) - (d13 * 2.0d)) - d15, ((d12 - d14) * 2.0d) + d13 + d15);
            i14 = i21;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i11;
        Cubic[] cubicArr2 = cubicArr;
        int length = cubicArr2.length;
        double[] dArr = new double[cubicArr2.length];
        double d11 = 0.0d;
        double d12 = 0.0d;
        double d13 = 0.0d;
        while (true) {
            i11 = 0;
            if (d12 >= 1.0d) {
                break;
            }
            double d14 = 0.0d;
            while (i11 < cubicArr2.length) {
                double d15 = dArr[i11];
                double eval = cubicArr2[i11].eval(d12);
                dArr[i11] = eval;
                double d16 = d15 - eval;
                d14 += d16 * d16;
                i11++;
            }
            if (d12 > 0.0d) {
                d13 += Math.sqrt(d14);
            }
            d12 += 0.1d;
        }
        while (i11 < cubicArr2.length) {
            double d17 = dArr[i11];
            double eval2 = cubicArr2[i11].eval(1.0d);
            dArr[i11] = eval2;
            double d18 = d17 - eval2;
            d11 += d18 * d18;
            i11++;
        }
        return d13 + Math.sqrt(d11);
    }

    public void getPos(double d11, double[] dArr) {
        double d12 = d11 * this.f10556e;
        int i11 = 0;
        while (true) {
            double[] dArr2 = this.f10555d;
            if (i11 >= dArr2.length - 1) {
                break;
            }
            double d13 = dArr2[i11];
            if (d13 >= d12) {
                break;
            }
            d12 -= d13;
            i11++;
        }
        for (int i12 = 0; i12 < dArr.length; i12++) {
            dArr[i12] = this.f10553b[i12][i11].eval(d12 / this.f10555d[i11]);
        }
    }

    public void getVelocity(double d11, double[] dArr) {
        double d12 = d11 * this.f10556e;
        int i11 = 0;
        while (true) {
            double[] dArr2 = this.f10555d;
            if (i11 >= dArr2.length - 1) {
                break;
            }
            double d13 = dArr2[i11];
            if (d13 >= d12) {
                break;
            }
            d12 -= d13;
            i11++;
        }
        for (int i12 = 0; i12 < dArr.length; i12++) {
            dArr[i12] = this.f10553b[i12][i11].vel(d12 / this.f10555d[i11]);
        }
    }

    public void setup(double[][] dArr) {
        int i11;
        int length = dArr[0].length;
        this.f10554c = length;
        int length2 = dArr.length;
        this.f10552a = length2;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = length;
        this.f10557f = (double[][]) Array.newInstance(Double.TYPE, iArr);
        this.f10553b = new Cubic[this.f10554c][];
        for (int i12 = 0; i12 < this.f10554c; i12++) {
            for (int i13 = 0; i13 < this.f10552a; i13++) {
                this.f10557f[i12][i13] = dArr[i13][i12];
            }
        }
        int i14 = 0;
        while (true) {
            i11 = this.f10554c;
            if (i14 >= i11) {
                break;
            }
            Cubic[][] cubicArr = this.f10553b;
            double[] dArr2 = this.f10557f[i14];
            cubicArr[i14] = a(dArr2.length, dArr2);
            i14++;
        }
        this.f10555d = new double[(this.f10552a - 1)];
        this.f10556e = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i11];
        for (int i15 = 0; i15 < this.f10555d.length; i15++) {
            for (int i16 = 0; i16 < this.f10554c; i16++) {
                cubicArr2[i16] = this.f10553b[i16][i15];
            }
            double d11 = this.f10556e;
            double[] dArr3 = this.f10555d;
            double approxLength = approxLength(cubicArr2);
            dArr3[i15] = approxLength;
            this.f10556e = d11 + approxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d11, float[] fArr) {
        double d12 = d11 * this.f10556e;
        int i11 = 0;
        while (true) {
            double[] dArr = this.f10555d;
            if (i11 >= dArr.length - 1) {
                break;
            }
            double d13 = dArr[i11];
            if (d13 >= d12) {
                break;
            }
            d12 -= d13;
            i11++;
        }
        for (int i12 = 0; i12 < fArr.length; i12++) {
            fArr[i12] = (float) this.f10553b[i12][i11].eval(d12 / this.f10555d[i11]);
        }
    }

    public double getPos(double d11, int i11) {
        double[] dArr;
        double d12 = d11 * this.f10556e;
        int i12 = 0;
        while (true) {
            dArr = this.f10555d;
            if (i12 >= dArr.length - 1) {
                break;
            }
            double d13 = dArr[i12];
            if (d13 >= d12) {
                break;
            }
            d12 -= d13;
            i12++;
        }
        return this.f10553b[i11][i12].eval(d12 / dArr[i12]);
    }
}
