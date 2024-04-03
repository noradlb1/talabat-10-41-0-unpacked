package androidx.compose.foundation.layout;

public final /* synthetic */ class a {
    public static float a(SideCalculator sideCalculator, float f11, float f12) {
        return RangesKt___RangesKt.coerceAtMost(sideCalculator.motionOf(f11, f12), 0.0f);
    }

    public static float b(SideCalculator sideCalculator, float f11, float f12) {
        return RangesKt___RangesKt.coerceAtLeast(sideCalculator.motionOf(f11, f12), 0.0f);
    }
}
