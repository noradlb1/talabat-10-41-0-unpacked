package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbis extends zzaok implements zzbit {
    public zzbis() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzbit zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        if (queryLocalInterface instanceof zzbit) {
            return (zzbit) queryLocalInterface;
        }
        return new zzbir(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zze((zzbfk) zzaol.zza(parcel, zzbfk.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
