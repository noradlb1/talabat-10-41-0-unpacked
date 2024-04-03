package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

public final class zzejw implements zzeht<zzdmw> {
    private final Context zza;
    private final zzdwj zzb;
    private final zzdnt zzc;
    private final zzfef zzd;
    private final Executor zze;
    private final zzcjf zzf;
    private final zzbrw zzg;
    private final boolean zzh = ((Boolean) zzbgq.zzc().zzb(zzblj.zzgz)).booleanValue();

    public zzejw(Context context, zzcjf zzcjf, zzfef zzfef, Executor executor, zzdnt zzdnt, zzdwj zzdwj, zzbrw zzbrw) {
        this.zza = context;
        this.zzd = zzfef;
        this.zzc = zzdnt;
        this.zze = executor;
        this.zzf = zzcjf;
        this.zzb = zzdwj;
        this.zzg = zzbrw;
    }

    public final zzfxa<zzdmw> zza(zzfdz zzfdz, zzfdn zzfdn) {
        zzdwn zzdwn = new zzdwn();
        zzfxa<zzdmw> zzn = zzfwq.zzn(zzfwq.zzi(null), new zzejt(this, zzfdn, zzfdz, zzdwn), this.zze);
        zzn.zzc(new zzeju(zzdwn), this.zze);
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
        zzdnt zzdnt = this.zzc;
        zzdbk zzdbk = new zzdbk(zzfdz2, zzfdn2, (String) null);
        Context context = this.zza;
        zzcjf zzcjf = this.zzf;
        zzfef zzfef = this.zzd;
        boolean z11 = this.zzh;
        boolean z12 = z11;
        zzejv zzejv = r1;
        zzejv zzejv2 = new zzejv(context, zzcjf, zzcjr, zzfdn, zza2, zzfef, z12, this.zzg);
        zzdmx zze2 = zzdnt.zze(zzdbk, new zzdna(zzejv, zza2));
        zzcjr.zzd(zze2);
        zze2.zzc().zzj(new zzejr(zza2), zzcjm.zzf);
        zzdwi zzk = zze2.zzk();
        if (this.zzh) {
            zzbrw = this.zzg;
        } else {
            zzbrw = null;
        }
        zzk.zzi(zza2, true, zzbrw);
        zze2.zzk();
        zzfdn zzfdn3 = zzfdn;
        zzfds zzfds = zzfdn3.zzt;
        return zzfwq.zzm(zzdwi.zzj(zza2, zzfds.zzb, zzfds.zza), new zzejs(this, zza2, zzfdn3, zze2), this.zze);
    }
}
