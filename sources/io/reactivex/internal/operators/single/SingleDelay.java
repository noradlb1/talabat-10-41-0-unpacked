package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

public final class SingleDelay<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f18236b;

    /* renamed from: c  reason: collision with root package name */
    public final long f18237c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f18238d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f18239e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f18240f;

    public final class Delay implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18241b;

        /* renamed from: sd  reason: collision with root package name */
        private final SequentialDisposable f18243sd;

        public final class OnError implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            private final Throwable f18245e;

            public OnError(Throwable th2) {
                this.f18245e = th2;
            }

            public void run() {
                Delay.this.f18241b.onError(this.f18245e);
            }
        }

        public final class OnSuccess implements Runnable {
            private final T value;

            public OnSuccess(T t11) {
                this.value = t11;
            }

            public void run() {
                Delay.this.f18241b.onSuccess(this.value);
            }
        }

        public Delay(SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
            this.f18243sd = sequentialDisposable;
            this.f18241b = singleObserver;
        }

        public void onError(Throwable th2) {
            SequentialDisposable sequentialDisposable = this.f18243sd;
            Scheduler scheduler = SingleDelay.this.f18239e;
            OnError onError = new OnError(th2);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.replace(scheduler.scheduleDirect(onError, singleDelay.f18240f ? singleDelay.f18237c : 0, singleDelay.f18238d));
        }

        public void onSubscribe(Disposable disposable) {
            this.f18243sd.replace(disposable);
        }

        public void onSuccess(T t11) {
            SequentialDisposable sequentialDisposable = this.f18243sd;
            Scheduler scheduler = SingleDelay.this.f18239e;
            OnSuccess onSuccess = new OnSuccess(t11);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.replace(scheduler.scheduleDirect(onSuccess, singleDelay.f18237c, singleDelay.f18238d));
        }
    }

    public SingleDelay(SingleSource<? extends T> singleSource, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        this.f18236b = singleSource;
        this.f18237c = j11;
        this.f18238d = timeUnit;
        this.f18239e = scheduler;
        this.f18240f = z11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.f18236b.subscribe(new Delay(sequentialDisposable, singleObserver));
    }
}
