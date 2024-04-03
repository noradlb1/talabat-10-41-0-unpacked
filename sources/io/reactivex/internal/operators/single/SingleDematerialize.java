package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

@Experimental
public final class SingleDematerialize<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Single<T> f18266b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, Notification<R>> f18267c;

    public static final class DematerializeObserver<T, R> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f18268b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, Notification<R>> f18269c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f18270d;

        public DematerializeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, Notification<R>> function) {
            this.f18268b = maybeObserver;
            this.f18269c = function;
        }

        public void dispose() {
            this.f18270d.dispose();
        }

        public boolean isDisposed() {
            return this.f18270d.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f18268b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18270d, disposable)) {
                this.f18270d = disposable;
                this.f18268b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Notification notification = (Notification) ObjectHelper.requireNonNull(this.f18269c.apply(t11), "The selector returned a null Notification");
                if (notification.isOnNext()) {
                    this.f18268b.onSuccess(notification.getValue());
                } else if (notification.isOnComplete()) {
                    this.f18268b.onComplete();
                } else {
                    this.f18268b.onError(notification.getError());
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18268b.onError(th2);
            }
        }
    }

    public SingleDematerialize(Single<T> single, Function<? super T, Notification<R>> function) {
        this.f18266b = single;
        this.f18267c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f18266b.subscribe(new DematerializeObserver(maybeObserver, this.f18267c));
    }
}
