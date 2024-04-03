package com.designsystem.ds_input_field;

import com.designsystem.ds_input_field.country.DSCountryModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/designsystem/ds_input_field/country/DSCountryModel;", "country", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PhoneFieldComposablesKt$showCountryPicker$1$3 extends Lambda implements Function1<DSCountryModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<DSCountryModel, Unit> f31860g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneFieldComposablesKt$showCountryPicker$1$3(Function1<? super DSCountryModel, Unit> function1) {
        super(1);
        this.f31860g = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DSCountryModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DSCountryModel dSCountryModel) {
        Intrinsics.checkNotNullParameter(dSCountryModel, "country");
        this.f31860g.invoke(dSCountryModel);
    }
}
