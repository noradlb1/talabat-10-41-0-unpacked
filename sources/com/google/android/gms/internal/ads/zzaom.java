package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaom extends zzaoj implements zzaoo {
    public zzaom(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    public final void zze(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zza.writeString("GMA_SDK");
        zzbt(2, zza);
    }

    public final void zzf() throws RemoteException {
        zzbt(3, zza());
    }

    public final void zzg(int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zzbt(7, zza);
    }

    public final void zzh(int[] iArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeIntArray((int[]) null);
        zzbt(4, zza);
    }

    public final void zzi(int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(0);
        zzbt(6, zza);
    }

    public final void zzj(byte[] bArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeByteArray(bArr);
        zzbt(5, zza);
    }
}
