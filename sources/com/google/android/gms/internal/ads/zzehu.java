package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

public final class zzehu<DelegateT, AdapterT> implements zzeht<AdapterT> {
    @VisibleForTesting
    public final zzeht<DelegateT> zza;
    private final zzfpv<DelegateT, AdapterT> zzb;

    public zzehu(zzeht<DelegateT> zzeht, zzfpv<DelegateT, AdapterT> zzfpv) {
        this.zza = zzeht;
        this.zzb = zzfpv;
    }

    public final zzfxa<AdapterT> zza(zzfdz zzfdz, zzfdn zzfdn) {
        return zzfwq.zzm(this.zza.zza(zzfdz, zzfdn), this.zzb, zzcjm.zza);
    }

    public final boolean zzb(zzfdz zzfdz, zzfdn zzfdn) {
        return this.zza.zzb(zzfdz, zzfdn);
    }
}
