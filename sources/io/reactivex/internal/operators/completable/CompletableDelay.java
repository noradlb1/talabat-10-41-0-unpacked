package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableDelay extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14629b;

    /* renamed from: c  reason: collision with root package name */
    public final long f14630c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f14631d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f14632e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f14633f;

    public static final class Delay extends AtomicReference<Disposable> implements CompletableObserver, Runnable, Disposable {
        private static final long serialVersionUID = 465972761105851022L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14634b;

        /* renamed from: c  reason: collision with root package name */
        public final long f14635c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f14636d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f14637e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f14638f;

        /* renamed from: g  reason: collision with root package name */
        public Throwable f14639g;

        public Delay(CompletableObserver completableObserver, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
            this.f14634b = completableObserver;
            this.f14635c = j11;
            this.f14636d = timeUnit;
            this.f14637e = scheduler;
            this.f14638f = z11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            DisposableHelper.replace(this, this.f14637e.scheduleDirect(this, this.f14635c, this.f14636d));
        }

        public void onError(Throwable th2) {
            long j11;
            this.f14639g = th2;
            Scheduler scheduler = this.f14637e;
            if (this.f14638f) {
                j11 = this.f14635c;
            } else {
                j11 = 0;
            }
            DisposableHelper.replace(this, scheduler.scheduleDirect(this, j11, this.f14636d));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f14634b.onSubscribe(this);
            }
        }

        public void run() {
            Throwable th2 = this.f14639g;
            this.f14639g = null;
            if (th2 != null) {
                this.f14634b.onError(th2);
            } else {
                this.f14634b.onComplete();
            }
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        this.f14629b = completableSource;
        this.f14630c = j11;
        this.f14631d = timeUnit;
        this.f14632e = scheduler;
        this.f14633f = z11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14629b.subscribe(new Delay(completableObserver, this.f14630c, this.f14631d, this.f14632e, this.f14633f));
    }
}
