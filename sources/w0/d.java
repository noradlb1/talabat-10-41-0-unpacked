package w0;

import androidx.constraintlayout.core.motion.utils.TypedValues;

public final /* synthetic */ class d {
    static {
        String str = TypedValues.MotionScene.NAME;
    }

    public static int a(String str) {
        str.hashCode();
        if (!str.equals(TypedValues.MotionScene.S_DEFAULT_DURATION)) {
            return !str.equals(TypedValues.MotionScene.S_LAYOUT_DURING_TRANSITION) ? -1 : 601;
        }
        return 600;
    }

    public static int b(int i11) {
        if (i11 != 600) {
            return i11 != 601 ? -1 : 1;
        }
        return 2;
    }
}
