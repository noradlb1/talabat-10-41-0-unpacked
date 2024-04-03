package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbip extends zzaok implements zzbiq {
    public zzbip() {
        super("com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }

    public static zzbiq zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
        if (queryLocalInterface instanceof zzbiq) {
            return (zzbiq) queryLocalInterface;
        }
        return new zzbio(iBinder);
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
