package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbxg extends zzaok implements zzbxh {
    public zzbxg() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbxh zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzbxh) {
            return (zzbxh) queryLocalInterface;
        }
        return new zzbxf(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzbxk zzb = zzb(parcel.readString());
            parcel2.writeNoException();
            zzaol.zzf(parcel2, zzb);
        } else if (i11 == 2) {
            boolean zzf = zzf(parcel.readString());
            parcel2.writeNoException();
            zzaol.zzc(parcel2, zzf);
        } else if (i11 == 3) {
            zzbzo zzc = zzc(parcel.readString());
            parcel2.writeNoException();
            zzaol.zzf(parcel2, zzc);
        } else if (i11 != 4) {
            return false;
        } else {
            boolean zze = zze(parcel.readString());
            parcel2.writeNoException();
            zzaol.zzc(parcel2, zze);
        }
        return true;
    }
}
