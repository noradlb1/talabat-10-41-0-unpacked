package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super T> f20086d;

    public static final class BackpressureDropSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6246093802440953054L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20087b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f20088c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20089d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f20090e;

        public BackpressureDropSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            this.f20087b = subscriber;
            this.f20088c = consumer;
        }

        public void cancel() {
            this.f20089d.cancel();
        }

        public void onComplete() {
            if (!this.f20090e) {
                this.f20090e = true;
                this.f20087b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20090e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20090e = true;
            this.f20087b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f20090e) {
                if (get() != 0) {
                    this.f20087b.onNext(t11);
                    BackpressureHelper.produced(this, 1);
                    return;
                }
                try {
                    this.f20088c.accept(t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20089d, subscription)) {
                this.f20089d = subscription;
                this.f20087b.onSubscribe(this);
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
        this.f20086d = this;
    }

    public void accept(T t11) {
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new BackpressureDropSubscriber(subscriber, this.f20086d));
    }

    public FlowableOnBackpressureDrop(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.f20086d = consumer;
    }
}
