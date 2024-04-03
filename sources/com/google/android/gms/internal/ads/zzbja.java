package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbja extends zzaoj implements zzbjc {
    public zzbja(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void zze() throws RemoteException {
        zzbt(4, zza());
    }

    public final void zzf(boolean z11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzc(zza, z11);
        zzbt(5, zza);
    }

    public final void zzg() throws RemoteException {
        zzbt(3, zza());
    }

    public final void zzh() throws RemoteException {
        zzbt(2, zza());
    }

    public final void zzi() throws RemoteException {
        zzbt(1, zza());
    }
}
