package com.google.android.gms.internal.ads;

public final class zzaua implements zzava {
    private final zzava[] zza;

    public zzaua(zzava[] zzavaArr) {
        this.zza = zzavaArr;
    }

    public final long zza() {
        long j11 = Long.MAX_VALUE;
        for (zzava zza2 : this.zza) {
            long zza3 = zza2.zza();
            if (zza3 != Long.MIN_VALUE) {
                j11 = Math.min(j11, zza3);
            }
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j11;
    }

    public final boolean zzbr(long j11) {
        boolean z11;
        boolean z12 = false;
        do {
            long zza2 = zza();
            if (zza2 == Long.MIN_VALUE) {
                break;
            }
            z11 = false;
            for (zzava zzava : this.zza) {
                if (zzava.zza() == zza2) {
                    z11 |= zzava.zzbr(j11);
                }
            }
            z12 |= z11;
        } while (z11);
        return z12;
    }
}
