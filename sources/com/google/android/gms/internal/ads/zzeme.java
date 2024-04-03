package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

public final class zzeme implements zzeht<zzdvn> {
    private final Context zza;
    private final zzdwj zzb;
    private final zzdvs zzc;
    private final zzfef zzd;
    private final Executor zze;
    private final zzcjf zzf;
    private final zzbrw zzg;
    private final boolean zzh = ((Boolean) zzbgq.zzc().zzb(zzblj.zzgz)).booleanValue();

    public zzeme(Context context, zzcjf zzcjf, zzfef zzfef, Executor executor, zzdvs zzdvs, zzdwj zzdwj, zzbrw zzbrw) {
        this.zza = context;
        this.zzd = zzfef;
        this.zzc = zzdvs;
        this.zze = executor;
        this.zzf = zzcjf;
        this.zzb = zzdwj;
        this.zzg = zzbrw;
    }

    public final zzfxa<zzdvn> zza(zzfdz zzfdz, zzfdn zzfdn) {
        zzdwn zzdwn = new zzdwn();
        zzfxa<zzdvn> zzn = zzfwq.zzn(zzfwq.zzi(null), new zzelz(this, zzfdn, zzfdz, zzdwn), this.zze);
        zzn.zzc(new zzema(zzdwn), this.zze);
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
        zzcop zza2 = this.zzb.zza(this.zzd.zze, zzfdn2, zzfdz2.zzb.zzb);
        zza2.zzab(zzfdn2.zzT);
        zzdwn.zza(this.zza, (View) zza2);
        zzcjr zzcjr = new zzcjr();
        zzdvs zzdvs = this.zzc;
        zzdbk zzdbk = new zzdbk(zzfdz2, zzfdn2, (String) null);
        zzemd zzemd = r1;
        zzemd zzemd2 = new zzemd(this.zza, this.zzb, this.zzd, this.zzf, zzfdn, zzcjr, zza2, this.zzg, this.zzh);
        zzdvo zze2 = zzdvs.zze(zzdbk, new zzdvp(zzemd, zza2));
        zzcjr.zzd(zze2);
        zzbsj.zzb(zza2, zze2.zzg());
        zze2.zzc().zzj(new zzelx(zza2), zzcjm.zzf);
        zzdwi zzl = zze2.zzl();
        if (this.zzh) {
            zzbrw = this.zzg;
        } else {
            zzbrw = null;
        }
        zzl.zzi(zza2, true, zzbrw);
        zze2.zzl();
        zzfdn zzfdn3 = zzfdn;
        zzfds zzfds = zzfdn3.zzt;
        return zzfwq.zzm(zzdwi.zzj(zza2, zzfds.zzb, zzfds.zza), new zzely(this, zza2, zzfdn3, zze2), this.zze);
    }
}
