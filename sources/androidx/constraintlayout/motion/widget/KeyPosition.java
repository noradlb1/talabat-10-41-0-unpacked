package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

public class KeyPosition extends KeyPositionBase {
    public static final String DRAWPATH = "drawPath";
    public static final String PERCENT_HEIGHT = "percentHeight";
    public static final String PERCENT_WIDTH = "percentWidth";
    public static final String PERCENT_X = "percentX";
    public static final String PERCENT_Y = "percentY";
    public static final String SIZE_PERCENT = "sizePercent";
    private static final String TAG = "KeyPosition";
    public static final String TRANSITION_EASING = "transitionEasing";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;

    /* renamed from: g  reason: collision with root package name */
    public String f10877g = null;

    /* renamed from: h  reason: collision with root package name */
    public int f10878h = Key.UNSET;

    /* renamed from: i  reason: collision with root package name */
    public int f10879i = 0;

    /* renamed from: j  reason: collision with root package name */
    public float f10880j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f10881k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public float f10882l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f10883m = Float.NaN;
    private float mCalculatedPositionX = Float.NaN;
    private float mCalculatedPositionY = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    public float f10884n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public float f10885o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    public int f10886p = 0;

    public static class Loader {
        private static final int CURVE_FIT = 4;
        private static final int DRAW_PATH = 5;
        private static final int FRAME_POSITION = 2;
        private static final int PATH_MOTION_ARC = 10;
        private static final int PERCENT_HEIGHT = 12;
        private static final int PERCENT_WIDTH = 11;
        private static final int PERCENT_X = 6;
        private static final int PERCENT_Y = 7;
        private static final int SIZE_PERCENT = 8;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TYPE = 9;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private Loader() {
        }

