package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

public final class CompletableToSingle<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14751b;

    /* renamed from: c  reason: collision with root package name */
    public final Callable<? extends T> f14752c;

    /* renamed from: d  reason: collision with root package name */
    public final T f14753d;

    public final class ToSingle implements CompletableObserver {
        private final SingleObserver<? super T> observer;

        public ToSingle(SingleObserver<? super T> singleObserver) {
            this.observer = singleObserver;
        }

        public void onComplete() {
            T t11;
            CompletableToSingle completableToSingle = CompletableToSingle.this;
            Callable<? extends T> callable = completableToSingle.f14752c;
            if (callable != null) {
                try {
                    t11 = callable.call();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.observer.onError(th2);
                    return;
                }
            } else {
                t11 = completableToSingle.f14753d;
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

    public CompletableToSingle(CompletableSource completableSource, Callable<? extends T> callable, T t11) {
        this.f14751b = completableSource;
        this.f14753d = t11;
        this.f14752c = callable;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f14751b.subscribe(new ToSingle(singleObserver));
    }
}
