package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableTakeLastOne<T> extends AbstractObservableWithUpstream<T, T> {

    public static final class TakeLastOneObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17755b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17756c;

        /* renamed from: d  reason: collision with root package name */
        public T f17757d;

        public TakeLastOneObserver(Observer<? super T> observer) {
            this.f17755b = observer;
        }

        public void a() {
            T t11 = this.f17757d;
            if (t11 != null) {
                this.f17757d = null;
                this.f17755b.onNext(t11);
            }
            this.f17755b.onComplete();
        }

        public void dispose() {
            this.f17757d = null;
            this.f17756c.dispose();
        }

        public boolean isDisposed() {
            return this.f17756c.isDisposed();
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th2) {
            this.f17757d = null;
            this.f17755b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17757d = t11;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17756c, disposable)) {
                this.f17756c = disposable;
                this.f17755b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastOne(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new TakeLastOneObserver(observer));
    }
}