        /* access modifiers changed from: private */
        public static void read(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyPosition.f10872b = typedArray.getResourceId(index, keyPosition.f10872b);
                                break;
                            } else {
                                keyPosition.f10873c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyPosition.f10872b);
                            keyPosition.f10872b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyPosition.f10873c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyPosition.f10871a = typedArray.getInt(index, keyPosition.f10871a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type != 3) {
                            keyPosition.f10877g = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                            break;
                        } else {
                            keyPosition.f10877g = typedArray.getString(index);
                            break;
                        }
                    case 4:
                        keyPosition.f10887f = typedArray.getInteger(index, keyPosition.f10887f);
                        break;
                    case 5:
                        keyPosition.f10879i = typedArray.getInt(index, keyPosition.f10879i);
                        break;
                    case 6:
                        keyPosition.f10882l = typedArray.getFloat(index, keyPosition.f10882l);
                        break;
                    case 7:
                        keyPosition.f10883m = typedArray.getFloat(index, keyPosition.f10883m);
                        break;
                    case 8:
                        float f11 = typedArray.getFloat(index, keyPosition.f10881k);
                        keyPosition.f10880j = f11;
                        keyPosition.f10881k = f11;
                        break;
                    case 9:
                        keyPosition.f10886p = typedArray.getInt(index, keyPosition.f10886p);
                        break;
                    case 10:
                        keyPosition.f10878h = typedArray.getInt(index, keyPosition.f10878h);
                        break;
                    case 11:
                        keyPosition.f10880j = typedArray.getFloat(index, keyPosition.f10880j);
                        break;
                    case 12:
                        keyPosition.f10881k = typedArray.getFloat(index, keyPosition.f10881k);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                }
            }
            if (keyPosition.f10871a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public KeyPosition() {
        this.f10874d = 2;
    }

    private void calcCartesianPosition(float f11, float f12, float f13, float f14) {
        float f15;
        float f16;
        float f17;
        float f18 = f13 - f11;
        float f19 = f14 - f12;
        float f21 = 0.0f;
        if (Float.isNaN(this.f10882l)) {
            f15 = 0.0f;
        } else {
            f15 = this.f10882l;
        }
        if (Float.isNaN(this.f10885o)) {
            f16 = 0.0f;
        } else {
            f16 = this.f10885o;
        }
        if (Float.isNaN(this.f10883m)) {
            f17 = 0.0f;
        } else {
            f17 = this.f10883m;
        }
        if (!Float.isNaN(this.f10884n)) {
            f21 = this.f10884n;
        }
        this.mCalculatedPositionX = (float) ((int) (f11 + (f15 * f18) + (f21 * f19)));
        this.mCalculatedPositionY = (float) ((int) (f12 + (f18 * f16) + (f19 * f17)));
    }

    private void calcPathPosition(float f11, float f12, float f13, float f14) {
        float f15 = f13 - f11;
        float f16 = f14 - f12;
        float f17 = this.f10882l;
        float f18 = this.f10883m;
        this.mCalculatedPositionX = f11 + (f15 * f17) + ((-f16) * f18);
        this.mCalculatedPositionY = f12 + (f16 * f17) + (f15 * f18);
    }

    private void calcScreenPosition(int i11, int i12) {
        float f11 = this.f10882l;
        float f12 = (float) 0;
        this.mCalculatedPositionX = (((float) (i11 - 0)) * f11) + f12;
        this.mCalculatedPositionY = (((float) (i12 - 0)) * f11) + f12;
    }

    public void addValues(HashMap<String, ViewSpline> hashMap) {
    }

    public Key copy(Key key) {
        super.copy(key);
        KeyPosition keyPosition = (KeyPosition) key;
        this.f10877g = keyPosition.f10877g;
        this.f10878h = keyPosition.f10878h;
        this.f10879i = keyPosition.f10879i;
        this.f10880j = keyPosition.f10880j;
        this.f10881k = Float.NaN;
        this.f10882l = keyPosition.f10882l;
        this.f10883m = keyPosition.f10883m;
        this.f10884n = keyPosition.f10884n;
        this.f10885o = keyPosition.f10885o;
        this.mCalculatedPositionX = keyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = keyPosition.mCalculatedPositionY;
        return this;
    }

    public void e(int i11, int i12, float f11, float f12, float f13, float f14) {
        int i13 = this.f10886p;
        if (i13 == 1) {
            calcPathPosition(f11, f12, f13, f14);
        } else if (i13 != 2) {
            calcCartesianPosition(f11, f12, f13, f14);
        } else {
            calcScreenPosition(i11, i12);
        }
    }

    public void f(RectF rectF, RectF rectF2, float f11, float f12, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
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

    public void g(RectF rectF, RectF rectF2, float f11, float f12, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
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

    public void h(View view, RectF rectF, RectF rectF2, float f11, float f12, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
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

    public boolean intersects(int i11, int i12, RectF rectF, RectF rectF2, float f11, float f12) {
        e(i11, i12, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        if (Math.abs(f11 - this.mCalculatedPositionX) >= 20.0f || Math.abs(f12 - this.mCalculatedPositionY) >= 20.0f) {
            return false;
        }
        return true;
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f11, float f12, String[] strArr, float[] fArr) {
        int i11 = this.f10886p;
        if (i11 == 1) {
            g(rectF, rectF2, f11, f12, strArr, fArr);
        } else if (i11 != 2) {
            f(rectF, rectF2, f11, f12, strArr, fArr);
        } else {
            h(view, rectF, rectF2, f11, f12, strArr, fArr);
        }
    }

    public void setType(int i11) {
        this.f10886p = i11;
    }

    public void setValue(String str, Object obj) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c11 = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c11 = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c11 = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c11 = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.f10877g = obj.toString();
                return;
            case 1:
                this.f10880j = c(obj);
                return;
            case 2:
                this.f10881k = c(obj);
                return;
            case 3:
                this.f10879i = d(obj);
                return;
            case 4:
                float c12 = c(obj);
                this.f10880j = c12;
                this.f10881k = c12;
                return;
            case 5:
                this.f10882l = c(obj);
                return;
            case 6:
                this.f10883m = c(obj);
                return;
            default:
                return;
        }
    }

    public Key clone() {
        return new KeyPosition().copy(this);
    }
}
