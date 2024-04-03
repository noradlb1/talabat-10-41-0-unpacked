package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzaw;
import java.util.concurrent.Executor;

public final class zzeiu implements zzeht<zzcyw> {
    private final zzczt zza;
    private final Context zzb;
    private final zzdwj zzc;
    private final zzfef zzd;
    private final Executor zze;
    private final zzfpv<zzfdn, zzaw> zzf;

    public zzeiu(zzczt zzczt, Context context, Executor executor, zzdwj zzdwj, zzfef zzfef, zzfpv<zzfdn, zzaw> zzfpv) {
        this.zzb = context;
        this.zza = zzczt;
        this.zze = executor;
        this.zzc = zzdwj;
        this.zzd = zzfef;
        this.zzf = zzfpv;
    }

    public final zzfxa<zzcyw> zza(zzfdz zzfdz, zzfdn zzfdn) {
        return zzfwq.zzn(zzfwq.zzi(null), new zzeir(this, zzfdz, zzfdn), this.zze);
    }

    public final boolean zzb(zzfdz zzfdz, zzfdn zzfdn) {
        zzfds zzfds = zzfdn.zzt;
        return (zzfds == null || zzfds.zza == null) ? false : true;
    }

    public final /* synthetic */ zzfxa zzc(zzfdz zzfdz, zzfdn zzfdn, Object obj) throws Exception {
        View view;
        zzbfi zza2 = zzfej.zza(this.zzb, zzfdn.zzv);
        zzcop zza3 = this.zzc.zza(zza2, zzfdn, zzfdz.zzb.zzb);
        zza3.zzab(zzfdn.zzT);
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfI)).booleanValue() || !zzfdn.zzae) {
            view = new zzdwm(this.zzb, (View) zza3, this.zzf.apply(zzfdn));
        } else {
            view = zzdak.zza(this.zzb, (View) zza3, zzfdn);
        }
        zzcyx zza4 = this.zza.zza(new zzdbk(zzfdz, zzfdn, (String) null), new zzczd(view, zza3, new zzeio(zza3), zzfej.zzc(zza2)));
        zza4.zzj().zzi(zza3, false, (zzbrw) null);
        zzdfj zzc2 = zza4.zzc();
        zzeip zzeip = new zzeip(zza3);
        zzfxb zzfxb = zzcjm.zzf;
        zzc2.zzj(zzeip, zzfxb);
        zza4.zzj();
        zzfds zzfds = zzfdn.zzt;
        zzfxa<?> zzj = zzdwi.zzj(zza3, zzfds.zzb, zzfds.zza);
        if (zzfdn.zzJ) {
            zzj.zzc(new zzeis(zza3), this.zze);
        }
        zzj.zzc(new zzeit(this, zza3), this.zze);
        return zzfwq.zzm(zzj, new zzeiq(zza4), zzfxb);
    }

    public final /* synthetic */ void zzd(zzcop zzcop) {
        zzcop.zzaa();
        zzcpl zzs = zzcop.zzs();
        zzbkq zzbkq = this.zzd.zza;
        if (zzbkq != null && zzs != null) {
            zzs.zzs(zzbkq);
        }
    }
}
