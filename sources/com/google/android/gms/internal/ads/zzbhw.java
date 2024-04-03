package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbhw extends zzaoj implements zzbhy {
    public zzbhw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    public final void zzb() throws RemoteException {
        zzbt(5, zza());
    }

    public final void zzc() throws RemoteException {
        zzbt(3, zza());
    }

    public final void zzd(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(1, zza);
    }

    public final void zze() throws RemoteException {
        zzbt(4, zza());
    }

    public final void zzf() throws RemoteException {
        zzbt(2, zza());
    }
}
