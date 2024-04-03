package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelayWithCompletable<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f20836b;

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f20837c;

    public static final class DelayWithMainObserver<T> implements MaybeObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<Disposable> f20838b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeObserver<? super T> f20839c;

        public DelayWithMainObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super T> maybeObserver) {
            this.f20838b = atomicReference;
            this.f20839c = maybeObserver;
        }

        public void onComplete() {
            this.f20839c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20839c.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f20838b, disposable);
        }

        public void onSuccess(T t11) {
            this.f20839c.onSuccess(t11);
        }
    }

    public static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 703409937383992161L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20840b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeSource<T> f20841c;

        public OtherObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.f20840b = maybeObserver;
            this.f20841c = maybeSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f20841c.subscribe(new DelayWithMainObserver(this, this.f20840b));
        }

        public void onError(Throwable th2) {
            this.f20840b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f20840b.onSubscribe(this);
            }
        }
    }

    public MaybeDelayWithCompletable(MaybeSource<T> maybeSource, CompletableSource completableSource) {
        this.f20836b = maybeSource;
        this.f20837c = completableSource;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20837c.subscribe(new OtherObserver(maybeObserver, this.f20836b));
    }
}
