package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.QueueDrain;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import org.reactivestreams.Subscriber;

public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {

    /* renamed from: d  reason: collision with root package name */
    public final Subscriber<? super V> f23149d;

    /* renamed from: e  reason: collision with root package name */
    public final SimplePlainQueue<U> f23150e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f23151f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f23152g;

    /* renamed from: h  reason: collision with root package name */
    public Throwable f23153h;

    public QueueDrainSubscriber(Subscriber<? super V> subscriber, SimplePlainQueue<U> simplePlainQueue) {
        this.f23149d = subscriber;
        this.f23150e = simplePlainQueue;
    }

    public final void a(U u11, boolean z11, Disposable disposable) {
        Subscriber<? super V> subscriber = this.f23149d;
        SimplePlainQueue<U> simplePlainQueue = this.f23150e;
        if (fastEnter()) {
            long j11 = this.f23154c.get();
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
        Subscriber<? super V> subscriber = this.f23149d;
        SimplePlainQueue<U> simplePlainQueue = this.f23150e;
        if (fastEnter()) {
            long j11 = this.f23154c.get();
            if (j11 == 0) {
                this.f23151f = true;
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
        return this.f23151f;
    }

    public final boolean done() {
        return this.f23152g;
    }

    public final boolean enter() {
        return this.f23155b.getAndIncrement() == 0;
    }

    public final Throwable error() {
        return this.f23153h;
    }

    public final boolean fastEnter() {
        return this.f23155b.get() == 0 && this.f23155b.compareAndSet(0, 1);
    }

    public final int leave(int i11) {
        return this.f23155b.addAndGet(i11);
    }

    public final long produced(long j11) {
        return this.f23154c.addAndGet(-j11);
    }

    public final long requested() {
        return this.f23154c.get();
    }

    public final void requested(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            BackpressureHelper.add(this.f23154c, j11);
        }
    }
}
