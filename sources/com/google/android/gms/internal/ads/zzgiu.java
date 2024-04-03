package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzgiu extends zzgix {
    final /* synthetic */ zzgjf zza;
    private int zzb = 0;
    private final int zzc;

    public zzgiu(zzgjf zzgjf) {
        this.zza = zzgjf;
        this.zzc = zzgjf.zzd();
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
