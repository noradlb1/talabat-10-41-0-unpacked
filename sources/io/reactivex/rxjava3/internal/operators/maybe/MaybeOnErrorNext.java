package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeOnErrorNext<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends MaybeSource<? extends T>> f20993c;

    public static final class OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 2026620218879969836L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20994b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends MaybeSource<? extends T>> f20995c;

        public static final class NextMaybeObserver<T> implements MaybeObserver<T> {

            /* renamed from: b  reason: collision with root package name */
            public final MaybeObserver<? super T> f20996b;

            /* renamed from: c  reason: collision with root package name */
            public final AtomicReference<Disposable> f20997c;

            public NextMaybeObserver(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
                this.f20996b = maybeObserver;
                this.f20997c = atomicReference;
            }

            public void onComplete() {
                this.f20996b.onComplete();
            }

            public void onError(Throwable th2) {
                this.f20996b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.f20997c, disposable);
            }

            public void onSuccess(T t11) {
                this.f20996b.onSuccess(t11);
            }
        }

        public OnErrorNextMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends MaybeSource<? extends T>> function) {
            this.f20994b = maybeObserver;
            this.f20995c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f20994b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f20995c.apply(th2);
                Objects.requireNonNull(apply, "The resumeFunction returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                DisposableHelper.replace(this, (Disposable) null);
                maybeSource.subscribe(new NextMaybeObserver(this.f20994b, this));
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f20994b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f20994b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20994b.onSuccess(t11);
        }
    }

    public MaybeOnErrorNext(MaybeSource<T> maybeSource, Function<? super Throwable, ? extends MaybeSource<? extends T>> function) {
        super(maybeSource);
        this.f20993c = function;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new OnErrorNextMaybeObserver(maybeObserver, this.f20993c));
    }
}
