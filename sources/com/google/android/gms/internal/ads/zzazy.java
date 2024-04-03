package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzazy extends zzaoj implements zzbaa {
    public zzazy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    public final void zzb() throws RemoteException {
        zzbt(5, zza());
    }

    public final void zzc() throws RemoteException {
        zzbt(2, zza());
    }

    public final void zzd(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(3, zza);
    }

    public final void zze() throws RemoteException {
        zzbt(4, zza());
    }

    public final void zzf() throws RemoteException {
        zzbt(1, zza());
    }
}
