package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

public abstract class zzq extends zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzr zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        if (queryLocalInterface instanceof zzr) {
            return (zzr) queryLocalInterface;
        }
        return new zzp(iBinder);
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzc.zzb(parcel);
            zze((LocationResult) zzc.zza(parcel, LocationResult.CREATOR));
        } else if (i11 == 2) {
            zzc.zzb(parcel);
            zzd((LocationAvailability) zzc.zza(parcel, LocationAvailability.CREATOR));
        } else if (i11 != 3) {
            return false;
        } else {
            zzf();
        }
        return true;
    }
}
