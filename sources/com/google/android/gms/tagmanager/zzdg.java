package com.google.android.gms.tagmanager;

import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzdg implements zzej {
    private final long zzabf = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
    private final int zzabg = 5;
    private double zzabh = ((double) Math.min(1, 5));
    private long zzabi;
    private final Object zzabj = new Object();
    private final long zzaia = 5000;
    private final Clock zzsd;
    private final String zzup;

    public zzdg(int i11, int i12, long j11, long j12, String str, Clock clock) {
        this.zzup = str;
        this.zzsd = clock;
    }

    public final boolean zzfm() {
        synchronized (this.zzabj) {
            long currentTimeMillis = this.zzsd.currentTimeMillis();
            long j11 = this.zzabi;
            if (currentTimeMillis - j11 < this.zzaia) {
                String str = this.zzup;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 34);
                sb2.append("Excessive ");
                sb2.append(str);
                sb2.append(" detected; call ignored.");
                zzdi.zzac(sb2.toString());
                return false;
            }
            double d11 = this.zzabh;
            int i11 = this.zzabg;
            if (d11 < ((double) i11)) {
                double d12 = ((double) (currentTimeMillis - j11)) / ((double) this.zzabf);
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
            String str2 = this.zzup;
            StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 34);
            sb3.append("Excessive ");
            sb3.append(str2);
            sb3.append(" detected; call ignored.");
            zzdi.zzac(sb3.toString());
            return false;
        }
    }
}
