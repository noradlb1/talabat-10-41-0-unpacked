package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

public abstract class MotionKey implements TypedValues {
    public static final String ALPHA = "alpha";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String ROTATION = "rotationZ";
    public static final String ROTATION_X = "rotationX";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static int UNSET = -1;
    public static final String VISIBILITY = "visibility";

    /* renamed from: a  reason: collision with root package name */
    public int f10517a;

    /* renamed from: b  reason: collision with root package name */
    public String f10518b = null;
    public HashMap<String, CustomVariable> mCustom;
    public int mFramePosition;
    public int mType;

    public MotionKey() {
        int i11 = UNSET;
        this.mFramePosition = i11;
        this.f10517a = i11;
    }

    public float a(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    public abstract void addValues(HashMap<String, SplineSet> hashMap);

    public int b(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }

    public abstract MotionKey clone();

    public MotionKey copy(MotionKey motionKey) {
        this.mFramePosition = motionKey.mFramePosition;
        this.f10517a = motionKey.f10517a;
        this.f10518b = motionKey.f10518b;
        this.mType = motionKey.mType;
        return this;
    }

    public abstract void getAttributeNames(HashSet<String> hashSet);

    public int getFramePosition() {
        return this.mFramePosition;
    }

    public void setCustomAttribute(String str, int i11, float f11) {
        this.mCustom.put(str, new CustomVariable(str, i11, f11));
    }

    public void setFramePosition(int i11) {
        this.mFramePosition = i11;
    }

    public void setInterpolation(HashMap<String, Integer> hashMap) {
    }

    public boolean setValue(int i11, float f11) {
        return false;
    }

    public boolean setValue(int i11, int i12) {
        if (i11 != 100) {
            return false;
        }
        this.mFramePosition = i12;
        return true;
    }

    public boolean setValue(int i11, boolean z11) {
        return false;
    }

    public MotionKey setViewId(int i11) {
        this.f10517a = i11;
        return this;
    }

    public void setCustomAttribute(String str, int i11, int i12) {
        this.mCustom.put(str, new CustomVariable(str, i11, i12));
    }

    public boolean setValue(int i11, String str) {
        if (i11 != 101) {
            return false;
        }
        this.f10518b = str;
        return true;
    }

    public void setCustomAttribute(String str, int i11, boolean z11) {
        this.mCustom.put(str, new CustomVariable(str, i11, z11));
    }

    public void setCustomAttribute(String str, int i11, String str2) {
        this.mCustom.put(str, new CustomVariable(str, i11, str2));
    }
}
