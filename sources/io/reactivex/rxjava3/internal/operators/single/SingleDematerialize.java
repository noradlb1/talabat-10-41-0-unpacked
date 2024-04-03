package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

public final class SingleDematerialize<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Single<T> f22800b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, Notification<R>> f22801c;

    public static final class DematerializeObserver<T, R> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f22802b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, Notification<R>> f22803c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22804d;

        public DematerializeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, Notification<R>> function) {
            this.f22802b = maybeObserver;
            this.f22803c = function;
        }

        public void dispose() {
            this.f22804d.dispose();
        }

        public boolean isDisposed() {
            return this.f22804d.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f22802b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22804d, disposable)) {
                this.f22804d = disposable;
                this.f22802b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Notification<R> apply = this.f22803c.apply(t11);
                Objects.requireNonNull(apply, "The selector returned a null Notification");
                Notification notification = apply;
                if (notification.isOnNext()) {
                    this.f22802b.onSuccess(notification.getValue());
                } else if (notification.isOnComplete()) {
                    this.f22802b.onComplete();
                } else {
                    this.f22802b.onError(notification.getError());
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22802b.onError(th2);
            }
        }
    }

    public SingleDematerialize(Single<T> single, Function<? super T, Notification<R>> function) {
        this.f22800b = single;
        this.f22801c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f22800b.subscribe(new DematerializeObserver(maybeObserver, this.f22801c));
    }
}
