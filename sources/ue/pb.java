package ue;

import com.talabat.QuickOrderScreen;
import com.talabat.designhelpers.CountryCodePicker;

public final /* synthetic */ class pb implements CountryCodePicker.CountryPickerListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QuickOrderScreen f57696a;

    public /* synthetic */ pb(QuickOrderScreen quickOrderScreen) {
        this.f57696a = quickOrderScreen;
    }

    public final void onSelectCountry(String str, String str2, String str3) {
        this.f57696a.lambda$onCreate$6(str, str2, str3);
    }
}
