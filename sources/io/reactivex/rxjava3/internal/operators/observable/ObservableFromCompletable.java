package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamCompletableSource;

public final class ObservableFromCompletable<T> extends Observable<T> implements HasUpstreamCompletableSource {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f21787b;

    public static final class FromCompletableObserver<T> extends AbstractEmptyQueueFuseable<T> implements CompletableObserver {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21788b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f21789c;

        public FromCompletableObserver(Observer<? super T> observer) {
            this.f21788b = observer;
        }

        public void dispose() {
            this.f21789c.dispose();
            this.f21789c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f21789c.isDisposed();
        }

        public void onComplete() {
            this.f21789c = DisposableHelper.DISPOSED;
            this.f21788b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21789c = DisposableHelper.DISPOSED;
            this.f21788b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21789c, disposable)) {
                this.f21789c = disposable;
                this.f21788b.onSubscribe(this);
            }
        }
    }

    public ObservableFromCompletable(CompletableSource completableSource) {
        this.f21787b = completableSource;
    }

    public CompletableSource source() {
        return this.f21787b;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21787b.subscribe(new FromCompletableObserver(observer));
    }
}
