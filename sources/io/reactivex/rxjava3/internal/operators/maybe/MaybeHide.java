package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeHide<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class HideMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20951b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f20952c;

        public HideMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f20951b = maybeObserver;
        }

        public void dispose() {
            this.f20952c.dispose();
            this.f20952c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20952c.isDisposed();
        }

        public void onComplete() {
            this.f20951b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20951b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20952c, disposable)) {
                this.f20952c = disposable;
                this.f20951b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20951b.onSuccess(t11);
        }
    }

    public MaybeHide(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new HideMaybeObserver(maybeObserver));
    }
}
