package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzceu extends zzaoj implements zzcew {
    public zzceu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public final int zze() throws RemoteException {
        Parcel zzbs = zzbs(2, zza());
        int readInt = zzbs.readInt();
        zzbs.recycle();
        return readInt;
    }

    public final String zzf() throws RemoteException {
        Parcel zzbs = zzbs(1, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }
}
