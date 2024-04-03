package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;
import w0.f;

public class MotionKeyPosition extends MotionKey {
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX;
    public float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    public int mCurveFit;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing = null;

    public MotionKeyPosition() {
        int i11 = MotionKey.UNSET;
        this.mCurveFit = i11;
        this.mPathMotionArc = i11;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    private void calcCartesianPosition(float f11, float f12, float f13, float f14) {
        float f15;
        float f16;
        float f17;
        float f18 = f13 - f11;
        float f19 = f14 - f12;
        float f21 = 0.0f;
        if (Float.isNaN(this.mPercentX)) {
            f15 = 0.0f;
        } else {
            f15 = this.mPercentX;
        }
        if (Float.isNaN(this.mAltPercentY)) {
            f16 = 0.0f;
        } else {
            f16 = this.mAltPercentY;
        }
        if (Float.isNaN(this.mPercentY)) {
            f17 = 0.0f;
        } else {
            f17 = this.mPercentY;
        }
        if (!Float.isNaN(this.mAltPercentX)) {
            f21 = this.mAltPercentX;
        }
        this.mCalculatedPositionX = (float) ((int) (f11 + (f15 * f18) + (f21 * f19)));
        this.mCalculatedPositionY = (float) ((int) (f12 + (f18 * f16) + (f19 * f17)));
    }

    private void calcPathPosition(float f11, float f12, float f13, float f14) {
        float f15 = f13 - f11;
        float f16 = f14 - f12;
        float f17 = this.mPercentX;
        float f18 = this.mPercentY;
        this.mCalculatedPositionX = f11 + (f15 * f17) + ((-f16) * f18);
        this.mCalculatedPositionY = f12 + (f16 * f17) + (f15 * f18);
    }

    private void calcScreenPosition(int i11, int i12) {
        float f11 = this.mPercentX;
        float f12 = (float) 0;
        this.mCalculatedPositionX = (((float) (i11 - 0)) * f11) + f12;
        this.mCalculatedPositionY = (((float) (i12 - 0)) * f11) + f12;
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    public void c(int i11, int i12, float f11, float f12, float f13, float f14) {
        int i13 = this.mPositionType;
        if (i13 == 1) {
            calcPathPosition(f11, f12, f13, f14);
        } else if (i13 != 2) {
            calcCartesianPosition(f11, f12, f13, f14);
        } else {
            calcScreenPosition(i11, i12);
        }
    }

    public MotionKey copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.mTransitionEasing = motionKeyPosition.mTransitionEasing;
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mPercentWidth = motionKeyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = motionKeyPosition.mPercentX;
        this.mPercentY = motionKeyPosition.mPercentY;
        this.mAltPercentX = motionKeyPosition.mAltPercentX;
        this.mAltPercentY = motionKeyPosition.mAltPercentY;
        this.mCalculatedPositionX = motionKeyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = motionKeyPosition.mCalculatedPositionY;
        return this;
    }

    public void d(FloatRect floatRect, FloatRect floatRect2, float f11, float f12, String[] strArr, float[] fArr) {
        float centerX = floatRect.centerX();
        float centerY = floatRect.centerY();
        float centerX2 = floatRect2.centerX() - centerX;
        float centerY2 = floatRect2.centerY() - centerY;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = (f11 - centerX) / centerX2;
            strArr[1] = "percentY";
            fArr[1] = (f12 - centerY) / centerY2;
        } else if ("percentX".equals(str)) {
            fArr[0] = (f11 - centerX) / centerX2;
            fArr[1] = (f12 - centerY) / centerY2;
        } else {
            fArr[1] = (f11 - centerX) / centerX2;
            fArr[0] = (f12 - centerY) / centerY2;
        }
    }

    public void e(FloatRect floatRect, FloatRect floatRect2, float f11, float f12, String[] strArr, float[] fArr) {
        float centerX = floatRect.centerX();
        float centerY = floatRect.centerY();
        float centerX2 = floatRect2.centerX() - centerX;
        float centerY2 = floatRect2.centerY() - centerY;
        float hypot = (float) Math.hypot((double) centerX2, (double) centerY2);
        if (((double) hypot) < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f13 = centerX2 / hypot;
        float f14 = centerY2 / hypot;
        float f15 = f12 - centerY;
        float f16 = f11 - centerX;
        float f17 = ((f13 * f15) - (f16 * f14)) / hypot;
        float f18 = ((f13 * f16) + (f14 * f15)) / hypot;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            strArr[1] = "percentY";
            fArr[0] = f18;
            fArr[1] = f17;
        } else if ("percentX".equals(str)) {
            fArr[0] = f18;
            fArr[1] = f17;
        }
    }

    public void f(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f11, float f12, String[] strArr, float[] fArr) {
        floatRect.centerX();
        floatRect.centerY();
        floatRect2.centerX();
        floatRect2.centerY();
        MotionWidget parent = motionWidget.getParent();
        int width = parent.getWidth();
        int height = parent.getHeight();
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = f11 / ((float) width);
            strArr[1] = "percentY";
            fArr[1] = f12 / ((float) height);
        } else if ("percentX".equals(str)) {
            fArr[0] = f11 / ((float) width);
            fArr[1] = f12 / ((float) height);
        } else {
            fArr[1] = f11 / ((float) width);
            fArr[0] = f12 / ((float) height);
        }
    }

    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public int getId(String str) {
        return f.a(str);
    }

    public boolean intersects(int i11, int i12, FloatRect floatRect, FloatRect floatRect2, float f11, float f12) {
        c(i11, i12, floatRect.centerX(), floatRect.centerY(), floatRect2.centerX(), floatRect2.centerY());
        if (Math.abs(f11 - this.mCalculatedPositionX) >= 20.0f || Math.abs(f12 - this.mCalculatedPositionY) >= 20.0f) {
            return false;
        }
        return true;
    }

    public void positionAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f11, float f12, String[] strArr, float[] fArr) {
        int i11 = this.mPositionType;
        if (i11 == 1) {
            e(floatRect, floatRect2, f11, f12, strArr, fArr);
        } else if (i11 != 2) {
            d(floatRect, floatRect2, f11, f12, strArr, fArr);
        } else {
            f(motionWidget, floatRect, floatRect2, f11, f12, strArr, fArr);
        }
    }

    public boolean setValue(int i11, int i12) {
        if (i11 == 100) {
            this.mFramePosition = i12;
            return true;
        } else if (i11 == 508) {
            this.mCurveFit = i12;
            return true;
        } else if (i11 != 510) {
            return super.setValue(i11, i12);
        } else {
            this.mPositionType = i12;
            return true;
        }
    }

    public MotionKey clone() {
        return new MotionKeyPosition().copy(this);
    }

    public boolean setValue(int i11, float f11) {
        switch (i11) {
            case 503:
                this.mPercentWidth = f11;
                return true;
            case 504:
                this.mPercentHeight = f11;
                return true;
            case 505:
                this.mPercentWidth = f11;
                this.mPercentHeight = f11;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_X /*506*/:
                this.mPercentX = f11;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_Y /*507*/:
                this.mPercentY = f11;
                return true;
            default:
                return super.setValue(i11, f11);
        }
    }

    public boolean setValue(int i11, String str) {
        if (i11 != 501) {
            return super.setValue(i11, str);
        }
        this.mTransitionEasing = str.toString();
        return true;
    }
}
