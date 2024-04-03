package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzaon extends zzaok implements zzaoo {
    public static zzaoo zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        if (queryLocalInterface instanceof zzaoo) {
            return (zzaoo) queryLocalInterface;
        }
        return new zzaom(iBinder);
    }
}
