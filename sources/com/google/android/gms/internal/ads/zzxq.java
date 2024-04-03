package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzxq {
    public static final zzxq zza = new zzxq(0, 0);
    public final long zzb;
    public final long zzc;

    public zzxq(long j11, long j12) {
        this.zzb = j11;
        this.zzc = j12;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzxq.class == obj.getClass()) {
            zzxq zzxq = (zzxq) obj;
            return this.zzb == zzxq.zzb && this.zzc == zzxq.zzc;
        }
    }

    public final int hashCode() {
        return (((int) this.zzb) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        long j11 = this.zzb;
        long j12 = this.zzc;
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("[timeUs=");
        sb2.append(j11);
        sb2.append(", position=");
        sb2.append(j12);
        sb2.append("]");
        return sb2.toString();
    }
}
