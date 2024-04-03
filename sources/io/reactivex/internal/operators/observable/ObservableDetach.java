package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {

    public static final class DetachObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public Observer<? super T> f17116b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17117c;

        public DetachObserver(Observer<? super T> observer) {
            this.f17116b = observer;
        }

        public void dispose() {
            Disposable disposable = this.f17117c;
            this.f17117c = EmptyComponent.INSTANCE;
            this.f17116b = EmptyComponent.asObserver();
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f17117c.isDisposed();
        }

        public void onComplete() {
            Observer<? super T> observer = this.f17116b;
            this.f17117c = EmptyComponent.INSTANCE;
            this.f17116b = EmptyComponent.asObserver();
            observer.onComplete();
        }

        public void onError(Throwable th2) {
            Observer<? super T> observer = this.f17116b;
            this.f17117c = EmptyComponent.INSTANCE;
            this.f17116b = EmptyComponent.asObserver();
            observer.onError(th2);
        }

        public void onNext(T t11) {
            this.f17116b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17117c, disposable)) {
                this.f17117c = disposable;
                this.f17116b.onSubscribe(this);
            }
        }
    }

    public ObservableDetach(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new DetachObserver(observer));
    }
}
