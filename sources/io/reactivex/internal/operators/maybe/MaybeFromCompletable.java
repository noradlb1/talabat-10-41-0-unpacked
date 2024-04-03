package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamCompletableSource;

public final class MaybeFromCompletable<T> extends Maybe<T> implements HasUpstreamCompletableSource {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f16435b;

    public static final class FromCompletableObserver<T> implements CompletableObserver, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16436b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f16437c;

        public FromCompletableObserver(MaybeObserver<? super T> maybeObserver) {
            this.f16436b = maybeObserver;
        }

        public void dispose() {
            this.f16437c.dispose();
            this.f16437c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16437c.isDisposed();
        }

        public void onComplete() {
            this.f16437c = DisposableHelper.DISPOSED;
            this.f16436b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16437c = DisposableHelper.DISPOSED;
            this.f16436b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16437c, disposable)) {
                this.f16437c = disposable;
                this.f16436b.onSubscribe(this);
            }
        }
    }

    public MaybeFromCompletable(CompletableSource completableSource) {
        this.f16435b = completableSource;
    }

    public CompletableSource source() {
        return this.f16435b;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16435b.subscribe(new FromCompletableObserver(maybeObserver));
    }
}
