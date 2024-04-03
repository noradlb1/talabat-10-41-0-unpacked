package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDoOnDispose<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22823b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f22824c;

    public static final class DoOnDisposeObserver<T> extends AtomicReference<Action> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -8583764624474935784L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22825b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f22826c;

        public DoOnDisposeObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.f22825b = singleObserver;
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
                this.f22826c.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f22826c.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f22825b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22826c, disposable)) {
                this.f22826c = disposable;
                this.f22825b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f22825b.onSuccess(t11);
        }
    }

    public SingleDoOnDispose(SingleSource<T> singleSource, Action action) {
        this.f22823b = singleSource;
        this.f22824c = action;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22823b.subscribe(new DoOnDisposeObserver(singleObserver, this.f22824c));
    }
}
