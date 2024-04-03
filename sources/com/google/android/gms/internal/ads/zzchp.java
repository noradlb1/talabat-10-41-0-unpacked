package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzchp extends zzaok implements zzchq {
    public zzchp() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            parcel.readString();
            parcel.readString();
        } else if (i11 == 2) {
            zzb(parcel.readString());
        } else if (i11 != 3) {
            return false;
        } else {
            zzc(parcel.readString(), parcel.readString(), (Bundle) zzaol.zza(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
