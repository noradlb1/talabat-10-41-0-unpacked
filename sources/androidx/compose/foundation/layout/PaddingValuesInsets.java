package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
final class PaddingValuesInsets implements WindowInsets {
    @NotNull
    private final PaddingValues paddingValues;

    public PaddingValuesInsets(@NotNull PaddingValues paddingValues2) {
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        this.paddingValues = paddingValues2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaddingValuesInsets)) {
            return false;
        }
        return Intrinsics.areEqual((Object) ((PaddingValuesInsets) obj).paddingValues, (Object) this.paddingValues);
    }

    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return density.m5441roundToPx0680j_4(this.paddingValues.m496calculateBottomPaddingD9Ej5fM());
    }

    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.m5441roundToPx0680j_4(this.paddingValues.m497calculateLeftPaddingu2uoSUM(layoutDirection));
    }

    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.m5441roundToPx0680j_4(this.paddingValues.m498calculateRightPaddingu2uoSUM(layoutDirection));
    }

    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return density.m5441roundToPx0680j_4(this.paddingValues.m499calculateTopPaddingD9Ej5fM());
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }

    @NotNull
    public String toString() {
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        float r12 = this.paddingValues.m497calculateLeftPaddingu2uoSUM(layoutDirection);
        float r22 = this.paddingValues.m499calculateTopPaddingD9Ej5fM();
        float r02 = this.paddingValues.m498calculateRightPaddingu2uoSUM(layoutDirection);
        float r32 = this.paddingValues.m496calculateBottomPaddingD9Ej5fM();
        return "PaddingValues(" + Dp.m5489toStringimpl(r12) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Dp.m5489toStringimpl(r22) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Dp.m5489toStringimpl(r02) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Dp.m5489toStringimpl(r32) + ')';
    }
}
