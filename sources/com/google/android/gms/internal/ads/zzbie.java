package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbie extends zzaok implements zzbif {
    public zzbie() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    public static zzbif zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
        if (queryLocalInterface instanceof zzbif) {
            return (zzbif) queryLocalInterface;
        }
        return new zzbid(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zze();
        parcel2.writeNoException();
        return true;
    }
}
