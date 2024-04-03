package com.google.android.libraries.places.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import d2.h;

public final class zzep implements ViewModelProvider.Factory {
    private final zzee zza;
    private final zzeu zzb;
    private final zzev zzc;

    public zzep(zzee zzee, zzeu zzeu, zzev zzev) {
        this.zza = zzee;
        this.zzb = zzeu;
        this.zzc = zzev;
    }

    public final <T extends ViewModel> T create(Class<T> cls) {
        zzfm.zze(cls == zzer.class, "This factory can only be used to instantiate its enclosing class.");
        return new zzer(this.zza, this.zzb, this.zzc, (zzeq) null);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
