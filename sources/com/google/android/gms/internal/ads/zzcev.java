package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzcev extends zzaok implements zzcew {
    public zzcev() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public static zzcew zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
        if (queryLocalInterface instanceof zzcew) {
            return (zzcew) queryLocalInterface;
        }
        return new zzceu(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            String zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        } else if (i11 != 2) {
            return false;
        } else {
            int zze = zze();
            parcel2.writeNoException();
            parcel2.writeInt(zze);
        }
        return true;
    }
}
