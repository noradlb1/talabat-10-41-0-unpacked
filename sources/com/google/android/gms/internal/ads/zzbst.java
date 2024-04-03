package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbst extends zzaok implements zzbsu {
    public static zzbsu zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
        if (queryLocalInterface instanceof zzbsu) {
            return (zzbsu) queryLocalInterface;
        }
        return new zzbss(iBinder);
    }
}
