package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbqb extends zzaok implements zzbqc {
    public zzbqb() {
        super("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzf(parcel.readString());
        } else if (i11 != 2) {
            return false;
        } else {
            zze();
        }
        parcel2.writeNoException();
        return true;
    }
}
