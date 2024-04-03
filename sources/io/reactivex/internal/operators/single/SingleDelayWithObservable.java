package io.reactivex.internal.operators.single;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithObservable<T, U> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18251b;

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<U> f18252c;

    public static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements Observer<U>, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18253b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleSource<T> f18254c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f18255d;

        public OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f18253b = singleObserver;
            this.f18254c = singleSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (!this.f18255d) {
                this.f18255d = true;
                this.f18254c.subscribe(new ResumeSingleObserver(this, this.f18253b));
            }
        }

        public void onError(Throwable th2) {
            if (this.f18255d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18255d = true;
            this.f18253b.onError(th2);
        }

        public void onNext(U u11) {
            ((Disposable) get()).dispose();
            onComplete();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.set(this, disposable)) {
                this.f18253b.onSubscribe(this);
            }
        }
    }

    public SingleDelayWithObservable(SingleSource<T> singleSource, ObservableSource<U> observableSource) {
        this.f18251b = singleSource;
        this.f18252c = observableSource;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18252c.subscribe(new OtherSubscriber(singleObserver, this.f18251b));
    }
}
