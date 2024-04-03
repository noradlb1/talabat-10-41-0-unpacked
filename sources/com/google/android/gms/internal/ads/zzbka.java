package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzbka implements Runnable {
    final /* synthetic */ zzbkb zza;

    public zzbka(zzbkb zzbkb) {
        this.zza = zzbkb;
    }

    public final void run() {
        if (this.zza.zza != null) {
            try {
                this.zza.zza.zze(1);
            } catch (RemoteException e11) {
                zzciz.zzk("Could not notify onAdFailedToLoad event.", e11);
            }
        }
    }
}
