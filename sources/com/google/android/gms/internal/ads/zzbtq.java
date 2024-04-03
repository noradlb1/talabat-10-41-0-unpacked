package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbtq extends zzaok implements zzbtr {
    public zzbtq() {
        super("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    public static zzbtr zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
        if (queryLocalInterface instanceof zzbtr) {
            return (zzbtr) queryLocalInterface;
        }
        return new zzbtp(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 2) {
            zzf();
        } else if (i11 != 3) {
            return false;
        } else {
            zze(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
