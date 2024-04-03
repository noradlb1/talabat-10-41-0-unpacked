package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;

public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {

    public static final class DetachObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public Observer<? super T> f21644b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f21645c;

        public DetachObserver(Observer<? super T> observer) {
            this.f21644b = observer;
        }

        public void dispose() {
            Disposable disposable = this.f21645c;
            this.f21645c = EmptyComponent.INSTANCE;
            this.f21644b = EmptyComponent.asObserver();
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f21645c.isDisposed();
        }

        public void onComplete() {
            Observer<? super T> observer = this.f21644b;
            this.f21645c = EmptyComponent.INSTANCE;
            this.f21644b = EmptyComponent.asObserver();
            observer.onComplete();
        }

        public void onError(Throwable th2) {
            Observer<? super T> observer = this.f21644b;
            this.f21645c = EmptyComponent.INSTANCE;
            this.f21644b = EmptyComponent.asObserver();
            observer.onError(th2);
        }

        public void onNext(T t11) {
            this.f21644b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21645c, disposable)) {
                this.f21645c = disposable;
                this.f21644b.onSubscribe(this);
            }
        }
    }

    public ObservableDetach(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new DetachObserver(observer));
    }
}
