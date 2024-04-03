package io.reactivex.internal.operators.single;

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

public final class SingleFlatMapMaybe<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f18347b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f18348c;

    public static final class FlatMapMaybeObserver<R> implements MaybeObserver<R> {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<Disposable> f18349b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeObserver<? super R> f18350c;

        public FlatMapMaybeObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
            this.f18349b = atomicReference;
            this.f18350c = maybeObserver;
        }

        public void onComplete() {
            this.f18350c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f18350c.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f18349b, disposable);
        }

        public void onSuccess(R r11) {
            this.f18350c.onSuccess(r11);
        }
    }

    public static final class FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5843758257109742742L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f18351b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f18352c;

        public FlatMapSingleObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
            this.f18351b = maybeObserver;
            this.f18352c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f18351b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f18351b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.f18352c.apply(t11), "The mapper returned a null MaybeSource");
                if (!isDisposed()) {
                    maybeSource.subscribe(new FlatMapMaybeObserver(this, this.f18351b));
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public SingleFlatMapMaybe(SingleSource<? extends T> singleSource, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        this.f18348c = function;
        this.f18347b = singleSource;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f18347b.subscribe(new FlatMapSingleObserver(maybeObserver, this.f18348c));
    }
}
