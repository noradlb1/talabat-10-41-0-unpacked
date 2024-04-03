package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;

public final class CompletableToSingle<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19241b;

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<? extends T> f19242c;

    /* renamed from: d  reason: collision with root package name */
    public final T f19243d;

    public final class ToSingle implements CompletableObserver {
        private final SingleObserver<? super T> observer;

        public ToSingle(SingleObserver<? super T> singleObserver) {
            this.observer = singleObserver;
        }

        public void onComplete() {
            T t11;
            CompletableToSingle completableToSingle = CompletableToSingle.this;
            Supplier<? extends T> supplier = completableToSingle.f19242c;
            if (supplier != null) {
                try {
                    t11 = supplier.get();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.observer.onError(th2);
                    return;
                }
            } else {
                t11 = completableToSingle.f19243d;
            }
            if (t11 == null) {
                this.observer.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.observer.onSuccess(t11);
            }
        }

        public void onError(Throwable th2) {
            this.observer.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }
    }

    public CompletableToSingle(CompletableSource completableSource, Supplier<? extends T> supplier, T t11) {
        this.f19241b = completableSource;
        this.f19243d = t11;
        this.f19242c = supplier;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19241b.subscribe(new ToSingle(singleObserver));
    }
}
