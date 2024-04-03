package com.designsystem.ds_input_field;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$InputField$1$1$1 extends Lambda implements Function1<KeyboardActionScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31615g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<TextFieldValue> f31616h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$InputField$1$1$1(Function1<? super String, Unit> function1, MutableState<TextFieldValue> mutableState) {
        super(1);
        this.f31615g = function1;
        this.f31616h = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyboardActionScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull KeyboardActionScope keyboardActionScope) {
        Intrinsics.checkNotNullParameter(keyboardActionScope, "$this$KeyboardActions");
        Function1<String, Unit> function1 = this.f31615g;
        if (function1 != null) {
            function1.invoke(InputFieldCommonComposablesKt.m8419InputField_mytMHeg$lambda2(this.f31616h).getText());
        }
    }
}
