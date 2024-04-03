package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends T> f17721c;

    public static final class SwitchIfEmptyObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17722b;

        /* renamed from: c  reason: collision with root package name */
        public final ObservableSource<? extends T> f17723c;

        /* renamed from: d  reason: collision with root package name */
        public final SequentialDisposable f17724d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        public boolean f17725e = true;

        public SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.f17722b = observer;
            this.f17723c = observableSource;
        }

        public void onComplete() {
            if (this.f17725e) {
                this.f17725e = false;
                this.f17723c.subscribe(this);
                return;
            }
            this.f17722b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17722b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f17725e) {
                this.f17725e = false;
            }
            this.f17722b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f17724d.update(disposable);
        }
    }

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.f17721c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.f17721c);
        observer.onSubscribe(switchIfEmptyObserver.f17724d);
        this.f16799b.subscribe(switchIfEmptyObserver);
    }
}
