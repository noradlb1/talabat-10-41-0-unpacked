package com.google.android.gms.internal.ads;

abstract class zzym {
    protected final zzxt zza;

    public zzym(zzxt zzxt) {
        this.zza = zzxt;
    }

    public abstract boolean zza(zzfd zzfd) throws zzbj;

    public abstract boolean zzb(zzfd zzfd, long j11) throws zzbj;

    public final boolean zzf(zzfd zzfd, long j11) throws zzbj {
        return zza(zzfd) && zzb(zzfd, j11);
    }
}
