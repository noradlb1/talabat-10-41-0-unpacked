package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

public final class SingleOnErrorReturn<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f18384b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f18385c;

    /* renamed from: d  reason: collision with root package name */
    public final T f18386d;

    public final class OnErrorReturn implements SingleObserver<T> {
        private final SingleObserver<? super T> observer;

        public OnErrorReturn(SingleObserver<? super T> singleObserver) {
            this.observer = singleObserver;
        }

        public void onError(Throwable th2) {
            T t11;
            SingleOnErrorReturn singleOnErrorReturn = SingleOnErrorReturn.this;
            Function<? super Throwable, ? extends T> function = singleOnErrorReturn.f18385c;
            if (function != null) {
                try {
                    t11 = function.apply(th2);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.observer.onError(new CompositeException(th2, th3));
                    return;
                }
            } else {
                t11 = singleOnErrorReturn.f18386d;
            }
            if (t11 == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th2);
                this.observer.onError(nullPointerException);
                return;
            }
            this.observer.onSuccess(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            this.observer.onSuccess(t11);
        }
    }

    public SingleOnErrorReturn(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t11) {
        this.f18384b = singleSource;
        this.f18385c = function;
        this.f18386d = t11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18384b.subscribe(new OnErrorReturn(singleObserver));
    }
}
