package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbd;

public abstract class zzcdl extends zzaok implements zzcdm {
    public zzcdl() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzf((ParcelFileDescriptor) zzaol.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i11 != 2) {
            return false;
        } else {
            zze((zzbd) zzaol.zza(parcel, zzbd.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
