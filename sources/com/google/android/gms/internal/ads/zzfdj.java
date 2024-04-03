package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzfdj extends zzfmb {
    final /* synthetic */ zzbho zza;
    final /* synthetic */ zzfdk zzb;

    public zzfdj(zzfdk zzfdk, zzbho zzbho) {
        this.zzb = zzfdk;
        this.zza = zzbho;
    }

    public final void zzv() {
        if (this.zzb.zzd != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
    }
}
