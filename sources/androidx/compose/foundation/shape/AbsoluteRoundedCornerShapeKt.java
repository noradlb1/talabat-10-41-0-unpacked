package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a;\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000e\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\u000e\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"AbsoluteRoundedCornerShape", "Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "corner", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "AbsoluteRoundedCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "topLeft", "topRight", "bottomRight", "bottomLeft", "AbsoluteRoundedCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "", "percent", "", "topLeftPercent", "topRightPercent", "bottomRightPercent", "bottomLeftPercent", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AbsoluteRoundedCornerShapeKt {
    @NotNull
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(@NotNull CornerSize cornerSize) {
        Intrinsics.checkNotNullParameter(cornerSize, "corner");
        return new AbsoluteRoundedCornerShape(cornerSize, cornerSize, cornerSize, cornerSize);
    }

    public static /* synthetic */ AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape$default(float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 2) != 0) {
            f12 = 0.0f;
        }
        if ((i11 & 4) != 0) {
            f13 = 0.0f;
        }
        if ((i11 & 8) != 0) {
            f14 = 0.0f;
        }
        return AbsoluteRoundedCornerShape(f11, f12, f13, f14);
    }

    @NotNull
    /* renamed from: AbsoluteRoundedCornerShape-0680j_4  reason: not valid java name */
    public static final AbsoluteRoundedCornerShape m800AbsoluteRoundedCornerShape0680j_4(float f11) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.m806CornerSize0680j_4(f11));
    }

    @NotNull
    /* renamed from: AbsoluteRoundedCornerShape-a9UjIt4  reason: not valid java name */
    public static final AbsoluteRoundedCornerShape m801AbsoluteRoundedCornerShapea9UjIt4(float f11, float f12, float f13, float f14) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.m806CornerSize0680j_4(f11), CornerSizeKt.m806CornerSize0680j_4(f12), CornerSizeKt.m806CornerSize0680j_4(f13), CornerSizeKt.m806CornerSize0680j_4(f14));
    }

    /* renamed from: AbsoluteRoundedCornerShape-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ AbsoluteRoundedCornerShape m802AbsoluteRoundedCornerShapea9UjIt4$default(float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 4) != 0) {
            f13 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 8) != 0) {
            f14 = Dp.m5478constructorimpl((float) 0);
        }
        return m801AbsoluteRoundedCornerShapea9UjIt4(f11, f12, f13, f14);
    }

    @NotNull
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(float f11) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(f11));
    }

    public static /* synthetic */ AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape$default(int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = 0;
        }
        if ((i15 & 2) != 0) {
            i12 = 0;
        }
        if ((i15 & 4) != 0) {
            i13 = 0;
        }
        if ((i15 & 8) != 0) {
            i14 = 0;
        }
        return AbsoluteRoundedCornerShape(i11, i12, i13, i14);
    }

    @NotNull
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(int i11) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(i11));
    }

    @NotNull
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(float f11, float f12, float f13, float f14) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(f11), CornerSizeKt.CornerSize(f12), CornerSizeKt.CornerSize(f13), CornerSizeKt.CornerSize(f14));
    }

    @NotNull
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(int i11, int i12, int i13, int i14) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(i11), CornerSizeKt.CornerSize(i12), CornerSizeKt.CornerSize(i13), CornerSizeKt.CornerSize(i14));
    }
}
