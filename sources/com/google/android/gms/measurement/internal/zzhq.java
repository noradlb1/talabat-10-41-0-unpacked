package com.google.android.gms.measurement.internal;

final class zzhq implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzik zze;

    public zzhq(zzik zzik, String str, String str2, Object obj, long j11) {
        this.zze = zzik;
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j11;
    }

    public final void run() {
        this.zze.zzY(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
