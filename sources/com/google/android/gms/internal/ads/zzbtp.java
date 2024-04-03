package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbtp extends zzaoj implements zzbtr {
    public zzbtp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbt(3, zza);
    }

    public final void zzf() throws RemoteException {
        zzbt(2, zza());
    }
}
