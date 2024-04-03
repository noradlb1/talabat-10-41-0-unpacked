package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17838c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f17839d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f17840e;

    /* renamed from: f  reason: collision with root package name */
    public final ObservableSource<? extends T> f17841f;

    public static final class FallbackObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17842b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f17843c;

        public FallbackObserver(Observer<? super T> observer, AtomicReference<Disposable> atomicReference) {
            this.f17842b = observer;
            this.f17843c = atomicReference;
        }

        public void onComplete() {
            this.f17842b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17842b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17842b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f17843c, disposable);
        }
    }

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17844b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17845c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f17846d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f17847e;

        /* renamed from: f  reason: collision with root package name */
        public final SequentialDisposable f17848f = new SequentialDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f17849g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<Disposable> f17850h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public ObservableSource<? extends T> f17851i;

        public TimeoutFallbackObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource<? extends T> observableSource) {
            this.f17844b = observer;
            this.f17845c = j11;
            this.f17846d = timeUnit;
            this.f17847e = worker;
            this.f17851i = observableSource;
        }

        public void a(long j11) {
            this.f17848f.replace(this.f17847e.schedule(new TimeoutTask(j11, this), this.f17845c, this.f17846d));
        }

        public void dispose() {
            DisposableHelper.dispose(this.f17850h);
            DisposableHelper.dispose(this);
            this.f17847e.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (this.f17849g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f17848f.dispose();
                this.f17844b.onComplete();
                this.f17847e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17849g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f17848f.dispose();
                this.f17844b.onError(th2);
                this.f17847e.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f17849g.get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (this.f17849g.compareAndSet(j11, j12)) {
                    ((Disposable) this.f17848f.get()).dispose();
                    this.f17844b.onNext(t11);
                    a(j12);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f17850h, disposable);
        }

        public void onTimeout(long j11) {
            if (this.f17849g.compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f17850h);
                ObservableSource<? extends T> observableSource = this.f17851i;
                this.f17851i = null;
                observableSource.subscribe(new FallbackObserver(this.f17844b, this));
                this.f17847e.dispose();
            }
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17852b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17853c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f17854d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f17855e;

        /* renamed from: f  reason: collision with root package name */
        public final SequentialDisposable f17856f = new SequentialDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Disposable> f17857g = new AtomicReference<>();

        public TimeoutObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f17852b = observer;
            this.f17853c = j11;
            this.f17854d = timeUnit;
            this.f17855e = worker;
        }

        public void a(long j11) {
            this.f17856f.replace(this.f17855e.schedule(new TimeoutTask(j11, this), this.f17853c, this.f17854d));
        }

        public void dispose() {
            DisposableHelper.dispose(this.f17857g);
            this.f17855e.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f17857g.get());
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f17856f.dispose();
                this.f17852b.onComplete();
                this.f17855e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f17856f.dispose();
                this.f17852b.onError(th2);
                this.f17855e.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (compareAndSet(j11, j12)) {
                    ((Disposable) this.f17856f.get()).dispose();
                    this.f17852b.onNext(t11);
                    a(j12);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f17857g, disposable);
        }

        public void onTimeout(long j11) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f17857g);
                this.f17852b.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.f17853c, this.f17854d)));
                this.f17855e.dispose();
            }
        }
    }

    public interface TimeoutSupport {
        void onTimeout(long j11);
    }

    public static final class TimeoutTask implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutSupport f17858b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17859c;

        public TimeoutTask(long j11, TimeoutSupport timeoutSupport) {
            this.f17859c = j11;
            this.f17858b = timeoutSupport;
        }

        public void run() {
            this.f17858b.onTimeout(this.f17859c);
        }
    }

    public ObservableTimeoutTimed(Observable<T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        super(observable);
        this.f17838c = j11;
        this.f17839d = timeUnit;
        this.f17840e = scheduler;
        this.f17841f = observableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        if (this.f17841f == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.f17838c, this.f17839d, this.f17840e.createWorker());
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.a(0);
            this.f16799b.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.f17838c, this.f17839d, this.f17840e.createWorker(), this.f17841f);
        observer.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.a(0);
        this.f16799b.subscribe(timeoutFallbackObserver);
    }
}
