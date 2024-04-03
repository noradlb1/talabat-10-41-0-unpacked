package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "invoke-KlQnJC8", "(I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldState$onImeActionPerformed$1 extends Lambda implements Function1<ImeAction, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3619g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldState$onImeActionPerformed$1(TextFieldState textFieldState) {
        super(1);
        this.f3619g = textFieldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m929invokeKlQnJC8(((ImeAction) obj).m5186unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-KlQnJC8  reason: not valid java name */
    public final void m929invokeKlQnJC8(int i11) {
        this.f3619g.keyboardActionRunner.m855runActionKlQnJC8(i11);
    }
}
