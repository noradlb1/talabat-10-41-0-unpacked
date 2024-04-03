package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaok;
import com.google.android.gms.internal.ads.zzaol;

public abstract class zzbu extends zzaok implements zzbv {
    public zzbu() {
        super("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            boolean zzf = zzf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            zzaol.zzc(parcel2, zzf);
        } else if (i11 != 2) {
            return false;
        } else {
            zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
        }
        return true;
    }
}
