package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<U> f22365c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<V>> f22366d;

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSource<? extends T> f22367e;

    public static final class TimeoutConsumer extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutSelectorSupport f22368b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22369c;

        public TimeoutConsumer(long j11, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.f22369c = j11;
            this.f22368b = timeoutSelectorSupport;
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
                this.f22368b.onTimeout(this.f22369c);
            }
        }

        public void onError(Throwable th2) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f22368b.onTimeoutError(this.f22369c, th2);
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
                this.f22368b.onTimeout(this.f22369c);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long serialVersionUID = -7508389464265974549L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22370b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<?>> f22371c;

        /* renamed from: d  reason: collision with root package name */
        public final SequentialDisposable f22372d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f22373e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f22374f;

        /* renamed from: g  reason: collision with root package name */
        public ObservableSource<? extends T> f22375g;

        public TimeoutFallbackObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function, ObservableSource<? extends T> observableSource) {
            this.f22370b = observer;
            this.f22371c = function;
            this.f22375g = observableSource;
            this.f22373e = new AtomicLong();
            this.f22374f = new AtomicReference<>();
        }

        public void a(ObservableSource<?> observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.f22372d.replace(timeoutConsumer)) {
                    observableSource.subscribe(timeoutConsumer);
                }
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22374f);
            DisposableHelper.dispose(this);
            this.f22372d.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (this.f22373e.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f22372d.dispose();
                this.f22370b.onComplete();
                this.f22372d.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22373e.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f22372d.dispose();
                this.f22370b.onError(th2);
                this.f22372d.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f22373e.get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (this.f22373e.compareAndSet(j11, j12)) {
                    Disposable disposable = (Disposable) this.f22372d.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f22370b.onNext(t11);
                    try {
                        Object apply = this.f22371c.apply(t11);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        ObservableSource observableSource = (ObservableSource) apply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j12, this);
                        if (this.f22372d.replace(timeoutConsumer)) {
                            observableSource.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f22374f.get().dispose();
                        this.f22373e.getAndSet(Long.MAX_VALUE);
                        this.f22370b.onError(th2);
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22374f, disposable);
        }

        public void onTimeout(long j11) {
            if (this.f22373e.compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f22374f);
                ObservableSource<? extends T> observableSource = this.f22375g;
                this.f22375g = null;
                observableSource.subscribe(new ObservableTimeoutTimed.FallbackObserver(this.f22370b, this));
            }
        }

        public void onTimeoutError(long j11, Throwable th2) {
            if (this.f22373e.compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this);
                this.f22370b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22376b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<?>> f22377c;

        /* renamed from: d  reason: collision with root package name */
        public final SequentialDisposable f22378d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f22379e = new AtomicReference<>();

        public TimeoutObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function) {
            this.f22376b = observer;
            this.f22377c = function;
        }

        public void a(ObservableSource<?> observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.f22378d.replace(timeoutConsumer)) {
                    observableSource.subscribe(timeoutConsumer);
                }
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22379e);
            this.f22378d.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f22379e.get());
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f22378d.dispose();
                this.f22376b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f22378d.dispose();
                this.f22376b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (compareAndSet(j11, j12)) {
                    Disposable disposable = (Disposable) this.f22378d.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f22376b.onNext(t11);
                    try {
                        Object apply = this.f22377c.apply(t11);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        ObservableSource observableSource = (ObservableSource) apply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j12, this);
                        if (this.f22378d.replace(timeoutConsumer)) {
                            observableSource.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f22379e.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.f22376b.onError(th2);
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22379e, disposable);
        }

        public void onTimeout(long j11) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f22379e);
                this.f22376b.onError(new TimeoutException());
            }
        }

        public void onTimeoutError(long j11, Throwable th2) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f22379e);
                this.f22376b.onError(th2);
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
        this.f22365c = observableSource;
        this.f22366d = function;
        this.f22367e = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        if (this.f22367e == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.f22366d);
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.a(this.f22365c);
            this.f21304b.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.f22366d, this.f22367e);
        observer.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.a(this.f22365c);
        this.f21304b.subscribe(timeoutFallbackObserver);
    }
}
