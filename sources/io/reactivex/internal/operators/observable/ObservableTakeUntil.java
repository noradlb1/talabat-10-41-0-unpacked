package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends U> f17774c;

    public static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1418547743690811973L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17775b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f17776c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final TakeUntilMainObserver<T, U>.OtherObserver f17777d = new OtherObserver();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f17778e = new AtomicThrowable();

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
            this.f17775b = observer;
        }

        public void a() {
            DisposableHelper.dispose(this.f17776c);
            HalfSerializer.onComplete((Observer<?>) this.f17775b, (AtomicInteger) this, this.f17778e);
        }

        public void b(Throwable th2) {
            DisposableHelper.dispose(this.f17776c);
            HalfSerializer.onError((Observer<?>) this.f17775b, th2, (AtomicInteger) this, this.f17778e);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f17776c);
            DisposableHelper.dispose(this.f17777d);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f17776c.get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.f17777d);
            HalfSerializer.onComplete((Observer<?>) this.f17775b, (AtomicInteger) this, this.f17778e);
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f17777d);
            HalfSerializer.onError((Observer<?>) this.f17775b, th2, (AtomicInteger) this, this.f17778e);
        }

        public void onNext(T t11) {
            HalfSerializer.onNext(this.f17775b, t11, (AtomicInteger) this, this.f17778e);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f17776c, disposable);
        }
    }

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f17774c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(observer);
        observer.onSubscribe(takeUntilMainObserver);
        this.f17774c.subscribe(takeUntilMainObserver.f17777d);
        this.f16799b.subscribe(takeUntilMainObserver);
    }
}
