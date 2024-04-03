package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbzd extends zzaoj implements zzbzf {
    public zzbzd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString("Adapter returned null.");
        zzbt(3, zza);
    }

    public final void zzf(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(4, zza);
    }

    public final void zzg() throws RemoteException {
        zzbt(2, zza());
    }
}
