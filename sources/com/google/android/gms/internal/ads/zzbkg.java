package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final /* synthetic */ class zzbkg implements Runnable {
    public final /* synthetic */ zzcfg zza;

    public /* synthetic */ zzbkg(zzcfg zzcfg) {
        this.zza = zzcfg;
    }

    public final void run() {
        zzcfg zzcfg = this.zza;
        if (zzcfg != null) {
            try {
                zzcfg.zze(1);
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
    }
}
