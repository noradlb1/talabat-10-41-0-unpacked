package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzfjv extends zzaok implements zzfjw {
    public static zzfjw zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.omid.IOmid");
        if (queryLocalInterface instanceof zzfjw) {
            return (zzfjw) queryLocalInterface;
        }
        return new zzfju(iBinder);
    }
}
