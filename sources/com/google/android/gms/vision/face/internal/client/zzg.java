package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zza;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.internal.vision.zzp;

public abstract class zzg extends zza implements zzh {
    public zzg() {
        super("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    public final boolean dispatchTransaction(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            FaceParcel[] zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzp) zzd.zza(parcel, zzp.CREATOR));
            parcel2.writeNoException();
            parcel2.writeTypedArray(zzc, 1);
        } else if (i11 == 2) {
            boolean zzd = zzd(parcel.readInt());
            parcel2.writeNoException();
            zzd.writeBoolean(parcel2, zzd);
        } else if (i11 != 3) {
            return false;
        } else {
            zzm();
            parcel2.writeNoException();
        }
        return true;
    }
}
