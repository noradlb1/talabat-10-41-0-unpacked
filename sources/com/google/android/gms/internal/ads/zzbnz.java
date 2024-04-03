package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract class zzbnz extends zzaok implements zzboa {
    public zzbnz() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzboa zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        if (queryLocalInterface instanceof zzboa) {
            return (zzboa) queryLocalInterface;
        }
        return new zzbny(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 2) {
            String zzg = zzg();
            parcel2.writeNoException();
            parcel2.writeString(zzg);
            return true;
        } else if (i11 != 3) {
            return false;
        } else {
            List<zzboi> zzh = zzh();
            parcel2.writeNoException();
            parcel2.writeList(zzh);
            return true;
        }
    }
}
