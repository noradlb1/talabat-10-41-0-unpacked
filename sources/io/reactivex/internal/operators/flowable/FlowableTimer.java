package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimer extends Flowable<Long> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f16057c;

    /* renamed from: d  reason: collision with root package name */
    public final long f16058d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f16059e;

    public static final class TimerSubscriber extends AtomicReference<Disposable> implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Long> f16060b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f16061c;

        public TimerSubscriber(Subscriber<? super Long> subscriber) {
            this.f16060b = subscriber;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                this.f16061c = true;
            }
        }

        public void run() {
            if (get() == DisposableHelper.DISPOSED) {
                return;
            }
            if (this.f16061c) {
                this.f16060b.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.f16060b.onComplete();
                return;
            }
            lazySet(EmptyDisposable.INSTANCE);
            this.f16060b.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.trySet(this, disposable);
        }
    }

    public FlowableTimer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f16058d = j11;
        this.f16059e = timeUnit;
        this.f16057c = scheduler;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(subscriber);
        subscriber.onSubscribe(timerSubscriber);
        timerSubscriber.setResource(this.f16057c.scheduleDirect(timerSubscriber, this.f16058d, this.f16059e));
    }
}
