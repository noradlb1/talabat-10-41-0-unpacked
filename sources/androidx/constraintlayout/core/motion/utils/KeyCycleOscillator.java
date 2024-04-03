package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import w0.c;

public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<WavePoint> f10563a = new ArrayList<>();
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    public int mVariesBy = 0;
    private int mWaveShape = 0;
    private String mWaveString = null;

    public static class CoreSpline extends KeyCycleOscillator {

        /* renamed from: b  reason: collision with root package name */
        public String f10565b;

        /* renamed from: c  reason: collision with root package name */
        public int f10566c;

        public CoreSpline(String str) {
            this.f10565b = str;
            this.f10566c = c.a(str);
        }

        public void setProperty(MotionWidget motionWidget, float f11) {
            motionWidget.setValue(this.f10566c, get(f11));
        }
    }

    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        private final int OFFST = 0;
        private final int PHASE = 1;
        private final int VALUE = 2;

        /* renamed from: a  reason: collision with root package name */
        public Oscillator f10567a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f10568b;

        /* renamed from: c  reason: collision with root package name */
        public double[] f10569c;

        /* renamed from: d  reason: collision with root package name */
        public float[] f10570d;

        /* renamed from: e  reason: collision with root package name */
        public float[] f10571e;

        /* renamed from: f  reason: collision with root package name */
        public float[] f10572f;

        /* renamed from: g  reason: collision with root package name */
        public float[] f10573g;

        /* renamed from: h  reason: collision with root package name */
        public int f10574h;

        /* renamed from: i  reason: collision with root package name */
        public CurveFit f10575i;

        /* renamed from: j  reason: collision with root package name */
        public double[] f10576j;

        /* renamed from: k  reason: collision with root package name */
        public double[] f10577k;

        /* renamed from: l  reason: collision with root package name */
        public float f10578l;
        private final int mVariesBy;

        public CycleOscillator(int i11, String str, int i12, int i13) {
            Oscillator oscillator = new Oscillator();
            this.f10567a = oscillator;
            this.f10574h = i11;
            this.mVariesBy = i12;
            oscillator.setType(i11, str);
            this.f10568b = new float[i13];
            this.f10569c = new double[i13];
            this.f10570d = new float[i13];
            this.f10571e = new float[i13];
            this.f10572f = new float[i13];
            this.f10573g = new float[i13];
        }

        public double getLastPhase() {
            return this.f10576j[1];
        }

        public double getSlope(float f11) {
            CurveFit curveFit = this.f10575i;
            if (curveFit != null) {
                double d11 = (double) f11;
                curveFit.getSlope(d11, this.f10577k);
                this.f10575i.getPos(d11, this.f10576j);
            } else {
                double[] dArr = this.f10577k;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d12 = (double) f11;
            double value = this.f10567a.getValue(d12, this.f10576j[1]);
            double slope = this.f10567a.getSlope(d12, this.f10576j[1], this.f10577k[1]);
            double[] dArr2 = this.f10577k;
            return dArr2[0] + (value * dArr2[2]) + (slope * this.f10576j[2]);
        }

        public double getValues(float f11) {
            CurveFit curveFit = this.f10575i;
            if (curveFit != null) {
                curveFit.getPos((double) f11, this.f10576j);
            } else {
                double[] dArr = this.f10576j;
                dArr[0] = (double) this.f10571e[0];
                dArr[1] = (double) this.f10572f[0];
                dArr[2] = (double) this.f10568b[0];
            }
            double[] dArr2 = this.f10576j;
            return dArr2[0] + (this.f10567a.getValue((double) f11, dArr2[1]) * this.f10576j[2]);
        }

        public void setPoint(int i11, int i12, float f11, float f12, float f13, float f14) {
            this.f10569c[i11] = ((double) i12) / 100.0d;
            this.f10570d[i11] = f11;
            this.f10571e[i11] = f12;
            this.f10572f[i11] = f13;
            this.f10568b[i11] = f14;
        }

        public void setup(float f11) {
            this.f10578l = f11;
            int length = this.f10569c.length;
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = length;
            double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, iArr);
            float[] fArr = this.f10568b;
            this.f10576j = new double[(fArr.length + 2)];
            this.f10577k = new double[(fArr.length + 2)];
            if (this.f10569c[0] > 0.0d) {
                this.f10567a.addPoint(0.0d, this.f10570d[0]);
            }
            double[] dArr2 = this.f10569c;
            int length2 = dArr2.length - 1;
            if (dArr2[length2] < 1.0d) {
                this.f10567a.addPoint(1.0d, this.f10570d[length2]);
            }
            for (int i11 = 0; i11 < dArr.length; i11++) {
                double[] dArr3 = dArr[i11];
                dArr3[0] = (double) this.f10571e[i11];
                dArr3[1] = (double) this.f10572f[i11];
                dArr3[2] = (double) this.f10568b[i11];
                this.f10567a.addPoint(this.f10569c[i11], this.f10570d[i11]);
            }
            this.f10567a.normalize();
            double[] dArr4 = this.f10569c;
            if (dArr4.length > 1) {
                this.f10575i = CurveFit.get(0, dArr4, dArr);
            } else {
                this.f10575i = null;
            }
        }
    }

    public static class IntDoubleSort {
        private IntDoubleSort() {
        }

        private static int partition(int[] iArr, float[] fArr, int i11, int i12) {
            int i13 = iArr[i12];
            int i14 = i11;
            while (i11 < i12) {
                if (iArr[i11] <= i13) {
                    swap(iArr, fArr, i14, i11);
                    i14++;
                }
                i11++;
            }
            swap(iArr, fArr, i14, i12);
            return i14;
        }

        private static void swap(int[] iArr, float[] fArr, int i11, int i12) {
            int i13 = iArr[i11];
            iArr[i11] = iArr[i12];
            iArr[i12] = i13;
            float f11 = fArr[i11];
            fArr[i11] = fArr[i12];
            fArr[i12] = f11;
        }
    }

    public static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        private static int partition(int[] iArr, float[] fArr, float[] fArr2, int i11, int i12) {
            int i13 = iArr[i12];
            int i14 = i11;
            while (i11 < i12) {
                if (iArr[i11] <= i13) {
                    swap(iArr, fArr, fArr2, i14, i11);
                    i14++;
                }
                i11++;
            }
            swap(iArr, fArr, fArr2, i14, i12);
            return i14;
        }

        private static void swap(int[] iArr, float[] fArr, float[] fArr2, int i11, int i12) {
            int i13 = iArr[i11];
            iArr[i11] = iArr[i12];
            iArr[i12] = i13;
            float f11 = fArr[i11];
            fArr[i11] = fArr[i12];
            fArr[i12] = f11;
            float f12 = fArr2[i11];
            fArr2[i11] = fArr2[i12];
            fArr2[i12] = f12;
        }
    }

    public static class PathRotateSet extends KeyCycleOscillator {

        /* renamed from: b  reason: collision with root package name */
        public String f10579b;

        /* renamed from: c  reason: collision with root package name */
        public int f10580c;

        public PathRotateSet(String str) {
            this.f10579b = str;
            this.f10580c = c.a(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f11, double d11, double d12) {
            motionWidget.setRotationZ(get(f11) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
        }

        public void setProperty(MotionWidget motionWidget, float f11) {
            motionWidget.setValue(this.f10580c, get(f11));
        }
    }

    public static class WavePoint {

        /* renamed from: a  reason: collision with root package name */
        public int f10581a;

        /* renamed from: b  reason: collision with root package name */
        public float f10582b;

        /* renamed from: c  reason: collision with root package name */
        public float f10583c;

        /* renamed from: d  reason: collision with root package name */
        public float f10584d;

        /* renamed from: e  reason: collision with root package name */
        public float f10585e;

        public WavePoint(int i11, float f11, float f12, float f13, float f14) {
            this.f10581a = i11;
            this.f10582b = f14;
            this.f10583c = f12;
            this.f10584d = f11;
            this.f10585e = f13;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        if (str.equals("pathRotate")) {
            return new PathRotateSet(str);
        }
        return new CoreSpline(str);
    }

    public void a(Object obj) {
    }

    public float get(float f11) {
        return (float) this.mCycleOscillator.getValues(f11);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f11) {
        return (float) this.mCycleOscillator.getSlope(f11);
    }

    public void setPoint(int i11, int i12, String str, int i13, float f11, float f12, float f13, float f14, Object obj) {
        int i14 = i13;
        this.f10563a.add(new WavePoint(i11, f11, f12, f13, f14));
        if (i14 != -1) {
            this.mVariesBy = i14;
        }
        this.mWaveShape = i12;
        a(obj);
        this.mWaveString = str;
    }

    public void setProperty(MotionWidget motionWidget, float f11) {
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f11) {
        int size = this.f10563a.size();
        if (size != 0) {
            Collections.sort(this.f10563a, new Comparator<WavePoint>() {
                public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                    return Integer.compare(wavePoint.f10581a, wavePoint2.f10581a);
                }
            });
            double[] dArr = new double[size];
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
            Iterator<WavePoint> it = this.f10563a.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                WavePoint next = it.next();
                float f12 = next.f10584d;
                dArr[i11] = ((double) f12) * 0.01d;
                double[] dArr3 = dArr2[i11];
                float f13 = next.f10582b;
                dArr3[0] = (double) f13;
                float f14 = next.f10583c;
                dArr3[1] = (double) f14;
                float f15 = next.f10585e;
                dArr3[2] = (double) f15;
                this.mCycleOscillator.setPoint(i11, next.f10581a, f12, f14, f15, f13);
                i11++;
                dArr2 = dArr2;
            }
            double[][] dArr4 = dArr2;
            this.mCycleOscillator.setup(f11);
            this.mCurveFit = CurveFit.get(0, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.f10563a.iterator();
        while (it.hasNext()) {
            WavePoint next = it.next();
            str = str + "[" + next.f10581a + " , " + decimalFormat.format((double) next.f10582b) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i11, int i12, String str, int i13, float f11, float f12, float f13, float f14) {
        int i14 = i13;
        this.f10563a.add(new WavePoint(i11, f11, f12, f13, f14));
        if (i14 != -1) {
            this.mVariesBy = i14;
        }
        this.mWaveShape = i12;
        this.mWaveString = str;
    }
}
