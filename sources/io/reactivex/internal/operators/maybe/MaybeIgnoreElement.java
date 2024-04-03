package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeIgnoreElement<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16447b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f16448c;

        public IgnoreMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f16447b = maybeObserver;
        }

        public void dispose() {
            this.f16448c.dispose();
            this.f16448c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16448c.isDisposed();
        }

        public void onComplete() {
            this.f16448c = DisposableHelper.DISPOSED;
            this.f16447b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16448c = DisposableHelper.DISPOSED;
            this.f16447b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16448c, disposable)) {
                this.f16448c = disposable;
                this.f16447b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16448c = DisposableHelper.DISPOSED;
            this.f16447b.onComplete();
        }
    }

    public MaybeIgnoreElement(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new IgnoreMaybeObserver(maybeObserver));
    }
}
