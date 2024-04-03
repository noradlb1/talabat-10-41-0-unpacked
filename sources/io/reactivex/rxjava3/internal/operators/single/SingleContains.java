package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;

public final class SingleContains<T> extends Single<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22763b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f22764c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<Object, Object> f22765d;

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
                this.downstream.onSuccess(Boolean.valueOf(singleContains.f22765d.test(t11, singleContains.f22764c)));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.f22763b = singleSource;
        this.f22764c = obj;
        this.f22765d = biPredicate;
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f22763b.subscribe(new ContainsSingleObserver(singleObserver));
    }
}
