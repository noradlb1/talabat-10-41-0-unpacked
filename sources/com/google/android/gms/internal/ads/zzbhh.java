package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbhh extends zzaoj {
    public zzbhh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, String str, zzbxh zzbxh, int i11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzaol.zzf(zza, zzbxh);
        zza.writeInt(214106000);
        Parcel zzbs = zzbs(1, zza);
        IBinder readStrongBinder = zzbs.readStrongBinder();
        zzbs.recycle();
        return readStrongBinder;
    }
}
