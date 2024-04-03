package io.reactivex.subscribers;

import i.b;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription {
    private volatile boolean cancelled;
    private final Subscriber<? super T> downstream;
    private final AtomicLong missedRequested;

    /* renamed from: qs  reason: collision with root package name */
    private QueueSubscription<T> f23680qs;
    private final AtomicReference<Subscription> upstream;

    public enum EmptySubscriber implements FlowableSubscriber<Object> {
        INSTANCE;

        public void onComplete() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(Object obj) {
        }

        public void onSubscribe(Subscription subscription) {
        }
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber<>();
    }

    public final TestSubscriber<T> assertOf(Consumer<? super TestSubscriber<T>> consumer) {
        try {
            consumer.accept(this);
            return this;
        } catch (Throwable th2) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    public void b() {
    }

    public final void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            SubscriptionHelper.cancel(this.upstream);
        }
    }

    public final void dispose() {
        cancel();
    }

    public final boolean hasSubscription() {
        return this.upstream.get() != null;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        if (!this.f18647g) {
            this.f18647g = true;
            if (this.upstream.get() == null) {
                this.f18644d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f18646f = Thread.currentThread();
            this.f18645e++;
            this.downstream.onComplete();
        } finally {
            this.f18642b.countDown();
        }
    }

    public void onError(Throwable th2) {
        if (!this.f18647g) {
            this.f18647g = true;
            if (this.upstream.get() == null) {
                this.f18644d.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f18646f = Thread.currentThread();
            this.f18644d.add(th2);
            if (th2 == null) {
                this.f18644d.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.downstream.onError(th2);
        } finally {
            this.f18642b.countDown();
        }
    }

    public void onNext(T t11) {
        if (!this.f18647g) {
            this.f18647g = true;
            if (this.upstream.get() == null) {
                this.f18644d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f18646f = Thread.currentThread();
        if (this.f18649i == 2) {
            while (true) {
                try {
                    T poll = this.f23680qs.poll();
                    if (poll != null) {
                        this.f18643c.add(poll);
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    this.f18644d.add(th2);
                    this.f23680qs.cancel();
                    return;
                }
            }
        } else {
            this.f18643c.add(t11);
            if (t11 == null) {
                this.f18644d.add(new NullPointerException("onNext received a null value"));
            }
            this.downstream.onNext(t11);
        }
    }

    public void onSubscribe(Subscription subscription) {
        this.f18646f = Thread.currentThread();
        if (subscription == null) {
            this.f18644d.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!b.a(this.upstream, (Object) null, subscription)) {
            subscription.cancel();
            if (this.upstream.get() != SubscriptionHelper.CANCELLED) {
                this.f18644d.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + subscription));
            }
        } else {
            int i11 = this.f18648h;
            if (i11 != 0 && (subscription instanceof QueueSubscription)) {
                QueueSubscription<T> queueSubscription = (QueueSubscription) subscription;
                this.f23680qs = queueSubscription;
                int requestFusion = queueSubscription.requestFusion(i11);
                this.f18649i = requestFusion;
                if (requestFusion == 1) {
                    this.f18647g = true;
                    this.f18646f = Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.f23680qs.poll();
                            if (poll != null) {
                                this.f18643c.add(poll);
                            } else {
                                this.f18645e++;
                                return;
                            }
                        } catch (Throwable th2) {
                            this.f18644d.add(th2);
                            return;
                        }
                    }
                }
            }
            this.downstream.onSubscribe(subscription);
            long andSet = this.missedRequested.getAndSet(0);
            if (andSet != 0) {
                subscription.request(andSet);
            }
            b();
        }
    }

    public final void request(long j11) {
        SubscriptionHelper.deferredRequest(this.upstream, this.missedRequested, j11);
    }

    public final TestSubscriber<T> requestMore(long j11) {
        request(j11);
        return this;
    }

    public TestSubscriber(long j11) {
        this(EmptySubscriber.INSTANCE, j11);
    }

    public static <T> TestSubscriber<T> create(long j11) {
        return new TestSubscriber<>(j11);
    }

    public final TestSubscriber<T> assertNotSubscribed() {
        if (this.upstream.get() != null) {
            throw a("Subscribed!");
        } else if (this.f18644d.isEmpty()) {
            return this;
        } else {
            throw a("Not subscribed but errors found");
        }
    }

    public final TestSubscriber<T> assertSubscribed() {
        if (this.upstream.get() != null) {
            return this;
        }
        throw a("Not subscribed!");
    }

    public TestSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, Long.MAX_VALUE);
    }

    public static <T> TestSubscriber<T> create(Subscriber<? super T> subscriber) {
        return new TestSubscriber<>(subscriber);
    }

    public TestSubscriber(Subscriber<? super T> subscriber, long j11) {
        if (j11 >= 0) {
            this.downstream = subscriber;
            this.upstream = new AtomicReference<>();
            this.missedRequested = new AtomicLong(j11);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }
}
