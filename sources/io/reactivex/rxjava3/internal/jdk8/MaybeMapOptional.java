package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j$.util.Optional;
import java.util.Objects;

public final class MaybeMapOptional<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Maybe<T> f18902b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, Optional<? extends R>> f18903c;

    public static final class MapOptionalMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f18904b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, Optional<? extends R>> f18905c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f18906d;

        public MapOptionalMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, Optional<? extends R>> function) {
            this.f18904b = maybeObserver;
            this.f18905c = function;
        }

        public void dispose() {
            Disposable disposable = this.f18906d;
            this.f18906d = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f18906d.isDisposed();
        }

        public void onComplete() {
            this.f18904b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f18904b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18906d, disposable)) {
                this.f18906d = disposable;
                this.f18904b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Optional<? extends R> apply = this.f18905c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null item");
                Optional optional = apply;
                if (optional.isPresent()) {
                    this.f18904b.onSuccess(optional.get());
                } else {
                    this.f18904b.onComplete();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18904b.onError(th2);
            }
        }
    }

    public MaybeMapOptional(Maybe<T> maybe, Function<? super T, Optional<? extends R>> function) {
        this.f18902b = maybe;
        this.f18903c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f18902b.subscribe(new MapOptionalMaybeObserver(maybeObserver, this.f18903c));
    }
}
