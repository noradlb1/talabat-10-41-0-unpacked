package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.places.zzb;
import com.google.android.gms.internal.places.zze;

public abstract class zzaa extends zzb implements zzx {
    public zzaa() {
        super("com.google.android.gms.location.places.internal.IPlacesCallbacks");
    }

    public final boolean dispatchTransaction(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzb((DataHolder) zze.zzb(parcel, DataHolder.CREATOR));
        } else if (i11 == 2) {
            zzc((DataHolder) zze.zzb(parcel, DataHolder.CREATOR));
        } else if (i11 == 3) {
            zzd((DataHolder) zze.zzb(parcel, DataHolder.CREATOR));
        } else if (i11 == 4) {
            zzb((Status) zze.zzb(parcel, Status.CREATOR));
        } else if (i11 != 5) {
            return false;
        } else {
            zze((DataHolder) zze.zzb(parcel, DataHolder.CREATOR));
        }
        return true;
    }
}
