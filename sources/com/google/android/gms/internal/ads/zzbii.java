package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbii extends zzaok implements zzbij {
    public zzbii() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzbij zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        if (queryLocalInterface instanceof zzbij) {
            return (zzbij) queryLocalInterface;
        }
        return new zzbih(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            String zze = zze();
            parcel2.writeNoException();
            parcel2.writeString(zze);
        } else if (i11 != 2) {
            return false;
        } else {
            String zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        }
        return true;
    }
}
