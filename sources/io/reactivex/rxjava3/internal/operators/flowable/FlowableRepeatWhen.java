package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeatWhen<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Flowable<Object>, ? extends Publisher<?>> f20213d;

    public static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        public RepeatWhenSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<Object> flowableProcessor, Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        public void onComplete() {
            c(0);
        }

        public void onError(Throwable th2) {
            this.f20220l.cancel();
            this.f20218j.onError(th2);
        }
    }

    public static final class WhenReceiver<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {
        private static final long serialVersionUID = 2827772011130406689L;

        /* renamed from: b  reason: collision with root package name */
        public final Publisher<T> f20214b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f20215c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f20216d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public WhenSourceSubscriber<T, U> f20217e;

        public WhenReceiver(Publisher<T> publisher) {
            this.f20214b = publisher;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f20215c);
        }

        public void onComplete() {
            this.f20217e.cancel();
            this.f20217e.f20218j.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20217e.cancel();
            this.f20217e.f20218j.onError(th2);
        }

        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (this.f20215c.get() != SubscriptionHelper.CANCELLED) {
                    this.f20214b.subscribe(this.f20217e);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f20215c, this.f20216d, subscription);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f20215c, this.f20216d, j11);
        }
    }

    public static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5604623027276966720L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super T> f20218j;

        /* renamed from: k  reason: collision with root package name */
        public final FlowableProcessor<U> f20219k;

        /* renamed from: l  reason: collision with root package name */
        public final Subscription f20220l;
        private long produced;

        public WhenSourceSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<U> flowableProcessor, Subscription subscription) {
            super(false);
            this.f20218j = subscriber;
            this.f20219k = flowableProcessor;
            this.f20220l = subscription;
        }

        public final void c(U u11) {
            setSubscription(EmptySubscription.INSTANCE);
            long j11 = this.produced;
            if (j11 != 0) {
                this.produced = 0;
                produced(j11);
            }
            this.f20220l.request(1);
            this.f20219k.onNext(u11);
        }

        public final void cancel() {
            super.cancel();
            this.f20220l.cancel();
        }

        public final void onNext(T t11) {
            this.produced++;
            this.f20218j.onNext(t11);
        }

        public final void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableRepeatWhen(Flowable<T> flowable, Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        super(flowable);
        this.f20213d = function;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor serialized = UnicastProcessor.create(8).toSerialized();
        try {
            Object apply = this.f20213d.apply(serialized);
            Objects.requireNonNull(apply, "handler returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            WhenReceiver whenReceiver = new WhenReceiver(this.f19260c);
            RepeatWhenSubscriber repeatWhenSubscriber = new RepeatWhenSubscriber(serializedSubscriber, serialized, whenReceiver);
            whenReceiver.f20217e = repeatWhenSubscriber;
            subscriber.onSubscribe(repeatWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
