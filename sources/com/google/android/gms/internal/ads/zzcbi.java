package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzcbi extends zzaok implements zzcbj {
    public static zzcbj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
        if (queryLocalInterface instanceof zzcbj) {
            return (zzcbj) queryLocalInterface;
        }
        return new zzcbh(iBinder);
    }
}
