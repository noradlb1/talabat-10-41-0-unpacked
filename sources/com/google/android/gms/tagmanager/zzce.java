package com.google.android.gms.tagmanager;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gtm.zzn;
import com.google.android.gms.internal.gtm.zzo;

public abstract class zzce extends zzn implements zzcd {
    public zzce() {
        super("com.google.android.gms.tagmanager.ICustomEvaluatorProxy");
    }

    public final boolean dispatchTransaction(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzb(parcel.readString(), zzo.zzb(parcel));
            parcel2.writeNoException();
        } else if (i11 != 2) {
            return false;
        } else {
            String zzc = zzc(parcel.readString(), zzo.zzb(parcel));
            parcel2.writeNoException();
            parcel2.writeString(zzc);
        }
        return true;
    }
}
