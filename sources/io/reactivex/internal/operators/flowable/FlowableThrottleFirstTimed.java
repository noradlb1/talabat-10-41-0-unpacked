package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableThrottleFirstTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15980d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f15981e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f15982f;

    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -9102637559663639004L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15983b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15984c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f15985d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f15986e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f15987f;

        /* renamed from: g  reason: collision with root package name */
        public final SequentialDisposable f15988g = new SequentialDisposable();

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f15989h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15990i;

        public DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f15983b = subscriber;
            this.f15984c = j11;
            this.f15985d = timeUnit;
            this.f15986e = worker;
        }

        public void cancel() {
            this.f15987f.cancel();
            this.f15986e.dispose();
        }

        public void onComplete() {
            if (!this.f15990i) {
                this.f15990i = true;
                this.f15983b.onComplete();
                this.f15986e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15990i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15990i = true;
            this.f15983b.onError(th2);
            this.f15986e.dispose();
        }

        public void onNext(T t11) {
            if (!this.f15990i && !this.f15989h) {
                this.f15989h = true;
                if (get() != 0) {
                    this.f15983b.onNext(t11);
                    BackpressureHelper.produced(this, 1);
                    Disposable disposable = (Disposable) this.f15988g.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f15988g.replace(this.f15986e.schedule(this, this.f15984c, this.f15985d));
                    return;
                }
                this.f15990i = true;
                cancel();
                this.f15983b.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15987f, subscription)) {
                this.f15987f = subscription;
                this.f15983b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }

        public void run() {
            this.f15989h = false;
        }
    }

    public FlowableThrottleFirstTimed(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.f15980d = j11;
        this.f15981e = timeUnit;
        this.f15982f = scheduler;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.f15980d, this.f15981e, this.f15982f.createWorker()));
    }
}
