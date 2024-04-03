package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f22136c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f22137d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f22138e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f22139f;

    public static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f22140h = new AtomicInteger(1);

        public SampleTimedEmitLast(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j11, timeUnit, scheduler);
        }

        public void b() {
            c();
            if (this.f22140h.decrementAndGet() == 0) {
                this.f22141b.onComplete();
            }
        }

        public void run() {
            if (this.f22140h.incrementAndGet() == 2) {
                c();
                if (this.f22140h.decrementAndGet() == 0) {
                    this.f22141b.onComplete();
                }
            }
        }
    }

    public static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public SampleTimedNoLast(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j11, timeUnit, scheduler);
        }

        public void b() {
            this.f22141b.onComplete();
        }

        public void run() {
            c();
        }
    }

    public static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22141b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22142c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f22143d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f22144e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f22145f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public Disposable f22146g;

        public SampleTimedObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            this.f22141b = observer;
            this.f22142c = j11;
            this.f22143d = timeUnit;
            this.f22144e = scheduler;
        }

        public void a() {
            DisposableHelper.dispose(this.f22145f);
        }

        public abstract void b();

        public void c() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.f22141b.onNext(andSet);
            }
        }

        public void dispose() {
            a();
            this.f22146g.dispose();
        }

        public boolean isDisposed() {
            return this.f22146g.isDisposed();
        }

        public void onComplete() {
            a();
            b();
        }

        public void onError(Throwable th2) {
            a();
            this.f22141b.onError(th2);
        }

        public void onNext(T t11) {
            lazySet(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22146g, disposable)) {
                this.f22146g = disposable;
                this.f22141b.onSubscribe(this);
                Scheduler scheduler = this.f22144e;
                long j11 = this.f22142c;
                DisposableHelper.replace(this.f22145f, scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f22143d));
            }
        }
    }

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(observableSource);
        this.f22136c = j11;
        this.f22137d = timeUnit;
        this.f22138e = scheduler;
        this.f22139f = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f22139f) {
            this.f21304b.subscribe(new SampleTimedEmitLast(serializedObserver, this.f22136c, this.f22137d, this.f22138e));
        } else {
            this.f21304b.subscribe(new SampleTimedNoLast(serializedObserver, this.f22136c, this.f22137d, this.f22138e));
        }
    }
}
