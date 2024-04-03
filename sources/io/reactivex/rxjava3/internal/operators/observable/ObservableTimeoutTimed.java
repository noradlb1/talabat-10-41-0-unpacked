package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f22380c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f22381d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f22382e;

    /* renamed from: f  reason: collision with root package name */
    public final ObservableSource<? extends T> f22383f;

    public static final class FallbackObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22384b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f22385c;

        public FallbackObserver(Observer<? super T> observer, AtomicReference<Disposable> atomicReference) {
            this.f22384b = observer;
            this.f22385c = atomicReference;
        }

        public void onComplete() {
            this.f22384b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22384b.onError(th2);
        }

        public void onNext(T t11) {
            this.f22384b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f22385c, disposable);
        }
    }

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22386b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22387c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f22388d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f22389e;

        /* renamed from: f  reason: collision with root package name */
        public final SequentialDisposable f22390f = new SequentialDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f22391g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<Disposable> f22392h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public ObservableSource<? extends T> f22393i;

        public TimeoutFallbackObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource<? extends T> observableSource) {
            this.f22386b = observer;
            this.f22387c = j11;
            this.f22388d = timeUnit;
            this.f22389e = worker;
            this.f22393i = observableSource;
        }

        public void a(long j11) {
            this.f22390f.replace(this.f22389e.schedule(new TimeoutTask(j11, this), this.f22387c, this.f22388d));
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22392h);
            DisposableHelper.dispose(this);
            this.f22389e.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (this.f22391g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f22390f.dispose();
                this.f22386b.onComplete();
                this.f22389e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22391g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f22390f.dispose();
                this.f22386b.onError(th2);
                this.f22389e.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f22391g.get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (this.f22391g.compareAndSet(j11, j12)) {
                    ((Disposable) this.f22390f.get()).dispose();
                    this.f22386b.onNext(t11);
                    a(j12);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22392h, disposable);
        }

        public void onTimeout(long j11) {
            if (this.f22391g.compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f22392h);
                ObservableSource<? extends T> observableSource = this.f22393i;
                this.f22393i = null;
                observableSource.subscribe(new FallbackObserver(this.f22386b, this));
                this.f22389e.dispose();
            }
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22394b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22395c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f22396d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f22397e;

        /* renamed from: f  reason: collision with root package name */
        public final SequentialDisposable f22398f = new SequentialDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Disposable> f22399g = new AtomicReference<>();

        public TimeoutObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f22394b = observer;
            this.f22395c = j11;
            this.f22396d = timeUnit;
            this.f22397e = worker;
        }

        public void a(long j11) {
            this.f22398f.replace(this.f22397e.schedule(new TimeoutTask(j11, this), this.f22395c, this.f22396d));
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22399g);
            this.f22397e.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f22399g.get());
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f22398f.dispose();
                this.f22394b.onComplete();
                this.f22397e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f22398f.dispose();
                this.f22394b.onError(th2);
                this.f22397e.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (compareAndSet(j11, j12)) {
                    ((Disposable) this.f22398f.get()).dispose();
                    this.f22394b.onNext(t11);
                    a(j12);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22399g, disposable);
        }

        public void onTimeout(long j11) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f22399g);
                this.f22394b.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.f22395c, this.f22396d)));
                this.f22397e.dispose();
            }
        }
    }

    public interface TimeoutSupport {
        void onTimeout(long j11);
    }

    public static final class TimeoutTask implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutSupport f22400b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22401c;

        public TimeoutTask(long j11, TimeoutSupport timeoutSupport) {
            this.f22401c = j11;
            this.f22400b = timeoutSupport;
        }

        public void run() {
            this.f22400b.onTimeout(this.f22401c);
        }
    }

    public ObservableTimeoutTimed(Observable<T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        super(observable);
        this.f22380c = j11;
        this.f22381d = timeUnit;
        this.f22382e = scheduler;
        this.f22383f = observableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        if (this.f22383f == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.f22380c, this.f22381d, this.f22382e.createWorker());
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.a(0);
            this.f21304b.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.f22380c, this.f22381d, this.f22382e.createWorker(), this.f22383f);
        observer.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.a(0);
        this.f21304b.subscribe(timeoutFallbackObserver);
    }
}
