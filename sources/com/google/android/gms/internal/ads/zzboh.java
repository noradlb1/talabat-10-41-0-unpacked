package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzboh extends zzaok implements zzboi {
    public zzboh() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzboi zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        if (queryLocalInterface instanceof zzboi) {
            return (zzboi) queryLocalInterface;
        }
        return new zzbog(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            IObjectWrapper zzf = zzf();
            parcel2.writeNoException();
            zzaol.zzf(parcel2, zzf);
        } else if (i11 == 2) {
            Uri zze = zze();
            parcel2.writeNoException();
            zzaol.zze(parcel2, zze);
        } else if (i11 == 3) {
            double zzb = zzb();
            parcel2.writeNoException();
            parcel2.writeDouble(zzb);
        } else if (i11 == 4) {
            int zzd = zzd();
            parcel2.writeNoException();
            parcel2.writeInt(zzd);
        } else if (i11 != 5) {
            return false;
        } else {
            int zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeInt(zzc);
        }
        return true;
    }
}
