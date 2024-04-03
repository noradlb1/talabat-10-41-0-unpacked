package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17090c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f17091d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f17092e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f17093f;

    public static final class DelayObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17094b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17095c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f17096d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f17097e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f17098f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f17099g;

        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            public void run() {
                try {
                    DelayObserver.this.f17094b.onComplete();
                } finally {
                    DelayObserver.this.f17097e.dispose();
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
                    DelayObserver.this.f17094b.onError(this.throwable);
                } finally {
                    DelayObserver.this.f17097e.dispose();
                }
            }
        }

        public final class OnNext implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final T f17103t;

            public OnNext(T t11) {
                this.f17103t = t11;
            }

            public void run() {
                DelayObserver.this.f17094b.onNext(this.f17103t);
            }
        }

        public DelayObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker, boolean z11) {
            this.f17094b = observer;
            this.f17095c = j11;
            this.f17096d = timeUnit;
            this.f17097e = worker;
            this.f17098f = z11;
        }

        public void dispose() {
            this.f17099g.dispose();
            this.f17097e.dispose();
        }

        public boolean isDisposed() {
            return this.f17097e.isDisposed();
        }

        public void onComplete() {
            this.f17097e.schedule(new OnComplete(), this.f17095c, this.f17096d);
        }

        public void onError(Throwable th2) {
            this.f17097e.schedule(new OnError(th2), this.f17098f ? this.f17095c : 0, this.f17096d);
        }

        public void onNext(T t11) {
            this.f17097e.schedule(new OnNext(t11), this.f17095c, this.f17096d);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17099g, disposable)) {
                this.f17099g = disposable;
                this.f17094b.onSubscribe(this);
            }
        }
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(observableSource);
        this.f17090c = j11;
        this.f17091d = timeUnit;
        this.f17092e = scheduler;
        this.f17093f = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver;
        if (this.f17093f) {
            serializedObserver = observer;
        } else {
            serializedObserver = new SerializedObserver(observer);
        }
        this.f16799b.subscribe(new DelayObserver(serializedObserver, this.f17090c, this.f17091d, this.f17092e.createWorker(), this.f17093f));
    }
}
