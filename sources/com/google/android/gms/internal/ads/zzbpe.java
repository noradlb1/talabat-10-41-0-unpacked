package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbpe extends zzaoj implements zzbpg {
    public zzbpe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public final void zze(zzbox zzbox) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbox);
        zzbt(1, zza);
    }
}
