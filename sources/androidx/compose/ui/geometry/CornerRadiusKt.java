package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"CornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-3Ry4LBc", "(JJF)J", "ui-geometry_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CornerRadiusKt {
    @Stable
    public static final long CornerRadius(float f11, float f12) {
        long floatToIntBits = (long) Float.floatToIntBits(f11);
        return CornerRadius.m2645constructorimpl((((long) Float.floatToIntBits(f12)) & 4294967295L) | (floatToIntBits << 32));
    }

    public static /* synthetic */ long CornerRadius$default(float f11, float f12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f12 = f11;
        }
        return CornerRadius(f11, f12);
    }

    @Stable
    /* renamed from: lerp-3Ry4LBc  reason: not valid java name */
    public static final long m2662lerp3Ry4LBc(long j11, long j12, float f11) {
        return CornerRadius(MathHelpersKt.lerp(CornerRadius.m2651getXimpl(j11), CornerRadius.m2651getXimpl(j12), f11), MathHelpersKt.lerp(CornerRadius.m2652getYimpl(j11), CornerRadius.m2652getYimpl(j12), f11));
    }
}
