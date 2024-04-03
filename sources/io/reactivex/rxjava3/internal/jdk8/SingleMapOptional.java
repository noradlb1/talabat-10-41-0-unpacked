package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j$.util.Optional;
import java.util.Objects;

public final class SingleMapOptional<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Single<T> f18998b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, Optional<? extends R>> f18999c;

    public static final class MapOptionalSingleObserver<T, R> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f19000b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, Optional<? extends R>> f19001c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f19002d;

        public MapOptionalSingleObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, Optional<? extends R>> function) {
            this.f19000b = maybeObserver;
            this.f19001c = function;
        }

        public void dispose() {
            Disposable disposable = this.f19002d;
            this.f19002d = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f19002d.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f19000b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19002d, disposable)) {
                this.f19002d = disposable;
                this.f19000b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Optional<? extends R> apply = this.f19001c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null item");
                Optional optional = apply;
                if (optional.isPresent()) {
                    this.f19000b.onSuccess(optional.get());
                } else {
                    this.f19000b.onComplete();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f19000b.onError(th2);
            }
        }
    }

    public SingleMapOptional(Single<T> single, Function<? super T, Optional<? extends R>> function) {
        this.f18998b = single;
        this.f18999c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f18998b.subscribe(new MapOptionalSingleObserver(maybeObserver, this.f18999c));
    }
}
