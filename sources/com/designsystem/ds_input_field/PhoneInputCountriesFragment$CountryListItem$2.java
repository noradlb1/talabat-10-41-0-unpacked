package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import com.designsystem.ds_input_field.country.DSCountryModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PhoneInputCountriesFragment$CountryListItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31871g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSCountryModel f31872h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31873i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$CountryListItem$2(PhoneInputCountriesFragment phoneInputCountriesFragment, DSCountryModel dSCountryModel, int i11) {
        super(2);
        this.f31871g = phoneInputCountriesFragment;
        this.f31872h = dSCountryModel;
        this.f31873i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f31871g.CountryListItem(this.f31872h, composer, this.f31873i | 1);
    }
}
