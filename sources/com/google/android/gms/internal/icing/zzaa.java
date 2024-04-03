package com.google.android.gms.internal.icing;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.firebase.appindexing.internal.zzc;

public final class zzaa extends zza {
    public zzaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
    }

    public final void zzd(zzac zzac, String str, zzx[] zzxArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzac);
        zza.writeString((String) null);
        zza.writeTypedArray(zzxArr, 0);
        zzc(1, zza);
    }

    public final void zze(zzac zzac, zzc[] zzcArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzac);
        zza.writeTypedArray(zzcArr, 0);
        zzc(7, zza);
    }
}
