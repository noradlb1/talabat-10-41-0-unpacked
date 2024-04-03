package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Set;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import w0.a;
import w0.e;

public class MotionWidget implements TypedValues {
    public static final int FILL_PARENT = -1;
    public static final int GONE_UNSET = Integer.MIN_VALUE;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 0;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MATCH_PARENT = -1;
    public static final int PARENT_ID = 0;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int UNSET = -1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 4;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: a  reason: collision with root package name */
    public WidgetFrame f10513a = new WidgetFrame();

    /* renamed from: b  reason: collision with root package name */
    public Motion f10514b = new Motion();

    /* renamed from: c  reason: collision with root package name */
    public PropertySet f10515c = new PropertySet();

    /* renamed from: d  reason: collision with root package name */
    public float f10516d;
    private float mProgress;

    public static class Motion {
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int SPLINE_STRING = -1;
        public int mAnimateCircleAngleTo = 0;
        public int mAnimateRelativeTo = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPathMotionArc = -1;
        public float mPathRotate = Float.NaN;
        public int mPolarRelativeTo = -1;
        public int mQuantizeInterpolatorID = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mTransitionEasing = null;
    }

    public static class PropertySet {
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;
        public int mVisibilityMode = 0;
        public int visibility = 4;
    }

    public MotionWidget() {
    }

    public MotionWidget findViewById(int i11) {
        return null;
    }

    public float getAlpha() {
        return this.f10515c.alpha;
    }

