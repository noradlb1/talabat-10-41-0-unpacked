package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class SingleDoOnSubscribe<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18299b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Disposable> f18300c;

    public static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18301b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super Disposable> f18302c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f18303d;

        public DoOnSubscribeSingleObserver(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer) {
            this.f18301b = singleObserver;
            this.f18302c = consumer;
        }

        public void onError(Throwable th2) {
            if (this.f18303d) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f18301b.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            try {
                this.f18302c.accept(disposable);
                this.f18301b.onSubscribe(disposable);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18303d = true;
                disposable.dispose();
                EmptyDisposable.error(th2, (SingleObserver<?>) this.f18301b);
            }
        }

        public void onSuccess(T t11) {
            if (!this.f18303d) {
                this.f18301b.onSuccess(t11);
            }
        }
    }

    public SingleDoOnSubscribe(SingleSource<T> singleSource, Consumer<? super Disposable> consumer) {
        this.f18299b = singleSource;
        this.f18300c = consumer;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18299b.subscribe(new DoOnSubscribeSingleObserver(singleObserver, this.f18300c));
    }
}
