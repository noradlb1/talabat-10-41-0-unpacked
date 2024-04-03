package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzazz extends zzaok implements zzbaa {
    public zzazz() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzf();
        } else if (i11 == 2) {
            zzc();
        } else if (i11 == 3) {
            zzd((zzbew) zzaol.zza(parcel, zzbew.CREATOR));
        } else if (i11 == 4) {
            zze();
        } else if (i11 != 5) {
            return false;
        } else {
            zzb();
        }
        parcel2.writeNoException();
        return true;
    }
}
