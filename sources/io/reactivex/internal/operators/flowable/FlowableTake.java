package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15928d;

    public static final class TakeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5636543848937116287L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15929b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15930c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f15931d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f15932e;

        /* renamed from: f  reason: collision with root package name */
        public long f15933f;

        public TakeSubscriber(Subscriber<? super T> subscriber, long j11) {
            this.f15929b = subscriber;
            this.f15930c = j11;
            this.f15933f = j11;
        }

        public void cancel() {
            this.f15932e.cancel();
        }

        public void onComplete() {
            if (!this.f15931d) {
                this.f15931d = true;
                this.f15929b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f15931d) {
                this.f15931d = true;
                this.f15932e.cancel();
                this.f15929b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            boolean z11;
            if (!this.f15931d) {
                long j11 = this.f15933f;
                long j12 = j11 - 1;
                this.f15933f = j12;
                if (j11 > 0) {
                    if (j12 == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    this.f15929b.onNext(t11);
                    if (z11) {
                        this.f15932e.cancel();
                        onComplete();
                    }
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15932e, subscription)) {
                this.f15932e = subscription;
                if (this.f15930c == 0) {
                    subscription.cancel();
                    this.f15931d = true;
                    EmptySubscription.complete(this.f15929b);
                    return;
                }
                this.f15929b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                if (get() || !compareAndSet(false, true) || j11 < this.f15930c) {
                    this.f15932e.request(j11);
                } else {
                    this.f15932e.request(Long.MAX_VALUE);
                }
            }
        }
    }

    public FlowableTake(Flowable<T> flowable, long j11) {
        super(flowable);
        this.f15928d = j11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new TakeSubscriber(subscriber, this.f15928d));
    }
}
