package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<U> f17823c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<V>> f17824d;

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSource<? extends T> f17825e;

    public static final class TimeoutConsumer extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutSelectorSupport f17826b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17827c;

        public TimeoutConsumer(long j11, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.f17827c = j11;
            this.f17826b = timeoutSelectorSupport;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f17826b.onTimeout(this.f17827c);
            }
        }

        public void onError(Throwable th2) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f17826b.onTimeoutError(this.f17827c, th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                disposable.dispose();
                lazySet(disposableHelper);
                this.f17826b.onTimeout(this.f17827c);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long serialVersionUID = -7508389464265974549L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17828b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<?>> f17829c;

        /* renamed from: d  reason: collision with root package name */
        public final SequentialDisposable f17830d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f17831e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f17832f;

        /* renamed from: g  reason: collision with root package name */
        public ObservableSource<? extends T> f17833g;

        public TimeoutFallbackObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function, ObservableSource<? extends T> observableSource) {
            this.f17828b = observer;
            this.f17829c = function;
            this.f17833g = observableSource;
            this.f17831e = new AtomicLong();
            this.f17832f = new AtomicReference<>();
        }

        public void a(ObservableSource<?> observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.f17830d.replace(timeoutConsumer)) {
                    observableSource.subscribe(timeoutConsumer);
                }
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this.f17832f);
            DisposableHelper.dispose(this);
            this.f17830d.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (this.f17831e.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f17830d.dispose();
                this.f17828b.onComplete();
                this.f17830d.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17831e.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f17830d.dispose();
                this.f17828b.onError(th2);
                this.f17830d.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f17831e.get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (this.f17831e.compareAndSet(j11, j12)) {
                    Disposable disposable = (Disposable) this.f17830d.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f17828b.onNext(t11);
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17829c.apply(t11), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j12, this);
                        if (this.f17830d.replace(timeoutConsumer)) {
                            observableSource.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f17832f.get().dispose();
                        this.f17831e.getAndSet(Long.MAX_VALUE);
                        this.f17828b.onError(th2);
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f17832f, disposable);
        }

        public void onTimeout(long j11) {
            if (this.f17831e.compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f17832f);
                ObservableSource<? extends T> observableSource = this.f17833g;
                this.f17833g = null;
                observableSource.subscribe(new ObservableTimeoutTimed.FallbackObserver(this.f17828b, this));
            }
        }

        public void onTimeoutError(long j11, Throwable th2) {
            if (this.f17831e.compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this);
                this.f17828b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17834b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<?>> f17835c;

        /* renamed from: d  reason: collision with root package name */
        public final SequentialDisposable f17836d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f17837e = new AtomicReference<>();

        public TimeoutObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function) {
            this.f17834b = observer;
            this.f17835c = function;
        }

        public void a(ObservableSource<?> observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.f17836d.replace(timeoutConsumer)) {
                    observableSource.subscribe(timeoutConsumer);
                }
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this.f17837e);
            this.f17836d.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f17837e.get());
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f17836d.dispose();
                this.f17834b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f17836d.dispose();
                this.f17834b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (compareAndSet(j11, j12)) {
                    Disposable disposable = (Disposable) this.f17836d.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f17834b.onNext(t11);
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17835c.apply(t11), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j12, this);
                        if (this.f17836d.replace(timeoutConsumer)) {
                            observableSource.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f17837e.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.f17834b.onError(th2);
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f17837e, disposable);
        }

        public void onTimeout(long j11) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f17837e);
                this.f17834b.onError(new TimeoutException());
            }
        }

        public void onTimeoutError(long j11, Throwable th2) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f17837e);
                this.f17834b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }
    }

    public interface TimeoutSelectorSupport extends ObservableTimeoutTimed.TimeoutSupport {
        void onTimeoutError(long j11, Throwable th2);
    }

    public ObservableTimeout(Observable<T> observable, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        super(observable);
        this.f17823c = observableSource;
        this.f17824d = function;
        this.f17825e = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        if (this.f17825e == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.f17824d);
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.a(this.f17823c);
            this.f16799b.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.f17824d, this.f17825e);
        observer.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.a(this.f17823c);
        this.f16799b.subscribe(timeoutFallbackObserver);
    }
}
