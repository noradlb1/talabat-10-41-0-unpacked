package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

public abstract class zzbv extends zzb implements zzbw {
    public zzbv() {
        super("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
    }

    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzc.zzc(parcel);
            zzb((Bitmap) zzc.zza(parcel, Bitmap.CREATOR));
        } else if (i11 != 2) {
            return false;
        } else {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzc.zzc(parcel);
            zzc(asInterface);
        }
        parcel2.writeNoException();
        return true;
    }
}
