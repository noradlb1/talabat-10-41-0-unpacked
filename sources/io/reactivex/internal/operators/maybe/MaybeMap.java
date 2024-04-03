package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

public final class MaybeMap<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends R> f16459c;

    public static final class MapMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f16460b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f16461c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16462d;

        public MapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends R> function) {
            this.f16460b = maybeObserver;
            this.f16461c = function;
        }

        public void dispose() {
            Disposable disposable = this.f16462d;
            this.f16462d = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f16462d.isDisposed();
        }

        public void onComplete() {
            this.f16460b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16460b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16462d, disposable)) {
                this.f16462d = disposable;
                this.f16460b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                this.f16460b.onSuccess(ObjectHelper.requireNonNull(this.f16461c.apply(t11), "The mapper returned a null item"));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16460b.onError(th2);
            }
        }
    }

    public MaybeMap(MaybeSource<T> maybeSource, Function<? super T, ? extends R> function) {
        super(maybeSource);
        this.f16459c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f16264b.subscribe(new MapMaybeObserver(maybeObserver, this.f16459c));
    }
}
