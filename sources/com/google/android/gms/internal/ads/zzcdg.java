package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzcdg extends zzaoj implements zzcdi {
    public zzcdg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zze(zzcdq zzcdq, zzcdm zzcdm) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzcdq);
        zzaol.zzf(zza, zzcdm);
        zzbt(6, zza);
    }

    public final void zzf(zzcdq zzcdq, zzcdm zzcdm) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzcdq);
        zzaol.zzf(zza, zzcdm);
        zzbt(5, zza);
    }

    public final void zzg(zzcdq zzcdq, zzcdm zzcdm) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzcdq);
        zzaol.zzf(zza, zzcdm);
        zzbt(4, zza);
    }

    public final void zzh(String str, zzcdm zzcdm) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzaol.zzf(zza, zzcdm);
        zzbt(7, zza);
    }
}
