package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindow<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* renamed from: d  reason: collision with root package name */
    public final long f16083d;

    /* renamed from: e  reason: collision with root package name */
    public final long f16084e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16085f;

    public static final class WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Flowable<T>> f16086b;

        /* renamed from: c  reason: collision with root package name */
        public final long f16087c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicBoolean f16088d = new AtomicBoolean();

        /* renamed from: e  reason: collision with root package name */
        public final int f16089e;

        /* renamed from: f  reason: collision with root package name */
        public long f16090f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f16091g;

        /* renamed from: h  reason: collision with root package name */
        public UnicastProcessor<T> f16092h;

        public WindowExactSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, int i11) {
            super(1);
            this.f16086b = subscriber;
            this.f16087c = j11;
            this.f16089e = i11;
        }

        public void cancel() {
            if (this.f16088d.compareAndSet(false, true)) {
                run();
            }
        }

        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.f16092h;
            if (unicastProcessor != null) {
                this.f16092h = null;
                unicastProcessor.onComplete();
            }
            this.f16086b.onComplete();
        }

        public void onError(Throwable th2) {
            UnicastProcessor<T> unicastProcessor = this.f16092h;
            if (unicastProcessor != null) {
                this.f16092h = null;
                unicastProcessor.onError(th2);
            }
            this.f16086b.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f16090f;
            UnicastProcessor<T> unicastProcessor = this.f16092h;
            if (j11 == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.f16089e, this);
                this.f16092h = unicastProcessor;
                this.f16086b.onNext(unicastProcessor);
            }
            long j12 = j11 + 1;
            unicastProcessor.onNext(t11);
            if (j12 == this.f16087c) {
                this.f16090f = 0;
                this.f16092h = null;
                unicastProcessor.onComplete();
                return;
            }
            this.f16090f = j12;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16091g, subscription)) {
                this.f16091g = subscription;
                this.f16086b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                this.f16091g.request(BackpressureHelper.multiplyCap(this.f16087c, j11));
            }
        }

        public void run() {
            if (decrementAndGet() == 0) {
                this.f16091g.cancel();
            }
        }
    }

    public static final class WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Flowable<T>> f16093b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<UnicastProcessor<T>> f16094c;

        /* renamed from: d  reason: collision with root package name */
        public final long f16095d;

        /* renamed from: e  reason: collision with root package name */
        public final long f16096e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayDeque<UnicastProcessor<T>> f16097f = new ArrayDeque<>();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicBoolean f16098g = new AtomicBoolean();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f16099h = new AtomicBoolean();

        /* renamed from: i  reason: collision with root package name */
        public final AtomicLong f16100i = new AtomicLong();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicInteger f16101j = new AtomicInteger();

        /* renamed from: k  reason: collision with root package name */
        public final int f16102k;

        /* renamed from: l  reason: collision with root package name */
        public long f16103l;

        /* renamed from: m  reason: collision with root package name */
        public long f16104m;

        /* renamed from: n  reason: collision with root package name */
        public Subscription f16105n;

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f16106o;

        /* renamed from: p  reason: collision with root package name */
        public Throwable f16107p;

        /* renamed from: q  reason: collision with root package name */
        public volatile boolean f16108q;

        public WindowOverlapSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, long j12, int i11) {
            super(1);
            this.f16093b = subscriber;
            this.f16095d = j11;
            this.f16096e = j12;
            this.f16094c = new SpscLinkedArrayQueue<>(i11);
            this.f16102k = i11;
        }

        public boolean a(boolean z11, boolean z12, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.f16108q) {
                spscLinkedArrayQueue.clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                Throwable th2 = this.f16107p;
                if (th2 != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th2);
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        public void b() {
            int i11;
            boolean z11;
            if (this.f16101j.getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.f16093b;
                SpscLinkedArrayQueue<UnicastProcessor<T>> spscLinkedArrayQueue = this.f16094c;
                int i12 = 1;
                do {
                    long j11 = this.f16100i.get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        }
                        boolean z12 = this.f16106o;
                        UnicastProcessor poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!a(z12, z11, subscriber, spscLinkedArrayQueue)) {
                            if (z11) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j12++;
                        } else {
                            return;
                        }
                    }
                    if (i11 != 0 || !a(this.f16106o, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                        if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                            this.f16100i.addAndGet(-j12);
                        }
                        i12 = this.f16101j.addAndGet(-i12);
                    } else {
                        return;
                    }
                } while (i12 != 0);
            }
        }

        public void cancel() {
            this.f16108q = true;
            if (this.f16098g.compareAndSet(false, true)) {
                run();
            }
        }

        public void onComplete() {
            if (!this.f16106o) {
                Iterator<UnicastProcessor<T>> it = this.f16097f.iterator();
                while (it.hasNext()) {
                    it.next().onComplete();
                }
                this.f16097f.clear();
                this.f16106o = true;
                b();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16106o) {
                RxJavaPlugins.onError(th2);
                return;
            }
            Iterator<UnicastProcessor<T>> it = this.f16097f.iterator();
            while (it.hasNext()) {
                it.next().onError(th2);
            }
            this.f16097f.clear();
            this.f16107p = th2;
            this.f16106o = true;
            b();
        }

        public void onNext(T t11) {
            if (!this.f16106o) {
                long j11 = this.f16103l;
                if (j11 == 0 && !this.f16108q) {
                    getAndIncrement();
                    UnicastProcessor create = UnicastProcessor.create(this.f16102k, this);
                    this.f16097f.offer(create);
                    this.f16094c.offer(create);
                    b();
                }
                long j12 = j11 + 1;
                Iterator<UnicastProcessor<T>> it = this.f16097f.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t11);
                }
                long j13 = this.f16104m + 1;
                if (j13 == this.f16095d) {
                    this.f16104m = j13 - this.f16096e;
                    Processor poll = this.f16097f.poll();
                    if (poll != null) {
                        poll.onComplete();
                    }
                } else {
                    this.f16104m = j13;
                }
                if (j12 == this.f16096e) {
                    this.f16103l = 0;
                } else {
                    this.f16103l = j12;
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16105n, subscription)) {
                this.f16105n = subscription;
                this.f16093b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f16100i, j11);
                if (this.f16099h.get() || !this.f16099h.compareAndSet(false, true)) {
                    this.f16105n.request(BackpressureHelper.multiplyCap(this.f16096e, j11));
                } else {
                    this.f16105n.request(BackpressureHelper.addCap(this.f16095d, BackpressureHelper.multiplyCap(this.f16096e, j11 - 1)));
                }
                b();
            }
        }

        public void run() {
            if (decrementAndGet() == 0) {
                this.f16105n.cancel();
            }
        }
    }

    public static final class WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Flowable<T>> f16109b;

        /* renamed from: c  reason: collision with root package name */
        public final long f16110c;

        /* renamed from: d  reason: collision with root package name */
        public final long f16111d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f16112e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicBoolean f16113f = new AtomicBoolean();

        /* renamed from: g  reason: collision with root package name */
        public final int f16114g;

        /* renamed from: h  reason: collision with root package name */
        public long f16115h;

        /* renamed from: i  reason: collision with root package name */
        public Subscription f16116i;

        /* renamed from: j  reason: collision with root package name */
        public UnicastProcessor<T> f16117j;

        public WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, long j12, int i11) {
            super(1);
            this.f16109b = subscriber;
            this.f16110c = j11;
            this.f16111d = j12;
            this.f16114g = i11;
        }

        public void cancel() {
            if (this.f16112e.compareAndSet(false, true)) {
                run();
            }
        }

        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.f16117j;
            if (unicastProcessor != null) {
                this.f16117j = null;
                unicastProcessor.onComplete();
            }
            this.f16109b.onComplete();
        }

        public void onError(Throwable th2) {
            UnicastProcessor<T> unicastProcessor = this.f16117j;
            if (unicastProcessor != null) {
                this.f16117j = null;
                unicastProcessor.onError(th2);
            }
            this.f16109b.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f16115h;
            UnicastProcessor<T> unicastProcessor = this.f16117j;
            if (j11 == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.f16114g, this);
                this.f16117j = unicastProcessor;
                this.f16109b.onNext(unicastProcessor);
            }
            long j12 = j11 + 1;
            if (unicastProcessor != null) {
                unicastProcessor.onNext(t11);
            }
            if (j12 == this.f16110c) {
                this.f16117j = null;
                unicastProcessor.onComplete();
            }
            if (j12 == this.f16111d) {
                this.f16115h = 0;
            } else {
                this.f16115h = j12;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16116i, subscription)) {
                this.f16116i = subscription;
                this.f16109b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (!SubscriptionHelper.validate(j11)) {
                return;
            }
            if (this.f16113f.get() || !this.f16113f.compareAndSet(false, true)) {
                this.f16116i.request(BackpressureHelper.multiplyCap(this.f16111d, j11));
                return;
            }
            this.f16116i.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(this.f16110c, j11), BackpressureHelper.multiplyCap(this.f16111d - this.f16110c, j11 - 1)));
        }

        public void run() {
            if (decrementAndGet() == 0) {
                this.f16116i.cancel();
            }
        }
    }

    public FlowableWindow(Flowable<T> flowable, long j11, long j12, int i11) {
        super(flowable);
        this.f16083d = j11;
        this.f16084e = j12;
        this.f16085f = i11;
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        long j11 = this.f16084e;
        long j12 = this.f16083d;
        if (j11 == j12) {
            this.f14763c.subscribe(new WindowExactSubscriber(subscriber, this.f16083d, this.f16085f));
        } else if (j11 > j12) {
            this.f14763c.subscribe(new WindowSkipSubscriber(subscriber, this.f16083d, this.f16084e, this.f16085f));
        } else {
            this.f14763c.subscribe(new WindowOverlapSubscriber(subscriber, this.f16083d, this.f16084e, this.f16085f));
        }
    }
}
