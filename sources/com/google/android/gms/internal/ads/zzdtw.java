package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final /* synthetic */ class zzdtw implements Runnable {
    public final /* synthetic */ zzdty zza;

    public /* synthetic */ zzdtw(zzdty zzdty) {
        this.zza = zzdty;
    }

    public final void run() {
        try {
            this.zza.zzd();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}
