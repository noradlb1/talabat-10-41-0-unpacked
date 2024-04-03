package androidx.compose.ui.focus;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001R\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/compose/ui/focus/FocusModifierKt$ResetFocusModifierLocals$3", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FocusModifierKt$ResetFocusModifierLocals$3 implements ModifierLocalProvider<FocusRequesterModifierLocal> {
    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public ProvidableModifierLocal<FocusRequesterModifierLocal> getKey() {
        return FocusRequesterModifierKt.getModifierLocalFocusRequester();
    }

    @Nullable
    public FocusRequesterModifierLocal getValue() {
        return null;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
