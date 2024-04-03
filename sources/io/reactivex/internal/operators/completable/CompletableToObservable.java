package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

public final class CompletableToObservable<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14748b;

    public static final class ObserverCompletableObserver extends BasicQueueDisposable<Void> implements CompletableObserver {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<?> f14749b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f14750c;

        public ObserverCompletableObserver(Observer<?> observer) {
            this.f14749b = observer;
        }

        public void clear() {
        }

        public void dispose() {
            this.f14750c.dispose();
        }

        public boolean isDisposed() {
            return this.f14750c.isDisposed();
        }

        public boolean isEmpty() {
            return true;
        }

        public void onComplete() {
            this.f14749b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f14749b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f14750c, disposable)) {
                this.f14750c = disposable;
                this.f14749b.onSubscribe(this);
            }
        }

        public Void poll() throws Exception {
            return null;
        }

        public int requestFusion(int i11) {
            return i11 & 2;
        }
    }

    public CompletableToObservable(CompletableSource completableSource) {
        this.f14748b = completableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f14748b.subscribe(new ObserverCompletableObserver(observer));
    }
}
