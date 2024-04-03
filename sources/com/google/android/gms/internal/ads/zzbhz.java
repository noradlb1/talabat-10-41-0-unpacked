package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzbhz extends zzaoj implements zzbib {
    public zzbhz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final float zze() throws RemoteException {
        Parcel zzbs = zzbs(7, zza());
        float readFloat = zzbs.readFloat();
        zzbs.recycle();
        return readFloat;
    }

    public final String zzf() throws RemoteException {
        Parcel zzbs = zzbs(9, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final List<zzbtn> zzg() throws RemoteException {
        Parcel zzbs = zzbs(13, zza());
        ArrayList<zzbtn> createTypedArrayList = zzbs.createTypedArrayList(zzbtn.CREATOR);
        zzbs.recycle();
        return createTypedArrayList;
    }

    public final void zzh(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbt(10, zza);
    }

    public final void zzi() throws RemoteException {
        zzbt(15, zza());
    }

    public final void zzj() throws RemoteException {
        zzbt(1, zza());
    }

    public final void zzk(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(6, zza);
    }

    public final void zzl(zzbin zzbin) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbin);
        zzbt(16, zza);
    }

    public final void zzm(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzbt(5, zza);
    }

    public final void zzn(zzbxh zzbxh) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbxh);
        zzbt(11, zza);
    }

    public final void zzo(boolean z11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzc(zza, z11);
        zzbt(4, zza);
    }

    public final void zzp(float f11) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f11);
        zzbt(2, zza);
    }

    public final void zzq(String str) throws RemoteException {
        throw null;
    }

    public final void zzr(zzbtu zzbtu) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbtu);
        zzbt(12, zza);
    }

    public final void zzs(zzbkk zzbkk) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbkk);
        zzbt(14, zza);
    }

    public final boolean zzt() throws RemoteException {
        Parcel zzbs = zzbs(8, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }
}
