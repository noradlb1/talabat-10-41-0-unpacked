package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

public final class SingleDelay<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f22770b;

    /* renamed from: c  reason: collision with root package name */
    public final long f22771c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f22772d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f22773e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f22774f;

    public final class Delay implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22775b;

        /* renamed from: sd  reason: collision with root package name */
        private final SequentialDisposable f22777sd;

        public final class OnError implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            private final Throwable f22779e;

            public OnError(Throwable th2) {
                this.f22779e = th2;
            }

            public void run() {
                Delay.this.f22775b.onError(this.f22779e);
            }
        }

        public final class OnSuccess implements Runnable {
            private final T value;

            public OnSuccess(T t11) {
                this.value = t11;
            }

            public void run() {
                Delay.this.f22775b.onSuccess(this.value);
            }
        }

        public Delay(SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
            this.f22777sd = sequentialDisposable;
            this.f22775b = singleObserver;
        }

        public void onError(Throwable th2) {
            SequentialDisposable sequentialDisposable = this.f22777sd;
            Scheduler scheduler = SingleDelay.this.f22773e;
            OnError onError = new OnError(th2);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.replace(scheduler.scheduleDirect(onError, singleDelay.f22774f ? singleDelay.f22771c : 0, singleDelay.f22772d));
        }

        public void onSubscribe(Disposable disposable) {
            this.f22777sd.replace(disposable);
        }

        public void onSuccess(T t11) {
            SequentialDisposable sequentialDisposable = this.f22777sd;
            Scheduler scheduler = SingleDelay.this.f22773e;
            OnSuccess onSuccess = new OnSuccess(t11);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.replace(scheduler.scheduleDirect(onSuccess, singleDelay.f22771c, singleDelay.f22772d));
        }
    }

    public SingleDelay(SingleSource<? extends T> singleSource, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        this.f22770b = singleSource;
        this.f22771c = j11;
        this.f22772d = timeUnit;
        this.f22773e = scheduler;
        this.f22774f = z11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.f22770b.subscribe(new Delay(sequentialDisposable, singleObserver));
    }
}
