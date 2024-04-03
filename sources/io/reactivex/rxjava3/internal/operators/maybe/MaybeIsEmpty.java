package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeIsEmpty<T> extends AbstractMaybeWithUpstream<T, Boolean> {

    public static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super Boolean> f20958b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f20959c;

        public IsEmptyMaybeObserver(MaybeObserver<? super Boolean> maybeObserver) {
            this.f20958b = maybeObserver;
        }

        public void dispose() {
            this.f20959c.dispose();
        }

        public boolean isDisposed() {
            return this.f20959c.isDisposed();
        }

        public void onComplete() {
            this.f20958b.onSuccess(Boolean.TRUE);
        }

        public void onError(Throwable th2) {
            this.f20958b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20959c, disposable)) {
                this.f20959c = disposable;
                this.f20958b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20958b.onSuccess(Boolean.FALSE);
        }
    }

    public MaybeIsEmpty(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    public void subscribeActual(MaybeObserver<? super Boolean> maybeObserver) {
        this.f20763b.subscribe(new IsEmptyMaybeObserver(maybeObserver));
    }
}
