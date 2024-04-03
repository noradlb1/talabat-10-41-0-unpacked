package com.designsystem.ds_input_field;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPasswordField$Content$1$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSPasswordField f31416g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPasswordField$Content$1$1(DSPasswordField dSPasswordField) {
        super(1);
        this.f31416g = dSPasswordField;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.f31416g.setText(str);
        Function1<String, Unit> onTextChange = this.f31416g.getOnTextChange();
        if (onTextChange != null) {
            onTextChange.invoke(str);
        }
    }
}
