package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private int MAX_DIMENSION = 4;

    /* renamed from: a  reason: collision with root package name */
    public Rect f10904a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public View f10905b;

    /* renamed from: c  reason: collision with root package name */
    public int f10906c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10907d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f10908e;

    /* renamed from: f  reason: collision with root package name */
    public float f10909f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    public float f10910g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f10911h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    public float f10912i;

    /* renamed from: j  reason: collision with root package name */
    public float f10913j;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    private HashMap<String, ViewSpline> mAttributesMap;
    private int mCurveFitType = -1;
    private HashMap<String, ViewOscillator> mCycleMap;
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList = new ArrayList<>();
    private KeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    private float[] mValuesBuff = new float[4];
    private float[] mVelocity = new float[1];

    public MotionController(View view) {
        int i11 = Key.UNSET;
        this.mPathMotionArc = i11;
        this.mTransformPivotTarget = i11;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = i11;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(view);
    }

    private float getAdjustedPosition(float f11, float[] fArr) {
        float f12 = 0.0f;
        float f13 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f14 = this.f10911h;
            if (((double) f14) != 1.0d) {
                float f15 = this.f10910g;
                if (f11 < f15) {
                    f11 = 0.0f;
                }
                if (f11 > f15 && ((double) f11) < 1.0d) {
                    f11 = Math.min((f11 - f15) * f14, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.f10990b;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        float f16 = Float.NaN;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            Easing easing2 = next.f10990b;
            if (easing2 != null) {
                float f17 = next.f10992d;
                if (f17 < f11) {
                    easing = easing2;
                    f12 = f17;
                } else if (Float.isNaN(f16)) {
                    f16 = next.f10992d;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f16)) {
                f13 = f16;
            }
            float f18 = f13 - f12;
            double d11 = (double) ((f11 - f12) / f18);
            f11 = (((float) easing.get(d11)) * f18) + f12;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d11);
            }
        }
        return f11;
    }

    private static Interpolator getInterpolator(Context context, int i11, String str, int i12) {
        if (i11 == -2) {
            return AnimationUtils.loadInterpolator(context, i12);
        }
        if (i11 == -1) {
            final Easing interpolator = Easing.getInterpolator(str);
            return new Interpolator() {
                public float getInterpolation(float f11) {
                    return (float) Easing.this.get((double) f11);
                }
            };
        } else if (i11 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (i11 == 1) {
                return new AccelerateInterpolator();
            }
            if (i11 == 2) {
                return new DecelerateInterpolator();
            }
            if (i11 == 4) {
                return new BounceInterpolator();
            }
            if (i11 != 5) {
                return null;
            }
            return new OvershootInterpolator();
        }
    }

    private float getPreCycleDistance() {
        char c11;
        float f11;
        float[] fArr = new float[2];
        float f12 = 1.0f / ((float) 99);
        double d11 = 0.0d;
        double d12 = 0.0d;
        float f13 = 0.0f;
        int i11 = 0;
        while (i11 < 100) {
            float f14 = ((float) i11) * f12;
            double d13 = (double) f14;
            Easing easing = this.mStartMotionPath.f10990b;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f15 = Float.NaN;
            float f16 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.f10990b;
                if (easing2 != null) {
                    float f17 = next.f10992d;
                    if (f17 < f14) {
                        easing = easing2;
                        f16 = f17;
                    } else if (Float.isNaN(f15)) {
                        f15 = next.f10992d;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f15)) {
                    f15 = 1.0f;
                }
                float f18 = f15 - f16;
                d13 = (double) ((((float) easing.get((double) ((f14 - f16) / f18))) * f18) + f16);
            }
            this.mSpline[0].getPos(d13, this.mInterpolateData);
            float f19 = f13;
            int i12 = i11;
            this.mStartMotionPath.c(d13, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i12 > 0) {
                c11 = 0;
                f11 = (float) (((double) f19) + Math.hypot(d12 - ((double) fArr[1]), d11 - ((double) fArr[0])));
            } else {
                c11 = 0;
                f11 = f19;
            }
            d11 = (double) fArr[c11];
            i11 = i12 + 1;
            f13 = f11;
            d12 = (double) fArr[1];
        }
        return f13;
    }

    private void insertKey(MotionPaths motionPaths) {
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            Log.e(TAG, " KeyPath position \"" + motionPaths.f10993e + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.m((float) ((int) this.f10905b.getX()), (float) ((int) this.f10905b.getY()), (float) this.f10905b.getWidth(), (float) this.f10905b.getHeight());
    }

    public void a(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public int b(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                iArr[i11] = it.next().f11005q;
                i11++;
            }
        }
        int i12 = 0;
        for (int i13 = 0; i13 < timePoints.length; i13++) {
            this.mSpline[0].getPos(timePoints[i13], this.mInterpolateData);
            this.mStartMotionPath.c(timePoints[i13], this.mInterpolateVariables, this.mInterpolateData, fArr, i12);
            i12 += 2;
        }
        return i12 / 2;
    }

    public void c(float[] fArr, int i11) {
        SplineSet splineSet;
        SplineSet splineSet2;
        ViewOscillator viewOscillator;
        double d11;
        int i12 = i11;
        float f11 = 1.0f;
        float f12 = 1.0f / ((float) (i12 - 1));
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        ViewOscillator viewOscillator2 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, ViewOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 == null) {
            viewOscillator = null;
        } else {
            viewOscillator = hashMap3.get("translationX");
        }
        HashMap<String, ViewOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            viewOscillator2 = hashMap4.get("translationY");
        }
        ViewOscillator viewOscillator3 = viewOscillator2;
        int i13 = 0;
        while (i13 < i12) {
            float f13 = ((float) i13) * f12;
            float f14 = this.f10911h;
            float f15 = 0.0f;
            if (f14 != f11) {
                float f16 = this.f10910g;
                if (f13 < f16) {
                    f13 = 0.0f;
                }
                if (f13 > f16 && ((double) f13) < 1.0d) {
                    f13 = Math.min((f13 - f16) * f14, f11);
                }
            }
            float f17 = f13;
            double d12 = (double) f17;
            Easing easing = this.mStartMotionPath.f10990b;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f18 = Float.NaN;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.f10990b;
                double d13 = d12;
                if (easing2 != null) {
                    float f19 = next.f10992d;
                    if (f19 < f17) {
                        f15 = f19;
                        easing = easing2;
                    } else if (Float.isNaN(f18)) {
                        f18 = next.f10992d;
                    }
                }
                d12 = d13;
            }
            double d14 = d12;
            if (easing != null) {
                if (Float.isNaN(f18)) {
                    f18 = 1.0f;
                }
                float f21 = f18 - f15;
                d11 = (double) ((((float) easing.get((double) ((f17 - f15) / f21))) * f21) + f15);
            } else {
                d11 = d14;
            }
            this.mSpline[0].getPos(d11, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d11, dArr);
                }
            }
            int i14 = i13 * 2;
            float f22 = f17;
            int i15 = i13;
            this.mStartMotionPath.c(d11, this.mInterpolateVariables, this.mInterpolateData, fArr, i14);
            if (viewOscillator != null) {
                fArr[i14] = fArr[i14] + viewOscillator.get(f22);
            } else if (splineSet != null) {
                fArr[i14] = fArr[i14] + splineSet.get(f22);
            }
            if (viewOscillator3 != null) {
                int i16 = i14 + 1;
                fArr[i16] = fArr[i16] + viewOscillator3.get(f22);
            } else if (splineSet2 != null) {
                int i17 = i14 + 1;
                fArr[i17] = fArr[i17] + splineSet2.get(f22);
            }
            i13 = i15 + 1;
            f11 = 1.0f;
        }
    }

    public void d(float f11, float[] fArr, int i11) {
        this.mSpline[0].getPos((double) getAdjustedPosition(f11, (float[]) null), this.mInterpolateData);
        this.mStartMotionPath.g(this.mInterpolateVariables, this.mInterpolateData, fArr, i11);
    }

    public void e(float[] fArr, int i11) {
        float f11 = 1.0f / ((float) (i11 - 1));
        for (int i12 = 0; i12 < i11; i12++) {
            this.mSpline[0].getPos((double) getAdjustedPosition(((float) i12) * f11, (float[]) null), this.mInterpolateData);
            this.mStartMotionPath.g(this.mInterpolateVariables, this.mInterpolateData, fArr, i12 * 8);
        }
    }

    public void f(boolean z11) {
        float f11;
        if ("button".equals(Debug.getName(this.f10905b)) && this.mKeyTriggers != null) {
            int i11 = 0;
            while (true) {
                KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                if (i11 < keyTriggerArr.length) {
                    KeyTrigger keyTrigger = keyTriggerArr[i11];
                    if (z11) {
                        f11 = -100.0f;
                    } else {
                        f11 = 100.0f;
                    }
                    keyTrigger.conditionallyFire(f11, this.f10905b);
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public int g(String str, float[] fArr, int i11) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i12 = 0; i12 < fArr.length; i12++) {
            fArr[i12] = splineSet.get((float) (i12 / (fArr.length - 1)));
        }
        return fArr.length;
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.f11001m;
    }

    public void getCenter(double d11, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d11, dArr);
        this.mSpline[0].getSlope(d11, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.d(d11, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.f10912i;
    }

    public float getCenterY() {
        return this.f10913j;
    }

    public int getDrawPath() {
        int i11 = this.mStartMotionPath.f10991c;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i11 = Math.max(i11, it.next().f10991c);
        }
        return Math.max(i11, this.mEndMotionPath.f10991c);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.f10997i;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.f10996h;
    }

    public float getFinalX() {
        return this.mEndMotionPath.f10994f;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f10995g;
    }

    public int getKeyFrameInfo(int i11, int[] iArr) {
        int i12 = i11;
        float[] fArr = new float[2];
        Iterator<Key> it = this.mKeyList.iterator();
        int i13 = 0;
        int i14 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i15 = next.f10874d;
            if (i15 == i12 || i12 != -1) {
                iArr[i14] = 0;
                int i16 = i14 + 1;
                iArr[i16] = i15;
                int i17 = i16 + 1;
                int i18 = next.f10871a;
                iArr[i17] = i18;
                double d11 = (double) (((float) i18) / 100.0f);
                this.mSpline[0].getPos(d11, this.mInterpolateData);
                this.mStartMotionPath.c(d11, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                int i19 = i17 + 1;
                iArr[i19] = Float.floatToIntBits(fArr[0]);
                int i21 = i19 + 1;
                iArr[i21] = Float.floatToIntBits(fArr[1]);
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    int i22 = i21 + 1;
                    iArr[i22] = keyPosition.f10886p;
                    int i23 = i22 + 1;
                    iArr[i23] = Float.floatToIntBits(keyPosition.f10882l);
                    i21 = i23 + 1;
                    iArr[i21] = Float.floatToIntBits(keyPosition.f10883m);
                }
                int i24 = i21 + 1;
                iArr[i14] = i24 - i14;
                i13++;
                i14 = i24;
            }
        }
        return i13;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<Key> it = this.mKeyList.iterator();
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i13 = next.f10871a;
            iArr[i11] = (next.f10874d * 1000) + i13;
            double d11 = (double) (((float) i13) / 100.0f);
            this.mSpline[0].getPos(d11, this.mInterpolateData);
            this.mStartMotionPath.c(d11, this.mInterpolateVariables, this.mInterpolateData, fArr, i12);
            i12 += 2;
            i11++;
        }
        return i11;
    }

    public float getStartHeight() {
        return this.mStartMotionPath.f10997i;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.f10996h;
    }

    public float getStartX() {
        return this.mStartMotionPath.f10994f;
    }

    public float getStartY() {
        return this.mStartMotionPath.f10995g;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public View getView() {
        return this.f10905b;
    }

    public void h(float f11, float f12, float f13, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f11, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i11 = 0;
        if (curveFitArr != null) {
            double d11 = (double) adjustedPosition;
            curveFitArr[0].getSlope(d11, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d11, this.mInterpolateData);
            float f14 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i11 >= dArr.length) {
                    break;
                }
                dArr[i11] = dArr[i11] * ((double) f14);
                i11++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d11, dArr2);
                    this.mArcSpline.getSlope(d11, this.mInterpolateVelocity);
                    this.mStartMotionPath.n(f12, f13, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
            this.mStartMotionPath.n(f12, f13, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        MotionPaths motionPaths = this.mEndMotionPath;
        float f15 = motionPaths.f10994f;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f16 = f15 - motionPaths2.f10994f;
        float f17 = motionPaths.f10995g - motionPaths2.f10995g;
        float f18 = (motionPaths.f10996h - motionPaths2.f10996h) + f16;
        float f19 = (motionPaths.f10997i - motionPaths2.f10997i) + f17;
        fArr[0] = (f16 * (1.0f - f12)) + (f18 * f12);
        fArr[1] = (f17 * (1.0f - f13)) + (f19 * f13);
    }

    public MotionPaths i(int i11) {
        return this.mMotionPaths.get(i11);
    }

    public float j(int i11, float f11, float f12) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f13 = motionPaths.f10994f;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f14 = motionPaths2.f10994f;
        float f15 = f13 - f14;
        float f16 = motionPaths.f10995g;
        float f17 = motionPaths2.f10995g;
        float f18 = f16 - f17;
        float f19 = f14 + (motionPaths2.f10996h / 2.0f);
        float f21 = f17 + (motionPaths2.f10997i / 2.0f);
        float hypot = (float) Math.hypot((double) f15, (double) f18);
        if (((double) hypot) < 1.0E-7d) {
            return Float.NaN;
        }
        float f22 = f11 - f19;
        float f23 = f12 - f21;
        if (((float) Math.hypot((double) f22, (double) f23)) == 0.0f) {
            return 0.0f;
        }
        float f24 = (f22 * f15) + (f23 * f18);
        if (i11 == 0) {
            return f24 / hypot;
        }
        if (i11 == 1) {
            return (float) Math.sqrt((double) ((hypot * hypot) - (f24 * f24)));
        }
        if (i11 == 2) {
            return f22 / f15;
        }
        if (i11 == 3) {
            return f23 / f15;
        }
        if (i11 == 4) {
            return f22 / f18;
        }
        if (i11 != 5) {
            return 0.0f;
        }
        return f23 / f18;
    }

    public double[] k(double d11) {
        this.mSpline[0].getPos(d11, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d11, dArr);
            }
        }
        return this.mInterpolateData;
    }

    public KeyPositionBase l(int i11, int i12, float f11, float f12) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f13 = motionPaths.f10994f;
        rectF.left = f13;
        float f14 = motionPaths.f10995g;
        rectF.top = f14;
        rectF.right = f13 + motionPaths.f10996h;
        rectF.bottom = f14 + motionPaths.f10997i;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f15 = motionPaths2.f10994f;
        rectF2.left = f15;
        float f16 = motionPaths2.f10995g;
        rectF2.top = f16;
        rectF2.right = f15 + motionPaths2.f10996h;
        rectF2.bottom = f16 + motionPaths2.f10997i;
        Iterator<Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                if (keyPositionBase.intersects(i11, i12, rectF, rectF2, f11, f12)) {
                    return keyPositionBase;
                }
            }
        }
        return null;
    }

    public void m(float f11, int i11, int i12, float f12, float f13, float[] fArr) {
        SplineSet splineSet;
        SplineSet splineSet2;
        SplineSet splineSet3;
        SplineSet splineSet4;
        SplineSet splineSet5;
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        ViewOscillator viewOscillator3;
        ViewOscillator viewOscillator4;
        float adjustedPosition = getAdjustedPosition(f11, this.mVelocity);
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        ViewOscillator viewOscillator5 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, ViewSpline> hashMap3 = this.mAttributesMap;
        if (hashMap3 == null) {
            splineSet3 = null;
        } else {
            splineSet3 = hashMap3.get("rotation");
        }
        HashMap<String, ViewSpline> hashMap4 = this.mAttributesMap;
        if (hashMap4 == null) {
            splineSet4 = null;
        } else {
            splineSet4 = hashMap4.get("scaleX");
        }
        HashMap<String, ViewSpline> hashMap5 = this.mAttributesMap;
        if (hashMap5 == null) {
            splineSet5 = null;
        } else {
            splineSet5 = hashMap5.get("scaleY");
        }
        HashMap<String, ViewOscillator> hashMap6 = this.mCycleMap;
        if (hashMap6 == null) {
            viewOscillator = null;
        } else {
            viewOscillator = hashMap6.get("translationX");
        }
        HashMap<String, ViewOscillator> hashMap7 = this.mCycleMap;
        if (hashMap7 == null) {
            viewOscillator2 = null;
        } else {
            viewOscillator2 = hashMap7.get("translationY");
        }
        HashMap<String, ViewOscillator> hashMap8 = this.mCycleMap;
        if (hashMap8 == null) {
            viewOscillator3 = null;
        } else {
            viewOscillator3 = hashMap8.get("rotation");
        }
        HashMap<String, ViewOscillator> hashMap9 = this.mCycleMap;
        if (hashMap9 == null) {
            viewOscillator4 = null;
        } else {
            viewOscillator4 = hashMap9.get("scaleX");
        }
        HashMap<String, ViewOscillator> hashMap10 = this.mCycleMap;
        if (hashMap10 != null) {
            viewOscillator5 = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity((KeyCycleOscillator) viewOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity((KeyCycleOscillator) viewOscillator, (KeyCycleOscillator) viewOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity((KeyCycleOscillator) viewOscillator4, (KeyCycleOscillator) viewOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d11 = (double) adjustedPosition;
                curveFit.getPos(d11, dArr);
                this.mArcSpline.getSlope(d11, this.mInterpolateVelocity);
                this.mStartMotionPath.n(f12, f13, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f12, f13, i11, i12, fArr);
            return;
        }
        int i13 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = (double) getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f14 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i13 < dArr2.length) {
                    dArr2[i13] = dArr2[i13] * ((double) f14);
                    i13++;
                } else {
                    float f15 = f12;
                    float f16 = f13;
                    this.mStartMotionPath.n(f15, f16, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f15, f16, i11, i12, fArr);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f17 = motionPaths.f10994f;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f18 = f17 - motionPaths2.f10994f;
            float f19 = motionPaths.f10995g - motionPaths2.f10995g;
            ViewOscillator viewOscillator6 = viewOscillator4;
            float f21 = (motionPaths.f10997i - motionPaths2.f10997i) + f19;
            fArr[0] = (f18 * (1.0f - f12)) + (((motionPaths.f10996h - motionPaths2.f10996h) + f18) * f12);
            fArr[1] = (f19 * (1.0f - f13)) + (f21 * f13);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity((KeyCycleOscillator) viewOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity((KeyCycleOscillator) viewOscillator, (KeyCycleOscillator) viewOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity((KeyCycleOscillator) viewOscillator6, (KeyCycleOscillator) viewOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f12, f13, i11, i12, fArr);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v59, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean n(android.view.View r21, float r22, long r23, androidx.constraintlayout.core.motion.utils.KeyCache r25) {
        /*
            r20 = this;
            r0 = r20
            r11 = r21
            r1 = 0
            r2 = r22
            float r2 = r0.getAdjustedPosition(r2, r1)
            int r3 = r0.mQuantizeMotionSteps
            int r4 = androidx.constraintlayout.motion.widget.Key.UNSET
            r13 = 1065353216(0x3f800000, float:1.0)
            if (r3 == r4) goto L_0x0042
            float r3 = (float) r3
            float r3 = r13 / r3
            float r4 = r2 / r3
            double r4 = (double) r4
            double r4 = java.lang.Math.floor(r4)
            float r4 = (float) r4
            float r4 = r4 * r3
            float r2 = r2 % r3
            float r2 = r2 / r3
            float r5 = r0.mQuantizeMotionPhase
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L_0x002d
            float r5 = r0.mQuantizeMotionPhase
            float r2 = r2 + r5
            float r2 = r2 % r13
        L_0x002d:
            android.view.animation.Interpolator r5 = r0.mQuantizeMotionInterpolator
            if (r5 == 0) goto L_0x0036
            float r2 = r5.getInterpolation(r2)
            goto L_0x0040
        L_0x0036:
            double r5 = (double) r2
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x003f
            r2 = r13
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            float r2 = r2 * r3
            float r2 = r2 + r4
        L_0x0042:
            r14 = r2
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r2 = r0.mAttributesMap
            if (r2 == 0) goto L_0x005f
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x004f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x005f
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.utils.ViewSpline r3 = (androidx.constraintlayout.motion.utils.ViewSpline) r3
            r3.setProperty(r11, r14)
            goto L_0x004f
        L_0x005f:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r2 = r0.mTimeCycleAttributesMap
            r15 = 0
            if (r2 == 0) goto L_0x0093
            java.util.Collection r2 = r2.values()
            java.util.Iterator r7 = r2.iterator()
            r8 = r1
            r9 = r15
        L_0x006e:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x008f
            java.lang.Object r1 = r7.next()
            androidx.constraintlayout.motion.utils.ViewTimeCycle r1 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate
            if (r2 == 0) goto L_0x0082
            r8 = r1
            androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate r8 = (androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate) r8
            goto L_0x006e
        L_0x0082:
            r2 = r21
            r3 = r14
            r4 = r23
            r6 = r25
            boolean r1 = r1.setProperty(r2, r3, r4, r6)
            r9 = r9 | r1
            goto L_0x006e
        L_0x008f:
            r16 = r9
            r9 = r8
            goto L_0x0096
        L_0x0093:
            r9 = r1
            r16 = r15
        L_0x0096:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.mSpline
            r10 = 1
            if (r1 == 0) goto L_0x01f1
            r1 = r1[r15]
            double r7 = (double) r14
            double[] r2 = r0.mInterpolateData
            r1.getPos((double) r7, (double[]) r2)
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.mSpline
            r1 = r1[r15]
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r7, (double[]) r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.mArcSpline
            if (r1 == 0) goto L_0x00bf
            double[] r2 = r0.mInterpolateData
            int r3 = r2.length
            if (r3 <= 0) goto L_0x00bf
            r1.getPos((double) r7, (double[]) r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.mArcSpline
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r7, (double[]) r2)
        L_0x00bf:
            boolean r1 = r0.mNoMovement
            if (r1 != 0) goto L_0x00df
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.mStartMotionPath
            int[] r4 = r0.mInterpolateVariables
            double[] r5 = r0.mInterpolateData
            double[] r6 = r0.mInterpolateVelocity
            r17 = 0
            boolean r3 = r0.f10907d
            r2 = r14
            r18 = r3
            r3 = r21
            r12 = r7
            r7 = r17
            r8 = r18
            r1.o(r2, r3, r4, r5, r6, r7, r8)
            r0.f10907d = r15
            goto L_0x00e0
        L_0x00df:
            r12 = r7
        L_0x00e0:
            int r1 = r0.mTransformPivotTarget
            int r2 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r1 == r2) goto L_0x0142
            android.view.View r1 = r0.mTransformPivotView
            if (r1 != 0) goto L_0x00f8
            android.view.ViewParent r1 = r21.getParent()
            android.view.View r1 = (android.view.View) r1
            int r2 = r0.mTransformPivotTarget
            android.view.View r1 = r1.findViewById(r2)
            r0.mTransformPivotView = r1
        L_0x00f8:
            android.view.View r1 = r0.mTransformPivotView
            if (r1 == 0) goto L_0x0142
            int r1 = r1.getTop()
            android.view.View r2 = r0.mTransformPivotView
            int r2 = r2.getBottom()
            int r1 = r1 + r2
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            android.view.View r3 = r0.mTransformPivotView
            int r3 = r3.getLeft()
            android.view.View r4 = r0.mTransformPivotView
            int r4 = r4.getRight()
            int r3 = r3 + r4
            float r3 = (float) r3
            float r3 = r3 / r2
            int r2 = r21.getRight()
            int r4 = r21.getLeft()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x0142
            int r2 = r21.getBottom()
            int r4 = r21.getTop()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x0142
            int r2 = r21.getLeft()
            float r2 = (float) r2
            float r3 = r3 - r2
            int r2 = r21.getTop()
            float r2 = (float) r2
            float r1 = r1 - r2
            r11.setPivotX(r3)
            r11.setPivotY(r1)
        L_0x0142:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r1 = r0.mAttributesMap
            if (r1 == 0) goto L_0x0170
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x014e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0170
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.core.motion.utils.SplineSet r1 = (androidx.constraintlayout.core.motion.utils.SplineSet) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewSpline.PathRotate
            if (r2 == 0) goto L_0x014e
            double[] r2 = r0.mInterpolateVelocity
            int r3 = r2.length
            if (r3 <= r10) goto L_0x014e
            androidx.constraintlayout.motion.utils.ViewSpline$PathRotate r1 = (androidx.constraintlayout.motion.utils.ViewSpline.PathRotate) r1
            r4 = r2[r15]
            r6 = r2[r10]
            r2 = r21
            r3 = r14
            r1.setPathRotate(r2, r3, r4, r6)
            goto L_0x014e
        L_0x0170:
            if (r9 == 0) goto L_0x018d
            double[] r1 = r0.mInterpolateVelocity
            r7 = r1[r15]
            r17 = r1[r10]
            r1 = r9
            r2 = r21
            r3 = r25
            r4 = r14
            r5 = r23
            r19 = r10
            r9 = r17
            boolean r1 = r1.setPathRotate(r2, r3, r4, r5, r7, r9)
            r1 = r16 | r1
            r16 = r1
            goto L_0x018f
        L_0x018d:
            r19 = r10
        L_0x018f:
            r10 = r19
        L_0x0191:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.mSpline
            int r2 = r1.length
            if (r10 >= r2) goto L_0x01b5
            r1 = r1[r10]
            float[] r2 = r0.mValuesBuff
            r1.getPos((double) r12, (float[]) r2)
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.mStartMotionPath
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r1 = r1.f11004p
            java.lang.String[] r2 = r0.mAttributeNames
            int r3 = r10 + -1
            r2 = r2[r3]
            java.lang.Object r1 = r1.get(r2)
            androidx.constraintlayout.widget.ConstraintAttribute r1 = (androidx.constraintlayout.widget.ConstraintAttribute) r1
            float[] r2 = r0.mValuesBuff
            androidx.constraintlayout.motion.utils.CustomSupport.setInterpolatedValue(r1, r11, r2)
            int r10 = r10 + 1
            goto L_0x0191
        L_0x01b5:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mStartPoint
            int r2 = r1.f10896b
            if (r2 != 0) goto L_0x01df
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x01c6
            int r1 = r1.f10897c
            r11.setVisibility(r1)
            goto L_0x01df
        L_0x01c6:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x01d4
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mEndPoint
            int r1 = r1.f10897c
            r11.setVisibility(r1)
            goto L_0x01df
        L_0x01d4:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r2 = r0.mEndPoint
            int r2 = r2.f10897c
            int r1 = r1.f10897c
            if (r2 == r1) goto L_0x01df
            r11.setVisibility(r15)
        L_0x01df:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r1 = r0.mKeyTriggers
            if (r1 == 0) goto L_0x0241
            r1 = r15
        L_0x01e4:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r2 = r0.mKeyTriggers
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0241
            r2 = r2[r1]
            r2.conditionallyFire(r14, r11)
            int r1 = r1 + 1
            goto L_0x01e4
        L_0x01f1:
            r19 = r10
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.mStartMotionPath
            float r2 = r1.f10994f
            androidx.constraintlayout.motion.widget.MotionPaths r3 = r0.mEndMotionPath
            float r4 = r3.f10994f
            float r4 = r4 - r2
            float r4 = r4 * r14
            float r2 = r2 + r4
            float r4 = r1.f10995g
            float r5 = r3.f10995g
            float r5 = r5 - r4
            float r5 = r5 * r14
            float r4 = r4 + r5
            float r5 = r1.f10996h
            float r6 = r3.f10996h
            float r7 = r6 - r5
            float r7 = r7 * r14
            float r7 = r7 + r5
            float r1 = r1.f10997i
            float r3 = r3.f10997i
            float r8 = r3 - r1
            float r8 = r8 * r14
            float r8 = r8 + r1
            r9 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r9
            int r10 = (int) r2
            float r4 = r4 + r9
            int r9 = (int) r4
            float r2 = r2 + r7
            int r2 = (int) r2
            float r4 = r4 + r8
            int r4 = (int) r4
            int r7 = r2 - r10
            int r8 = r4 - r9
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x022f
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x022f
            boolean r1 = r0.f10907d
            if (r1 == 0) goto L_0x023e
        L_0x022f:
            r1 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r1)
            r11.measure(r3, r1)
            r0.f10907d = r15
        L_0x023e:
            r11.layout(r10, r9, r2, r4)
        L_0x0241:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r1 = r0.mCycleMap
            if (r1 == 0) goto L_0x0270
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x024d:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0270
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.motion.utils.ViewOscillator r1 = (androidx.constraintlayout.motion.utils.ViewOscillator) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet
            if (r2 == 0) goto L_0x026c
            androidx.constraintlayout.motion.utils.ViewOscillator$PathRotateSet r1 = (androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet) r1
            double[] r2 = r0.mInterpolateVelocity
            r4 = r2[r15]
            r6 = r2[r19]
            r2 = r21
            r3 = r14
            r1.setPathRotate(r2, r3, r4, r6)
            goto L_0x024d
        L_0x026c:
            r1.setProperty(r11, r14)
            goto L_0x024d
        L_0x0270:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.n(android.view.View, float, long, androidx.constraintlayout.core.motion.utils.KeyCache):boolean");
    }

    public void o(View view, KeyPositionBase keyPositionBase, float f11, float f12, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f13 = motionPaths.f10994f;
        rectF.left = f13;
        float f14 = motionPaths.f10995g;
        rectF.top = f14;
        rectF.right = f13 + motionPaths.f10996h;
        rectF.bottom = f14 + motionPaths.f10997i;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f15 = motionPaths2.f10994f;
        rectF2.left = f15;
        float f16 = motionPaths2.f10995g;
        rectF2.top = f16;
        rectF2.right = f15 + motionPaths2.f10996h;
        rectF2.bottom = f16 + motionPaths2.f10997i;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f11, f12, strArr, fArr);
    }

    public void p(Rect rect, Rect rect2, int i11, int i12, int i13) {
        if (i11 == 1) {
            int i14 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i13 - ((i14 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i11 == 2) {
            int i15 = rect.left + rect.right;
            rect2.left = i12 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i15 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i11 == 3) {
            int i16 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i16 / 2);
            rect2.top = i13 - ((i16 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i11 == 4) {
            int i17 = rect.left + rect.right;
            rect2.left = i12 - (((rect.bottom + rect.top) + rect.width()) / 2);
            rect2.top = (i17 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        }
    }

    public void q(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.f10992d = 0.0f;
        motionPaths.f10993e = 0.0f;
        this.mNoMovement = true;
        motionPaths.m(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mEndMotionPath.m(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mStartPoint.setState(view);
        this.mEndPoint.setState(view);
    }

    public void r(Rect rect, ConstraintSet constraintSet, int i11, int i12) {
        int i13 = constraintSet.mRotate;
        if (i13 != 0) {
            p(rect, this.f10904a, i13, i11, i12);
            rect = this.f10904a;
        }
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.f10992d = 1.0f;
        motionPaths.f10993e = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.m((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.f10906c));
        this.mEndPoint.setState(rect, constraintSet, i13, this.f10906c);
    }

    public void remeasure() {
        this.f10907d = true;
    }

    public void s(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.f10992d = 0.0f;
        motionPaths.f10993e = 0.0f;
        motionPaths.m(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setDrawPath(int i11) {
        this.mStartMotionPath.f10991c = i11;
    }

    public void setPathMotionArc(int i11) {
        this.mPathMotionArc = i11;
    }

    public void setStartState(ViewState viewState, View view, int i11, int i12, int i13) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.f10992d = 0.0f;
        motionPaths.f10993e = 0.0f;
        Rect rect = new Rect();
        if (i11 == 1) {
            int i14 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i12 - ((i14 + viewState.height()) / 2);
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        } else if (i11 == 2) {
            int i15 = viewState.left + viewState.right;
            rect.left = i13 - (((viewState.top + viewState.bottom) + viewState.width()) / 2);
            rect.top = (i15 - viewState.height()) / 2;
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        }
        this.mStartMotionPath.m((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.mStartPoint.setState(rect, view, i11, viewState.rotation);
    }

    public void setTransformPivotTarget(int i11) {
        this.mTransformPivotTarget = i11;
        this.mTransformPivotView = null;
    }

    public void setView(View view) {
        this.f10905b = view;
        this.f10906c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f10908e = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i11, int i12, float f11, long j11) {
        ArrayList arrayList;
        String[] strArr;
        boolean z11;
        ConstraintAttribute constraintAttribute;
        int i13;
        ViewTimeCycle viewTimeCycle;
        ConstraintAttribute constraintAttribute2;
        int i14;
        Integer num;
        ViewSpline viewSpline;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashMap hashMap = new HashMap();
        int i15 = this.mPathMotionArc;
        if (i15 != Key.UNSET) {
            this.mStartMotionPath.f11000l = i15;
        }
        this.mStartPoint.a(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                Key next = it.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    insertKey(new MotionPaths(i11, i12, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i16 = keyPosition.f10887f;
                    if (i16 != Key.UNSET) {
                        this.mCurveFitType = i16;
                    }
                } else if (next instanceof KeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof KeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        int i17 = 0;
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        char c11 = 1;
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[1];
                    Iterator<Key> it3 = this.mKeyList.iterator();
                    while (it3.hasNext()) {
                        Key next2 = it3.next();
                        HashMap<String, ConstraintAttribute> hashMap2 = next2.f10875e;
                        if (!(hashMap2 == null || (constraintAttribute3 = hashMap2.get(str2)) == null)) {
                            sparseArray.append(next2.f10871a, constraintAttribute3);
                        }
                    }
                    viewSpline = ViewSpline.makeCustomSpline(str, sparseArray);
                } else {
                    viewSpline = ViewSpline.makeSpline(str);
                }
                if (viewSpline != null) {
                    viewSpline.setType(str);
                    this.mAttributesMap.put(str, viewSpline);
                }
            }
            ArrayList<Key> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                Iterator<Key> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    Key next3 = it4.next();
                    if (next3 instanceof KeyAttributes) {
                        next3.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String next4 : this.mAttributesMap.keySet()) {
                if (!hashMap.containsKey(next4) || (num = (Integer) hashMap.get(next4)) == null) {
                    i14 = 0;
                } else {
                    i14 = num.intValue();
                }
                SplineSet splineSet = this.mAttributesMap.get(next4);
                if (splineSet != null) {
                    splineSet.setup(i14);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String str3 = (String) it5.next();
                if (!this.mTimeCycleAttributesMap.containsKey(str3)) {
                    if (str3.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str4 = str3.split(",")[1];
                        Iterator<Key> it6 = this.mKeyList.iterator();
                        while (it6.hasNext()) {
                            Key next5 = it6.next();
                            HashMap<String, ConstraintAttribute> hashMap3 = next5.f10875e;
                            if (!(hashMap3 == null || (constraintAttribute2 = hashMap3.get(str4)) == null)) {
                                sparseArray2.append(next5.f10871a, constraintAttribute2);
                            }
                        }
                        viewTimeCycle = ViewTimeCycle.makeCustomSpline(str3, sparseArray2);
                        long j12 = j11;
                    } else {
                        viewTimeCycle = ViewTimeCycle.makeSpline(str3, j11);
                    }
                    if (viewTimeCycle != null) {
                        viewTimeCycle.setType(str3);
                        this.mTimeCycleAttributesMap.put(str3, viewTimeCycle);
                    }
                }
            }
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                Iterator<Key> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    Key next6 = it7.next();
                    if (next6 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) next6).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String next7 : this.mTimeCycleAttributesMap.keySet()) {
                if (hashMap.containsKey(next7)) {
                    i13 = ((Integer) hashMap.get(next7)).intValue();
                } else {
                    i13 = 0;
                }
                this.mTimeCycleAttributesMap.get(next7).setup(i13);
            }
        }
        int i18 = 2;
        int size = this.mMotionPaths.size() + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[size];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it8 = this.mMotionPaths.iterator();
        int i19 = 1;
        while (it8.hasNext()) {
            motionPathsArr[i19] = it8.next();
            i19++;
        }
        HashSet hashSet4 = new HashSet();
        for (String next8 : this.mEndMotionPath.f11004p.keySet()) {
            if (this.mStartMotionPath.f11004p.containsKey(next8)) {
                if (!hashSet2.contains("CUSTOM," + next8)) {
                    hashSet4.add(next8);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i21 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i21 >= strArr.length) {
                break;
            }
            String str5 = strArr[i21];
            this.mAttributeInterpolatorCount[i21] = 0;
            int i22 = 0;
            while (true) {
                if (i22 < size) {
                    if (motionPathsArr[i22].f11004p.containsKey(str5) && (constraintAttribute = motionPathsArr[i22].f11004p.get(str5)) != null) {
                        int[] iArr = this.mAttributeInterpolatorCount;
                        iArr[i21] = iArr[i21] + constraintAttribute.numberOfInterpolatedValues();
                        break;
                    }
                    i22++;
                } else {
                    break;
                }
            }
            i21++;
        }
        if (motionPathsArr[0].f11000l != Key.UNSET) {
            z11 = true;
        } else {
            z11 = false;
        }
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i23 = 1; i23 < size; i23++) {
            motionPathsArr[i23].a(motionPathsArr[i23 - 1], zArr, this.mAttributeNames, z11);
        }
        int i24 = 0;
        for (int i25 = 1; i25 < length; i25++) {
            if (zArr[i25]) {
                i24++;
            }
        }
        this.mInterpolateVariables = new int[i24];
        int max = Math.max(2, i24);
        this.mInterpolateData = new double[max];
        this.mInterpolateVelocity = new double[max];
        int i26 = 0;
        for (int i27 = 1; i27 < length; i27++) {
            if (zArr[i27]) {
                this.mInterpolateVariables[i26] = i27;
                i26++;
            }
        }
        int[] iArr2 = new int[2];
        iArr2[1] = this.mInterpolateVariables.length;
        iArr2[0] = size;
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, iArr2);
        double[] dArr2 = new double[size];
        for (int i28 = 0; i28 < size; i28++) {
            motionPathsArr[i28].b(dArr[i28], this.mInterpolateVariables);
            dArr2[i28] = (double) motionPathsArr[i28].f10992d;
        }
        int i29 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i29 >= iArr3.length) {
                break;
            }
            if (iArr3[i29] < MotionPaths.f10989u.length) {
                String str6 = MotionPaths.f10989u[this.mInterpolateVariables[i29]] + " [";
                for (int i31 = 0; i31 < size; i31++) {
                    str6 = str6 + dArr[i31][i29];
                }
            }
            i29++;
        }
        this.mSpline = new CurveFit[(this.mAttributeNames.length + 1)];
        int i32 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i32 >= strArr3.length) {
                break;
            }
            String str7 = strArr3[i32];
            int i33 = i17;
            int i34 = i33;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i33 < size) {
                if (motionPathsArr[i33].h(str7)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr4 = new int[i18];
                        iArr4[c11] = motionPathsArr[i33].f(str7);
                        iArr4[i17] = size;
                        dArr4 = (double[][]) Array.newInstance(Double.TYPE, iArr4);
                    }
                    MotionPaths motionPaths = motionPathsArr[i33];
                    dArr3[i34] = (double) motionPaths.f10992d;
                    motionPaths.e(str7, dArr4[i34], 0);
                    i34++;
                }
                i33++;
                i18 = 2;
                i17 = 0;
                c11 = 1;
            }
            i32++;
            this.mSpline[i32] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i34), (double[][]) Arrays.copyOf(dArr4, i34));
            i18 = 2;
            i17 = 0;
            c11 = 1;
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].f11000l != Key.UNSET) {
            int[] iArr5 = new int[size];
            double[] dArr5 = new double[size];
            int[] iArr6 = new int[2];
            iArr6[1] = 2;
            iArr6[0] = size;
            double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, iArr6);
            for (int i35 = 0; i35 < size; i35++) {
                MotionPaths motionPaths2 = motionPathsArr[i35];
                iArr5[i35] = motionPaths2.f11000l;
                dArr5[i35] = (double) motionPaths2.f10992d;
                double[] dArr7 = dArr6[i35];
                dArr7[0] = (double) motionPaths2.f10994f;
                dArr7[1] = (double) motionPaths2.f10995g;
            }
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator it9 = hashSet3.iterator();
            float f12 = Float.NaN;
            while (it9.hasNext()) {
                String str8 = (String) it9.next();
                ViewOscillator makeSpline = ViewOscillator.makeSpline(str8);
                if (makeSpline != null) {
                    if (makeSpline.variesByPath() && Float.isNaN(f12)) {
                        f12 = getPreCycleDistance();
                    }
                    makeSpline.setType(str8);
                    this.mCycleMap.put(str8, makeSpline);
                }
            }
            Iterator<Key> it10 = this.mKeyList.iterator();
            while (it10.hasNext()) {
                Key next9 = it10.next();
                if (next9 instanceof KeyCycle) {
                    ((KeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            for (ViewOscillator upVar : this.mCycleMap.values()) {
                upVar.setup(f12);
            }
        }
    }

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public void t(Rect rect, ConstraintSet constraintSet, int i11, int i12) {
        int i13 = constraintSet.mRotate;
        if (i13 != 0) {
            p(rect, this.f10904a, i13, i11, i12);
        }
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.f10992d = 0.0f;
        motionPaths.f10993e = 0.0f;
        readView(motionPaths);
        this.mStartMotionPath.m((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.f10906c);
        this.mStartMotionPath.applyParameters(parameters);
        this.f10909f = parameters.motion.mMotionStagger;
        this.mStartPoint.setState(rect, constraintSet, i13, this.f10906c);
        this.mTransformPivotTarget = parameters.transform.transformPivotTarget;
        ConstraintSet.Motion motion = parameters.motion;
        this.mQuantizeMotionSteps = motion.mQuantizeMotionSteps;
        this.mQuantizeMotionPhase = motion.mQuantizeMotionPhase;
        Context context = this.f10905b.getContext();
        ConstraintSet.Motion motion2 = parameters.motion;
        this.mQuantizeMotionInterpolator = getInterpolator(context, motion2.mQuantizeInterpolatorType, motion2.mQuantizeInterpolatorString, motion2.mQuantizeInterpolatorID);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f10994f + " y: " + this.mStartMotionPath.f10995g + " end: x: " + this.mEndMotionPath.f10994f + " y: " + this.mEndMotionPath.f10995g;
    }
}
