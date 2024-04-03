package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public abstract class zzsv {
    @Nullable
    private zzsu zza;
    @Nullable
    private zzte zzb;

    public abstract zzsw zzi(zzim[] zzimArr, zzch zzch, zzpz zzpz, zzcd zzcd) throws zzgg;

    public abstract void zzj(@Nullable Object obj);

    public final zzte zzk() {
        zzte zzte = this.zzb;
        zzte.getClass();
        return zzte;
    }

    public final void zzl(zzsu zzsu, zzte zzte) {
        this.zza = zzsu;
        this.zzb = zzte;
    }

    public final void zzm() {
        zzsu zzsu = this.zza;
        if (zzsu != null) {
            zzsu.zzj();
        }
    }
}
