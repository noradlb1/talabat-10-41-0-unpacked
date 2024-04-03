package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/LimitInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "(Landroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getSides-JoeWqyM", "()I", "I", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
final class LimitInsets implements WindowInsets {
    @NotNull
    private final WindowInsets insets;
    private final int sides;

    private LimitInsets(WindowInsets windowInsets, int i11) {
        this.insets = windowInsets;
        this.sides = i11;
    }

    public /* synthetic */ LimitInsets(WindowInsets windowInsets, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsets, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitInsets)) {
            return false;
        }
        LimitInsets limitInsets = (LimitInsets) obj;
        if (!Intrinsics.areEqual((Object) this.insets, (Object) limitInsets.insets) || !WindowInsetsSides.m589equalsimpl0(this.sides, limitInsets.sides)) {
            return false;
        }
        return true;
    }

    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        if (WindowInsetsSides.m590hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.m601getBottomJoeWqyM())) {
            return this.insets.getBottom(density);
        }
        return 0;
    }

    @NotNull
    public final WindowInsets getInsets() {
        return this.insets;
    }

    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        int i11;
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            i11 = WindowInsetsSides.Companion.m597getAllowLeftInLtrJoeWqyM$foundation_layout_release();
        } else {
            i11 = WindowInsetsSides.Companion.m598getAllowLeftInRtlJoeWqyM$foundation_layout_release();
        }
        if (WindowInsetsSides.m590hasAnybkgdKaI$foundation_layout_release(this.sides, i11)) {
            return this.insets.getLeft(density, layoutDirection);
        }
        return 0;
    }

    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        int i11;
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            i11 = WindowInsetsSides.Companion.m599getAllowRightInLtrJoeWqyM$foundation_layout_release();
        } else {
            i11 = WindowInsetsSides.Companion.m600getAllowRightInRtlJoeWqyM$foundation_layout_release();
        }
        if (WindowInsetsSides.m590hasAnybkgdKaI$foundation_layout_release(this.sides, i11)) {
            return this.insets.getRight(density, layoutDirection);
        }
        return 0;
    }

    /* renamed from: getSides-JoeWqyM  reason: not valid java name */
    public final int m461getSidesJoeWqyM() {
        return this.sides;
    }

    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        if (WindowInsetsSides.m590hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.m607getTopJoeWqyM())) {
            return this.insets.getTop(density);
        }
        return 0;
    }

    public int hashCode() {
        return (this.insets.hashCode() * 31) + WindowInsetsSides.m591hashCodeimpl(this.sides);
    }

    @NotNull
    public String toString() {
        return '(' + this.insets + " only " + WindowInsetsSides.m593toStringimpl(this.sides) + ')';
    }
}
