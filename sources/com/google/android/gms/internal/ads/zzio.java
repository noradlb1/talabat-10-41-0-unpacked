package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzio {
    public static final zzio zza;
    public static final zzio zzb = new zzio(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final zzio zzc = new zzio(Long.MAX_VALUE, 0);
    public static final zzio zzd = new zzio(0, Long.MAX_VALUE);
    public static final zzio zze;
    public final long zzf;
    public final long zzg;

    static {
        zzio zzio = new zzio(0, 0);
        zza = zzio;
        zze = zzio;
    }

    public zzio(long j11, long j12) {
        boolean z11;
        boolean z12 = true;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzd(z11);
        zzdy.zzd(j12 < 0 ? false : z12);
        this.zzf = j11;
        this.zzg = j12;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzio.class == obj.getClass()) {
            zzio zzio = (zzio) obj;
            return this.zzf == zzio.zzf && this.zzg == zzio.zzg;
        }
    }

    public final int hashCode() {
        return (((int) this.zzf) * 31) + ((int) this.zzg);
    }
}
