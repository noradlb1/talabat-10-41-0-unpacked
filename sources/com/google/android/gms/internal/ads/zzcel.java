package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzcel extends zzaok implements zzcem {
    public static zzcem zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
        if (queryLocalInterface instanceof zzcem) {
            return (zzcem) queryLocalInterface;
        }
        return new zzcek(iBinder);
    }
}
