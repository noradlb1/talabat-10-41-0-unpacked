package com.google.android.gms.internal.gtm;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzcg {
    private final long zzabf;
    private final int zzabg;
    private double zzabh;
    private long zzabi;
    private final Object zzabj;
    private final Clock zzsd;
    private final String zzup;

    private zzcg(int i11, long j11, String str, Clock clock) {
        this.zzabj = new Object();
        this.zzabg = 60;
        this.zzabh = (double) 60;
        this.zzabf = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        this.zzup = str;
        this.zzsd = clock;
    }

    public final boolean zzfm() {
        synchronized (this.zzabj) {
            long currentTimeMillis = this.zzsd.currentTimeMillis();
            double d11 = this.zzabh;
            int i11 = this.zzabg;
            if (d11 < ((double) i11)) {
                double d12 = ((double) (currentTimeMillis - this.zzabi)) / ((double) this.zzabf);
                if (d12 > 0.0d) {
                    this.zzabh = Math.min((double) i11, d11 + d12);
                }
            }
            this.zzabi = currentTimeMillis;
            double d13 = this.zzabh;
            if (d13 >= 1.0d) {
                this.zzabh = d13 - 1.0d;
                return true;
            }
            String str = this.zzup;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 34);
            sb2.append("Excessive ");
            sb2.append(str);
            sb2.append(" detected; call ignored.");
            zzch.zzac(sb2.toString());
            return false;
        }
    }

    public zzcg(String str, Clock clock) {
        this(60, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, str, clock);
    }
}
