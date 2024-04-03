package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbpn extends zzaoj implements zzbpp {
    public zzbpn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public final void zze(zzbpc zzbpc) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbpc);
        zzbt(1, zza);
    }
}
