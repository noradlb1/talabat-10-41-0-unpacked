package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryWhen<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Flowable<Throwable>, ? extends Publisher<?>> f15762d;

    public static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        public RetryWhenSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<Throwable> flowableProcessor, Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        public void onComplete() {
            this.f15713l.cancel();
            this.f15711j.onComplete();
        }

        public void onError(Throwable th2) {
            c(th2);
        }
    }

    public FlowableRetryWhen(Flowable<T> flowable, Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        super(flowable);
        this.f15762d = function;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor serialized = UnicastProcessor.create(8).toSerialized();
        try {
            Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f15762d.apply(serialized), "handler returned a null Publisher");
            FlowableRepeatWhen.WhenReceiver whenReceiver = new FlowableRepeatWhen.WhenReceiver(this.f14763c);
            RetryWhenSubscriber retryWhenSubscriber = new RetryWhenSubscriber(serializedSubscriber, serialized, whenReceiver);
            whenReceiver.f15710e = retryWhenSubscriber;
            subscriber.onSubscribe(retryWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
