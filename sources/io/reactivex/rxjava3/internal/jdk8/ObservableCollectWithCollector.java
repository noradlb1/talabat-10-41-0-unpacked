package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.function.BiConsumer;
import j$.util.function.Function;
import j$.util.stream.Collector;
import java.util.Objects;

public final class ObservableCollectWithCollector<T, A, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f18907b;

    /* renamed from: c  reason: collision with root package name */
    public final Collector<? super T, A, R> f18908c;

    public static final class CollectorObserver<T, A, R> extends DeferredScalarDisposable<R> implements Observer<T> {
        private static final long serialVersionUID = -229544830565448758L;

        /* renamed from: d  reason: collision with root package name */
        public final BiConsumer<A, T> f18909d;

        /* renamed from: e  reason: collision with root package name */
        public final Function<A, R> f18910e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f18911f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18912g;

        /* renamed from: h  reason: collision with root package name */
        public A f18913h;

        public CollectorObserver(Observer<? super R> observer, A a11, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            super(observer);
            this.f18913h = a11;
            this.f18909d = biConsumer;
            this.f18910e = function;
        }

        public void dispose() {
            super.dispose();
            this.f18911f.dispose();
        }

        public void onComplete() {
            if (!this.f18912g) {
                this.f18912g = true;
                this.f18911f = DisposableHelper.DISPOSED;
                A a11 = this.f18913h;
                this.f18913h = null;
                try {
                    R apply = this.f18910e.apply(a11);
                    Objects.requireNonNull(apply, "The finisher returned a null value");
                    complete(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19028b.onError(th2);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f18912g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18912g = true;
            this.f18911f = DisposableHelper.DISPOSED;
            this.f18913h = null;
            this.f19028b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18912g) {
                try {
                    this.f18909d.accept(this.f18913h, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f18911f.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.f18911f, disposable)) {
                this.f18911f = disposable;
                this.f19028b.onSubscribe(this);
            }
        }
    }

    public ObservableCollectWithCollector(Observable<T> observable, Collector<? super T, A, R> collector) {
        this.f18907b = observable;
        this.f18908c = collector;
    }

    public void subscribeActual(@NonNull Observer<? super R> observer) {
        try {
            this.f18907b.subscribe(new CollectorObserver(observer, this.f18908c.supplier().get(), this.f18908c.accumulator(), this.f18908c.finisher()));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
