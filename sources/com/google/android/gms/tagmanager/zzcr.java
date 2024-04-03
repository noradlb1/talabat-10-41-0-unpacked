package com.google.android.gms.tagmanager;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.gtm.zzm;
import com.google.android.gms.internal.gtm.zzo;

public final class zzcr extends zzm implements zzcp {
    public zzcr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.ITagManagerApi");
    }

    public final void initialize(IObjectWrapper iObjectWrapper, zzcm zzcm, zzcd zzcd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzo.zza(obtainAndWriteInterfaceToken, (IInterface) zzcm);
        zzo.zza(obtainAndWriteInterfaceToken, (IInterface) zzcd);
        zza(1, obtainAndWriteInterfaceToken);
    }

    public final void preview(Intent intent, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzo.zza(obtainAndWriteInterfaceToken, (Parcelable) intent);
        zzo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final void previewIntent(Intent intent, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, zzcm zzcm, zzcd zzcd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzo.zza(obtainAndWriteInterfaceToken, (Parcelable) intent);
        zzo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
        zzo.zza(obtainAndWriteInterfaceToken, (IInterface) zzcm);
        zzo.zza(obtainAndWriteInterfaceToken, (IInterface) zzcd);
        zza(3, obtainAndWriteInterfaceToken);
    }
}
