package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BasicTextFieldKt$BasicTextField$8$1 extends Lambda implements Function1<TextFieldValue, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3294g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, Unit> f3295h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicTextFieldKt$BasicTextField$8$1(TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1) {
        super(1);
        this.f3294g = textFieldValue;
        this.f3295h = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "it");
        if (!Intrinsics.areEqual((Object) this.f3294g, (Object) textFieldValue)) {
            this.f3295h.invoke(textFieldValue);
        }
    }
}
