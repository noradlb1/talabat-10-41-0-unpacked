package io.reactivex.rxjava3.internal.schedulers;

import i.b;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class InstantPeriodicTask implements Callable<Void>, Disposable {

    /* renamed from: g  reason: collision with root package name */
    public static final FutureTask<Void> f23054g = new FutureTask<>(Functions.EMPTY_RUNNABLE, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f23055b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Future<?>> f23056c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Future<?>> f23057d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f23058e;

    /* renamed from: f  reason: collision with root package name */
    public Thread f23059f;

    public InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.f23055b = runnable;
        this.f23058e = executorService;
    }

    public void a(Future<?> future) {
        Future future2;
        boolean z11;
        do {
            future2 = this.f23057d.get();
            if (future2 == f23054g) {
                if (this.f23059f != Thread.currentThread()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                future.cancel(z11);
                return;
            }
        } while (!b.a(this.f23057d, future2, future));
    }

    public void b(Future<?> future) {
        Future future2;
        boolean z11;
        do {
            future2 = this.f23056c.get();
            if (future2 == f23054g) {
                if (this.f23059f != Thread.currentThread()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                future.cancel(z11);
                return;
            }
        } while (!b.a(this.f23056c, future2, future));
    }

    public void dispose() {
        boolean z11;
        AtomicReference<Future<?>> atomicReference = this.f23057d;
        Future future = f23054g;
        Future andSet = atomicReference.getAndSet(future);
        boolean z12 = true;
        if (!(andSet == null || andSet == future)) {
            if (this.f23059f != Thread.currentThread()) {
                z11 = true;
            } else {
                z11 = false;
            }
            andSet.cancel(z11);
        }
        Future andSet2 = this.f23056c.getAndSet(future);
        if (andSet2 != null && andSet2 != future) {
            if (this.f23059f == Thread.currentThread()) {
                z12 = false;
            }
            andSet2.cancel(z12);
        }
    }

    public boolean isDisposed() {
        return this.f23057d.get() == f23054g;
    }

    public Void call() {
        this.f23059f = Thread.currentThread();
        try {
            this.f23055b.run();
            this.f23059f = null;
            b(this.f23058e.submit(this));
            return null;
        } catch (Throwable th2) {
            this.f23059f = null;
            RxJavaPlugins.onError(th2);
            throw th2;
        }
    }
}
