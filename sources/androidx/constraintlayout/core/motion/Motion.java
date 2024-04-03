package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.ViewState;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Motion implements TypedValues {
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
    public Rect f10475a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public MotionWidget f10476b;

    /* renamed from: c  reason: collision with root package name */
    public float f10477c = Float.NaN;

    /* renamed from: d  reason: collision with root package name */
    public float f10478d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f10479e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f10480f;

    /* renamed from: g  reason: collision with root package name */
    public float f10481g;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    private int mCurveFitType = -1;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<MotionKey> mKeyList = new ArrayList<>();
    private MotionKeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private boolean mNoMovement = false;
    private int mPathMotionArc = -1;
    private DifferentialInterpolator mQuantizeMotionInterpolator = null;
    private float mQuantizeMotionPhase = Float.NaN;
    private int mQuantizeMotionSteps = -1;
    private CurveFit[] mSpline;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private int mTransformPivotTarget = -1;
    private MotionWidget mTransformPivotView = null;
    private float[] mValuesBuff = new float[4];
    private float[] mVelocity = new float[1];

    public Motion(MotionWidget motionWidget) {
        setView(motionWidget);
    }

    private float getAdjustedPosition(float f11, float[] fArr) {
        float f12 = 0.0f;
        float f13 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f14 = this.f10479e;
            if (((double) f14) != 1.0d) {
                float f15 = this.f10478d;
                if (f11 < f15) {
                    f11 = 0.0f;
                }
                if (f11 > f15 && ((double) f11) < 1.0d) {
                    f11 = Math.min((f11 - f15) * f14, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.f10494b;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        float f16 = Float.NaN;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            Easing easing2 = next.f10494b;
            if (easing2 != null) {
                float f17 = next.f10496d;
                if (f17 < f11) {
                    easing = easing2;
                    f12 = f17;
                } else if (Float.isNaN(f16)) {
                    f16 = next.f10496d;
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

    private static DifferentialInterpolator getInterpolator(int i11, String str, int i12) {
        if (i11 != -1) {
            return null;
        }
        final Easing interpolator = Easing.getInterpolator(str);
        return new DifferentialInterpolator() {

            /* renamed from: a  reason: collision with root package name */
            public float f10482a;

            public float getInterpolation(float f11) {
                this.f10482a = f11;
                return (float) interpolator.get((double) f11);
            }

            public float getVelocity() {
                return (float) interpolator.getDiff((double) this.f10482a);
            }
        };
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
            Easing easing = this.mStartMotionPath.f10494b;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f15 = Float.NaN;
            float f16 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.f10494b;
                if (easing2 != null) {
                    float f17 = next.f10496d;
                    if (f17 < f14) {
                        easing = easing2;
                        f16 = f17;
                    } else if (Float.isNaN(f15)) {
                        f15 = next.f10496d;
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
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        MotionPaths motionPaths2 = null;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            if (motionPaths.f10497e == next.f10497e) {
                motionPaths2 = next;
            }
        }
        if (motionPaths2 != null) {
            this.mMotionPaths.remove(motionPaths2);
        }
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            Utils.loge(TAG, " KeyPath position \"" + motionPaths.f10497e + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.m((float) this.f10476b.getX(), (float) this.f10476b.getY(), (float) this.f10476b.getWidth(), (float) this.f10476b.getHeight());
    }

    public double[] a(double d11) {
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

    public void addKey(MotionKey motionKey) {
        this.mKeyList.add(motionKey);
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                iArr[i11] = it.next().f10509q;
                i11++;
            }
        }
        if (iArr2 != null) {
            Iterator<MotionPaths> it2 = this.mMotionPaths.iterator();
            int i12 = 0;
            while (it2.hasNext()) {
                iArr2[i12] = (int) (it2.next().f10497e * 100.0f);
                i12++;
            }
        }
        int i13 = 0;
        for (int i14 = 0; i14 < timePoints.length; i14++) {
            this.mSpline[0].getPos(timePoints[i14], this.mInterpolateData);
            this.mStartMotionPath.c(timePoints[i14], this.mInterpolateVariables, this.mInterpolateData, fArr, i13);
            i13 += 2;
        }
        return i13 / 2;
    }

    public void buildPath(float[] fArr, int i11) {
        SplineSet splineSet;
        SplineSet splineSet2;
        KeyCycleOscillator keyCycleOscillator;
        double d11;
        int i12 = i11;
        float f11 = 1.0f;
        float f12 = 1.0f / ((float) (i12 - 1));
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator2 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 == null) {
            keyCycleOscillator = null;
        } else {
            keyCycleOscillator = hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            keyCycleOscillator2 = hashMap4.get("translationY");
        }
        KeyCycleOscillator keyCycleOscillator3 = keyCycleOscillator2;
        int i13 = 0;
        while (i13 < i12) {
            float f13 = ((float) i13) * f12;
            float f14 = this.f10479e;
            float f15 = 0.0f;
            if (f14 != f11) {
                float f16 = this.f10478d;
                if (f13 < f16) {
                    f13 = 0.0f;
                }
                if (f13 > f16 && ((double) f13) < 1.0d) {
                    f13 = Math.min((f13 - f16) * f14, f11);
                }
            }
            float f17 = f13;
            double d12 = (double) f17;
            Easing easing = this.mStartMotionPath.f10494b;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f18 = Float.NaN;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.f10494b;
                double d13 = d12;
                if (easing2 != null) {
                    float f19 = next.f10496d;
                    if (f19 < f17) {
                        f15 = f19;
                        easing = easing2;
                    } else if (Float.isNaN(f18)) {
                        f18 = next.f10496d;
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
            if (keyCycleOscillator != null) {
                fArr[i14] = fArr[i14] + keyCycleOscillator.get(f22);
            } else if (splineSet != null) {
                fArr[i14] = fArr[i14] + splineSet.get(f22);
            }
            if (keyCycleOscillator3 != null) {
                int i16 = i14 + 1;
                fArr[i16] = fArr[i16] + keyCycleOscillator3.get(f22);
            } else if (splineSet2 != null) {
                int i17 = i14 + 1;
                fArr[i17] = fArr[i17] + splineSet2.get(f22);
            }
            i13 = i15 + 1;
            f11 = 1.0f;
        }
    }

    public void buildRect(float f11, float[] fArr, int i11) {
        this.mSpline[0].getPos((double) getAdjustedPosition(f11, (float[]) null), this.mInterpolateData);
        this.mStartMotionPath.g(this.mInterpolateVariables, this.mInterpolateData, fArr, i11);
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.f10505m;
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
        return this.f10480f;
    }

    public float getCenterY() {
        return this.f10481g;
    }

    public int getDrawPath() {
        int i11 = this.mStartMotionPath.f10495c;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i11 = Math.max(i11, it.next().f10495c);
        }
        return Math.max(i11, this.mEndMotionPath.f10495c);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.f10501i;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.f10500h;
    }

    public float getFinalX() {
        return this.mEndMotionPath.f10498f;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f10499g;
    }

    public int getId(String str) {
        return 0;
    }

    public MotionPaths getKeyFrame(int i11) {
        return this.mMotionPaths.get(i11);
    }

    public int getKeyFrameInfo(int i11, int[] iArr) {
        int i12 = i11;
        float[] fArr = new float[2];
        Iterator<MotionKey> it = this.mKeyList.iterator();
        int i13 = 0;
        int i14 = 0;
        while (it.hasNext()) {
            MotionKey next = it.next();
            int i15 = next.mType;
            if (i15 == i12 || i12 != -1) {
                iArr[i14] = 0;
                int i16 = i14 + 1;
                iArr[i16] = i15;
                int i17 = i16 + 1;
                int i18 = next.mFramePosition;
                iArr[i17] = i18;
                double d11 = (double) (((float) i18) / 100.0f);
                this.mSpline[0].getPos(d11, this.mInterpolateData);
                this.mStartMotionPath.c(d11, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                int i19 = i17 + 1;
                iArr[i19] = Float.floatToIntBits(fArr[0]);
                int i21 = i19 + 1;
                iArr[i21] = Float.floatToIntBits(fArr[1]);
                if (next instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                    int i22 = i21 + 1;
                    iArr[i22] = motionKeyPosition.mPositionType;
                    int i23 = i22 + 1;
                    iArr[i23] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i21 = i23 + 1;
                    iArr[i21] = Float.floatToIntBits(motionKeyPosition.mPercentY);
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
        Iterator<MotionKey> it = this.mKeyList.iterator();
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            MotionKey next = it.next();
            int i13 = next.mFramePosition;
            iArr[i11] = (next.mType * 1000) + i13;
            double d11 = (double) (((float) i13) / 100.0f);
            this.mSpline[0].getPos(d11, this.mInterpolateData);
            this.mStartMotionPath.c(d11, this.mInterpolateVariables, this.mInterpolateData, fArr, i12);
            i12 += 2;
            i11++;
        }
        return i11;
    }

    public float getStartHeight() {
        return this.mStartMotionPath.f10501i;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.f10500h;
    }

    public float getStartX() {
        return this.mStartMotionPath.f10498f;
    }

    public float getStartY() {
        return this.mStartMotionPath.f10499g;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public MotionWidget getView() {
        return this.f10476b;
    }

    public boolean interpolate(MotionWidget motionWidget, float f11, long j11, KeyCache keyCache) {
        double d11;
        float f12;
        MotionWidget motionWidget2 = motionWidget;
        float adjustedPosition = getAdjustedPosition(f11, (float[]) null);
        int i11 = this.mQuantizeMotionSteps;
        if (i11 != -1) {
            float f13 = 1.0f / ((float) i11);
            float floor = ((float) Math.floor((double) (adjustedPosition / f13))) * f13;
            float f14 = (adjustedPosition % f13) / f13;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f14 = (f14 + this.mQuantizeMotionPhase) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.mQuantizeMotionInterpolator;
            if (differentialInterpolator != null) {
                f12 = differentialInterpolator.getInterpolation(f14);
            } else if (((double) f14) > 0.5d) {
                f12 = 1.0f;
            } else {
                f12 = 0.0f;
            }
            adjustedPosition = (f12 * f13) + floor;
        }
        float f15 = adjustedPosition;
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            for (SplineSet property : hashMap.values()) {
                property.setProperty(motionWidget2, f15);
            }
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d12 = (double) f15;
            curveFitArr[0].getPos(d12, this.mInterpolateData);
            this.mSpline[0].getSlope(d12, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d12, dArr);
                    this.mArcSpline.getSlope(d12, this.mInterpolateVelocity);
                }
            }
            if (!this.mNoMovement) {
                d11 = d12;
                this.mStartMotionPath.n(f15, motionWidget, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, (double[]) null);
            } else {
                d11 = d12;
            }
            if (this.mTransformPivotTarget != -1) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = motionWidget.getParent().findViewById(this.mTransformPivotTarget);
                }
                MotionWidget motionWidget3 = this.mTransformPivotView;
                if (motionWidget3 != null) {
                    float top = ((float) (motionWidget3.getTop() + this.mTransformPivotView.getBottom())) / 2.0f;
                    float left = ((float) (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight())) / 2.0f;
                    if (motionWidget.getRight() - motionWidget.getLeft() > 0 && motionWidget.getBottom() - motionWidget.getTop() > 0) {
                        motionWidget2.setPivotX(left - ((float) motionWidget.getLeft()));
                        motionWidget2.setPivotY(top - ((float) motionWidget.getTop()));
                    }
                }
            }
            int i12 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i12 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i12].getPos(d11, this.mValuesBuff);
                this.mStartMotionPath.f10508p.get(this.mAttributeNames[i12 - 1]).setInterpolatedValue(motionWidget2, this.mValuesBuff);
                i12++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.f10485b == 0) {
                if (f15 <= 0.0f) {
                    motionWidget2.setVisibility(motionConstrainedPoint.f10486c);
                } else if (f15 >= 1.0f) {
                    motionWidget2.setVisibility(this.mEndPoint.f10486c);
                } else if (this.mEndPoint.f10486c != motionConstrainedPoint.f10486c) {
                    motionWidget2.setVisibility(4);
                }
            }
            if (this.mKeyTriggers != null) {
                int i13 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = this.mKeyTriggers;
                    if (i13 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i13].conditionallyFire(f15, motionWidget2);
                    i13++;
                }
            }
        } else {
            MotionPaths motionPaths = this.mStartMotionPath;
            float f16 = motionPaths.f10498f;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f17 = f16 + ((motionPaths2.f10498f - f16) * f15);
            float f18 = motionPaths.f10499g;
            float f19 = f18 + ((motionPaths2.f10499g - f18) * f15);
            float f21 = motionPaths.f10500h;
            float f22 = f21 + ((motionPaths2.f10500h - f21) * f15);
            float f23 = motionPaths.f10501i;
            float f24 = f17 + 0.5f;
            float f25 = f19 + 0.5f;
            motionWidget2.layout((int) f24, (int) f25, (int) (f24 + f22), (int) (f25 + f23 + ((motionPaths2.f10501i - f23) * f15)));
        }
        HashMap<String, KeyCycleOscillator> hashMap2 = this.mCycleMap;
        if (hashMap2 == null) {
            return false;
        }
        for (KeyCycleOscillator next : hashMap2.values()) {
            if (next instanceof KeyCycleOscillator.PathRotateSet) {
                double[] dArr2 = this.mInterpolateVelocity;
                ((KeyCycleOscillator.PathRotateSet) next).setPathRotate(motionWidget, f15, dArr2[0], dArr2[1]);
            } else {
                next.setProperty(motionWidget2, f15);
            }
        }
        return false;
    }

    public void setDrawPath(int i11) {
        this.mStartMotionPath.f10495c = i11;
    }

    public void setEnd(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.f10496d = 1.0f;
        motionPaths.f10497e = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.m((float) motionWidget.getLeft(), (float) motionWidget.getTop(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        this.mEndMotionPath.applyParameters(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setPathMotionArc(int i11) {
        this.mPathMotionArc = i11;
    }

    public void setStart(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.f10496d = 0.0f;
        motionPaths.f10497e = 0.0f;
        motionPaths.m((float) motionWidget.getX(), (float) motionWidget.getY(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        this.mStartMotionPath.applyParameters(motionWidget);
        this.mStartPoint.setState(motionWidget);
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i11, int i12, int i13) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.f10496d = 0.0f;
        motionPaths.f10497e = 0.0f;
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
        this.mStartPoint.setState(rect, motionWidget, i11, viewState.rotation);
    }

    public void setTransformPivotTarget(int i11) {
        this.mTransformPivotTarget = i11;
        this.mTransformPivotView = null;
    }

    public boolean setValue(int i11, float f11) {
        return false;
    }

    public boolean setValue(int i11, int i12) {
        if (i11 != 509) {
            return i11 == 704;
        }
        setPathMotionArc(i12);
        return true;
    }

    public boolean setValue(int i11, boolean z11) {
        return false;
    }

    public void setView(MotionWidget motionWidget) {
        this.f10476b = motionWidget;
    }

    public void setup(int i11, int i12, float f11, long j11) {
        ArrayList arrayList;
        String[] strArr;
        boolean z11;
        MotionPaths[] motionPathsArr;
        int i13;
        CustomVariable customVariable;
        int i14;
        SplineSet splineSet;
        CustomVariable customVariable2;
        int i15;
        Integer num;
        SplineSet splineSet2;
        CustomVariable customVariable3;
        long j12 = j11;
        new HashSet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashMap hashMap = new HashMap();
        int i16 = this.mPathMotionArc;
        if (i16 != -1) {
            this.mStartMotionPath.f10504l = i16;
        }
        this.mStartPoint.a(this.mEndPoint, hashSet2);
        ArrayList<MotionKey> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            Iterator<MotionKey> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                MotionKey next = it.next();
                if (next instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                    insertKey(new MotionPaths(i11, i12, motionKeyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i17 = motionKeyPosition.mCurveFit;
                    if (i17 != -1) {
                        this.mCurveFitType = i17;
                    }
                } else if (next instanceof MotionKeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof MotionKeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof MotionKeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((MotionKeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        char c11 = 1;
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (str.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar = new KeyFrameArray.CustomVar();
                    String str2 = str.split(",")[c11];
                    Iterator<MotionKey> it3 = this.mKeyList.iterator();
                    while (it3.hasNext()) {
                        MotionKey next2 = it3.next();
                        HashMap<String, CustomVariable> hashMap2 = next2.mCustom;
                        if (!(hashMap2 == null || (customVariable3 = hashMap2.get(str2)) == null)) {
                            customVar.append(next2.mFramePosition, customVariable3);
                        }
                    }
                    splineSet2 = SplineSet.makeCustomSplineSet(str, customVar);
                } else {
                    splineSet2 = SplineSet.makeSpline(str, j12);
                }
                if (splineSet2 != null) {
                    splineSet2.setType(str);
                    this.mAttributesMap.put(str, splineSet2);
                }
                c11 = 1;
            }
            ArrayList<MotionKey> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                Iterator<MotionKey> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    MotionKey next3 = it4.next();
                    if (next3 instanceof MotionKeyAttributes) {
                        next3.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String next4 : this.mAttributesMap.keySet()) {
                if (!hashMap.containsKey(next4) || (num = (Integer) hashMap.get(next4)) == null) {
                    i15 = 0;
                } else {
                    i15 = num.intValue();
                }
                SplineSet splineSet3 = this.mAttributesMap.get(next4);
                if (splineSet3 != null) {
                    splineSet3.setup(i15);
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
                        KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                        String str4 = str3.split(",")[1];
                        Iterator<MotionKey> it6 = this.mKeyList.iterator();
                        while (it6.hasNext()) {
                            MotionKey next5 = it6.next();
                            HashMap<String, CustomVariable> hashMap3 = next5.mCustom;
                            if (!(hashMap3 == null || (customVariable2 = hashMap3.get(str4)) == null)) {
                                customVar2.append(next5.mFramePosition, customVariable2);
                            }
                        }
                        splineSet = SplineSet.makeCustomSplineSet(str3, customVar2);
                    } else {
                        splineSet = SplineSet.makeSpline(str3, j12);
                    }
                    if (splineSet != null) {
                        splineSet.setType(str3);
                    }
                }
            }
            ArrayList<MotionKey> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                Iterator<MotionKey> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    MotionKey next6 = it7.next();
                    if (next6 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) next6).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String next7 : this.mTimeCycleAttributesMap.keySet()) {
                if (hashMap.containsKey(next7)) {
                    i14 = ((Integer) hashMap.get(next7)).intValue();
                } else {
                    i14 = 0;
                }
                this.mTimeCycleAttributesMap.get(next7).setup(i14);
            }
        }
        int i18 = 2;
        int size = this.mMotionPaths.size() + 2;
        MotionPaths[] motionPathsArr2 = new MotionPaths[size];
        motionPathsArr2[0] = this.mStartMotionPath;
        motionPathsArr2[size - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == MotionKey.UNSET) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it8 = this.mMotionPaths.iterator();
        int i19 = 1;
        while (it8.hasNext()) {
            motionPathsArr2[i19] = it8.next();
            i19++;
        }
        HashSet hashSet4 = new HashSet();
        for (String next8 : this.mEndMotionPath.f10508p.keySet()) {
            if (this.mStartMotionPath.f10508p.containsKey(next8)) {
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
                    if (motionPathsArr2[i22].f10508p.containsKey(str5) && (customVariable = motionPathsArr2[i22].f10508p.get(str5)) != null) {
                        int[] iArr = this.mAttributeInterpolatorCount;
                        iArr[i21] = iArr[i21] + customVariable.numberOfInterpolatedValues();
                        break;
                    }
                    i22++;
                } else {
                    break;
                }
            }
            i21++;
        }
        if (motionPathsArr2[0].f10504l != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i23 = 1; i23 < size; i23++) {
            motionPathsArr2[i23].a(motionPathsArr2[i23 - 1], zArr, this.mAttributeNames, z11);
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
            motionPathsArr2[i28].b(dArr[i28], this.mInterpolateVariables);
            dArr2[i28] = (double) motionPathsArr2[i28].f10496d;
        }
        int i29 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i29 >= iArr3.length) {
                break;
            }
            if (iArr3[i29] < MotionPaths.f10493u.length) {
                String str6 = MotionPaths.f10493u[this.mInterpolateVariables[i29]] + " [";
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
            int i33 = 0;
            int i34 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i33 < size) {
                if (motionPathsArr2[i33].h(str7)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr4 = new int[i18];
                        iArr4[1] = motionPathsArr2[i33].f(str7);
                        i13 = 0;
                        iArr4[0] = size;
                        dArr4 = (double[][]) Array.newInstance(Double.TYPE, iArr4);
                    } else {
                        i13 = 0;
                    }
                    MotionPaths motionPaths = motionPathsArr2[i33];
                    motionPathsArr = motionPathsArr2;
                    dArr3[i34] = (double) motionPaths.f10496d;
                    motionPaths.e(str7, dArr4[i34], i13);
                    i34++;
                } else {
                    motionPathsArr = motionPathsArr2;
                }
                i33++;
                motionPathsArr2 = motionPathsArr;
                i18 = 2;
            }
            i32++;
            this.mSpline[i32] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i34), (double[][]) Arrays.copyOf(dArr4, i34));
            motionPathsArr2 = motionPathsArr2;
            i18 = 2;
        }
        MotionPaths[] motionPathsArr3 = motionPathsArr2;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr3[0].f10504l != -1) {
            int[] iArr5 = new int[size];
            double[] dArr5 = new double[size];
            int[] iArr6 = new int[2];
            iArr6[1] = 2;
            iArr6[0] = size;
            double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, iArr6);
            for (int i35 = 0; i35 < size; i35++) {
                MotionPaths motionPaths2 = motionPathsArr3[i35];
                iArr5[i35] = motionPaths2.f10504l;
                dArr5[i35] = (double) motionPaths2.f10496d;
                double[] dArr7 = dArr6[i35];
                dArr7[0] = (double) motionPaths2.f10498f;
                dArr7[1] = (double) motionPaths2.f10499g;
            }
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator it9 = hashSet3.iterator();
            float f12 = Float.NaN;
            while (it9.hasNext()) {
                String str8 = (String) it9.next();
                KeyCycleOscillator makeWidgetCycle = KeyCycleOscillator.makeWidgetCycle(str8);
                if (makeWidgetCycle != null) {
                    if (makeWidgetCycle.variesByPath() && Float.isNaN(f12)) {
                        f12 = getPreCycleDistance();
                    }
                    makeWidgetCycle.setType(str8);
                    this.mCycleMap.put(str8, makeWidgetCycle);
                }
            }
            Iterator<MotionKey> it10 = this.mKeyList.iterator();
            while (it10.hasNext()) {
                MotionKey next9 = it10.next();
                if (next9 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            for (KeyCycleOscillator upVar : this.mCycleMap.values()) {
                upVar.setup(f12);
            }
        }
    }

    public void setupRelative(Motion motion) {
        this.mStartMotionPath.setupRelative(motion, motion.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motion, motion.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f10498f + " y: " + this.mStartMotionPath.f10499g + " end: x: " + this.mEndMotionPath.f10498f + " y: " + this.mEndMotionPath.f10499g;
    }

    public boolean setValue(int i11, String str) {
        if (705 == i11) {
            PrintStream printStream = System.out;
            printStream.println("TYPE_INTERPOLATOR  " + str);
            this.mQuantizeMotionInterpolator = getInterpolator(-1, str, 0);
        }
        return false;
    }
}
