package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

public abstract class zzba extends zzb implements zzbb {
    public zzba() {
        super("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        zzc.zzc(parcel);
        zzb(asInterface);
        parcel2.writeNoException();
        return true;
    }
}
