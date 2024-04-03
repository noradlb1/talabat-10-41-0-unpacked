package com.designsystem.ds_input_field;

import com.designsystem.ds_input_field.country.DSCountryModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPhoneNumberField$Content$1 extends Lambda implements Function2<DSCountryModel, String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSPhoneNumberField f31438g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPhoneNumberField$Content$1(DSPhoneNumberField dSPhoneNumberField) {
        super(2);
        this.f31438g = dSPhoneNumberField;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((DSCountryModel) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable DSCountryModel dSCountryModel, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f31438g.setText(str);
        Function2<DSCountryModel, String, Unit> onTextChange = this.f31438g.getOnTextChange();
        if (onTextChange != null) {
            onTextChange.invoke(dSCountryModel, str);
        }
    }
}
