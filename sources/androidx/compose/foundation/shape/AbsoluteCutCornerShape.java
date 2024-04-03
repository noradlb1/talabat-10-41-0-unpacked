package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016JE\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topLeft", "Landroidx/compose/foundation/shape/CornerSize;", "topRight", "bottomRight", "bottomLeft", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "copy", "topStart", "topEnd", "bottomEnd", "bottomStart", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AbsoluteCutCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbsoluteCutCornerShape(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
        Intrinsics.checkNotNullParameter(cornerSize, "topLeft");
        Intrinsics.checkNotNullParameter(cornerSize2, "topRight");
        Intrinsics.checkNotNullParameter(cornerSize3, "bottomRight");
        Intrinsics.checkNotNullParameter(cornerSize4, "bottomLeft");
    }

    @NotNull
    /* renamed from: createOutline-LjSzlW0  reason: not valid java name */
    public Outline m794createOutlineLjSzlW0(long j11, float f11, float f12, float f13, float f14, @NotNull LayoutDirection layoutDirection) {
        boolean z11;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (f11 + f12 + f14 + f13 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new Outline.Rectangle(SizeKt.m2766toRectuvyYCjk(j11));
        }
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(0.0f, f11);
        Path.lineTo(f11, 0.0f);
        Path.lineTo(Size.m2745getWidthimpl(j11) - f12, 0.0f);
        Path.lineTo(Size.m2745getWidthimpl(j11), f12);
        Path.lineTo(Size.m2745getWidthimpl(j11), Size.m2742getHeightimpl(j11) - f13);
        Path.lineTo(Size.m2745getWidthimpl(j11) - f13, Size.m2742getHeightimpl(j11));
        Path.lineTo(f14, Size.m2742getHeightimpl(j11));
        Path.lineTo(0.0f, Size.m2742getHeightimpl(j11) - f14);
        Path.close();
        return new Outline.Generic(Path);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbsoluteCutCornerShape)) {
            return false;
        }
        AbsoluteCutCornerShape absoluteCutCornerShape = (AbsoluteCutCornerShape) obj;
        if (Intrinsics.areEqual((Object) getTopStart(), (Object) absoluteCutCornerShape.getTopStart()) && Intrinsics.areEqual((Object) getTopEnd(), (Object) absoluteCutCornerShape.getTopEnd()) && Intrinsics.areEqual((Object) getBottomEnd(), (Object) absoluteCutCornerShape.getBottomEnd()) && Intrinsics.areEqual((Object) getBottomStart(), (Object) absoluteCutCornerShape.getBottomStart())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    @NotNull
    public String toString() {
        return "AbsoluteCutCornerShape(topLeft = " + getTopStart() + ", topRight = " + getTopEnd() + ", bottomRight = " + getBottomEnd() + ", bottomLeft = " + getBottomStart() + ')';
    }

    @NotNull
    public AbsoluteCutCornerShape copy(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        Intrinsics.checkNotNullParameter(cornerSize, "topStart");
        Intrinsics.checkNotNullParameter(cornerSize2, "topEnd");
        Intrinsics.checkNotNullParameter(cornerSize3, "bottomEnd");
        Intrinsics.checkNotNullParameter(cornerSize4, "bottomStart");
        return new AbsoluteCutCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }
}
