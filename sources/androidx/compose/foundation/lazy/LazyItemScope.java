package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Stable
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'ø\u0001\u0000J\u0016\u0010\u0007\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH&J\u0016\u0010\u000b\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH&ø\u0001\u0001\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/LazyItemScope;", "", "animateItemPlacement", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "fillParentMaxHeight", "fraction", "", "fillParentMaxSize", "fillParentMaxWidth", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@LazyScopeMarker
public interface LazyItemScope {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
    }

    @NotNull
    @ExperimentalFoundationApi
    Modifier animateItemPlacement(@NotNull Modifier modifier, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec);

    @NotNull
    Modifier fillParentMaxHeight(@NotNull Modifier modifier, float f11);

    @NotNull
    Modifier fillParentMaxSize(@NotNull Modifier modifier, float f11);

    @NotNull
    Modifier fillParentMaxWidth(@NotNull Modifier modifier, float f11);
}
