package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final /* synthetic */ class zzeja implements zzdat {
    public final /* synthetic */ zzehw zza;

    public /* synthetic */ zzeja(zzehw zzehw) {
        this.zza = zzehw;
    }

    public final zzbiz zza() {
        try {
            return ((zzbzo) this.zza.zzb).zze();
        } catch (RemoteException e11) {
            throw new zzfek(e11);
        }
    }
}
