package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SingleDoOnSubscribe<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22840b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Disposable> f22841c;

    public static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22842b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super Disposable> f22843c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22844d;

        public DoOnSubscribeSingleObserver(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer) {
            this.f22842b = singleObserver;
            this.f22843c = consumer;
        }

        public void onError(Throwable th2) {
            if (this.f22844d) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f22842b.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            try {
                this.f22843c.accept(disposable);
                this.f22842b.onSubscribe(disposable);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22844d = true;
                disposable.dispose();
                EmptyDisposable.error(th2, (SingleObserver<?>) this.f22842b);
            }
        }

        public void onSuccess(T t11) {
            if (!this.f22844d) {
                this.f22842b.onSuccess(t11);
            }
        }
    }

    public SingleDoOnSubscribe(SingleSource<T> singleSource, Consumer<? super Disposable> consumer) {
        this.f22840b = singleSource;
        this.f22841c = consumer;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22840b.subscribe(new DoOnSubscribeSingleObserver(singleObserver, this.f22841c));
    }
}
