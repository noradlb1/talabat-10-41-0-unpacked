package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzcbf extends zzaok implements zzcbg {
    public zzcbf() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzcbg zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        if (queryLocalInterface instanceof zzcbg) {
            return (zzcbg) queryLocalInterface;
        }
        return new zzcbe(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zze((Intent) zzaol.zza(parcel, Intent.CREATOR));
        } else if (i11 == 2) {
            zzg(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
        } else if (i11 != 3) {
            return false;
        } else {
            zzf();
        }
        parcel2.writeNoException();
        return true;
    }
}
