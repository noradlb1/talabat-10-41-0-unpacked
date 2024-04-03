package com.google.android.recaptcha.internal;

import com.google.android.exoplayer2.C;
import org.threeten.bp.Year;

public final class zzkp {
    public static final zzgn zza;
    public static final zzgn zzb;
    public static final zzgn zzc;

    static {
        zzgm zzi = zzgn.zzi();
        zzi.zze(-315576000000L);
        zzi.zzd(Year.MIN_VALUE);
        zza = (zzgn) zzi.zzj();
        zzgm zzi2 = zzgn.zzi();
        zzi2.zze(315576000000L);
        zzi2.zzd(Year.MAX_VALUE);
        zzb = (zzgn) zzi2.zzj();
        zzgm zzi3 = zzgn.zzi();
        zzi3.zze(0);
        zzi3.zzd(0);
        zzc = (zzgn) zzi3.zzj();
    }

    public static zzgn zza(long j11) {
        return zzc(j11 / 1000, (int) ((j11 % 1000) * 1000000));
    }

    public static zzgn zzb(long j11) {
        return zzc(j11 / C.NANOS_PER_SECOND, (int) (j11 % C.NANOS_PER_SECOND));
    }

    public static zzgn zzc(long j11, int i11) {
        int i12;
        if (i11 <= -1000000000 || i11 >= 1000000000) {
            j11 = zzen.zza(j11, (long) (i11 / 1000000000));
            i11 %= 1000000000;
        }
        if (j11 > 0 && i11 < 0) {
            i11 += 1000000000;
            j11--;
        }
        if (j11 < 0 && i11 > 0) {
            i11 -= 1000000000;
            j11++;
        }
        zzgm zzi = zzgn.zzi();
        zzi.zze(j11);
        zzi.zzd(i11);
        zzgn zzgn = (zzgn) zzi.zzj();
        long zzg = zzgn.zzg();
        int zzf = zzgn.zzf();
        if (zzg >= -315576000000L && zzg <= 315576000000L && ((long) zzf) >= -999999999 && zzf < 1000000000 && ((zzg >= 0 && zzf >= 0) || (i12 <= 0 && zzf <= 0))) {
            return zzgn;
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", new Object[]{Long.valueOf(zzg), Integer.valueOf(zzf)}));
    }
}
