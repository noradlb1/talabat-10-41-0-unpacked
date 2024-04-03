package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbmd extends zzaok implements zzbme {
    public static zzbme zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
        if (queryLocalInterface instanceof zzbme) {
            return (zzbme) queryLocalInterface;
        }
        return new zzbmc(iBinder);
    }
}
