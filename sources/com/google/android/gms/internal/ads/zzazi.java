package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzazi {
    final long zza;
    final String zzb;
    final int zzc;

    public zzazi(long j11, String str, int i11) {
        this.zza = j11;
        this.zzb = str;
        this.zzc = i11;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zzazi)) {
            zzazi zzazi = (zzazi) obj;
            if (zzazi.zza == this.zza && zzazi.zzc == this.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
