package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;

public final class SingleOnErrorReturn<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f22944b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f22945c;

    /* renamed from: d  reason: collision with root package name */
    public final T f22946d;

    public final class OnErrorReturn implements SingleObserver<T> {
        private final SingleObserver<? super T> observer;

        public OnErrorReturn(SingleObserver<? super T> singleObserver) {
            this.observer = singleObserver;
        }

        public void onError(Throwable th2) {
            T t11;
            SingleOnErrorReturn singleOnErrorReturn = SingleOnErrorReturn.this;
            Function<? super Throwable, ? extends T> function = singleOnErrorReturn.f22945c;
            if (function != null) {
                try {
                    t11 = function.apply(th2);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.observer.onError(new CompositeException(th2, th3));
                    return;
                }
            } else {
                t11 = singleOnErrorReturn.f22946d;
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
        this.f22944b = singleSource;
        this.f22945c = function;
        this.f22946d = t11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22944b.subscribe(new OnErrorReturn(singleObserver));
    }
}
