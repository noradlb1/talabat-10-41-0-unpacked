package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzeks extends zzbzh {
    final /* synthetic */ zzekt zza;
    private final zzehw<zzbzo, zzejp> zzb;

    public /* synthetic */ zzeks(zzekt zzekt, zzehw zzehw, zzekr zzekr) {
        this.zza = zzekt;
        this.zzb = zzehw;
    }

    public final void zze(String str) throws RemoteException {
        ((zzejp) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zzbew zzbew) throws RemoteException {
        ((zzejp) this.zzb.zzc).zzh(zzbew);
    }

    public final void zzg(zzbxw zzbxw) throws RemoteException {
        this.zza.zzc = zzbxw;
        ((zzejp) this.zzb.zzc).zzo();
    }
}
