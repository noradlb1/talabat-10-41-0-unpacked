package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbzq extends zzaok implements zzbzr {
    public zzbzq() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zze(parcel.readString());
        } else if (i11 == 2) {
            zzf(parcel.readString());
        } else if (i11 != 3) {
            return false;
        } else {
            zzg((zzbew) zzaol.zza(parcel, zzbew.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
