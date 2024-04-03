package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

public final class zzeim implements zzeht<zzcyf> {
    private final zzcxz zza;
    private final Context zzb;
    private final zzdwj zzc;
    private final Executor zzd;

    public zzeim(zzcxz zzcxz, Context context, Executor executor, zzdwj zzdwj) {
        this.zzb = context;
        this.zza = zzcxz;
        this.zzd = executor;
        this.zzc = zzdwj;
    }

    public final zzfxa<zzcyf> zza(zzfdz zzfdz, zzfdn zzfdn) {
        return zzfwq.zzn(zzfwq.zzi(null), new zzeil(this, zzfdz, zzfdn), this.zzd);
    }

    public final boolean zzb(zzfdz zzfdz, zzfdn zzfdn) {
        zzfds zzfds = zzfdn.zzt;
        return (zzfds == null || zzfds.zza == null) ? false : true;
    }

    public final /* synthetic */ zzfxa zzc(zzfdz zzfdz, zzfdn zzfdn, Object obj) throws Exception {
        zzbfi zza2 = zzfej.zza(this.zzb, zzfdn.zzv);
        zzcop zza3 = this.zzc.zza(zza2, zzfdn, zzfdz.zzb.zzb);
        zzcxs zza4 = this.zza.zza(new zzdbk(zzfdz, zzfdn, (String) null), new zzcxt((View) zza3, zza3, zzfej.zzc(zza2), zzfdn.zzX, zzfdn.zzab, zzfdn.zzL));
        zza4.zzg().zzi(zza3, false, (zzbrw) null);
        zzdfj zzc2 = zza4.zzc();
        zzeij zzeij = new zzeij(zza3);
        zzfxb zzfxb = zzcjm.zzf;
        zzc2.zzj(zzeij, zzfxb);
        zza4.zzg();
        zzfds zzfds = zzfdn.zzt;
        return zzfwq.zzm(zzdwi.zzj(zza3, zzfds.zzb, zzfds.zza), new zzeik(zza4), zzfxb);
    }
}
