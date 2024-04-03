package com.google.android.libraries.places.widget.internal.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.android.libraries.places.internal.zzdh;

final class zzj implements TextWatcher {
    final /* synthetic */ AutocompleteImplFragment zza;

    public /* synthetic */ zzj(AutocompleteImplFragment autocompleteImplFragment, zzi zzi) {
        this.zza = autocompleteImplFragment;
    }

    public final void afterTextChanged(Editable editable) {
        try {
            this.zza.zze.zzm(editable.toString());
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public final void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }
}
