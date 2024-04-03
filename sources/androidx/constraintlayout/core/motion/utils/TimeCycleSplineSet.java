package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

public abstract class TimeCycleSplineSet {
    private static final String TAG = "SplineSet";

    /* renamed from: k  reason: collision with root package name */
    public static float f10619k = 6.2831855f;

    /* renamed from: a  reason: collision with root package name */
    public CurveFit f10620a;

    /* renamed from: b  reason: collision with root package name */
    public int f10621b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int[] f10622c = new int[10];

    /* renamed from: d  reason: collision with root package name */
    public float[][] f10623d = ((float[][]) Array.newInstance(Float.TYPE, new int[]{10, 3}));

    /* renamed from: e  reason: collision with root package name */
    public int f10624e;

    /* renamed from: f  reason: collision with root package name */
    public String f10625f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f10626g = new float[3];

    /* renamed from: h  reason: collision with root package name */
    public boolean f10627h = false;

    /* renamed from: i  reason: collision with root package name */
    public long f10628i;

    /* renamed from: j  reason: collision with root package name */
    public float f10629j = Float.NaN;

    public static class CustomSet extends TimeCycleSplineSet {

        /* renamed from: l  reason: collision with root package name */
        public String f10630l;

        /* renamed from: m  reason: collision with root package name */
        public KeyFrameArray.CustomArray f10631m;

        /* renamed from: n  reason: collision with root package name */
        public KeyFrameArray.FloatArray f10632n = new KeyFrameArray.FloatArray();

        /* renamed from: o  reason: collision with root package name */
        public float[] f10633o;

        /* renamed from: p  reason: collision with root package name */
        public float[] f10634p;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.f10630l = str.split(",")[1];
            this.f10631m = customArray;
        }

