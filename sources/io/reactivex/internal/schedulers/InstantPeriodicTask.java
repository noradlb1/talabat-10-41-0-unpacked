package io.reactivex.internal.schedulers;

import i.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class InstantPeriodicTask implements Callable<Void>, Disposable {

    /* renamed from: g  reason: collision with root package name */
    public static final FutureTask<Void> f18496g = new FutureTask<>(Functions.EMPTY_RUNNABLE, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f18497b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Future<?>> f18498c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Future<?>> f18499d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f18500e;

    /* renamed from: f  reason: collision with root package name */
    public Thread f18501f;

    public InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.f18497b = runnable;
        this.f18500e = executorService;
    }

    public void a(Future<?> future) {
        Future future2;
        boolean z11;
        do {
            future2 = this.f18499d.get();
            if (future2 == f18496g) {
                if (this.f18501f != Thread.currentThread()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                future.cancel(z11);
                return;
            }
        } while (!b.a(this.f18499d, future2, future));
    }

    public void b(Future<?> future) {
        Future future2;
        boolean z11;
        do {
            future2 = this.f18498c.get();
            if (future2 == f18496g) {
                if (this.f18501f != Thread.currentThread()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                future.cancel(z11);
                return;
            }
        } while (!b.a(this.f18498c, future2, future));
    }

    public void dispose() {
        boolean z11;
        AtomicReference<Future<?>> atomicReference = this.f18499d;
        Future future = f18496g;
        Future andSet = atomicReference.getAndSet(future);
        boolean z12 = true;
        if (!(andSet == null || andSet == future)) {
            if (this.f18501f != Thread.currentThread()) {
                z11 = true;
            } else {
                z11 = false;
            }
            andSet.cancel(z11);
        }
        Future andSet2 = this.f18498c.getAndSet(future);
        if (andSet2 != null && andSet2 != future) {
            if (this.f18501f == Thread.currentThread()) {
                z12 = false;
            }
            andSet2.cancel(z12);
        }
    }

    public boolean isDisposed() {
        return this.f18499d.get() == f18496g;
    }

    public Void call() throws Exception {
        this.f18501f = Thread.currentThread();
        try {
            this.f18497b.run();
            b(this.f18500e.submit(this));
            this.f18501f = null;
        } catch (Throwable th2) {
            this.f18501f = null;
            RxJavaPlugins.onError(th2);
        }
        return null;
    }
}
