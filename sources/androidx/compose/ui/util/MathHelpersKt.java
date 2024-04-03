package androidx.compose.ui.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"lerp", "", "start", "stop", "fraction", "", "", "ui-util_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MathHelpersKt {
    public static final float lerp(float f11, float f12, float f13) {
        return ((((float) 1) - f13) * f11) + (f13 * f12);
    }

    public static final int lerp(int i11, int i12, float f11) {
        return i11 + MathKt__MathJVMKt.roundToInt(((double) (i12 - i11)) * ((double) f11));
    }

    public static final long lerp(long j11, long j12, float f11) {
        return j11 + MathKt__MathJVMKt.roundToLong(((double) (j12 - j11)) * ((double) f11));
    }
}
