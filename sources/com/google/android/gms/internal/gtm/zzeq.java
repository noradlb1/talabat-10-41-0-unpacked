package com.google.android.gms.internal.gtm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzeq extends zzm implements zzeo {
    public zzeq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.internal.ITagManagerLoadContainerCallback");
    }

    public final void zza(boolean z11, String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzo.writeBoolean(obtainAndWriteInterfaceToken, z11);
        obtainAndWriteInterfaceToken.writeString(str);
        zzb(1, obtainAndWriteInterfaceToken);
    }
}
