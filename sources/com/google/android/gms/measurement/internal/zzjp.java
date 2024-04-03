package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzjp implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzac zzc;
    final /* synthetic */ zzac zzd;
    final /* synthetic */ zzjz zze;

    public zzjp(zzjz zzjz, boolean z11, zzq zzq, boolean z12, zzac zzac, zzac zzac2) {
        this.zze = zzjz;
        this.zza = zzq;
        this.zzb = z12;
        this.zzc = zzac;
        this.zzd = zzac2;
    }

    public final void run() {
        zzac zzac;
        zzjz zzjz = this.zze;
        zzej zzh = zzjz.zzb;
        if (zzh == null) {
            zzjz.zzt.zzaA().zzd().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjz zzjz2 = this.zze;
        if (this.zzb) {
            zzac = null;
        } else {
            zzac = this.zzc;
        }
        zzjz2.zzD(zzh, zzac, this.zza);
        this.zze.zzQ();
    }
}
