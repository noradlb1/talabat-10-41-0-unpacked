package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import org.reactivestreams.Subscriber;

public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {

    /* renamed from: d  reason: collision with root package name */
    public final Subscriber<? super V> f18588d;

    /* renamed from: e  reason: collision with root package name */
    public final SimplePlainQueue<U> f18589e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f18590f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f18591g;

    /* renamed from: h  reason: collision with root package name */
    public Throwable f18592h;

    public QueueDrainSubscriber(Subscriber<? super V> subscriber, SimplePlainQueue<U> simplePlainQueue) {
        this.f18588d = subscriber;
        this.f18589e = simplePlainQueue;
    }

    public final void a(U u11, boolean z11, Disposable disposable) {
        Subscriber<? super V> subscriber = this.f18588d;
        SimplePlainQueue<U> simplePlainQueue = this.f18589e;
        if (fastEnter()) {
            long j11 = this.f18593c.get();
            if (j11 != 0) {
                if (accept(subscriber, u11) && j11 != Long.MAX_VALUE) {
                    produced(1);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            simplePlainQueue.offer(u11);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z11, disposable, this);
    }

    public boolean accept(Subscriber<? super V> subscriber, U u11) {
        return false;
    }

    public final void b(U u11, boolean z11, Disposable disposable) {
        Subscriber<? super V> subscriber = this.f18588d;
        SimplePlainQueue<U> simplePlainQueue = this.f18589e;
        if (fastEnter()) {
            long j11 = this.f18593c.get();
            if (j11 == 0) {
                this.f18590f = true;
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else if (simplePlainQueue.isEmpty()) {
                if (accept(subscriber, u11) && j11 != Long.MAX_VALUE) {
                    produced(1);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u11);
            }
        } else {
            simplePlainQueue.offer(u11);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z11, disposable, this);
    }

    public final boolean cancelled() {
        return this.f18590f;
    }

    public final boolean done() {
        return this.f18591g;
    }

    public final boolean enter() {
        return this.f18594b.getAndIncrement() == 0;
    }

    public final Throwable error() {
        return this.f18592h;
    }

    public final boolean fastEnter() {
        return this.f18594b.get() == 0 && this.f18594b.compareAndSet(0, 1);
    }

    public final int leave(int i11) {
        return this.f18594b.addAndGet(i11);
    }

    public final long produced(long j11) {
        return this.f18593c.addAndGet(-j11);
    }

    public final long requested() {
        return this.f18593c.get();
    }

    public final void requested(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            BackpressureHelper.add(this.f18593c, j11);
        }
    }
}
