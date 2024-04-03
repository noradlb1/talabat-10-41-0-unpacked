package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.gtm.zzm;
import com.google.android.gms.internal.gtm.zzo;

public final class zzci extends zzm implements zzcg {
    public zzci(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.IMeasurementEventListener");
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j11) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzo.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle);
        obtainAndWriteInterfaceToken.writeLong(j11);
        zza(1, obtainAndWriteInterfaceToken);
    }
}
