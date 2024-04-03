package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class zzfk {
    @GuardedBy("this")
    private long zza;
    @GuardedBy("this")
    private long zzb;
    @GuardedBy("this")
    private long zzc;
    private final ThreadLocal<Long> zzd = new ThreadLocal<>();

    public zzfk(long j11) {
        zzf(0);
    }

    public final synchronized long zza(long j11) {
        if (this.zzb == C.TIME_UNSET) {
            long j12 = this.zza;
            if (j12 == TimestampAdjuster.MODE_SHARED) {
                Long l11 = this.zzd.get();
                l11.getClass();
                j12 = l11.longValue();
            }
            this.zzb = j12 - j11;
            notifyAll();
        }
        this.zzc = j11;
        return j11 + this.zzb;
    }

    public final synchronized long zzb(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j12 = this.zzc;
        if (j12 != C.TIME_UNSET) {
            long j13 = (j12 * 90000) / 1000000;
            long j14 = (4294967296L + j13) / 8589934592L;
            long j15 = ((-1 + j14) * 8589934592L) + j11;
            j11 += j14 * 8589934592L;
            if (Math.abs(j15 - j13) < Math.abs(j11 - j13)) {
                j11 = j15;
            }
        }
        return zza((j11 * 1000000) / 90000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        return com.google.android.exoplayer2.C.TIME_UNSET;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzc() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.zza     // Catch:{ all -> 0x001f }
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0018
            r2 = 9223372036854775806(0x7ffffffffffffffe, double:NaN)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            monitor-exit(r4)
            return r0
        L_0x0018:
            monitor-exit(r4)
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            return r0
        L_0x001f:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfk.zzc():long");
    }

    public final synchronized long zzd() {
        long j11;
        j11 = this.zzc;
        return j11 != C.TIME_UNSET ? j11 + this.zzb : zzc();
    }

    public final synchronized long zze() {
        return this.zzb;
    }

    public final synchronized void zzf(long j11) {
        this.zza = j11;
        this.zzb = j11 == Long.MAX_VALUE ? 0 : -9223372036854775807L;
        this.zzc = C.TIME_UNSET;
    }
}
