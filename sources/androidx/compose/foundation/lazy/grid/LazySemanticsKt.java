package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"rememberLazyGridSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "reverseScrolling", "", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazySemanticsKt {
    @NotNull
    @Composable
    public static final LazyLayoutSemanticState rememberLazyGridSemanticState(@NotNull LazyGridState lazyGridState, @NotNull LazyLayoutItemProvider lazyLayoutItemProvider, boolean z11, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(lazyGridState, "state");
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        composer.startReplaceableGroup(-1950437665);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1950437665, i11, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridSemanticState (LazySemantics.kt:30)");
        }
        Boolean valueOf = Boolean.valueOf(z11);
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed((Object) valueOf) | composer.changed((Object) lazyGridState) | composer.changed((Object) lazyLayoutItemProvider);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazySemanticsKt$rememberLazyGridSemanticState$1$1(z11, lazyGridState, lazyLayoutItemProvider);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazySemanticsKt$rememberLazyGridSemanticState$1$1 lazySemanticsKt$rememberLazyGridSemanticState$1$1 = (LazySemanticsKt$rememberLazyGridSemanticState$1$1) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazySemanticsKt$rememberLazyGridSemanticState$1$1;
    }
}
