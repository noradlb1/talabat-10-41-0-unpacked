package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeDetach<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class DetachMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public MaybeObserver<? super T> f20846b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f20847c;

        public DetachMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f20846b = maybeObserver;
        }

        public void dispose() {
            this.f20846b = null;
            this.f20847c.dispose();
            this.f20847c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20847c.isDisposed();
        }

        public void onComplete() {
            this.f20847c = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.f20846b;
            if (maybeObserver != null) {
                this.f20846b = null;
                maybeObserver.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f20847c = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.f20846b;
            if (maybeObserver != null) {
                this.f20846b = null;
                maybeObserver.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20847c, disposable)) {
                this.f20847c = disposable;
                this.f20846b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20847c = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.f20846b;
            if (maybeObserver != null) {
                this.f20846b = null;
                maybeObserver.onSuccess(t11);
            }
        }
    }

    public MaybeDetach(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new DetachMaybeObserver(maybeObserver));
    }
}
