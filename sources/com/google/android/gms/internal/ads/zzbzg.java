package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbzg extends zzaoj implements zzbzi {
    public zzbzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString("Adapter returned null.");
        zzbt(2, zza);
    }

    public final void zzf(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(3, zza);
    }

    public final void zzg(zzbxw zzbxw) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbxw);
        zzbt(1, zza);
    }
}
