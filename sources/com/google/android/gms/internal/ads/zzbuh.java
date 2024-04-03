package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbuh extends zzaok implements zzbui {
    public static zzbui zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
        if (queryLocalInterface instanceof zzbui) {
            return (zzbui) queryLocalInterface;
        }
        return new zzbug(iBinder);
    }
}
