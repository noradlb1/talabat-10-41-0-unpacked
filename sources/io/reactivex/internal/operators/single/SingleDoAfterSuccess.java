package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class SingleDoAfterSuccess<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18274b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f18275c;

    public static final class DoAfterObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18276b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f18277c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f18278d;

        public DoAfterObserver(SingleObserver<? super T> singleObserver, Consumer<? super T> consumer) {
            this.f18276b = singleObserver;
            this.f18277c = consumer;
        }

        public void dispose() {
            this.f18278d.dispose();
        }

        public boolean isDisposed() {
            return this.f18278d.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f18276b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18278d, disposable)) {
                this.f18278d = disposable;
                this.f18276b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f18276b.onSuccess(t11);
            try {
                this.f18277c.accept(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public SingleDoAfterSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f18274b = singleSource;
        this.f18275c = consumer;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18274b.subscribe(new DoAfterObserver(singleObserver, this.f18275c));
    }
}
