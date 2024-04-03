package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    public Rect evaluate(float f11, Rect rect, Rect rect2) {
        int i11 = rect.left;
        int i12 = i11 + ((int) (((float) (rect2.left - i11)) * f11));
        int i13 = rect.top;
        int i14 = i13 + ((int) (((float) (rect2.top - i13)) * f11));
        int i15 = rect.right;
        int i16 = i15 + ((int) (((float) (rect2.right - i15)) * f11));
        int i17 = rect.bottom;
        int i18 = i17 + ((int) (((float) (rect2.bottom - i17)) * f11));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i12, i14, i16, i18);
        }
        rect3.set(i12, i14, i16, i18);
        return this.mRect;
    }
}
