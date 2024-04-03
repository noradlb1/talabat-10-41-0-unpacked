package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

public abstract class zzh extends zzb implements zzi {
    public zzh() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzad zzb = zzac.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            IObjectWrapper zzc = zzc(zzb);
            parcel2.writeNoException();
            zzc.zze(parcel2, zzc);
        } else if (i11 != 2) {
            return false;
        } else {
            zzad zzb2 = zzac.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            IObjectWrapper zzb3 = zzb(zzb2);
            parcel2.writeNoException();
            zzc.zze(parcel2, zzb3);
        }
        return true;
    }
}
