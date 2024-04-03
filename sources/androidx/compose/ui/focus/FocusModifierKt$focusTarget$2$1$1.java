package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FocusModifierKt$focusTarget$2$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FocusModifier f9596g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusModifierKt$focusTarget$2$1$1(FocusModifier focusModifier) {
        super(0);
        this.f9596g = focusModifier;
    }

    public final void invoke() {
        FocusTransactionsKt.sendOnFocusEvent(this.f9596g);
    }
}
