package com.google.android.gms.internal.gtm;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

abstract class zzbs {
    private static volatile Handler handler;
    /* access modifiers changed from: private */
    public final zzap zzwc;
    private final Runnable zzys = new zzbt(this);
    /* access modifiers changed from: private */
    public volatile long zzyt;

    public zzbs(zzap zzap) {
        Preconditions.checkNotNull(zzap);
        this.zzwc = zzap;
    }

    private final Handler getHandler() {
        Handler handler2;
        if (handler != null) {
            return handler;
        }
        synchronized (zzbs.class) {
            if (handler == null) {
                handler = new zzdj(this.zzwc.getContext().getMainLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }

    public final void cancel() {
        this.zzyt = 0;
        getHandler().removeCallbacks(this.zzys);
    }

    public abstract void run();

    public final long zzey() {
        if (this.zzyt == 0) {
            return 0;
        }
        return Math.abs(this.zzwc.zzcn().currentTimeMillis() - this.zzyt);
    }

    public final boolean zzez() {
        return this.zzyt != 0;
    }

    public final void zzh(long j11) {
        cancel();
        if (j11 >= 0) {
            this.zzyt = this.zzwc.zzcn().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzys, j11)) {
                this.zzwc.zzco().zze("Failed to schedule delayed post. time", Long.valueOf(j11));
            }
        }
    }

    public final void zzi(long j11) {
        if (zzez()) {
            long j12 = 0;
            if (j11 < 0) {
                cancel();
                return;
            }
            long abs = j11 - Math.abs(this.zzwc.zzcn().currentTimeMillis() - this.zzyt);
            if (abs >= 0) {
                j12 = abs;
            }
            getHandler().removeCallbacks(this.zzys);
            if (!getHandler().postDelayed(this.zzys, j12)) {
                this.zzwc.zzco().zze("Failed to adjust delayed post. time", Long.valueOf(j12));
            }
        }
    }
}
