package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class zzgk implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzgv zzd;

    public zzgk(zzgv zzgv, String str, String str2, String str3) {
        this.zzd = zzgv;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zzd.zza.zzA();
        return this.zzd.zza.zzh().zzs(this.zza, this.zzb, this.zzc);
    }
}
