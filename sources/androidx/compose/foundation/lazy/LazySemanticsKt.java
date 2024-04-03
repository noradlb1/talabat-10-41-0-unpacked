package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"rememberLazyListSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "reverseScrolling", "", "isVertical", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazySemanticsKt {
    @NotNull
    @Composable
    public static final LazyLayoutSemanticState rememberLazyListSemanticState(@NotNull LazyListState lazyListState, @NotNull LazyLayoutItemProvider lazyLayoutItemProvider, boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        composer.startReplaceableGroup(1624527721);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1624527721, i11, -1, "androidx.compose.foundation.lazy.rememberLazyListSemanticState (LazySemantics.kt:30)");
        }
        Object[] objArr = {lazyListState, lazyLayoutItemProvider, Boolean.valueOf(z11), Boolean.valueOf(z12)};
        composer.startReplaceableGroup(-568225417);
        boolean z13 = false;
        for (int i12 = 0; i12 < 4; i12++) {
            z13 |= composer.changed(objArr[i12]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z13 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazySemanticsKt$rememberLazyListSemanticState$1$1(z11, lazyListState, lazyLayoutItemProvider, z12);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazySemanticsKt$rememberLazyListSemanticState$1$1 lazySemanticsKt$rememberLazyListSemanticState$1$1 = (LazySemanticsKt$rememberLazyListSemanticState$1$1) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazySemanticsKt$rememberLazyListSemanticState$1$1;
    }
}
