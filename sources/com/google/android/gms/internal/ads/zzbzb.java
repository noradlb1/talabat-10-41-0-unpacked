package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzbzb extends zzaok implements zzbzc {
    public zzbzb() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzg(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        } else if (i11 == 2) {
            zze(parcel.readString());
        } else if (i11 == 3) {
            zzf((zzbew) zzaol.zza(parcel, zzbew.CREATOR));
        } else if (i11 != 4) {
            return false;
        } else {
            zzh(zzbxp.zzb(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
