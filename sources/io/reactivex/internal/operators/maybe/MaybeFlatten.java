package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatten<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f16428c;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f16429b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f16430c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16431d;

        public final class InnerObserver implements MaybeObserver<R> {
            public InnerObserver() {
            }

            public void onComplete() {
                FlatMapMaybeObserver.this.f16429b.onComplete();
            }

            public void onError(Throwable th2) {
                FlatMapMaybeObserver.this.f16429b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, disposable);
            }

            public void onSuccess(R r11) {
                FlatMapMaybeObserver.this.f16429b.onSuccess(r11);
            }
        }

        public FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
            this.f16429b = maybeObserver;
            this.f16430c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f16431d.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f16429b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16429b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16431d, disposable)) {
                this.f16431d = disposable;
                this.f16429b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.f16430c.apply(t11), "The mapper returned a null MaybeSource");
                if (!isDisposed()) {
                    maybeSource.subscribe(new InnerObserver());
                }
            } catch (Exception e11) {
                Exceptions.throwIfFatal(e11);
                this.f16429b.onError(e11);
            }
        }
    }

    public MaybeFlatten(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        super(maybeSource);
        this.f16428c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f16264b.subscribe(new FlatMapMaybeObserver(maybeObserver, this.f16428c));
    }
}
