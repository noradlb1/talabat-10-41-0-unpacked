package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzfol extends zzaok implements zzfom {
    public zzfol() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        switch (i11) {
            case 2:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel.readString();
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                break;
            case 5:
                parcel.createByteArray();
                break;
            case 6:
                parcel.readInt();
                break;
            case 7:
                parcel.readInt();
                break;
            case 8:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
