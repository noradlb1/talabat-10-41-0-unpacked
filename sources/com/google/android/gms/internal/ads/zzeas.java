package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final /* synthetic */ class zzeas implements Runnable {
    public final /* synthetic */ zzebb zza;
    public final /* synthetic */ zzbtu zzb;

    public /* synthetic */ zzeas(zzebb zzebb, zzbtu zzbtu) {
        this.zza = zzebb;
        this.zzb = zzbtu;
    }

    public final void run() {
        zzebb zzebb = this.zza;
        try {
            this.zzb.zzb(zzebb.zzf());
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }
}
