package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeDoAfterSuccess<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f20848c;

    public static final class DoAfterObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20849b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f20850c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20851d;

        public DoAfterObserver(MaybeObserver<? super T> maybeObserver, Consumer<? super T> consumer) {
            this.f20849b = maybeObserver;
            this.f20850c = consumer;
        }

        public void dispose() {
            this.f20851d.dispose();
        }

        public boolean isDisposed() {
            return this.f20851d.isDisposed();
        }

        public void onComplete() {
            this.f20849b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20849b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20851d, disposable)) {
                this.f20851d = disposable;
                this.f20849b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20849b.onSuccess(t11);
            try {
                this.f20850c.accept(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public MaybeDoAfterSuccess(MaybeSource<T> maybeSource, Consumer<? super T> consumer) {
        super(maybeSource);
        this.f20848c = consumer;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new DoAfterObserver(maybeObserver, this.f20848c));
    }
}
