package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbzk extends zzaok implements zzbzl {
    public zzbzk() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 2) {
            zzg();
        } else if (i11 == 3) {
            zze(parcel.readString());
        } else if (i11 != 4) {
            return false;
        } else {
            zzf((zzbew) zzaol.zza(parcel, zzbew.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
