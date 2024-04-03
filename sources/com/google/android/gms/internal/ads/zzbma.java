package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzbma extends zzaok implements zzbmb {
    public zzbma() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            String zzb = zzb();
            parcel2.writeNoException();
            parcel2.writeString(zzb);
        } else if (i11 == 2) {
            String zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeString(zzc);
        } else if (i11 == 3) {
            zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i11 == 4) {
            zze();
            parcel2.writeNoException();
        } else if (i11 != 5) {
            return false;
        } else {
            zzf();
            parcel2.writeNoException();
        }
        return true;
    }
}
