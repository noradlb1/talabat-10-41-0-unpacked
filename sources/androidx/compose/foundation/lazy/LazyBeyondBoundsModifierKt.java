package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a)\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"unsupportedDirection", "", "lazyListBeyondBoundsModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "reverseLayout", "", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyBeyondBoundsModifierKt {
    @NotNull
    @Composable
    public static final Modifier lazyListBeyondBoundsModifier(@NotNull Modifier modifier, @NotNull LazyListState lazyListState, @NotNull LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, boolean z11, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(lazyListBeyondBoundsInfo, "beyondBoundsInfo");
        composer.startReplaceableGroup(1245943849);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1245943849, i11, -1, "androidx.compose.foundation.lazy.lazyListBeyondBoundsModifier (LazyBeyondBoundsModifier.kt:44)");
        }
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        Object[] objArr = {lazyListState, lazyListBeyondBoundsInfo, Boolean.valueOf(z11), layoutDirection};
        composer.startReplaceableGroup(-568225417);
        boolean z12 = false;
        for (int i12 = 0; i12 < 4; i12++) {
            z12 |= composer.changed(objArr[i12]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z12 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyListBeyondBoundsModifierLocal(lazyListState, lazyListBeyondBoundsInfo, z11, layoutDirection);
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

    /* access modifiers changed from: private */
    public static final Void unsupportedDirection() {
        throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction".toString());
    }
}
