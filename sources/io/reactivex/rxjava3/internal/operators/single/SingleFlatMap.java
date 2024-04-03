package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMap<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f22861b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f22862c;

    public static final class SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 3258103020495908596L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f22863b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f22864c;

        public static final class FlatMapSingleObserver<R> implements SingleObserver<R> {

            /* renamed from: b  reason: collision with root package name */
            public final AtomicReference<Disposable> f22865b;

            /* renamed from: c  reason: collision with root package name */
            public final SingleObserver<? super R> f22866c;

            public FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
                this.f22865b = atomicReference;
                this.f22866c = singleObserver;
            }

            public void onError(Throwable th2) {
                this.f22866c.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this.f22865b, disposable);
            }

            public void onSuccess(R r11) {
                this.f22866c.onSuccess(r11);
            }
        }

        public SingleFlatMapCallback(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.f22863b = singleObserver;
            this.f22864c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f22863b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f22863b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f22864c.apply(t11);
                Objects.requireNonNull(apply, "The single returned by the mapper is null");
                SingleSource singleSource = (SingleSource) apply;
                if (!isDisposed()) {
                    singleSource.subscribe(new FlatMapSingleObserver(this, this.f22863b));
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22863b.onError(th2);
            }
        }
    }

    public SingleFlatMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f22862c = function;
        this.f22861b = singleSource;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f22861b.subscribe(new SingleFlatMapCallback(singleObserver, this.f22862c));
    }
}
