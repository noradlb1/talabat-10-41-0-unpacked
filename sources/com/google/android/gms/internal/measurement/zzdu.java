package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

abstract class zzdu implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzef zzk;

    public zzdu(zzef zzef, boolean z11) {
        this.zzk = zzef;
        this.zzh = zzef.zza.currentTimeMillis();
        this.zzi = zzef.zza.elapsedRealtime();
        this.zzj = z11;
    }

    public final void run() {
        if (this.zzk.zzh) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e11) {
            this.zzk.zzT(e11, false, this.zzj);
            zzb();
        }
    }

    public abstract void zza() throws RemoteException;

    public void zzb() {
    }
}
