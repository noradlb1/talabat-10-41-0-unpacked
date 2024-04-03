package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzazu extends zzaoj implements zzazw {
    public zzazu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public final void zzb(int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zzbt(2, zza);
    }

    public final void zzc(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(3, zza);
    }

    public final void zzd(zzazt zzazt) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzazt);
        zzbt(1, zza);
    }
}
