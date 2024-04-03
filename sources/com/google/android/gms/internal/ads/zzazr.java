package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzazr extends zzaoj implements zzazt {
    public zzazr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public final zzbhk zze() throws RemoteException {
        throw null;
    }

    public final zzbiw zzf() throws RemoteException {
        Parcel zzbs = zzbs(5, zza());
        zzbiw zzb = zzbiv.zzb(zzbs.readStrongBinder());
        zzbs.recycle();
        return zzb;
    }

    public final void zzg(boolean z11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzc(zza, z11);
        zzbt(6, zza);
    }

    public final void zzh(zzbit zzbit) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbit);
        zzbt(7, zza);
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzbaa zzbaa) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzbaa);
        zzbt(4, zza);
    }

    public final void zzj(zzazx zzazx) throws RemoteException {
        throw null;
    }
}
