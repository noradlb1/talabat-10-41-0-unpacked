package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends U> f22317c;

    public static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1418547743690811973L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22318b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f22319c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final TakeUntilMainObserver<T, U>.OtherObserver f22320d = new OtherObserver();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f22321e = new AtomicThrowable();

        public final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            public OtherObserver() {
            }

            public void onComplete() {
                TakeUntilMainObserver.this.a();
            }

            public void onError(Throwable th2) {
                TakeUntilMainObserver.this.b(th2);
            }

            public void onNext(U u11) {
                DisposableHelper.dispose(this);
                TakeUntilMainObserver.this.a();
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public TakeUntilMainObserver(Observer<? super T> observer) {
            this.f22318b = observer;
        }

        public void a() {
            DisposableHelper.dispose(this.f22319c);
            HalfSerializer.onComplete((Observer<?>) this.f22318b, (AtomicInteger) this, this.f22321e);
        }

        public void b(Throwable th2) {
            DisposableHelper.dispose(this.f22319c);
            HalfSerializer.onError((Observer<?>) this.f22318b, th2, (AtomicInteger) this, this.f22321e);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22319c);
            DisposableHelper.dispose(this.f22320d);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f22319c.get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.f22320d);
            HalfSerializer.onComplete((Observer<?>) this.f22318b, (AtomicInteger) this, this.f22321e);
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f22320d);
            HalfSerializer.onError((Observer<?>) this.f22318b, th2, (AtomicInteger) this, this.f22321e);
        }

        public void onNext(T t11) {
            HalfSerializer.onNext(this.f22318b, t11, (AtomicInteger) this, this.f22321e);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22319c, disposable);
        }
    }

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f22317c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(observer);
        observer.onSubscribe(takeUntilMainObserver);
        this.f22317c.subscribe(takeUntilMainObserver.f22320d);
        this.f21304b.subscribe(takeUntilMainObserver);
    }
}
