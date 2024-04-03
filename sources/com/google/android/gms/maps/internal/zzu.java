package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

public abstract class zzu extends zzb implements zzv {
    public zzu() {
        super("com.google.android.gms.maps.internal.IOnCameraMoveStartedListener");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        int readInt = parcel.readInt();
        zzc.zzc(parcel);
        zzb(readInt);
        parcel2.writeNoException();
        return true;
    }
}
