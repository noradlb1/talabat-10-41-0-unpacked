package io.reactivex.processors;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
public final class MulticastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: o  reason: collision with root package name */
    public static final MulticastSubscription[] f18689o = new MulticastSubscription[0];

    /* renamed from: p  reason: collision with root package name */
    public static final MulticastSubscription[] f18690p = new MulticastSubscription[0];

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f18691c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Subscription> f18692d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<MulticastSubscription<T>[]> f18693e = new AtomicReference<>(f18689o);

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f18694f;

    /* renamed from: g  reason: collision with root package name */
    public final int f18695g;

    /* renamed from: h  reason: collision with root package name */
    public final int f18696h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f18697i;

    /* renamed from: j  reason: collision with root package name */
    public volatile SimpleQueue<T> f18698j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f18699k;

    /* renamed from: l  reason: collision with root package name */
    public volatile Throwable f18700l;

    /* renamed from: m  reason: collision with root package name */
    public int f18701m;

    /* renamed from: n  reason: collision with root package name */
    public int f18702n;

    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f18703b;

        /* renamed from: c  reason: collision with root package name */
        public final MulticastProcessor<T> f18704c;

        /* renamed from: d  reason: collision with root package name */
        public long f18705d;

        public MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.f18703b = subscriber;
            this.f18704c = multicastProcessor;
        }

        public void a() {
            if (get() != Long.MIN_VALUE) {
                this.f18703b.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.f18703b.onError(th2);
            }
        }

        public void c(T t11) {
            if (get() != Long.MIN_VALUE) {
                this.f18705d++;
                this.f18703b.onNext(t11);
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f18704c.d(this);
            }
        }

        public void request(long j11) {
            long j12;
            long j13;
            if (SubscriptionHelper.validate(j11)) {
                do {
                    j12 = get();
                    if (j12 != Long.MIN_VALUE) {
                        j13 = Long.MAX_VALUE;
                        if (j12 != Long.MAX_VALUE) {
                            long j14 = j12 + j11;
                            if (j14 >= 0) {
                                j13 = j14;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j12, j13));
                this.f18704c.c();
            }
        }
    }

    public MulticastProcessor(int i11, boolean z11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        this.f18695g = i11;
        this.f18696h = i11 - (i11 >> 2);
        this.f18697i = z11;
        this.f18694f = new AtomicBoolean();
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(Flowable.bufferSize(), false);
    }

    public boolean b(MulticastSubscription<T> multicastSubscription) {
        MulticastSubscription[] multicastSubscriptionArr;
        MulticastSubscription[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = (MulticastSubscription[]) this.f18693e.get();
            if (multicastSubscriptionArr == f18690p) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = multicastSubscription;
        } while (!b.a(this.f18693e, multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    public void c() {
        int i11;
        T t11;
        boolean z11;
        if (this.f18691c.getAndIncrement() == 0) {
            AtomicReference<MulticastSubscription<T>[]> atomicReference = this.f18693e;
            int i12 = this.f18701m;
            int i13 = this.f18696h;
            int i14 = this.f18702n;
            int i15 = 1;
            while (true) {
                SimpleQueue<T> simpleQueue = this.f18698j;
                if (simpleQueue != null) {
                    MulticastSubscription[] multicastSubscriptionArr = (MulticastSubscription[]) atomicReference.get();
                    if (multicastSubscriptionArr.length != 0) {
                        int length = multicastSubscriptionArr.length;
                        long j11 = -1;
                        long j12 = -1;
                        int i16 = 0;
                        while (i16 < length) {
                            MulticastSubscription multicastSubscription = multicastSubscriptionArr[i16];
                            long j13 = multicastSubscription.get();
                            if (j13 >= 0) {
                                if (j12 == j11) {
                                    j12 = j13 - multicastSubscription.f18705d;
                                } else {
                                    j12 = Math.min(j12, j13 - multicastSubscription.f18705d);
                                }
                            }
                            i16++;
                            j11 = -1;
                        }
                        int i17 = i12;
                        while (true) {
                            i11 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
                            if (i11 <= 0) {
                                break;
                            }
                            MulticastSubscription[] multicastSubscriptionArr2 = (MulticastSubscription[]) atomicReference.get();
                            if (multicastSubscriptionArr2 == f18690p) {
                                simpleQueue.clear();
                                return;
                            } else if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                                break;
                            } else {
                                boolean z12 = this.f18699k;
                                try {
                                    t11 = simpleQueue.poll();
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    Exceptions.throwIfFatal(th3);
                                    SubscriptionHelper.cancel(this.f18692d);
                                    this.f18700l = th3;
                                    this.f18699k = true;
                                    t11 = null;
                                    z12 = true;
                                }
                                if (t11 == null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z12 && z11) {
                                    Throwable th4 = this.f18700l;
                                    if (th4 != null) {
                                        for (MulticastSubscription b11 : (MulticastSubscription[]) atomicReference.getAndSet(f18690p)) {
                                            b11.b(th4);
                                        }
                                        return;
                                    }
                                    for (MulticastSubscription a11 : (MulticastSubscription[]) atomicReference.getAndSet(f18690p)) {
                                        a11.a();
                                    }
                                    return;
                                } else if (z11) {
                                    break;
                                } else {
                                    for (MulticastSubscription c11 : multicastSubscriptionArr) {
                                        c11.c(t11);
                                    }
                                    j12--;
                                    if (i14 != 1 && (i17 = i17 + 1) == i13) {
                                        this.f18692d.get().request((long) i13);
                                        i17 = 0;
                                    }
                                }
                            }
                        }
                        if (i11 == 0) {
                            MulticastSubscription[] multicastSubscriptionArr3 = (MulticastSubscription[]) atomicReference.get();
                            MulticastSubscription[] multicastSubscriptionArr4 = f18690p;
                            if (multicastSubscriptionArr3 == multicastSubscriptionArr4) {
                                simpleQueue.clear();
                                return;
                            }
                            if (multicastSubscriptionArr == multicastSubscriptionArr3) {
                                if (this.f18699k && simpleQueue.isEmpty()) {
                                    Throwable th5 = this.f18700l;
                                    if (th5 != null) {
                                        for (MulticastSubscription b12 : (MulticastSubscription[]) atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                            b12.b(th5);
                                        }
                                        return;
                                    }
                                    for (MulticastSubscription a12 : (MulticastSubscription[]) atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                        a12.a();
                                    }
                                    return;
                                }
                            }
                            i12 = i17;
                        }
                        i12 = i17;
                    }
                }
                this.f18701m = i12;
                i15 = this.f18691c.addAndGet(-i15);
                if (i15 == 0) {
                    return;
                }
            }
        }
    }

    public void d(MulticastSubscription<T> multicastSubscription) {
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = (MulticastSubscription[]) this.f18693e.get();
            int length = multicastSubscriptionArr.length;
            if (length != 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (multicastSubscriptionArr[i11] == multicastSubscription) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length != 1) {
                        MulticastSubscription[] multicastSubscriptionArr2 = new MulticastSubscription[(length - 1)];
                        System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i11);
                        System.arraycopy(multicastSubscriptionArr, i11 + 1, multicastSubscriptionArr2, i11, (length - i11) - 1);
                        if (b.a(this.f18693e, multicastSubscriptionArr, multicastSubscriptionArr2)) {
                            return;
                        }
                    } else if (this.f18697i) {
                        if (b.a(this.f18693e, multicastSubscriptionArr, f18690p)) {
                            SubscriptionHelper.cancel(this.f18692d);
                            this.f18694f.set(true);
                            return;
                        }
                    } else if (b.a(this.f18693e, multicastSubscriptionArr, f18689o)) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public Throwable getThrowable() {
        if (this.f18694f.get()) {
            return this.f18700l;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.f18694f.get() && this.f18700l == null;
    }

    public boolean hasSubscribers() {
        return ((MulticastSubscription[]) this.f18693e.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f18694f.get() && this.f18700l != null;
    }

    public boolean offer(T t11) {
        if (this.f18694f.get()) {
            return false;
        }
        ObjectHelper.requireNonNull(t11, "offer called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f18702n != 0 || !this.f18698j.offer(t11)) {
            return false;
        }
        c();
        return true;
    }

    public void onComplete() {
        if (this.f18694f.compareAndSet(false, true)) {
            this.f18699k = true;
            c();
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f18694f.compareAndSet(false, true)) {
            this.f18700l = th2;
            this.f18699k = true;
            c();
            return;
        }
        RxJavaPlugins.onError(th2);
    }

    public void onNext(T t11) {
        if (!this.f18694f.get()) {
            if (this.f18702n == 0) {
                ObjectHelper.requireNonNull(t11, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                if (!this.f18698j.offer(t11)) {
                    SubscriptionHelper.cancel(this.f18692d);
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            c();
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f18692d, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f18702n = requestFusion;
                    this.f18698j = queueSubscription;
                    this.f18699k = true;
                    c();
                    return;
                } else if (requestFusion == 2) {
                    this.f18702n = requestFusion;
                    this.f18698j = queueSubscription;
                    subscription.request((long) this.f18695g);
                    return;
                }
            }
            this.f18698j = new SpscArrayQueue(this.f18695g);
            subscription.request((long) this.f18695g);
        }
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.f18692d, EmptySubscription.INSTANCE)) {
            this.f18698j = new SpscArrayQueue(this.f18695g);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.f18692d, EmptySubscription.INSTANCE)) {
            this.f18698j = new SpscLinkedArrayQueue(this.f18695g);
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Throwable th2;
        MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
        subscriber.onSubscribe(multicastSubscription);
        if (b(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                d(multicastSubscription);
            } else {
                c();
            }
        } else if ((this.f18694f.get() || !this.f18697i) && (th2 = this.f18700l) != null) {
            subscriber.onError(th2);
        } else {
            subscriber.onComplete();
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(boolean z11) {
        return new MulticastProcessor<>(Flowable.bufferSize(), z11);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int i11) {
        return new MulticastProcessor<>(i11, false);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int i11, boolean z11) {
        return new MulticastProcessor<>(i11, z11);
    }
}
