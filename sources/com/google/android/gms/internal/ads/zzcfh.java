package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzcfh extends zzaoj {
    public zzcfh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zze(zzcew zzcew, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzcew);
        zza.writeString(str);
        zza.writeString(str2);
        zzbt(2, zza);
    }
}
