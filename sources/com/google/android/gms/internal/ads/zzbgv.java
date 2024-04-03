package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbgv extends zzaoj implements zzbgx {
    public zzbgv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void zzc() throws RemoteException {
        zzbt(6, zza());
    }

    public final void zzd() throws RemoteException {
        zzbt(1, zza());
    }

    public final void zze(int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zzbt(2, zza);
    }

    public final void zzf(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(8, zza);
    }

    public final void zzg() throws RemoteException {
        zzbt(7, zza());
    }

    public final void zzh() throws RemoteException {
        zzbt(3, zza());
    }

    public final void zzi() throws RemoteException {
        zzbt(4, zza());
    }

    public final void zzj() throws RemoteException {
        zzbt(5, zza());
    }
}
