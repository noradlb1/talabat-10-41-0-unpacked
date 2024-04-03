package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbxl extends zzaoj implements zzbxn {
    public zzbxl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void zze() throws RemoteException {
        zzbt(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzbt(2, zza());
    }

    public final void zzg(int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zzbt(3, zza);
    }

    public final void zzh(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(23, zza);
    }

    public final void zzi(int i11, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zza.writeString(str);
        zzbt(22, zza);
    }

    public final void zzj(int i11) throws RemoteException {
        throw null;
    }

    public final void zzk(zzbew zzbew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbew);
        zzbt(24, zza);
    }

    public final void zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbt(21, zza);
    }

    public final void zzm() throws RemoteException {
        zzbt(8, zza());
    }

    public final void zzn() throws RemoteException {
        zzbt(4, zza());
    }

    public final void zzo() throws RemoteException {
        zzbt(6, zza());
    }

    public final void zzp() throws RemoteException {
        zzbt(5, zza());
    }

    public final void zzq(String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbt(9, zza);
    }

    public final void zzr(zzbpc zzbpc, String str) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbpc);
        zza.writeString(str);
        zzbt(10, zza);
    }

    public final void zzs(zzces zzces) throws RemoteException {
        throw null;
    }

    public final void zzt(zzcew zzcew) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzcew);
        zzbt(16, zza);
    }

    public final void zzu() throws RemoteException {
        zzbt(18, zza());
    }

    public final void zzv() throws RemoteException {
        zzbt(11, zza());
    }

    public final void zzw() throws RemoteException {
        zzbt(15, zza());
    }

    public final void zzx() throws RemoteException {
        zzbt(20, zza());
    }

    public final void zzy() throws RemoteException {
        zzbt(13, zza());
    }
}
