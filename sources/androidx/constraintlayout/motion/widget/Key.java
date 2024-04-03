package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Key {
    public static final String ALPHA = "alpha";
    public static final String CURVEFIT = "curveFit";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String MOTIONPROGRESS = "motionProgress";
    public static final String PIVOT_X = "transformPivotX";
    public static final String PIVOT_Y = "transformPivotY";
    public static final String PROGRESS = "progress";
    public static final String ROTATION = "rotation";
    public static final String ROTATION_X = "rotationX";
    public static final String ROTATION_Y = "rotationY";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITIONEASING = "transitionEasing";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static final String TRANSLATION_Z = "translationZ";
    public static int UNSET = -1;
    public static final String VISIBILITY = "visibility";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_VARIES_BY = "waveVariesBy";

    /* renamed from: a  reason: collision with root package name */
    public int f10871a;

    /* renamed from: b  reason: collision with root package name */
    public int f10872b;

    /* renamed from: c  reason: collision with root package name */
    public String f10873c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f10874d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f10875e;

    public Key() {
        int i11 = UNSET;
        this.f10871a = i11;
        this.f10872b = i11;
    }

    public boolean a(String str) {
        String str2 = this.f10873c;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public abstract void addValues(HashMap<String, ViewSpline> hashMap);

    public boolean b(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    public float c(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    public abstract Key clone();

    public Key copy(Key key) {
        this.f10871a = key.f10871a;
        this.f10872b = key.f10872b;
        this.f10873c = key.f10873c;
        this.f10874d = key.f10874d;
        this.f10875e = key.f10875e;
        return this;
    }

    public int d(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }

    public abstract void getAttributeNames(HashSet<String> hashSet);

    public int getFramePosition() {
        return this.f10871a;
    }

    public abstract void load(Context context, AttributeSet attributeSet);

    public void setFramePosition(int i11) {
        this.f10871a = i11;
    }

    public void setInterpolation(HashMap<String, Integer> hashMap) {
    }

    public abstract void setValue(String str, Object obj);

    public Key setViewId(int i11) {
        this.f10872b = i11;
        return this;
    }
}
