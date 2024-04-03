package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUnsubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f17873c;

    public static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1015244841293359600L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17874b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f17875c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17876d;

        public final class DisposeTask implements Runnable {
            public DisposeTask() {
            }

            public void run() {
                UnsubscribeObserver.this.f17876d.dispose();
            }
        }

        public UnsubscribeObserver(Observer<? super T> observer, Scheduler scheduler) {
            this.f17874b = observer;
            this.f17875c = scheduler;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f17875c.scheduleDirect(new DisposeTask());
            }
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (!get()) {
                this.f17874b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get()) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f17874b.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!get()) {
                this.f17874b.onNext(t11);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17876d, disposable)) {
                this.f17876d = disposable;
                this.f17874b.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f17873c = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new UnsubscribeObserver(observer, this.f17873c));
    }
}
