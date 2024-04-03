package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/layout/ExcludeInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "included", "excluded", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/WindowInsets;)V", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
final class ExcludeInsets implements WindowInsets {
    @NotNull
    private final WindowInsets excluded;
    @NotNull
    private final WindowInsets included;

    public ExcludeInsets(@NotNull WindowInsets windowInsets, @NotNull WindowInsets windowInsets2) {
        Intrinsics.checkNotNullParameter(windowInsets, "included");
        Intrinsics.checkNotNullParameter(windowInsets2, "excluded");
        this.included = windowInsets;
        this.excluded = windowInsets2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExcludeInsets)) {
            return false;
        }
        ExcludeInsets excludeInsets = (ExcludeInsets) obj;
        if (!Intrinsics.areEqual((Object) excludeInsets.included, (Object) this.included) || !Intrinsics.areEqual((Object) excludeInsets.excluded, (Object) this.excluded)) {
            return false;
        }
        return true;
    }

    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return RangesKt___RangesKt.coerceAtLeast(this.included.getBottom(density) - this.excluded.getBottom(density), 0);
    }

    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return RangesKt___RangesKt.coerceAtLeast(this.included.getLeft(density, layoutDirection) - this.excluded.getLeft(density, layoutDirection), 0);
    }

    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return RangesKt___RangesKt.coerceAtLeast(this.included.getRight(density, layoutDirection) - this.excluded.getRight(density, layoutDirection), 0);
    }

    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return RangesKt___RangesKt.coerceAtLeast(this.included.getTop(density) - this.excluded.getTop(density), 0);
    }

    public int hashCode() {
        return (this.included.hashCode() * 31) + this.excluded.hashCode();
    }

    @NotNull
    public String toString() {
        return '(' + this.included + " - " + this.excluded + ')';
    }
}
