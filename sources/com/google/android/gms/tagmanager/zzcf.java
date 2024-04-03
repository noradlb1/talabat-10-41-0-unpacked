package com.google.android.gms.tagmanager;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gtm.zzm;
import java.util.Map;

public final class zzcf extends zzm implements zzcd {
    public zzcf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.ICustomEvaluatorProxy");
    }

    public final void zzb(String str, Map map) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeMap(map);
        zza(1, obtainAndWriteInterfaceToken);
    }

    public final String zzc(String str, Map map) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeMap(map);
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }
}
