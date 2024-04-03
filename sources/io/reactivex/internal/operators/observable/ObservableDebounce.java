package io.reactivex.internal.operators.observable;

import i.b;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<U>> f17062c;

    public static final class DebounceObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17063b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<U>> f17064c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17065d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f17066e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public volatile long f17067f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f17068g;

        public static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {

            /* renamed from: b  reason: collision with root package name */
            public final DebounceObserver<T, U> f17069b;

            /* renamed from: c  reason: collision with root package name */
            public final long f17070c;

            /* renamed from: d  reason: collision with root package name */
            public final T f17071d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f17072e;

            /* renamed from: f  reason: collision with root package name */
            public final AtomicBoolean f17073f = new AtomicBoolean();

            public DebounceInnerObserver(DebounceObserver<T, U> debounceObserver, long j11, T t11) {
                this.f17069b = debounceObserver;
                this.f17070c = j11;
                this.f17071d = t11;
            }

            public void a() {
                if (this.f17073f.compareAndSet(false, true)) {
                    this.f17069b.a(this.f17070c, this.f17071d);
                }
            }

            public void onComplete() {
                if (!this.f17072e) {
                    this.f17072e = true;
                    a();
                }
            }

            public void onError(Throwable th2) {
                if (this.f17072e) {
                    RxJavaPlugins.onError(th2);
                    return;
                }
                this.f17072e = true;
                this.f17069b.onError(th2);
            }

            public void onNext(U u11) {
                if (!this.f17072e) {
                    this.f17072e = true;
                    dispose();
                    a();
                }
            }
        }

        public DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.f17063b = observer;
            this.f17064c = function;
        }

        public void a(long j11, T t11) {
            if (j11 == this.f17067f) {
                this.f17063b.onNext(t11);
            }
        }

        public void dispose() {
            this.f17065d.dispose();
            DisposableHelper.dispose(this.f17066e);
        }

        public boolean isDisposed() {
            return this.f17065d.isDisposed();
        }

        public void onComplete() {
            if (!this.f17068g) {
                this.f17068g = true;
                Disposable disposable = this.f17066e.get();
                if (disposable != DisposableHelper.DISPOSED) {
                    DebounceInnerObserver debounceInnerObserver = (DebounceInnerObserver) disposable;
                    if (debounceInnerObserver != null) {
                        debounceInnerObserver.a();
                    }
                    DisposableHelper.dispose(this.f17066e);
                    this.f17063b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f17066e);
            this.f17063b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17068g) {
                long j11 = this.f17067f + 1;
                this.f17067f = j11;
                Disposable disposable = this.f17066e.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17064c.apply(t11), "The ObservableSource supplied is null");
                    DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j11, t11);
                    if (b.a(this.f17066e, disposable, debounceInnerObserver)) {
                        observableSource.subscribe(debounceInnerObserver);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    dispose();
                    this.f17063b.onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17065d, disposable)) {
                this.f17065d = disposable;
                this.f17063b.onSubscribe(this);
            }
        }
    }

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.f17062c = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new DebounceObserver(new SerializedObserver(observer), this.f17062c));
    }
}
