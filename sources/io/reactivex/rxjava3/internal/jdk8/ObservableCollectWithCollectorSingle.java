package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.function.BiConsumer;
import j$.util.function.Function;
import j$.util.stream.Collector;
import java.util.Objects;

public final class ObservableCollectWithCollectorSingle<T, A, R> extends Single<R> implements FuseToObservable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f18914b;

    /* renamed from: c  reason: collision with root package name */
    public final Collector<? super T, A, R> f18915c;

    public static final class CollectorSingleObserver<T, A, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f18916b;

        /* renamed from: c  reason: collision with root package name */
        public final BiConsumer<A, T> f18917c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<A, R> f18918d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f18919e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18920f;

        /* renamed from: g  reason: collision with root package name */
        public A f18921g;

        public CollectorSingleObserver(SingleObserver<? super R> singleObserver, A a11, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            this.f18916b = singleObserver;
            this.f18921g = a11;
            this.f18917c = biConsumer;
            this.f18918d = function;
        }

        public void dispose() {
            this.f18919e.dispose();
            this.f18919e = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f18919e == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            if (!this.f18920f) {
                this.f18920f = true;
                this.f18919e = DisposableHelper.DISPOSED;
                A a11 = this.f18921g;
                this.f18921g = null;
                try {
                    R apply = this.f18918d.apply(a11);
                    Objects.requireNonNull(apply, "The finisher returned a null value");
                    this.f18916b.onSuccess(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f18916b.onError(th2);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f18920f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18920f = true;
            this.f18919e = DisposableHelper.DISPOSED;
            this.f18921g = null;
            this.f18916b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18920f) {
                try {
                    this.f18917c.accept(this.f18921g, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f18919e.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.f18919e, disposable)) {
                this.f18919e = disposable;
                this.f18916b.onSubscribe(this);
            }
        }
    }

    public ObservableCollectWithCollectorSingle(Observable<T> observable, Collector<? super T, A, R> collector) {
        this.f18914b = observable;
        this.f18915c = collector;
    }

    public Observable<R> fuseToObservable() {
        return new ObservableCollectWithCollector(this.f18914b, this.f18915c);
    }

    public void subscribeActual(@NonNull SingleObserver<? super R> singleObserver) {
        try {
            this.f18914b.subscribe(new CollectorSingleObserver(singleObserver, this.f18915c.supplier().get(), this.f18915c.accumulator(), this.f18915c.finisher()));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
