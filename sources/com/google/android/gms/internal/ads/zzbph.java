package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbph extends zzaoj implements zzbpj {
    public zzbph(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public final void zze(zzboz zzboz) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzboz);
        zzbt(1, zza);
    }
}
