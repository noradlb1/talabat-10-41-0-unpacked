package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;

public final class CompletableFromSingle<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f19152b;

    public static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19153b;

        public CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.f19153b = completableObserver;
        }

        public void onError(Throwable th2) {
            this.f19153b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f19153b.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            this.f19153b.onComplete();
        }
    }

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.f19152b = singleSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19152b.subscribe(new CompletableFromSingleObserver(completableObserver));
    }
}
