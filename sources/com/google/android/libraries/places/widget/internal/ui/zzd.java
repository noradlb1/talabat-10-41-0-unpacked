package com.google.android.libraries.places.widget.internal.ui;

import androidx.lifecycle.Observer;
import com.google.android.libraries.places.internal.zzdz;

public final /* synthetic */ class zzd implements Observer {
    public final /* synthetic */ AutocompleteImplFragment zza;

    public /* synthetic */ zzd(AutocompleteImplFragment autocompleteImplFragment) {
        this.zza = autocompleteImplFragment;
    }

    public final void onChanged(Object obj) {
        this.zza.zzg((zzdz) obj);
    }
}
