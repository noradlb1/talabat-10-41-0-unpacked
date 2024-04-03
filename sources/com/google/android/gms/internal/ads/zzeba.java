package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

final class zzeba extends zzbtq {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzcjr zzd;
    final /* synthetic */ zzebb zze;

    public zzeba(zzebb zzebb, Object obj, String str, long j11, zzcjr zzcjr) {
        this.zze = zzebb;
        this.zza = obj;
        this.zzb = str;
        this.zzc = j11;
        this.zzd = zzcjr;
    }

    public final void zze(String str) {
        synchronized (this.zza) {
            this.zze.zzu(this.zzb, false, str, (int) (zzt.zzA().elapsedRealtime() - this.zzc));
            this.zze.zzl.zza(this.zzb, "error");
            this.zze.zzo.zza(this.zzb, "error");
            this.zzd.zzd(Boolean.FALSE);
        }
    }

    public final void zzf() {
        synchronized (this.zza) {
            this.zze.zzu(this.zzb, true, "", (int) (zzt.zzA().elapsedRealtime() - this.zzc));
            this.zze.zzl.zzc(this.zzb);
            this.zze.zzo.zzc(this.zzb);
            this.zzd.zzd(Boolean.TRUE);
        }
    }
}
