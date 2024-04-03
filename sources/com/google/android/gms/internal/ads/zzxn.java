package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzxn {
    public final zzxq zza;
    public final zzxq zzb;

    public zzxn(zzxq zzxq, zzxq zzxq2) {
        this.zza = zzxq;
        this.zzb = zzxq2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzxn.class == obj.getClass()) {
            zzxn zzxn = (zzxn) obj;
            if (!this.zza.equals(zzxn.zza) || !this.zzb.equals(zzxn.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        String obj = this.zza.toString();
        String concat = this.zza.equals(this.zzb) ? "" : IndicativeSentencesGeneration.DEFAULT_SEPARATOR.concat(this.zzb.toString());
        StringBuilder sb2 = new StringBuilder(obj.length() + 2 + concat.length());
        sb2.append("[");
        sb2.append(obj);
        sb2.append(concat);
        sb2.append("]");
        return sb2.toString();
    }
}
