package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithSingle<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<? extends T> f21573c;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21574b;

        /* renamed from: c  reason: collision with root package name */
        public SingleSource<? extends T> f21575c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f21576d;

        public ConcatWithObserver(Observer<? super T> observer, SingleSource<? extends T> singleSource) {
            this.f21574b = observer;
            this.f21575c = singleSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f21576d = true;
            DisposableHelper.replace(this, (Disposable) null);
            SingleSource<? extends T> singleSource = this.f21575c;
            this.f21575c = null;
            singleSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f21574b.onError(th2);
        }

        public void onNext(T t11) {
            this.f21574b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.f21576d) {
                this.f21574b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f21574b.onNext(t11);
            this.f21574b.onComplete();
        }
    }

    public ObservableConcatWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.f21573c = singleSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new ConcatWithObserver(observer, this.f21573c));
    }
}
