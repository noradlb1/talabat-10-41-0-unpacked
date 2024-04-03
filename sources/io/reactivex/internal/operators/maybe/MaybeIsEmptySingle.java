package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybeIsEmptySingle<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T>, FuseToMaybe<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16454b;

    public static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f16455b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f16456c;

        public IsEmptyMaybeObserver(SingleObserver<? super Boolean> singleObserver) {
            this.f16455b = singleObserver;
        }

        public void dispose() {
            this.f16456c.dispose();
            this.f16456c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16456c.isDisposed();
        }

        public void onComplete() {
            this.f16456c = DisposableHelper.DISPOSED;
            this.f16455b.onSuccess(Boolean.TRUE);
        }

        public void onError(Throwable th2) {
            this.f16456c = DisposableHelper.DISPOSED;
            this.f16455b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16456c, disposable)) {
                this.f16456c = disposable;
                this.f16455b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16456c = DisposableHelper.DISPOSED;
            this.f16455b.onSuccess(Boolean.FALSE);
        }
    }

    public MaybeIsEmptySingle(MaybeSource<T> maybeSource) {
        this.f16454b = maybeSource;
    }

    public Maybe<Boolean> fuseToMaybe() {
        return RxJavaPlugins.onAssembly(new MaybeIsEmpty(this.f16454b));
    }

    public MaybeSource<T> source() {
        return this.f16454b;
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f16454b.subscribe(new IsEmptyMaybeObserver(singleObserver));
    }
}
