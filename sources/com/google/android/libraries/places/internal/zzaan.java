package com.google.android.libraries.places.internal;

import java.util.NoSuchElementException;

final class zzaan extends zzaaq {
    final /* synthetic */ zzaax zza;
    private int zzb = 0;
    private final int zzc;

    public zzaan(zzaax zzaax) {
        this.zza = zzaax;
        this.zzc = zzaax.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i11 = this.zzb;
        if (i11 < this.zzc) {
            this.zzb = i11 + 1;
            return this.zza.zzb(i11);
        }
        throw new NoSuchElementException();
    }
}
