package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzcef extends zzaok implements zzceg {
    public zzcef() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            String zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeString(zzc);
        } else if (i11 != 2) {
            return false;
        } else {
            int zzb = zzb();
            parcel2.writeNoException();
            parcel2.writeInt(zzb);
        }
        return true;
    }
}
