package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class zzcjr<T> implements zzfxa<T> {
    private final zzfxi<T> zza = zzfxi.zza();

    private static final boolean zza(boolean z11) {
        if (!z11) {
            zzt.zzo().zzr(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z11;
    }

    public boolean cancel(boolean z11) {
        return this.zza.cancel(z11);
    }

    public final T get() throws ExecutionException, InterruptedException {
        return this.zza.get();
    }

    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    public final boolean isDone() {
        return this.zza.isDone();
    }

    public final void zzc(Runnable runnable, Executor executor) {
        this.zza.zzc(runnable, executor);
    }

    public final boolean zzd(@Nullable T t11) {
        boolean zzs = this.zza.zzs(t11);
        zza(zzs);
        return zzs;
    }

    public final boolean zze(Throwable th2) {
        boolean zzt = this.zza.zzt(th2);
        zza(zzt);
        return zzt;
    }

    public final T get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zza.get(j11, timeUnit);
    }
}
