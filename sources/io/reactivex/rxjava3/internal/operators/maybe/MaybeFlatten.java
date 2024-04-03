package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatten<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f20933c;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f20934b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f20935c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20936d;

        public final class InnerObserver implements MaybeObserver<R> {
            public InnerObserver() {
            }

            public void onComplete() {
                FlatMapMaybeObserver.this.f20934b.onComplete();
            }

            public void onError(Throwable th2) {
                FlatMapMaybeObserver.this.f20934b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, disposable);
            }

            public void onSuccess(R r11) {
                FlatMapMaybeObserver.this.f20934b.onSuccess(r11);
            }
        }

        public FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
            this.f20934b = maybeObserver;
            this.f20935c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f20936d.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f20934b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20934b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20936d, disposable)) {
                this.f20936d = disposable;
                this.f20934b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f20935c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                if (!isDisposed()) {
                    maybeSource.subscribe(new InnerObserver());
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20934b.onError(th2);
            }
        }
    }

    public MaybeFlatten(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        super(maybeSource);
        this.f20933c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f20763b.subscribe(new FlatMapMaybeObserver(maybeObserver, this.f20933c));
    }
}
