package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzbor extends zzaok implements zzbos {
    public zzbor() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public static zzbos zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        if (queryLocalInterface instanceof zzbos) {
            return (zzbos) queryLocalInterface;
        }
        return new zzboq(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        } else if (i11 == 2) {
            zzd();
        } else if (i11 != 3) {
            return false;
        } else {
            zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
