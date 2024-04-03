package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbzp extends zzaoj implements zzbzr {
    public zzbzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbt(1, zza);
    }

    public final void zzf(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbt(2, zza);
    }

    public final void zzg(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(3, zza);
    }
}
