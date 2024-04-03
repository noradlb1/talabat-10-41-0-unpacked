package com.google.firebase.appindexing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.internal.icing.zza;
import com.google.android.gms.internal.icing.zzc;

public final class zzv extends zza {
    public zzv(IBinder iBinder) {
        super(iBinder, "com.google.firebase.appindexing.internal.IAppIndexingService");
    }

    public final zzg zzd(IStatusCallback iStatusCallback, zzz zzz) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, iStatusCallback);
        zzc.zzb(zza, zzz);
        Parcel zzb = zzb(8, zza);
        zzg zzg = (zzg) zzc.zza(zzb, zzg.CREATOR);
        zzb.recycle();
        return zzg;
    }
}
