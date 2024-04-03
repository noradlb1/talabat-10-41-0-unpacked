package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u000bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slotSizesSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @ExperimentalFoundationApi
    @Composable
    public static final void LazyStaggeredGrid(@NotNull LazyStaggeredGridState lazyStaggeredGridState, @NotNull Orientation orientation, @NotNull Function2<? super Density, ? super Constraints, int[]> function2, @Nullable Modifier modifier, @Nullable PaddingValues paddingValues, boolean z11, @Nullable FlingBehavior flingBehavior, boolean z12, @Nullable Arrangement.Vertical vertical, @Nullable Arrangement.Horizontal horizontal, @NotNull Function1<? super LazyStaggeredGridScope, Unit> function1, @Nullable Composer composer, int i11, int i12, int i13) {
        FlingBehavior flingBehavior2;
        int i14;
        LazyStaggeredGridState lazyStaggeredGridState2 = lazyStaggeredGridState;
        Function1<? super LazyStaggeredGridScope, Unit> function12 = function1;
        int i15 = i12;
        int i16 = i13;
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState2, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(function2, "slotSizesSums");
        Intrinsics.checkNotNullParameter(function12, "content");
        Composer startRestartGroup = composer.startRestartGroup(845690866);
        Modifier.Companion companion = (i16 & 8) != 0 ? Modifier.Companion : modifier;
        PaddingValues r16 = (i16 & 16) != 0 ? PaddingKt.m479PaddingValues0680j_4(Dp.m5478constructorimpl((float) 0)) : paddingValues;
        boolean z13 = (i16 & 32) != 0 ? false : z11;
        if ((i16 & 64) != 0) {
            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
            i14 = i11 & -3670017;
        } else {
            flingBehavior2 = flingBehavior;
            i14 = i11;
        }
        boolean z14 = (i16 & 128) != 0 ? true : z12;
        Arrangement.Vertical top = (i16 & 256) != 0 ? Arrangement.INSTANCE.getTop() : vertical;
        Arrangement.Horizontal start = (i16 & 512) != 0 ? Arrangement.INSTANCE.getStart() : horizontal;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(845690866, i14, i15, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:39)");
        }
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        OverscrollEffect overscrollEffect = scrollableDefaults.overscrollEffect(startRestartGroup, 6);
        LazyLayoutItemProvider rememberStaggeredGridItemProvider = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProvider(lazyStaggeredGridState2, function12, startRestartGroup, ((i15 << 3) & 112) | 8);
        int i17 = i14 >> 6;
        int i18 = i14 >> 9;
        int i19 = i18;
        LazyLayoutItemProvider lazyLayoutItemProvider = rememberStaggeredGridItemProvider;
        OverscrollEffect overscrollEffect2 = overscrollEffect;
        boolean z15 = z13;
        Modifier modifier2 = companion;
        Composer composer2 = startRestartGroup;
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> rememberStaggeredGridMeasurePolicy = LazyStaggeredGridMeasurePolicyKt.rememberStaggeredGridMeasurePolicy(lazyStaggeredGridState, rememberStaggeredGridItemProvider, r16, z13, orientation, top, start, function2, overscrollEffect2, startRestartGroup, (i17 & 7168) | (i17 & 896) | 8 | ((i14 << 9) & 57344) | (i18 & Opcodes.ASM7) | (i18 & 3670016) | ((i14 << 15) & 29360128));
        LazyLayoutSemanticState rememberLazyStaggeredGridSemanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState2, lazyLayoutItemProvider, z15, startRestartGroup, (i19 & 896) | 8);
        ScrollPositionUpdater(lazyLayoutItemProvider, lazyStaggeredGridState2, startRestartGroup, 64);
        Modifier then = modifier2.then(lazyStaggeredGridState.getRemeasurementModifier$foundation_release());
        Modifier modifier3 = modifier2;
        Orientation orientation2 = orientation;
        OverscrollEffect overscrollEffect3 = overscrollEffect2;
        LazyLayoutKt.LazyLayout(lazyLayoutItemProvider, LazyLayoutSemanticsKt.lazyLayoutSemantics(ScrollableKt.scrollable(OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(then, orientation2), overscrollEffect3), lazyStaggeredGridState, orientation, overscrollEffect3, z14, scrollableDefaults.reverseDirection((LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation2, z15), flingBehavior2, lazyStaggeredGridState.getMutableInteractionSource$foundation_release()), lazyLayoutItemProvider, rememberLazyStaggeredGridSemanticState, orientation, z14, startRestartGroup, ((i14 << 6) & 7168) | (i19 & 57344)), lazyStaggeredGridState.getPrefetchState$foundation_release(), rememberStaggeredGridMeasurePolicy, startRestartGroup, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            LazyStaggeredGridKt$LazyStaggeredGrid$1 lazyStaggeredGridKt$LazyStaggeredGrid$1 = r0;
            LazyStaggeredGridKt$LazyStaggeredGrid$1 lazyStaggeredGridKt$LazyStaggeredGrid$12 = new LazyStaggeredGridKt$LazyStaggeredGrid$1(lazyStaggeredGridState, orientation, function2, modifier3, r16, z15, flingBehavior2, z14, top, start, function1, i11, i12, i13);
            endRestartGroup.updateScope(lazyStaggeredGridKt$LazyStaggeredGrid$1);
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void ScrollPositionUpdater(LazyLayoutItemProvider lazyLayoutItemProvider, LazyStaggeredGridState lazyStaggeredGridState, Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(231106410);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231106410, i11, -1, "androidx.compose.foundation.lazy.staggeredgrid.ScrollPositionUpdater (LazyStaggeredGrid.kt:114)");
        }
        if (lazyLayoutItemProvider.getItemCount() > 0) {
            lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyLayoutItemProvider);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyStaggeredGridKt$ScrollPositionUpdater$1(lazyLayoutItemProvider, lazyStaggeredGridState, i11));
        }
    }
}
