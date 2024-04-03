package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbnq extends zzaoj {
    public zzbnq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzcda zzcda) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzcda);
        zzbt(1, zza);
    }
}
