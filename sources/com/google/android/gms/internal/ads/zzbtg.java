package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbtg extends zzaoj {
    public zzbtg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzbta zzbta, zzbtf zzbtf) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbta);
        zzaol.zzf(zza, zzbtf);
        zzbu(2, zza);
    }
}
