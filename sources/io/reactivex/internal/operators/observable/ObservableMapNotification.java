package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f17395c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Throwable, ? extends ObservableSource<? extends R>> f17396d;

    /* renamed from: e  reason: collision with root package name */
    public final Callable<? extends ObservableSource<? extends R>> f17397e;

    public static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super ObservableSource<? extends R>> f17398b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f17399c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super Throwable, ? extends ObservableSource<? extends R>> f17400d;

        /* renamed from: e  reason: collision with root package name */
        public final Callable<? extends ObservableSource<? extends R>> f17401e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f17402f;

        public MapNotificationObserver(Observer<? super ObservableSource<? extends R>> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
            this.f17398b = observer;
            this.f17399c = function;
            this.f17400d = function2;
            this.f17401e = callable;
        }

        public void dispose() {
            this.f17402f.dispose();
        }

        public boolean isDisposed() {
            return this.f17402f.isDisposed();
        }

        public void onComplete() {
            try {
                this.f17398b.onNext((ObservableSource) ObjectHelper.requireNonNull(this.f17401e.call(), "The onComplete ObservableSource returned is null"));
                this.f17398b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f17398b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            try {
                this.f17398b.onNext((ObservableSource) ObjectHelper.requireNonNull(this.f17400d.apply(th2), "The onError ObservableSource returned is null"));
                this.f17398b.onComplete();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f17398b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            try {
                this.f17398b.onNext((ObservableSource) ObjectHelper.requireNonNull(this.f17399c.apply(t11), "The onNext ObservableSource returned is null"));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f17398b.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17402f, disposable)) {
                this.f17402f = disposable;
                this.f17398b.onSubscribe(this);
            }
        }
    }

    public ObservableMapNotification(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        super(observableSource);
        this.f17395c = function;
        this.f17396d = function2;
        this.f17397e = callable;
    }

    public void subscribeActual(Observer<? super ObservableSource<? extends R>> observer) {
        this.f16799b.subscribe(new MapNotificationObserver(observer, this.f17395c, this.f17396d, this.f17397e));
    }
}
