package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;

public abstract class zzc extends zzb implements zzd {
    public zzc() {
        super("com.google.android.gms.maps.internal.ICancelableCallback");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzc();
        } else if (i11 != 2) {
            return false;
        } else {
            zzb();
        }
        parcel2.writeNoException();
        return true;
    }
}
