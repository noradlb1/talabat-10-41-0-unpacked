package com.designsystem.ds_input_field;

import com.designsystem.ds_input_field.country.DSCountryModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PhoneInputCountriesFragment$CountrySearchField$1$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31881g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$CountrySearchField$1$1(PhoneInputCountriesFragment phoneInputCountriesFragment) {
        super(1);
        this.f31881g = phoneInputCountriesFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        PhoneInputCountriesFragment phoneInputCountriesFragment = this.f31881g;
        PhoneInputCountriesFragment phoneInputCountriesFragment2 = this.f31881g;
        ArrayList arrayList = new ArrayList();
        for (Object next : phoneInputCountriesFragment.getCountries()) {
            DSCountryModel dSCountryModel = (DSCountryModel) next;
            boolean z11 = true;
            if (!(str.length() == 0)) {
                z11 = phoneInputCountriesFragment2.countryMatchQuery(dSCountryModel, str);
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        phoneInputCountriesFragment.setDisplayedCountries(arrayList);
    }
}
