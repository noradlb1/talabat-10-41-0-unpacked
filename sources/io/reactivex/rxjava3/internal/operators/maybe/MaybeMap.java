package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

public final class MaybeMap<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends R> f20965c;

    public static final class MapMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f20966b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f20967c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20968d;

        public MapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends R> function) {
            this.f20966b = maybeObserver;
            this.f20967c = function;
        }

        public void dispose() {
            Disposable disposable = this.f20968d;
            this.f20968d = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f20968d.isDisposed();
        }

        public void onComplete() {
            this.f20966b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20966b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20968d, disposable)) {
                this.f20968d = disposable;
                this.f20966b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f20967c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null item");
                this.f20966b.onSuccess(apply);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20966b.onError(th2);
            }
        }
    }

    public MaybeMap(MaybeSource<T> maybeSource, Function<? super T, ? extends R> function) {
        super(maybeSource);
        this.f20965c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f20763b.subscribe(new MapMaybeObserver(maybeObserver, this.f20965c));
    }
}
