package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

public final class zzbik implements MuteThisAdReason {
    private final String zza;
    private final zzbij zzb;

    public zzbik(zzbij zzbij) {
        String str;
        this.zzb = zzbij;
        try {
            str = zzbij.zze();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            str = null;
        }
        this.zza = str;
    }

    public final String getDescription() {
        return this.zza;
    }

    public final String toString() {
        return this.zza;
    }

    public final zzbij zza() {
        return this.zzb;
    }
}
