package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;

public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends T> f22264c;

    public static final class SwitchIfEmptyObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22265b;

        /* renamed from: c  reason: collision with root package name */
        public final ObservableSource<? extends T> f22266c;

        /* renamed from: d  reason: collision with root package name */
        public final SequentialDisposable f22267d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        public boolean f22268e = true;

        public SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.f22265b = observer;
            this.f22266c = observableSource;
        }

        public void onComplete() {
            if (this.f22268e) {
                this.f22268e = false;
                this.f22266c.subscribe(this);
                return;
            }
            this.f22265b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22265b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f22268e) {
                this.f22268e = false;
            }
            this.f22265b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f22267d.update(disposable);
        }
    }

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.f22264c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.f22264c);
        observer.onSubscribe(switchIfEmptyObserver.f22267d);
        this.f21304b.subscribe(switchIfEmptyObserver);
    }
}
