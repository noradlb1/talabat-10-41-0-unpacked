package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import java.util.NoSuchElementException;

public final class MaybeToSingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f21068b;

    /* renamed from: c  reason: collision with root package name */
    public final T f21069c;

    public static final class ToSingleMaybeSubscriber<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f21070b;

        /* renamed from: c  reason: collision with root package name */
        public final T f21071c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21072d;

        public ToSingleMaybeSubscriber(SingleObserver<? super T> singleObserver, T t11) {
            this.f21070b = singleObserver;
            this.f21071c = t11;
        }

        public void dispose() {
            this.f21072d.dispose();
            this.f21072d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f21072d.isDisposed();
        }

        public void onComplete() {
            this.f21072d = DisposableHelper.DISPOSED;
            T t11 = this.f21071c;
            if (t11 != null) {
                this.f21070b.onSuccess(t11);
            } else {
                this.f21070b.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }

        public void onError(Throwable th2) {
            this.f21072d = DisposableHelper.DISPOSED;
            this.f21070b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21072d, disposable)) {
                this.f21072d = disposable;
                this.f21070b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f21072d = DisposableHelper.DISPOSED;
            this.f21070b.onSuccess(t11);
        }
    }

    public MaybeToSingle(MaybeSource<T> maybeSource, T t11) {
        this.f21068b = maybeSource;
        this.f21069c = t11;
    }

    public MaybeSource<T> source() {
        return this.f21068b;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f21068b.subscribe(new ToSingleMaybeSubscriber(singleObserver, this.f21069c));
    }
}
