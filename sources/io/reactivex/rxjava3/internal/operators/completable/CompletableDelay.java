package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableDelay extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19114b;

    /* renamed from: c  reason: collision with root package name */
    public final long f19115c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f19116d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f19117e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f19118f;

    public static final class Delay extends AtomicReference<Disposable> implements CompletableObserver, Runnable, Disposable {
        private static final long serialVersionUID = 465972761105851022L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19119b;

        /* renamed from: c  reason: collision with root package name */
        public final long f19120c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f19121d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f19122e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f19123f;

        /* renamed from: g  reason: collision with root package name */
        public Throwable f19124g;

        public Delay(CompletableObserver completableObserver, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
            this.f19119b = completableObserver;
            this.f19120c = j11;
            this.f19121d = timeUnit;
            this.f19122e = scheduler;
            this.f19123f = z11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            DisposableHelper.replace(this, this.f19122e.scheduleDirect(this, this.f19120c, this.f19121d));
        }

        public void onError(Throwable th2) {
            long j11;
            this.f19124g = th2;
            Scheduler scheduler = this.f19122e;
            if (this.f19123f) {
                j11 = this.f19120c;
            } else {
                j11 = 0;
            }
            DisposableHelper.replace(this, scheduler.scheduleDirect(this, j11, this.f19121d));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f19119b.onSubscribe(this);
            }
        }

        public void run() {
            Throwable th2 = this.f19124g;
            this.f19124g = null;
            if (th2 != null) {
                this.f19119b.onError(th2);
            } else {
                this.f19119b.onComplete();
            }
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        this.f19114b = completableSource;
        this.f19115c = j11;
        this.f19116d = timeUnit;
        this.f19117e = scheduler;
        this.f19118f = z11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19114b.subscribe(new Delay(completableObserver, this.f19115c, this.f19116d, this.f19117e, this.f19118f));
    }
}
