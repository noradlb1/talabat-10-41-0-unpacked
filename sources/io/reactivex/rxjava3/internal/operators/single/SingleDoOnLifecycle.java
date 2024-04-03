package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SingleDoOnLifecycle<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Single<T> f22833b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Disposable> f22834c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f22835d;

    public static final class SingleLifecycleObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22836b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super Disposable> f22837c;

        /* renamed from: d  reason: collision with root package name */
        public final Action f22838d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f22839e;

        public SingleLifecycleObserver(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer, Action action) {
            this.f22836b = singleObserver;
            this.f22837c = consumer;
            this.f22838d = action;
        }

        public void dispose() {
            try {
                this.f22838d.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f22839e.dispose();
            this.f22839e = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f22839e.isDisposed();
        }

        public void onError(@NonNull Throwable th2) {
            Disposable disposable = this.f22839e;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.f22839e = disposableHelper;
                this.f22836b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(@NonNull Disposable disposable) {
            try {
                this.f22837c.accept(disposable);
                if (DisposableHelper.validate(this.f22839e, disposable)) {
                    this.f22839e = disposable;
                    this.f22836b.onSubscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                disposable.dispose();
                this.f22839e = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th2, (SingleObserver<?>) this.f22836b);
            }
        }

        public void onSuccess(@NonNull T t11) {
            Disposable disposable = this.f22839e;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.f22839e = disposableHelper;
                this.f22836b.onSuccess(t11);
            }
        }
    }

    public SingleDoOnLifecycle(Single<T> single, Consumer<? super Disposable> consumer, Action action) {
        this.f22833b = single;
        this.f22834c = consumer;
        this.f22835d = action;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22833b.subscribe(new SingleLifecycleObserver(singleObserver, this.f22834c, this.f22835d));
    }
}
