package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbok extends zzaoj implements zzbom {
    public zzbok(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public final IObjectWrapper zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzbs = zzbs(2, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }

    public final void zzbE(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(1, zza);
    }

    public final void zzbF(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(6, zza);
    }

    public final void zzbG(zzbof zzbof) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbof);
        zzbt(8, zza);
    }

    public final void zzbH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(9, zza);
    }

    public final void zzbI(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(3, zza);
    }

    public final void zzc() throws RemoteException {
        zzbt(4, zza());
    }

    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(7, zza);
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zza.writeInt(i11);
        zzbt(5, zza);
    }
}
