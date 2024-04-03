package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"collectIsPressedAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PressInteractionKt {
    @NotNull
    @Composable
    public static final State<Boolean> collectIsPressedAsState(@NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(interactionSource, "<this>");
        composer.startReplaceableGroup(-1692965168);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1692965168, i11, -1, "androidx.compose.foundation.interaction.collectIsPressedAsState (PressInteraction.kt:83)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        int i12 = i11 & 14;
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed((Object) interactionSource) | composer.changed((Object) mutableState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new PressInteractionKt$collectIsPressedAsState$1$1(interactionSource, mutableState, (Continuation<? super PressInteractionKt$collectIsPressedAsState$1$1>) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect((Object) interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, composer, i12 | 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }
}
