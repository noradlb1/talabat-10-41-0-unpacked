package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleLatest<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f22342c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f22343d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f22344e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f22345f;

    public static final class ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22346b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22347c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f22348d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f22349e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f22350f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<T> f22351g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public Disposable f22352h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f22353i;

        /* renamed from: j  reason: collision with root package name */
        public Throwable f22354j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f22355k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f22356l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f22357m;

        public ThrottleLatestObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker, boolean z11) {
            this.f22346b = observer;
            this.f22347c = j11;
            this.f22348d = timeUnit;
            this.f22349e = worker;
            this.f22350f = z11;
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.f22351g;
                Observer<? super T> observer = this.f22346b;
                int i11 = 1;
                while (!this.f22355k) {
                    boolean z12 = this.f22353i;
                    if (!z12 || this.f22354j == null) {
                        if (atomicReference.get() == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12) {
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (!z11 && this.f22350f) {
                                observer.onNext(andSet);
                            }
                            observer.onComplete();
                            this.f22349e.dispose();
                            return;
                        }
                        if (z11) {
                            if (this.f22356l) {
                                this.f22357m = false;
                                this.f22356l = false;
                            }
                        } else if (!this.f22357m || this.f22356l) {
                            observer.onNext(atomicReference.getAndSet((Object) null));
                            this.f22356l = false;
                            this.f22357m = true;
                            this.f22349e.schedule(this, this.f22347c, this.f22348d);
                        }
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        observer.onError(this.f22354j);
                        this.f22349e.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public void dispose() {
            this.f22355k = true;
            this.f22352h.dispose();
            this.f22349e.dispose();
            if (getAndIncrement() == 0) {
                this.f22351g.lazySet((Object) null);
            }
        }

        public boolean isDisposed() {
            return this.f22355k;
        }

        public void onComplete() {
            this.f22353i = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f22354j = th2;
            this.f22353i = true;
            a();
        }

        public void onNext(T t11) {
            this.f22351g.set(t11);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22352h, disposable)) {
                this.f22352h = disposable;
                this.f22346b.onSubscribe(this);
            }
        }

        public void run() {
            this.f22356l = true;
            a();
        }
    }

    public ObservableThrottleLatest(Observable<T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(observable);
        this.f22342c = j11;
        this.f22343d = timeUnit;
        this.f22344e = scheduler;
        this.f22345f = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new ThrottleLatestObserver(observer, this.f22342c, this.f22343d, this.f22344e.createWorker(), this.f22345f));
    }
}
