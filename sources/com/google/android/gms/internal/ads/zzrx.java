package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzrx {
    public final long zza;
    public final long zzb;

    public zzrx(long j11, long j12) {
        this.zza = j11;
        this.zzb = j12;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzrx)) {
            return false;
        }
        zzrx zzrx = (zzrx) obj;
        if (this.zza == zzrx.zza && this.zzb == zzrx.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}
