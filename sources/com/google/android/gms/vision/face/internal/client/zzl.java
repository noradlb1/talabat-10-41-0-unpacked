package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zza;
import com.google.android.gms.internal.vision.zzd;

public abstract class zzl extends zza implements zzi {
    public zzl() {
        super("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
    }

    public static zzi asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
        if (queryLocalInterface instanceof zzi) {
            return (zzi) queryLocalInterface;
        }
        return new zzk(iBinder);
    }

    public final boolean dispatchTransaction(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zzh newFaceDetector = newFaceDetector(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzf) zzd.zza(parcel, zzf.CREATOR));
        parcel2.writeNoException();
        zzd.zza(parcel2, (IInterface) newFaceDetector);
        return true;
    }
}
