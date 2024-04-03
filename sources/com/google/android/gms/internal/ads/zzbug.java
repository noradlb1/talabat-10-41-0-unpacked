package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbug extends zzaoj implements zzbui {
    public zzbug(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    public final void zze(int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zzbt(2, zza);
    }

    public final void zzf(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(3, zza);
    }

    public final void zzg(zzbuc zzbuc) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbuc);
        zzbt(1, zza);
    }
}
