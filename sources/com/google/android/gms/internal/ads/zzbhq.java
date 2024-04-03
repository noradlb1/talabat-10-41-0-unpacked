package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbhq extends zzaok implements zzbhr {
    public zzbhq() {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public static zzbhr zzd(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        if (queryLocalInterface instanceof zzbhr) {
            return (zzbhr) queryLocalInterface;
        }
        return new zzbhp(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zzc(parcel.readString(), parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}
