package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzcbe extends zzaoj implements zzcbg {
    public zzcbe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public final void zze(Intent intent) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, intent);
        zzbt(1, zza);
    }

    public final void zzf() throws RemoteException {
        zzbt(3, zza());
    }

    public final void zzg(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeString(str2);
        zzbt(2, zza);
    }
}
