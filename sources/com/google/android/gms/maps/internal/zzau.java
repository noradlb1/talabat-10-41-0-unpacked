package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

public abstract class zzau extends zzb implements zzav {
    public zzau() {
        super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zzad zzb = zzac.zzb(parcel.readStrongBinder());
        zzc.zzc(parcel);
        boolean zzb2 = zzb(zzb);
        parcel2.writeNoException();
        parcel2.writeInt(zzb2 ? 1 : 0);
        return true;
    }
}
