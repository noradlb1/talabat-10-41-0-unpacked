package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithObservable<T, U> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22785b;

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<U> f22786c;

    public static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements Observer<U>, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22787b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleSource<T> f22788c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22789d;

        public OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f22787b = singleObserver;
            this.f22788c = singleSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (!this.f22789d) {
                this.f22789d = true;
                this.f22788c.subscribe(new ResumeSingleObserver(this, this.f22787b));
            }
        }

        public void onError(Throwable th2) {
            if (this.f22789d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22789d = true;
            this.f22787b.onError(th2);
        }

        public void onNext(U u11) {
            ((Disposable) get()).dispose();
            onComplete();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f22787b.onSubscribe(this);
            }
        }
    }

    public SingleDelayWithObservable(SingleSource<T> singleSource, ObservableSource<U> observableSource) {
        this.f22785b = singleSource;
        this.f22786c = observableSource;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22786c.subscribe(new OtherSubscriber(singleObserver, this.f22785b));
    }
}
