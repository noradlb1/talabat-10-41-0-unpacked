package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gtm.zzn;
import com.google.android.gms.internal.gtm.zzo;

public abstract class zzch extends zzn implements zzcg {
    public zzch() {
        super("com.google.android.gms.tagmanager.IMeasurementEventListener");
    }

    public final boolean dispatchTransaction(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        onEvent(parcel.readString(), parcel.readString(), (Bundle) zzo.zza(parcel, Bundle.CREATOR), parcel.readLong());
        parcel2.writeNoException();
        return true;
    }
}
