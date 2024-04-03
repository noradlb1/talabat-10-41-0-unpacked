package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbpr extends zzaoj implements zzbpt {
    public zzbpr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    public final void zze(zzbhk zzbhk, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbhk);
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(1, zza);
    }
}
