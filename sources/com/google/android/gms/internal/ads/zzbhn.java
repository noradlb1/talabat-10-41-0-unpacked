package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbhn extends zzaok implements zzbho {
    public static zzbho zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
        if (queryLocalInterface instanceof zzbho) {
            return (zzbho) queryLocalInterface;
        }
        return new zzbhm(iBinder);
    }
}
