package com.google.android.libraries.places.widget.internal.ui;

import androidx.activity.OnBackPressedCallback;

final class zzf extends OnBackPressedCallback {
    final /* synthetic */ AutocompleteImplFragment zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzf(AutocompleteImplFragment autocompleteImplFragment, boolean z11) {
        super(true);
        this.zza = autocompleteImplFragment;
    }

    public final void handleOnBackPressed() {
        this.zza.zze.zzj();
    }
}
