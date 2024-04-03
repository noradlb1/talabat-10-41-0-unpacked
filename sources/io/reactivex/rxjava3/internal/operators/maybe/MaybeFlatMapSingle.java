package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapSingle<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f20927b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f20928c;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4827726964688405508L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f20929b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f20930c;

        public FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.f20929b = maybeObserver;
            this.f20930c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f20929b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20929b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f20929b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f20930c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                if (!isDisposed()) {
                    singleSource.subscribe(new FlatMapSingleObserver(this, this.f20929b));
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public static final class FlatMapSingleObserver<R> implements SingleObserver<R> {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<Disposable> f20931b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeObserver<? super R> f20932c;

        public FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
            this.f20931b = atomicReference;
            this.f20932c = maybeObserver;
        }

        public void onError(Throwable th2) {
            this.f20932c.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f20931b, disposable);
        }

        public void onSuccess(R r11) {
            this.f20932c.onSuccess(r11);
        }
    }

    public MaybeFlatMapSingle(MaybeSource<T> maybeSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f20927b = maybeSource;
        this.f20928c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f20927b.subscribe(new FlatMapMaybeObserver(maybeObserver, this.f20928c));
    }
}
