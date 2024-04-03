package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.internal.maps.zzu;

public abstract class zzaa extends zzb implements zzab {
    public zzaa() {
        super("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzb();
        } else if (i11 != 2) {
            return false;
        } else {
            zzu zzb = zzt.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            zzc(zzb);
        }
        parcel2.writeNoException();
        return true;
    }
}
