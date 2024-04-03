package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.CameraPosition;

public abstract class zzm extends zzb implements zzn {
    public zzm() {
        super("com.google.android.gms.maps.internal.IOnCameraChangeListener");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zzc.zzc(parcel);
        zzb((CameraPosition) zzc.zza(parcel, CameraPosition.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
