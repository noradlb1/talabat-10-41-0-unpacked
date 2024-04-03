package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzhx implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzik zze;

    public zzhx(zzik zzik, AtomicReference atomicReference, String str, String str2, String str3, boolean z11) {
        this.zze = zzik;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z11;
    }

    public final void run() {
        this.zze.zzt.zzt().zzz(this.zza, (String) null, this.zzb, this.zzc, this.zzd);
    }
}
