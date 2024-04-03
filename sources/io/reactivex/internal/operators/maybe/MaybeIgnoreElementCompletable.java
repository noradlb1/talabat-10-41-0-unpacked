package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybeIgnoreElementCompletable<T> extends Completable implements FuseToMaybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16449b;

    public static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f16450b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f16451c;

        public IgnoreMaybeObserver(CompletableObserver completableObserver) {
            this.f16450b = completableObserver;
        }

        public void dispose() {
            this.f16451c.dispose();
            this.f16451c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16451c.isDisposed();
        }

        public void onComplete() {
            this.f16451c = DisposableHelper.DISPOSED;
            this.f16450b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16451c = DisposableHelper.DISPOSED;
            this.f16450b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16451c, disposable)) {
                this.f16451c = disposable;
                this.f16450b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16451c = DisposableHelper.DISPOSED;
            this.f16450b.onComplete();
        }
    }

    public MaybeIgnoreElementCompletable(MaybeSource<T> maybeSource) {
        this.f16449b = maybeSource;
    }

    public Maybe<T> fuseToMaybe() {
        return RxJavaPlugins.onAssembly(new MaybeIgnoreElement(this.f16449b));
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f16449b.subscribe(new IgnoreMaybeObserver(completableObserver));
    }
}
