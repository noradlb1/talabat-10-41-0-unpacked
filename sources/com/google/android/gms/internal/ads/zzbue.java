package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbue extends zzaok implements zzbuf {
    public zzbue() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            if (i11 != 2) {
                return false;
            }
            parcel.readInt();
        }
        parcel2.writeNoException();
        return true;
    }
}
