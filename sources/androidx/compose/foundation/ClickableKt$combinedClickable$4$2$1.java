package androidx.compose.foundation;

import a0.a;
import a0.b;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ClickableKt$combinedClickable$4$2$1 implements ModifierLocalConsumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f1571b;

    public ClickableKt$combinedClickable$4$2$1(MutableState<Boolean> mutableState) {
        this.f1571b = mutableState;
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

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        this.f1571b.setValue(modifierLocalReadScope.getCurrent(ScrollableKt.getModifierLocalScrollableContainer()));
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
