package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f19601d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f19602e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f19603f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f19604g;

    public static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19605b;

        /* renamed from: c  reason: collision with root package name */
        public final long f19606c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f19607d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f19608e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f19609f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f19610g;

        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            public void run() {
                try {
                    DelaySubscriber.this.f19605b.onComplete();
                } finally {
                    DelaySubscriber.this.f19608e.dispose();
                }
            }
        }

        public final class OnError implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final Throwable f19613t;

            public OnError(Throwable th2) {
                this.f19613t = th2;
            }

            public void run() {
                try {
                    DelaySubscriber.this.f19605b.onError(this.f19613t);
                } finally {
                    DelaySubscriber.this.f19608e.dispose();
                }
            }
        }

        public final class OnNext implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final T f19615t;

            public OnNext(T t11) {
                this.f19615t = t11;
            }

            public void run() {
                DelaySubscriber.this.f19605b.onNext(this.f19615t);
            }
        }

        public DelaySubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker, boolean z11) {
            this.f19605b = subscriber;
            this.f19606c = j11;
            this.f19607d = timeUnit;
            this.f19608e = worker;
            this.f19609f = z11;
        }

        public void cancel() {
            this.f19610g.cancel();
            this.f19608e.dispose();
        }

        public void onComplete() {
            this.f19608e.schedule(new OnComplete(), this.f19606c, this.f19607d);
        }

        public void onError(Throwable th2) {
            this.f19608e.schedule(new OnError(th2), this.f19609f ? this.f19606c : 0, this.f19607d);
        }

        public void onNext(T t11) {
            this.f19608e.schedule(new OnNext(t11), this.f19606c, this.f19607d);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19610g, subscription)) {
                this.f19610g = subscription;
                this.f19605b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f19610g.request(j11);
        }
    }

    public FlowableDelay(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(flowable);
        this.f19601d = j11;
        this.f19602e = timeUnit;
        this.f19603f = scheduler;
        this.f19604g = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber;
        if (this.f19604g) {
            serializedSubscriber = subscriber;
        } else {
            serializedSubscriber = new SerializedSubscriber(subscriber);
        }
        this.f19260c.subscribe(new DelaySubscriber(serializedSubscriber, this.f19601d, this.f19602e, this.f19603f.createWorker(), this.f19604g));
    }
}
