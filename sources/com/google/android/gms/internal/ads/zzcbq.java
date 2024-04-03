package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzcbq extends zzaoj implements zzcbs {
    public zzcbq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final boolean zzE() throws RemoteException {
        Parcel zzbs = zzbs(11, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final void zzg(int i11, int i12, Intent intent) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zza.writeInt(i12);
        zzaol.zzd(zza, intent);
        zzbt(12, zza);
    }

    public final void zzh() throws RemoteException {
        zzbt(10, zza());
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(13, zza);
    }

    public final void zzk(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, bundle);
        zzbt(1, zza);
    }

    public final void zzl() throws RemoteException {
        zzbt(8, zza());
    }

    public final void zzn() throws RemoteException {
        zzbt(5, zza());
    }

    public final void zzo() throws RemoteException {
        zzbt(2, zza());
    }

    public final void zzp() throws RemoteException {
        zzbt(4, zza());
    }

    public final void zzq(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, bundle);
        Parcel zzbs = zzbs(6, zza);
        if (zzbs.readInt() != 0) {
            bundle.readFromParcel(zzbs);
        }
        zzbs.recycle();
    }

    public final void zzr() throws RemoteException {
        zzbt(3, zza());
    }

    public final void zzs() throws RemoteException {
        zzbt(7, zza());
    }

    public final void zzt() throws RemoteException {
        zzbt(14, zza());
    }

    public final void zzv() throws RemoteException {
        zzbt(9, zza());
    }
}
