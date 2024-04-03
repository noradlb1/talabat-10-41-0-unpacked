package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdav;
import com.google.android.gms.internal.ads.zzdea;

final class zzfag<R extends zzdea<AdT>, AdT extends zzdav> implements zzfgh<R, AdT> {
    private final zzfbc<R, zzffw<R, AdT>> zza;

    public zzfag(zzfbc<R, zzffw<R, AdT>> zzfbc) {
        this.zza = zzfbc;
    }

    public final zzfxa<zzffw<R, AdT>> zza(zzfgi<R, AdT> zzfgi) {
        zzfah zzfah = (zzfah) zzfgi;
        return ((zzfad) this.zza).zzb(zzfah.zzb, zzfah.zza, null);
    }

    public final void zzb(zzffw<R, AdT> zzffw) {
        zzffw.zza = ((zzfad) this.zza).zza();
    }
}
