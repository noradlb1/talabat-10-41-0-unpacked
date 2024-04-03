package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenObservable<R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f21097b;

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends R> f21098c;

    public static final class AndThenObservableObserver<R> extends AtomicReference<Disposable> implements Observer<R>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21099b;

        /* renamed from: c  reason: collision with root package name */
        public ObservableSource<? extends R> f21100c;

        public AndThenObservableObserver(Observer<? super R> observer, ObservableSource<? extends R> observableSource) {
            this.f21100c = observableSource;
            this.f21099b = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            ObservableSource<? extends R> observableSource = this.f21100c;
            if (observableSource == null) {
                this.f21099b.onComplete();
                return;
            }
            this.f21100c = null;
            observableSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f21099b.onError(th2);
        }

        public void onNext(R r11) {
            this.f21099b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    public CompletableAndThenObservable(CompletableSource completableSource, ObservableSource<? extends R> observableSource) {
        this.f21097b = completableSource;
        this.f21098c = observableSource;
    }

    public void subscribeActual(Observer<? super R> observer) {
        AndThenObservableObserver andThenObservableObserver = new AndThenObservableObserver(observer, this.f21098c);
        observer.onSubscribe(andThenObservableObserver);
        this.f21097b.subscribe(andThenObservableObserver);
    }
}
