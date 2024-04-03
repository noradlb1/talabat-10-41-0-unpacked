package ue;

import com.talabat.AddAddressScreen2;
import com.talabat.designhelpers.CountryCodePicker;

public final /* synthetic */ class a0 implements CountryCodePicker.CountryPickerListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57421a;

    public /* synthetic */ a0(AddAddressScreen2 addAddressScreen2) {
        this.f57421a = addAddressScreen2;
    }

    public final void onSelectCountry(String str, String str2, String str3) {
        this.f57421a.lambda$setViewOnClickListener$11(str, str2, str3);
    }
}
