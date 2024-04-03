package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbd;

public final class zzcdk extends zzaoj implements zzcdm {
    public zzcdk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    public final void zze(zzbd zzbd) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbd);
        zzbt(2, zza);
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, parcelFileDescriptor);
        zzbt(1, zza);
    }
}
