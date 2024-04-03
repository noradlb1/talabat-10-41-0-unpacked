package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SingleDoAfterTerminate<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22813b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f22814c;

    public static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22815b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f22816c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22817d;

        public DoAfterTerminateObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.f22815b = singleObserver;
            this.f22816c = action;
        }

        private void onAfterTerminate() {
            try {
                this.f22816c.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        public void dispose() {
            this.f22817d.dispose();
        }

        public boolean isDisposed() {
            return this.f22817d.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f22815b.onError(th2);
            onAfterTerminate();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22817d, disposable)) {
                this.f22817d = disposable;
                this.f22815b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f22815b.onSuccess(t11);
            onAfterTerminate();
        }
    }

    public SingleDoAfterTerminate(SingleSource<T> singleSource, Action action) {
        this.f22813b = singleSource;
        this.f22814c = action;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22813b.subscribe(new DoAfterTerminateObserver(singleObserver, this.f22814c));
    }
}
