package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToMaybe;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeIsEmptySingle<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T>, FuseToMaybe<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f20960b;

    public static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f20961b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f20962c;

        public IsEmptyMaybeObserver(SingleObserver<? super Boolean> singleObserver) {
            this.f20961b = singleObserver;
        }

        public void dispose() {
            this.f20962c.dispose();
            this.f20962c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20962c.isDisposed();
        }

        public void onComplete() {
            this.f20962c = DisposableHelper.DISPOSED;
            this.f20961b.onSuccess(Boolean.TRUE);
        }

        public void onError(Throwable th2) {
            this.f20962c = DisposableHelper.DISPOSED;
            this.f20961b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20962c, disposable)) {
                this.f20962c = disposable;
                this.f20961b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20962c = DisposableHelper.DISPOSED;
            this.f20961b.onSuccess(Boolean.FALSE);
        }
    }

    public MaybeIsEmptySingle(MaybeSource<T> maybeSource) {
        this.f20960b = maybeSource;
    }

    public Maybe<Boolean> fuseToMaybe() {
        return RxJavaPlugins.onAssembly(new MaybeIsEmpty(this.f20960b));
    }

    public MaybeSource<T> source() {
        return this.f20960b;
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f20960b.subscribe(new IsEmptyMaybeObserver(singleObserver));
    }
}
