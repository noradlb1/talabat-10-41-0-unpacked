package com.google.android.libraries.places.widget.internal.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.internal.zzdh;

final class zzg extends RecyclerView.OnScrollListener {
    final /* synthetic */ AutocompleteImplFragment zza;

    public zzg(AutocompleteImplFragment autocompleteImplFragment) {
        this.zza = autocompleteImplFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        if (i11 == 1) {
            try {
                this.zza.zze.zzg();
                this.zza.zzg.clearFocus();
            } catch (Error | RuntimeException e11) {
                zzdh.zzb(e11);
                throw e11;
            }
        }
    }
}
