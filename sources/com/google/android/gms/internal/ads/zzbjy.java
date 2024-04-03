package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;

final class zzbjy extends zzbhc {
    final /* synthetic */ zzbjz zza;

    public /* synthetic */ zzbjy(zzbjz zzbjz, zzbjx zzbjx) {
        this.zza = zzbjz;
    }

    @Nullable
    public final String zze() throws RemoteException {
        return null;
    }

    @Nullable
    public final String zzf() throws RemoteException {
        return null;
    }

    public final void zzg(zzbfd zzbfd) throws RemoteException {
        zzh(zzbfd, 1);
    }

    public final void zzh(zzbfd zzbfd, int i11) throws RemoteException {
        zzciz.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzcis.zza.post(new zzbjw(this));
    }

    public final boolean zzi() throws RemoteException {
        return false;
    }
}
