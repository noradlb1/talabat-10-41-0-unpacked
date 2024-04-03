package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDoOnDispose<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18289b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f18290c;

    public static final class DoOnDisposeObserver<T> extends AtomicReference<Action> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -8583764624474935784L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18291b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f18292c;

        public DoOnDisposeObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.f18291b = singleObserver;
            lazySet(action);
        }

        public void dispose() {
            Action action = (Action) getAndSet((Object) null);
            if (action != null) {
                try {
                    action.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
                this.f18292c.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f18292c.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f18291b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18292c, disposable)) {
                this.f18292c = disposable;
                this.f18291b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f18291b.onSuccess(t11);
        }
    }

    public SingleDoOnDispose(SingleSource<T> singleSource, Action action) {
        this.f18289b = singleSource;
        this.f18290c = action;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18289b.subscribe(new DoOnDisposeObserver(singleObserver, this.f18290c));
    }
}
