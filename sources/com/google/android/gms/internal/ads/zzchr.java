package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public final class zzchr extends zzaoj implements zzcht {
    public zzchr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzchx zzchx, zzchq zzchq) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzd(zza, zzchx);
        zzaol.zzf(zza, zzchq);
        zzbt(1, zza);
    }

    public final void zzf(zzcco zzcco) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzcco);
        zzbt(7, zza);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(8, zza);
    }

    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(2, zza);
    }

    public final void zzi(List<Uri> list, IObjectWrapper iObjectWrapper, zzcch zzcch) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzcch);
        zzbt(6, zza);
    }

    public final void zzj(List<Uri> list, IObjectWrapper iObjectWrapper, zzcch zzcch) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzcch);
        zzbt(5, zza);
    }
}
