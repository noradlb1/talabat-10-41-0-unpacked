package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbhp extends zzaoj implements zzbhr {
    public zzbhp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public final void zzc(String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbt(1, zza);
    }
}
