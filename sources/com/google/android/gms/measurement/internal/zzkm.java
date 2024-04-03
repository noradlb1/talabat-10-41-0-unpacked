package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

final class zzkm extends zzan {
    final /* synthetic */ zzkn zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzkm(zzkn zzkn, zzgy zzgy) {
        super(zzgy);
        this.zza = zzkn;
    }

    @WorkerThread
    public final void zzc() {
        zzkn zzkn = this.zza;
        zzkn.zzc.zzg();
        zzkn.zzd(false, false, zzkn.zzc.zzt.zzax().elapsedRealtime());
        zzkn.zzc.zzt.zzd().zzf(zzkn.zzc.zzt.zzax().elapsedRealtime());
    }
}
