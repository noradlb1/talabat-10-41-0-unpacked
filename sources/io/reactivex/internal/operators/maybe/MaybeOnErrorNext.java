package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeOnErrorNext<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends MaybeSource<? extends T>> f16487c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f16488d;

    public static final class OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 2026620218879969836L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16489b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends MaybeSource<? extends T>> f16490c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f16491d;

        public static final class NextMaybeObserver<T> implements MaybeObserver<T> {

            /* renamed from: b  reason: collision with root package name */
            public final MaybeObserver<? super T> f16492b;

            /* renamed from: c  reason: collision with root package name */
            public final AtomicReference<Disposable> f16493c;

            public NextMaybeObserver(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
                this.f16492b = maybeObserver;
                this.f16493c = atomicReference;
            }

            public void onComplete() {
                this.f16492b.onComplete();
            }

            public void onError(Throwable th2) {
                this.f16492b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.f16493c, disposable);
            }

            public void onSuccess(T t11) {
                this.f16492b.onSuccess(t11);
            }
        }

        public OnErrorNextMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends MaybeSource<? extends T>> function, boolean z11) {
            this.f16489b = maybeObserver;
            this.f16490c = function;
            this.f16491d = z11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f16489b.onComplete();
        }

        public void onError(Throwable th2) {
            if (this.f16491d || (th2 instanceof Exception)) {
                try {
                    MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.f16490c.apply(th2), "The resumeFunction returned a null MaybeSource");
                    DisposableHelper.replace(this, (Disposable) null);
                    maybeSource.subscribe(new NextMaybeObserver(this.f16489b, this));
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f16489b.onError(new CompositeException(th2, th3));
                }
            } else {
                this.f16489b.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f16489b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16489b.onSuccess(t11);
        }
    }

    public MaybeOnErrorNext(MaybeSource<T> maybeSource, Function<? super Throwable, ? extends MaybeSource<? extends T>> function, boolean z11) {
        super(maybeSource);
        this.f16487c = function;
        this.f16488d = z11;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new OnErrorNextMaybeObserver(maybeObserver, this.f16487c, this.f16488d));
    }
}
