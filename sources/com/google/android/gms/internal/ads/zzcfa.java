package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzcfa extends zzaoj implements zzcfc {
    public zzcfa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    public final void zze() throws RemoteException {
        zzbt(7, zza());
    }

    public final void zzf() throws RemoteException {
        zzbt(6, zza());
    }

    public final void zzg() throws RemoteException {
        zzbt(2, zza());
    }

    public final void zzh(int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zzbt(4, zza);
    }

    public final void zzi(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(5, zza);
    }

    public final void zzj() throws RemoteException {
        zzbt(1, zza());
    }

    public final void zzk(zzcew zzcew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzcew);
        zzbt(3, zza);
    }
}
