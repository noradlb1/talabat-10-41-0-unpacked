package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzfdc extends zzfmb {
    final /* synthetic */ zzbiq zza;
    final /* synthetic */ zzfde zzb;

    public zzfdc(zzfde zzfde, zzbiq zzbiq) {
        this.zzb = zzfde;
        this.zza = zzbiq;
    }

    public final void zzv() {
        if (this.zzb.zzf != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
    }
}
