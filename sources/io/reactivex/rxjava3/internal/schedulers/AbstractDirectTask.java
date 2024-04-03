package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable, SchedulerRunnableIntrospection {

    /* renamed from: e  reason: collision with root package name */
    public static final FutureTask<Void> f23016e;

    /* renamed from: f  reason: collision with root package name */
    public static final FutureTask<Void> f23017f;
    private static final long serialVersionUID = 1811839108042568751L;

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f23018b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f23019c;

    /* renamed from: d  reason: collision with root package name */
    public Thread f23020d;

    static {
        Runnable runnable = Functions.EMPTY_RUNNABLE;
        f23016e = new FutureTask<>(runnable, (Object) null);
        f23017f = new FutureTask<>(runnable, (Object) null);
    }

    public AbstractDirectTask(Runnable runnable, boolean z11) {
        this.f23018b = runnable;
        this.f23019c = z11;
    }

    private void cancelFuture(Future<?> future) {
        if (this.f23020d == Thread.currentThread()) {
            future.cancel(false);
        } else {
            future.cancel(this.f23019c);
        }
    }

    public final void dispose() {
        FutureTask<Void> futureTask;
        Future future = (Future) get();
        if (future != f23016e && future != (futureTask = f23017f) && compareAndSet(future, futureTask) && future != null) {
            cancelFuture(future);
        }
    }

    public Runnable getWrappedRunnable() {
        return this.f23018b;
    }

    public final boolean isDisposed() {
        Future future = (Future) get();
        if (future == f23016e || future == f23017f) {
            return true;
        }
        return false;
    }

    public final void setFuture(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 != f23016e) {
                if (future2 == f23017f) {
                    cancelFuture(future);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    public String toString() {
        String str;
        Future future = (Future) get();
        if (future == f23016e) {
            str = "Finished";
        } else if (future == f23017f) {
            str = "Disposed";
        } else if (this.f23020d != null) {
            str = "Running on " + this.f23020d;
        } else {
            str = "Waiting";
        }
        return getClass().getSimpleName() + "[" + str + "]";
    }
}
