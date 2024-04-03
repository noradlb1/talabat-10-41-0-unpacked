package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbou extends zzaok implements zzbov {
    public static zzbov zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (queryLocalInterface instanceof zzbov) {
            return (zzbov) queryLocalInterface;
        }
        return new zzbot(iBinder);
    }
}
