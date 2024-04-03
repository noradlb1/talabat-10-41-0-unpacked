package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzaza {
    private final float zza;
    private final float zzb;
    private final float zzc;
    private final float zzd;
    private final int zze;

    @VisibleForTesting
    public zzaza(float f11, float f12, float f13, float f14, int i11) {
        this.zza = f11;
        this.zzb = f12;
        this.zzc = f11 + f13;
        this.zzd = f12 + f14;
        this.zze = i11;
    }

    public final float zza() {
        return this.zzd;
    }

    public final float zzb() {
        return this.zza;
    }

    public final float zzc() {
        return this.zzc;
    }

    public final float zzd() {
        return this.zzb;
    }

    public final int zze() {
        return this.zze;
    }
}
