package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

public final class zzas {
    public static final zzas zza = new zzas(new zzaq());
    public static final zzj<zzas> zzb = zzap.zza;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final float zzf;
    public final float zzg;

    private zzas(zzaq zzaq) {
        this.zzc = C.TIME_UNSET;
        this.zzd = C.TIME_UNSET;
        this.zze = C.TIME_UNSET;
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        long j11 = ((zzas) obj).zzc;
        return true;
    }

    public final int hashCode() {
        int i11 = (int) -9223372034707292159L;
        return (((((((i11 * 31) + i11) * 31) + i11) * 31) + Float.floatToIntBits(-3.4028235E38f)) * 31) + Float.floatToIntBits(-3.4028235E38f);
    }
}
