package com.google.android.gms.location.places.ui;

import android.view.View;

final class zzg implements View.OnClickListener {
    private final /* synthetic */ SupportPlaceAutocompleteFragment zzdm;

    public zzg(SupportPlaceAutocompleteFragment supportPlaceAutocompleteFragment) {
        this.zzdm = supportPlaceAutocompleteFragment;
    }

    public final void onClick(View view) {
        if (!this.zzdm.zzdh) {
            this.zzdm.zzn();
        }
    }
}
