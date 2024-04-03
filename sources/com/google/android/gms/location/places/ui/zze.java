package com.google.android.gms.location.places.ui;

import android.view.View;

final class zze implements View.OnClickListener {
    private final /* synthetic */ PlaceAutocompleteFragment zzdl;

    public zze(PlaceAutocompleteFragment placeAutocompleteFragment) {
        this.zzdl = placeAutocompleteFragment;
    }

    public final void onClick(View view) {
        if (!this.zzdl.zzdh) {
            this.zzdl.zzn();
        }
    }
}
