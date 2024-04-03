package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzekd extends zzbze {
    private final zzehw<zzbzo, zzejp> zza;

    public /* synthetic */ zzekd(zzeke zzeke, zzehw zzehw, zzekc zzekc) {
        this.zza = zzehw;
    }

    public final void zze(String str) throws RemoteException {
        ((zzejp) this.zza.zzc).zzi(0, str);
    }

    public final void zzf(zzbew zzbew) throws RemoteException {
        ((zzejp) this.zza.zzc).zzh(zzbew);
    }

    public final void zzg() throws RemoteException {
        ((zzejp) this.zza.zzc).zzo();
    }
}
