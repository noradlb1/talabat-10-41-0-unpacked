package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"lazyListPinningModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyListPinningModifierKt {
    @NotNull
    @Composable
    public static final Modifier lazyListPinningModifier(@NotNull Modifier modifier, @NotNull LazyListState lazyListState, @NotNull LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(lazyListBeyondBoundsInfo, "beyondBoundsInfo");
        composer.startReplaceableGroup(854917725);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(854917725, i11, -1, "androidx.compose.foundation.lazy.lazyListPinningModifier (LazyListPinningModifier.kt:34)");
        }
        int i12 = MutableVector.$stable;
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed((Object) lazyListState) | composer.changed((Object) lazyListBeyondBoundsInfo);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyListPinningModifier(lazyListState, lazyListBeyondBoundsInfo);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier then = modifier.then((Modifier) rememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
