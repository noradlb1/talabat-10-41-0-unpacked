package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class MaybeDoFinally<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Action f16347c;

    public static final class DoFinallyObserver<T> extends AtomicInteger implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16348b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f16349c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16350d;

        public DoFinallyObserver(MaybeObserver<? super T> maybeObserver, Action action) {
            this.f16348b = maybeObserver;
            this.f16349c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f16349c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            this.f16350d.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f16350d.isDisposed();
        }

        public void onComplete() {
            this.f16348b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            this.f16348b.onError(th2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16350d, disposable)) {
                this.f16350d = disposable;
                this.f16348b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16348b.onSuccess(t11);
            a();
        }
    }

    public MaybeDoFinally(MaybeSource<T> maybeSource, Action action) {
        super(maybeSource);
        this.f16347c = action;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new DoFinallyObserver(maybeObserver, this.f16347c));
    }
}
