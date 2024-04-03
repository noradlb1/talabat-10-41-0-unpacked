package io.reactivex.rxjava3.internal.operators.flowable;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends U>> f19706d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f19707e;

    /* renamed from: f  reason: collision with root package name */
    public final int f19708f;

    /* renamed from: g  reason: collision with root package name */
    public final int f19709g;

    public static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -4606175640614850599L;

        /* renamed from: b  reason: collision with root package name */
        public final long f19710b;

        /* renamed from: c  reason: collision with root package name */
        public final MergeSubscriber<T, U> f19711c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19712d;

        /* renamed from: e  reason: collision with root package name */
        public final int f19713e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f19714f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SimpleQueue<U> f19715g;

        /* renamed from: h  reason: collision with root package name */
        public long f19716h;

        /* renamed from: i  reason: collision with root package name */
        public int f19717i;

        public InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, int i11, long j11) {
            this.f19710b = j11;
            this.f19711c = mergeSubscriber;
            this.f19713e = i11;
            this.f19712d = i11 >> 2;
        }

        public void a(long j11) {
            if (this.f19717i != 1) {
                long j12 = this.f19716h + j11;
                if (j12 >= ((long) this.f19712d)) {
                    this.f19716h = 0;
                    ((Subscription) get()).request(j12);
                    return;
                }
                this.f19716h = j12;
            }
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f19714f = true;
            this.f19711c.e();
        }

        public void onError(Throwable th2) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.f19711c.h(this, th2);
        }

        public void onNext(U u11) {
            if (this.f19717i != 2) {
                this.f19711c.j(u11, this);
            } else {
                this.f19711c.e();
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f19717i = requestFusion;
                        this.f19715g = queueSubscription;
                        this.f19714f = true;
                        this.f19711c.e();
                        return;
                    } else if (requestFusion == 2) {
                        this.f19717i = requestFusion;
                        this.f19715g = queueSubscription;
                    }
                }
                subscription.request((long) this.f19713e);
            }
        }
    }

    public static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: s  reason: collision with root package name */
        public static final InnerSubscriber<?, ?>[] f19718s = new InnerSubscriber[0];
        private static final long serialVersionUID = -2117620485640801370L;

        /* renamed from: t  reason: collision with root package name */
        public static final InnerSubscriber<?, ?>[] f19719t = new InnerSubscriber[0];

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super U> f19720b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends U>> f19721c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f19722d;

        /* renamed from: e  reason: collision with root package name */
        public final int f19723e;

        /* renamed from: f  reason: collision with root package name */
        public final int f19724f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SimplePlainQueue<U> f19725g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f19726h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicThrowable f19727i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f19728j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicReference<InnerSubscriber<?, ?>[]> f19729k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicLong f19730l;

        /* renamed from: m  reason: collision with root package name */
        public Subscription f19731m;

        /* renamed from: n  reason: collision with root package name */
        public long f19732n;

        /* renamed from: o  reason: collision with root package name */
        public long f19733o;

        /* renamed from: p  reason: collision with root package name */
        public int f19734p;

        /* renamed from: q  reason: collision with root package name */
        public int f19735q;

        /* renamed from: r  reason: collision with root package name */
        public final int f19736r;

        public MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z11, int i11, int i12) {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
            this.f19729k = atomicReference;
            this.f19730l = new AtomicLong();
            this.f19720b = subscriber;
            this.f19721c = function;
            this.f19722d = z11;
            this.f19723e = i11;
            this.f19724f = i12;
            this.f19736r = Math.max(1, i11 >> 1);
            atomicReference.lazySet(f19718s);
        }

        public boolean a(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f19729k.get();
                if (innerSubscriberArr == f19719t) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!b.a(this.f19729k, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        public boolean b() {
            if (this.f19728j) {
                c();
                return true;
            } else if (this.f19722d || this.f19727i.get() == null) {
                return false;
            } else {
                c();
                this.f19727i.tryTerminateConsumer((Subscriber<?>) this.f19720b);
                return true;
            }
        }

        public void c() {
            SimplePlainQueue<U> simplePlainQueue = this.f19725g;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
        }

        public void cancel() {
            SimplePlainQueue<U> simplePlainQueue;
            if (!this.f19728j) {
                this.f19728j = true;
                this.f19731m.cancel();
                d();
                if (getAndIncrement() == 0 && (simplePlainQueue = this.f19725g) != null) {
                    simplePlainQueue.clear();
                }
            }
        }

        public void d() {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = this.f19729k;
            InnerSubscriber<?, ?>[] innerSubscriberArr = f19719t;
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = (InnerSubscriber[]) atomicReference.getAndSet(innerSubscriberArr);
            if (innerSubscriberArr2 != innerSubscriberArr) {
                for (InnerSubscriber<?, ?> dispose : innerSubscriberArr2) {
                    dispose.dispose();
                }
                this.f19727i.tryTerminateAndReport();
            }
        }

        public void e() {
            if (getAndIncrement() == 0) {
                f();
            }
        }

        public void f() {
            boolean z11;
            long j11;
            long j12;
            boolean z12;
            long j13;
            long j14;
            int i11;
            int i12;
            long j15;
            long j16;
            Subscriber<? super U> subscriber = this.f19720b;
            int i13 = 1;
            while (!b()) {
                SimplePlainQueue<U> simplePlainQueue = this.f19725g;
                long j17 = this.f19730l.get();
                if (j17 == Long.MAX_VALUE) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                long j18 = 0;
                if (simplePlainQueue != null) {
                    long j19 = 0;
                    j11 = 0;
                    while (j17 != 0) {
                        U poll = simplePlainQueue.poll();
                        if (!b()) {
                            if (poll == null) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j11++;
                            j19++;
                            j17--;
                        } else {
                            return;
                        }
                    }
                    if (j19 != 0) {
                        if (z11) {
                            j17 = Long.MAX_VALUE;
                        } else {
                            j17 = this.f19730l.addAndGet(-j19);
                        }
                    }
                } else {
                    j11 = 0;
                }
                boolean z13 = this.f19726h;
                SimplePlainQueue<U> simplePlainQueue2 = this.f19725g;
                InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.f19729k.get();
                int length = innerSubscriberArr.length;
                if (!z13 || ((simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) || length != 0)) {
                    int i14 = i13;
                    if (length != 0) {
                        long j21 = this.f19733o;
                        int i15 = this.f19734p;
                        if (length <= i15 || innerSubscriberArr[i15].f19710b != j21) {
                            if (length <= i15) {
                                i15 = 0;
                            }
                            for (int i16 = 0; i16 < length && innerSubscriberArr[i15].f19710b != j21; i16++) {
                                i15++;
                                if (i15 == length) {
                                    i15 = 0;
                                }
                            }
                            this.f19734p = i15;
                            this.f19733o = innerSubscriberArr[i15].f19710b;
                        }
                        int i17 = i15;
                        boolean z14 = false;
                        int i18 = 0;
                        while (true) {
                            if (i18 >= length) {
                                z12 = z14;
                                break;
                            } else if (!b()) {
                                InnerSubscriber innerSubscriber = innerSubscriberArr[i17];
                                U u11 = null;
                                while (true) {
                                    SimpleQueue<U> simpleQueue = innerSubscriber.f19715g;
                                    if (simpleQueue != null) {
                                        i11 = length;
                                        U u12 = u11;
                                        long j22 = j18;
                                        while (true) {
                                            if (j12 == j18) {
                                                j15 = j18;
                                                break;
                                            } else if (!b()) {
                                                try {
                                                    U poll2 = simpleQueue.poll();
                                                    if (poll2 == null) {
                                                        u12 = poll2;
                                                        j15 = 0;
                                                        break;
                                                    }
                                                    subscriber.onNext(poll2);
                                                    j12--;
                                                    j22++;
                                                    u12 = poll2;
                                                    j18 = 0;
                                                } catch (Throwable th2) {
                                                    Throwable th3 = th2;
                                                    Exceptions.throwIfFatal(th3);
                                                    innerSubscriber.dispose();
                                                    this.f19727i.tryAddThrowableOrReport(th3);
                                                    if (!this.f19722d) {
                                                        this.f19731m.cancel();
                                                    }
                                                    if (!b()) {
                                                        i(innerSubscriber);
                                                        i18++;
                                                        i12 = i11;
                                                        z14 = true;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                        if (j22 != j15) {
                                            if (!z11) {
                                                j12 = this.f19730l.addAndGet(-j22);
                                            } else {
                                                j12 = Long.MAX_VALUE;
                                            }
                                            innerSubscriber.a(j22);
                                            j16 = 0;
                                        } else {
                                            j16 = j15;
                                        }
                                        if (j12 == j16 || u12 == null) {
                                            break;
                                        }
                                        length = i11;
                                        u11 = u12;
                                        j18 = 0;
                                    } else {
                                        i11 = length;
                                        break;
                                    }
                                }
                                boolean z15 = innerSubscriber.f19714f;
                                SimpleQueue<U> simpleQueue2 = innerSubscriber.f19715g;
                                if (z15 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                    i(innerSubscriber);
                                    if (!b()) {
                                        j11++;
                                        z14 = true;
                                    } else {
                                        return;
                                    }
                                }
                                if (j12 == 0) {
                                    z12 = z14;
                                    break;
                                }
                                i17++;
                                i12 = i11;
                                if (i17 == i12) {
                                    i17 = 0;
                                }
                                i18++;
                                length = i12;
                                j18 = 0;
                            } else {
                                return;
                            }
                        }
                        this.f19734p = i17;
                        this.f19733o = innerSubscriberArr[i17].f19710b;
                        j14 = j11;
                        j13 = 0;
                    } else {
                        j13 = 0;
                        j14 = j11;
                        z12 = false;
                    }
                    if (j14 != j13 && !this.f19728j) {
                        this.f19731m.request(j14);
                    }
                    if (z12) {
                        i13 = i14;
                    } else {
                        i13 = addAndGet(-i14);
                        if (i13 == 0) {
                            return;
                        }
                    }
                } else {
                    this.f19727i.tryTerminateConsumer((Subscriber<?>) this.f19720b);
                    return;
                }
            }
        }

        public SimpleQueue<U> g() {
            SimplePlainQueue<U> simplePlainQueue = this.f19725g;
            if (simplePlainQueue == null) {
                if (this.f19723e == Integer.MAX_VALUE) {
                    simplePlainQueue = new SpscLinkedArrayQueue<>(this.f19724f);
                } else {
                    simplePlainQueue = new SpscArrayQueue<>(this.f19723e);
                }
                this.f19725g = simplePlainQueue;
            }
            return simplePlainQueue;
        }

        public void h(InnerSubscriber<T, U> innerSubscriber, Throwable th2) {
            if (this.f19727i.tryAddThrowableOrReport(th2)) {
                innerSubscriber.f19714f = true;
                if (!this.f19722d) {
                    this.f19731m.cancel();
                    for (InnerSubscriber dispose : (InnerSubscriber[]) this.f19729k.getAndSet(f19719t)) {
                        dispose.dispose();
                    }
                }
                e();
            }
        }

        public void i(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<T, U>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f19729k.get();
                int length = innerSubscriberArr.length;
                if (length != 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            i11 = -1;
                            break;
                        } else if (innerSubscriberArr[i11] == innerSubscriber) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i11 >= 0) {
                        if (length == 1) {
                            innerSubscriberArr2 = f19718s;
                        } else {
                            InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[(length - 1)];
                            System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i11);
                            System.arraycopy(innerSubscriberArr, i11 + 1, innerSubscriberArr3, i11, (length - i11) - 1);
                            innerSubscriberArr2 = innerSubscriberArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!b.a(this.f19729k, innerSubscriberArr, innerSubscriberArr2));
        }

        public void j(U u11, InnerSubscriber<T, U> innerSubscriber) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                SimpleQueue simpleQueue = innerSubscriber.f19715g;
                if (simpleQueue == null) {
                    simpleQueue = new SpscArrayQueue(this.f19724f);
                    innerSubscriber.f19715g = simpleQueue;
                }
                if (!simpleQueue.offer(u11)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                long j11 = this.f19730l.get();
                SimpleQueue simpleQueue2 = innerSubscriber.f19715g;
                if (j11 == 0 || (simpleQueue2 != null && !simpleQueue2.isEmpty())) {
                    if (simpleQueue2 == null) {
                        simpleQueue2 = new SpscArrayQueue(this.f19724f);
                        innerSubscriber.f19715g = simpleQueue2;
                    }
                    if (!simpleQueue2.offer(u11)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                    }
                } else {
                    this.f19720b.onNext(u11);
                    if (j11 != Long.MAX_VALUE) {
                        this.f19730l.decrementAndGet();
                    }
                    innerSubscriber.a(1);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            f();
        }

        public void k(U u11) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j11 = this.f19730l.get();
                SimpleQueue simpleQueue = this.f19725g;
                if (j11 == 0 || (simpleQueue != null && !simpleQueue.isEmpty())) {
                    if (simpleQueue == null) {
                        simpleQueue = g();
                    }
                    if (!simpleQueue.offer(u11)) {
                        onError(new MissingBackpressureException("Scalar queue full?!"));
                    }
                } else {
                    this.f19720b.onNext(u11);
                    if (j11 != Long.MAX_VALUE) {
                        this.f19730l.decrementAndGet();
                    }
                    if (this.f19723e != Integer.MAX_VALUE && !this.f19728j) {
                        int i11 = this.f19735q + 1;
                        this.f19735q = i11;
                        int i12 = this.f19736r;
                        if (i11 == i12) {
                            this.f19735q = 0;
                            this.f19731m.request((long) i12);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!g().offer(u11)) {
                onError(new MissingBackpressureException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            f();
        }

        public void onComplete() {
            if (!this.f19726h) {
                this.f19726h = true;
                e();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19726h) {
                RxJavaPlugins.onError(th2);
            } else if (this.f19727i.tryAddThrowableOrReport(th2)) {
                this.f19726h = true;
                if (!this.f19722d) {
                    for (InnerSubscriber dispose : (InnerSubscriber[]) this.f19729k.getAndSet(f19719t)) {
                        dispose.dispose();
                    }
                }
                e();
            }
        }

        public void onNext(T t11) {
            if (!this.f19726h) {
                try {
                    Object apply = this.f19721c.apply(t11);
                    Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                    Publisher publisher = (Publisher) apply;
                    if (publisher instanceof Supplier) {
                        try {
                            Object obj = ((Supplier) publisher).get();
                            if (obj != null) {
                                k(obj);
                            } else if (this.f19723e != Integer.MAX_VALUE && !this.f19728j) {
                                int i11 = this.f19735q + 1;
                                this.f19735q = i11;
                                int i12 = this.f19736r;
                                if (i11 == i12) {
                                    this.f19735q = 0;
                                    this.f19731m.request((long) i12);
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f19727i.tryAddThrowableOrReport(th2);
                            e();
                        }
                    } else {
                        int i13 = this.f19724f;
                        long j11 = this.f19732n;
                        this.f19732n = 1 + j11;
                        InnerSubscriber innerSubscriber = new InnerSubscriber(this, i13, j11);
                        if (a(innerSubscriber)) {
                            publisher.subscribe(innerSubscriber);
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f19731m.cancel();
                    onError(th3);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19731m, subscription)) {
                this.f19731m = subscription;
                this.f19720b.onSubscribe(this);
                if (!this.f19728j) {
                    int i11 = this.f19723e;
                    if (i11 == Integer.MAX_VALUE) {
                        subscription.request(Long.MAX_VALUE);
                    } else {
                        subscription.request((long) i11);
                    }
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f19730l, j11);
                e();
            }
        }
    }

    public FlowableFlatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, boolean z11, int i11, int i12) {
        super(flowable);
        this.f19706d = function;
        this.f19707e = z11;
        this.f19708f = i11;
        this.f19709g = i12;
    }

    public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z11, int i11, int i12) {
        return new MergeSubscriber(subscriber, function, z11, i11, i12);
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f19260c, subscriber, this.f19706d)) {
            this.f19260c.subscribe(subscribe(subscriber, this.f19706d, this.f19707e, this.f19708f, this.f19709g));
        }
    }
}
