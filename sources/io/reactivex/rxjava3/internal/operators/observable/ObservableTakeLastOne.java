package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableTakeLastOne<T> extends AbstractObservableWithUpstream<T, T> {

    public static final class TakeLastOneObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22298b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f22299c;

        /* renamed from: d  reason: collision with root package name */
        public T f22300d;

        public TakeLastOneObserver(Observer<? super T> observer) {
            this.f22298b = observer;
        }

        public void a() {
            T t11 = this.f22300d;
            if (t11 != null) {
                this.f22300d = null;
                this.f22298b.onNext(t11);
            }
            this.f22298b.onComplete();
        }

        public void dispose() {
            this.f22300d = null;
            this.f22299c.dispose();
        }

        public boolean isDisposed() {
            return this.f22299c.isDisposed();
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th2) {
            this.f22300d = null;
            this.f22298b.onError(th2);
        }

        public void onNext(T t11) {
            this.f22300d = t11;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22299c, disposable)) {
                this.f22299c = disposable;
                this.f22298b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastOne(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new TakeLastOneObserver(observer));
    }
}
