package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelayWithCompletable<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16335b;

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f16336c;

    public static final class DelayWithMainObserver<T> implements MaybeObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<Disposable> f16337b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeObserver<? super T> f16338c;

        public DelayWithMainObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super T> maybeObserver) {
            this.f16337b = atomicReference;
            this.f16338c = maybeObserver;
        }

        public void onComplete() {
            this.f16338c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16338c.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f16337b, disposable);
        }

        public void onSuccess(T t11) {
            this.f16338c.onSuccess(t11);
        }
    }

    public static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 703409937383992161L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16339b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeSource<T> f16340c;

        public OtherObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.f16339b = maybeObserver;
            this.f16340c = maybeSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f16340c.subscribe(new DelayWithMainObserver(this, this.f16339b));
        }

        public void onError(Throwable th2) {
            this.f16339b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f16339b.onSubscribe(this);
            }
        }
    }

    public MaybeDelayWithCompletable(MaybeSource<T> maybeSource, CompletableSource completableSource) {
        this.f16335b = maybeSource;
        this.f16336c = completableSource;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16336c.subscribe(new OtherObserver(maybeObserver, this.f16335b));
    }
}
