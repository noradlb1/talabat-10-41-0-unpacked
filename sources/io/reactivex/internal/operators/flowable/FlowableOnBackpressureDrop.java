package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super T> f15563d;

    public static final class BackpressureDropSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6246093802440953054L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15564b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f15565c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15566d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f15567e;

        public BackpressureDropSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            this.f15564b = subscriber;
            this.f15565c = consumer;
        }

        public void cancel() {
            this.f15566d.cancel();
        }

        public void onComplete() {
            if (!this.f15567e) {
                this.f15567e = true;
                this.f15564b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15567e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15567e = true;
            this.f15564b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15567e) {
                if (get() != 0) {
                    this.f15564b.onNext(t11);
                    BackpressureHelper.produced(this, 1);
                    return;
                }
                try {
                    this.f15565c.accept(t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15566d, subscription)) {
                this.f15566d = subscription;
                this.f15564b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }
    }

    public FlowableOnBackpressureDrop(Flowable<T> flowable) {
        super(flowable);
        this.f15563d = this;
    }

    public void accept(T t11) {
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new BackpressureDropSubscriber(subscriber, this.f15563d));
    }

    public FlowableOnBackpressureDrop(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.f15563d = consumer;
    }
}
