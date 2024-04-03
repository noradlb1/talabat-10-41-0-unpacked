package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.operators.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    private static final long serialVersionUID = -3830916580126663321L;

    /* renamed from: b  reason: collision with root package name */
    public final T f23172b;

    /* renamed from: c  reason: collision with root package name */
    public final Subscriber<? super T> f23173c;

    public ScalarSubscription(Subscriber<? super T> subscriber, T t11) {
        this.f23173c = subscriber;
        this.f23172b = t11;
    }

    public void cancel() {
        lazySet(2);
    }

    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    public boolean isEmpty() {
        return get() != 0;
    }

    public boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Nullable
    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.f23172b;
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11) && compareAndSet(0, 1)) {
            Subscriber<? super T> subscriber = this.f23173c;
            subscriber.onNext(this.f23172b);
            if (get() != 2) {
                subscriber.onComplete();
            }
        }
    }

    public int requestFusion(int i11) {
        return i11 & 1;
    }

    public boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