        public void setPoint(int i11, float f11, float f12, int i12, float f13) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f11, long j11, KeyCache keyCache) {
            boolean z11;
            MotionWidget motionWidget2 = motionWidget;
            long j12 = j11;
            this.f10620a.getPos((double) f11, this.f10633o);
            float[] fArr = this.f10633o;
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            long j13 = j12 - this.f10628i;
            if (Float.isNaN(this.f10629j)) {
                float floatValue = keyCache.getFloatValue(motionWidget2, this.f10630l, 0);
                this.f10629j = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.f10629j = 0.0f;
                }
            }
            float f14 = (float) ((((double) this.f10629j) + ((((double) j13) * 1.0E-9d) * ((double) f12))) % 1.0d);
            this.f10629j = f14;
            this.f10628i = j12;
            float a11 = a(f14);
            this.f10627h = false;
            int i11 = 0;
            while (true) {
                float[] fArr2 = this.f10634p;
                if (i11 >= fArr2.length) {
                    break;
                }
                boolean z12 = this.f10627h;
                float f15 = this.f10633o[i11];
                if (((double) f15) != 0.0d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.f10627h = z12 | z11;
                fArr2[i11] = (f15 * a11) + f13;
                i11++;
            }
            motionWidget2.setInterpolatedValue(this.f10631m.valueAt(0), this.f10634p);
            if (f12 != 0.0f) {
                this.f10627h = true;
            }
            return this.f10627h;
        }

        public void setup(int i11) {
            int size = this.f10631m.size();
            int numberOfInterpolatedValues = this.f10631m.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i12 = numberOfInterpolatedValues + 2;
            this.f10633o = new float[i12];
            this.f10634p = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = i12;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i13 = 0; i13 < size; i13++) {
                int keyAt = this.f10631m.keyAt(i13);
                CustomAttribute valueAt = this.f10631m.valueAt(i13);
                float[] valueAt2 = this.f10632n.valueAt(i13);
                dArr[i13] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.f10633o);
                int i14 = 0;
                while (true) {
                    float[] fArr = this.f10633o;
                    if (i14 >= fArr.length) {
                        break;
                    }
                    dArr2[i13][i14] = (double) fArr[i14];
                    i14++;
                }
                double[] dArr3 = dArr2[i13];
                dArr3[numberOfInterpolatedValues] = (double) valueAt2[0];
                dArr3[numberOfInterpolatedValues + 1] = (double) valueAt2[1];
            }
            this.f10620a = CurveFit.get(i11, dArr, dArr2);
        }

        public void setPoint(int i11, CustomAttribute customAttribute, float f11, int i12, float f12) {
            this.f10631m.append(i11, customAttribute);
            this.f10632n.append(i11, new float[]{f11, f12});
            this.f10621b = Math.max(this.f10621b, i12);
        }
    }

    public static class CustomVarSet extends TimeCycleSplineSet {

        /* renamed from: l  reason: collision with root package name */
        public String f10635l;

        /* renamed from: m  reason: collision with root package name */
        public KeyFrameArray.CustomVar f10636m;

        /* renamed from: n  reason: collision with root package name */
        public KeyFrameArray.FloatArray f10637n = new KeyFrameArray.FloatArray();

        /* renamed from: o  reason: collision with root package name */
        public float[] f10638o;

        /* renamed from: p  reason: collision with root package name */
        public float[] f10639p;

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.f10635l = str.split(",")[1];
            this.f10636m = customVar;
        }

        public void setPoint(int i11, float f11, float f12, int i12, float f13) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f11, long j11, KeyCache keyCache) {
            boolean z11;
            MotionWidget motionWidget2 = motionWidget;
            long j12 = j11;
            this.f10620a.getPos((double) f11, this.f10638o);
            float[] fArr = this.f10638o;
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            long j13 = j12 - this.f10628i;
            if (Float.isNaN(this.f10629j)) {
                float floatValue = keyCache.getFloatValue(motionWidget2, this.f10635l, 0);
                this.f10629j = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.f10629j = 0.0f;
                }
            }
            float f14 = (float) ((((double) this.f10629j) + ((((double) j13) * 1.0E-9d) * ((double) f12))) % 1.0d);
            this.f10629j = f14;
            this.f10628i = j12;
            float a11 = a(f14);
            this.f10627h = false;
            int i11 = 0;
            while (true) {
                float[] fArr2 = this.f10639p;
                if (i11 >= fArr2.length) {
                    break;
                }
                boolean z12 = this.f10627h;
                float f15 = this.f10638o[i11];
                if (((double) f15) != 0.0d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.f10627h = z12 | z11;
                fArr2[i11] = (f15 * a11) + f13;
                i11++;
            }
            this.f10636m.valueAt(0).setInterpolatedValue(motionWidget2, this.f10639p);
            if (f12 != 0.0f) {
                this.f10627h = true;
            }
            return this.f10627h;
        }

        public void setup(int i11) {
            int size = this.f10636m.size();
            int numberOfInterpolatedValues = this.f10636m.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i12 = numberOfInterpolatedValues + 2;
            this.f10638o = new float[i12];
            this.f10639p = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = i12;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i13 = 0; i13 < size; i13++) {
                int keyAt = this.f10636m.keyAt(i13);
                CustomVariable valueAt = this.f10636m.valueAt(i13);
                float[] valueAt2 = this.f10637n.valueAt(i13);
                dArr[i13] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.f10638o);
                int i14 = 0;
                while (true) {
                    float[] fArr = this.f10638o;
                    if (i14 >= fArr.length) {
                        break;
                    }
                    dArr2[i13][i14] = (double) fArr[i14];
                    i14++;
                }
                double[] dArr3 = dArr2[i13];
                dArr3[numberOfInterpolatedValues] = (double) valueAt2[0];
                dArr3[numberOfInterpolatedValues + 1] = (double) valueAt2[1];
            }
            this.f10620a = CurveFit.get(i11, dArr, dArr2);
        }

        public void setPoint(int i11, CustomVariable customVariable, float f11, int i12, float f12) {
            this.f10636m.append(i11, customVariable);
            this.f10637n.append(i11, new float[]{f11, f12});
            this.f10621b = Math.max(this.f10621b, i12);
        }
    }

    public static class Sort {
        public static void a(int[] iArr, float[][] fArr, int i11, int i12) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i12;
            iArr2[1] = i11;
            int i13 = 2;
            while (i13 > 0) {
                int i14 = i13 - 1;
                int i15 = iArr2[i14];
                i13 = i14 - 1;
                int i16 = iArr2[i13];
                if (i15 < i16) {
                    int partition = partition(iArr, fArr, i15, i16);
                    int i17 = i13 + 1;
                    iArr2[i13] = partition - 1;
                    int i18 = i17 + 1;
                    iArr2[i17] = i15;
                    int i19 = i18 + 1;
                    iArr2[i18] = i16;
                    i13 = i19 + 1;
                    iArr2[i19] = partition + 1;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i11, int i12) {
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

        private static void swap(int[] iArr, float[][] fArr, int i11, int i12) {
            int i13 = iArr[i11];
            iArr[i11] = iArr[i12];
            iArr[i12] = i13;
            float[] fArr2 = fArr[i11];
            fArr[i11] = fArr[i12];
            fArr[i12] = fArr2;
        }
    }

    public float a(float f11) {
        float abs;
        switch (this.f10621b) {
            case 1:
                return Math.signum(f11 * f10619k);
            case 2:
                abs = Math.abs(f11);
                break;
            case 3:
                return (((f11 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f11 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos((double) (f11 * f10619k));
            case 6:
                float abs2 = 1.0f - Math.abs(((f11 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin((double) (f11 * f10619k));
        }
        return 1.0f - abs;
    }

    public void b(long j11) {
        this.f10628i = j11;
    }

    public CurveFit getCurveFit() {
        return this.f10620a;
    }

    public void setPoint(int i11, float f11, float f12, int i12, float f13) {
        int[] iArr = this.f10622c;
        int i13 = this.f10624e;
        iArr[i13] = i11;
        float[] fArr = this.f10623d[i13];
        fArr[0] = f11;
        fArr[1] = f12;
        fArr[2] = f13;
        this.f10621b = Math.max(this.f10621b, i12);
        this.f10624e++;
    }

    public void setType(String str) {
        this.f10625f = str;
    }

    public void setup(int i11) {
        int i12 = this.f10624e;
        if (i12 == 0) {
            System.err.println("Error no points added to " + this.f10625f);
            return;
        }
        Sort.a(this.f10622c, this.f10623d, 0, i12 - 1);
        int i13 = 1;
        int i14 = 0;
        while (true) {
            int[] iArr = this.f10622c;
            if (i13 >= iArr.length) {
                break;
            }
            if (iArr[i13] != iArr[i13 - 1]) {
                i14++;
            }
            i13++;
        }
        if (i14 == 0) {
            i14 = 1;
        }
        double[] dArr = new double[i14];
        int[] iArr2 = new int[2];
        iArr2[1] = 3;
        iArr2[0] = i14;
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
        int i15 = 0;
        for (int i16 = 0; i16 < this.f10624e; i16++) {
            if (i16 > 0) {
                int[] iArr3 = this.f10622c;
                if (iArr3[i16] == iArr3[i16 - 1]) {
                }
            }
            dArr[i15] = ((double) this.f10622c[i16]) * 0.01d;
            double[] dArr3 = dArr2[i15];
            float[] fArr = this.f10623d[i16];
            dArr3[0] = (double) fArr[0];
            dArr3[1] = (double) fArr[1];
            dArr3[2] = (double) fArr[2];
            i15++;
        }
        this.f10620a = CurveFit.get(i11, dArr, dArr2);
    }

    public String toString() {
        String str = this.f10625f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i11 = 0; i11 < this.f10624e; i11++) {
            str = str + "[" + this.f10622c[i11] + " , " + decimalFormat.format(this.f10623d[i11]) + "] ";
        }
        return str;
    }
}
