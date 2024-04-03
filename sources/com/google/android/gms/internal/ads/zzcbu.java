package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzcbu extends zzaok implements zzcbv {
    public static zzcbv zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzcbv) {
            return (zzcbv) queryLocalInterface;
        }
        return new zzcbt(iBinder);
    }
}
