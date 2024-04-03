package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

public final class zzeig implements zzeht<zzcyp> {
    private final zzcyk zza;
    private final Context zzb;
    private final zzdwj zzc;
    private final zzfef zzd;
    private final Executor zze;
    private final zzcjf zzf;
    private final zzbrw zzg;
    private final boolean zzh = ((Boolean) zzbgq.zzc().zzb(zzblj.zzgz)).booleanValue();

    public zzeig(zzcyk zzcyk, Context context, Executor executor, zzdwj zzdwj, zzfef zzfef, zzcjf zzcjf, zzbrw zzbrw) {
        this.zzb = context;
        this.zza = zzcyk;
        this.zze = executor;
        this.zzc = zzdwj;
        this.zzd = zzfef;
        this.zzf = zzcjf;
        this.zzg = zzbrw;
    }

    public final zzfxa<zzcyp> zza(zzfdz zzfdz, zzfdn zzfdn) {
        zzdwn zzdwn = new zzdwn();
        zzfxa<zzcyp> zzn = zzfwq.zzn(zzfwq.zzi(null), new zzeie(this, zzfdn, zzfdz, zzdwn), this.zze);
        zzn.zzc(new zzeif(zzdwn), this.zze);
        return zzn;
    }

    public final boolean zzb(zzfdz zzfdz, zzfdn zzfdn) {
        zzfds zzfds = zzfdn.zzt;
        return (zzfds == null || zzfds.zza == null) ? false : true;
    }

    public final /* synthetic */ zzfxa zzc(zzfdn zzfdn, zzfdz zzfdz, zzdwn zzdwn, Object obj) throws Exception {
        zzbrw zzbrw;
        zzfdn zzfdn2 = zzfdn;
        zzfdz zzfdz2 = zzfdz;
        zzcop zza2 = this.zzc.zza(this.zzd.zze, zzfdn2, zzfdz2.zzb.zzb);
        zza2.zzab(zzfdn2.zzT);
        zzdwn.zza(this.zzb, (View) zza2);
        zzcjr zzcjr = new zzcjr();
        zzcyk zzcyk = this.zza;
        zzdbk zzdbk = new zzdbk(zzfdz2, zzfdn2, (String) null);
        zzeii zzeii = r1;
        zzeii zzeii2 = new zzeii(this.zzf, zzcjr, zzfdn, zza2, this.zzd, this.zzh, this.zzg);
        zzcyh zza3 = zzcyk.zza(zzdbk, new zzdna(zzeii, zza2), new zzcyi(zzfdn2.zzX));
        zzdwi zzj = zza3.zzj();
        if (this.zzh) {
            zzbrw = this.zzg;
        } else {
            zzbrw = null;
        }
        zzj.zzi(zza2, false, zzbrw);
        zzcjr.zzd(zza3);
        zza3.zzc().zzj(new zzeic(zza2), zzcjm.zzf);
        zza3.zzj();
        zzfds zzfds = zzfdn2.zzt;
        return zzfwq.zzm(zzdwi.zzj(zza2, zzfds.zzb, zzfds.zza), new zzeid(this, zza2, zzfdn2, zza3), this.zze);
    }
}
