package com.google.android.gms.internal.icing;

import java.util.NoSuchElementException;

final class zzbx extends zzbz {
    final /* synthetic */ zzcf zza;
    private int zzb = 0;
    private final int zzc;

    public zzbx(zzcf zzcf) {
        this.zza = zzcf;
        this.zzc = zzcf.zzc();
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
