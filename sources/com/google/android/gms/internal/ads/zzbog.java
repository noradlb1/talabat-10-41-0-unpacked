package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbog extends zzaoj implements zzboi {
    public zzbog(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public final double zzb() throws RemoteException {
        Parcel zzbs = zzbs(3, zza());
        double readDouble = zzbs.readDouble();
        zzbs.recycle();
        return readDouble;
    }

    public final int zzc() throws RemoteException {
        Parcel zzbs = zzbs(5, zza());
        int readInt = zzbs.readInt();
        zzbs.recycle();
        return readInt;
    }

    public final int zzd() throws RemoteException {
        Parcel zzbs = zzbs(4, zza());
        int readInt = zzbs.readInt();
        zzbs.recycle();
        return readInt;
    }

    public final Uri zze() throws RemoteException {
        Parcel zzbs = zzbs(2, zza());
        Uri uri = (Uri) zzaol.zza(zzbs, Uri.CREATOR);
        zzbs.recycle();
        return uri;
    }

    public final IObjectWrapper zzf() throws RemoteException {
        Parcel zzbs = zzbs(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }
}
