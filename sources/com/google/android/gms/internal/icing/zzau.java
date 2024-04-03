package com.google.android.gms.internal.icing;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzau extends zza {
    public zzau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.search.internal.ISearchAuthService");
    }

    public final void zzd(zzat zzat, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzat);
        zza.writeString(str);
        zza.writeString(str2);
        zzc(1, zza);
    }

    public final void zze(zzat zzat, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzat);
        zza.writeString(str);
        zza.writeString(str2);
        zzc(2, zza);
    }
}
