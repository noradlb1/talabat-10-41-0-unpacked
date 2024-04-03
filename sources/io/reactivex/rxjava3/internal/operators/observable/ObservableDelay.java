package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f21618c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f21619d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f21620e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f21621f;

    public static final class DelayObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21622b;

        /* renamed from: c  reason: collision with root package name */
        public final long f21623c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f21624d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f21625e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f21626f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f21627g;

        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            public void run() {
                try {
                    DelayObserver.this.f21622b.onComplete();
                } finally {
                    DelayObserver.this.f21625e.dispose();
                }
            }
        }

        public final class OnError implements Runnable {
            private final Throwable throwable;

            public OnError(Throwable th2) {
                this.throwable = th2;
            }

            public void run() {
                try {
                    DelayObserver.this.f21622b.onError(this.throwable);
                } finally {
                    DelayObserver.this.f21625e.dispose();
                }
            }
        }

        public final class OnNext implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final T f21631t;

            public OnNext(T t11) {
                this.f21631t = t11;
            }

            public void run() {
                DelayObserver.this.f21622b.onNext(this.f21631t);
            }
        }

        public DelayObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker, boolean z11) {
            this.f21622b = observer;
            this.f21623c = j11;
            this.f21624d = timeUnit;
            this.f21625e = worker;
            this.f21626f = z11;
        }

        public void dispose() {
            this.f21627g.dispose();
            this.f21625e.dispose();
        }

        public boolean isDisposed() {
            return this.f21625e.isDisposed();
        }

        public void onComplete() {
            this.f21625e.schedule(new OnComplete(), this.f21623c, this.f21624d);
        }

        public void onError(Throwable th2) {
            this.f21625e.schedule(new OnError(th2), this.f21626f ? this.f21623c : 0, this.f21624d);
        }

        public void onNext(T t11) {
            this.f21625e.schedule(new OnNext(t11), this.f21623c, this.f21624d);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21627g, disposable)) {
                this.f21627g = disposable;
                this.f21622b.onSubscribe(this);
            }
        }
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(observableSource);
        this.f21618c = j11;
        this.f21619d = timeUnit;
        this.f21620e = scheduler;
        this.f21621f = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver;
        if (this.f21621f) {
            serializedObserver = observer;
        } else {
            serializedObserver = new SerializedObserver(observer);
        }
        this.f21304b.subscribe(new DelayObserver(serializedObserver, this.f21618c, this.f21619d, this.f21620e.createWorker(), this.f21621f));
    }
}
