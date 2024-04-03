package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapNotification<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f16407c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Throwable, ? extends MaybeSource<? extends R>> f16408d;

    /* renamed from: e  reason: collision with root package name */
    public final Callable<? extends MaybeSource<? extends R>> f16409e;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f16410b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f16411c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super Throwable, ? extends MaybeSource<? extends R>> f16412d;

        /* renamed from: e  reason: collision with root package name */
        public final Callable<? extends MaybeSource<? extends R>> f16413e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f16414f;

        public final class InnerObserver implements MaybeObserver<R> {
            public InnerObserver() {
            }

            public void onComplete() {
                FlatMapMaybeObserver.this.f16410b.onComplete();
            }

            public void onError(Throwable th2) {
                FlatMapMaybeObserver.this.f16410b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, disposable);
            }

            public void onSuccess(R r11) {
                FlatMapMaybeObserver.this.f16410b.onSuccess(r11);
            }
        }

        public FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
            this.f16410b = maybeObserver;
            this.f16411c = function;
            this.f16412d = function2;
            this.f16413e = callable;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f16414f.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            try {
                ((MaybeSource) ObjectHelper.requireNonNull(this.f16413e.call(), "The onCompleteSupplier returned a null MaybeSource")).subscribe(new InnerObserver());
            } catch (Exception e11) {
                Exceptions.throwIfFatal(e11);
                this.f16410b.onError(e11);
            }
        }

        public void onError(Throwable th2) {
            try {
                ((MaybeSource) ObjectHelper.requireNonNull(this.f16412d.apply(th2), "The onErrorMapper returned a null MaybeSource")).subscribe(new InnerObserver());
            } catch (Exception e11) {
                Exceptions.throwIfFatal(e11);
                this.f16410b.onError(new CompositeException(th2, e11));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16414f, disposable)) {
                this.f16414f = disposable;
                this.f16410b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                ((MaybeSource) ObjectHelper.requireNonNull(this.f16411c.apply(t11), "The onSuccessMapper returned a null MaybeSource")).subscribe(new InnerObserver());
            } catch (Exception e11) {
                Exceptions.throwIfFatal(e11);
                this.f16410b.onError(e11);
            }
        }
    }

    public MaybeFlatMapNotification(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
        super(maybeSource);
        this.f16407c = function;
        this.f16408d = function2;
        this.f16409e = callable;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f16264b.subscribe(new FlatMapMaybeObserver(maybeObserver, this.f16407c, this.f16408d, this.f16409e));
    }
}
