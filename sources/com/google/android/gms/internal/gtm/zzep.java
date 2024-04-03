package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzep extends zzn implements zzeo {
    public zzep() {
        super("com.google.android.gms.tagmanager.internal.ITagManagerLoadContainerCallback");
    }

    public final boolean dispatchTransaction(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zza(zzo.zza(parcel), parcel.readString());
        return true;
    }
}
