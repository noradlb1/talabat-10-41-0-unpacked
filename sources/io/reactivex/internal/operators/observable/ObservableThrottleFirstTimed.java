package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleFirstTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17790c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f17791d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f17792e;

    public static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 786994795061867455L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17793b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17794c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f17795d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f17796e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f17797f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f17798g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f17799h;

        public DebounceTimedObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f17793b = observer;
            this.f17794c = j11;
            this.f17795d = timeUnit;
            this.f17796e = worker;
        }

        public void dispose() {
            this.f17797f.dispose();
            this.f17796e.dispose();
        }

        public boolean isDisposed() {
            return this.f17796e.isDisposed();
        }

        public void onComplete() {
            if (!this.f17799h) {
                this.f17799h = true;
                this.f17793b.onComplete();
                this.f17796e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17799h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17799h = true;
            this.f17793b.onError(th2);
            this.f17796e.dispose();
        }

        public void onNext(T t11) {
            if (!this.f17798g && !this.f17799h) {
                this.f17798g = true;
                this.f17793b.onNext(t11);
                Disposable disposable = (Disposable) get();
                if (disposable != null) {
                    disposable.dispose();
                }
                DisposableHelper.replace(this, this.f17796e.schedule(this, this.f17794c, this.f17795d));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17797f, disposable)) {
                this.f17797f = disposable;
                this.f17793b.onSubscribe(this);
            }
        }

        public void run() {
            this.f17798g = false;
        }
    }

    public ObservableThrottleFirstTimed(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f17790c = j11;
        this.f17791d = timeUnit;
        this.f17792e = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.f17790c, this.f17791d, this.f17792e.createWorker()));
    }
}
