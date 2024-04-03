package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbgy extends zzaoj implements zzbha {
    public zzbgy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    public final void zzb(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(2, zza);
    }

    public final void zzc() throws RemoteException {
        zzbt(1, zza());
    }
}
