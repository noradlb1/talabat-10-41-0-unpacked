package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeIgnoreElement<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20953b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f20954c;

        public IgnoreMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f20953b = maybeObserver;
        }

        public void dispose() {
            this.f20954c.dispose();
            this.f20954c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20954c.isDisposed();
        }

        public void onComplete() {
            this.f20954c = DisposableHelper.DISPOSED;
            this.f20953b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20954c = DisposableHelper.DISPOSED;
            this.f20953b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20954c, disposable)) {
                this.f20954c = disposable;
                this.f20953b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20954c = DisposableHelper.DISPOSED;
            this.f20953b.onComplete();
        }
    }

    public MaybeIgnoreElement(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new IgnoreMaybeObserver(maybeObserver));
    }
}
