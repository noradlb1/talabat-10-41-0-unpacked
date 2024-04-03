package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class zzj implements Runnable {
    final /* synthetic */ zzcf zza;
    final /* synthetic */ zzau zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ AppMeasurementDynamiteService zzd;

    public zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, zzau zzau, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzcf;
        this.zzb = zzau;
        this.zzc = str;
    }

    public final void run() {
        this.zzd.zza.zzt().zzB(this.zza, this.zzb, this.zzc);
    }
}
