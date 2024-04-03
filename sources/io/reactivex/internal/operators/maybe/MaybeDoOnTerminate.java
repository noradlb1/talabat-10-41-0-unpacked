package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;

public final class MaybeDoOnTerminate<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16355b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f16356c;

    public final class DoOnTerminate implements MaybeObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16357b;

        public DoOnTerminate(MaybeObserver<? super T> maybeObserver) {
            this.f16357b = maybeObserver;
        }

        public void onComplete() {
            try {
                MaybeDoOnTerminate.this.f16356c.run();
                this.f16357b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16357b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            try {
                MaybeDoOnTerminate.this.f16356c.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f16357b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f16357b.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            try {
                MaybeDoOnTerminate.this.f16356c.run();
                this.f16357b.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16357b.onError(th2);
            }
        }
    }

    public MaybeDoOnTerminate(MaybeSource<T> maybeSource, Action action) {
        this.f16355b = maybeSource;
        this.f16356c = action;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16355b.subscribe(new DoOnTerminate(maybeObserver));
    }
}
