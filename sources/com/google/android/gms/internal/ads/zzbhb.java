package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbhb extends zzaoj implements zzbhd {
    public zzbhb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final String zze() throws RemoteException {
        throw null;
    }

    public final String zzf() throws RemoteException {
        throw null;
    }

    public final void zzg(zzbfd zzbfd) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbfd);
        zzbt(1, zza);
    }

    public final void zzh(zzbfd zzbfd, int i11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbfd);
        zza.writeInt(i11);
        zzbt(5, zza);
    }

    public final boolean zzi() throws RemoteException {
        Parcel zzbs = zzbs(3, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }
}
