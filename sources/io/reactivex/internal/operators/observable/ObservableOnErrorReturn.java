package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f17457c;

    public static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17458b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends T> f17459c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17460d;

        public OnErrorReturnObserver(Observer<? super T> observer, Function<? super Throwable, ? extends T> function) {
            this.f17458b = observer;
            this.f17459c = function;
        }

        public void dispose() {
            this.f17460d.dispose();
        }

        public boolean isDisposed() {
            return this.f17460d.isDisposed();
        }

        public void onComplete() {
            this.f17458b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f17459c.apply(th2);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th2);
                    this.f17458b.onError(nullPointerException);
                    return;
                }
                this.f17458b.onNext(apply);
                this.f17458b.onComplete();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f17458b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f17458b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17460d, disposable)) {
                this.f17460d = disposable;
                this.f17458b.onSubscribe(this);
            }
        }
    }

    public ObservableOnErrorReturn(ObservableSource<T> observableSource, Function<? super Throwable, ? extends T> function) {
        super(observableSource);
        this.f17457c = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new OnErrorReturnObserver(observer, this.f17457c));
    }
}
