package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbzh extends zzaok implements zzbzi {
    public zzbzh() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzg(zzbxv.zzb(parcel.readStrongBinder()));
        } else if (i11 == 2) {
            zze(parcel.readString());
        } else if (i11 != 3) {
            return false;
        } else {
            zzf((zzbew) zzaol.zza(parcel, zzbew.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
