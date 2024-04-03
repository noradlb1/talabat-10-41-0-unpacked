package com.google.android.gms.vision.clearcut;

import javax.annotation.concurrent.GuardedBy;

public final class zzb {
    private final Object lock = new Object();
    private final long zzbt = Math.round(30000.0d);
    @GuardedBy("lock")
    private long zzbu = Long.MIN_VALUE;

    public zzb(double d11) {
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zzbu + this.zzbt > currentTimeMillis) {
                return false;
            }
            this.zzbu = currentTimeMillis;
            return true;
        }
    }
}
