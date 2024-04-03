package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzccz extends zzaok implements zzcda {
    public zzccz() {
        super("com.google.android.gms.ads.internal.report.IDynamiteErrorEventListener");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zzb();
        parcel2.writeNoException();
        return true;
    }
}
