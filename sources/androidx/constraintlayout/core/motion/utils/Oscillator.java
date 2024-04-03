package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;

    /* renamed from: a  reason: collision with root package name */
    public float[] f10597a = new float[0];

    /* renamed from: b  reason: collision with root package name */
    public double[] f10598b = new double[0];

    /* renamed from: c  reason: collision with root package name */
    public double[] f10599c;

    /* renamed from: d  reason: collision with root package name */
    public String f10600d;

    /* renamed from: e  reason: collision with root package name */
    public MonotonicCurveFit f10601e;

    /* renamed from: f  reason: collision with root package name */
    public int f10602f;

    /* renamed from: g  reason: collision with root package name */
    public double f10603g = 6.283185307179586d;
    private boolean mNormalized = false;

    public double a(double d11) {
        if (d11 <= 0.0d) {
            d11 = 1.0E-5d;
        } else if (d11 >= 1.0d) {
            d11 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f10598b, d11);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i11 = (-binarySearch) - 1;
        float[] fArr = this.f10597a;
        float f11 = fArr[i11];
        int i12 = i11 - 1;
        float f12 = fArr[i12];
        double d12 = (double) (f11 - f12);
        double[] dArr = this.f10598b;
        double d13 = dArr[i11];
        double d14 = dArr[i12];
        double d15 = d12 / (d13 - d14);
        return (((double) f12) - (d15 * d14)) + (d11 * d15);
    }

    public void addPoint(double d11, float f11) {
        int length = this.f10597a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f10598b, d11);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f10598b = Arrays.copyOf(this.f10598b, length);
        this.f10597a = Arrays.copyOf(this.f10597a, length);
        this.f10599c = new double[length];
        double[] dArr = this.f10598b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f10598b[binarySearch] = d11;
        this.f10597a[binarySearch] = f11;
        this.mNormalized = false;
    }

    public double b(double d11) {
        if (d11 < 0.0d) {
            d11 = 0.0d;
        } else if (d11 > 1.0d) {
            d11 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f10598b, d11);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i11 = (-binarySearch) - 1;
        float[] fArr = this.f10597a;
        float f11 = fArr[i11];
        int i12 = i11 - 1;
        float f12 = fArr[i12];
        double d12 = (double) (f11 - f12);
        double[] dArr = this.f10598b;
        double d13 = dArr[i11];
        double d14 = dArr[i12];
        double d15 = d12 / (d13 - d14);
        return this.f10599c[i12] + ((((double) f12) - (d15 * d14)) * (d11 - d14)) + ((d15 * ((d11 * d11) - (d14 * d14))) / 2.0d);
    }

    public double getSlope(double d11, double d12, double d13) {
        double b11 = d12 + b(d11);
        double a11 = a(d11) + d13;
        switch (this.f10602f) {
            case 1:
                return 0.0d;
            case 2:
                return a11 * 4.0d * Math.signum((((b11 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return a11 * 2.0d;
            case 4:
                return (-a11) * 2.0d;
            case 5:
                double d14 = this.f10603g;
                return (-d14) * a11 * Math.sin(d14 * b11);
            case 6:
                return a11 * 4.0d * ((((b11 * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.f10601e.getSlope(b11 % 1.0d, 0);
            default:
                double d15 = this.f10603g;
                return a11 * d15 * Math.cos(d15 * b11);
        }
    }

    public double getValue(double d11, double d12) {
        double abs;
        double b11 = b(d11) + d12;
        switch (this.f10602f) {
            case 1:
                return Math.signum(0.5d - (b11 % 1.0d));
            case 2:
                abs = Math.abs((((b11 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((b11 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((b11 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f10603g * (d12 + b11));
            case 6:
                double abs2 = 1.0d - Math.abs(((b11 * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.f10601e.getPos(b11 % 1.0d, 0);
            default:
                return Math.sin(this.f10603g * b11);
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d11 = 0.0d;
        int i11 = 0;
        while (true) {
            float[] fArr = this.f10597a;
            if (i11 >= fArr.length) {
                break;
            }
            d11 += (double) fArr[i11];
            i11++;
        }
        double d12 = 0.0d;
        int i12 = 1;
        while (true) {
            float[] fArr2 = this.f10597a;
            if (i12 >= fArr2.length) {
                break;
            }
            int i13 = i12 - 1;
            double[] dArr = this.f10598b;
            d12 += (dArr[i12] - dArr[i13]) * ((double) ((fArr2[i13] + fArr2[i12]) / 2.0f));
            i12++;
        }
        int i14 = 0;
        while (true) {
            float[] fArr3 = this.f10597a;
            if (i14 >= fArr3.length) {
                break;
            }
            fArr3[i14] = (float) (((double) fArr3[i14]) * (d11 / d12));
            i14++;
        }
        this.f10599c[0] = 0.0d;
        int i15 = 1;
        while (true) {
            float[] fArr4 = this.f10597a;
            if (i15 < fArr4.length) {
                int i16 = i15 - 1;
                double[] dArr2 = this.f10598b;
                double d13 = dArr2[i15] - dArr2[i16];
                double[] dArr3 = this.f10599c;
                dArr3[i15] = dArr3[i16] + (d13 * ((double) ((fArr4[i16] + fArr4[i15]) / 2.0f)));
                i15++;
            } else {
                this.mNormalized = true;
                return;
            }
        }
    }

    public void setType(int i11, String str) {
        this.f10602f = i11;
        this.f10600d = str;
        if (str != null) {
            this.f10601e = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f10598b) + " period=" + Arrays.toString(this.f10597a);
    }
}
