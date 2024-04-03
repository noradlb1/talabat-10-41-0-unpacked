package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import org.apache.commons.lang3.CharUtils;

class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    public static final boolean DEBUG = false;
    public static final String TAG = "MotionPaths";

    /* renamed from: h  reason: collision with root package name */
    public static String[] f10895h = {"position", Param.X, Param.Y, "width", "height", "pathRotate"};
    private float alpha = 1.0f;
    private boolean applyElevation = false;

    /* renamed from: b  reason: collision with root package name */
    public int f10896b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f10897c;

    /* renamed from: d  reason: collision with root package name */
    public LinkedHashMap<String, ConstraintAttribute> f10898d = new LinkedHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public int f10899e = 0;
    private float elevation = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public double[] f10900f = new double[18];

    /* renamed from: g  reason: collision with root package name */
    public double[] f10901g = new double[18];
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
    private float f10902x;

    /* renamed from: y  reason: collision with root package name */
    private float f10903y;

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
            hashSet.add("elevation");
        }
        int i11 = this.f10897c;
        int i12 = motionConstrainedPoint.f10897c;
        if (i11 != i12 && this.f10896b == 0 && (i11 == 0 || i12 == 0)) {
            hashSet.add("alpha");
        }
        if (diff(this.rotation, motionConstrainedPoint.rotation)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add("transitionPathRotate");
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
            hashSet.add(Key.PIVOT_X);
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add(Key.PIVOT_Y);
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
    }

    public void addValues(HashMap<String, ViewSpline> hashMap, int i11) {
        for (String next : hashMap.keySet()) {
            ViewSpline viewSpline = hashMap.get(next);
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
                case -1225497657:
                    if (next.equals("translationX")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (next.equals("translationY")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (next.equals("translationZ")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (next.equals("progress")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (next.equals("scaleX")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (next.equals("scaleY")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case -760884510:
                    if (next.equals(Key.PIVOT_X)) {
                        c11 = 8;
                        break;
                    }
                    break;
                case -760884509:
                    if (next.equals(Key.PIVOT_Y)) {
                        c11 = 9;
                        break;
                    }
                    break;
                case -40300674:
                    if (next.equals("rotation")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case -4379043:
                    if (next.equals("elevation")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (next.equals("transitionPathRotate")) {
                        c11 = 12;
                        break;
                    }
                    break;
                case 92909918:
                    if (next.equals("alpha")) {
                        c11 = CharUtils.CR;
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
                    viewSpline.setPoint(i11, f12);
                    break;
                case 1:
                    if (!Float.isNaN(this.rotationY)) {
                        f12 = this.rotationY;
                    }
                    viewSpline.setPoint(i11, f12);
                    break;
                case 2:
                    if (!Float.isNaN(this.translationX)) {
                        f12 = this.translationX;
                    }
                    viewSpline.setPoint(i11, f12);
                    break;
                case 3:
                    if (!Float.isNaN(this.translationY)) {
                        f12 = this.translationY;
                    }
                    viewSpline.setPoint(i11, f12);
                    break;
                case 4:
                    if (!Float.isNaN(this.translationZ)) {
                        f12 = this.translationZ;
                    }
                    viewSpline.setPoint(i11, f12);
                    break;
                case 5:
                    if (!Float.isNaN(this.mProgress)) {
                        f12 = this.mProgress;
                    }
                    viewSpline.setPoint(i11, f12);
                    break;
                case 6:
                    if (!Float.isNaN(this.scaleX)) {
                        f11 = this.scaleX;
                    }
                    viewSpline.setPoint(i11, f11);
                    break;
                case 7:
                    if (!Float.isNaN(this.scaleY)) {
                        f11 = this.scaleY;
                    }
                    viewSpline.setPoint(i11, f11);
                    break;
                case 8:
                    if (!Float.isNaN(this.mPivotX)) {
                        f12 = this.mPivotX;
                    }
                    viewSpline.setPoint(i11, f12);
                    break;
                case 9:
                    if (!Float.isNaN(this.mPivotY)) {
                        f12 = this.mPivotY;
                    }
                    viewSpline.setPoint(i11, f12);
                    break;
                case 10:
                    if (!Float.isNaN(this.rotation)) {
                        f12 = this.rotation;
                    }
                    viewSpline.setPoint(i11, f12);
                    break;
                case 11:
                    if (!Float.isNaN(this.elevation)) {
                        f12 = this.elevation;
                    }
                    viewSpline.setPoint(i11, f12);
                    break;
                case 12:
                    if (!Float.isNaN(this.mPathRotate)) {
                        f12 = this.mPathRotate;
                    }
                    viewSpline.setPoint(i11, f12);
                    break;
                case 13:
                    if (!Float.isNaN(this.alpha)) {
                        f11 = this.alpha;
                    }
                    viewSpline.setPoint(i11, f11);
                    break;
                default:
                    if (!next.startsWith("CUSTOM")) {
                        Log.e("MotionPaths", "UNKNOWN spline " + next);
                        break;
                    } else {
                        String str = next.split(",")[1];
                        if (!this.f10898d.containsKey(str)) {
                            break;
                        } else {
                            ConstraintAttribute constraintAttribute = this.f10898d.get(str);
                            if (!(viewSpline instanceof ViewSpline.CustomSet)) {
                                Log.e("MotionPaths", next + " ViewSpline not a CustomSet frame = " + i11 + ", value" + constraintAttribute.getValueToInterpolate() + viewSpline);
                                break;
                            } else {
                                ((ViewSpline.CustomSet) viewSpline).setPoint(i11, constraintAttribute);
                                break;
                            }
                        }
                    }
            }
        }
    }

    public void applyParameters(View view) {
        this.f10897c = view.getVisibility();
        this.alpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.applyElevation = false;
        this.elevation = view.getElevation();
        this.rotation = view.getRotation();
        this.rotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.scaleX = view.getScaleX();
        this.scaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.translationX = view.getTranslationX();
        this.translationY = view.getTranslationY();
        this.translationZ = view.getTranslationZ();
    }

    public void b(float f11, float f12, float f13, float f14) {
        this.f10902x = f11;
        this.f10903y = f12;
        this.width = f13;
        this.height = f14;
    }

    public void setState(View view) {
        b(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        applyParameters(view);
    }

    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.position, motionConstrainedPoint.position);
    }

    public void setState(Rect rect, View view, int i11, float f11) {
        b((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        applyParameters(view);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (i11 == 1) {
            this.rotation = f11 - 90.0f;
        } else if (i11 == 2) {
            this.rotation = f11 + 90.0f;
        }
    }

    public void setState(Rect rect, ConstraintSet constraintSet, int i11, int i12) {
        b((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        applyParameters(constraintSet.getParameters(i12));
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        return;
                    }
                }
            }
            float f11 = this.rotation + 90.0f;
            this.rotation = f11;
            if (f11 > 180.0f) {
                this.rotation = f11 - 360.0f;
                return;
            }
            return;
        }
        this.rotation -= 90.0f;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        float f11;
        ConstraintSet.PropertySet propertySet = constraint.propertySet;
        int i11 = propertySet.mVisibilityMode;
        this.f10896b = i11;
        int i12 = propertySet.visibility;
        this.f10897c = i12;
        if (i12 == 0 || i11 != 0) {
            f11 = propertySet.alpha;
        } else {
            f11 = 0.0f;
        }
        this.alpha = f11;
        ConstraintSet.Transform transform = constraint.transform;
        this.applyElevation = transform.applyElevation;
        this.elevation = transform.elevation;
        this.rotation = transform.rotation;
        this.rotationX = transform.rotationX;
        this.rotationY = transform.rotationY;
        this.scaleX = transform.scaleX;
        this.scaleY = transform.scaleY;
        this.mPivotX = transform.transformPivotX;
        this.mPivotY = transform.transformPivotY;
        this.translationX = transform.translationX;
        this.translationY = transform.translationY;
        this.translationZ = transform.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mProgress = constraint.propertySet.mProgress;
        for (String next : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(next);
            if (constraintAttribute.isContinuous()) {
                this.f10898d.put(next, constraintAttribute);
            }
        }
    }
}
