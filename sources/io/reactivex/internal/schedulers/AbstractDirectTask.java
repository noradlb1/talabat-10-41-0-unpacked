package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable, SchedulerRunnableIntrospection {

    /* renamed from: d  reason: collision with root package name */
    public static final FutureTask<Void> f18461d;

    /* renamed from: e  reason: collision with root package name */
    public static final FutureTask<Void> f18462e;
    private static final long serialVersionUID = 1811839108042568751L;

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f18463b;

    /* renamed from: c  reason: collision with root package name */
    public Thread f18464c;

    static {
        Runnable runnable = Functions.EMPTY_RUNNABLE;
        f18461d = new FutureTask<>(runnable, (Object) null);
        f18462e = new FutureTask<>(runnable, (Object) null);
    }

    public AbstractDirectTask(Runnable runnable) {
        this.f18463b = runnable;
    }

    public final void dispose() {
        FutureTask<Void> futureTask;
        boolean z11;
        Future future = (Future) get();
        if (future != f18461d && future != (futureTask = f18462e) && compareAndSet(future, futureTask) && future != null) {
            if (this.f18464c != Thread.currentThread()) {
                z11 = true;
            } else {
                z11 = false;
            }
            future.cancel(z11);
        }
    }

    public Runnable getWrappedRunnable() {
        return this.f18463b;
    }

    public final boolean isDisposed() {
        Future future = (Future) get();
        if (future == f18461d || future == f18462e) {
            return true;
        }
        return false;
    }

    public final void setFuture(Future<?> future) {
        Future future2;
        boolean z11;
        do {
            future2 = (Future) get();
            if (future2 != f18461d) {
                if (future2 == f18462e) {
                    if (this.f18464c != Thread.currentThread()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    future.cancel(z11);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
