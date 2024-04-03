package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzfwq extends zzfws {
    public static <V> zzfwp<V> zza(Iterable<? extends zzfxa<? extends V>> iterable) {
        return new zzfwp<>(false, zzfss.zzl(iterable), (zzfwo) null);
    }

    @SafeVarargs
    public static <V> zzfwp<V> zzb(zzfxa<? extends V>... zzfxaArr) {
        return new zzfwp<>(false, zzfss.zzn(zzfxaArr), (zzfwo) null);
    }

    public static <V> zzfwp<V> zzc(Iterable<? extends zzfxa<? extends V>> iterable) {
        return new zzfwp<>(true, zzfss.zzl(iterable), (zzfwo) null);
    }

    @SafeVarargs
    public static <V> zzfwp<V> zzd(zzfxa<? extends V>... zzfxaArr) {
        return new zzfwp<>(true, zzfss.zzn(zzfxaArr), (zzfwo) null);
    }

    public static <V> zzfxa<List<V>> zze(Iterable<? extends zzfxa<? extends V>> iterable) {
        return new zzfvy(zzfss.zzl(iterable), true);
    }

    public static <V, X extends Throwable> zzfxa<V> zzf(zzfxa<? extends V> zzfxa, Class<X> cls, zzfpv<? super X, ? extends V> zzfpv, Executor executor) {
        zzfvd zzfvd = new zzfvd(zzfxa, cls, zzfpv);
        zzfxa.zzc(zzfvd, zzfxh.zzc(executor, zzfvd));
        return zzfvd;
    }

    public static <V, X extends Throwable> zzfxa<V> zzg(zzfxa<? extends V> zzfxa, Class<X> cls, zzfvx<? super X, ? extends V> zzfvx, Executor executor) {
        zzfvc zzfvc = new zzfvc(zzfxa, cls, zzfvx);
        zzfxa.zzc(zzfvc, zzfxh.zzc(executor, zzfvc));
        return zzfvc;
    }

    public static <V> zzfxa<V> zzh(Throwable th2) {
        th2.getClass();
        return new zzfwt(th2);
    }

    public static <V> zzfxa<V> zzi(V v11) {
        if (v11 == null) {
            return zzfwu.zza;
        }
        return new zzfwu(v11);
    }

    public static zzfxa<Void> zzj() {
        return zzfwu.zza;
    }

    public static <O> zzfxa<O> zzk(Callable<O> callable, Executor executor) {
        zzfxp zzfxp = new zzfxp(callable);
        executor.execute(zzfxp);
        return zzfxp;
    }

    public static <O> zzfxa<O> zzl(zzfvw<O> zzfvw, Executor executor) {
        zzfxp zzfxp = new zzfxp(zzfvw);
        executor.execute(zzfxp);
        return zzfxp;
    }

    public static <I, O> zzfxa<O> zzm(zzfxa<I> zzfxa, zzfpv<? super I, ? extends O> zzfpv, Executor executor) {
        int i11 = zzfvm.zzc;
        zzfpv.getClass();
        zzfvl zzfvl = new zzfvl(zzfxa, zzfpv);
        zzfxa.zzc(zzfvl, zzfxh.zzc(executor, zzfvl));
        return zzfvl;
    }

    public static <I, O> zzfxa<O> zzn(zzfxa<I> zzfxa, zzfvx<? super I, ? extends O> zzfvx, Executor executor) {
        int i11 = zzfvm.zzc;
        executor.getClass();
        zzfvk zzfvk = new zzfvk(zzfxa, zzfvx);
        zzfxa.zzc(zzfvk, zzfxh.zzc(executor, zzfvk));
        return zzfvk;
    }

    public static <V> zzfxa<V> zzo(zzfxa<V> zzfxa, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (zzfxa.isDone()) {
            return zzfxa;
        }
        return zzfxm.zzb(zzfxa, j11, timeUnit, scheduledExecutorService);
    }

    public static <V> V zzp(Future<V> future) throws ExecutionException {
        if (future.isDone()) {
            return zzfxr.zza(future);
        }
        throw new IllegalStateException(zzfqr.zzb("Future was expected to be done: %s", future));
    }

    public static <V> V zzq(Future<V> future) {
        try {
            return zzfxr.zza(future);
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof Error) {
                throw new zzfwf((Error) cause);
            }
            throw new zzfxq(cause);
        }
    }

    public static <V> void zzr(zzfxa<V> zzfxa, zzfwm<? super V> zzfwm, Executor executor) {
        zzfwm.getClass();
        zzfxa.zzc(new zzfwn(zzfxa, zzfwm), executor);
    }
}
