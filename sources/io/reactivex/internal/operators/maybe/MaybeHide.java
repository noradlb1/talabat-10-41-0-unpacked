package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeHide<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class HideMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16445b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f16446c;

        public HideMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f16445b = maybeObserver;
        }

        public void dispose() {
            this.f16446c.dispose();
            this.f16446c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16446c.isDisposed();
        }

        public void onComplete() {
            this.f16445b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16445b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16446c, disposable)) {
                this.f16446c = disposable;
                this.f16445b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16445b.onSuccess(t11);
        }
    }

    public MaybeHide(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new HideMaybeObserver(maybeObserver));
    }
}
