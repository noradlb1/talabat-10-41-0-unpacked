package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "fraction", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class EasingFunctionsKt$EaseInOutBounce$1 implements Easing {
    public static final EasingFunctionsKt$EaseInOutBounce$1 INSTANCE = new EasingFunctionsKt$EaseInOutBounce$1();

    public final float transform(float f11) {
        float f12;
        if (((double) f11) < 0.5d) {
            f12 = ((float) 1) - EasingFunctionsKt.getEaseOutBounce().transform(1.0f - (f11 * 2.0f));
        } else {
            f12 = ((float) 1) + EasingFunctionsKt.getEaseOutBounce().transform((f11 * 2.0f) - 1.0f);
        }
        return f12 / 2.0f;
    }
}
