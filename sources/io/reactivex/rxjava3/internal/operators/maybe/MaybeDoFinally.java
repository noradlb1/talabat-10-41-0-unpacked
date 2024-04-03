package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class MaybeDoFinally<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Action f20852c;

    public static final class DoFinallyObserver<T> extends AtomicInteger implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20853b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f20854c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20855d;

        public DoFinallyObserver(MaybeObserver<? super T> maybeObserver, Action action) {
            this.f20853b = maybeObserver;
            this.f20854c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f20854c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            this.f20855d.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f20855d.isDisposed();
        }

        public void onComplete() {
            this.f20853b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            this.f20853b.onError(th2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20855d, disposable)) {
                this.f20855d = disposable;
                this.f20853b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20853b.onSuccess(t11);
            a();
        }
    }

    public MaybeDoFinally(MaybeSource<T> maybeSource, Action action) {
        super(maybeSource);
        this.f20852c = action;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new DoFinallyObserver(maybeObserver, this.f20852c));
    }
}
