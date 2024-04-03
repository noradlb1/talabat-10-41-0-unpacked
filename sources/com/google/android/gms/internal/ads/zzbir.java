package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbir extends zzaoj implements zzbit {
    public zzbir(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public final void zze(zzbfk zzbfk) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbfk);
        zzbt(1, zza);
    }
}
