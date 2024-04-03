package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapSingleElement<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16422b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f16423c;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4827726964688405508L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f16424b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f16425c;

        public FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.f16424b = maybeObserver;
            this.f16425c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f16424b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16424b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f16424b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                ((SingleSource) ObjectHelper.requireNonNull(this.f16425c.apply(t11), "The mapper returned a null SingleSource")).subscribe(new FlatMapSingleObserver(this, this.f16424b));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public static final class FlatMapSingleObserver<R> implements SingleObserver<R> {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<Disposable> f16426b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeObserver<? super R> f16427c;

        public FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
            this.f16426b = atomicReference;
            this.f16427c = maybeObserver;
        }

        public void onError(Throwable th2) {
            this.f16427c.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f16426b, disposable);
        }

        public void onSuccess(R r11) {
            this.f16427c.onSuccess(r11);
        }
    }

    public MaybeFlatMapSingleElement(MaybeSource<T> maybeSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f16422b = maybeSource;
        this.f16423c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f16422b.subscribe(new FlatMapMaybeObserver(maybeObserver, this.f16423c));
    }
}
