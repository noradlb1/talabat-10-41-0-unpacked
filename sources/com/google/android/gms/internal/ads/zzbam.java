package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbam extends zzaoj {
    public zzbam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzbak zzbak) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbak);
        Parcel zzbs = zzbs(3, zza);
        long readLong = zzbs.readLong();
        zzbs.recycle();
        return readLong;
    }

    public final zzbah zzf(zzbak zzbak) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbak);
        Parcel zzbs = zzbs(1, zza);
        zzbah zzbah = (zzbah) zzaol.zza(zzbs, zzbah.CREATOR);
        zzbs.recycle();
        return zzbah;
    }

    public final zzbah zzg(zzbak zzbak) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbak);
        Parcel zzbs = zzbs(2, zza);
        zzbah zzbah = (zzbah) zzaol.zza(zzbs, zzbah.CREATOR);
        zzbs.recycle();
        return zzbah;
    }
}
