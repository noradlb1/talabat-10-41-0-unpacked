package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Arrays;
import java.util.LinkedHashMap;

class MotionPaths implements Comparable<MotionPaths> {
    public static final boolean DEBUG = false;
    public static final boolean OLD_WAY = false;
    public static final String TAG = "MotionPaths";

    /* renamed from: u  reason: collision with root package name */
    public static String[] f10989u = {"position", Param.X, Param.Y, "width", "height", "pathRotate"};

    /* renamed from: b  reason: collision with root package name */
    public Easing f10990b;

    /* renamed from: c  reason: collision with root package name */
    public int f10991c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float f10992d;

    /* renamed from: e  reason: collision with root package name */
    public float f10993e;

    /* renamed from: f  reason: collision with root package name */
    public float f10994f;

    /* renamed from: g  reason: collision with root package name */
    public float f10995g;

    /* renamed from: h  reason: collision with root package name */
    public float f10996h;

    /* renamed from: i  reason: collision with root package name */
    public float f10997i;

    /* renamed from: j  reason: collision with root package name */
    public float f10998j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f10999k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public int f11000l;

    /* renamed from: m  reason: collision with root package name */
    public int f11001m;

    /* renamed from: n  reason: collision with root package name */
    public float f11002n;

    /* renamed from: o  reason: collision with root package name */
    public MotionController f11003o;

    /* renamed from: p  reason: collision with root package name */
    public LinkedHashMap<String, ConstraintAttribute> f11004p;

    /* renamed from: q  reason: collision with root package name */
    public int f11005q;

    /* renamed from: r  reason: collision with root package name */
    public int f11006r;

    /* renamed from: s  reason: collision with root package name */
    public double[] f11007s;

    /* renamed from: t  reason: collision with root package name */
    public double[] f11008t;

    public MotionPaths() {
        int i11 = Key.UNSET;
        this.f11000l = i11;
        this.f11001m = i11;
        this.f11002n = Float.NaN;
        this.f11003o = null;
        this.f11004p = new LinkedHashMap<>();
        this.f11005q = 0;
        this.f11007s = new double[18];
        this.f11008t = new double[18];
    }

    private boolean diff(float f11, float f12) {
        if (Float.isNaN(f11) || Float.isNaN(f12)) {
            if (Float.isNaN(f11) != Float.isNaN(f12)) {
                return true;
            }
            return false;
        } else if (Math.abs(f11 - f12) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    private static final float xRotate(float f11, float f12, float f13, float f14, float f15, float f16) {
        return (((f15 - f13) * f12) - ((f16 - f14) * f11)) + f13;
    }

    private static final float yRotate(float f11, float f12, float f13, float f14, float f15, float f16) {
        return ((f15 - f13) * f11) + ((f16 - f14) * f12) + f14;
    }

    public void a(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z11) {
        boolean diff = diff(this.f10994f, motionPaths.f10994f);
        boolean diff2 = diff(this.f10995g, motionPaths.f10995g);
        zArr[0] = zArr[0] | diff(this.f10993e, motionPaths.f10993e);
        boolean z12 = diff | diff2 | z11;
        zArr[1] = zArr[1] | z12;
        zArr[2] = z12 | zArr[2];
        zArr[3] = zArr[3] | diff(this.f10996h, motionPaths.f10996h);
        zArr[4] = diff(this.f10997i, motionPaths.f10997i) | zArr[4];
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.f10990b = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.f11000l = motion.mPathMotionArc;
        this.f11001m = motion.mAnimateRelativeTo;
        this.f10998j = motion.mPathRotate;
        this.f10991c = motion.mDrawPath;
        this.f11006r = motion.mAnimateCircleAngleTo;
        this.f10999k = constraint.propertySet.mProgress;
        this.f11002n = constraint.layout.circleAngle;
        for (String next : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(next);
            if (constraintAttribute != null && constraintAttribute.isContinuous()) {
                this.f11004p.put(next, constraintAttribute);
            }
        }
    }

    public void b(double[] dArr, int[] iArr) {
        float[] fArr = {this.f10993e, this.f10994f, this.f10995g, this.f10996h, this.f10997i, this.f10998j};
        int i11 = 0;
        for (int i12 : iArr) {
            if (i12 < 6) {
                dArr[i11] = (double) fArr[i12];
                i11++;
            }
        }
    }

    public void c(double d11, int[] iArr, double[] dArr, float[] fArr, int i11) {
        int[] iArr2 = iArr;
        float f11 = this.f10994f;
        float f12 = this.f10995g;
        float f13 = this.f10996h;
        float f14 = this.f10997i;
        for (int i12 = 0; i12 < iArr2.length; i12++) {
            float f15 = (float) dArr[i12];
            int i13 = iArr2[i12];
            if (i13 == 1) {
                f11 = f15;
            } else if (i13 == 2) {
                f12 = f15;
            } else if (i13 == 3) {
                f13 = f15;
            } else if (i13 == 4) {
                f14 = f15;
            }
        }
        MotionController motionController = this.f11003o;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d11, fArr2, new float[2]);
            float f16 = fArr2[0];
            float f17 = fArr2[1];
            double d12 = (double) f16;
            double d13 = (double) f11;
            double d14 = (double) f12;
            f11 = (float) ((d12 + (Math.sin(d14) * d13)) - ((double) (f13 / 2.0f)));
            f12 = (float) ((((double) f17) - (d13 * Math.cos(d14))) - ((double) (f14 / 2.0f)));
        }
        fArr[i11] = f11 + (f13 / 2.0f) + 0.0f;
        fArr[i11 + 1] = f12 + (f14 / 2.0f) + 0.0f;
    }

