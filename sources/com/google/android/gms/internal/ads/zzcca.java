package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public final class zzcca extends zzaok implements zzccb {
    public static zzccb zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        if (queryLocalInterface instanceof zzccb) {
            return (zzccb) queryLocalInterface;
        }
        return new zzcbz(iBinder);
    }
}
