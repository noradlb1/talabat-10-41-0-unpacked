package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzccg extends zzaok implements zzcch {
    public zzccg() {
        super("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }

    public static zzcch zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
        if (queryLocalInterface instanceof zzcch) {
            return (zzcch) queryLocalInterface;
        }
        return new zzccf(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzf(parcel.createTypedArrayList(Uri.CREATOR));
        } else if (i11 != 2) {
            return false;
        } else {
            zze(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
