package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "fraction", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class EasingFunctionsKt$EaseOutElastic$1 implements Easing {
    public static final EasingFunctionsKt$EaseOutElastic$1 INSTANCE = new EasingFunctionsKt$EaseOutElastic$1();

    public final float transform(float f11) {
        boolean z11;
        boolean z12 = true;
        if (f11 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return 0.0f;
        }
        if (f11 != 1.0f) {
            z12 = false;
        }
        if (z12) {
            return 1.0f;
        }
        return (float) ((((double) ((float) Math.pow((double) 2.0f, (double) (-10.0f * f11)))) * Math.sin(((double) ((f11 * 10.0f) - 0.75f)) * 2.0943951023931953d)) + ((double) 1.0f));
    }
}
