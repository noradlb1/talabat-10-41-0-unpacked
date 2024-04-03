package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdyf implements zzgpr<Set<zzdlw<zzfif>>> {
    private final zzgqe<String> zza;
    private final zzgqe<Context> zzb;
    private final zzgqe<Executor> zzc;
    private final zzgqe<Map<zzfhy, zzdyh>> zzd;

    public zzdyf(zzgqe<String> zzgqe, zzgqe<Context> zzgqe2, zzgqe<Executor> zzgqe3, zzgqe<Map<zzfhy, zzdyh>> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        String zza2 = ((zzexq) this.zza).zza();
        Context zza3 = ((zzcqr) this.zzb).zza();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        Map zzd2 = ((zzgpv) this.zzd).zzb();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdv)).booleanValue()) {
            zzbay zzbay = new zzbay(new zzbbc(zza3));
            zzbay.zzb(new zzdyg(zza2));
            set = Collections.singleton(new zzdlw(new zzdyi(zzbay, zzd2), zzfxb));
        } else {
            set = Collections.emptySet();
        }
        zzgpz.zzb(set);
        return set;
    }
}
