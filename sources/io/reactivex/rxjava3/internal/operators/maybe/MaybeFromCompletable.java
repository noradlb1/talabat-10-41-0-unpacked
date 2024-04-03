package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamCompletableSource;

public final class MaybeFromCompletable<T> extends Maybe<T> implements HasUpstreamCompletableSource {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f20940b;

    public static final class FromCompletableObserver<T> implements CompletableObserver, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20941b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f20942c;

        public FromCompletableObserver(MaybeObserver<? super T> maybeObserver) {
            this.f20941b = maybeObserver;
        }

        public void dispose() {
            this.f20942c.dispose();
            this.f20942c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20942c.isDisposed();
        }

        public void onComplete() {
            this.f20942c = DisposableHelper.DISPOSED;
            this.f20941b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20942c = DisposableHelper.DISPOSED;
            this.f20941b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20942c, disposable)) {
                this.f20942c = disposable;
                this.f20941b.onSubscribe(this);
            }
        }
    }

    public MaybeFromCompletable(CompletableSource completableSource) {
        this.f20940b = completableSource;
    }

    public CompletableSource source() {
        return this.f20940b;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20940b.subscribe(new FromCompletableObserver(maybeObserver));
    }
}
