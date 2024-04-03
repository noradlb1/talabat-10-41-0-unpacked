package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzcqi extends zzaok implements zzcqj {
    public static zzcqj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.measurement.IMeasurementManager");
        if (queryLocalInterface instanceof zzcqj) {
            return (zzcqj) queryLocalInterface;
        }
        return new zzcqh(iBinder);
    }
}
