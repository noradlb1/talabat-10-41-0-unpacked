package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleDoFinally<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18284b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f18285c;

    public static final class DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18286b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f18287c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f18288d;

        public DoFinallyObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.f18286b = singleObserver;
            this.f18287c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f18287c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            this.f18288d.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f18288d.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f18286b.onError(th2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18288d, disposable)) {
                this.f18288d = disposable;
                this.f18286b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f18286b.onSuccess(t11);
            a();
        }
    }

    public SingleDoFinally(SingleSource<T> singleSource, Action action) {
        this.f18284b = singleSource;
        this.f18285c = action;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18284b.subscribe(new DoFinallyObserver(singleObserver, this.f18285c));
    }
}
