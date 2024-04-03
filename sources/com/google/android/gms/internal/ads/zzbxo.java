package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbxo extends zzaoj implements zzbxq {
    public zzbxo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    public final IObjectWrapper zze() throws RemoteException {
        Parcel zzbs = zzbs(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }

    public final boolean zzf() throws RemoteException {
        Parcel zzbs = zzbs(2, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }
}
