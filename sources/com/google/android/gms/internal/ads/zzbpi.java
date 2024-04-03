package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbpi extends zzaok implements zzbpj {
    public static zzbpj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        if (queryLocalInterface instanceof zzbpj) {
            return (zzbpj) queryLocalInterface;
        }
        return new zzbph(iBinder);
    }
}
