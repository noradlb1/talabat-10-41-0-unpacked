package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapNotification<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f20918c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Throwable, ? extends MaybeSource<? extends R>> f20919d;

    /* renamed from: e  reason: collision with root package name */
    public final Supplier<? extends MaybeSource<? extends R>> f20920e;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f20921b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f20922c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super Throwable, ? extends MaybeSource<? extends R>> f20923d;

        /* renamed from: e  reason: collision with root package name */
        public final Supplier<? extends MaybeSource<? extends R>> f20924e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f20925f;

        public final class InnerObserver implements MaybeObserver<R> {
            public InnerObserver() {
            }

            public void onComplete() {
                FlatMapMaybeObserver.this.f20921b.onComplete();
            }

            public void onError(Throwable th2) {
                FlatMapMaybeObserver.this.f20921b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, disposable);
            }

            public void onSuccess(R r11) {
                FlatMapMaybeObserver.this.f20921b.onSuccess(r11);
            }
        }

        public FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Supplier<? extends MaybeSource<? extends R>> supplier) {
            this.f20921b = maybeObserver;
            this.f20922c = function;
            this.f20923d = function2;
            this.f20924e = supplier;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f20925f.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            try {
                Object obj = this.f20924e.get();
                Objects.requireNonNull(obj, "The onCompleteSupplier returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) obj;
                if (!isDisposed()) {
                    maybeSource.subscribe(new InnerObserver());
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20921b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f20923d.apply(th2);
                Objects.requireNonNull(apply, "The onErrorMapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                if (!isDisposed()) {
                    maybeSource.subscribe(new InnerObserver());
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f20921b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20925f, disposable)) {
                this.f20925f = disposable;
                this.f20921b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f20922c.apply(t11);
                Objects.requireNonNull(apply, "The onSuccessMapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                if (!isDisposed()) {
                    maybeSource.subscribe(new InnerObserver());
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20921b.onError(th2);
            }
        }
    }

    public MaybeFlatMapNotification(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Supplier<? extends MaybeSource<? extends R>> supplier) {
        super(maybeSource);
        this.f20918c = function;
        this.f20919d = function2;
        this.f20920e = supplier;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f20763b.subscribe(new FlatMapMaybeObserver(maybeObserver, this.f20918c, this.f20919d, this.f20920e));
    }
}
