package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Publisher<? extends T> f18094a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18095b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18096c;

    public static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T>[] f18097b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLongArray f18098c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f18099d;

        /* renamed from: e  reason: collision with root package name */
        public final int f18100e;

        /* renamed from: f  reason: collision with root package name */
        public final int f18101f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f18102g;

        /* renamed from: h  reason: collision with root package name */
        public SimpleQueue<T> f18103h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f18104i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f18105j;

        /* renamed from: k  reason: collision with root package name */
        public int f18106k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f18107l;

        /* renamed from: m  reason: collision with root package name */
        public final AtomicInteger f18108m = new AtomicInteger();

        /* renamed from: n  reason: collision with root package name */
        public int f18109n;

        /* renamed from: o  reason: collision with root package name */
        public int f18110o;

        public final class RailSubscription implements Subscription {

            /* renamed from: b  reason: collision with root package name */
            public final int f18111b;

            /* renamed from: c  reason: collision with root package name */
            public final int f18112c;

            public RailSubscription(int i11, int i12) {
                this.f18111b = i11;
                this.f18112c = i12;
            }

            public void cancel() {
                if (ParallelDispatcher.this.f18098c.compareAndSet(this.f18111b + this.f18112c, 0, 1)) {
                    ParallelDispatcher parallelDispatcher = ParallelDispatcher.this;
                    int i11 = this.f18112c;
                    parallelDispatcher.a(i11 + i11);
                }
            }

            public void request(long j11) {
                long j12;
                if (SubscriptionHelper.validate(j11)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.f18098c;
                    do {
                        j12 = atomicLongArray.get(this.f18111b);
                        if (j12 != Long.MAX_VALUE) {
                        } else {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.f18111b, j12, BackpressureHelper.addCap(j12, j11)));
                    if (ParallelDispatcher.this.f18108m.get() == this.f18112c) {
                        ParallelDispatcher.this.b();
                    }
                }
            }
        }

        public ParallelDispatcher(Subscriber<? super T>[] subscriberArr, int i11) {
            this.f18097b = subscriberArr;
            this.f18100e = i11;
            this.f18101f = i11 - (i11 >> 2);
            int length = subscriberArr.length;
            int i12 = length + length;
            AtomicLongArray atomicLongArray = new AtomicLongArray(i12 + 1);
            this.f18098c = atomicLongArray;
            atomicLongArray.lazySet(i12, (long) length);
            this.f18099d = new long[length];
        }

        public void a(int i11) {
            if (this.f18098c.decrementAndGet(i11) == 0) {
                this.f18107l = true;
                this.f18102g.cancel();
                if (getAndIncrement() == 0) {
                    this.f18103h.clear();
                }
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                if (this.f18110o == 1) {
                    d();
                } else {
                    c();
                }
            }
        }

        public void c() {
            Throwable th2;
            SimpleQueue<T> simpleQueue = this.f18103h;
            Subscriber<? super T>[] subscriberArr = this.f18097b;
            AtomicLongArray atomicLongArray = this.f18098c;
            long[] jArr = this.f18099d;
            int length = jArr.length;
            int i11 = this.f18106k;
            int i12 = this.f18109n;
            int i13 = 1;
            while (true) {
                int i14 = 0;
                int i15 = 0;
                while (!this.f18107l) {
                    boolean z11 = this.f18105j;
                    if (!z11 || (th2 = this.f18104i) == null) {
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
                                            if (i12 == this.f18101f) {
                                                this.f18102g.request((long) i12);
                                                i12 = 0;
                                            }
                                            i15 = 0;
                                        }
                                    } catch (Throwable th3) {
                                        Throwable th4 = th3;
                                        Exceptions.throwIfFatal(th4);
                                        this.f18102g.cancel();
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
                                this.f18106k = i11;
                                this.f18109n = i12;
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
            SimpleQueue<T> simpleQueue = this.f18103h;
            Subscriber<? super T>[] subscriberArr = this.f18097b;
            AtomicLongArray atomicLongArray = this.f18098c;
            long[] jArr = this.f18099d;
            int length = jArr.length;
            int i11 = this.f18106k;
            int i12 = 1;
            while (true) {
                int i13 = 0;
                int i14 = 0;
                while (!this.f18107l) {
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
                            this.f18102g.cancel();
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
                            this.f18106k = i11;
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
            Subscriber<? super T>[] subscriberArr = this.f18097b;
            int length = subscriberArr.length;
            int i11 = 0;
            while (i11 < length && !this.f18107l) {
                int i12 = i11 + 1;
                this.f18108m.lazySet(i12);
                subscriberArr[i11].onSubscribe(new RailSubscription(i11, length));
                i11 = i12;
            }
        }

        public void onComplete() {
            this.f18105j = true;
            b();
        }

        public void onError(Throwable th2) {
            this.f18104i = th2;
            this.f18105j = true;
            b();
        }

        public void onNext(T t11) {
            if (this.f18110o != 0 || this.f18103h.offer(t11)) {
                b();
                return;
            }
            this.f18102g.cancel();
            onError(new MissingBackpressureException("Queue is full?"));
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18102g, subscription)) {
                this.f18102g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f18110o = requestFusion;
                        this.f18103h = queueSubscription;
                        this.f18105j = true;
                        e();
                        b();
                        return;
                    } else if (requestFusion == 2) {
                        this.f18110o = requestFusion;
                        this.f18103h = queueSubscription;
                        e();
                        subscription.request((long) this.f18100e);
                        return;
                    }
                }
                this.f18103h = new SpscArrayQueue(this.f18100e);
                e();
                subscription.request((long) this.f18100e);
            }
        }
    }

    public ParallelFromPublisher(Publisher<? extends T> publisher, int i11, int i12) {
        this.f18094a = publisher;
        this.f18095b = i11;
        this.f18096c = i12;
    }

    public int parallelism() {
        return this.f18095b;
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (a(subscriberArr)) {
            this.f18094a.subscribe(new ParallelDispatcher(subscriberArr, this.f18096c));
        }
    }
}
