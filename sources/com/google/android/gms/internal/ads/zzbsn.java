package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbsn extends zzaok implements zzbso {
    public zzbsn() {
        super("com.google.android.gms.ads.internal.h5.client.IH5AdsEventListener");
    }

    public static zzbso zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsEventListener");
        if (queryLocalInterface instanceof zzbso) {
            return (zzbso) queryLocalInterface;
        }
        return new zzbsm(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zzb(parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}
