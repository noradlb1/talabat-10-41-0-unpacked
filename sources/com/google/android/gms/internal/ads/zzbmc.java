package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbmc extends zzaoj implements zzbme {
    public zzbmc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public final void zze(zzbmb zzbmb) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbmb);
        zzbt(1, zza);
    }
}
