package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BasicTextFieldKt$BasicTextField$4$1 extends Lambda implements Function1<TextFieldValue, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f3273g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<TextFieldValue> f3274h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<String> f3275i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicTextFieldKt$BasicTextField$4$1(Function1<? super String, Unit> function1, MutableState<TextFieldValue> mutableState, MutableState<String> mutableState2) {
        super(1);
        this.f3273g = function1;
        this.f3274h = mutableState;
        this.f3275i = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "newTextFieldValueState");
        BasicTextFieldKt.m826BasicTextField$lambda3(this.f3274h, textFieldValue);
        boolean z11 = !Intrinsics.areEqual((Object) BasicTextFieldKt.m827BasicTextField$lambda6(this.f3275i), (Object) textFieldValue.getText());
        BasicTextFieldKt.m828BasicTextField$lambda7(this.f3275i, textFieldValue.getText());
        if (z11) {
            this.f3273g.invoke(textFieldValue.getText());
        }
    }
}
