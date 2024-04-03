package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BasicTextFieldKt$BasicTextField$3$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3271g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<TextFieldValue> f3272h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicTextFieldKt$BasicTextField$3$1(TextFieldValue textFieldValue, MutableState<TextFieldValue> mutableState) {
        super(0);
        this.f3271g = textFieldValue;
        this.f3272h = mutableState;
    }

    public final void invoke() {
        if (!TextRange.m5031equalsimpl0(this.f3271g.m5234getSelectiond9O1mEE(), BasicTextFieldKt.m825BasicTextField$lambda2(this.f3272h).m5234getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) this.f3271g.m5233getCompositionMzsxiRA(), (Object) BasicTextFieldKt.m825BasicTextField$lambda2(this.f3272h).m5233getCompositionMzsxiRA())) {
            BasicTextFieldKt.m826BasicTextField$lambda3(this.f3272h, this.f3271g);
        }
    }
}
