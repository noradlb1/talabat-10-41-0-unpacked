package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenObservable<R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f16584b;

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends R> f16585c;

    public static final class AndThenObservableObserver<R> extends AtomicReference<Disposable> implements Observer<R>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f16586b;

        /* renamed from: c  reason: collision with root package name */
        public ObservableSource<? extends R> f16587c;

        public AndThenObservableObserver(Observer<? super R> observer, ObservableSource<? extends R> observableSource) {
            this.f16587c = observableSource;
            this.f16586b = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            ObservableSource<? extends R> observableSource = this.f16587c;
            if (observableSource == null) {
                this.f16586b.onComplete();
                return;
            }
            this.f16587c = null;
            observableSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f16586b.onError(th2);
        }

        public void onNext(R r11) {
            this.f16586b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    public CompletableAndThenObservable(CompletableSource completableSource, ObservableSource<? extends R> observableSource) {
        this.f16584b = completableSource;
        this.f16585c = observableSource;
    }

    public void subscribeActual(Observer<? super R> observer) {
        AndThenObservableObserver andThenObservableObserver = new AndThenObservableObserver(observer, this.f16585c);
        observer.onSubscribe(andThenObservableObserver);
        this.f16584b.subscribe(andThenObservableObserver);
    }
}
