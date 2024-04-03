package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17593c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f17594d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f17595e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f17596f;

    public static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f17597h = new AtomicInteger(1);

        public SampleTimedEmitLast(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j11, timeUnit, scheduler);
        }

        public void b() {
            c();
            if (this.f17597h.decrementAndGet() == 0) {
                this.f17598b.onComplete();
            }
        }

        public void run() {
            if (this.f17597h.incrementAndGet() == 2) {
                c();
                if (this.f17597h.decrementAndGet() == 0) {
                    this.f17598b.onComplete();
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
            this.f17598b.onComplete();
        }

        public void run() {
            c();
        }
    }

    public static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17598b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17599c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f17600d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f17601e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f17602f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public Disposable f17603g;

        public SampleTimedObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            this.f17598b = observer;
            this.f17599c = j11;
            this.f17600d = timeUnit;
            this.f17601e = scheduler;
        }

        public void a() {
            DisposableHelper.dispose(this.f17602f);
        }

        public abstract void b();

        public void c() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.f17598b.onNext(andSet);
            }
        }

        public void dispose() {
            a();
            this.f17603g.dispose();
        }

        public boolean isDisposed() {
            return this.f17603g.isDisposed();
        }

        public void onComplete() {
            a();
            b();
        }

        public void onError(Throwable th2) {
            a();
            this.f17598b.onError(th2);
        }

        public void onNext(T t11) {
            lazySet(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17603g, disposable)) {
                this.f17603g = disposable;
                this.f17598b.onSubscribe(this);
                Scheduler scheduler = this.f17601e;
                long j11 = this.f17599c;
                DisposableHelper.replace(this.f17602f, scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f17600d));
            }
        }
    }

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(observableSource);
        this.f17593c = j11;
        this.f17594d = timeUnit;
        this.f17595e = scheduler;
        this.f17596f = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f17596f) {
            this.f16799b.subscribe(new SampleTimedEmitLast(serializedObserver, this.f17593c, this.f17594d, this.f17595e));
        } else {
            this.f16799b.subscribe(new SampleTimedNoLast(serializedObserver, this.f17593c, this.f17594d, this.f17595e));
        }
    }
}
