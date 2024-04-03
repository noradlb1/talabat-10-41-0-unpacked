package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

public abstract class zzay extends zzb implements zzaz {
    public zzay() {
        super("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        boolean zzb = zzb();
        parcel2.writeNoException();
        int i13 = zzc.zza;
        parcel2.writeInt(zzb ? 1 : 0);
        return true;
    }
}
