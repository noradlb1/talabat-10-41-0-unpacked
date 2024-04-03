package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

final class zzedf implements zzfwm<zzfdz> {
    final /* synthetic */ zzedg zza;

    public zzedf(zzedg zzedg) {
        this.zza = zzedg;
    }

    public final void zza(Throwable th2) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeE)).booleanValue()) {
            Matcher matcher = zzedg.zza.matcher(th2.getMessage());
            if (matcher.matches()) {
                this.zza.zzf.zzg(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfdz zzfdz = (zzfdz) obj;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeE)).booleanValue()) {
            this.zza.zzf.zzg(zzfdz.zzb.zzb.zze);
            this.zza.zzf.zzh(zzfdz.zzb.zzb.zzf);
        }
    }
}
