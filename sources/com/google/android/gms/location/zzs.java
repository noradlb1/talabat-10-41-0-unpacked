package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zza;

public final class zzs extends zza implements zzu {
    public zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationListener");
    }

    public final void zzd(Location location) throws RemoteException {
        throw null;
    }

    public final void zze() throws RemoteException {
        throw null;
    }
}
