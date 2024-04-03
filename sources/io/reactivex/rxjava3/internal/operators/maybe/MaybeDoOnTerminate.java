package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;

public final class MaybeDoOnTerminate<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f20866b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f20867c;

    public final class DoOnTerminate implements MaybeObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20868b;

        public DoOnTerminate(MaybeObserver<? super T> maybeObserver) {
            this.f20868b = maybeObserver;
        }

        public void onComplete() {
            try {
                MaybeDoOnTerminate.this.f20867c.run();
                this.f20868b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20868b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            try {
                MaybeDoOnTerminate.this.f20867c.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f20868b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f20868b.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            try {
                MaybeDoOnTerminate.this.f20867c.run();
                this.f20868b.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20868b.onError(th2);
            }
        }
    }

    public MaybeDoOnTerminate(MaybeSource<T> maybeSource, Action action) {
        this.f20866b = maybeSource;
        this.f20867c = action;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20866b.subscribe(new DoOnTerminate(maybeObserver));
    }
}
