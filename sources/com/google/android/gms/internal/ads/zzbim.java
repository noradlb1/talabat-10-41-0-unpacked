package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbim extends zzaok implements zzbin {
    public zzbim() {
        super("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zze((zzbew) zzaol.zza(parcel, zzbew.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
