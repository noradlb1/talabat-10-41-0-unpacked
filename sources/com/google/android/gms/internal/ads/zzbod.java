package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbod extends zzaoj implements zzbof {
    public zzbod(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    public final float zze() throws RemoteException {
        Parcel zzbs = zzbs(2, zza());
        float readFloat = zzbs.readFloat();
        zzbs.recycle();
        return readFloat;
    }

    public final float zzf() throws RemoteException {
        Parcel zzbs = zzbs(6, zza());
        float readFloat = zzbs.readFloat();
        zzbs.recycle();
        return readFloat;
    }

    public final float zzg() throws RemoteException {
        Parcel zzbs = zzbs(5, zza());
        float readFloat = zzbs.readFloat();
        zzbs.recycle();
        return readFloat;
    }

    public final zzbiz zzh() throws RemoteException {
        Parcel zzbs = zzbs(7, zza());
        zzbiz zzb = zzbiy.zzb(zzbs.readStrongBinder());
        zzbs.recycle();
        return zzb;
    }

    public final IObjectWrapper zzi() throws RemoteException {
        Parcel zzbs = zzbs(4, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(3, zza);
    }

    public final boolean zzk() throws RemoteException {
        Parcel zzbs = zzbs(8, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final void zzl(zzbpq zzbpq) throws RemoteException {
        throw null;
    }
}
