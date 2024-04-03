package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzcep extends zzaoj implements zzcer {
    public zzcep(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(8, zza);
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(6, zza);
    }

    public final void zzg(IObjectWrapper iObjectWrapper, int i11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zza.writeInt(i11);
        zzbt(9, zza);
    }

    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        throw null;
    }

    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(3, zza);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(4, zza);
    }

    public final void zzk(IObjectWrapper iObjectWrapper, int i11) throws RemoteException {
        throw null;
    }

    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(1, zza);
    }

    public final void zzm(IObjectWrapper iObjectWrapper, zzces zzces) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzd(zza, zzces);
        zzbt(7, zza);
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(11, zza);
    }

    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(5, zza);
    }
}
