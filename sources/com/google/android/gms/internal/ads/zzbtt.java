package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbtt extends zzaok implements zzbtu {
    public zzbtt() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzbtu zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzbtu) {
            return (zzbtu) queryLocalInterface;
        }
        return new zzbts(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zzb(parcel.createTypedArrayList(zzbtn.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
