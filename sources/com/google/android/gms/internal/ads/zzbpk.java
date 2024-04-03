package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbpk extends zzaoj implements zzbpm {
    public zzbpk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void zze(zzbpc zzbpc, String str) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbpc);
        zza.writeString(str);
        zzbt(1, zza);
    }
}
