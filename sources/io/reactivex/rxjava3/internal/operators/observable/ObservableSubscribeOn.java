package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f22260c;

    public static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8094547886072529208L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22261b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f22262c = new AtomicReference<>();

        public SubscribeOnObserver(Observer<? super T> observer) {
            this.f22261b = observer;
        }

        public void a(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22262c);
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f22261b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22261b.onError(th2);
        }

        public void onNext(T t11) {
            this.f22261b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22262c, disposable);
        }
    }

    public final class SubscribeTask implements Runnable {
        private final SubscribeOnObserver<T> parent;

        public SubscribeTask(SubscribeOnObserver<T> subscribeOnObserver) {
            this.parent = subscribeOnObserver;
        }

        public void run() {
            ObservableSubscribeOn.this.f21304b.subscribe(this.parent);
        }
    }

    public ObservableSubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f22260c = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(observer);
        observer.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.a(this.f22260c.scheduleDirect(new SubscribeTask(subscribeOnObserver)));
    }
}
