package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeIsEmpty<T> extends AbstractMaybeWithUpstream<T, Boolean> {

    public static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super Boolean> f16452b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f16453c;

        public IsEmptyMaybeObserver(MaybeObserver<? super Boolean> maybeObserver) {
            this.f16452b = maybeObserver;
        }

        public void dispose() {
            this.f16453c.dispose();
        }

        public boolean isDisposed() {
            return this.f16453c.isDisposed();
        }

        public void onComplete() {
            this.f16452b.onSuccess(Boolean.TRUE);
        }

        public void onError(Throwable th2) {
            this.f16452b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16453c, disposable)) {
                this.f16453c = disposable;
                this.f16452b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16452b.onSuccess(Boolean.FALSE);
        }
    }

    public MaybeIsEmpty(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    public void subscribeActual(MaybeObserver<? super Boolean> maybeObserver) {
        this.f16264b.subscribe(new IsEmptyMaybeObserver(maybeObserver));
    }
}
