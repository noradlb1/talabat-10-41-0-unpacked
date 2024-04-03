package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.LatLng;

public abstract class zzam extends zzb implements zzan {
    public zzam() {
        super("com.google.android.gms.maps.internal.IOnMapClickListener");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zzc.zzc(parcel);
        zzb((LatLng) zzc.zza(parcel, LatLng.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
