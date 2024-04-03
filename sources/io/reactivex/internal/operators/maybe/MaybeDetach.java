package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeDetach<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class DetachMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public MaybeObserver<? super T> f16341b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f16342c;

        public DetachMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f16341b = maybeObserver;
        }

        public void dispose() {
            this.f16341b = null;
            this.f16342c.dispose();
            this.f16342c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16342c.isDisposed();
        }

        public void onComplete() {
            this.f16342c = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.f16341b;
            if (maybeObserver != null) {
                this.f16341b = null;
                maybeObserver.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f16342c = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.f16341b;
            if (maybeObserver != null) {
                this.f16341b = null;
                maybeObserver.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16342c, disposable)) {
                this.f16342c = disposable;
                this.f16341b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16342c = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.f16341b;
            if (maybeObserver != null) {
                this.f16341b = null;
                maybeObserver.onSuccess(t11);
            }
        }
    }

    public MaybeDetach(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new DetachMaybeObserver(maybeObserver));
    }
}
