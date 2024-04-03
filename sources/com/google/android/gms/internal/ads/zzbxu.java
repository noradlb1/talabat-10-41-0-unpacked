package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzbxu extends zzaoj implements zzbxw {
    public zzbxu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public final boolean zzA() throws RemoteException {
        Parcel zzbs = zzbs(18, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final boolean zzB() throws RemoteException {
        Parcel zzbs = zzbs(17, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final double zze() throws RemoteException {
        Parcel zzbs = zzbs(8, zza());
        double readDouble = zzbs.readDouble();
        zzbs.recycle();
        return readDouble;
    }

    public final float zzf() throws RemoteException {
        Parcel zzbs = zzbs(23, zza());
        float readFloat = zzbs.readFloat();
        zzbs.recycle();
        return readFloat;
    }

    public final float zzg() throws RemoteException {
        Parcel zzbs = zzbs(25, zza());
        float readFloat = zzbs.readFloat();
        zzbs.recycle();
        return readFloat;
    }

    public final float zzh() throws RemoteException {
        Parcel zzbs = zzbs(24, zza());
        float readFloat = zzbs.readFloat();
        zzbs.recycle();
        return readFloat;
    }

    public final Bundle zzi() throws RemoteException {
        Parcel zzbs = zzbs(16, zza());
        Bundle bundle = (Bundle) zzaol.zza(zzbs, Bundle.CREATOR);
        zzbs.recycle();
        return bundle;
    }

    public final zzbiz zzj() throws RemoteException {
        Parcel zzbs = zzbs(11, zza());
        zzbiz zzb = zzbiy.zzb(zzbs.readStrongBinder());
        zzbs.recycle();
        return zzb;
    }

    public final zzboa zzk() throws RemoteException {
        Parcel zzbs = zzbs(12, zza());
        zzboa zzj = zzbnz.zzj(zzbs.readStrongBinder());
        zzbs.recycle();
        return zzj;
    }

    public final zzboi zzl() throws RemoteException {
        Parcel zzbs = zzbs(5, zza());
        zzboi zzg = zzboh.zzg(zzbs.readStrongBinder());
        zzbs.recycle();
        return zzg;
    }

    public final IObjectWrapper zzm() throws RemoteException {
        Parcel zzbs = zzbs(13, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzbs = zzbs(14, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzo() throws RemoteException {
        Parcel zzbs = zzbs(15, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }

    public final String zzp() throws RemoteException {
        Parcel zzbs = zzbs(7, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzq() throws RemoteException {
        Parcel zzbs = zzbs(4, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzr() throws RemoteException {
        Parcel zzbs = zzbs(6, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzs() throws RemoteException {
        Parcel zzbs = zzbs(2, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzt() throws RemoteException {
        Parcel zzbs = zzbs(10, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzu() throws RemoteException {
        Parcel zzbs = zzbs(9, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final List zzv() throws RemoteException {
        Parcel zzbs = zzbs(3, zza());
        ArrayList zzb = zzaol.zzb(zzbs);
        zzbs.recycle();
        return zzb;
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(20, zza);
    }

    public final void zzx() throws RemoteException {
        zzbt(19, zza());
    }

    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, iObjectWrapper2);
        zzaol.zzf(zza, iObjectWrapper3);
        zzbt(21, zza);
    }

    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(22, zza);
    }
}
