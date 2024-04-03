package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"lazyLayoutSemantics", "Landroidx/compose/ui/Modifier;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutSemanticsKt {
    @NotNull
    @Composable
    public static final Modifier lazyLayoutSemantics(@NotNull Modifier modifier, @NotNull LazyLayoutItemProvider lazyLayoutItemProvider, @NotNull LazyLayoutSemanticState lazyLayoutSemanticState, @NotNull Orientation orientation, boolean z11, @Nullable Composer composer, int i11) {
        boolean z12;
        LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1 lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1;
        LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1 lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1;
        Modifier modifier2 = modifier;
        LazyLayoutItemProvider lazyLayoutItemProvider2 = lazyLayoutItemProvider;
        LazyLayoutSemanticState lazyLayoutSemanticState2 = lazyLayoutSemanticState;
        Orientation orientation2 = orientation;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier2, "<this>");
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider2, "itemProvider");
        Intrinsics.checkNotNullParameter(lazyLayoutSemanticState2, "state");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        composer2.startReplaceableGroup(1548174271);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1548174271, i11, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutSemantics (LazyLayoutSemantics.kt:39)");
        }
        composer2.startReplaceableGroup(773894976);
        composer2.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
            composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        Object[] objArr = {lazyLayoutItemProvider2, lazyLayoutSemanticState2, orientation2, Boolean.valueOf(z11)};
        composer2.startReplaceableGroup(-568225417);
        boolean z13 = false;
        for (int i12 = 0; i12 < 4; i12++) {
            z13 |= composer2.changed(objArr[i12]);
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (z13 || rememberedValue2 == Composer.Companion.getEmpty()) {
            if (orientation2 == Orientation.Vertical) {
                z12 = true;
            } else {
                z12 = false;
            }
            LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1 lazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1 = new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1(lazyLayoutItemProvider2);
            ScrollAxisRange scrollAxisRange = lazyLayoutSemanticState.scrollAxisRange();
            if (z11) {
                lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1 = new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1(z12, coroutineScope, lazyLayoutSemanticState2);
            } else {
                lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1 = null;
            }
            if (z11) {
                lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1 = new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1(lazyLayoutItemProvider2, coroutineScope, lazyLayoutSemanticState2);
            } else {
                lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1 = null;
            }
            rememberedValue2 = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$1(lazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1, z12, scrollAxisRange, lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1, lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1, lazyLayoutSemanticState.collectionInfo()), 1, (Object) null);
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier then = modifier2.then((Modifier) rememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
