package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbpf extends zzaok implements zzbpg {
    public static zzbpg zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
        if (queryLocalInterface instanceof zzbpg) {
            return (zzbpg) queryLocalInterface;
        }
        return new zzbpe(iBinder);
    }
}
