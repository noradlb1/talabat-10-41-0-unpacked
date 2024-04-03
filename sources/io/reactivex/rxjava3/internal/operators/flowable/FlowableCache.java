package io.reactivex.rxjava3.internal.operators.flowable;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> implements FlowableSubscriber<T> {

    /* renamed from: m  reason: collision with root package name */
    public static final CacheSubscription[] f19405m = new CacheSubscription[0];

    /* renamed from: n  reason: collision with root package name */
    public static final CacheSubscription[] f19406n = new CacheSubscription[0];

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f19407d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public final int f19408e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<CacheSubscription<T>[]> f19409f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f19410g;

    /* renamed from: h  reason: collision with root package name */
    public final Node<T> f19411h;

    /* renamed from: i  reason: collision with root package name */
    public Node<T> f19412i;

    /* renamed from: j  reason: collision with root package name */
    public int f19413j;

    /* renamed from: k  reason: collision with root package name */
    public Throwable f19414k;

    /* renamed from: l  reason: collision with root package name */
    public volatile boolean f19415l;

    public static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19416b;

        /* renamed from: c  reason: collision with root package name */
        public final FlowableCache<T> f19417c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f19418d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public Node<T> f19419e;

        /* renamed from: f  reason: collision with root package name */
        public int f19420f;

        /* renamed from: g  reason: collision with root package name */
        public long f19421g;

        public CacheSubscription(Subscriber<? super T> subscriber, FlowableCache<T> flowableCache) {
            this.f19416b = subscriber;
            this.f19417c = flowableCache;
            this.f19419e = flowableCache.f19411h;
        }

        public void cancel() {
            if (this.f19418d.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f19417c.c(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.addCancel(this.f19418d, j11);
                this.f19417c.d(this);
            }
        }
    }

    public static final class Node<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T[] f19422a;

        /* renamed from: b  reason: collision with root package name */
        public volatile Node<T> f19423b;

        public Node(int i11) {
            this.f19422a = new Object[i11];
        }
    }

    public FlowableCache(Flowable<T> flowable, int i11) {
        super(flowable);
        this.f19408e = i11;
        Node<T> node = new Node<>(i11);
        this.f19411h = node;
        this.f19412i = node;
        this.f19409f = new AtomicReference<>(f19405m);
    }

    public void b(CacheSubscription<T> cacheSubscription) {
        CacheSubscription[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.f19409f.get();
            if (cacheSubscriptionArr != f19406n) {
                int length = cacheSubscriptionArr.length;
                cacheSubscriptionArr2 = new CacheSubscription[(length + 1)];
                System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
                cacheSubscriptionArr2[length] = cacheSubscription;
            } else {
                return;
            }
        } while (!b.a(this.f19409f, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    public void c(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.f19409f.get();
            int length = cacheSubscriptionArr.length;
            if (length != 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (cacheSubscriptionArr[i11] == cacheSubscription) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        cacheSubscriptionArr2 = f19405m;
                    } else {
                        CacheSubscription[] cacheSubscriptionArr3 = new CacheSubscription[(length - 1)];
                        System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i11);
                        System.arraycopy(cacheSubscriptionArr, i11 + 1, cacheSubscriptionArr3, i11, (length - i11) - 1);
                        cacheSubscriptionArr2 = cacheSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f19409f, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    public void d(CacheSubscription<T> cacheSubscription) {
        boolean z11;
        CacheSubscription<T> cacheSubscription2 = cacheSubscription;
        if (cacheSubscription.getAndIncrement() == 0) {
            long j11 = cacheSubscription2.f19421g;
            int i11 = cacheSubscription2.f19420f;
            Node<T> node = cacheSubscription2.f19419e;
            AtomicLong atomicLong = cacheSubscription2.f19418d;
            Subscriber<? super T> subscriber = cacheSubscription2.f19416b;
            int i12 = this.f19408e;
            int i13 = 1;
            while (true) {
                boolean z12 = this.f19415l;
                if (this.f19410g == j11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z12 || !z11) {
                    if (!z11) {
                        long j12 = atomicLong.get();
                        if (j12 == Long.MIN_VALUE) {
                            cacheSubscription2.f19419e = null;
                            return;
                        } else if (j12 != j11) {
                            if (i11 == i12) {
                                node = node.f19423b;
                                i11 = 0;
                            }
                            subscriber.onNext(node.f19422a[i11]);
                            i11++;
                            j11++;
                        }
                    }
                    cacheSubscription2.f19421g = j11;
                    cacheSubscription2.f19420f = i11;
                    cacheSubscription2.f19419e = node;
                    i13 = cacheSubscription2.addAndGet(-i13);
                    if (i13 == 0) {
                        return;
                    }
                } else {
                    cacheSubscription2.f19419e = null;
                    Throwable th2 = this.f19414k;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
            }
        }
    }

    public void onComplete() {
        this.f19415l = true;
        for (CacheSubscription d11 : (CacheSubscription[]) this.f19409f.getAndSet(f19406n)) {
            d(d11);
        }
    }

    public void onError(Throwable th2) {
        if (this.f19415l) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f19414k = th2;
        this.f19415l = true;
        for (CacheSubscription d11 : (CacheSubscription[]) this.f19409f.getAndSet(f19406n)) {
            d(d11);
        }
    }

    public void onNext(T t11) {
        int i11 = this.f19413j;
        if (i11 == this.f19408e) {
            Node<T> node = new Node<>(i11);
            node.f19422a[0] = t11;
            this.f19413j = 1;
            this.f19412i.f19423b = node;
            this.f19412i = node;
        } else {
            this.f19412i.f19422a[i11] = t11;
            this.f19413j = i11 + 1;
        }
        this.f19410g++;
        for (CacheSubscription d11 : (CacheSubscription[]) this.f19409f.get()) {
            d(d11);
        }
    }

    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        CacheSubscription cacheSubscription = new CacheSubscription(subscriber, this);
        subscriber.onSubscribe(cacheSubscription);
        b(cacheSubscription);
        if (this.f19407d.get() || !this.f19407d.compareAndSet(false, true)) {
            d(cacheSubscription);
        } else {
            this.f19260c.subscribe(this);
        }
    }
}
