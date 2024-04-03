package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.state.WidgetFrame;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import w0.a;

public abstract class SplineSet {
    private static final String TAG = "SplineSet";

    /* renamed from: a  reason: collision with root package name */
    public CurveFit f10606a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f10607b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    public float[] f10608c = new float[10];
    private int count;
    private String mType;

    public static class CoreSpline extends SplineSet {

        /* renamed from: d  reason: collision with root package name */
        public String f10609d;

        /* renamed from: e  reason: collision with root package name */
        public long f10610e;

        public CoreSpline(String str, long j11) {
            this.f10609d = str;
            this.f10610e = j11;
        }

        public void setProperty(TypedValues typedValues, float f11) {
            typedValues.setValue(typedValues.getId(this.f10609d), get(f11));
        }
    }

    public static class CustomSet extends SplineSet {

        /* renamed from: d  reason: collision with root package name */
        public String f10611d;

        /* renamed from: e  reason: collision with root package name */
        public KeyFrameArray.CustomArray f10612e;

        /* renamed from: f  reason: collision with root package name */
        public float[] f10613f;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.f10611d = str.split(",")[1];
            this.f10612e = customArray;
        }

        public void setPoint(int i11, float f11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(WidgetFrame widgetFrame, float f11) {
            this.f10606a.getPos((double) f11, this.f10613f);
            widgetFrame.setCustomValue(this.f10612e.valueAt(0), this.f10613f);
        }

        public void setup(int i11) {
            int size = this.f10612e.size();
            int numberOfInterpolatedValues = this.f10612e.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.f10613f = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = numberOfInterpolatedValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i12 = 0; i12 < size; i12++) {
                int keyAt = this.f10612e.keyAt(i12);
                CustomAttribute valueAt = this.f10612e.valueAt(i12);
                dArr[i12] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.f10613f);
                int i13 = 0;
                while (true) {
                    float[] fArr = this.f10613f;
                    if (i13 >= fArr.length) {
                        break;
                    }
                    dArr2[i12][i13] = (double) fArr[i13];
                    i13++;
                }
            }
            this.f10606a = CurveFit.get(i11, dArr, dArr2);
        }

        public void setPoint(int i11, CustomAttribute customAttribute) {
            this.f10612e.append(i11, customAttribute);
        }
    }

    public static class CustomSpline extends SplineSet {

        /* renamed from: d  reason: collision with root package name */
        public String f10614d;

        /* renamed from: e  reason: collision with root package name */
        public KeyFrameArray.CustomVar f10615e;

        /* renamed from: f  reason: collision with root package name */
        public float[] f10616f;

        public CustomSpline(String str, KeyFrameArray.CustomVar customVar) {
            this.f10614d = str.split(",")[1];
            this.f10615e = customVar;
        }

        public void setPoint(int i11, float f11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(TypedValues typedValues, float f11) {
            setProperty((MotionWidget) typedValues, f11);
        }

        public void setup(int i11) {
            int size = this.f10615e.size();
            int numberOfInterpolatedValues = this.f10615e.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.f10616f = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = numberOfInterpolatedValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i12 = 0; i12 < size; i12++) {
                int keyAt = this.f10615e.keyAt(i12);
                CustomVariable valueAt = this.f10615e.valueAt(i12);
                dArr[i12] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.f10616f);
                int i13 = 0;
                while (true) {
                    float[] fArr = this.f10616f;
                    if (i13 >= fArr.length) {
                        break;
                    }
                    dArr2[i12][i13] = (double) fArr[i13];
                    i13++;
                }
            }
            this.f10606a = CurveFit.get(i11, dArr, dArr2);
        }

        public void setPoint(int i11, CustomVariable customVariable) {
            this.f10615e.append(i11, customVariable);
        }

        public void setProperty(MotionWidget motionWidget, float f11) {
            this.f10606a.getPos((double) f11, this.f10616f);
            this.f10615e.valueAt(0).setInterpolatedValue(motionWidget, this.f10616f);
        }
    }

    public static class Sort {
        private Sort() {
        }

        public static void a(int[] iArr, float[] fArr, int i11, int i12) {
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

    public static SplineSet makeCustomSpline(String str, KeyFrameArray.CustomArray customArray) {
        return new CustomSet(str, customArray);
    }

    public static SplineSet makeCustomSplineSet(String str, KeyFrameArray.CustomVar customVar) {
        return new CustomSpline(str, customVar);
    }

    public static SplineSet makeSpline(String str, long j11) {
        return new CoreSpline(str, j11);
    }

    public float get(float f11) {
        return (float) this.f10606a.getPos((double) f11, 0);
    }

    public CurveFit getCurveFit() {
        return this.f10606a;
    }

    public float getSlope(float f11) {
        return (float) this.f10606a.getSlope((double) f11, 0);
    }

    public void setPoint(int i11, float f11) {
        int[] iArr = this.f10607b;
        if (iArr.length < this.count + 1) {
            this.f10607b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f10608c;
            this.f10608c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f10607b;
        int i12 = this.count;
        iArr2[i12] = i11;
        this.f10608c[i12] = f11;
        this.count = i12 + 1;
    }

    public void setProperty(TypedValues typedValues, float f11) {
        typedValues.setValue(a.a(this.mType), get(f11));
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i11) {
        int i12 = this.count;
        if (i12 != 0) {
            Sort.a(this.f10607b, this.f10608c, 0, i12 - 1);
            int i13 = 1;
            for (int i14 = 1; i14 < this.count; i14++) {
                int[] iArr = this.f10607b;
                if (iArr[i14 - 1] != iArr[i14]) {
                    i13++;
                }
            }
            double[] dArr = new double[i13];
            int[] iArr2 = new int[2];
            iArr2[1] = 1;
            iArr2[0] = i13;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
            int i15 = 0;
            for (int i16 = 0; i16 < this.count; i16++) {
                if (i16 > 0) {
                    int[] iArr3 = this.f10607b;
                    if (iArr3[i16] == iArr3[i16 - 1]) {
                    }
                }
                dArr[i15] = ((double) this.f10607b[i16]) * 0.01d;
                dArr2[i15][0] = (double) this.f10608c[i16];
                i15++;
            }
            this.f10606a = CurveFit.get(i11, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i11 = 0; i11 < this.count; i11++) {
            str = str + "[" + this.f10607b[i11] + " , " + decimalFormat.format((double) this.f10608c[i11]) + "] ";
        }
        return str;
    }
}
