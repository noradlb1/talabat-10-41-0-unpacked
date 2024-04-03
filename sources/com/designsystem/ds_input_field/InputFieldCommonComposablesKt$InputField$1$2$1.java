package com.designsystem.ds_input_field;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$InputField$1$2$1 extends Lambda implements Function1<TextFieldValue, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, TextFieldValue> f31617g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f31618h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31619i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<TextFieldValue> f31620j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f31621k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$InputField$1$2$1(Function1<? super TextFieldValue, TextFieldValue> function1, Integer num, Function1<? super String, Unit> function12, MutableState<TextFieldValue> mutableState, MutableState<Integer> mutableState2) {
        super(1);
        this.f31617g = function1;
        this.f31618h = num;
        this.f31619i = function12;
        this.f31620j = mutableState;
        this.f31621k = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.invoke(r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.TextFieldValue r9) {
        /*
            r8 = this;
            java.lang.String r0 = "changedText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.input.TextFieldValue, androidx.compose.ui.text.input.TextFieldValue> r0 = r8.f31617g
            if (r0 != 0) goto L_0x000a
            goto L_0x0012
        L_0x000a:
            java.lang.Object r0 = r0.invoke(r9)
            androidx.compose.ui.text.input.TextFieldValue r0 = (androidx.compose.ui.text.input.TextFieldValue) r0
            if (r0 != 0) goto L_0x0014
        L_0x0012:
            r1 = r9
            goto L_0x0015
        L_0x0014:
            r1 = r0
        L_0x0015:
            java.lang.Integer r9 = r8.f31618h
            if (r9 == 0) goto L_0x0030
            java.lang.String r9 = r1.getText()
            java.lang.Integer r0 = r8.f31618h
            int r0 = r0.intValue()
            java.lang.String r2 = kotlin.text.StringsKt___StringsKt.take((java.lang.String) r9, (int) r0)
            r3 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            androidx.compose.ui.text.input.TextFieldValue r1 = androidx.compose.ui.text.input.TextFieldValue.m5230copy3r_uNRQ$default((androidx.compose.ui.text.input.TextFieldValue) r1, (java.lang.String) r2, (long) r3, (androidx.compose.ui.text.TextRange) r5, (int) r6, (java.lang.Object) r7)
        L_0x0030:
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r9 = r8.f31620j
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8420InputField_mytMHeg$lambda3(r9, r1)
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r9 = r8.f31619i
            if (r9 != 0) goto L_0x003a
            goto L_0x0041
        L_0x003a:
            java.lang.String r0 = r1.getText()
            r9.invoke(r0)
        L_0x0041:
            androidx.compose.runtime.MutableState<java.lang.Integer> r9 = r8.f31621k
            java.lang.String r0 = r1.getText()
            int r0 = r0.length()
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8416InputField_mytMHeg$lambda12(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1$2$1.invoke(androidx.compose.ui.text.input.TextFieldValue):void");
    }
}
