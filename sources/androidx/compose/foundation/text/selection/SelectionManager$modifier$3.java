package androidx.compose.foundation.text.selection;

import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "focusState", "Landroidx/compose/ui/focus/FocusState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionManager$modifier$3 extends Lambda implements Function1<FocusState, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SelectionManager f3722g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionManager$modifier$3(SelectionManager selectionManager) {
        super(1);
        this.f3722g = selectionManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (!focusState.isFocused() && this.f3722g.getHasFocus()) {
            this.f3722g.onRelease();
        }
        this.f3722g.setHasFocus(focusState.isFocused());
    }
}
