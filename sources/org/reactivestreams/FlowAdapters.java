package org.reactivestreams;

import j$.util.concurrent.Flow$Processor;
import j$.util.concurrent.Flow$Publisher;
import j$.util.concurrent.Flow$Subscriber;
import j$.util.concurrent.Flow$Subscription;
import java.util.Objects;

public final class FlowAdapters {

    public static final class FlowPublisherFromReactive<T> implements Flow$Publisher<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Publisher<? extends T> f63303a;

        public FlowPublisherFromReactive(Publisher<? extends T> publisher) {
            this.f63303a = publisher;
        }

        public void subscribe(Flow$Subscriber<? super T> flow$Subscriber) {
            this.f63303a.subscribe(flow$Subscriber == null ? null : new ReactiveToFlowSubscriber(flow$Subscriber));
        }
    }

    public static final class FlowToReactiveProcessor<T, U> implements Flow$Processor<T, U> {

        /* renamed from: a  reason: collision with root package name */
        public final Processor<? super T, ? extends U> f63304a;

        public FlowToReactiveProcessor(Processor<? super T, ? extends U> processor) {
            this.f63304a = processor;
        }

        public void onComplete() {
            this.f63304a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f63304a.onError(th2);
        }

        public void onNext(T t11) {
            this.f63304a.onNext(t11);
        }

        public void onSubscribe(Flow$Subscription flow$Subscription) {
            this.f63304a.onSubscribe(flow$Subscription == null ? null : new ReactiveToFlowSubscription(flow$Subscription));
        }

        public void subscribe(Flow$Subscriber<? super U> flow$Subscriber) {
            this.f63304a.subscribe(flow$Subscriber == null ? null : new ReactiveToFlowSubscriber(flow$Subscriber));
        }
    }

    public static final class FlowToReactiveSubscriber<T> implements Flow$Subscriber<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Subscriber<? super T> f63305a;

        public FlowToReactiveSubscriber(Subscriber<? super T> subscriber) {
            this.f63305a = subscriber;
        }

        public void onComplete() {
            this.f63305a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f63305a.onError(th2);
        }

        public void onNext(T t11) {
            this.f63305a.onNext(t11);
        }

        public void onSubscribe(Flow$Subscription flow$Subscription) {
            this.f63305a.onSubscribe(flow$Subscription == null ? null : new ReactiveToFlowSubscription(flow$Subscription));
        }
    }

    public static final class FlowToReactiveSubscription implements Flow$Subscription {

        /* renamed from: a  reason: collision with root package name */
        public final Subscription f63306a;

        public FlowToReactiveSubscription(Subscription subscription) {
            this.f63306a = subscription;
        }

        public void cancel() {
            this.f63306a.cancel();
        }

        public void request(long j11) {
            this.f63306a.request(j11);
        }
    }

    public static final class ReactivePublisherFromFlow<T> implements Publisher<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Flow$Publisher<? extends T> f63307b;

        public ReactivePublisherFromFlow(Flow$Publisher<? extends T> flow$Publisher) {
            this.f63307b = flow$Publisher;
        }

        public void subscribe(Subscriber<? super T> subscriber) {
            this.f63307b.subscribe(subscriber == null ? null : new FlowToReactiveSubscriber(subscriber));
        }
    }

    public static final class ReactiveToFlowProcessor<T, U> implements Processor<T, U> {

        /* renamed from: b  reason: collision with root package name */
        public final Flow$Processor<? super T, ? extends U> f63308b;

        public ReactiveToFlowProcessor(Flow$Processor<? super T, ? extends U> flow$Processor) {
            this.f63308b = flow$Processor;
        }

        public void onComplete() {
            this.f63308b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f63308b.onError(th2);
        }

        public void onNext(T t11) {
            this.f63308b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f63308b.onSubscribe(subscription == null ? null : new FlowToReactiveSubscription(subscription));
        }

        public void subscribe(Subscriber<? super U> subscriber) {
            this.f63308b.subscribe(subscriber == null ? null : new FlowToReactiveSubscriber(subscriber));
        }
    }

    public static final class ReactiveToFlowSubscriber<T> implements Subscriber<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Flow$Subscriber<? super T> f63309b;

        public ReactiveToFlowSubscriber(Flow$Subscriber<? super T> flow$Subscriber) {
            this.f63309b = flow$Subscriber;
        }

        public void onComplete() {
            this.f63309b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f63309b.onError(th2);
        }

        public void onNext(T t11) {
            this.f63309b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f63309b.onSubscribe(subscription == null ? null : new FlowToReactiveSubscription(subscription));
        }
    }

    public static final class ReactiveToFlowSubscription implements Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Flow$Subscription f63310b;

        public ReactiveToFlowSubscription(Flow$Subscription flow$Subscription) {
            this.f63310b = flow$Subscription;
        }

        public void cancel() {
            this.f63310b.cancel();
        }

        public void request(long j11) {
            this.f63310b.request(j11);
        }
    }

    private FlowAdapters() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Flow$Processor<T, U> toFlowProcessor(Processor<? super T, ? extends U> processor) {
        Objects.requireNonNull(processor, "reactiveStreamsProcessor");
        if (processor instanceof ReactiveToFlowProcessor) {
            return ((ReactiveToFlowProcessor) processor).f63308b;
        }
        if (processor instanceof Flow$Processor) {
            return (Flow$Processor) processor;
        }
        return new FlowToReactiveProcessor(processor);
    }

    public static <T> Flow$Publisher<T> toFlowPublisher(Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "reactiveStreamsPublisher");
        if (publisher instanceof ReactivePublisherFromFlow) {
            return ((ReactivePublisherFromFlow) publisher).f63307b;
        }
        if (publisher instanceof Flow$Publisher) {
            return (Flow$Publisher) publisher;
        }
        return new FlowPublisherFromReactive(publisher);
    }

    public static <T> Flow$Subscriber<T> toFlowSubscriber(Subscriber<T> subscriber) {
        Objects.requireNonNull(subscriber, "reactiveStreamsSubscriber");
        if (subscriber instanceof ReactiveToFlowSubscriber) {
            return ((ReactiveToFlowSubscriber) subscriber).f63309b;
        }
        if (subscriber instanceof Flow$Subscriber) {
            return (Flow$Subscriber) subscriber;
        }
        return new FlowToReactiveSubscriber(subscriber);
    }

    public static <T, U> Processor<T, U> toProcessor(Flow$Processor<? super T, ? extends U> flow$Processor) {
        Objects.requireNonNull(flow$Processor, "flowProcessor");
        if (flow$Processor instanceof FlowToReactiveProcessor) {
            return ((FlowToReactiveProcessor) flow$Processor).f63304a;
        }
        if (flow$Processor instanceof Processor) {
            return (Processor) flow$Processor;
        }
        return new ReactiveToFlowProcessor(flow$Processor);
    }

    public static <T> Publisher<T> toPublisher(Flow$Publisher<? extends T> flow$Publisher) {
        Objects.requireNonNull(flow$Publisher, "flowPublisher");
        if (flow$Publisher instanceof FlowPublisherFromReactive) {
            return ((FlowPublisherFromReactive) flow$Publisher).f63303a;
        }
        if (flow$Publisher instanceof Publisher) {
            return (Publisher) flow$Publisher;
        }
        return new ReactivePublisherFromFlow(flow$Publisher);
    }

    public static <T> Subscriber<T> toSubscriber(Flow$Subscriber<T> flow$Subscriber) {
        Objects.requireNonNull(flow$Subscriber, "flowSubscriber");
        if (flow$Subscriber instanceof FlowToReactiveSubscriber) {
            return ((FlowToReactiveSubscriber) flow$Subscriber).f63305a;
        }
        if (flow$Subscriber instanceof Subscriber) {
            return (Subscriber) flow$Subscriber;
        }
        return new ReactiveToFlowSubscriber(flow$Subscriber);
    }
}
