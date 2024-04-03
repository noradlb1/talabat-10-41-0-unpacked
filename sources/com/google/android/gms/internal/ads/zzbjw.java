package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzbjw implements Runnable {
    final /* synthetic */ zzbjy zza;

    public zzbjw(zzbjy zzbjy) {
        this.zza = zzbjy;
    }

    public final void run() {
        if (this.zza.zza.zza != null) {
            try {
                this.zza.zza.zza.zze(1);
            } catch (RemoteException e11) {
                zzciz.zzk("Could not notify onAdFailedToLoad event.", e11);
            }
        }
    }
}
