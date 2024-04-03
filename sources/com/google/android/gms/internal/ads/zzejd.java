package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzejd extends zzbzb {
    final /* synthetic */ zzeje zza;
    private final zzehw<zzbzo, zzejp> zzb;

    public /* synthetic */ zzejd(zzeje zzeje, zzehw zzehw, zzejc zzejc) {
        this.zza = zzeje;
        this.zzb = zzehw;
    }

    public final void zze(String str) throws RemoteException {
        ((zzejp) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zzbew zzbew) throws RemoteException {
        ((zzejp) this.zzb.zzc).zzh(zzbew);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzc = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzejp) this.zzb.zzc).zzo();
    }

    public final void zzh(zzbxq zzbxq) throws RemoteException {
        this.zza.zzd = zzbxq;
        ((zzejp) this.zzb.zzc).zzo();
    }
}
