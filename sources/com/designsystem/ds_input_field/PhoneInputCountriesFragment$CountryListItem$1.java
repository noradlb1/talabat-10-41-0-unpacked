package com.designsystem.ds_input_field;

import androidx.fragment.app.Fragment;
import com.designsystem.ds_bottom_sheet_v2.BottomSheet;
import com.designsystem.ds_input_field.country.DSCountryModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PhoneInputCountriesFragment$CountryListItem$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31869g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSCountryModel f31870h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$CountryListItem$1(PhoneInputCountriesFragment phoneInputCountriesFragment, DSCountryModel dSCountryModel) {
        super(0);
        this.f31869g = phoneInputCountriesFragment;
        this.f31870h = dSCountryModel;
    }

    public final void invoke() {
        Fragment parentFragment = this.f31869g.getParentFragment();
        BottomSheet bottomSheet = parentFragment instanceof BottomSheet ? (BottomSheet) parentFragment : null;
        if (bottomSheet != null) {
            bottomSheet.dismiss();
        }
        this.f31869g.getOnCountrySelected().invoke(this.f31870h);
    }
}
