package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

public abstract class zzaw extends zzb implements zzax {
    public zzaw() {
        super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzad zzb = zzac.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            zzd(zzb);
        } else if (i11 == 2) {
            zzad zzb2 = zzac.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            zzb(zzb2);
        } else if (i11 != 3) {
            return false;
        } else {
            zzad zzb3 = zzac.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            zzc(zzb3);
        }
        parcel2.writeNoException();
        return true;
    }
}
