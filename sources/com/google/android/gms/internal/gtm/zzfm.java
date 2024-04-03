package com.google.android.gms.internal.gtm;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

final class zzfm implements zzfe {
    private final long zzabf;
    private final int zzabg;
    private double zzabh;
    private final Object zzabj;
    private long zzakm;
    private Clock zzsd;

    private zzfm(int i11, long j11) {
        this.zzabj = new Object();
        this.zzabg = 60;
        this.zzabh = (double) 60;
        this.zzabf = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        this.zzsd = DefaultClock.getInstance();
    }

    public final boolean zzfm() {
        synchronized (this.zzabj) {
            long currentTimeMillis = this.zzsd.currentTimeMillis();
            double d11 = this.zzabh;
            int i11 = this.zzabg;
            if (d11 < ((double) i11)) {
                double d12 = ((double) (currentTimeMillis - this.zzakm)) / ((double) this.zzabf);
                if (d12 > 0.0d) {
                    this.zzabh = Math.min((double) i11, d11 + d12);
                }
            }
            this.zzakm = currentTimeMillis;
            double d13 = this.zzabh;
            if (d13 >= 1.0d) {
                this.zzabh = d13 - 1.0d;
                return true;
            }
            zzev.zzac("No more tokens available.");
            return false;
        }
    }

    public zzfm() {
        this(60, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }
}
