package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

public final class MaybeCount<T> extends Single<Long> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16308b;

    public static final class CountMaybeObserver implements MaybeObserver<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Long> f16309b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f16310c;

        public CountMaybeObserver(SingleObserver<? super Long> singleObserver) {
            this.f16309b = singleObserver;
        }

        public void dispose() {
            this.f16310c.dispose();
            this.f16310c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16310c.isDisposed();
        }

        public void onComplete() {
            this.f16310c = DisposableHelper.DISPOSED;
            this.f16309b.onSuccess(0L);
        }

        public void onError(Throwable th2) {
            this.f16310c = DisposableHelper.DISPOSED;
            this.f16309b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16310c, disposable)) {
                this.f16310c = disposable;
                this.f16309b.onSubscribe(this);
            }
        }

        public void onSuccess(Object obj) {
            this.f16310c = DisposableHelper.DISPOSED;
            this.f16309b.onSuccess(1L);
        }
    }

    public MaybeCount(MaybeSource<T> maybeSource) {
        this.f16308b = maybeSource;
    }

    public MaybeSource<T> source() {
        return this.f16308b;
    }

    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f16308b.subscribe(new CountMaybeObserver(singleObserver));
    }
}
