package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbsq extends zzaok implements zzbsr {
    public zzbsq() {
        super("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
    }

    public static zzbsr zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
        if (queryLocalInterface instanceof zzbsr) {
            return (zzbsr) queryLocalInterface;
        }
        return new zzbsp(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzf(parcel.readString());
        } else if (i11 != 2) {
            return false;
        } else {
            zze();
        }
        parcel2.writeNoException();
        return true;
    }
}
