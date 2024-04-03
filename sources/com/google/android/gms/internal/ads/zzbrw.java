package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbrw {
    private boolean zza = false;
    private boolean zzb = false;
    private float zzc = 0.0f;
    private final AtomicBoolean zzd = new AtomicBoolean(false);

    public final synchronized float zza() {
        return this.zzc;
    }

    public final synchronized void zzb(boolean z11, float f11) {
        this.zzb = z11;
        this.zzc = f11;
    }

    public final synchronized void zzc(boolean z11) {
        this.zza = z11;
        this.zzd.set(true);
    }

    public final synchronized boolean zzd() {
        return this.zzb;
    }

    public final synchronized boolean zze(boolean z11) {
        if (!this.zzd.get()) {
            return z11;
        }
        return this.zza;
    }
}
