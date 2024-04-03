package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapBiSelector<T, U, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends U>> f16379c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f16380d;

    public static final class FlatMapBiMainObserver<T, U, R> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends U>> f16381b;

        /* renamed from: c  reason: collision with root package name */
        public final InnerObserver<T, U, R> f16382c;

        public static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long serialVersionUID = -2897979525538174559L;

            /* renamed from: b  reason: collision with root package name */
            public final MaybeObserver<? super R> f16383b;

            /* renamed from: c  reason: collision with root package name */
            public final BiFunction<? super T, ? super U, ? extends R> f16384c;

            /* renamed from: d  reason: collision with root package name */
            public T f16385d;

            public InnerObserver(MaybeObserver<? super R> maybeObserver, BiFunction<? super T, ? super U, ? extends R> biFunction) {
                this.f16383b = maybeObserver;
                this.f16384c = biFunction;
            }

            public void onComplete() {
                this.f16383b.onComplete();
            }

            public void onError(Throwable th2) {
                this.f16383b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(U u11) {
                T t11 = this.f16385d;
                this.f16385d = null;
                try {
                    this.f16383b.onSuccess(ObjectHelper.requireNonNull(this.f16384c.apply(t11, u11), "The resultSelector returned a null value"));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f16383b.onError(th2);
                }
            }
        }

        public FlatMapBiMainObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f16382c = new InnerObserver<>(maybeObserver, biFunction);
            this.f16381b = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this.f16382c);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.f16382c.get());
        }

        public void onComplete() {
            this.f16382c.f16383b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16382c.f16383b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.f16382c, disposable)) {
                this.f16382c.f16383b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.f16381b.apply(t11), "The mapper returned a null MaybeSource");
                if (DisposableHelper.replace(this.f16382c, (Disposable) null)) {
                    InnerObserver<T, U, R> innerObserver = this.f16382c;
                    innerObserver.f16385d = t11;
                    maybeSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16382c.f16383b.onError(th2);
            }
        }
    }

    public MaybeFlatMapBiSelector(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        super(maybeSource);
        this.f16379c = function;
        this.f16380d = biFunction;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f16264b.subscribe(new FlatMapBiMainObserver(maybeObserver, this.f16379c, this.f16380d));
    }
}
