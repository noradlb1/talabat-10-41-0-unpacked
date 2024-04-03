package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/FixedDpInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "leftDp", "Landroidx/compose/ui/unit/Dp;", "topDp", "rightDp", "bottomDp", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class FixedDpInsets implements WindowInsets {
    private final float bottomDp;
    private final float leftDp;
    private final float rightDp;
    private final float topDp;

    private FixedDpInsets(float f11, float f12, float f13, float f14) {
        this.leftDp = f11;
        this.topDp = f12;
        this.rightDp = f13;
        this.bottomDp = f14;
    }

    public /* synthetic */ FixedDpInsets(float f11, float f12, float f13, float f14, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDpInsets)) {
            return false;
        }
        FixedDpInsets fixedDpInsets = (FixedDpInsets) obj;
        if (!Dp.m5483equalsimpl0(this.leftDp, fixedDpInsets.leftDp) || !Dp.m5483equalsimpl0(this.topDp, fixedDpInsets.topDp) || !Dp.m5483equalsimpl0(this.rightDp, fixedDpInsets.rightDp) || !Dp.m5483equalsimpl0(this.bottomDp, fixedDpInsets.bottomDp)) {
            return false;
        }
        return true;
    }

    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return density.m5441roundToPx0680j_4(this.bottomDp);
    }

    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.m5441roundToPx0680j_4(this.leftDp);
    }

    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.m5441roundToPx0680j_4(this.rightDp);
    }

    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return density.m5441roundToPx0680j_4(this.topDp);
    }

    public int hashCode() {
        return (((((Dp.m5484hashCodeimpl(this.leftDp) * 31) + Dp.m5484hashCodeimpl(this.topDp)) * 31) + Dp.m5484hashCodeimpl(this.rightDp)) * 31) + Dp.m5484hashCodeimpl(this.bottomDp);
    }

    @NotNull
    public String toString() {
        return "Insets(left=" + Dp.m5489toStringimpl(this.leftDp) + ", top=" + Dp.m5489toStringimpl(this.topDp) + ", right=" + Dp.m5489toStringimpl(this.rightDp) + ", bottom=" + Dp.m5489toStringimpl(this.bottomDp) + ')';
    }
}
