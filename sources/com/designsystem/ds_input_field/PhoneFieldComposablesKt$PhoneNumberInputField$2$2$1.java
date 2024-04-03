package com.designsystem.ds_input_field;

import androidx.compose.runtime.MutableState;
import com.designsystem.ds_input_field.country.DSCountryModel;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PhoneFieldComposablesKt$PhoneNumberInputField$2$2$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<DSCountryModel, String, Unit> f31810g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<DSCountryModel> f31811h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneFieldComposablesKt$PhoneNumberInputField$2$2$1(Function2<? super DSCountryModel, ? super String, Unit> function2, MutableState<DSCountryModel> mutableState) {
        super(1);
        this.f31810g = function2;
        this.f31811h = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_NUMBER_KEY);
        Function2<DSCountryModel, String, Unit> function2 = this.f31810g;
        if (function2 != null) {
            function2.invoke(PhoneFieldComposablesKt.m8455PhoneNumberInputField_4_mkn5s$lambda7(this.f31811h), str);
        }
    }
}
