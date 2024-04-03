package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

public final class MaybeDematerialize<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, Notification<R>> f20842c;

    public static final class DematerializeObserver<T, R> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f20843b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, Notification<R>> f20844c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20845d;

        public DematerializeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, Notification<R>> function) {
            this.f20843b = maybeObserver;
            this.f20844c = function;
        }

        public void dispose() {
            this.f20845d.dispose();
        }

        public boolean isDisposed() {
            return this.f20845d.isDisposed();
        }

        public void onComplete() {
            this.f20843b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20843b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20845d, disposable)) {
                this.f20845d = disposable;
                this.f20843b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Notification<R> apply = this.f20844c.apply(t11);
                Objects.requireNonNull(apply, "The selector returned a null Notification");
                Notification notification = apply;
                if (notification.isOnNext()) {
                    this.f20843b.onSuccess(notification.getValue());
                } else if (notification.isOnComplete()) {
                    this.f20843b.onComplete();
                } else {
                    this.f20843b.onError(notification.getError());
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20843b.onError(th2);
            }
        }
    }

    public MaybeDematerialize(Maybe<T> maybe, Function<? super T, Notification<R>> function) {
        super(maybe);
        this.f20842c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f20763b.subscribe(new DematerializeObserver(maybeObserver, this.f20842c));
    }
}