    public void configureRelativeTo(MotionController motionController) {
        motionController.k((double) this.f10999k);
    }

    public void d(double d11, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f11;
        int[] iArr2 = iArr;
        float f12 = this.f10994f;
        float f13 = this.f10995g;
        float f14 = this.f10996h;
        float f15 = this.f10997i;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            float f21 = (float) dArr[i11];
            float f22 = (float) dArr2[i11];
            int i12 = iArr2[i11];
            if (i12 == 1) {
                f12 = f21;
                f16 = f22;
            } else if (i12 == 2) {
                f13 = f21;
                f18 = f22;
            } else if (i12 == 3) {
                f14 = f21;
                f17 = f22;
            } else if (i12 == 4) {
                f15 = f21;
                f19 = f22;
            }
        }
        float f23 = 2.0f;
        float f24 = (f17 / 2.0f) + f16;
        float f25 = (f19 / 2.0f) + f18;
        MotionController motionController = this.f11003o;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.getCenter(d11, fArr3, fArr4);
            float f26 = fArr3[0];
            float f27 = fArr3[1];
            float f28 = fArr4[0];
            double d12 = (double) f12;
            float f29 = fArr4[1];
            double d13 = (double) f13;
            f11 = f14;
            double d14 = (double) f16;
            double d15 = (double) f18;
            float sin = (float) (((double) f28) + (Math.sin(d13) * d14) + (Math.cos(d13) * d15));
            f25 = (float) ((((double) f29) - (d14 * Math.cos(d13))) + (Math.sin(d13) * d15));
            f24 = sin;
            f12 = (float) ((((double) f26) + (Math.sin(d13) * d12)) - ((double) (f14 / 2.0f)));
            f13 = (float) ((((double) f27) - (d12 * Math.cos(d13))) - ((double) (f15 / 2.0f)));
            f23 = 2.0f;
        } else {
            f11 = f14;
        }
        fArr[0] = f12 + (f11 / f23) + 0.0f;
        fArr[1] = f13 + (f15 / f23) + 0.0f;
        fArr2[0] = f24;
        fArr2[1] = f25;
    }

    public int e(String str, double[] dArr, int i11) {
        ConstraintAttribute constraintAttribute = this.f11004p.get(str);
        int i12 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.numberOfInterpolatedValues() == 1) {
            dArr[i11] = (double) constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = constraintAttribute.numberOfInterpolatedValues();
        float[] fArr = new float[numberOfInterpolatedValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        while (i12 < numberOfInterpolatedValues) {
            dArr[i11] = (double) fArr[i12];
            i12++;
            i11++;
        }
        return numberOfInterpolatedValues;
    }

    public int f(String str) {
        ConstraintAttribute constraintAttribute = this.f11004p.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.numberOfInterpolatedValues();
    }

    public void g(int[] iArr, double[] dArr, float[] fArr, int i11) {
        float f11 = this.f10994f;
        float f12 = this.f10995g;
        float f13 = this.f10996h;
        float f14 = this.f10997i;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            float f15 = (float) dArr[i12];
            int i13 = iArr[i12];
            if (i13 == 1) {
                f11 = f15;
            } else if (i13 == 2) {
                f12 = f15;
            } else if (i13 == 3) {
                f13 = f15;
            } else if (i13 == 4) {
                f14 = f15;
            }
        }
        MotionController motionController = this.f11003o;
        if (motionController != null) {
            float centerX = motionController.getCenterX();
            double d11 = (double) f11;
            double d12 = (double) f12;
            f12 = (float) ((((double) this.f11003o.getCenterY()) - (d11 * Math.cos(d12))) - ((double) (f14 / 2.0f)));
            f11 = (float) ((((double) centerX) + (Math.sin(d12) * d11)) - ((double) (f13 / 2.0f)));
        }
        float f16 = f13 + f11;
        float f17 = f14 + f12;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i14 = i11 + 1;
        fArr[i11] = f11 + 0.0f;
        int i15 = i14 + 1;
        fArr[i14] = f12 + 0.0f;
        int i16 = i15 + 1;
        fArr[i15] = f16 + 0.0f;
        int i17 = i16 + 1;
        fArr[i16] = f12 + 0.0f;
        int i18 = i17 + 1;
        fArr[i17] = f16 + 0.0f;
        int i19 = i18 + 1;
        fArr[i18] = f17 + 0.0f;
        fArr[i19] = f11 + 0.0f;
        fArr[i19 + 1] = f17 + 0.0f;
    }

    public boolean h(String str) {
        return this.f11004p.containsKey(str);
    }

    public void i(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f11;
        float f12;
        float f13;
        float f14;
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f15 = ((float) keyPosition2.f10871a) / 100.0f;
        this.f10992d = f15;
        this.f10991c = keyPosition2.f10879i;
        if (Float.isNaN(keyPosition2.f10880j)) {
            f11 = f15;
        } else {
            f11 = keyPosition2.f10880j;
        }
        if (Float.isNaN(keyPosition2.f10881k)) {
            f12 = f15;
        } else {
            f12 = keyPosition2.f10881k;
        }
        float f16 = motionPaths4.f10996h;
        float f17 = motionPaths3.f10996h;
        float f18 = motionPaths4.f10997i;
        float f19 = motionPaths3.f10997i;
        this.f10993e = this.f10992d;
        float f21 = motionPaths3.f10994f;
        float f22 = motionPaths3.f10995g;
        float f23 = (motionPaths4.f10994f + (f16 / 2.0f)) - ((f17 / 2.0f) + f21);
        float f24 = (motionPaths4.f10995g + (f18 / 2.0f)) - (f22 + (f19 / 2.0f));
        float f25 = (f16 - f17) * f11;
        float f26 = f25 / 2.0f;
        this.f10994f = (float) ((int) ((f21 + (f23 * f15)) - f26));
        float f27 = (f18 - f19) * f12;
        float f28 = f27 / 2.0f;
        this.f10995g = (float) ((int) ((f22 + (f24 * f15)) - f28));
        this.f10996h = (float) ((int) (f17 + f25));
        this.f10997i = (float) ((int) (f19 + f27));
        KeyPosition keyPosition3 = keyPosition;
        if (Float.isNaN(keyPosition3.f10882l)) {
            f13 = f15;
        } else {
            f13 = keyPosition3.f10882l;
        }
        float f29 = 0.0f;
        if (Float.isNaN(keyPosition3.f10885o)) {
            f14 = 0.0f;
        } else {
            f14 = keyPosition3.f10885o;
        }
        if (!Float.isNaN(keyPosition3.f10883m)) {
            f15 = keyPosition3.f10883m;
        }
        if (!Float.isNaN(keyPosition3.f10884n)) {
            f29 = keyPosition3.f10884n;
        }
        this.f11005q = 0;
        MotionPaths motionPaths5 = motionPaths;
        this.f10994f = (float) ((int) (((motionPaths5.f10994f + (f13 * f23)) + (f29 * f24)) - f26));
        this.f10995g = (float) ((int) (((motionPaths5.f10995g + (f23 * f14)) + (f24 * f15)) - f28));
        this.f10990b = Easing.getInterpolator(keyPosition3.f10877g);
        this.f11000l = keyPosition3.f10878h;
    }

    public void j(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f11;
        float f12;
        float f13;
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f14 = ((float) keyPosition2.f10871a) / 100.0f;
        this.f10992d = f14;
        this.f10991c = keyPosition2.f10879i;
        if (Float.isNaN(keyPosition2.f10880j)) {
            f11 = f14;
        } else {
            f11 = keyPosition2.f10880j;
        }
        if (Float.isNaN(keyPosition2.f10881k)) {
            f12 = f14;
        } else {
            f12 = keyPosition2.f10881k;
        }
        float f15 = motionPaths4.f10996h - motionPaths3.f10996h;
        float f16 = motionPaths4.f10997i - motionPaths3.f10997i;
        this.f10993e = this.f10992d;
        if (!Float.isNaN(keyPosition2.f10882l)) {
            f14 = keyPosition2.f10882l;
        }
        float f17 = motionPaths3.f10994f;
        float f18 = motionPaths3.f10996h;
        float f19 = motionPaths3.f10995g;
        float f21 = motionPaths3.f10997i;
        float f22 = motionPaths4.f10994f + (motionPaths4.f10996h / 2.0f);
        float f23 = f22 - ((f18 / 2.0f) + f17);
        float f24 = (motionPaths4.f10995g + (motionPaths4.f10997i / 2.0f)) - ((f21 / 2.0f) + f19);
        float f25 = f23 * f14;
        float f26 = f15 * f11;
        float f27 = f26 / 2.0f;
        this.f10994f = (float) ((int) ((f17 + f25) - f27));
        float f28 = f14 * f24;
        float f29 = f16 * f12;
        float f31 = f29 / 2.0f;
        this.f10995g = (float) ((int) ((f19 + f28) - f31));
        this.f10996h = (float) ((int) (f18 + f26));
        this.f10997i = (float) ((int) (f21 + f29));
        KeyPosition keyPosition3 = keyPosition;
        if (Float.isNaN(keyPosition3.f10883m)) {
            f13 = 0.0f;
        } else {
            f13 = keyPosition3.f10883m;
        }
        float f32 = (-f24) * f13;
        float f33 = f23 * f13;
        this.f11005q = 1;
        MotionPaths motionPaths5 = motionPaths;
        this.f10994f = ((float) ((int) ((motionPaths5.f10994f + f25) - f27))) + f32;
        this.f10995g = ((float) ((int) ((motionPaths5.f10995g + f28) - f31))) + f33;
        this.f11001m = this.f11001m;
        this.f10990b = Easing.getInterpolator(keyPosition3.f10877g);
        this.f11000l = keyPosition3.f10878h;
    }

    public void k(int i11, int i12, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17 = ((float) keyPosition.f10871a) / 100.0f;
        this.f10992d = f17;
        this.f10991c = keyPosition.f10879i;
        this.f11005q = keyPosition.f10886p;
        if (Float.isNaN(keyPosition.f10880j)) {
            f11 = f17;
        } else {
            f11 = keyPosition.f10880j;
        }
        if (Float.isNaN(keyPosition.f10881k)) {
            f12 = f17;
        } else {
            f12 = keyPosition.f10881k;
        }
        float f18 = motionPaths2.f10996h;
        float f19 = motionPaths.f10996h;
        float f21 = motionPaths2.f10997i;
        float f22 = motionPaths.f10997i;
        this.f10993e = this.f10992d;
        this.f10996h = (float) ((int) (f19 + ((f18 - f19) * f11)));
        this.f10997i = (float) ((int) (f22 + ((f21 - f22) * f12)));
        int i13 = keyPosition.f10886p;
        if (i13 == 1) {
            if (Float.isNaN(keyPosition.f10882l)) {
                f13 = f17;
            } else {
                f13 = keyPosition.f10882l;
            }
            float f23 = motionPaths2.f10994f;
            float f24 = motionPaths.f10994f;
            this.f10994f = (f13 * (f23 - f24)) + f24;
            if (!Float.isNaN(keyPosition.f10883m)) {
                f17 = keyPosition.f10883m;
            }
            float f25 = motionPaths2.f10995g;
            float f26 = motionPaths.f10995g;
            this.f10995g = (f17 * (f25 - f26)) + f26;
        } else if (i13 != 2) {
            if (Float.isNaN(keyPosition.f10882l)) {
                f16 = f17;
            } else {
                f16 = keyPosition.f10882l;
            }
            float f27 = motionPaths2.f10994f;
            float f28 = motionPaths.f10994f;
            this.f10994f = (f16 * (f27 - f28)) + f28;
            if (!Float.isNaN(keyPosition.f10883m)) {
                f17 = keyPosition.f10883m;
            }
            float f29 = motionPaths2.f10995g;
            float f31 = motionPaths.f10995g;
            this.f10995g = (f17 * (f29 - f31)) + f31;
        } else {
            if (Float.isNaN(keyPosition.f10882l)) {
                float f32 = motionPaths2.f10994f;
                float f33 = motionPaths.f10994f;
                f14 = ((f32 - f33) * f17) + f33;
            } else {
                f14 = Math.min(f12, f11) * keyPosition.f10882l;
            }
            this.f10994f = f14;
            if (Float.isNaN(keyPosition.f10883m)) {
                float f34 = motionPaths2.f10995g;
                float f35 = motionPaths.f10995g;
                f15 = (f17 * (f34 - f35)) + f35;
            } else {
                f15 = keyPosition.f10883m;
            }
            this.f10995g = f15;
        }
        this.f11001m = motionPaths.f11001m;
        this.f10990b = Easing.getInterpolator(keyPosition.f10877g);
        this.f11000l = keyPosition.f10878h;
    }

    public void l(int i11, int i12, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f11;
        float f12;
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f13 = ((float) keyPosition2.f10871a) / 100.0f;
        this.f10992d = f13;
        this.f10991c = keyPosition2.f10879i;
        if (Float.isNaN(keyPosition2.f10880j)) {
            f11 = f13;
        } else {
            f11 = keyPosition2.f10880j;
        }
        if (Float.isNaN(keyPosition2.f10881k)) {
            f12 = f13;
        } else {
            f12 = keyPosition2.f10881k;
        }
        float f14 = motionPaths4.f10996h;
        float f15 = motionPaths3.f10996h;
        float f16 = motionPaths4.f10997i;
        float f17 = motionPaths3.f10997i;
        this.f10993e = this.f10992d;
        float f18 = motionPaths3.f10994f;
        float f19 = motionPaths3.f10995g;
        float f21 = motionPaths4.f10994f + (f14 / 2.0f);
        float f22 = motionPaths4.f10995g + (f16 / 2.0f);
        float f23 = (f14 - f15) * f11;
        this.f10994f = (float) ((int) ((f18 + ((f21 - ((f15 / 2.0f) + f18)) * f13)) - (f23 / 2.0f)));
        float f24 = (f16 - f17) * f12;
        this.f10995g = (float) ((int) ((f19 + ((f22 - (f19 + (f17 / 2.0f))) * f13)) - (f24 / 2.0f)));
        this.f10996h = (float) ((int) (f15 + f23));
        this.f10997i = (float) ((int) (f17 + f24));
        this.f11005q = 2;
        KeyPosition keyPosition3 = keyPosition;
        if (!Float.isNaN(keyPosition3.f10882l)) {
            this.f10994f = (float) ((int) (keyPosition3.f10882l * ((float) ((int) (((float) i11) - this.f10996h)))));
        }
        if (!Float.isNaN(keyPosition3.f10883m)) {
            this.f10995g = (float) ((int) (keyPosition3.f10883m * ((float) ((int) (((float) i12) - this.f10997i)))));
        }
        this.f11001m = this.f11001m;
        this.f10990b = Easing.getInterpolator(keyPosition3.f10877g);
        this.f11000l = keyPosition3.f10878h;
    }

    public void m(float f11, float f12, float f13, float f14) {
        this.f10994f = f11;
        this.f10995g = f12;
        this.f10996h = f13;
        this.f10997i = f14;
    }

    public void n(float f11, float f12, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            float f17 = (float) dArr[i11];
            double d11 = dArr2[i11];
            int i12 = iArr2[i11];
            if (i12 == 1) {
                f13 = f17;
            } else if (i12 == 2) {
                f15 = f17;
            } else if (i12 == 3) {
                f14 = f17;
            } else if (i12 == 4) {
                f16 = f17;
            }
        }
        float f18 = f13 - ((0.0f * f14) / 2.0f);
        float f19 = f15 - ((0.0f * f16) / 2.0f);
        fArr[0] = (f18 * (1.0f - f11)) + (((f14 * 1.0f) + f18) * f11) + 0.0f;
        fArr[1] = (f19 * (1.0f - f12)) + (((f16 * 1.0f) + f19) * f12) + 0.0f;
    }

    public void o(float f11, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z11) {
        float f12;
        boolean z12;
        boolean z13;
        float f13;
        View view2 = view;
        int[] iArr2 = iArr;
        double[] dArr4 = dArr2;
        float f14 = this.f10994f;
        float f15 = this.f10995g;
        float f16 = this.f10996h;
        float f17 = this.f10997i;
        if (iArr2.length != 0 && this.f11007s.length <= iArr2[iArr2.length - 1]) {
            int i11 = iArr2[iArr2.length - 1] + 1;
            this.f11007s = new double[i11];
            this.f11008t = new double[i11];
        }
        Arrays.fill(this.f11007s, Double.NaN);
        for (int i12 = 0; i12 < iArr2.length; i12++) {
            double[] dArr5 = this.f11007s;
            int i13 = iArr2[i12];
            dArr5[i13] = dArr[i12];
            this.f11008t[i13] = dArr4[i12];
        }
        float f18 = Float.NaN;
        int i14 = 0;
        float f19 = 0.0f;
        float f21 = 0.0f;
        float f22 = 0.0f;
        float f23 = 0.0f;
        while (true) {
            double[] dArr6 = this.f11007s;
            if (i14 >= dArr6.length) {
                break;
            }
            double d11 = 0.0d;
            if (!Double.isNaN(dArr6[i14]) || !(dArr3 == null || dArr3[i14] == 0.0d)) {
                if (dArr3 != null) {
                    d11 = dArr3[i14];
                }
                if (!Double.isNaN(this.f11007s[i14])) {
                    d11 = this.f11007s[i14] + d11;
                }
                f13 = f18;
                float f24 = (float) d11;
                float f25 = (float) this.f11008t[i14];
                if (i14 == 1) {
                    f18 = f13;
                    f19 = f25;
                    f14 = f24;
                } else if (i14 == 2) {
                    f18 = f13;
                    f21 = f25;
                    f15 = f24;
                } else if (i14 == 3) {
                    f18 = f13;
                    f22 = f25;
                    f16 = f24;
                } else if (i14 == 4) {
                    f18 = f13;
                    f23 = f25;
                    f17 = f24;
                } else if (i14 == 5) {
                    f18 = f24;
                }
                i14++;
                double[] dArr7 = dArr2;
            } else {
                f13 = f18;
            }
            f18 = f13;
            i14++;
            double[] dArr72 = dArr2;
        }
        float f26 = f18;
        MotionController motionController = this.f11003o;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter((double) f11, fArr, fArr2);
            float f27 = fArr[0];
            float f28 = fArr[1];
            float f29 = fArr2[0];
            float f31 = fArr2[1];
            double d12 = (double) f14;
            double d13 = (double) f15;
            double sin = ((double) f27) + (Math.sin(d13) * d12);
            f12 = f17;
            float f32 = (float) (sin - ((double) (f16 / 2.0f)));
            float cos = (float) ((((double) f28) - (Math.cos(d13) * d12)) - ((double) (f17 / 2.0f)));
            double d14 = (double) f19;
            double d15 = (double) f21;
            float sin2 = (float) (((double) f29) + (Math.sin(d13) * d14) + (Math.cos(d13) * d12 * d15));
            float f33 = f32;
            float cos2 = (float) ((((double) f31) - (d14 * Math.cos(d13))) + (d12 * Math.sin(d13) * d15));
            double[] dArr8 = dArr2;
            if (dArr8.length >= 2) {
                z13 = false;
                dArr8[0] = (double) sin2;
                z12 = true;
                dArr8[1] = (double) cos2;
            } else {
                z13 = false;
                z12 = true;
            }
            if (!Float.isNaN(f26)) {
                view2.setRotation((float) (((double) f26) + Math.toDegrees(Math.atan2((double) cos2, (double) sin2))));
            }
            f14 = f33;
            f15 = cos;
        } else {
            float f34 = f26;
            f12 = f17;
            z13 = false;
            z12 = true;
            if (!Float.isNaN(f34)) {
                view2.setRotation((float) (((double) 0.0f) + ((double) f34) + Math.toDegrees(Math.atan2((double) (f21 + (f23 / 2.0f)), (double) (f19 + (f22 / 2.0f))))));
            }
        }
        if (view2 instanceof FloatLayout) {
            ((FloatLayout) view2).layout(f14, f15, f16 + f14, f15 + f12);
            return;
        }
        float f35 = f14 + 0.5f;
        int i15 = (int) f35;
        float f36 = f15 + 0.5f;
        int i16 = (int) f36;
        int i17 = (int) (f35 + f16);
        int i18 = (int) (f36 + f12);
        int i19 = i17 - i15;
        int i21 = i18 - i16;
        if (!(i19 == view.getMeasuredWidth() && i21 == view.getMeasuredHeight())) {
            z13 = z12;
        }
        if (z13 || z11) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), View.MeasureSpec.makeMeasureSpec(i21, 1073741824));
        }
        view2.layout(i15, i16, i17, i18);
    }

    public void setupRelative(MotionController motionController, MotionPaths motionPaths) {
        double d11 = (double) (((this.f10994f + (this.f10996h / 2.0f)) - motionPaths.f10994f) - (motionPaths.f10996h / 2.0f));
        double d12 = (double) (((this.f10995g + (this.f10997i / 2.0f)) - motionPaths.f10995g) - (motionPaths.f10997i / 2.0f));
        this.f11003o = motionController;
        this.f10994f = (float) Math.hypot(d12, d11);
        if (Float.isNaN(this.f11002n)) {
            this.f10995g = (float) (Math.atan2(d12, d11) + 1.5707963267948966d);
        } else {
            this.f10995g = (float) Math.toRadians((double) this.f11002n);
        }
    }

    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.f10993e, motionPaths.f10993e);
    }

    public MotionPaths(int i11, int i12, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i13 = Key.UNSET;
        this.f11000l = i13;
        this.f11001m = i13;
        this.f11002n = Float.NaN;
        this.f11003o = null;
        this.f11004p = new LinkedHashMap<>();
        this.f11005q = 0;
        this.f11007s = new double[18];
        this.f11008t = new double[18];
        if (motionPaths.f11001m != Key.UNSET) {
            k(i11, i12, keyPosition, motionPaths, motionPaths2);
            return;
        }
        int i14 = keyPosition.f10886p;
        if (i14 == 1) {
            j(keyPosition, motionPaths, motionPaths2);
        } else if (i14 != 2) {
            i(keyPosition, motionPaths, motionPaths2);
        } else {
            l(i11, i12, keyPosition, motionPaths, motionPaths2);
        }
    }
}
