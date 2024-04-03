package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzy extends zza implements zzaa {
    public zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMapCapabilitiesDelegate");
    }

    public final boolean zzd() throws RemoteException {
        Parcel zzJ = zzJ(1, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
