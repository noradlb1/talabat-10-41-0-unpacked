package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends U>> f15198d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15199e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15200f;

    /* renamed from: g  reason: collision with root package name */
    public final int f15201g;

    public static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -4606175640614850599L;

        /* renamed from: b  reason: collision with root package name */
        public final long f15202b;

        /* renamed from: c  reason: collision with root package name */
        public final MergeSubscriber<T, U> f15203c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15204d;

        /* renamed from: e  reason: collision with root package name */
        public final int f15205e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f15206f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SimpleQueue<U> f15207g;

        /* renamed from: h  reason: collision with root package name */
        public long f15208h;

        /* renamed from: i  reason: collision with root package name */
        public int f15209i;

        public InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j11) {
            this.f15202b = j11;
            this.f15203c = mergeSubscriber;
            int i11 = mergeSubscriber.f15216f;
            this.f15205e = i11;
            this.f15204d = i11 >> 2;
        }

        public void a(long j11) {
            if (this.f15209i != 1) {
                long j12 = this.f15208h + j11;
                if (j12 >= ((long) this.f15204d)) {
                    this.f15208h = 0;
                    ((Subscription) get()).request(j12);
                    return;
                }
                this.f15208h = j12;
            }
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f15206f = true;
            this.f15203c.e();
        }

        public void onError(Throwable th2) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.f15203c.i(this, th2);
        }

        public void onNext(U u11) {
            if (this.f15209i != 2) {
                this.f15203c.k(u11, this);
            } else {
                this.f15203c.e();
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f15209i = requestFusion;
                        this.f15207g = queueSubscription;
                        this.f15206f = true;
                        this.f15203c.e();
                        return;
                    } else if (requestFusion == 2) {
                        this.f15209i = requestFusion;
                        this.f15207g = queueSubscription;
                    }
                }
                subscription.request((long) this.f15205e);
            }
        }
    }

    public static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: s  reason: collision with root package name */
        public static final InnerSubscriber<?, ?>[] f15210s = new InnerSubscriber[0];
        private static final long serialVersionUID = -2117620485640801370L;

        /* renamed from: t  reason: collision with root package name */
        public static final InnerSubscriber<?, ?>[] f15211t = new InnerSubscriber[0];

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super U> f15212b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends U>> f15213c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f15214d;

        /* renamed from: e  reason: collision with root package name */
        public final int f15215e;

        /* renamed from: f  reason: collision with root package name */
        public final int f15216f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SimplePlainQueue<U> f15217g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f15218h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicThrowable f15219i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f15220j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicReference<InnerSubscriber<?, ?>[]> f15221k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicLong f15222l;

        /* renamed from: m  reason: collision with root package name */
        public Subscription f15223m;

        /* renamed from: n  reason: collision with root package name */
        public long f15224n;

        /* renamed from: o  reason: collision with root package name */
        public long f15225o;

        /* renamed from: p  reason: collision with root package name */
        public int f15226p;

        /* renamed from: q  reason: collision with root package name */
        public int f15227q;

        /* renamed from: r  reason: collision with root package name */
        public final int f15228r;

        public MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z11, int i11, int i12) {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
            this.f15221k = atomicReference;
            this.f15222l = new AtomicLong();
            this.f15212b = subscriber;
            this.f15213c = function;
            this.f15214d = z11;
            this.f15215e = i11;
            this.f15216f = i12;
            this.f15228r = Math.max(1, i11 >> 1);
            atomicReference.lazySet(f15210s);
        }

        public boolean a(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f15221k.get();
                if (innerSubscriberArr == f15211t) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!b.a(this.f15221k, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        public boolean b() {
            if (this.f15220j) {
                c();
                return true;
            } else if (this.f15214d || this.f15219i.get() == null) {
                return false;
            } else {
                c();
                Throwable terminate = this.f15219i.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.f15212b.onError(terminate);
                }
                return true;
            }
        }

        public void c() {
            SimplePlainQueue<U> simplePlainQueue = this.f15217g;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
        }

        public void cancel() {
            SimplePlainQueue<U> simplePlainQueue;
            if (!this.f15220j) {
                this.f15220j = true;
                this.f15223m.cancel();
                d();
                if (getAndIncrement() == 0 && (simplePlainQueue = this.f15217g) != null) {
                    simplePlainQueue.clear();
                }
            }
        }

        public void d() {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = (InnerSubscriber[]) this.f15221k.get();
            InnerSubscriber<?, ?>[] innerSubscriberArr3 = f15211t;
            if (innerSubscriberArr2 != innerSubscriberArr3 && (innerSubscriberArr = (InnerSubscriber[]) this.f15221k.getAndSet(innerSubscriberArr3)) != innerSubscriberArr3) {
                for (InnerSubscriber<?, ?> dispose : innerSubscriberArr) {
                    dispose.dispose();
                }
                Throwable terminate = this.f15219i.terminate();
                if (terminate != null && terminate != ExceptionHelper.TERMINATED) {
                    RxJavaPlugins.onError(terminate);
                }
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
            boolean z12;
            long j12;
            long j13;
            int i11;
            int i12;
            long j14;
            Subscriber<? super U> subscriber = this.f15212b;
            int i13 = 1;
            while (!b()) {
                SimplePlainQueue<U> simplePlainQueue = this.f15217g;
                long j15 = this.f15222l.get();
                if (j15 == Long.MAX_VALUE) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                long j16 = 0;
                long j17 = 0;
                if (simplePlainQueue != null) {
                    while (true) {
                        long j18 = 0;
                        U u11 = null;
                        while (true) {
                            if (j15 == 0) {
                                break;
                            }
                            U poll = simplePlainQueue.poll();
                            if (!b()) {
                                if (poll == null) {
                                    u11 = poll;
                                    break;
                                }
                                subscriber.onNext(poll);
                                j17++;
                                j18++;
                                j15--;
                                u11 = poll;
                            } else {
                                return;
                            }
                        }
                        if (j18 != 0) {
                            if (z11) {
                                j15 = Long.MAX_VALUE;
                            } else {
                                j15 = this.f15222l.addAndGet(-j18);
                            }
                        }
                        if (j15 == 0 || u11 == null) {
                            break;
                        }
                    }
                }
                boolean z13 = this.f15218h;
                SimplePlainQueue<U> simplePlainQueue2 = this.f15217g;
                InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.f15221k.get();
                int length = innerSubscriberArr.length;
                if (!z13 || ((simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) || length != 0)) {
                    int i14 = i13;
                    if (length != 0) {
                        long j19 = this.f15225o;
                        int i15 = this.f15226p;
                        if (length <= i15 || innerSubscriberArr[i15].f15202b != j19) {
                            if (length <= i15) {
                                i15 = 0;
                            }
                            for (int i16 = 0; i16 < length && innerSubscriberArr[i15].f15202b != j19; i16++) {
                                i15++;
                                if (i15 == length) {
                                    i15 = 0;
                                }
                            }
                            this.f15226p = i15;
                            this.f15225o = innerSubscriberArr[i15].f15202b;
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
                                U u12 = null;
                                while (!b()) {
                                    SimpleQueue<U> simpleQueue = innerSubscriber.f15207g;
                                    if (simpleQueue == null) {
                                        i11 = length;
                                    } else {
                                        i11 = length;
                                        U u13 = u12;
                                        long j21 = j16;
                                        while (true) {
                                            if (j11 == j16) {
                                                break;
                                            }
                                            try {
                                                U poll2 = simpleQueue.poll();
                                                if (poll2 == null) {
                                                    u13 = poll2;
                                                    j16 = 0;
                                                    break;
                                                }
                                                subscriber.onNext(poll2);
                                                if (!b()) {
                                                    j11--;
                                                    j21++;
                                                    u13 = poll2;
                                                    j16 = 0;
                                                } else {
                                                    return;
                                                }
                                            } catch (Throwable th2) {
                                                Throwable th3 = th2;
                                                Exceptions.throwIfFatal(th3);
                                                innerSubscriber.dispose();
                                                this.f15219i.addThrowable(th3);
                                                if (!this.f15214d) {
                                                    this.f15223m.cancel();
                                                }
                                                if (!b()) {
                                                    j(innerSubscriber);
                                                    i18++;
                                                    z14 = true;
                                                    i12 = 1;
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        if (j21 != j16) {
                                            if (!z11) {
                                                j11 = this.f15222l.addAndGet(-j21);
                                            } else {
                                                j11 = Long.MAX_VALUE;
                                            }
                                            innerSubscriber.a(j21);
                                            j14 = 0;
                                        } else {
                                            j14 = j16;
                                        }
                                        if (!(j11 == j14 || u13 == null)) {
                                            length = i11;
                                            u12 = u13;
                                            j16 = 0;
                                        }
                                    }
                                    boolean z15 = innerSubscriber.f15206f;
                                    SimpleQueue<U> simpleQueue2 = innerSubscriber.f15207g;
                                    if (z15 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                        j(innerSubscriber);
                                        if (!b()) {
                                            j17++;
                                            z14 = true;
                                        } else {
                                            return;
                                        }
                                    }
                                    if (j11 == 0) {
                                        z12 = z14;
                                        break;
                                    }
                                    i17++;
                                    if (i17 == i11) {
                                        i17 = 0;
                                    }
                                    i12 = 1;
                                    i18 += i12;
                                    length = i11;
                                    j16 = 0;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                        this.f15226p = i17;
                        this.f15225o = innerSubscriberArr[i17].f15202b;
                        j13 = j17;
                        j12 = 0;
                    } else {
                        j12 = 0;
                        j13 = j17;
                        z12 = false;
                    }
                    if (j13 != j12 && !this.f15220j) {
                        this.f15223m.request(j13);
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
                    Throwable terminate = this.f15219i.terminate();
                    if (terminate == ExceptionHelper.TERMINATED) {
                        return;
                    }
                    if (terminate == null) {
                        subscriber.onComplete();
                        return;
                    } else {
                        subscriber.onError(terminate);
                        return;
                    }
                }
            }
        }

        public SimpleQueue<U> g(InnerSubscriber<T, U> innerSubscriber) {
            SimpleQueue<U> simpleQueue = innerSubscriber.f15207g;
            if (simpleQueue != null) {
                return simpleQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f15216f);
            innerSubscriber.f15207g = spscArrayQueue;
            return spscArrayQueue;
        }

        public SimpleQueue<U> h() {
            SimplePlainQueue<U> simplePlainQueue = this.f15217g;
            if (simplePlainQueue == null) {
                if (this.f15215e == Integer.MAX_VALUE) {
                    simplePlainQueue = new SpscLinkedArrayQueue<>(this.f15216f);
                } else {
                    simplePlainQueue = new SpscArrayQueue<>(this.f15215e);
                }
                this.f15217g = simplePlainQueue;
            }
            return simplePlainQueue;
        }

        public void i(InnerSubscriber<T, U> innerSubscriber, Throwable th2) {
            if (this.f15219i.addThrowable(th2)) {
                innerSubscriber.f15206f = true;
                if (!this.f15214d) {
                    this.f15223m.cancel();
                    for (InnerSubscriber dispose : (InnerSubscriber[]) this.f15221k.getAndSet(f15211t)) {
                        dispose.dispose();
                    }
                }
                e();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void j(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<T, U>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f15221k.get();
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
                            innerSubscriberArr2 = f15210s;
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
            } while (!b.a(this.f15221k, innerSubscriberArr, innerSubscriberArr2));
        }

        public void k(U u11, InnerSubscriber<T, U> innerSubscriber) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                SimpleQueue simpleQueue = innerSubscriber.f15207g;
                if (simpleQueue == null) {
                    simpleQueue = new SpscArrayQueue(this.f15216f);
                    innerSubscriber.f15207g = simpleQueue;
                }
                if (!simpleQueue.offer(u11)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                long j11 = this.f15222l.get();
                SimpleQueue<U> simpleQueue2 = innerSubscriber.f15207g;
                if (j11 == 0 || (simpleQueue2 != null && !simpleQueue2.isEmpty())) {
                    if (simpleQueue2 == null) {
                        simpleQueue2 = g(innerSubscriber);
                    }
                    if (!simpleQueue2.offer(u11)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.f15212b.onNext(u11);
                    if (j11 != Long.MAX_VALUE) {
                        this.f15222l.decrementAndGet();
                    }
                    innerSubscriber.a(1);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            f();
        }

        public void l(U u11) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j11 = this.f15222l.get();
                SimpleQueue simpleQueue = this.f15217g;
                if (j11 == 0 || (simpleQueue != null && !simpleQueue.isEmpty())) {
                    if (simpleQueue == null) {
                        simpleQueue = h();
                    }
                    if (!simpleQueue.offer(u11)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.f15212b.onNext(u11);
                    if (j11 != Long.MAX_VALUE) {
                        this.f15222l.decrementAndGet();
                    }
                    if (this.f15215e != Integer.MAX_VALUE && !this.f15220j) {
                        int i11 = this.f15227q + 1;
                        this.f15227q = i11;
                        int i12 = this.f15228r;
                        if (i11 == i12) {
                            this.f15227q = 0;
                            this.f15223m.request((long) i12);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!h().offer(u11)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            f();
        }

        public void onComplete() {
            if (!this.f15218h) {
                this.f15218h = true;
                e();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15218h) {
                RxJavaPlugins.onError(th2);
            } else if (this.f15219i.addThrowable(th2)) {
                this.f15218h = true;
                if (!this.f15214d) {
                    for (InnerSubscriber dispose : (InnerSubscriber[]) this.f15221k.getAndSet(f15211t)) {
                        dispose.dispose();
                    }
                }
                e();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!this.f15218h) {
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f15213c.apply(t11), "The mapper returned a null Publisher");
                    if (publisher instanceof Callable) {
                        try {
                            Object call = ((Callable) publisher).call();
                            if (call != null) {
                                l(call);
                            } else if (this.f15215e != Integer.MAX_VALUE && !this.f15220j) {
                                int i11 = this.f15227q + 1;
                                this.f15227q = i11;
                                int i12 = this.f15228r;
                                if (i11 == i12) {
                                    this.f15227q = 0;
                                    this.f15223m.request((long) i12);
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f15219i.addThrowable(th2);
                            e();
                        }
                    } else {
                        long j11 = this.f15224n;
                        this.f15224n = 1 + j11;
                        InnerSubscriber innerSubscriber = new InnerSubscriber(this, j11);
                        if (a(innerSubscriber)) {
                            publisher.subscribe(innerSubscriber);
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f15223m.cancel();
                    onError(th3);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15223m, subscription)) {
                this.f15223m = subscription;
                this.f15212b.onSubscribe(this);
                if (!this.f15220j) {
                    int i11 = this.f15215e;
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
                BackpressureHelper.add(this.f15222l, j11);
                e();
            }
        }
    }

    public FlowableFlatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, boolean z11, int i11, int i12) {
        super(flowable);
        this.f15198d = function;
        this.f15199e = z11;
        this.f15200f = i11;
        this.f15201g = i12;
    }

    public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z11, int i11, int i12) {
        return new MergeSubscriber(subscriber, function, z11, i11, i12);
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f14763c, subscriber, this.f15198d)) {
            this.f14763c.subscribe(subscribe(subscriber, this.f15198d, this.f15199e, this.f15200f, this.f15201g));
        }
    }
}
