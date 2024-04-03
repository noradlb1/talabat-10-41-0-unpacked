package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;

public final class CompletableFromSingle<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f14667b;

    public static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14668b;

        public CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.f14668b = completableObserver;
        }

        public void onError(Throwable th2) {
            this.f14668b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f14668b.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            this.f14668b.onComplete();
        }
    }

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.f14667b = singleSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14667b.subscribe(new CompletableFromSingleObserver(completableObserver));
    }
}
