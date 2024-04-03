package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapBiSelector<T, U, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22867b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends U>> f22868c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f22869d;

    public static final class FlatMapBiMainObserver<T, U, R> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends U>> f22870b;

        /* renamed from: c  reason: collision with root package name */
        public final InnerObserver<T, U, R> f22871c;

        public static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements SingleObserver<U> {
            private static final long serialVersionUID = -2897979525538174559L;

            /* renamed from: b  reason: collision with root package name */
            public final SingleObserver<? super R> f22872b;

            /* renamed from: c  reason: collision with root package name */
            public final BiFunction<? super T, ? super U, ? extends R> f22873c;

            /* renamed from: d  reason: collision with root package name */
            public T f22874d;

            public InnerObserver(SingleObserver<? super R> singleObserver, BiFunction<? super T, ? super U, ? extends R> biFunction) {
                this.f22872b = singleObserver;
                this.f22873c = biFunction;
            }

            public void onError(Throwable th2) {
                this.f22872b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(U u11) {
                T t11 = this.f22874d;
                this.f22874d = null;
                try {
                    Object apply = this.f22873c.apply(t11, u11);
                    Objects.requireNonNull(apply, "The resultSelector returned a null value");
                    this.f22872b.onSuccess(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f22872b.onError(th2);
                }
            }
        }

        public FlatMapBiMainObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f22871c = new InnerObserver<>(singleObserver, biFunction);
            this.f22870b = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22871c);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.f22871c.get());
        }

        public void onError(Throwable th2) {
            this.f22871c.f22872b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.f22871c, disposable)) {
                this.f22871c.f22872b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f22870b.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                SingleSource singleSource = (SingleSource) apply;
                if (DisposableHelper.replace(this.f22871c, (Disposable) null)) {
                    InnerObserver<T, U, R> innerObserver = this.f22871c;
                    innerObserver.f22874d = t11;
                    singleSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22871c.f22872b.onError(th2);
            }
        }
    }

    public SingleFlatMapBiSelector(SingleSource<T> singleSource, Function<? super T, ? extends SingleSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        this.f22867b = singleSource;
        this.f22868c = function;
        this.f22869d = biFunction;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f22867b.subscribe(new FlatMapBiMainObserver(singleObserver, this.f22868c, this.f22869d));
    }
}
