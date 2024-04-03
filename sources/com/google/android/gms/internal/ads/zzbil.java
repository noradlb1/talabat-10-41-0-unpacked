package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbil extends zzaoj implements zzbin {
    public zzbil(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
    }

    public final void zze(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(1, zza);
    }
}
