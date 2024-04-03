package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbzm extends zzaoj implements zzbzo {
    public zzbzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final zzbiz zze() throws RemoteException {
        Parcel zzbs = zzbs(5, zza());
        zzbiz zzb = zzbiy.zzb(zzbs.readStrongBinder());
        zzbs.recycle();
        return zzb;
    }

    public final zzcab zzf() throws RemoteException {
        Parcel zzbs = zzbs(2, zza());
        zzcab zzcab = (zzcab) zzaol.zza(zzbs, zzcab.CREATOR);
        zzbs.recycle();
        return zzcab;
    }

    public final zzcab zzg() throws RemoteException {
        Parcel zzbs = zzbs(3, zza());
        zzcab zzcab = (zzcab) zzaol.zza(zzbs, zzcab.CREATOR);
        zzbs.recycle();
        return zzcab;
    }

    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzbfi zzbfi, zzbzr zzbzr) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzaol.zzd(zza, bundle);
        zzaol.zzd(zza, bundle2);
        zzaol.zzd(zza, zzbfi);
        zzaol.zzf(zza, zzbzr);
        zzbt(1, zza);
    }

    public final void zzi(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzc zzbzc, zzbxn zzbxn, zzbfi zzbfi) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaol.zzd(zza, zzbfd);
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzbzc);
        zzaol.zzf(zza, zzbxn);
        zzaol.zzd(zza, zzbfi);
        zzbt(13, zza);
    }

    public final void zzj(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzc zzbzc, zzbxn zzbxn, zzbfi zzbfi) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaol.zzd(zza, zzbfd);
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzbzc);
        zzaol.zzf(zza, zzbxn);
        zzaol.zzd(zza, zzbfi);
        zzbt(21, zza);
    }

    public final void zzk(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzf zzbzf, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaol.zzd(zza, zzbfd);
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzbzf);
        zzaol.zzf(zza, zzbxn);
        zzbt(14, zza);
    }

    public final void zzl(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzi zzbzi, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaol.zzd(zza, zzbfd);
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzbzi);
        zzaol.zzf(zza, zzbxn);
        zzbt(18, zza);
    }

    public final void zzm(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzi zzbzi, zzbxn zzbxn, zzbnw zzbnw) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaol.zzd(zza, zzbfd);
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzbzi);
        zzaol.zzf(zza, zzbxn);
        zzaol.zzd(zza, zzbnw);
        zzbt(22, zza);
    }

    public final void zzn(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzl zzbzl, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaol.zzd(zza, zzbfd);
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzbzl);
        zzaol.zzf(zza, zzbxn);
        zzbt(20, zza);
    }

    public final void zzo(String str, String str2, zzbfd zzbfd, IObjectWrapper iObjectWrapper, zzbzl zzbzl, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaol.zzd(zza, zzbfd);
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzbzl);
        zzaol.zzf(zza, zzbxn);
        zzbt(16, zza);
    }

    public final void zzp(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbt(19, zza);
    }

    public final boolean zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        Parcel zzbs = zzbs(15, zza);
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        Parcel zzbs = zzbs(17, zza);
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }
}
