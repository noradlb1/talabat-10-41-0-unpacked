package com.checkout.frames.utils.extensions;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0013\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0003\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"rememberKeyboardOpenState", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "clearFocusOnKeyboardDismiss", "Landroidx/compose/ui/Modifier;", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ModifierExtensionsKt {
    @NotNull
    public static final Modifier clearFocusOnKeyboardDismiss(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed$default(modifier, (Function1) null, ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1.INSTANCE, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    @Composable
    public static final State<Boolean> rememberKeyboardOpenState(Composer composer, int i11) {
        composer.startReplaceableGroup(-1991578361);
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        State<Boolean> produceState = SnapshotStateKt.produceState(Boolean.valueOf(ViewExtensionsKt.isKeyboardOpen(view)), new ModifierExtensionsKt$rememberKeyboardOpenState$1$1(view, (Continuation<? super ModifierExtensionsKt$rememberKeyboardOpenState$1$1>) null), composer, 64);
        composer.endReplaceableGroup();
        return produceState;
    }
}
