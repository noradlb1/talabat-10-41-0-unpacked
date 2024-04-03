package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzjm implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzjz zzb;

    public zzjm(zzjz zzjz, zzq zzq) {
        this.zzb = zzjz;
        this.zza = zzq;
    }

    public final void run() {
        zzjz zzjz = this.zzb;
        zzej zzh = zzjz.zzb;
        if (zzh == null) {
            zzjz.zzt.zzaA().zzd().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzs(this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e11) {
            this.zzb.zzt.zzaA().zzd().zzb("Failed to send measurementEnabled to the service", e11);
        }
    }
}
