package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "fraction", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class EasingFunctionsKt$EaseOutBounce$1 implements Easing {
    public static final EasingFunctionsKt$EaseOutBounce$1 INSTANCE = new EasingFunctionsKt$EaseOutBounce$1();

    public final float transform(float f11) {
        float f12;
        float f13;
        if (f11 < 0.36363637f) {
            return 7.5625f * f11 * f11;
        }
        if (f11 < 0.72727275f) {
            float f14 = f11 - 0.54545456f;
            f12 = 7.5625f * f14 * f14;
            f13 = 0.75f;
        } else if (f11 < 0.90909094f) {
            float f15 = f11 - 0.8181818f;
            f12 = 7.5625f * f15 * f15;
            f13 = 0.9375f;
        } else {
            float f16 = f11 - 0.95454544f;
            f12 = 7.5625f * f16 * f16;
            f13 = 0.984375f;
        }
        return f12 + f13;
    }
}
