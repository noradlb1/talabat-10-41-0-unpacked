package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

final class zzcv {
    private long startTime;
    private final Clock zzsd;

    public zzcv(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.zzsd = clock;
    }

    public final void clear() {
        this.startTime = 0;
    }

    public final void start() {
        this.startTime = this.zzsd.elapsedRealtime();
    }

    public final boolean zzj(long j11) {
        if (this.startTime != 0 && this.zzsd.elapsedRealtime() - this.startTime <= j11) {
            return false;
        }
        return true;
    }

    public zzcv(Clock clock, long j11) {
        Preconditions.checkNotNull(clock);
        this.zzsd = clock;
        this.startTime = j11;
    }
}
