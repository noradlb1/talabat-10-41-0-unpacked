package androidx.constraintlayout.core.motion.utils;

public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    public static class Constant extends CurveFit {

        /* renamed from: a  reason: collision with root package name */
        public double f10544a;

        /* renamed from: b  reason: collision with root package name */
        public double[] f10545b;

        public Constant(double d11, double[] dArr) {
            this.f10544a = d11;
            this.f10545b = dArr;
        }

        public void getPos(double d11, double[] dArr) {
            double[] dArr2 = this.f10545b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        public double getSlope(double d11, int i11) {
            return 0.0d;
        }

        public void getSlope(double d11, double[] dArr) {
            for (int i11 = 0; i11 < this.f10545b.length; i11++) {
                dArr[i11] = 0.0d;
            }
        }

        public double[] getTimePoints() {
            return new double[]{this.f10544a};
        }

        public void getPos(double d11, float[] fArr) {
            int i11 = 0;
            while (true) {
                double[] dArr = this.f10545b;
                if (i11 < dArr.length) {
                    fArr[i11] = (float) dArr[i11];
                    i11++;
                } else {
                    return;
                }
            }
        }

        public double getPos(double d11, int i11) {
            return this.f10545b[i11];
        }
    }

    public static CurveFit get(int i11, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i11 = 2;
        }
        if (i11 == 0) {
            return new MonotonicCurveFit(dArr, dArr2);
        }
        if (i11 != 2) {
            return new LinearCurveFit(dArr, dArr2);
        }
        return new Constant(dArr[0], dArr2[0]);
    }

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    public abstract double getPos(double d11, int i11);

    public abstract void getPos(double d11, double[] dArr);

    public abstract void getPos(double d11, float[] fArr);

    public abstract double getSlope(double d11, int i11);

    public abstract void getSlope(double d11, double[] dArr);

    public abstract double[] getTimePoints();
}
