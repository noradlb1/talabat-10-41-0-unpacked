package com.designsystem.ds_input_field;

import com.designsystem.ds_input_field.country.DSCountryModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n"}, d2 = {"Lkotlin/Function1;", "Lcom/designsystem/ds_input_field/country/DSCountryModel;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PhoneInputCountriesFragment$onCountrySelected$2 extends Lambda implements Function0<Function1<? super DSCountryModel, ? extends Unit>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31887g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$onCountrySelected$2(PhoneInputCountriesFragment phoneInputCountriesFragment) {
        super(0);
        this.f31887g = phoneInputCountriesFragment;
    }

    @NotNull
    public final Function1<DSCountryModel, Unit> invoke() {
        Serializable serializable = this.f31887g.requireArguments().getSerializable("PHONE_INPUT_ON_COUNTRY_SELECTED");
        if (serializable != null) {
            return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(serializable, 1);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
