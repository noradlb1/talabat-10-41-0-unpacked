package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Arrays;
import java.util.HashMap;

public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";

    /* renamed from: u  reason: collision with root package name */
    public static String[] f10493u = {"position", Param.X, Param.Y, "width", "height", "pathRotate"};

    /* renamed from: b  reason: collision with root package name */
    public Easing f10494b;

    /* renamed from: c  reason: collision with root package name */
    public int f10495c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float f10496d;

    /* renamed from: e  reason: collision with root package name */
    public float f10497e;

    /* renamed from: f  reason: collision with root package name */
    public float f10498f;

    /* renamed from: g  reason: collision with root package name */
    public float f10499g;

    /* renamed from: h  reason: collision with root package name */
    public float f10500h;

    /* renamed from: i  reason: collision with root package name */
    public float f10501i;

    /* renamed from: j  reason: collision with root package name */
    public float f10502j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f10503k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public int f10504l = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f10505m = -1;

    /* renamed from: n  reason: collision with root package name */
    public float f10506n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public Motion f10507o = null;

    /* renamed from: p  reason: collision with root package name */
    public HashMap<String, CustomVariable> f10508p = new HashMap<>();

    /* renamed from: q  reason: collision with root package name */
    public int f10509q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f10510r;

    /* renamed from: s  reason: collision with root package name */
    public double[] f10511s = new double[18];

    /* renamed from: t  reason: collision with root package name */
    public double[] f10512t = new double[18];

    public MotionPaths() {
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
        boolean diff = diff(this.f10498f, motionPaths.f10498f);
        boolean diff2 = diff(this.f10499g, motionPaths.f10499g);
        zArr[0] = zArr[0] | diff(this.f10497e, motionPaths.f10497e);
        boolean z12 = diff | diff2 | z11;
        zArr[1] = zArr[1] | z12;
        zArr[2] = z12 | zArr[2];
        zArr[3] = zArr[3] | diff(this.f10500h, motionPaths.f10500h);
        zArr[4] = diff(this.f10501i, motionPaths.f10501i) | zArr[4];
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.f10494b = Easing.getInterpolator(motionWidget.f10514b.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.f10514b;
        this.f10504l = motion.mPathMotionArc;
        this.f10505m = motion.mAnimateRelativeTo;
        this.f10502j = motion.mPathRotate;
        this.f10495c = motion.mDrawPath;
        this.f10510r = motion.mAnimateCircleAngleTo;
        this.f10503k = motionWidget.f10515c.mProgress;
        this.f10506n = 0.0f;
        for (String next : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(next);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.f10508p.put(next, customAttribute);
            }
        }
    }

    public void b(double[] dArr, int[] iArr) {
        float[] fArr = {this.f10497e, this.f10498f, this.f10499g, this.f10500h, this.f10501i, this.f10502j};
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
        float f11 = this.f10498f;
        float f12 = this.f10499g;
        float f13 = this.f10500h;
        float f14 = this.f10501i;
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
        Motion motion = this.f10507o;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d11, fArr2, new float[2]);
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

    public void configureRelativeTo(Motion motion) {
        motion.a((double) this.f10503k);
    }

    public void d(double d11, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f11;
        int[] iArr2 = iArr;
        float f12 = this.f10498f;
        float f13 = this.f10499g;
        float f14 = this.f10500h;
        float f15 = this.f10501i;
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
        Motion motion = this.f10507o;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d11, fArr3, fArr4);
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
        CustomVariable customVariable = this.f10508p.get(str);
        int i12 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i11] = (double) customVariable.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        float[] fArr = new float[numberOfInterpolatedValues];
        customVariable.getValuesToInterpolate(fArr);
        while (i12 < numberOfInterpolatedValues) {
            dArr[i11] = (double) fArr[i12];
            i12++;
            i11++;
        }
        return numberOfInterpolatedValues;
    }

    public int f(String str) {
        CustomVariable customVariable = this.f10508p.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    public void g(int[] iArr, double[] dArr, float[] fArr, int i11) {
        float f11 = this.f10498f;
        float f12 = this.f10499g;
        float f13 = this.f10500h;
        float f14 = this.f10501i;
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
        Motion motion = this.f10507o;
        if (motion != null) {
            float centerX = motion.getCenterX();
            double d11 = (double) f11;
            double d12 = (double) f12;
            f12 = (float) ((((double) this.f10507o.getCenterY()) - (d11 * Math.cos(d12))) - ((double) (f14 / 2.0f)));
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
        return this.f10508p.containsKey(str);
    }

    public void i(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f11;
        float f12;
        float f13;
        float f14;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f15 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.f10496d = f15;
        this.f10495c = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f11 = f15;
        } else {
            f11 = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f12 = f15;
        } else {
            f12 = motionKeyPosition2.mPercentHeight;
        }
        float f16 = motionPaths4.f10500h;
        float f17 = motionPaths3.f10500h;
        float f18 = motionPaths4.f10501i;
        float f19 = motionPaths3.f10501i;
        this.f10497e = this.f10496d;
        float f21 = motionPaths3.f10498f;
        float f22 = motionPaths3.f10499g;
        float f23 = (motionPaths4.f10498f + (f16 / 2.0f)) - ((f17 / 2.0f) + f21);
        float f24 = (motionPaths4.f10499g + (f18 / 2.0f)) - (f22 + (f19 / 2.0f));
        float f25 = (f16 - f17) * f11;
        float f26 = f25 / 2.0f;
        this.f10498f = (float) ((int) ((f21 + (f23 * f15)) - f26));
        float f27 = (f18 - f19) * f12;
        float f28 = f27 / 2.0f;
        this.f10499g = (float) ((int) ((f22 + (f24 * f15)) - f28));
        this.f10500h = (float) ((int) (f17 + f25));
        this.f10501i = (float) ((int) (f19 + f27));
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        if (Float.isNaN(motionKeyPosition3.mPercentX)) {
            f13 = f15;
        } else {
            f13 = motionKeyPosition3.mPercentX;
        }
        float f29 = 0.0f;
        if (Float.isNaN(motionKeyPosition3.mAltPercentY)) {
            f14 = 0.0f;
        } else {
            f14 = motionKeyPosition3.mAltPercentY;
        }
        if (!Float.isNaN(motionKeyPosition3.mPercentY)) {
            f15 = motionKeyPosition3.mPercentY;
        }
        if (!Float.isNaN(motionKeyPosition3.mAltPercentX)) {
            f29 = motionKeyPosition3.mAltPercentX;
        }
        this.f10509q = 0;
        MotionPaths motionPaths5 = motionPaths;
        this.f10498f = (float) ((int) (((motionPaths5.f10498f + (f13 * f23)) + (f29 * f24)) - f26));
        this.f10499g = (float) ((int) (((motionPaths5.f10499g + (f23 * f14)) + (f24 * f15)) - f28));
        this.f10494b = Easing.getInterpolator(motionKeyPosition3.mTransitionEasing);
        this.f10504l = motionKeyPosition3.mPathMotionArc;
    }

    public void j(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f11;
        float f12;
        float f13;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f14 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.f10496d = f14;
        this.f10495c = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f11 = f14;
        } else {
            f11 = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f12 = f14;
        } else {
            f12 = motionKeyPosition2.mPercentHeight;
        }
        float f15 = motionPaths4.f10500h - motionPaths3.f10500h;
        float f16 = motionPaths4.f10501i - motionPaths3.f10501i;
        this.f10497e = this.f10496d;
        if (!Float.isNaN(motionKeyPosition2.mPercentX)) {
            f14 = motionKeyPosition2.mPercentX;
        }
        float f17 = motionPaths3.f10498f;
        float f18 = motionPaths3.f10500h;
        float f19 = motionPaths3.f10499g;
        float f21 = motionPaths3.f10501i;
        float f22 = motionPaths4.f10498f + (motionPaths4.f10500h / 2.0f);
        float f23 = f22 - ((f18 / 2.0f) + f17);
        float f24 = (motionPaths4.f10499g + (motionPaths4.f10501i / 2.0f)) - ((f21 / 2.0f) + f19);
        float f25 = f23 * f14;
        float f26 = f15 * f11;
        float f27 = f26 / 2.0f;
        this.f10498f = (float) ((int) ((f17 + f25) - f27));
        float f28 = f14 * f24;
        float f29 = f16 * f12;
        float f31 = f29 / 2.0f;
        this.f10499g = (float) ((int) ((f19 + f28) - f31));
        this.f10500h = (float) ((int) (f18 + f26));
        this.f10501i = (float) ((int) (f21 + f29));
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        if (Float.isNaN(motionKeyPosition3.mPercentY)) {
            f13 = 0.0f;
        } else {
            f13 = motionKeyPosition3.mPercentY;
        }
        float f32 = (-f24) * f13;
        float f33 = f23 * f13;
        this.f10509q = 1;
        MotionPaths motionPaths5 = motionPaths;
        this.f10498f = ((float) ((int) ((motionPaths5.f10498f + f25) - f27))) + f32;
        this.f10499g = ((float) ((int) ((motionPaths5.f10499g + f28) - f31))) + f33;
        this.f10505m = this.f10505m;
        this.f10494b = Easing.getInterpolator(motionKeyPosition3.mTransitionEasing);
        this.f10504l = motionKeyPosition3.mPathMotionArc;
    }

    public void k(int i11, int i12, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17 = ((float) motionKeyPosition.mFramePosition) / 100.0f;
        this.f10496d = f17;
        this.f10495c = motionKeyPosition.mDrawPath;
        this.f10509q = motionKeyPosition.mPositionType;
        if (Float.isNaN(motionKeyPosition.mPercentWidth)) {
            f11 = f17;
        } else {
            f11 = motionKeyPosition.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition.mPercentHeight)) {
            f12 = f17;
        } else {
            f12 = motionKeyPosition.mPercentHeight;
        }
        float f18 = motionPaths2.f10500h;
        float f19 = motionPaths.f10500h;
        float f21 = motionPaths2.f10501i;
        float f22 = motionPaths.f10501i;
        this.f10497e = this.f10496d;
        this.f10500h = (float) ((int) (f19 + ((f18 - f19) * f11)));
        this.f10501i = (float) ((int) (f22 + ((f21 - f22) * f12)));
        int i13 = motionKeyPosition.mPositionType;
        if (i13 == 1) {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                f13 = f17;
            } else {
                f13 = motionKeyPosition.mPercentX;
            }
            float f23 = motionPaths2.f10498f;
            float f24 = motionPaths.f10498f;
            this.f10498f = (f13 * (f23 - f24)) + f24;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f17 = motionKeyPosition.mPercentY;
            }
            float f25 = motionPaths2.f10499g;
            float f26 = motionPaths.f10499g;
            this.f10499g = (f17 * (f25 - f26)) + f26;
        } else if (i13 != 2) {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                f16 = f17;
            } else {
                f16 = motionKeyPosition.mPercentX;
            }
            float f27 = motionPaths2.f10498f;
            float f28 = motionPaths.f10498f;
            this.f10498f = (f16 * (f27 - f28)) + f28;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f17 = motionKeyPosition.mPercentY;
            }
            float f29 = motionPaths2.f10499g;
            float f31 = motionPaths.f10499g;
            this.f10499g = (f17 * (f29 - f31)) + f31;
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f32 = motionPaths2.f10498f;
                float f33 = motionPaths.f10498f;
                f14 = ((f32 - f33) * f17) + f33;
            } else {
                f14 = Math.min(f12, f11) * motionKeyPosition.mPercentX;
            }
            this.f10498f = f14;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f34 = motionPaths2.f10499g;
                float f35 = motionPaths.f10499g;
                f15 = (f17 * (f34 - f35)) + f35;
            } else {
                f15 = motionKeyPosition.mPercentY;
            }
            this.f10499g = f15;
        }
        this.f10505m = motionPaths.f10505m;
        this.f10494b = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.f10504l = motionKeyPosition.mPathMotionArc;
    }

    public void l(int i11, int i12, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f11;
        float f12;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f13 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.f10496d = f13;
        this.f10495c = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f11 = f13;
        } else {
            f11 = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f12 = f13;
        } else {
            f12 = motionKeyPosition2.mPercentHeight;
        }
        float f14 = motionPaths4.f10500h;
        float f15 = motionPaths3.f10500h;
        float f16 = motionPaths4.f10501i;
        float f17 = motionPaths3.f10501i;
        this.f10497e = this.f10496d;
        float f18 = motionPaths3.f10498f;
        float f19 = motionPaths3.f10499g;
        float f21 = motionPaths4.f10498f + (f14 / 2.0f);
        float f22 = motionPaths4.f10499g + (f16 / 2.0f);
        float f23 = (f14 - f15) * f11;
        this.f10498f = (float) ((int) ((f18 + ((f21 - ((f15 / 2.0f) + f18)) * f13)) - (f23 / 2.0f)));
        float f24 = (f16 - f17) * f12;
        this.f10499g = (float) ((int) ((f19 + ((f22 - (f19 + (f17 / 2.0f))) * f13)) - (f24 / 2.0f)));
        this.f10500h = (float) ((int) (f15 + f23));
        this.f10501i = (float) ((int) (f17 + f24));
        this.f10509q = 2;
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        if (!Float.isNaN(motionKeyPosition3.mPercentX)) {
            this.f10498f = (float) ((int) (motionKeyPosition3.mPercentX * ((float) ((int) (((float) i11) - this.f10500h)))));
        }
        if (!Float.isNaN(motionKeyPosition3.mPercentY)) {
            this.f10499g = (float) ((int) (motionKeyPosition3.mPercentY * ((float) ((int) (((float) i12) - this.f10501i)))));
        }
        this.f10505m = this.f10505m;
        this.f10494b = Easing.getInterpolator(motionKeyPosition3.mTransitionEasing);
        this.f10504l = motionKeyPosition3.mPathMotionArc;
    }

    public void m(float f11, float f12, float f13, float f14) {
        this.f10498f = f11;
        this.f10499g = f12;
        this.f10500h = f13;
        this.f10501i = f14;
    }

    public void n(float f11, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f12;
        float f13;
        MotionWidget motionWidget2 = motionWidget;
        int[] iArr2 = iArr;
        double[] dArr4 = dArr2;
        float f14 = this.f10498f;
        float f15 = this.f10499g;
        float f16 = this.f10500h;
        float f17 = this.f10501i;
        if (iArr2.length != 0 && this.f10511s.length <= iArr2[iArr2.length - 1]) {
            int i11 = iArr2[iArr2.length - 1] + 1;
            this.f10511s = new double[i11];
            this.f10512t = new double[i11];
        }
        Arrays.fill(this.f10511s, Double.NaN);
        for (int i12 = 0; i12 < iArr2.length; i12++) {
            double[] dArr5 = this.f10511s;
            int i13 = iArr2[i12];
            dArr5[i13] = dArr[i12];
            this.f10512t[i13] = dArr4[i12];
        }
        float f18 = Float.NaN;
        int i14 = 0;
        float f19 = 0.0f;
        float f21 = 0.0f;
        float f22 = 0.0f;
        float f23 = 0.0f;
        while (true) {
            double[] dArr6 = this.f10511s;
            if (i14 >= dArr6.length) {
                break;
            }
            double d11 = 0.0d;
            if (!Double.isNaN(dArr6[i14]) || !(dArr3 == null || dArr3[i14] == 0.0d)) {
                if (dArr3 != null) {
                    d11 = dArr3[i14];
                }
                if (!Double.isNaN(this.f10511s[i14])) {
                    d11 = this.f10511s[i14] + d11;
                }
                f13 = f18;
                float f24 = (float) d11;
                float f25 = (float) this.f10512t[i14];
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
        Motion motion = this.f10507o;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter((double) f11, fArr, fArr2);
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
                dArr8[0] = (double) sin2;
                dArr8[1] = (double) cos2;
            }
            if (!Float.isNaN(f26)) {
                motionWidget2.setRotationZ((float) (((double) f26) + Math.toDegrees(Math.atan2((double) cos2, (double) sin2))));
            }
            f14 = f33;
            f15 = cos;
        } else {
            float f34 = f26;
            f12 = f17;
            if (!Float.isNaN(f34)) {
                motionWidget2.setRotationZ((float) (((double) 0.0f) + ((double) f34) + Math.toDegrees(Math.atan2((double) (f21 + (f23 / 2.0f)), (double) (f19 + (f22 / 2.0f))))));
            }
        }
        float f35 = f14 + 0.5f;
        float f36 = f15 + 0.5f;
        motionWidget2.layout((int) f35, (int) f36, (int) (f35 + f16), (int) (f36 + f12));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d11 = (double) (((this.f10498f + (this.f10500h / 2.0f)) - motionPaths.f10498f) - (motionPaths.f10500h / 2.0f));
        double d12 = (double) (((this.f10499g + (this.f10501i / 2.0f)) - motionPaths.f10499g) - (motionPaths.f10501i / 2.0f));
        this.f10507o = motion;
        this.f10498f = (float) Math.hypot(d12, d11);
        if (Float.isNaN(this.f10506n)) {
            this.f10499g = (float) (Math.atan2(d12, d11) + 1.5707963267948966d);
        } else {
            this.f10499g = (float) Math.toRadians((double) this.f10506n);
        }
    }

    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.f10497e, motionPaths.f10497e);
    }

    public MotionPaths(int i11, int i12, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        if (motionPaths.f10505m != -1) {
            k(i11, i12, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i13 = motionKeyPosition.mPositionType;
        if (i13 == 1) {
            j(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i13 != 2) {
            i(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            l(i11, i12, motionKeyPosition, motionPaths, motionPaths2);
        }
    }
}
