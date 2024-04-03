package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016JE\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/shape/RoundedCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "copy", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundedCornerShape(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
        Intrinsics.checkNotNullParameter(cornerSize, "topStart");
        Intrinsics.checkNotNullParameter(cornerSize2, "topEnd");
        Intrinsics.checkNotNullParameter(cornerSize3, "bottomEnd");
        Intrinsics.checkNotNullParameter(cornerSize4, "bottomStart");
    }

    @NotNull
    /* renamed from: createOutline-LjSzlW0  reason: not valid java name */
    public Outline m820createOutlineLjSzlW0(long j11, float f11, float f12, float f13, float f14, @NotNull LayoutDirection layoutDirection) {
        boolean z11;
        float f15;
        float f16;
        float f17;
        float f18;
        LayoutDirection layoutDirection2 = layoutDirection;
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        if (f11 + f12 + f13 + f14 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new Outline.Rectangle(SizeKt.m2766toRectuvyYCjk(j11));
        }
        Rect r32 = SizeKt.m2766toRectuvyYCjk(j11);
        LayoutDirection layoutDirection3 = LayoutDirection.Ltr;
        if (layoutDirection2 == layoutDirection3) {
            f15 = f11;
        } else {
            f15 = f12;
        }
        long CornerRadius$default = CornerRadiusKt.CornerRadius$default(f15, 0.0f, 2, (Object) null);
        if (layoutDirection2 == layoutDirection3) {
            f16 = f12;
        } else {
            f16 = f11;
        }
        long CornerRadius$default2 = CornerRadiusKt.CornerRadius$default(f16, 0.0f, 2, (Object) null);
        if (layoutDirection2 == layoutDirection3) {
            f17 = f13;
        } else {
            f17 = f14;
        }
        long CornerRadius$default3 = CornerRadiusKt.CornerRadius$default(f17, 0.0f, 2, (Object) null);
        if (layoutDirection2 == layoutDirection3) {
            f18 = f14;
        } else {
            f18 = f13;
        }
        return new Outline.Rounded(RoundRectKt.m2728RoundRectZAM2FJo(r32, CornerRadius$default, CornerRadius$default2, CornerRadius$default3, CornerRadiusKt.CornerRadius$default(f18, 0.0f, 2, (Object) null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundedCornerShape)) {
            return false;
        }
        RoundedCornerShape roundedCornerShape = (RoundedCornerShape) obj;
        if (Intrinsics.areEqual((Object) getTopStart(), (Object) roundedCornerShape.getTopStart()) && Intrinsics.areEqual((Object) getTopEnd(), (Object) roundedCornerShape.getTopEnd()) && Intrinsics.areEqual((Object) getBottomEnd(), (Object) roundedCornerShape.getBottomEnd()) && Intrinsics.areEqual((Object) getBottomStart(), (Object) roundedCornerShape.getBottomStart())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    @NotNull
    public String toString() {
        return "RoundedCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + ')';
    }

    @NotNull
    public RoundedCornerShape copy(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        Intrinsics.checkNotNullParameter(cornerSize, "topStart");
        Intrinsics.checkNotNullParameter(cornerSize2, "topEnd");
        Intrinsics.checkNotNullParameter(cornerSize3, "bottomEnd");
        Intrinsics.checkNotNullParameter(cornerSize4, "bottomStart");
        return new RoundedCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }
}
