package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzq;
import com.google.android.gms.internal.maps.zzr;

public abstract class zzy extends zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.maps.internal.IOnGroundOverlayClickListener");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zzr zzb = zzq.zzb(parcel.readStrongBinder());
        zzc.zzc(parcel);
        zzb(zzb);
        parcel2.writeNoException();
        return true;
    }
}
