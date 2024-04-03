package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.util.UUID;

public final class zzaor {
    public static final int zza;
    public static final UUID zzb = new UUID(0, 0);
    public static final UUID zzc = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID zzd = new UUID(-1301668207276963122L, -6645017420763422227L);
    public static final UUID zze = new UUID(-7348484286925749626L, -6083546864340672619L);

    static {
        int i11;
        if (zzaxb.zza < 23) {
            i11 = 1020;
        } else {
            i11 = 6396;
        }
        zza = i11;
    }

    public static long zza(long j11) {
        return j11 == C.TIME_UNSET ? C.TIME_UNSET : j11 * 1000;
    }

    public static long zzb(long j11) {
        return j11 == C.TIME_UNSET ? C.TIME_UNSET : j11 / 1000;
    }
}
