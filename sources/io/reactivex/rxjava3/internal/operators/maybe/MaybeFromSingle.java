package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamSingleSource;

public final class MaybeFromSingle<T> extends Maybe<T> implements HasUpstreamSingleSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f20947b;

    public static final class FromSingleObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20948b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f20949c;

        public FromSingleObserver(MaybeObserver<? super T> maybeObserver) {
            this.f20948b = maybeObserver;
        }

        public void dispose() {
            this.f20949c.dispose();
            this.f20949c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20949c.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f20949c = DisposableHelper.DISPOSED;
            this.f20948b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20949c, disposable)) {
                this.f20949c = disposable;
                this.f20948b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20949c = DisposableHelper.DISPOSED;
            this.f20948b.onSuccess(t11);
        }
    }

    public MaybeFromSingle(SingleSource<T> singleSource) {
        this.f20947b = singleSource;
    }

    public SingleSource<T> source() {
        return this.f20947b;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20947b.subscribe(new FromSingleObserver(maybeObserver));
    }
}
