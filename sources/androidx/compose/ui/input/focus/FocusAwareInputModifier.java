package androidx.compose.ui.input.focus;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.focus.FocusDirectedInputEvent;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00000\u0004BG\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00000\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00000\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/input/focus/FocusAwareInputModifier;", "T", "Landroidx/compose/ui/input/focus/FocusDirectedInputEvent;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "onEvent", "Lkotlin/Function1;", "", "onPreEvent", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/modifier/ProvidableModifierLocal;)V", "focusAwareEventParent", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getOnEvent", "()Lkotlin/jvm/functions/Function1;", "getOnPreEvent", "value", "getValue", "()Landroidx/compose/ui/input/focus/FocusAwareInputModifier;", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "propagateEvent", "event", "(Landroidx/compose/ui/input/focus/FocusDirectedInputEvent;)Z", "propagateFocusAwareEvent", "propagatePreEvent", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class FocusAwareInputModifier<T extends FocusDirectedInputEvent> implements ModifierLocalConsumer, ModifierLocalProvider<FocusAwareInputModifier<T>> {
    @Nullable
    private FocusAwareInputModifier<T> focusAwareEventParent;
    @NotNull
    private final ProvidableModifierLocal<FocusAwareInputModifier<T>> key;
    @Nullable
    private final Function1<FocusDirectedInputEvent, Boolean> onEvent;
    @Nullable
    private final Function1<FocusDirectedInputEvent, Boolean> onPreEvent;

    public FocusAwareInputModifier(@Nullable Function1<? super FocusDirectedInputEvent, Boolean> function1, @Nullable Function1<? super FocusDirectedInputEvent, Boolean> function12, @NotNull ProvidableModifierLocal<FocusAwareInputModifier<T>> providableModifierLocal) {
        Intrinsics.checkNotNullParameter(providableModifierLocal, "key");
        this.onEvent = function1;
        this.onPreEvent = function12;
        this.key = providableModifierLocal;
    }

    private final boolean propagateEvent(T t11) {
        boolean z11;
        Function1<FocusDirectedInputEvent, Boolean> function1 = this.onEvent;
        if (function1 == null || !function1.invoke(t11).booleanValue()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return true;
        }
        FocusAwareInputModifier<T> focusAwareInputModifier = this.focusAwareEventParent;
        if (focusAwareInputModifier != null) {
            return focusAwareInputModifier.propagateEvent(t11);
        }
        return false;
    }

    private final boolean propagatePreEvent(T t11) {
        boolean z11;
        FocusAwareInputModifier<T> focusAwareInputModifier = this.focusAwareEventParent;
        if (focusAwareInputModifier == null || !focusAwareInputModifier.propagatePreEvent(t11)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return true;
        }
        Function1<FocusDirectedInputEvent, Boolean> function1 = this.onPreEvent;
        if (function1 != null) {
            return function1.invoke(t11).booleanValue();
        }
        return false;
    }

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
    public ProvidableModifierLocal<FocusAwareInputModifier<T>> getKey() {
        return this.key;
    }

    @Nullable
    public final Function1<FocusDirectedInputEvent, Boolean> getOnEvent() {
        return this.onEvent;
    }

    @Nullable
    public final Function1<FocusDirectedInputEvent, Boolean> getOnPreEvent() {
        return this.onPreEvent;
    }

    @NotNull
    public FocusAwareInputModifier<T> getValue() {
        return this;
    }

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        this.focusAwareEventParent = (FocusAwareInputModifier) modifierLocalReadScope.getCurrent(getKey());
    }

    public final boolean propagateFocusAwareEvent(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "event");
        if (propagatePreEvent(t11) || propagateEvent(t11)) {
            return true;
        }
        return false;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
