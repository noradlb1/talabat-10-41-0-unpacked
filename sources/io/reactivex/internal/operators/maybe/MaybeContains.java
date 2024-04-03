package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

public final class MaybeContains<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16303b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f16304c;

    public static final class ContainsMaybeObserver implements MaybeObserver<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f16305b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f16306c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16307d;

        public ContainsMaybeObserver(SingleObserver<? super Boolean> singleObserver, Object obj) {
            this.f16305b = singleObserver;
            this.f16306c = obj;
        }

        public void dispose() {
            this.f16307d.dispose();
            this.f16307d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16307d.isDisposed();
        }

        public void onComplete() {
            this.f16307d = DisposableHelper.DISPOSED;
            this.f16305b.onSuccess(Boolean.FALSE);
        }

        public void onError(Throwable th2) {
            this.f16307d = DisposableHelper.DISPOSED;
            this.f16305b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16307d, disposable)) {
                this.f16307d = disposable;
                this.f16305b.onSubscribe(this);
            }
        }

        public void onSuccess(Object obj) {
            this.f16307d = DisposableHelper.DISPOSED;
            this.f16305b.onSuccess(Boolean.valueOf(ObjectHelper.equals(obj, this.f16306c)));
        }
    }

    public MaybeContains(MaybeSource<T> maybeSource, Object obj) {
        this.f16303b = maybeSource;
        this.f16304c = obj;
    }

    public MaybeSource<T> source() {
        return this.f16303b;
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f16303b.subscribe(new ContainsMaybeObserver(singleObserver, this.f16304c));
    }
}
