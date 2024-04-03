package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;

public abstract class zzq extends zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.maps.internal.IOnCameraMoveCanceledListener");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zzb();
        parcel2.writeNoException();
        return true;
    }
}
