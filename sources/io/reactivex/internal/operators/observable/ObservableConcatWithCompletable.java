package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f17037c;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17038b;

        /* renamed from: c  reason: collision with root package name */
        public CompletableSource f17039c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f17040d;

        public ConcatWithObserver(Observer<? super T> observer, CompletableSource completableSource) {
            this.f17038b = observer;
            this.f17039c = completableSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (this.f17040d) {
                this.f17038b.onComplete();
                return;
            }
            this.f17040d = true;
            DisposableHelper.replace(this, (Disposable) null);
            CompletableSource completableSource = this.f17039c;
            this.f17039c = null;
            completableSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f17038b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17038b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.f17040d) {
                this.f17038b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f17037c = completableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new ConcatWithObserver(observer, this.f17037c));
    }
}
