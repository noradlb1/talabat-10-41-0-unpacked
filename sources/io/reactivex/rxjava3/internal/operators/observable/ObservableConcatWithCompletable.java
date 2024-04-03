package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f21565c;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21566b;

        /* renamed from: c  reason: collision with root package name */
        public CompletableSource f21567c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f21568d;

        public ConcatWithObserver(Observer<? super T> observer, CompletableSource completableSource) {
            this.f21566b = observer;
            this.f21567c = completableSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (this.f21568d) {
                this.f21566b.onComplete();
                return;
            }
            this.f21568d = true;
            DisposableHelper.replace(this, (Disposable) null);
            CompletableSource completableSource = this.f21567c;
            this.f21567c = null;
            completableSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f21566b.onError(th2);
        }

        public void onNext(T t11) {
            this.f21566b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.f21568d) {
                this.f21566b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f21565c = completableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new ConcatWithObserver(observer, this.f21565c));
    }
}
