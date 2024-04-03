package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeatWhen<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Flowable<Object>, ? extends Publisher<?>> f15706d;

    public static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        public RepeatWhenSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<Object> flowableProcessor, Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        public void onComplete() {
            c(0);
        }

        public void onError(Throwable th2) {
            this.f15713l.cancel();
            this.f15711j.onError(th2);
        }
    }

    public static final class WhenReceiver<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {
        private static final long serialVersionUID = 2827772011130406689L;

        /* renamed from: b  reason: collision with root package name */
        public final Publisher<T> f15707b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f15708c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f15709d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public WhenSourceSubscriber<T, U> f15710e;

        public WhenReceiver(Publisher<T> publisher) {
            this.f15707b = publisher;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f15708c);
        }

        public void onComplete() {
            this.f15710e.cancel();
            this.f15710e.f15711j.onComplete();
        }

        public void onError(Throwable th2) {
            this.f15710e.cancel();
            this.f15710e.f15711j.onError(th2);
        }

        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (this.f15708c.get() != SubscriptionHelper.CANCELLED) {
                    this.f15707b.subscribe(this.f15710e);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f15708c, this.f15709d, subscription);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f15708c, this.f15709d, j11);
        }
    }

    public static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5604623027276966720L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super T> f15711j;

        /* renamed from: k  reason: collision with root package name */
        public final FlowableProcessor<U> f15712k;

        /* renamed from: l  reason: collision with root package name */
        public final Subscription f15713l;
        private long produced;

        public WhenSourceSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<U> flowableProcessor, Subscription subscription) {
            super(false);
            this.f15711j = subscriber;
            this.f15712k = flowableProcessor;
            this.f15713l = subscription;
        }

        public final void c(U u11) {
            setSubscription(EmptySubscription.INSTANCE);
            long j11 = this.produced;
            if (j11 != 0) {
                this.produced = 0;
                produced(j11);
            }
            this.f15713l.request(1);
            this.f15712k.onNext(u11);
        }

        public final void cancel() {
            super.cancel();
            this.f15713l.cancel();
        }

        public final void onNext(T t11) {
            this.produced++;
            this.f15711j.onNext(t11);
        }

        public final void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableRepeatWhen(Flowable<T> flowable, Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        super(flowable);
        this.f15706d = function;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor serialized = UnicastProcessor.create(8).toSerialized();
        try {
            Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f15706d.apply(serialized), "handler returned a null Publisher");
            WhenReceiver whenReceiver = new WhenReceiver(this.f14763c);
            RepeatWhenSubscriber repeatWhenSubscriber = new RepeatWhenSubscriber(serializedSubscriber, serialized, whenReceiver);
            whenReceiver.f15710e = repeatWhenSubscriber;
            subscriber.onSubscribe(repeatWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
