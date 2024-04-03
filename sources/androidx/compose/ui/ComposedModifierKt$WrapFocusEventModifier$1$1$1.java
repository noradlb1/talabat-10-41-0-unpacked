package androidx.compose.ui;

import androidx.compose.ui.focus.FocusEventModifierLocal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposedModifierKt$WrapFocusEventModifier$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FocusEventModifierLocal f9551g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposedModifierKt$WrapFocusEventModifier$1$1$1(FocusEventModifierLocal focusEventModifierLocal) {
        super(0);
        this.f9551g = focusEventModifierLocal;
    }

    public final void invoke() {
        this.f9551g.notifyIfNoFocusModifiers();
    }
}
