package io.reactivex.rxjava3.internal.operators.observable;

import i.b;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.observers.SerializedObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<U>> f21590c;

    public static final class DebounceObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21591b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<U>> f21592c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21593d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f21594e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public volatile long f21595f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f21596g;

        public static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {

            /* renamed from: c  reason: collision with root package name */
            public final DebounceObserver<T, U> f21597c;

            /* renamed from: d  reason: collision with root package name */
            public final long f21598d;

            /* renamed from: e  reason: collision with root package name */
            public final T f21599e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f21600f;

            /* renamed from: g  reason: collision with root package name */
            public final AtomicBoolean f21601g = new AtomicBoolean();

            public DebounceInnerObserver(DebounceObserver<T, U> debounceObserver, long j11, T t11) {
                this.f21597c = debounceObserver;
                this.f21598d = j11;
                this.f21599e = t11;
            }

            public void b() {
                if (this.f21601g.compareAndSet(false, true)) {
                    this.f21597c.a(this.f21598d, this.f21599e);
                }
            }

            public void onComplete() {
                if (!this.f21600f) {
                    this.f21600f = true;
                    b();
                }
            }

            public void onError(Throwable th2) {
                if (this.f21600f) {
                    RxJavaPlugins.onError(th2);
                    return;
                }
                this.f21600f = true;
                this.f21597c.onError(th2);
            }

            public void onNext(U u11) {
                if (!this.f21600f) {
                    this.f21600f = true;
                    dispose();
                    b();
                }
            }
        }

        public DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.f21591b = observer;
            this.f21592c = function;
        }

        public void a(long j11, T t11) {
            if (j11 == this.f21595f) {
                this.f21591b.onNext(t11);
            }
        }

        public void dispose() {
            this.f21593d.dispose();
            DisposableHelper.dispose(this.f21594e);
        }

        public boolean isDisposed() {
            return this.f21593d.isDisposed();
        }

        public void onComplete() {
            if (!this.f21596g) {
                this.f21596g = true;
                Disposable disposable = this.f21594e.get();
                if (disposable != DisposableHelper.DISPOSED) {
                    DebounceInnerObserver debounceInnerObserver = (DebounceInnerObserver) disposable;
                    if (debounceInnerObserver != null) {
                        debounceInnerObserver.b();
                    }
                    DisposableHelper.dispose(this.f21594e);
                    this.f21591b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f21594e);
            this.f21591b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21596g) {
                long j11 = this.f21595f + 1;
                this.f21595f = j11;
                Disposable disposable = this.f21594e.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    Object apply = this.f21592c.apply(t11);
                    Objects.requireNonNull(apply, "The ObservableSource supplied is null");
                    ObservableSource observableSource = (ObservableSource) apply;
                    DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j11, t11);
                    if (b.a(this.f21594e, disposable, debounceInnerObserver)) {
                        observableSource.subscribe(debounceInnerObserver);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    dispose();
                    this.f21591b.onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21593d, disposable)) {
                this.f21593d = disposable;
                this.f21591b.onSubscribe(this);
            }
        }
    }

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.f21590c = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new DebounceObserver(new SerializedObserver(observer), this.f21590c));
    }
}
