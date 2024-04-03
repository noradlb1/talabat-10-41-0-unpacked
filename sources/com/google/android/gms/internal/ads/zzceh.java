package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzceh extends zzaoj {
    public zzceh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    public final void zze(zzceg zzceg, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzceg);
        zza.writeString(str);
        zza.writeString(str2);
        zzbt(2, zza);
    }
}
