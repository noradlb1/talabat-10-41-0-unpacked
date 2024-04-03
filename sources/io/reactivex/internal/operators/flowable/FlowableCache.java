package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> implements FlowableSubscriber<T> {

    /* renamed from: m  reason: collision with root package name */
    public static final CacheSubscription[] f14917m = new CacheSubscription[0];

    /* renamed from: n  reason: collision with root package name */
    public static final CacheSubscription[] f14918n = new CacheSubscription[0];

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f14919d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public final int f14920e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<CacheSubscription<T>[]> f14921f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f14922g;

    /* renamed from: h  reason: collision with root package name */
    public final Node<T> f14923h;

    /* renamed from: i  reason: collision with root package name */
    public Node<T> f14924i;

    /* renamed from: j  reason: collision with root package name */
    public int f14925j;

    /* renamed from: k  reason: collision with root package name */
    public Throwable f14926k;

    /* renamed from: l  reason: collision with root package name */
    public volatile boolean f14927l;

    public static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f14928b;

        /* renamed from: c  reason: collision with root package name */
        public final FlowableCache<T> f14929c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f14930d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public Node<T> f14931e;

        /* renamed from: f  reason: collision with root package name */
        public int f14932f;

        /* renamed from: g  reason: collision with root package name */
        public long f14933g;

        public CacheSubscription(Subscriber<? super T> subscriber, FlowableCache<T> flowableCache) {
            this.f14928b = subscriber;
            this.f14929c = flowableCache;
            this.f14931e = flowableCache.f14923h;
        }

        public void cancel() {
            if (this.f14930d.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f14929c.c(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.addCancel(this.f14930d, j11);
                this.f14929c.d(this);
            }
        }
    }

    public static final class Node<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T[] f14934a;

        /* renamed from: b  reason: collision with root package name */
        public volatile Node<T> f14935b;

        public Node(int i11) {
            this.f14934a = new Object[i11];
        }
    }

    public FlowableCache(Flowable<T> flowable, int i11) {
        super(flowable);
        this.f14920e = i11;
        Node<T> node = new Node<>(i11);
        this.f14923h = node;
        this.f14924i = node;
        this.f14921f = new AtomicReference<>(f14917m);
    }

    public void b(CacheSubscription<T> cacheSubscription) {
        CacheSubscription[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.f14921f.get();
            if (cacheSubscriptionArr != f14918n) {
                int length = cacheSubscriptionArr.length;
                cacheSubscriptionArr2 = new CacheSubscription[(length + 1)];
                System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
                cacheSubscriptionArr2[length] = cacheSubscription;
            } else {
                return;
            }
        } while (!b.a(this.f14921f, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    public void c(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.f14921f.get();
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
                        cacheSubscriptionArr2 = f14917m;
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
        } while (!b.a(this.f14921f, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    public void d(CacheSubscription<T> cacheSubscription) {
        boolean z11;
        CacheSubscription<T> cacheSubscription2 = cacheSubscription;
        if (cacheSubscription.getAndIncrement() == 0) {
            long j11 = cacheSubscription2.f14933g;
            int i11 = cacheSubscription2.f14932f;
            Node<T> node = cacheSubscription2.f14931e;
            AtomicLong atomicLong = cacheSubscription2.f14930d;
            Subscriber<? super T> subscriber = cacheSubscription2.f14928b;
            int i12 = this.f14920e;
            int i13 = 1;
            while (true) {
                boolean z12 = this.f14927l;
                if (this.f14922g == j11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z12 || !z11) {
                    if (!z11) {
                        long j12 = atomicLong.get();
                        if (j12 == Long.MIN_VALUE) {
                            cacheSubscription2.f14931e = null;
                            return;
                        } else if (j12 != j11) {
                            if (i11 == i12) {
                                node = node.f14935b;
                                i11 = 0;
                            }
                            subscriber.onNext(node.f14934a[i11]);
                            i11++;
                            j11++;
                        }
                    }
                    cacheSubscription2.f14933g = j11;
                    cacheSubscription2.f14932f = i11;
                    cacheSubscription2.f14931e = node;
                    i13 = cacheSubscription2.addAndGet(-i13);
                    if (i13 == 0) {
                        return;
                    }
                } else {
                    cacheSubscription2.f14931e = null;
                    Throwable th2 = this.f14926k;
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
        this.f14927l = true;
        for (CacheSubscription d11 : (CacheSubscription[]) this.f14921f.getAndSet(f14918n)) {
            d(d11);
        }
    }

    public void onError(Throwable th2) {
        if (this.f14927l) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f14926k = th2;
        this.f14927l = true;
        for (CacheSubscription d11 : (CacheSubscription[]) this.f14921f.getAndSet(f14918n)) {
            d(d11);
        }
    }

    public void onNext(T t11) {
        int i11 = this.f14925j;
        if (i11 == this.f14920e) {
            Node<T> node = new Node<>(i11);
            node.f14934a[0] = t11;
            this.f14925j = 1;
            this.f14924i.f14935b = node;
            this.f14924i = node;
        } else {
            this.f14924i.f14934a[i11] = t11;
            this.f14925j = i11 + 1;
        }
        this.f14922g++;
        for (CacheSubscription d11 : (CacheSubscription[]) this.f14921f.get()) {
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
        if (this.f14919d.get() || !this.f14919d.compareAndSet(false, true)) {
            d(cacheSubscription);
        } else {
            this.f14763c.subscribe(this);
        }
    }
}
