package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbhl extends zzaoj {
    public zzbhl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, zzbfi zzbfi, String str, zzbxh zzbxh, int i11, int i12) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzd(zza, zzbfi);
        zza.writeString(str);
        zzaol.zzf(zza, zzbxh);
        zza.writeInt(214106000);
        zza.writeInt(i12);
        Parcel zzbs = zzbs(2, zza);
        IBinder readStrongBinder = zzbs.readStrongBinder();
        zzbs.recycle();
        return readStrongBinder;
    }
}
