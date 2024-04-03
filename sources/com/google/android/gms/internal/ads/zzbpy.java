package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzbpy extends zzaok implements zzbpz {
    public zzbpy() {
        super("com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
    }

    public static zzbpz zzc(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
        if (queryLocalInterface instanceof zzbpz) {
            return (zzbpz) queryLocalInterface;
        }
        return new zzbpx(iBinder);
    }

    public final boolean zzbQ(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 2) {
            return false;
        }
        boolean zzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        parcel2.writeNoException();
        zzaol.zzc(parcel2, zzb);
        return true;
    }
}
