package androidx.compose.foundation.lazy.layout;

import android.view.View;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"LazyLayoutPrefetcher", "", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutPrefetcher_androidKt {
    @ExperimentalFoundationApi
    @Composable
    public static final void LazyLayoutPrefetcher(@NotNull LazyLayoutPrefetchState lazyLayoutPrefetchState, @NotNull LazyLayoutItemContentFactory lazyLayoutItemContentFactory, @NotNull SubcomposeLayoutState subcomposeLayoutState, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(lazyLayoutPrefetchState, "prefetchState");
        Intrinsics.checkNotNullParameter(lazyLayoutItemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(subcomposeLayoutState, "subcomposeLayoutState");
        Composer startRestartGroup = composer.startRestartGroup(1113453182);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1113453182, i11, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher (LazyLayoutPrefetcher.android.kt:35)");
        }
        View view = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
        int i12 = SubcomposeLayoutState.$stable;
        startRestartGroup.startReplaceableGroup(1618982084);
        boolean changed = startRestartGroup.changed((Object) subcomposeLayoutState) | startRestartGroup.changed((Object) lazyLayoutPrefetchState) | startRestartGroup.changed((Object) view);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            startRestartGroup.updateRememberedValue(new LazyLayoutPrefetcher(lazyLayoutPrefetchState, subcomposeLayoutState, lazyLayoutItemContentFactory, view));
        }
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2(lazyLayoutPrefetchState, lazyLayoutItemContentFactory, subcomposeLayoutState, i11));
        }
    }
}
