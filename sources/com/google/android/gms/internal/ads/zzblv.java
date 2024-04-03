package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
public final class zzblv {
    private final long zza;
    @Nullable
    private final String zzb;
    @Nullable
    private final zzblv zzc;

    public zzblv(long j11, @Nullable String str, @Nullable zzblv zzblv) {
        this.zza = j11;
        this.zzb = str;
        this.zzc = zzblv;
    }

    public final long zza() {
        return this.zza;
    }

    @Nullable
    public final zzblv zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zzb;
    }
}
