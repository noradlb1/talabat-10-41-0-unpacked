package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/text/input/TextFieldValue;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldState$onValueChange$1 extends Lambda implements Function1<TextFieldValue, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3620g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldState$onValueChange$1(TextFieldState textFieldState) {
        super(1);
        this.f3620g = textFieldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "it");
        String text = textFieldValue.getText();
        AnnotatedString untransformedText = this.f3620g.getUntransformedText();
        if (!Intrinsics.areEqual((Object) text, (Object) untransformedText != null ? untransformedText.getText() : null)) {
            this.f3620g.setHandleState(HandleState.None);
        }
        this.f3620g.onValueChangeOriginal.invoke(textFieldValue);
        this.f3620g.getRecomposeScope().invalidate();
    }
}
