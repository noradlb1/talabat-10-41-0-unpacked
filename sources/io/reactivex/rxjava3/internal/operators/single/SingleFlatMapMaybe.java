package io.reactivex.rxjava3.internal.operators.single;

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

public final class SingleFlatMapMaybe<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f22896b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f22897c;

    public static final class FlatMapMaybeObserver<R> implements MaybeObserver<R> {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<Disposable> f22898b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeObserver<? super R> f22899c;

        public FlatMapMaybeObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
            this.f22898b = atomicReference;
            this.f22899c = maybeObserver;
        }

        public void onComplete() {
            this.f22899c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22899c.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f22898b, disposable);
        }

        public void onSuccess(R r11) {
            this.f22899c.onSuccess(r11);
        }
    }

    public static final class FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5843758257109742742L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f22900b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f22901c;

        public FlatMapSingleObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
            this.f22900b = maybeObserver;
            this.f22901c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f22900b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f22900b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f22901c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                if (!isDisposed()) {
                    maybeSource.subscribe(new FlatMapMaybeObserver(this, this.f22900b));
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public SingleFlatMapMaybe(SingleSource<? extends T> singleSource, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        this.f22897c = function;
        this.f22896b = singleSource;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f22896b.subscribe(new FlatMapSingleObserver(maybeObserver, this.f22897c));
    }
}
