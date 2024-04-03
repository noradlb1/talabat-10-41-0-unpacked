package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.gtm.zzm;
import com.google.android.gms.internal.gtm.zzo;
import java.util.HashMap;
import java.util.Map;

public final class zzco extends zzm implements zzcm {
    public zzco(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.IMeasurementProxy");
    }

    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j11) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzo.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle);
        obtainAndWriteInterfaceToken.writeLong(j11);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzcj zzcj) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzo.zza(obtainAndWriteInterfaceToken, (IInterface) zzcj);
        zza(21, obtainAndWriteInterfaceToken);
    }

    public final Map zzib() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
        HashMap zzb = zzo.zzb(transactAndReadException);
        transactAndReadException.recycle();
        return zzb;
    }

    public final void zza(zzcg zzcg) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzo.zza(obtainAndWriteInterfaceToken, (IInterface) zzcg);
        zza(22, obtainAndWriteInterfaceToken);
    }
}
