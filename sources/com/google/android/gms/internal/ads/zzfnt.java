package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzfnt extends zzaoj {
    public zzfnt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfnr zze(zzfnp zzfnp) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzfnp);
        Parcel zzbs = zzbs(1, zza);
        zzfnr zzfnr = (zzfnr) zzaol.zza(zzbs, zzfnr.CREATOR);
        zzbs.recycle();
        return zzfnr;
    }

    public final zzfoa zzf(zzfny zzfny) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzfny);
        Parcel zzbs = zzbs(3, zza);
        zzfoa zzfoa = (zzfoa) zzaol.zza(zzbs, zzfoa.CREATOR);
        zzbs.recycle();
        return zzfoa;
    }

    public final void zzg(zzfnm zzfnm) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzfnm);
        zzbt(2, zza);
    }
}
