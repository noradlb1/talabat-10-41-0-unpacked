package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMap<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f18320b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f18321c;

    public static final class SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 3258103020495908596L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f18322b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f18323c;

        public static final class FlatMapSingleObserver<R> implements SingleObserver<R> {

            /* renamed from: b  reason: collision with root package name */
            public final AtomicReference<Disposable> f18324b;

            /* renamed from: c  reason: collision with root package name */
            public final SingleObserver<? super R> f18325c;

            public FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
                this.f18324b = atomicReference;
                this.f18325c = singleObserver;
            }

            public void onError(Throwable th2) {
                this.f18325c.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this.f18324b, disposable);
            }

            public void onSuccess(R r11) {
                this.f18325c.onSuccess(r11);
            }
        }

        public SingleFlatMapCallback(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.f18322b = singleObserver;
            this.f18323c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f18322b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f18322b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.f18323c.apply(t11), "The single returned by the mapper is null");
                if (!isDisposed()) {
                    singleSource.subscribe(new FlatMapSingleObserver(this, this.f18322b));
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18322b.onError(th2);
            }
        }
    }

    public SingleFlatMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f18321c = function;
        this.f18320b = singleSource;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f18320b.subscribe(new SingleFlatMapCallback(singleObserver, this.f18321c));
    }
}
