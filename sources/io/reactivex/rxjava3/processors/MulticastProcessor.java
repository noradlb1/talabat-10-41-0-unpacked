package io.reactivex.rxjava3.processors;

import i.b;
import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
public final class MulticastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: n  reason: collision with root package name */
    public static final MulticastSubscription[] f23288n = new MulticastSubscription[0];

    /* renamed from: o  reason: collision with root package name */
    public static final MulticastSubscription[] f23289o = new MulticastSubscription[0];

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f23290c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Subscription> f23291d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<MulticastSubscription<T>[]> f23292e = new AtomicReference<>(f23288n);

    /* renamed from: f  reason: collision with root package name */
    public final int f23293f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23294g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f23295h;

    /* renamed from: i  reason: collision with root package name */
    public volatile SimpleQueue<T> f23296i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f23297j;

    /* renamed from: k  reason: collision with root package name */
    public volatile Throwable f23298k;

    /* renamed from: l  reason: collision with root package name */
    public int f23299l;

    /* renamed from: m  reason: collision with root package name */
    public int f23300m;

    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f23301b;

        /* renamed from: c  reason: collision with root package name */
        public final MulticastProcessor<T> f23302c;

        /* renamed from: d  reason: collision with root package name */
        public long f23303d;

        public MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.f23301b = subscriber;
            this.f23302c = multicastProcessor;
        }

        public void a() {
            if (get() != Long.MIN_VALUE) {
                this.f23301b.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.f23301b.onError(th2);
            }
        }

        public void c(T t11) {
            if (get() != Long.MIN_VALUE) {
                this.f23303d++;
                this.f23301b.onNext(t11);
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f23302c.d(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                long addCancel = BackpressureHelper.addCancel(this, j11);
                if (addCancel != Long.MIN_VALUE && addCancel != Long.MAX_VALUE) {
                    this.f23302c.c();
                }
            }
        }
    }

    public MulticastProcessor(int i11, boolean z11) {
        this.f23293f = i11;
        this.f23294g = i11 - (i11 >> 2);
        this.f23295h = z11;
    }

    @NonNull
    @CheckReturnValue
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(Flowable.bufferSize(), false);
    }

    public boolean b(MulticastSubscription<T> multicastSubscription) {
        MulticastSubscription[] multicastSubscriptionArr;
        MulticastSubscription[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = (MulticastSubscription[]) this.f23292e.get();
            if (multicastSubscriptionArr == f23289o) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = multicastSubscription;
        } while (!b.a(this.f23292e, multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    public void c() {
        int i11;
        T t11;
        boolean z11;
        if (this.f23290c.getAndIncrement() == 0) {
            AtomicReference<MulticastSubscription<T>[]> atomicReference = this.f23292e;
            int i12 = this.f23299l;
            int i13 = this.f23294g;
            int i14 = this.f23300m;
            int i15 = 1;
            while (true) {
                SimpleQueue<T> simpleQueue = this.f23296i;
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
                                    j12 = j13 - multicastSubscription.f23303d;
                                } else {
                                    j12 = Math.min(j12, j13 - multicastSubscription.f23303d);
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
                            if (multicastSubscriptionArr2 == f23289o) {
                                simpleQueue.clear();
                                return;
                            } else if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                                break;
                            } else {
                                boolean z12 = this.f23297j;
                                try {
                                    t11 = simpleQueue.poll();
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    Exceptions.throwIfFatal(th3);
                                    SubscriptionHelper.cancel(this.f23291d);
                                    this.f23298k = th3;
                                    this.f23297j = true;
                                    t11 = null;
                                    z12 = true;
                                }
                                if (t11 == null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z12 && z11) {
                                    Throwable th4 = this.f23298k;
                                    if (th4 != null) {
                                        for (MulticastSubscription b11 : (MulticastSubscription[]) atomicReference.getAndSet(f23289o)) {
                                            b11.b(th4);
                                        }
                                        return;
                                    }
                                    for (MulticastSubscription a11 : (MulticastSubscription[]) atomicReference.getAndSet(f23289o)) {
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
                                        this.f23291d.get().request((long) i13);
                                        i17 = 0;
                                    }
                                }
                            }
                        }
                        if (i11 == 0) {
                            MulticastSubscription[] multicastSubscriptionArr3 = (MulticastSubscription[]) atomicReference.get();
                            MulticastSubscription[] multicastSubscriptionArr4 = f23289o;
                            if (multicastSubscriptionArr3 == multicastSubscriptionArr4) {
                                simpleQueue.clear();
                                return;
                            }
                            if (multicastSubscriptionArr == multicastSubscriptionArr3) {
                                if (this.f23297j && simpleQueue.isEmpty()) {
                                    Throwable th5 = this.f23298k;
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
                this.f23299l = i12;
                i15 = this.f23290c.addAndGet(-i15);
                if (i15 == 0) {
                    return;
                }
            }
        }
    }

    public void d(MulticastSubscription<T> multicastSubscription) {
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = (MulticastSubscription[]) this.f23292e.get();
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
                        if (b.a(this.f23292e, multicastSubscriptionArr, multicastSubscriptionArr2)) {
                            return;
                        }
                    } else if (this.f23295h) {
                        if (b.a(this.f23292e, multicastSubscriptionArr, f23289o)) {
                            SubscriptionHelper.cancel(this.f23291d);
                            this.f23297j = true;
                            return;
                        }
                    } else if (b.a(this.f23292e, multicastSubscriptionArr, f23288n)) {
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

    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.f23297j) {
            return this.f23298k;
        }
        return null;
    }

    @CheckReturnValue
    public boolean hasComplete() {
        return this.f23297j && this.f23298k == null;
    }

    @CheckReturnValue
    public boolean hasSubscribers() {
        return ((MulticastSubscription[]) this.f23292e.get()).length != 0;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        return this.f23297j && this.f23298k != null;
    }

    @CheckReturnValue
    public boolean offer(@NonNull T t11) {
        ExceptionHelper.nullCheck(t11, "offer called with a null value.");
        if (this.f23297j) {
            return false;
        }
        if (this.f23300m != 0) {
            throw new IllegalStateException("offer() should not be called in fusion mode!");
        } else if (!this.f23296i.offer(t11)) {
            return false;
        } else {
            c();
            return true;
        }
    }

    public void onComplete() {
        this.f23297j = true;
        c();
    }

    public void onError(@NonNull Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        if (!this.f23297j) {
            this.f23298k = th2;
            this.f23297j = true;
            c();
            return;
        }
        RxJavaPlugins.onError(th2);
    }

    public void onNext(@NonNull T t11) {
        if (!this.f23297j) {
            if (this.f23300m == 0) {
                ExceptionHelper.nullCheck(t11, "onNext called with a null value.");
                if (!this.f23296i.offer(t11)) {
                    SubscriptionHelper.cancel(this.f23291d);
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            c();
        }
    }

    public void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f23291d, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f23300m = requestFusion;
                    this.f23296i = queueSubscription;
                    this.f23297j = true;
                    c();
                    return;
                } else if (requestFusion == 2) {
                    this.f23300m = requestFusion;
                    this.f23296i = queueSubscription;
                    subscription.request((long) this.f23293f);
                    return;
                }
            }
            this.f23296i = new SpscArrayQueue(this.f23293f);
            subscription.request((long) this.f23293f);
        }
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.f23291d, EmptySubscription.INSTANCE)) {
            this.f23296i = new SpscArrayQueue(this.f23293f);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.f23291d, EmptySubscription.INSTANCE)) {
            this.f23296i = new SpscLinkedArrayQueue(this.f23293f);
        }
    }

    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        Throwable th2;
        MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
        subscriber.onSubscribe(multicastSubscription);
        if (b(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                d(multicastSubscription);
            } else {
                c();
            }
        } else if (!this.f23297j || (th2 = this.f23298k) == null) {
            subscriber.onComplete();
        } else {
            subscriber.onError(th2);
        }
    }

    @NonNull
    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(boolean z11) {
        return new MulticastProcessor<>(Flowable.bufferSize(), z11);
    }

    @NonNull
    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int i11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return new MulticastProcessor<>(i11, false);
    }

    @NonNull
    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int i11, boolean z11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return new MulticastProcessor<>(i11, z11);
    }
}
