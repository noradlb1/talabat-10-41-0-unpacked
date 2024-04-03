package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    public static final boolean DEBUG = false;
    public static final String TAG = "MotionPaths";

    /* renamed from: h  reason: collision with root package name */
    public static String[] f10484h = {"position", Param.X, Param.Y, "width", "height", "pathRotate"};
    private float alpha = 1.0f;
    private boolean applyElevation = false;

    /* renamed from: b  reason: collision with root package name */
    public int f10485b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f10486c;

    /* renamed from: d  reason: collision with root package name */
    public LinkedHashMap<String, CustomVariable> f10487d = new LinkedHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public int f10488e = 0;
    private float elevation = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public double[] f10489f = new double[18];

    /* renamed from: g  reason: collision with root package name */
    public double[] f10490g = new double[18];
    private float height;
    private int mAnimateRelativeTo = -1;
    private int mDrawPath = 0;
    private Easing mKeyFrameEasing;
    private float mPathRotate = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mProgress = Float.NaN;
    private float position;
    private float rotation = 0.0f;
    private float rotationX = 0.0f;
    public float rotationY = 0.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float translationX = 0.0f;
    private float translationY = 0.0f;
    private float translationZ = 0.0f;
    private float width;

    /* renamed from: x  reason: collision with root package name */
    private float f10491x;

    /* renamed from: y  reason: collision with root package name */
    private float f10492y;

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

    public void a(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (diff(this.alpha, motionConstrainedPoint.alpha)) {
            hashSet.add("alpha");
        }
        if (diff(this.elevation, motionConstrainedPoint.elevation)) {
            hashSet.add("translationZ");
        }
        int i11 = this.f10486c;
        int i12 = motionConstrainedPoint.f10486c;
        if (i11 != i12 && this.f10485b == 0 && (i11 == 4 || i12 == 4)) {
            hashSet.add("alpha");
        }
        if (diff(this.rotation, motionConstrainedPoint.rotation)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
            hashSet.add("progress");
        }
        if (diff(this.rotationX, motionConstrainedPoint.rotationX)) {
            hashSet.add("rotationX");
        }
        if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add("rotationY");
        }
        if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
            hashSet.add("pivotX");
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add("pivotY");
        }
        if (diff(this.scaleX, motionConstrainedPoint.scaleX)) {
            hashSet.add("scaleX");
        }
        if (diff(this.scaleY, motionConstrainedPoint.scaleY)) {
            hashSet.add("scaleY");
        }
        if (diff(this.translationX, motionConstrainedPoint.translationX)) {
            hashSet.add("translationX");
        }
        if (diff(this.translationY, motionConstrainedPoint.translationY)) {
            hashSet.add("translationY");
        }
        if (diff(this.translationZ, motionConstrainedPoint.translationZ)) {
            hashSet.add("translationZ");
        }
        if (diff(this.elevation, motionConstrainedPoint.elevation)) {
            hashSet.add("elevation");
        }
    }

    public void addValues(HashMap<String, SplineSet> hashMap, int i11) {
        for (String next : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(next);
            next.hashCode();
            char c11 = 65535;
            switch (next.hashCode()) {
                case -1249320806:
                    if (next.equals("rotationX")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (next.equals("rotationY")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1249320804:
                    if (next.equals("rotationZ")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1225497657:
                    if (next.equals("translationX")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1225497656:
                    if (next.equals("translationY")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -1225497655:
                    if (next.equals("translationZ")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case -1001078227:
                    if (next.equals("progress")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -987906986:
                    if (next.equals("pivotX")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case -987906985:
                    if (next.equals("pivotY")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case -908189618:
                    if (next.equals("scaleX")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case -908189617:
                    if (next.equals("scaleY")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case 92909918:
                    if (next.equals("alpha")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 803192288:
                    if (next.equals("pathRotate")) {
                        c11 = 12;
                        break;
                    }
                    break;
            }
            float f11 = 1.0f;
            float f12 = 0.0f;
            switch (c11) {
                case 0:
                    if (!Float.isNaN(this.rotationX)) {
                        f12 = this.rotationX;
                    }
                    splineSet.setPoint(i11, f12);
                    break;
                case 1:
                    if (!Float.isNaN(this.rotationY)) {
                        f12 = this.rotationY;
                    }
                    splineSet.setPoint(i11, f12);
                    break;
                case 2:
                    if (!Float.isNaN(this.rotation)) {
                        f12 = this.rotation;
                    }
                    splineSet.setPoint(i11, f12);
                    break;
                case 3:
                    if (!Float.isNaN(this.translationX)) {
                        f12 = this.translationX;
                    }
                    splineSet.setPoint(i11, f12);
                    break;
                case 4:
                    if (!Float.isNaN(this.translationY)) {
                        f12 = this.translationY;
                    }
                    splineSet.setPoint(i11, f12);
                    break;
                case 5:
                    if (!Float.isNaN(this.translationZ)) {
                        f12 = this.translationZ;
                    }
                    splineSet.setPoint(i11, f12);
                    break;
                case 6:
                    if (!Float.isNaN(this.mProgress)) {
                        f12 = this.mProgress;
                    }
                    splineSet.setPoint(i11, f12);
                    break;
                case 7:
                    if (!Float.isNaN(this.mPivotX)) {
                        f12 = this.mPivotX;
                    }
                    splineSet.setPoint(i11, f12);
                    break;
                case 8:
                    if (!Float.isNaN(this.mPivotY)) {
                        f12 = this.mPivotY;
                    }
                    splineSet.setPoint(i11, f12);
                    break;
                case 9:
                    if (!Float.isNaN(this.scaleX)) {
                        f11 = this.scaleX;
                    }
                    splineSet.setPoint(i11, f11);
                    break;
                case 10:
                    if (!Float.isNaN(this.scaleY)) {
                        f11 = this.scaleY;
                    }
                    splineSet.setPoint(i11, f11);
                    break;
                case 11:
                    if (!Float.isNaN(this.alpha)) {
                        f11 = this.alpha;
                    }
                    splineSet.setPoint(i11, f11);
                    break;
                case 12:
                    if (!Float.isNaN(this.mPathRotate)) {
                        f12 = this.mPathRotate;
                    }
                    splineSet.setPoint(i11, f12);
                    break;
                default:
                    if (!next.startsWith("CUSTOM")) {
                        Utils.loge("MotionPaths", "UNKNOWN spline " + next);
                        break;
                    } else {
                        String str = next.split(",")[1];
                        if (!this.f10487d.containsKey(str)) {
                            break;
                        } else {
                            CustomVariable customVariable = this.f10487d.get(str);
                            if (!(splineSet instanceof SplineSet.CustomSpline)) {
                                Utils.loge("MotionPaths", next + " ViewSpline not a CustomSet frame = " + i11 + ", value" + customVariable.getValueToInterpolate() + splineSet);
                                break;
                            } else {
                                ((SplineSet.CustomSpline) splineSet).setPoint(i11, customVariable);
                                break;
                            }
                        }
                    }
            }
        }
    }

    public void applyParameters(MotionWidget motionWidget) {
        float f11;
        this.f10486c = motionWidget.getVisibility();
        if (motionWidget.getVisibility() != 4) {
            f11 = 0.0f;
        } else {
            f11 = motionWidget.getAlpha();
        }
        this.alpha = f11;
        this.applyElevation = false;
        this.rotation = motionWidget.getRotationZ();
        this.rotationX = motionWidget.getRotationX();
        this.rotationY = motionWidget.getRotationY();
        this.scaleX = motionWidget.getScaleX();
        this.scaleY = motionWidget.getScaleY();
        this.mPivotX = motionWidget.getPivotX();
        this.mPivotY = motionWidget.getPivotY();
        this.translationX = motionWidget.getTranslationX();
        this.translationY = motionWidget.getTranslationY();
        this.translationZ = motionWidget.getTranslationZ();
        for (String next : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(next);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.f10487d.put(next, customAttribute);
            }
        }
    }

    public void b(float f11, float f12, float f13, float f14) {
        this.f10491x = f11;
        this.f10492y = f12;
        this.width = f13;
        this.height = f14;
    }

    public void setState(MotionWidget motionWidget) {
        b((float) motionWidget.getX(), (float) motionWidget.getY(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        applyParameters(motionWidget);
    }

    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.position, motionConstrainedPoint.position);
    }

    public void setState(Rect rect, MotionWidget motionWidget, int i11, float f11) {
        b((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        applyParameters(motionWidget);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (i11 == 1) {
            this.rotation = f11 - 90.0f;
        } else if (i11 == 2) {
            this.rotation = f11 + 90.0f;
        }
    }
}
