package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class SingleDoAfterTerminate<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18279b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f18280c;

    public static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18281b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f18282c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f18283d;

        public DoAfterTerminateObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.f18281b = singleObserver;
            this.f18282c = action;
        }

        private void onAfterTerminate() {
            try {
                this.f18282c.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        public void dispose() {
            this.f18283d.dispose();
        }

        public boolean isDisposed() {
            return this.f18283d.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f18281b.onError(th2);
            onAfterTerminate();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18283d, disposable)) {
                this.f18283d = disposable;
                this.f18281b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f18281b.onSuccess(t11);
            onAfterTerminate();
        }
    }

    public SingleDoAfterTerminate(SingleSource<T> singleSource, Action action) {
        this.f18279b = singleSource;
        this.f18280c = action;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18279b.subscribe(new DoAfterTerminateObserver(singleObserver, this.f18280c));
    }
}
