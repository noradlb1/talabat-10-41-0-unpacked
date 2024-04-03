package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f17717c;

    public static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8094547886072529208L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17718b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f17719c = new AtomicReference<>();

        public SubscribeOnObserver(Observer<? super T> observer) {
            this.f17718b = observer;
        }

        public void a(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f17719c);
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f17718b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17718b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17718b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f17719c, disposable);
        }
    }

    public final class SubscribeTask implements Runnable {
        private final SubscribeOnObserver<T> parent;

        public SubscribeTask(SubscribeOnObserver<T> subscribeOnObserver) {
            this.parent = subscribeOnObserver;
        }

        public void run() {
            ObservableSubscribeOn.this.f16799b.subscribe(this.parent);
        }
    }

    public ObservableSubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f17717c = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(observer);
        observer.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.a(this.f17717c.scheduleDirect(new SubscribeTask(subscribeOnObserver)));
    }
}
