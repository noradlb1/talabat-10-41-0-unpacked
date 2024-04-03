package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimer extends Flowable<Long> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f20565c;

    /* renamed from: d  reason: collision with root package name */
    public final long f20566d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f20567e;

    public static final class TimerSubscriber extends AtomicReference<Disposable> implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Long> f20568b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f20569c;

        public TimerSubscriber(Subscriber<? super Long> subscriber) {
            this.f20568b = subscriber;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                this.f20569c = true;
            }
        }

        public void run() {
            if (get() == DisposableHelper.DISPOSED) {
                return;
            }
            if (this.f20569c) {
                this.f20568b.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.f20568b.onComplete();
                return;
            }
            lazySet(EmptyDisposable.INSTANCE);
            this.f20568b.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.trySet(this, disposable);
        }
    }

    public FlowableTimer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f20566d = j11;
        this.f20567e = timeUnit;
        this.f20565c = scheduler;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(subscriber);
        subscriber.onSubscribe(timerSubscriber);
        timerSubscriber.setResource(this.f20565c.scheduleDirect(timerSubscriber, this.f20566d, this.f20567e));
    }
}
