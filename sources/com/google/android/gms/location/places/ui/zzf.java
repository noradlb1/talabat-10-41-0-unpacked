package com.google.android.gms.location.places.ui;

import android.view.View;

final class zzf implements View.OnClickListener {
    private final /* synthetic */ SupportPlaceAutocompleteFragment zzdm;

    public zzf(SupportPlaceAutocompleteFragment supportPlaceAutocompleteFragment) {
        this.zzdm = supportPlaceAutocompleteFragment;
    }

    public final void onClick(View view) {
        this.zzdm.setText("");
    }
}
