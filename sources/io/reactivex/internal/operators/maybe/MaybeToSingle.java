package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import java.util.NoSuchElementException;

public final class MaybeToSingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16555b;

    /* renamed from: c  reason: collision with root package name */
    public final T f16556c;

    public static final class ToSingleMaybeSubscriber<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f16557b;

        /* renamed from: c  reason: collision with root package name */
        public final T f16558c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16559d;

        public ToSingleMaybeSubscriber(SingleObserver<? super T> singleObserver, T t11) {
            this.f16557b = singleObserver;
            this.f16558c = t11;
        }

        public void dispose() {
            this.f16559d.dispose();
            this.f16559d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16559d.isDisposed();
        }

        public void onComplete() {
            this.f16559d = DisposableHelper.DISPOSED;
            T t11 = this.f16558c;
            if (t11 != null) {
                this.f16557b.onSuccess(t11);
            } else {
                this.f16557b.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }

        public void onError(Throwable th2) {
            this.f16559d = DisposableHelper.DISPOSED;
            this.f16557b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16559d, disposable)) {
                this.f16559d = disposable;
                this.f16557b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16559d = DisposableHelper.DISPOSED;
            this.f16557b.onSuccess(t11);
        }
    }

    public MaybeToSingle(MaybeSource<T> maybeSource, T t11) {
        this.f16555b = maybeSource;
        this.f16556c = t11;
    }

    public MaybeSource<T> source() {
        return this.f16555b;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f16555b.subscribe(new ToSingleMaybeSubscriber(singleObserver, this.f16556c));
    }
}
