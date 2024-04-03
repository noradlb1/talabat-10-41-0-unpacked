package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

final class zzqx {
    public final int zza;
    public final boolean zzb;

    public zzqx(int i11, boolean z11) {
        this.zza = i11;
        this.zzb = z11;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzqx.class == obj.getClass()) {
            zzqx zzqx = (zzqx) obj;
            return this.zza == zzqx.zza && this.zzb == zzqx.zzb;
        }
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
