package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbpu extends zzaoj implements zzbpw {
    public zzbpu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public final void zze(zzbqf zzbqf) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbqf);
        zzbt(1, zza);
    }
}
