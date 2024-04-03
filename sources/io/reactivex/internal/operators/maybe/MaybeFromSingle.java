package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamSingleSource;

public final class MaybeFromSingle<T> extends Maybe<T> implements HasUpstreamSingleSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f16442b;

    public static final class FromSingleObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16443b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f16444c;

        public FromSingleObserver(MaybeObserver<? super T> maybeObserver) {
            this.f16443b = maybeObserver;
        }

        public void dispose() {
            this.f16444c.dispose();
            this.f16444c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16444c.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f16444c = DisposableHelper.DISPOSED;
            this.f16443b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16444c, disposable)) {
                this.f16444c = disposable;
                this.f16443b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16444c = DisposableHelper.DISPOSED;
            this.f16443b.onSuccess(t11);
        }
    }

    public MaybeFromSingle(SingleSource<T> singleSource) {
        this.f16442b = singleSource;
    }

    public SingleSource<T> source() {
        return this.f16442b;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16442b.subscribe(new FromSingleObserver(maybeObserver));
    }
}
