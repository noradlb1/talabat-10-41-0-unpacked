package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public final class zzccd extends zzaok implements zzcce {
    public static zzcce zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        if (queryLocalInterface instanceof zzcce) {
            return (zzcce) queryLocalInterface;
        }
        return new zzccc(iBinder);
    }
}
