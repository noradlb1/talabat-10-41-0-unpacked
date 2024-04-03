package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

public final class zzcza implements zzgpr<zzcyz> {
    private final zzgqe<zzdau> zza;
    private final zzgqe<Context> zzb;
    private final zzgqe<zzfdo> zzc;
    private final zzgqe<View> zzd;
    private final zzgqe<zzcop> zze;
    private final zzgqe<zzdat> zzf;
    private final zzgqe<zzdqn> zzg;
    private final zzgqe<zzdmf> zzh;
    private final zzgqe<zzenz> zzi;
    private final zzgqe<Executor> zzj;

    public zzcza(zzgqe<zzdau> zzgqe, zzgqe<Context> zzgqe2, zzgqe<zzfdo> zzgqe3, zzgqe<View> zzgqe4, zzgqe<zzcop> zzgqe5, zzgqe<zzdat> zzgqe6, zzgqe<zzdqn> zzgqe7, zzgqe<zzdmf> zzgqe8, zzgqe<zzenz> zzgqe9, zzgqe<Executor> zzgqe10) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
        this.zzg = zzgqe7;
        this.zzh = zzgqe8;
        this.zzi = zzgqe9;
        this.zzj = zzgqe10;
    }

    public static zzcyz zzc(zzdau zzdau, Context context, zzfdo zzfdo, View view, zzcop zzcop, zzdat zzdat, zzdqn zzdqn, zzdmf zzdmf, zzgpl<zzenz> zzgpl, Executor executor) {
        return new zzcyz(zzdau, context, zzfdo, view, zzcop, zzdat, zzdqn, zzdmf, zzgpl, executor);
    }

    /* renamed from: zza */
    public final zzcyz zzb() {
        return new zzcyz(((zzdcq) this.zza).zzb(), this.zzb.zzb(), ((zzczg) this.zzc).zza(), ((zzczf) this.zzd).zza(), ((zzczr) this.zze).zza(), ((zzczh) this.zzf).zza(), ((zzdon) this.zzg).zza(), this.zzh.zzb(), zzgpq.zza(this.zzi), this.zzj.zzb());
    }
}
