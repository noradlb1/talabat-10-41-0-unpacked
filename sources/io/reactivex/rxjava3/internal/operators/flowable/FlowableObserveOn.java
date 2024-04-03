package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f20039d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f20040e;

    /* renamed from: f  reason: collision with root package name */
    public final int f20041f;

    public static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;

        /* renamed from: b  reason: collision with root package name */
        public final Scheduler.Worker f20042b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f20043c;

        /* renamed from: d  reason: collision with root package name */
        public final int f20044d;

        /* renamed from: e  reason: collision with root package name */
        public final int f20045e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f20046f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public Subscription f20047g;

        /* renamed from: h  reason: collision with root package name */
        public SimpleQueue<T> f20048h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f20049i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f20050j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f20051k;

        /* renamed from: l  reason: collision with root package name */
        public int f20052l;

        /* renamed from: m  reason: collision with root package name */
        public long f20053m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f20054n;

        public BaseObserveOnSubscriber(Scheduler.Worker worker, boolean z11, int i11) {
            this.f20042b = worker;
            this.f20043c = z11;
            this.f20044d = i11;
            this.f20045e = i11 - (i11 >> 2);
        }

        public final boolean a(boolean z11, boolean z12, Subscriber<?> subscriber) {
            if (this.f20049i) {
                clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!this.f20043c) {
                    Throwable th2 = this.f20051k;
                    if (th2 != null) {
                        this.f20049i = true;
                        clear();
                        subscriber.onError(th2);
                        this.f20042b.dispose();
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        this.f20049i = true;
                        subscriber.onComplete();
                        this.f20042b.dispose();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    this.f20049i = true;
                    Throwable th3 = this.f20051k;
                    if (th3 != null) {
                        subscriber.onError(th3);
                    } else {
                        subscriber.onComplete();
                    }
                    this.f20042b.dispose();
                    return true;
                }
            }
        }

        public abstract void b();

        public abstract void c();

        public final void cancel() {
            if (!this.f20049i) {
                this.f20049i = true;
                this.f20047g.cancel();
                this.f20042b.dispose();
                if (!this.f20054n && getAndIncrement() == 0) {
                    this.f20048h.clear();
                }
            }
        }

        public final void clear() {
            this.f20048h.clear();
        }

        public abstract void d();

        public final void e() {
            if (getAndIncrement() == 0) {
                this.f20042b.schedule(this);
            }
        }

        public final boolean isEmpty() {
            return this.f20048h.isEmpty();
        }

        public final void onComplete() {
            if (!this.f20050j) {
                this.f20050j = true;
                e();
            }
        }

        public final void onError(Throwable th2) {
            if (this.f20050j) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20051k = th2;
            this.f20050j = true;
            e();
        }

        public final void onNext(T t11) {
            if (!this.f20050j) {
                if (this.f20052l == 2) {
                    e();
                    return;
                }
                if (!this.f20048h.offer(t11)) {
                    this.f20047g.cancel();
                    this.f20051k = new MissingBackpressureException("Queue is full?!");
                    this.f20050j = true;
                }
                e();
            }
        }

        public final void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20046f, j11);
                e();
            }
        }

        public final int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f20054n = true;
            return 2;
        }

        public final void run() {
            if (this.f20054n) {
                c();
            } else if (this.f20052l == 1) {
                d();
            } else {
                b();
            }
        }
    }

    public static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;

        /* renamed from: o  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f20055o;

        /* renamed from: p  reason: collision with root package name */
        public long f20056p;

        public ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler.Worker worker, boolean z11, int i11) {
            super(worker, z11, i11);
            this.f20055o = conditionalSubscriber;
        }

        public void b() {
            int i11;
            boolean z11;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f20055o;
            SimpleQueue<T> simpleQueue = this.f20048h;
            long j11 = this.f20053m;
            long j12 = this.f20056p;
            int i12 = 1;
            do {
                long j13 = this.f20046f.get();
                while (true) {
                    i11 = (j11 > j13 ? 1 : (j11 == j13 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z12 = this.f20050j;
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
                            if (j12 == ((long) this.f20045e)) {
                                this.f20047g.request(j12);
                                j12 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f20049i = true;
                        this.f20047g.cancel();
                        simpleQueue.clear();
                        conditionalSubscriber.onError(th2);
                        this.f20042b.dispose();
                        return;
                    }
                }
                if (i11 != 0 || !a(this.f20050j, simpleQueue.isEmpty(), conditionalSubscriber)) {
                    this.f20053m = j11;
                    this.f20056p = j12;
                    i12 = addAndGet(-i12);
                } else {
                    return;
                }
            } while (i12 != 0);
        }

        public void c() {
            int i11 = 1;
            while (!this.f20049i) {
                boolean z11 = this.f20050j;
                this.f20055o.onNext(null);
                if (z11) {
                    this.f20049i = true;
                    Throwable th2 = this.f20051k;
                    if (th2 != null) {
                        this.f20055o.onError(th2);
                    } else {
                        this.f20055o.onComplete();
                    }
                    this.f20042b.dispose();
                    return;
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }

        public void d() {
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f20055o;
            SimpleQueue<T> simpleQueue = this.f20048h;
            long j11 = this.f20053m;
            int i11 = 1;
            do {
                long j12 = this.f20046f.get();
                while (j11 != j12) {
                    try {
                        T poll = simpleQueue.poll();
                        if (!this.f20049i) {
                            if (poll == null) {
                                this.f20049i = true;
                                conditionalSubscriber.onComplete();
                                this.f20042b.dispose();
                                return;
                            } else if (conditionalSubscriber.tryOnNext(poll)) {
                                j11++;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f20049i = true;
                        this.f20047g.cancel();
                        conditionalSubscriber.onError(th2);
                        this.f20042b.dispose();
                        return;
                    }
                }
                if (!this.f20049i) {
                    if (simpleQueue.isEmpty()) {
                        this.f20049i = true;
                        conditionalSubscriber.onComplete();
                        this.f20042b.dispose();
                        return;
                    }
                    this.f20053m = j11;
                    i11 = addAndGet(-i11);
                } else {
                    return;
                }
            } while (i11 != 0);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20047g, subscription)) {
                this.f20047g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f20052l = 1;
                        this.f20048h = queueSubscription;
                        this.f20050j = true;
                        this.f20055o.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.f20052l = 2;
                        this.f20048h = queueSubscription;
                        this.f20055o.onSubscribe(this);
                        subscription.request((long) this.f20044d);
                        return;
                    }
                }
                this.f20048h = new SpscArrayQueue(this.f20044d);
                this.f20055o.onSubscribe(this);
                subscription.request((long) this.f20044d);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.f20048h.poll();
            if (!(poll == null || this.f20052l == 1)) {
                long j11 = this.f20056p + 1;
                if (j11 == ((long) this.f20045e)) {
                    this.f20056p = 0;
                    this.f20047g.request(j11);
                } else {
                    this.f20056p = j11;
                }
            }
            return poll;
        }
    }

    public static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;

        /* renamed from: o  reason: collision with root package name */
        public final Subscriber<? super T> f20057o;

        public ObserveOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, boolean z11, int i11) {
            super(worker, z11, i11);
            this.f20057o = subscriber;
        }

        public void b() {
            int i11;
            boolean z11;
            Subscriber<? super T> subscriber = this.f20057o;
            SimpleQueue<T> simpleQueue = this.f20048h;
            long j11 = this.f20053m;
            int i12 = 1;
            while (true) {
                long j12 = this.f20046f.get();
                while (true) {
                    i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z12 = this.f20050j;
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
                            if (j11 == ((long) this.f20045e)) {
                                if (j12 != Long.MAX_VALUE) {
                                    j12 = this.f20046f.addAndGet(-j11);
                                }
                                this.f20047g.request(j11);
                                j11 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f20049i = true;
                        this.f20047g.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th2);
                        this.f20042b.dispose();
                        return;
                    }
                }
                if (i11 != 0 || !a(this.f20050j, simpleQueue.isEmpty(), subscriber)) {
                    int i13 = get();
                    if (i12 == i13) {
                        this.f20053m = j11;
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
            while (!this.f20049i) {
                boolean z11 = this.f20050j;
                this.f20057o.onNext(null);
                if (z11) {
                    this.f20049i = true;
                    Throwable th2 = this.f20051k;
                    if (th2 != null) {
                        this.f20057o.onError(th2);
                    } else {
                        this.f20057o.onComplete();
                    }
                    this.f20042b.dispose();
                    return;
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }

        public void d() {
            Subscriber<? super T> subscriber = this.f20057o;
            SimpleQueue<T> simpleQueue = this.f20048h;
            long j11 = this.f20053m;
            int i11 = 1;
            do {
                long j12 = this.f20046f.get();
                while (j11 != j12) {
                    try {
                        T poll = simpleQueue.poll();
                        if (!this.f20049i) {
                            if (poll == null) {
                                this.f20049i = true;
                                subscriber.onComplete();
                                this.f20042b.dispose();
                                return;
                            }
                            subscriber.onNext(poll);
                            j11++;
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f20049i = true;
                        this.f20047g.cancel();
                        subscriber.onError(th2);
                        this.f20042b.dispose();
                        return;
                    }
                }
                if (!this.f20049i) {
                    if (simpleQueue.isEmpty()) {
                        this.f20049i = true;
                        subscriber.onComplete();
                        this.f20042b.dispose();
                        return;
                    }
                    this.f20053m = j11;
                    i11 = addAndGet(-i11);
                } else {
                    return;
                }
            } while (i11 != 0);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20047g, subscription)) {
                this.f20047g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f20052l = 1;
                        this.f20048h = queueSubscription;
                        this.f20050j = true;
                        this.f20057o.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.f20052l = 2;
                        this.f20048h = queueSubscription;
                        this.f20057o.onSubscribe(this);
                        subscription.request((long) this.f20044d);
                        return;
                    }
                }
                this.f20048h = new SpscArrayQueue(this.f20044d);
                this.f20057o.onSubscribe(this);
                subscription.request((long) this.f20044d);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.f20048h.poll();
            if (!(poll == null || this.f20052l == 1)) {
                long j11 = this.f20053m + 1;
                if (j11 == ((long) this.f20045e)) {
                    this.f20053m = 0;
                    this.f20047g.request(j11);
                } else {
                    this.f20053m = j11;
                }
            }
            return poll;
        }
    }

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z11, int i11) {
        super(flowable);
        this.f20039d = scheduler;
        this.f20040e = z11;
        this.f20041f = i11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.f20039d.createWorker();
        if (subscriber instanceof ConditionalSubscriber) {
            this.f19260c.subscribe(new ObserveOnConditionalSubscriber((ConditionalSubscriber) subscriber, createWorker, this.f20040e, this.f20041f));
        } else {
            this.f19260c.subscribe(new ObserveOnSubscriber(subscriber, createWorker, this.f20040e, this.f20041f));
        }
    }
}
