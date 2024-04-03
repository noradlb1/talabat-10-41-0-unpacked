package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbhc extends zzaok implements zzbhd {
    public zzbhc() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzg((zzbfd) zzaol.zza(parcel, zzbfd.CREATOR));
            parcel2.writeNoException();
        } else if (i11 == 2) {
            String zze = zze();
            parcel2.writeNoException();
            parcel2.writeString(zze);
        } else if (i11 == 3) {
            boolean zzi = zzi();
            parcel2.writeNoException();
            zzaol.zzc(parcel2, zzi);
        } else if (i11 == 4) {
            String zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        } else if (i11 != 5) {
            return false;
        } else {
            zzh((zzbfd) zzaol.zza(parcel, zzbfd.CREATOR), parcel.readInt());
            parcel2.writeNoException();
        }
        return true;
    }
}
