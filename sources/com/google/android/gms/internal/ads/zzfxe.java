package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzfxe<V> extends zzfwk<V> implements ScheduledFuture<V> {
    private final ScheduledFuture<?> zza;

    public zzfxe(zzfxa<V> zzfxa, ScheduledFuture<?> scheduledFuture) {
        super(zzfxa);
        this.zza = scheduledFuture;
    }

    public final boolean cancel(boolean z11) {
        boolean cancel = zzb().cancel(z11);
        if (cancel) {
            this.zza.cancel(z11);
        }
        return cancel;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zza.compareTo((Delayed) obj);
    }

    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
