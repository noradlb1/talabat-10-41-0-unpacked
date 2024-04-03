package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableTimeout extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14734b;

    /* renamed from: c  reason: collision with root package name */
    public final long f14735c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f14736d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f14737e;

    /* renamed from: f  reason: collision with root package name */
    public final CompletableSource f14738f;

    public final class DisposeTask implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CompositeDisposable f14739b;

        /* renamed from: c  reason: collision with root package name */
        public final CompletableObserver f14740c;
        private final AtomicBoolean once;

        public final class DisposeObserver implements CompletableObserver {
            public DisposeObserver() {
            }

            public void onComplete() {
                DisposeTask.this.f14739b.dispose();
                DisposeTask.this.f14740c.onComplete();
            }

            public void onError(Throwable th2) {
                DisposeTask.this.f14739b.dispose();
                DisposeTask.this.f14740c.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposeTask.this.f14739b.add(disposable);
            }
        }

        public DisposeTask(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.once = atomicBoolean;
            this.f14739b = compositeDisposable;
            this.f14740c = completableObserver;
        }

        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.f14739b.clear();
                CompletableSource completableSource = CompletableTimeout.this.f14738f;
                if (completableSource == null) {
                    CompletableObserver completableObserver = this.f14740c;
                    CompletableTimeout completableTimeout = CompletableTimeout.this;
                    completableObserver.onError(new TimeoutException(ExceptionHelper.timeoutMessage(completableTimeout.f14735c, completableTimeout.f14736d)));
                    return;
                }
                completableSource.subscribe(new DisposeObserver());
            }
        }
    }

    public static final class TimeOutObserver implements CompletableObserver {
        private final CompletableObserver downstream;
        private final AtomicBoolean once;
        private final CompositeDisposable set;

        public TimeOutObserver(CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
            this.set = compositeDisposable;
            this.once = atomicBoolean;
            this.downstream = completableObserver;
        }

        public void onComplete() {
            if (this.once.compareAndSet(false, true)) {
                this.set.dispose();
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.once.compareAndSet(false, true)) {
                this.set.dispose();
                this.downstream.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }
    }

    public CompletableTimeout(CompletableSource completableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource2) {
        this.f14734b = completableSource;
        this.f14735c = j11;
        this.f14736d = timeUnit;
        this.f14737e = scheduler;
        this.f14738f = completableSource2;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.add(this.f14737e.scheduleDirect(new DisposeTask(atomicBoolean, compositeDisposable, completableObserver), this.f14735c, this.f14736d));
        this.f14734b.subscribe(new TimeOutObserver(compositeDisposable, atomicBoolean, completableObserver));
    }
}
