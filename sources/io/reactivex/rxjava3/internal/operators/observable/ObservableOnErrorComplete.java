package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableOnErrorComplete<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super Throwable> f21996c;

    public static final class OnErrorCompleteObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21997b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super Throwable> f21998c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21999d;

        public OnErrorCompleteObserver(Observer<? super T> observer, Predicate<? super Throwable> predicate) {
            this.f21997b = observer;
            this.f21998c = predicate;
        }

        public void dispose() {
            this.f21999d.dispose();
        }

        public boolean isDisposed() {
            return this.f21999d.isDisposed();
        }

        public void onComplete() {
            this.f21997b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                if (this.f21998c.test(th2)) {
                    this.f21997b.onComplete();
                } else {
                    this.f21997b.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f21997b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f21997b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21999d, disposable)) {
                this.f21999d = disposable;
                this.f21997b.onSubscribe(this);
            }
        }
    }

    public ObservableOnErrorComplete(ObservableSource<T> observableSource, Predicate<? super Throwable> predicate) {
        super(observableSource);
        this.f21996c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new OnErrorCompleteObserver(observer, this.f21996c));
    }
}
