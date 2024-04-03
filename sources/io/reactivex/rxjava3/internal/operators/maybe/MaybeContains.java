package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import java.util.Objects;

public final class MaybeContains<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f20802b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f20803c;

    public static final class ContainsMaybeObserver implements MaybeObserver<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f20804b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f20805c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20806d;

        public ContainsMaybeObserver(SingleObserver<? super Boolean> singleObserver, Object obj) {
            this.f20804b = singleObserver;
            this.f20805c = obj;
        }

        public void dispose() {
            this.f20806d.dispose();
            this.f20806d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20806d.isDisposed();
        }

        public void onComplete() {
            this.f20806d = DisposableHelper.DISPOSED;
            this.f20804b.onSuccess(Boolean.FALSE);
        }

        public void onError(Throwable th2) {
            this.f20806d = DisposableHelper.DISPOSED;
            this.f20804b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20806d, disposable)) {
                this.f20806d = disposable;
                this.f20804b.onSubscribe(this);
            }
        }

        public void onSuccess(Object obj) {
            this.f20806d = DisposableHelper.DISPOSED;
            this.f20804b.onSuccess(Boolean.valueOf(Objects.equals(obj, this.f20805c)));
        }
    }

    public MaybeContains(MaybeSource<T> maybeSource, Object obj) {
        this.f20802b = maybeSource;
        this.f20803c = obj;
    }

    public MaybeSource<T> source() {
        return this.f20802b;
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f20802b.subscribe(new ContainsMaybeObserver(singleObserver, this.f20803c));
    }
}
