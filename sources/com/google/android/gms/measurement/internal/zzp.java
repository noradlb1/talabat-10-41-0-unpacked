package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;

final class zzp implements zzhg {
    public final zzci zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzp(AppMeasurementDynamiteService appMeasurementDynamiteService, zzci zzci) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzci;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j11) {
        try {
            this.zza.zze(str, str2, bundle, j11);
        } catch (RemoteException e11) {
            zzgd zzgd = this.zzb.zza;
            if (zzgd != null) {
                zzgd.zzaA().zzk().zzb("Event listener threw exception", e11);
            }
        }
    }
}
