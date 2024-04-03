package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleLatest<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17800c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f17801d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f17802e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f17803f;

    public static final class ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17804b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17805c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f17806d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f17807e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f17808f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<T> f17809g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public Disposable f17810h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f17811i;

        /* renamed from: j  reason: collision with root package name */
        public Throwable f17812j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f17813k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f17814l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f17815m;

        public ThrottleLatestObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker, boolean z11) {
            this.f17804b = observer;
            this.f17805c = j11;
            this.f17806d = timeUnit;
            this.f17807e = worker;
            this.f17808f = z11;
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.f17809g;
                Observer<? super T> observer = this.f17804b;
                int i11 = 1;
                while (!this.f17813k) {
                    boolean z12 = this.f17811i;
                    if (!z12 || this.f17812j == null) {
                        if (atomicReference.get() == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12) {
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (!z11 && this.f17808f) {
                                observer.onNext(andSet);
                            }
                            observer.onComplete();
                            this.f17807e.dispose();
                            return;
                        }
                        if (z11) {
                            if (this.f17814l) {
                                this.f17815m = false;
                                this.f17814l = false;
                            }
                        } else if (!this.f17815m || this.f17814l) {
                            observer.onNext(atomicReference.getAndSet((Object) null));
                            this.f17814l = false;
                            this.f17815m = true;
                            this.f17807e.schedule(this, this.f17805c, this.f17806d);
                        }
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        observer.onError(this.f17812j);
                        this.f17807e.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public void dispose() {
            this.f17813k = true;
            this.f17810h.dispose();
            this.f17807e.dispose();
            if (getAndIncrement() == 0) {
                this.f17809g.lazySet((Object) null);
            }
        }

        public boolean isDisposed() {
            return this.f17813k;
        }

        public void onComplete() {
            this.f17811i = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f17812j = th2;
            this.f17811i = true;
            a();
        }

        public void onNext(T t11) {
            this.f17809g.set(t11);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17810h, disposable)) {
                this.f17810h = disposable;
                this.f17804b.onSubscribe(this);
            }
        }

        public void run() {
            this.f17814l = true;
            a();
        }
    }

    public ObservableThrottleLatest(Observable<T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(observable);
        this.f17800c = j11;
        this.f17801d = timeUnit;
        this.f17802e = scheduler;
        this.f17803f = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new ThrottleLatestObserver(observer, this.f17800c, this.f17801d, this.f17802e.createWorker(), this.f17803f));
    }
}
