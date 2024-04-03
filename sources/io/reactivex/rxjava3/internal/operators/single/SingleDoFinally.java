package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleDoFinally<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22818b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f22819c;

    public static final class DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22820b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f22821c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22822d;

        public DoFinallyObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.f22820b = singleObserver;
            this.f22821c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f22821c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            this.f22822d.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f22822d.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f22820b.onError(th2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22822d, disposable)) {
                this.f22822d = disposable;
                this.f22820b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f22820b.onSuccess(t11);
            a();
        }
    }

    public SingleDoFinally(SingleSource<T> singleSource, Action action) {
        this.f22818b = singleSource;
        this.f22819c = action;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22818b.subscribe(new DoFinallyObserver(singleObserver, this.f22819c));
    }
}
