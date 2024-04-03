package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUnsubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f22415c;

    public static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1015244841293359600L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22416b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f22417c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22418d;

        public final class DisposeTask implements Runnable {
            public DisposeTask() {
            }

            public void run() {
                UnsubscribeObserver.this.f22418d.dispose();
            }
        }

        public UnsubscribeObserver(Observer<? super T> observer, Scheduler scheduler) {
            this.f22416b = observer;
            this.f22417c = scheduler;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f22417c.scheduleDirect(new DisposeTask());
            }
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (!get()) {
                this.f22416b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get()) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f22416b.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!get()) {
                this.f22416b.onNext(t11);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22418d, disposable)) {
                this.f22418d = disposable;
                this.f22416b.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f22415c = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new UnsubscribeObserver(observer, this.f22415c));
    }
}
