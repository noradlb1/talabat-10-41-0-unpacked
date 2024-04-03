package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzcff extends zzaok implements zzcfg {
    public zzcff() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzg();
        } else if (i11 == 2) {
            zze(parcel.readInt());
        } else if (i11 != 3) {
            return false;
        } else {
            zzf((zzbew) zzaol.zza(parcel, zzbew.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
