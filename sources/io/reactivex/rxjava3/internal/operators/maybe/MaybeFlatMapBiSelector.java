package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapBiSelector<T, U, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends U>> f20890c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f20891d;

    public static final class FlatMapBiMainObserver<T, U, R> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends U>> f20892b;

        /* renamed from: c  reason: collision with root package name */
        public final InnerObserver<T, U, R> f20893c;

        public static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long serialVersionUID = -2897979525538174559L;

            /* renamed from: b  reason: collision with root package name */
            public final MaybeObserver<? super R> f20894b;

            /* renamed from: c  reason: collision with root package name */
            public final BiFunction<? super T, ? super U, ? extends R> f20895c;

            /* renamed from: d  reason: collision with root package name */
            public T f20896d;

            public InnerObserver(MaybeObserver<? super R> maybeObserver, BiFunction<? super T, ? super U, ? extends R> biFunction) {
                this.f20894b = maybeObserver;
                this.f20895c = biFunction;
            }

            public void onComplete() {
                this.f20894b.onComplete();
            }

            public void onError(Throwable th2) {
                this.f20894b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(U u11) {
                T t11 = this.f20896d;
                this.f20896d = null;
                try {
                    Object apply = this.f20895c.apply(t11, u11);
                    Objects.requireNonNull(apply, "The resultSelector returned a null value");
                    this.f20894b.onSuccess(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f20894b.onError(th2);
                }
            }
        }

        public FlatMapBiMainObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f20893c = new InnerObserver<>(maybeObserver, biFunction);
            this.f20892b = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this.f20893c);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.f20893c.get());
        }

        public void onComplete() {
            this.f20893c.f20894b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20893c.f20894b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.f20893c, disposable)) {
                this.f20893c.f20894b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f20892b.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                if (DisposableHelper.replace(this.f20893c, (Disposable) null)) {
                    InnerObserver<T, U, R> innerObserver = this.f20893c;
                    innerObserver.f20896d = t11;
                    maybeSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20893c.f20894b.onError(th2);
            }
        }
    }

    public MaybeFlatMapBiSelector(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        super(maybeSource);
        this.f20890c = function;
        this.f20891d = biFunction;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f20763b.subscribe(new FlatMapBiMainObserver(maybeObserver, this.f20890c, this.f20891d));
    }
}
