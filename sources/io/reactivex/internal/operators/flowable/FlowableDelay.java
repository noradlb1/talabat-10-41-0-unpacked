package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15095d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f15096e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f15097f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f15098g;

    public static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15099b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15100c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f15101d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f15102e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f15103f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f15104g;

        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            public void run() {
                try {
                    DelaySubscriber.this.f15099b.onComplete();
                } finally {
                    DelaySubscriber.this.f15102e.dispose();
                }
            }
        }

        public final class OnError implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final Throwable f15107t;

            public OnError(Throwable th2) {
                this.f15107t = th2;
            }

            public void run() {
                try {
                    DelaySubscriber.this.f15099b.onError(this.f15107t);
                } finally {
                    DelaySubscriber.this.f15102e.dispose();
                }
            }
        }

        public final class OnNext implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final T f15109t;

            public OnNext(T t11) {
                this.f15109t = t11;
            }

            public void run() {
                DelaySubscriber.this.f15099b.onNext(this.f15109t);
            }
        }

        public DelaySubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker, boolean z11) {
            this.f15099b = subscriber;
            this.f15100c = j11;
            this.f15101d = timeUnit;
            this.f15102e = worker;
            this.f15103f = z11;
        }

        public void cancel() {
            this.f15104g.cancel();
            this.f15102e.dispose();
        }

        public void onComplete() {
            this.f15102e.schedule(new OnComplete(), this.f15100c, this.f15101d);
        }

        public void onError(Throwable th2) {
            this.f15102e.schedule(new OnError(th2), this.f15103f ? this.f15100c : 0, this.f15101d);
        }

        public void onNext(T t11) {
            this.f15102e.schedule(new OnNext(t11), this.f15100c, this.f15101d);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15104g, subscription)) {
                this.f15104g = subscription;
                this.f15099b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15104g.request(j11);
        }
    }

    public FlowableDelay(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(flowable);
        this.f15095d = j11;
        this.f15096e = timeUnit;
        this.f15097f = scheduler;
        this.f15098g = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber;
        if (this.f15098g) {
            serializedSubscriber = subscriber;
        } else {
            serializedSubscriber = new SerializedSubscriber(subscriber);
        }
        this.f14763c.subscribe(new DelaySubscriber(serializedSubscriber, this.f15095d, this.f15096e, this.f15097f.createWorker(), this.f15098g));
    }
}
