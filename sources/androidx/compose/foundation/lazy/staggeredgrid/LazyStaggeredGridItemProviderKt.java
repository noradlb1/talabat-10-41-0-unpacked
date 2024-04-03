package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"rememberStaggeredGridItemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridItemProviderKt {
    @ExperimentalFoundationApi
    @NotNull
    @Composable
    public static final LazyLayoutItemProvider rememberStaggeredGridItemProvider(@NotNull LazyStaggeredGridState lazyStaggeredGridState, @NotNull Function1<? super LazyStaggeredGridScope, Unit> function1, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState, "state");
        Intrinsics.checkNotNullParameter(function1, "content");
        composer.startReplaceableGroup(290499291);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(290499291, i11, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProvider (LazyStaggeredGridItemProvider.kt:29)");
        }
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, (i11 >> 3) & 14);
        State<IntRange> rememberLazyNearestItemsRangeState = LazyNearestItemsRangeKt.rememberLazyNearestItemsRangeState(new LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$1(lazyStaggeredGridState), LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$2.INSTANCE, LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$3.INSTANCE, composer, 432);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) lazyStaggeredGridState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$1(SnapshotStateKt.derivedStateOf(new LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$itemProviderState$1(rememberUpdatedState, rememberLazyNearestItemsRangeState)));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$1 lazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$1 = (LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$1) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$1;
    }
}
