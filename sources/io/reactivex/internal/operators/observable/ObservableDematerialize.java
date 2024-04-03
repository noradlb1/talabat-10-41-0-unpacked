package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDematerialize<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends Notification<R>> f17111c;

    public static final class DematerializeObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f17112b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Notification<R>> f17113c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f17114d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f17115e;

        public DematerializeObserver(Observer<? super R> observer, Function<? super T, ? extends Notification<R>> function) {
            this.f17112b = observer;
            this.f17113c = function;
        }

        public void dispose() {
            this.f17115e.dispose();
        }

        public boolean isDisposed() {
            return this.f17115e.isDisposed();
        }

        public void onComplete() {
            if (!this.f17114d) {
                this.f17114d = true;
                this.f17112b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17114d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17114d = true;
            this.f17112b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17114d) {
                try {
                    Notification notification = (Notification) ObjectHelper.requireNonNull(this.f17113c.apply(t11), "The selector returned a null Notification");
                    if (notification.isOnError()) {
                        this.f17115e.dispose();
                        onError(notification.getError());
                    } else if (notification.isOnComplete()) {
                        this.f17115e.dispose();
                        onComplete();
                    } else {
                        this.f17112b.onNext(notification.getValue());
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17115e.dispose();
                    onError(th2);
                }
            } else if (t11 instanceof Notification) {
                Notification notification2 = (Notification) t11;
                if (notification2.isOnError()) {
                    RxJavaPlugins.onError(notification2.getError());
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17115e, disposable)) {
                this.f17115e = disposable;
                this.f17112b.onSubscribe(this);
            }
        }
    }

    public ObservableDematerialize(ObservableSource<T> observableSource, Function<? super T, ? extends Notification<R>> function) {
        super(observableSource);
        this.f17111c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f16799b.subscribe(new DematerializeObserver(observer, this.f17111c));
    }
}
