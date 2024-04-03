package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "fraction", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class EasingFunctionsKt$EaseInOutElastic$1 implements Easing {
    public static final EasingFunctionsKt$EaseInOutElastic$1 INSTANCE = new EasingFunctionsKt$EaseInOutElastic$1();

    public final float transform(float f11) {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (f11 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return 0.0f;
        }
        if (f11 == 1.0f) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            return 1.0f;
        }
        if (0.0f > f11 || f11 > 0.5f) {
            z13 = false;
        }
        if (z13) {
            double d11 = (double) 2.0f;
            float f12 = f11 * 20.0f;
            return (float) ((-(((double) ((float) Math.pow(d11, (double) (f12 - 10.0f)))) * Math.sin(((double) (f12 - 11.125f)) * 1.3962634015954636d))) / d11);
        }
        double d12 = (double) 2.0f;
        return ((float) ((((double) ((float) Math.pow(d12, (double) ((-20.0f * f11) + 10.0f)))) * Math.sin(((double) ((f11 * 20.0f) - 11.125f)) * 1.3962634015954636d)) / d12)) + 1.0f;
    }
}
