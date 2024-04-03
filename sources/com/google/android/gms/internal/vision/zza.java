package com.google.android.gms.internal.vision;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza extends Binder implements IInterface {
    private static zzc zza;

    public zza(String str) {
        attachInterface(this, str);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean dispatchTransaction(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        return false;
    }

    public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        boolean z11;
        if (i11 > 16777215) {
            z11 = super.onTransact(i11, parcel, parcel2, i12);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z11 = false;
        }
        if (z11) {
            return true;
        }
        return dispatchTransaction(i11, parcel, parcel2, i12);
    }
}
