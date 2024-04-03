package com.talabat.userandlocation.choosecountry.ui.fragment;

import android.view.View;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.CountryDisplayModel;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryFragment f12270b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CountryDisplayModel f12271c;

    public /* synthetic */ a(ChooseCountryFragment chooseCountryFragment, CountryDisplayModel countryDisplayModel) {
        this.f12270b = chooseCountryFragment;
        this.f12271c = countryDisplayModel;
    }

    public final void onClick(View view) {
        ChooseCountryFragment$observeViewModel$6.m5891invoke$lambda0(this.f12270b, this.f12271c, view);
    }
}
