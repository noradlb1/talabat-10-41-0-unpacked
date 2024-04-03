package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

final class zzbyb implements InitializationCompleteCallback {
    final /* synthetic */ zzbtr zza;

    public zzbyb(zzbyg zzbyg, zzbtr zzbtr) {
        this.zza = zzbtr;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zza.zzf();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }
}
