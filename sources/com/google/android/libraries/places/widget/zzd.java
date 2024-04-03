package com.google.android.libraries.places.widget;

import android.view.View;

public final /* synthetic */ class zzd implements View.OnClickListener {
    public final /* synthetic */ AutocompleteFragment zza;

    public /* synthetic */ zzd(AutocompleteFragment autocompleteFragment) {
        this.zza = autocompleteFragment;
    }

    public final void onClick(View view) {
        this.zza.setText("");
    }
}
