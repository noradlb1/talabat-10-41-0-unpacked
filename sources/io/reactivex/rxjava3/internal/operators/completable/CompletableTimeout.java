package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableTimeout extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19226b;

    /* renamed from: c  reason: collision with root package name */
    public final long f19227c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f19228d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f19229e;

    /* renamed from: f  reason: collision with root package name */
    public final CompletableSource f19230f;

    public final class DisposeTask implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CompositeDisposable f19231b;

        /* renamed from: c  reason: collision with root package name */
        public final CompletableObserver f19232c;
        private final AtomicBoolean once;

        public final class DisposeObserver implements CompletableObserver {
            public DisposeObserver() {
            }

            public void onComplete() {
                DisposeTask.this.f19231b.dispose();
                DisposeTask.this.f19232c.onComplete();
            }

            public void onError(Throwable th2) {
                DisposeTask.this.f19231b.dispose();
                DisposeTask.this.f19232c.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposeTask.this.f19231b.add(disposable);
            }
        }

        public DisposeTask(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.once = atomicBoolean;
            this.f19231b = compositeDisposable;
            this.f19232c = completableObserver;
        }

        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.f19231b.clear();
                CompletableSource completableSource = CompletableTimeout.this.f19230f;
                if (completableSource == null) {
                    CompletableObserver completableObserver = this.f19232c;
                    CompletableTimeout completableTimeout = CompletableTimeout.this;
                    completableObserver.onError(new TimeoutException(ExceptionHelper.timeoutMessage(completableTimeout.f19227c, completableTimeout.f19228d)));
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
        this.f19226b = completableSource;
        this.f19227c = j11;
        this.f19228d = timeUnit;
        this.f19229e = scheduler;
        this.f19230f = completableSource2;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.add(this.f19229e.scheduleDirect(new DisposeTask(atomicBoolean, compositeDisposable, completableObserver), this.f19227c, this.f19228d));
        this.f19226b.subscribe(new TimeOutObserver(compositeDisposable, atomicBoolean, completableObserver));
    }
}
