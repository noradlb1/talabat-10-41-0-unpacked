package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;

public final class MaybeCount<T> extends Single<Long> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f20807b;

    public static final class CountMaybeObserver implements MaybeObserver<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Long> f20808b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f20809c;

        public CountMaybeObserver(SingleObserver<? super Long> singleObserver) {
            this.f20808b = singleObserver;
        }

        public void dispose() {
            this.f20809c.dispose();
            this.f20809c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20809c.isDisposed();
        }

        public void onComplete() {
            this.f20809c = DisposableHelper.DISPOSED;
            this.f20808b.onSuccess(0L);
        }

        public void onError(Throwable th2) {
            this.f20809c = DisposableHelper.DISPOSED;
            this.f20808b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20809c, disposable)) {
                this.f20809c = disposable;
                this.f20808b.onSubscribe(this);
            }
        }

        public void onSuccess(Object obj) {
            this.f20809c = DisposableHelper.DISPOSED;
            this.f20808b.onSuccess(1L);
        }
    }

    public MaybeCount(MaybeSource<T> maybeSource) {
        this.f20807b = maybeSource;
    }

    public MaybeSource<T> source() {
        return this.f20807b;
    }

    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f20807b.subscribe(new CountMaybeObserver(singleObserver));
    }
}
