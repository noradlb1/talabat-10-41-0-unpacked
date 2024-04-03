package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapSingle<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16416b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f16417c;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4827726964688405508L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f16418b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f16419c;

        public FlatMapMaybeObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.f16418b = singleObserver;
            this.f16419c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f16418b.onError(new NoSuchElementException());
        }

        public void onError(Throwable th2) {
            this.f16418b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f16418b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.f16419c.apply(t11), "The mapper returned a null SingleSource");
                if (!isDisposed()) {
                    singleSource.subscribe(new FlatMapSingleObserver(this, this.f16418b));
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public static final class FlatMapSingleObserver<R> implements SingleObserver<R> {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<Disposable> f16420b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleObserver<? super R> f16421c;

        public FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
            this.f16420b = atomicReference;
            this.f16421c = singleObserver;
        }

        public void onError(Throwable th2) {
            this.f16421c.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f16420b, disposable);
        }

        public void onSuccess(R r11) {
            this.f16421c.onSuccess(r11);
        }
    }

    public MaybeFlatMapSingle(MaybeSource<T> maybeSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f16416b = maybeSource;
        this.f16417c = function;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f16416b.subscribe(new FlatMapMaybeObserver(singleObserver, this.f16417c));
    }
}