    public int getBottom() {
        return this.f10513a.bottom;
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.f10513a.getCustomAttribute(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.f10513a.getCustomAttributeNames();
    }

    public int getHeight() {
        WidgetFrame widgetFrame = this.f10513a;
        return widgetFrame.bottom - widgetFrame.top;
    }

    public int getId(String str) {
        int a11 = a.a(str);
        if (a11 != -1) {
            return a11;
        }
        return e.a(str);
    }

    public int getLeft() {
        return this.f10513a.left;
    }

    public String getName() {
        return this.f10513a.getId();
    }

    public MotionWidget getParent() {
        return null;
    }

    public float getPivotX() {
        return this.f10513a.pivotX;
    }

    public float getPivotY() {
        return this.f10513a.pivotY;
    }

    public int getRight() {
        return this.f10513a.right;
    }

    public float getRotationX() {
        return this.f10513a.rotationX;
    }

    public float getRotationY() {
        return this.f10513a.rotationY;
    }

    public float getRotationZ() {
        return this.f10513a.rotationZ;
    }

    public float getScaleX() {
        return this.f10513a.scaleX;
    }

    public float getScaleY() {
        return this.f10513a.scaleY;
    }

    public int getTop() {
        return this.f10513a.top;
    }

    public float getTranslationX() {
        return this.f10513a.translationX;
    }

    public float getTranslationY() {
        return this.f10513a.translationY;
    }

    public float getTranslationZ() {
        return this.f10513a.translationZ;
    }

    public float getValueAttributes(int i11) {
        switch (i11) {
            case 303:
                return this.f10513a.alpha;
            case 304:
                return this.f10513a.translationX;
            case 305:
                return this.f10513a.translationY;
            case 306:
                return this.f10513a.translationZ;
            case 308:
                return this.f10513a.rotationX;
            case 309:
                return this.f10513a.rotationY;
            case 310:
                return this.f10513a.rotationZ;
            case 311:
                return this.f10513a.scaleX;
            case 312:
                return this.f10513a.scaleY;
            case 313:
                return this.f10513a.pivotX;
            case 314:
                return this.f10513a.pivotY;
            case 315:
                return this.mProgress;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE:
                return this.f10516d;
            default:
                return Float.NaN;
        }
    }

    public int getVisibility() {
        return this.f10515c.visibility;
    }

    public WidgetFrame getWidgetFrame() {
        return this.f10513a;
    }

    public int getWidth() {
        WidgetFrame widgetFrame = this.f10513a;
        return widgetFrame.right - widgetFrame.left;
    }

    public int getX() {
        return this.f10513a.left;
    }

    public int getY() {
        return this.f10513a.top;
    }

    public void layout(int i11, int i12, int i13, int i14) {
        setBounds(i11, i12, i13, i14);
    }

    public void setBounds(int i11, int i12, int i13, int i14) {
        if (this.f10513a == null) {
            this.f10513a = new WidgetFrame((ConstraintWidget) null);
        }
        WidgetFrame widgetFrame = this.f10513a;
        widgetFrame.top = i12;
        widgetFrame.left = i11;
        widgetFrame.right = i13;
        widgetFrame.bottom = i14;
    }

    public void setCustomAttribute(String str, int i11, float f11) {
        this.f10513a.setCustomAttribute(str, i11, f11);
    }

    public void setInterpolatedValue(CustomAttribute customAttribute, float[] fArr) {
        this.f10513a.setCustomAttribute(customAttribute.f10470a, 901, fArr[0]);
    }

    public void setPivotX(float f11) {
        this.f10513a.pivotX = f11;
    }

    public void setPivotY(float f11) {
        this.f10513a.pivotY = f11;
    }

    public void setRotationX(float f11) {
        this.f10513a.rotationX = f11;
    }

    public void setRotationY(float f11) {
        this.f10513a.rotationY = f11;
    }

    public void setRotationZ(float f11) {
        this.f10513a.rotationZ = f11;
    }

    public void setScaleX(float f11) {
        this.f10513a.scaleX = f11;
    }

    public void setScaleY(float f11) {
        this.f10513a.scaleY = f11;
    }

    public void setTranslationX(float f11) {
        this.f10513a.translationX = f11;
    }

    public void setTranslationY(float f11) {
        this.f10513a.translationY = f11;
    }

    public void setTranslationZ(float f11) {
        this.f10513a.translationZ = f11;
    }

    public boolean setValue(int i11, int i12) {
        return setValueAttributes(i11, (float) i12);
    }

    public boolean setValue(int i11, boolean z11) {
        return false;
    }

    public boolean setValueAttributes(int i11, float f11) {
        switch (i11) {
            case 303:
                this.f10513a.alpha = f11;
                return true;
            case 304:
                this.f10513a.translationX = f11;
                return true;
            case 305:
                this.f10513a.translationY = f11;
                return true;
            case 306:
                this.f10513a.translationZ = f11;
                return true;
            case 308:
                this.f10513a.rotationX = f11;
                return true;
            case 309:
                this.f10513a.rotationY = f11;
                return true;
            case 310:
                this.f10513a.rotationZ = f11;
                return true;
            case 311:
                this.f10513a.scaleX = f11;
                return true;
            case 312:
                this.f10513a.scaleY = f11;
                return true;
            case 313:
                this.f10513a.pivotX = f11;
                return true;
            case 314:
                this.f10513a.pivotY = f11;
                return true;
            case 315:
                this.mProgress = f11;
                return true;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE:
                this.f10516d = f11;
                return true;
            default:
                return false;
        }
    }

    public boolean setValueMotion(int i11, int i12) {
        switch (i11) {
            case TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO:
                this.f10514b.mAnimateRelativeTo = i12;
                return true;
            case TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO:
                this.f10514b.mAnimateCircleAngleTo = i12;
                return true;
            case TypedValues.MotionType.TYPE_PATHMOTION_ARC:
                this.f10514b.mPathMotionArc = i12;
                return true;
            case TypedValues.MotionType.TYPE_DRAW_PATH:
                this.f10514b.mDrawPath = i12;
                return true;
            case TypedValues.MotionType.TYPE_POLAR_RELATIVETO:
                this.f10514b.mPolarRelativeTo = i12;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS:
                this.f10514b.mQuantizeMotionSteps = i12;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE:
                this.f10514b.mQuantizeInterpolatorType = i12;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID:
                this.f10514b.mQuantizeInterpolatorID = i12;
                return true;
            default:
                return false;
        }
    }

    public void setVisibility(int i11) {
        this.f10515c.visibility = i11;
    }

    public String toString() {
        return this.f10513a.left + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f10513a.top + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f10513a.right + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f10513a.bottom;
    }

    public void setCustomAttribute(String str, int i11, int i12) {
        this.f10513a.setCustomAttribute(str, i11, i12);
    }

    public boolean setValue(int i11, float f11) {
        if (setValueAttributes(i11, f11)) {
            return true;
        }
        return setValueMotion(i11, f11);
    }

    public void setCustomAttribute(String str, int i11, boolean z11) {
        this.f10513a.setCustomAttribute(str, i11, z11);
    }

    public void setCustomAttribute(String str, int i11, String str2) {
        this.f10513a.setCustomAttribute(str, i11, str2);
    }

    public boolean setValue(int i11, String str) {
        return setValueMotion(i11, str);
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.f10513a = widgetFrame;
    }

    public boolean setValueMotion(int i11, String str) {
        if (i11 == 603) {
            this.f10514b.mTransitionEasing = str;
            return true;
        } else if (i11 != 604) {
            return false;
        } else {
            this.f10514b.mQuantizeInterpolatorString = str;
            return true;
        }
    }

    public boolean setValueMotion(int i11, float f11) {
        switch (i11) {
            case 600:
                this.f10514b.mMotionStagger = f11;
                return true;
            case 601:
                this.f10514b.mPathRotate = f11;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE:
                this.f10514b.mQuantizeMotionPhase = f11;
                return true;
            default:
                return false;
        }
    }
}
