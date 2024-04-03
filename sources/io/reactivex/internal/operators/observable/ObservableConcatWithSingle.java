package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithSingle<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<? extends T> f17045c;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17046b;

        /* renamed from: c  reason: collision with root package name */
        public SingleSource<? extends T> f17047c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f17048d;

        public ConcatWithObserver(Observer<? super T> observer, SingleSource<? extends T> singleSource) {
            this.f17046b = observer;
            this.f17047c = singleSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f17048d = true;
            DisposableHelper.replace(this, (Disposable) null);
            SingleSource<? extends T> singleSource = this.f17047c;
            this.f17047c = null;
            singleSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f17046b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17046b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.f17048d) {
                this.f17046b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f17046b.onNext(t11);
            this.f17046b.onComplete();
        }
    }

    public ObservableConcatWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.f17045c = singleSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new ConcatWithObserver(observer, this.f17045c));
    }
}
