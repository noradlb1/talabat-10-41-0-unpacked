package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToMaybe;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeIgnoreElementCompletable<T> extends Completable implements FuseToMaybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f20955b;

    public static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f20956b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f20957c;

        public IgnoreMaybeObserver(CompletableObserver completableObserver) {
            this.f20956b = completableObserver;
        }

        public void dispose() {
            this.f20957c.dispose();
            this.f20957c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20957c.isDisposed();
        }

        public void onComplete() {
            this.f20957c = DisposableHelper.DISPOSED;
            this.f20956b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20957c = DisposableHelper.DISPOSED;
            this.f20956b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20957c, disposable)) {
                this.f20957c = disposable;
                this.f20956b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20957c = DisposableHelper.DISPOSED;
            this.f20956b.onComplete();
        }
    }

    public MaybeIgnoreElementCompletable(MaybeSource<T> maybeSource) {
        this.f20955b = maybeSource;
    }

    public Maybe<T> fuseToMaybe() {
        return RxJavaPlugins.onAssembly(new MaybeIgnoreElement(this.f20955b));
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f20955b.subscribe(new IgnoreMaybeObserver(completableObserver));
    }
}
