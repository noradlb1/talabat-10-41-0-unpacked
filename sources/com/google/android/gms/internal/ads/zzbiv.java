package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract class zzbiv extends zzaok implements zzbiw {
    public zzbiv() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public static zzbiw zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        if (queryLocalInterface instanceof zzbiw) {
            return (zzbiw) queryLocalInterface;
        }
        return new zzbiu(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            String zze = zze();
            parcel2.writeNoException();
            parcel2.writeString(zze);
        } else if (i11 == 2) {
            String zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        } else if (i11 != 3) {
            return false;
        } else {
            List<zzbfm> zzg = zzg();
            parcel2.writeNoException();
            parcel2.writeTypedList(zzg);
        }
        return true;
    }
}
