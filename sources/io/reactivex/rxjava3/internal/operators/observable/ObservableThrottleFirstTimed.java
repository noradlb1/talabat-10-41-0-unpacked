package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleFirstTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f22333c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f22334d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f22335e;

    public static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 786994795061867455L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22336b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22337c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f22338d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f22339e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f22340f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f22341g;

        public DebounceTimedObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f22336b = observer;
            this.f22337c = j11;
            this.f22338d = timeUnit;
            this.f22339e = worker;
        }

        public void dispose() {
            this.f22340f.dispose();
            this.f22339e.dispose();
        }

        public boolean isDisposed() {
            return this.f22339e.isDisposed();
        }

        public void onComplete() {
            this.f22336b.onComplete();
            this.f22339e.dispose();
        }

        public void onError(Throwable th2) {
            this.f22336b.onError(th2);
            this.f22339e.dispose();
        }

        public void onNext(T t11) {
            if (!this.f22341g) {
                this.f22341g = true;
                this.f22336b.onNext(t11);
                Disposable disposable = (Disposable) get();
                if (disposable != null) {
                    disposable.dispose();
                }
                DisposableHelper.replace(this, this.f22339e.schedule(this, this.f22337c, this.f22338d));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22340f, disposable)) {
                this.f22340f = disposable;
                this.f22336b.onSubscribe(this);
            }
        }

        public void run() {
            this.f22341g = false;
        }
    }

    public ObservableThrottleFirstTimed(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f22333c = j11;
        this.f22334d = timeUnit;
        this.f22335e = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.f22333c, this.f22334d, this.f22335e.createWorker()));
    }
}
