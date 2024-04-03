package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzbyn implements Runnable {
    final /* synthetic */ zzbyx zza;

    public zzbyn(zzbyx zzbyx) {
        this.zza = zzbyx;
    }

    public final void run() {
        try {
            this.zza.zza.zzo();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}
