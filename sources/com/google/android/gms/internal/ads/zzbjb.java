package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbjb extends zzaok implements zzbjc {
    public zzbjb() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzi();
        } else if (i11 == 2) {
            zzh();
        } else if (i11 == 3) {
            zzg();
        } else if (i11 == 4) {
            zze();
        } else if (i11 != 5) {
            return false;
        } else {
            zzf(zzaol.zzg(parcel));
        }
        parcel2.writeNoException();
        return true;
    }
}
