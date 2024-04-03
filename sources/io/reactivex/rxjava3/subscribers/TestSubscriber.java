package io.reactivex.rxjava3.subscribers;

import i.b;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription {
    private volatile boolean cancelled;
    private final Subscriber<? super T> downstream;
    private final AtomicLong missedRequested;
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

    @NonNull
    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber<>();
    }

    /* renamed from: c */
    public final TestSubscriber<T> a() {
        if (this.upstream.get() != null) {
            return this;
        }
        throw b("Not subscribed!");
    }

    public final void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            SubscriptionHelper.cancel(this.upstream);
        }
    }

    public void d() {
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
        if (!this.f23208g) {
            this.f23208g = true;
            if (this.upstream.get() == null) {
                this.f23205d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f23207f = Thread.currentThread();
            this.f23206e++;
            this.downstream.onComplete();
        } finally {
            this.f23203b.countDown();
        }
    }

    public void onError(@NonNull Throwable th2) {
        if (!this.f23208g) {
            this.f23208g = true;
            if (this.upstream.get() == null) {
                this.f23205d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f23207f = Thread.currentThread();
            if (th2 == null) {
                this.f23205d.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f23205d.add(th2);
            }
            this.downstream.onError(th2);
        } finally {
            this.f23203b.countDown();
        }
    }

    public void onNext(@NonNull T t11) {
        if (!this.f23208g) {
            this.f23208g = true;
            if (this.upstream.get() == null) {
                this.f23205d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f23207f = Thread.currentThread();
        this.f23204c.add(t11);
        if (t11 == null) {
            this.f23205d.add(new NullPointerException("onNext received a null value"));
        }
        this.downstream.onNext(t11);
    }

    public void onSubscribe(@NonNull Subscription subscription) {
        this.f23207f = Thread.currentThread();
        if (subscription == null) {
            this.f23205d.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!b.a(this.upstream, (Object) null, subscription)) {
            subscription.cancel();
            if (this.upstream.get() != SubscriptionHelper.CANCELLED) {
                List<Throwable> list = this.f23205d;
                list.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + subscription));
            }
        } else {
            this.downstream.onSubscribe(subscription);
            long andSet = this.missedRequested.getAndSet(0);
            if (andSet != 0) {
                subscription.request(andSet);
            }
            d();
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

    @NonNull
    public static <T> TestSubscriber<T> create(long j11) {
        return new TestSubscriber<>(j11);
    }

    public TestSubscriber(@NonNull Subscriber<? super T> subscriber) {
        this(subscriber, Long.MAX_VALUE);
    }

    public static <T> TestSubscriber<T> create(@NonNull Subscriber<? super T> subscriber) {
        return new TestSubscriber<>(subscriber);
    }

    public TestSubscriber(@NonNull Subscriber<? super T> subscriber, long j11) {
        if (j11 >= 0) {
            this.downstream = subscriber;
            this.upstream = new AtomicReference<>();
            this.missedRequested = new AtomicLong(j11);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }
}
