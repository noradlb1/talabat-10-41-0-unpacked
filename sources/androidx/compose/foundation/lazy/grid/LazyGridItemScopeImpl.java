package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0017ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "()V", "animateItemPlacement", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyGridItemScopeImpl implements LazyGridItemScope {
    @NotNull
    public static final LazyGridItemScopeImpl INSTANCE = new LazyGridItemScopeImpl();

    private LazyGridItemScopeImpl() {
    }

    @NotNull
    @ExperimentalFoundationApi
    public Modifier animateItemPlacement(@NotNull Modifier modifier, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new LazyGridItemScopeImpl$animateItemPlacement$$inlined$debugInspectorInfo$1(finiteAnimationSpec);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new AnimateItemPlacementModifier(finiteAnimationSpec, function1));
    }
}
