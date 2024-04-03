package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;

public final class SingleContains<T> extends Single<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18229b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f18230c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<Object, Object> f18231d;

    public final class ContainsSingleObserver implements SingleObserver<T> {
        private final SingleObserver<? super Boolean> downstream;

        public ContainsSingleObserver(SingleObserver<? super Boolean> singleObserver) {
            this.downstream = singleObserver;
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            try {
                SingleContains singleContains = SingleContains.this;
                this.downstream.onSuccess(Boolean.valueOf(singleContains.f18231d.test(t11, singleContains.f18230c)));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.f18229b = singleSource;
        this.f18230c = obj;
        this.f18231d = biPredicate;
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f18229b.subscribe(new ContainsSingleObserver(singleObserver));
    }
}
