package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzbyp implements Runnable {
    final /* synthetic */ zzbyx zza;

    public zzbyp(zzbyx zzbyx) {
        this.zza = zzbyx;
    }

    public final void run() {
        try {
            this.zza.zza.zzf();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}
