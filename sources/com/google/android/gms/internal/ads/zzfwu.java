package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

final class zzfwu<V> implements zzfxa<V> {
    static final zzfxa<?> zza = new zzfwu((Object) null);
    private static final Logger zzb = Logger.getLogger(zzfwu.class.getName());
    private final V zzc;

    public zzfwu(V v11) {
        this.zzc = v11;
    }

    public final boolean cancel(boolean z11) {
        return false;
    }

    public final V get() {
        return this.zzc;
    }

    public final V get(long j11, TimeUnit timeUnit) throws ExecutionException {
        timeUnit.getClass();
        return this.zzc;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.zzc);
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 27 + valueOf.length());
        sb2.append(obj);
        sb2.append("[status=SUCCESS, result=[");
        sb2.append(valueOf);
        sb2.append("]]");
        return sb2.toString();
    }

    public final void zzc(Runnable runnable, Executor executor) {
        zzfqg.zzc(runnable, "Runnable was null.");
        zzfqg.zzc(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb2.append("RuntimeException while executing runnable ");
            sb2.append(valueOf);
            sb2.append(" with executor ");
            sb2.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", sb2.toString(), e11);
        }
    }
}
