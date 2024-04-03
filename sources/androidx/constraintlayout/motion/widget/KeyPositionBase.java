package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

abstract class KeyPositionBase extends Key {

    /* renamed from: f  reason: collision with root package name */
    public int f10887f = Key.UNSET;

    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public abstract boolean intersects(int i11, int i12, RectF rectF, RectF rectF2, float f11, float f12);

    public abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f11, float f12, String[] strArr, float[] fArr);
}
