package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Publisher<? extends T> f22628a;

    /* renamed from: b  reason: collision with root package name */
    public final int f22629b;

    /* renamed from: c  reason: collision with root package name */
    public final int f22630c;

    public static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T>[] f22631b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLongArray f22632c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f22633d;

        /* renamed from: e  reason: collision with root package name */
        public final int f22634e;

        /* renamed from: f  reason: collision with root package name */
        public final int f22635f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f22636g;

        /* renamed from: h  reason: collision with root package name */
        public SimpleQueue<T> f22637h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f22638i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f22639j;

        /* renamed from: k  reason: collision with root package name */
        public int f22640k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f22641l;

        /* renamed from: m  reason: collision with root package name */
        public final AtomicInteger f22642m = new AtomicInteger();

        /* renamed from: n  reason: collision with root package name */
        public int f22643n;

        /* renamed from: o  reason: collision with root package name */
        public int f22644o;

        public final class RailSubscription implements Subscription {

            /* renamed from: b  reason: collision with root package name */
            public final int f22645b;

            /* renamed from: c  reason: collision with root package name */
            public final int f22646c;

            public RailSubscription(int i11, int i12) {
                this.f22645b = i11;
                this.f22646c = i12;
            }

            public void cancel() {
                if (ParallelDispatcher.this.f22632c.compareAndSet(this.f22645b + this.f22646c, 0, 1)) {
                    ParallelDispatcher parallelDispatcher = ParallelDispatcher.this;
                    int i11 = this.f22646c;
                    parallelDispatcher.a(i11 + i11);
                }
            }

            public void request(long j11) {
                long j12;
                if (SubscriptionHelper.validate(j11)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.f22632c;
                    do {
                        j12 = atomicLongArray.get(this.f22645b);
                        if (j12 != Long.MAX_VALUE) {
                        } else {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.f22645b, j12, BackpressureHelper.addCap(j12, j11)));
                    if (ParallelDispatcher.this.f22642m.get() == this.f22646c) {
                        ParallelDispatcher.this.b();
                    }
                }
            }
        }

        public ParallelDispatcher(Subscriber<? super T>[] subscriberArr, int i11) {
            this.f22631b = subscriberArr;
            this.f22634e = i11;
            this.f22635f = i11 - (i11 >> 2);
            int length = subscriberArr.length;
            int i12 = length + length;
            AtomicLongArray atomicLongArray = new AtomicLongArray(i12 + 1);
            this.f22632c = atomicLongArray;
            atomicLongArray.lazySet(i12, (long) length);
            this.f22633d = new long[length];
        }

        public void a(int i11) {
            if (this.f22632c.decrementAndGet(i11) == 0) {
                this.f22641l = true;
                this.f22636g.cancel();
                if (getAndIncrement() == 0) {
                    this.f22637h.clear();
                }
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                if (this.f22644o == 1) {
                    d();
                } else {
                    c();
                }
            }
        }

        public void c() {
            Throwable th2;
            SimpleQueue<T> simpleQueue = this.f22637h;
            Subscriber<? super T>[] subscriberArr = this.f22631b;
            AtomicLongArray atomicLongArray = this.f22632c;
            long[] jArr = this.f22633d;
            int length = jArr.length;
            int i11 = this.f22640k;
            int i12 = this.f22643n;
            int i13 = 1;
            while (true) {
                int i14 = 0;
                int i15 = 0;
                while (!this.f22641l) {
                    boolean z11 = this.f22639j;
                    if (!z11 || (th2 = this.f22638i) == null) {
                        boolean isEmpty = simpleQueue.isEmpty();
                        if (!z11 || !isEmpty) {
                            if (!isEmpty) {
                                long j11 = atomicLongArray.get(i11);
                                long j12 = jArr[i11];
                                if (j11 == j12 || atomicLongArray.get(length + i11) != 0) {
                                    i15++;
                                } else {
                                    try {
                                        T poll = simpleQueue.poll();
                                        if (poll != null) {
                                            subscriberArr[i11].onNext(poll);
                                            jArr[i11] = j12 + 1;
                                            i12++;
                                            if (i12 == this.f22635f) {
                                                this.f22636g.request((long) i12);
                                                i12 = 0;
                                            }
                                            i15 = 0;
                                        }
                                    } catch (Throwable th3) {
                                        Throwable th4 = th3;
                                        Exceptions.throwIfFatal(th4);
                                        this.f22636g.cancel();
                                        int length2 = subscriberArr.length;
                                        while (i14 < length2) {
                                            subscriberArr[i14].onError(th4);
                                            i14++;
                                        }
                                        return;
                                    }
                                }
                                i11++;
                                if (i11 == length) {
                                    i11 = 0;
                                    continue;
                                }
                                if (i15 == length) {
                                }
                            }
                            int i16 = get();
                            if (i16 == i13) {
                                this.f22640k = i11;
                                this.f22643n = i12;
                                i13 = addAndGet(-i13);
                                if (i13 == 0) {
                                    return;
                                }
                            } else {
                                i13 = i16;
                            }
                        } else {
                            int length3 = subscriberArr.length;
                            while (i14 < length3) {
                                subscriberArr[i14].onComplete();
                                i14++;
                            }
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        int length4 = subscriberArr.length;
                        while (i14 < length4) {
                            subscriberArr[i14].onError(th2);
                            i14++;
                        }
                        return;
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        public void d() {
            SimpleQueue<T> simpleQueue = this.f22637h;
            Subscriber<? super T>[] subscriberArr = this.f22631b;
            AtomicLongArray atomicLongArray = this.f22632c;
            long[] jArr = this.f22633d;
            int length = jArr.length;
            int i11 = this.f22640k;
            int i12 = 1;
            while (true) {
                int i13 = 0;
                int i14 = 0;
                while (!this.f22641l) {
                    if (simpleQueue.isEmpty()) {
                        int length2 = subscriberArr.length;
                        while (i13 < length2) {
                            subscriberArr[i13].onComplete();
                            i13++;
                        }
                        return;
                    }
                    long j11 = atomicLongArray.get(i11);
                    long j12 = jArr[i11];
                    if (j11 == j12 || atomicLongArray.get(length + i11) != 0) {
                        i14++;
                    } else {
                        try {
                            T poll = simpleQueue.poll();
                            if (poll == null) {
                                int length3 = subscriberArr.length;
                                while (i13 < length3) {
                                    subscriberArr[i13].onComplete();
                                    i13++;
                                }
                                return;
                            }
                            subscriberArr[i11].onNext(poll);
                            jArr[i11] = j12 + 1;
                            i14 = 0;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            Exceptions.throwIfFatal(th3);
                            this.f22636g.cancel();
                            int length4 = subscriberArr.length;
                            while (i13 < length4) {
                                subscriberArr[i13].onError(th3);
                                i13++;
                            }
                            return;
                        }
                    }
                    i11++;
                    if (i11 == length) {
                        i11 = 0;
                        continue;
                    }
                    if (i14 == length) {
                        int i15 = get();
                        if (i15 == i12) {
                            this.f22640k = i11;
                            i12 = addAndGet(-i12);
                            if (i12 == 0) {
                                return;
                            }
                        } else {
                            i12 = i15;
                        }
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        public void e() {
            Subscriber<? super T>[] subscriberArr = this.f22631b;
            int length = subscriberArr.length;
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                this.f22642m.lazySet(i12);
                subscriberArr[i11].onSubscribe(new RailSubscription(i11, length));
                i11 = i12;
            }
        }

        public void onComplete() {
            this.f22639j = true;
            b();
        }

        public void onError(Throwable th2) {
            this.f22638i = th2;
            this.f22639j = true;
            b();
        }

        public void onNext(T t11) {
            if (this.f22644o != 0 || this.f22637h.offer(t11)) {
                b();
                return;
            }
            this.f22636g.cancel();
            onError(new MissingBackpressureException("Queue is full?"));
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22636g, subscription)) {
                this.f22636g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f22644o = requestFusion;
                        this.f22637h = queueSubscription;
                        this.f22639j = true;
                        e();
                        b();
                        return;
                    } else if (requestFusion == 2) {
                        this.f22644o = requestFusion;
                        this.f22637h = queueSubscription;
                        e();
                        subscription.request((long) this.f22634e);
                        return;
                    }
                }
                this.f22637h = new SpscArrayQueue(this.f22634e);
                e();
                subscription.request((long) this.f22634e);
            }
        }
    }

    public ParallelFromPublisher(Publisher<? extends T> publisher, int i11, int i12) {
        this.f22628a = publisher;
        this.f22629b = i11;
        this.f22630c = i12;
    }

    public int parallelism() {
        return this.f22629b;
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (a(onSubscribe)) {
            this.f22628a.subscribe(new ParallelDispatcher(onSubscribe, this.f22630c));
        }
    }
}
