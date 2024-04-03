package com.designsystem.ds_input_field;

import com.designsystem.ds_input_field.country.DSCountryModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n"}, d2 = {"Ljava/util/ArrayList;", "Lcom/designsystem/ds_input_field/country/DSCountryModel;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PhoneInputCountriesFragment$countries$2 extends Lambda implements Function0<ArrayList<DSCountryModel>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31884g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$countries$2(PhoneInputCountriesFragment phoneInputCountriesFragment) {
        super(0);
        this.f31884g = phoneInputCountriesFragment;
    }

    @NotNull
    public final ArrayList<DSCountryModel> invoke() {
        ArrayList<DSCountryModel> parcelableArrayList = this.f31884g.requireArguments().getParcelableArrayList("PHONE_INPUT_COUNTRIES");
        if (parcelableArrayList != null) {
            return parcelableArrayList;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
