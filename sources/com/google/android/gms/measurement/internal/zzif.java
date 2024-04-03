package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzqu;

final class zzif implements Runnable {
    final /* synthetic */ zzhb zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzhb zze;
    final /* synthetic */ zzik zzf;

    public zzif(zzik zzik, zzhb zzhb, long j11, long j12, boolean z11, zzhb zzhb2) {
        this.zzf = zzik;
        this.zza = zzhb;
        this.zzb = j11;
        this.zzc = j12;
        this.zzd = z11;
        this.zze = zzhb2;
    }

    public final void run() {
        this.zzf.zzV(this.zza);
        this.zzf.zzL(this.zzb, false);
        zzik.zzw(this.zzf, this.zza, this.zzc, true, this.zzd);
        zzqu.zzc();
        if (this.zzf.zzt.zzf().zzs((String) null, zzeg.zzan)) {
            zzik.zzv(this.zzf, this.zza, this.zze);
        }
    }
}
