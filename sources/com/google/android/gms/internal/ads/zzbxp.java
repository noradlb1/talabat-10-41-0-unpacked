package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzbxp extends zzaok implements zzbxq {
    public zzbxp() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    public static zzbxq zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
        if (queryLocalInterface instanceof zzbxq) {
            return (zzbxq) queryLocalInterface;
        }
        return new zzbxo(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            IObjectWrapper zze = zze();
            parcel2.writeNoException();
            zzaol.zzf(parcel2, zze);
        } else if (i11 != 2) {
            return false;
        } else {
            boolean zzf = zzf();
            parcel2.writeNoException();
            zzaol.zzc(parcel2, zzf);
        }
        return true;
    }
}
