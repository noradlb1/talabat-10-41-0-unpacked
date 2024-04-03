package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbud extends zzaoj implements zzbuf {
    public zzbud(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    public final void zze(int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zzbt(2, zza);
    }

    public final void zzf() throws RemoteException {
        zzbt(1, zza());
    }
}
