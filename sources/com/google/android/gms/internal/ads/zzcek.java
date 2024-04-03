package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzcek extends zzaoj implements zzcem {
    public zzcek(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public final void zze(zzceg zzceg) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzceg);
        zzbt(5, zza);
    }

    public final void zzf() throws RemoteException {
        zzbt(4, zza());
    }

    public final void zzg(int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zzbt(7, zza);
    }

    public final void zzh() throws RemoteException {
        zzbt(6, zza());
    }

    public final void zzi() throws RemoteException {
        zzbt(1, zza());
    }

    public final void zzj() throws RemoteException {
        zzbt(2, zza());
    }

    public final void zzk() throws RemoteException {
        zzbt(8, zza());
    }

    public final void zzl() throws RemoteException {
        zzbt(3, zza());
    }
}
