package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f15516d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15517e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15518f;

    public static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;

        /* renamed from: b  reason: collision with root package name */
        public final Scheduler.Worker f15519b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f15520c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15521d;

        /* renamed from: e  reason: collision with root package name */
        public final int f15522e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f15523f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public Subscription f15524g;

        /* renamed from: h  reason: collision with root package name */
        public SimpleQueue<T> f15525h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f15526i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f15527j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f15528k;

        /* renamed from: l  reason: collision with root package name */
        public int f15529l;

        /* renamed from: m  reason: collision with root package name */
        public long f15530m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f15531n;

        public BaseObserveOnSubscriber(Scheduler.Worker worker, boolean z11, int i11) {
            this.f15519b = worker;
            this.f15520c = z11;
            this.f15521d = i11;
            this.f15522e = i11 - (i11 >> 2);
        }

        public final boolean a(boolean z11, boolean z12, Subscriber<?> subscriber) {
            if (this.f15526i) {
                clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!this.f15520c) {
                    Throwable th2 = this.f15528k;
                    if (th2 != null) {
                        this.f15526i = true;
                        clear();
                        subscriber.onError(th2);
                        this.f15519b.dispose();
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        this.f15526i = true;
                        subscriber.onComplete();
                        this.f15519b.dispose();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    this.f15526i = true;
                    Throwable th3 = this.f15528k;
                    if (th3 != null) {
                        subscriber.onError(th3);
                    } else {
                        subscriber.onComplete();
                    }
                    this.f15519b.dispose();
                    return true;
                }
            }
        }

        public abstract void b();

        public abstract void c();

        public final void cancel() {
            if (!this.f15526i) {
                this.f15526i = true;
                this.f15524g.cancel();
                this.f15519b.dispose();
                if (!this.f15531n && getAndIncrement() == 0) {
                    this.f15525h.clear();
                }
            }
        }

        public final void clear() {
            this.f15525h.clear();
        }

        public abstract void d();

        public final void e() {
            if (getAndIncrement() == 0) {
                this.f15519b.schedule(this);
            }
        }

        public final boolean isEmpty() {
            return this.f15525h.isEmpty();
        }

        public final void onComplete() {
            if (!this.f15527j) {
                this.f15527j = true;
                e();
            }
        }

        public final void onError(Throwable th2) {
            if (this.f15527j) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15528k = th2;
            this.f15527j = true;
            e();
        }

        public final void onNext(T t11) {
            if (!this.f15527j) {
                if (this.f15529l == 2) {
                    e();
                    return;
                }
                if (!this.f15525h.offer(t11)) {
                    this.f15524g.cancel();
                    this.f15528k = new MissingBackpressureException("Queue is full?!");
                    this.f15527j = true;
                }
                e();
            }
        }

        public final void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15523f, j11);
                e();
            }
        }

        public final int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f15531n = true;
            return 2;
        }

        public final void run() {
            if (this.f15531n) {
                c();
            } else if (this.f15529l == 1) {
                d();
            } else {
                b();
            }
        }
    }

    public static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;

        /* renamed from: o  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f15532o;

        /* renamed from: p  reason: collision with root package name */
        public long f15533p;

        public ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler.Worker worker, boolean z11, int i11) {
            super(worker, z11, i11);
            this.f15532o = conditionalSubscriber;
        }

        public void b() {
            int i11;
            boolean z11;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f15532o;
            SimpleQueue<T> simpleQueue = this.f15525h;
            long j11 = this.f15530m;
            long j12 = this.f15533p;
            int i12 = 1;
            while (true) {
                long j13 = this.f15523f.get();
                while (true) {
                    i11 = (j11 > j13 ? 1 : (j11 == j13 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z12 = this.f15527j;
                    try {
                        T poll = simpleQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!a(z12, z11, conditionalSubscriber)) {
                            if (z11) {
                                break;
                            }
                            if (conditionalSubscriber.tryOnNext(poll)) {
                                j11++;
                            }
                            j12++;
                            if (j12 == ((long) this.f15522e)) {
                                this.f15524g.request(j12);
                                j12 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f15526i = true;
                        this.f15524g.cancel();
                        simpleQueue.clear();
                        conditionalSubscriber.onError(th2);
                        this.f15519b.dispose();
                        return;
                    }
                }
                if (i11 != 0 || !a(this.f15527j, simpleQueue.isEmpty(), conditionalSubscriber)) {
                    int i13 = get();
                    if (i12 == i13) {
                        this.f15530m = j11;
                        this.f15533p = j12;
                        i12 = addAndGet(-i12);
                        if (i12 == 0) {
                            return;
                        }
                    } else {
                        i12 = i13;
                    }
                } else {
                    return;
                }
            }
        }

        public void c() {
            int i11 = 1;
            while (!this.f15526i) {
                boolean z11 = this.f15527j;
                this.f15532o.onNext(null);
                if (z11) {
                    this.f15526i = true;
                    Throwable th2 = this.f15528k;
                    if (th2 != null) {
                        this.f15532o.onError(th2);
                    } else {
                        this.f15532o.onComplete();
                    }
                    this.f15519b.dispose();
                    return;
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }

        public void d() {
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f15532o;
            SimpleQueue<T> simpleQueue = this.f15525h;
            long j11 = this.f15530m;
            int i11 = 1;
            while (true) {
                long j12 = this.f15523f.get();
                while (j11 != j12) {
                    try {
                        T poll = simpleQueue.poll();
                        if (!this.f15526i) {
                            if (poll == null) {
                                this.f15526i = true;
                                conditionalSubscriber.onComplete();
                                this.f15519b.dispose();
                                return;
                            } else if (conditionalSubscriber.tryOnNext(poll)) {
                                j11++;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f15526i = true;
                        this.f15524g.cancel();
                        conditionalSubscriber.onError(th2);
                        this.f15519b.dispose();
                        return;
                    }
                }
                if (!this.f15526i) {
                    if (simpleQueue.isEmpty()) {
                        this.f15526i = true;
                        conditionalSubscriber.onComplete();
                        this.f15519b.dispose();
                        return;
                    }
                    int i12 = get();
                    if (i11 == i12) {
                        this.f15530m = j11;
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        i11 = i12;
                    }
                } else {
                    return;
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15524g, subscription)) {
                this.f15524g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f15529l = 1;
                        this.f15525h = queueSubscription;
                        this.f15527j = true;
                        this.f15532o.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.f15529l = 2;
                        this.f15525h = queueSubscription;
                        this.f15532o.onSubscribe(this);
                        subscription.request((long) this.f15521d);
                        return;
                    }
                }
                this.f15525h = new SpscArrayQueue(this.f15521d);
                this.f15532o.onSubscribe(this);
                subscription.request((long) this.f15521d);
            }
        }

        @Nullable
        public T poll() throws Exception {
            T poll = this.f15525h.poll();
            if (!(poll == null || this.f15529l == 1)) {
                long j11 = this.f15533p + 1;
                if (j11 == ((long) this.f15522e)) {
                    this.f15533p = 0;
                    this.f15524g.request(j11);
                } else {
                    this.f15533p = j11;
                }
            }
            return poll;
        }
    }

    public static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;

        /* renamed from: o  reason: collision with root package name */
        public final Subscriber<? super T> f15534o;

        public ObserveOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, boolean z11, int i11) {
            super(worker, z11, i11);
            this.f15534o = subscriber;
        }

        public void b() {
            int i11;
            boolean z11;
            Subscriber<? super T> subscriber = this.f15534o;
            SimpleQueue<T> simpleQueue = this.f15525h;
            long j11 = this.f15530m;
            int i12 = 1;
            while (true) {
                long j12 = this.f15523f.get();
                while (true) {
                    i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z12 = this.f15527j;
                    try {
                        T poll = simpleQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!a(z12, z11, subscriber)) {
                            if (z11) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j11++;
                            if (j11 == ((long) this.f15522e)) {
                                if (j12 != Long.MAX_VALUE) {
                                    j12 = this.f15523f.addAndGet(-j11);
                                }
                                this.f15524g.request(j11);
                                j11 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f15526i = true;
                        this.f15524g.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th2);
                        this.f15519b.dispose();
                        return;
                    }
                }
                if (i11 != 0 || !a(this.f15527j, simpleQueue.isEmpty(), subscriber)) {
                    int i13 = get();
                    if (i12 == i13) {
                        this.f15530m = j11;
                        i12 = addAndGet(-i12);
                        if (i12 == 0) {
                            return;
                        }
                    } else {
                        i12 = i13;
                    }
                } else {
                    return;
                }
            }
        }

        public void c() {
            int i11 = 1;
            while (!this.f15526i) {
                boolean z11 = this.f15527j;
                this.f15534o.onNext(null);
                if (z11) {
                    this.f15526i = true;
                    Throwable th2 = this.f15528k;
                    if (th2 != null) {
                        this.f15534o.onError(th2);
                    } else {
                        this.f15534o.onComplete();
                    }
                    this.f15519b.dispose();
                    return;
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }

        public void d() {
            Subscriber<? super T> subscriber = this.f15534o;
            SimpleQueue<T> simpleQueue = this.f15525h;
            long j11 = this.f15530m;
            int i11 = 1;
            while (true) {
                long j12 = this.f15523f.get();
                while (j11 != j12) {
                    try {
                        T poll = simpleQueue.poll();
                        if (!this.f15526i) {
                            if (poll == null) {
                                this.f15526i = true;
                                subscriber.onComplete();
                                this.f15519b.dispose();
                                return;
                            }
                            subscriber.onNext(poll);
                            j11++;
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f15526i = true;
                        this.f15524g.cancel();
                        subscriber.onError(th2);
                        this.f15519b.dispose();
                        return;
                    }
                }
                if (!this.f15526i) {
                    if (simpleQueue.isEmpty()) {
                        this.f15526i = true;
                        subscriber.onComplete();
                        this.f15519b.dispose();
                        return;
                    }
                    int i12 = get();
                    if (i11 == i12) {
                        this.f15530m = j11;
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        i11 = i12;
                    }
                } else {
                    return;
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15524g, subscription)) {
                this.f15524g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f15529l = 1;
                        this.f15525h = queueSubscription;
                        this.f15527j = true;
                        this.f15534o.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.f15529l = 2;
                        this.f15525h = queueSubscription;
                        this.f15534o.onSubscribe(this);
                        subscription.request((long) this.f15521d);
                        return;
                    }
                }
                this.f15525h = new SpscArrayQueue(this.f15521d);
                this.f15534o.onSubscribe(this);
                subscription.request((long) this.f15521d);
            }
        }

        @Nullable
        public T poll() throws Exception {
            T poll = this.f15525h.poll();
            if (!(poll == null || this.f15529l == 1)) {
                long j11 = this.f15530m + 1;
                if (j11 == ((long) this.f15522e)) {
                    this.f15530m = 0;
                    this.f15524g.request(j11);
                } else {
                    this.f15530m = j11;
                }
            }
            return poll;
        }
    }

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z11, int i11) {
        super(flowable);
        this.f15516d = scheduler;
        this.f15517e = z11;
        this.f15518f = i11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.f15516d.createWorker();
        if (subscriber instanceof ConditionalSubscriber) {
            this.f14763c.subscribe(new ObserveOnConditionalSubscriber((ConditionalSubscriber) subscriber, createWorker, this.f15517e, this.f15518f));
        } else {
            this.f14763c.subscribe(new ObserveOnSubscriber(subscriber, createWorker, this.f15517e, this.f15518f));
        }
    }
}
