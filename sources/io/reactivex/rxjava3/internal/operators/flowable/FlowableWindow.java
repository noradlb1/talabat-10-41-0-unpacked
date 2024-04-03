package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.processors.UnicastProcessor;
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
    public final long f20591d;

    /* renamed from: e  reason: collision with root package name */
    public final long f20592e;

    /* renamed from: f  reason: collision with root package name */
    public final int f20593f;

    public static final class WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Flowable<T>> f20594b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20595c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicBoolean f20596d = new AtomicBoolean();

        /* renamed from: e  reason: collision with root package name */
        public final int f20597e;

        /* renamed from: f  reason: collision with root package name */
        public long f20598f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f20599g;

        /* renamed from: h  reason: collision with root package name */
        public UnicastProcessor<T> f20600h;

        public WindowExactSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, int i11) {
            super(1);
            this.f20594b = subscriber;
            this.f20595c = j11;
            this.f20597e = i11;
        }

        public void cancel() {
            if (this.f20596d.compareAndSet(false, true)) {
                run();
            }
        }

        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.f20600h;
            if (unicastProcessor != null) {
                this.f20600h = null;
                unicastProcessor.onComplete();
            }
            this.f20594b.onComplete();
        }

        public void onError(Throwable th2) {
            UnicastProcessor<T> unicastProcessor = this.f20600h;
            if (unicastProcessor != null) {
                this.f20600h = null;
                unicastProcessor.onError(th2);
            }
            this.f20594b.onError(th2);
        }

        public void onNext(T t11) {
            FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept;
            long j11 = this.f20598f;
            UnicastProcessor<T> unicastProcessor = this.f20600h;
            if (j11 == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.f20597e, this);
                this.f20600h = unicastProcessor;
                flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                this.f20594b.onNext(flowableWindowSubscribeIntercept);
            } else {
                flowableWindowSubscribeIntercept = null;
            }
            long j12 = j11 + 1;
            unicastProcessor.onNext(t11);
            if (j12 == this.f20595c) {
                this.f20598f = 0;
                this.f20600h = null;
                unicastProcessor.onComplete();
            } else {
                this.f20598f = j12;
            }
            if (flowableWindowSubscribeIntercept != null && flowableWindowSubscribeIntercept.b()) {
                flowableWindowSubscribeIntercept.f20669c.onComplete();
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20599g, subscription)) {
                this.f20599g = subscription;
                this.f20594b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                this.f20599g.request(BackpressureHelper.multiplyCap(this.f20595c, j11));
            }
        }

        public void run() {
            if (decrementAndGet() == 0) {
                this.f20599g.cancel();
            }
        }
    }

    public static final class WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Flowable<T>> f20601b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<UnicastProcessor<T>> f20602c;

        /* renamed from: d  reason: collision with root package name */
        public final long f20603d;

        /* renamed from: e  reason: collision with root package name */
        public final long f20604e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayDeque<UnicastProcessor<T>> f20605f = new ArrayDeque<>();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicBoolean f20606g = new AtomicBoolean();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f20607h = new AtomicBoolean();

        /* renamed from: i  reason: collision with root package name */
        public final AtomicLong f20608i = new AtomicLong();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicInteger f20609j = new AtomicInteger();

        /* renamed from: k  reason: collision with root package name */
        public final int f20610k;

        /* renamed from: l  reason: collision with root package name */
        public long f20611l;

        /* renamed from: m  reason: collision with root package name */
        public long f20612m;

        /* renamed from: n  reason: collision with root package name */
        public Subscription f20613n;

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f20614o;

        /* renamed from: p  reason: collision with root package name */
        public Throwable f20615p;

        /* renamed from: q  reason: collision with root package name */
        public volatile boolean f20616q;

        public WindowOverlapSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, long j12, int i11) {
            super(1);
            this.f20601b = subscriber;
            this.f20603d = j11;
            this.f20604e = j12;
            this.f20602c = new SpscLinkedArrayQueue<>(i11);
            this.f20610k = i11;
        }

        public boolean a(boolean z11, boolean z12, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (!z11) {
                return false;
            }
            Throwable th2 = this.f20615p;
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

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
            if (r10 != 0) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
            if (r15.f20616q == false) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x006e, code lost:
            if (a(r15.f20614o, r1.isEmpty(), r0, r1) == false) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
            if (r8 == 0) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x007c, code lost:
            if (r4 == Long.MAX_VALUE) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x007e, code lost:
            r15.f20608i.addAndGet(-r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x000f, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r15 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r15.f20609j
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super io.reactivex.rxjava3.core.Flowable<T>> r0 = r15.f20601b
                io.reactivex.rxjava3.operators.SpscLinkedArrayQueue<io.reactivex.rxjava3.processors.UnicastProcessor<T>> r1 = r15.f20602c
                r2 = 1
                r3 = r2
            L_0x000f:
                boolean r4 = r15.f20616q
                if (r4 == 0) goto L_0x001f
            L_0x0013:
                java.lang.Object r4 = r1.poll()
                io.reactivex.rxjava3.processors.UnicastProcessor r4 = (io.reactivex.rxjava3.processors.UnicastProcessor) r4
                if (r4 == 0) goto L_0x0084
                r4.onComplete()
                goto L_0x0013
            L_0x001f:
                java.util.concurrent.atomic.AtomicLong r4 = r15.f20608i
                long r4 = r4.get()
                r6 = 0
                r8 = r6
            L_0x0028:
                int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r10 == 0) goto L_0x005d
                boolean r11 = r15.f20614o
                java.lang.Object r12 = r1.poll()
                io.reactivex.rxjava3.processors.UnicastProcessor r12 = (io.reactivex.rxjava3.processors.UnicastProcessor) r12
                if (r12 != 0) goto L_0x0038
                r13 = r2
                goto L_0x0039
            L_0x0038:
                r13 = 0
            L_0x0039:
                boolean r14 = r15.f20616q
                if (r14 == 0) goto L_0x003e
                goto L_0x000f
            L_0x003e:
                boolean r11 = r15.a(r11, r13, r0, r1)
                if (r11 == 0) goto L_0x0045
                return
            L_0x0045:
                if (r13 == 0) goto L_0x0048
                goto L_0x005d
            L_0x0048:
                io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowSubscribeIntercept r10 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowSubscribeIntercept
                r10.<init>(r12)
                r0.onNext(r10)
                boolean r10 = r10.b()
                if (r10 == 0) goto L_0x0059
                r12.onComplete()
            L_0x0059:
                r10 = 1
                long r8 = r8 + r10
                goto L_0x0028
            L_0x005d:
                if (r10 != 0) goto L_0x0071
                boolean r10 = r15.f20616q
                if (r10 == 0) goto L_0x0064
                goto L_0x000f
            L_0x0064:
                boolean r10 = r15.f20614o
                boolean r11 = r1.isEmpty()
                boolean r10 = r15.a(r10, r11, r0, r1)
                if (r10 == 0) goto L_0x0071
                return
            L_0x0071:
                int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r6 == 0) goto L_0x0084
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 == 0) goto L_0x0084
                java.util.concurrent.atomic.AtomicLong r4 = r15.f20608i
                long r5 = -r8
                r4.addAndGet(r5)
            L_0x0084:
                java.util.concurrent.atomic.AtomicInteger r4 = r15.f20609j
                int r3 = -r3
                int r3 = r4.addAndGet(r3)
                if (r3 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow.WindowOverlapSubscriber.b():void");
        }

        public void cancel() {
            this.f20616q = true;
            if (this.f20606g.compareAndSet(false, true)) {
                run();
            }
            b();
        }

        public void onComplete() {
            Iterator<UnicastProcessor<T>> it = this.f20605f.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.f20605f.clear();
            this.f20614o = true;
            b();
        }

        public void onError(Throwable th2) {
            Iterator<UnicastProcessor<T>> it = this.f20605f.iterator();
            while (it.hasNext()) {
                it.next().onError(th2);
            }
            this.f20605f.clear();
            this.f20615p = th2;
            this.f20614o = true;
            b();
        }

        public void onNext(T t11) {
            UnicastProcessor unicastProcessor;
            long j11 = this.f20611l;
            if (j11 != 0 || this.f20616q) {
                unicastProcessor = null;
            } else {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.f20610k, this);
                this.f20605f.offer(unicastProcessor);
            }
            long j12 = j11 + 1;
            Iterator<UnicastProcessor<T>> it = this.f20605f.iterator();
            while (it.hasNext()) {
                it.next().onNext(t11);
            }
            if (unicastProcessor != null) {
                this.f20602c.offer(unicastProcessor);
                b();
            }
            long j13 = this.f20612m + 1;
            if (j13 == this.f20603d) {
                this.f20612m = j13 - this.f20604e;
                Processor poll = this.f20605f.poll();
                if (poll != null) {
                    poll.onComplete();
                }
            } else {
                this.f20612m = j13;
            }
            if (j12 == this.f20604e) {
                this.f20611l = 0;
            } else {
                this.f20611l = j12;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20613n, subscription)) {
                this.f20613n = subscription;
                this.f20601b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20608i, j11);
                if (this.f20607h.get() || !this.f20607h.compareAndSet(false, true)) {
                    this.f20613n.request(BackpressureHelper.multiplyCap(this.f20604e, j11));
                } else {
                    this.f20613n.request(BackpressureHelper.addCap(this.f20603d, BackpressureHelper.multiplyCap(this.f20604e, j11 - 1)));
                }
                b();
            }
        }

        public void run() {
            if (decrementAndGet() == 0) {
                this.f20613n.cancel();
            }
        }
    }

    public static final class WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Flowable<T>> f20617b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20618c;

        /* renamed from: d  reason: collision with root package name */
        public final long f20619d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f20620e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicBoolean f20621f = new AtomicBoolean();

        /* renamed from: g  reason: collision with root package name */
        public final int f20622g;

        /* renamed from: h  reason: collision with root package name */
        public long f20623h;

        /* renamed from: i  reason: collision with root package name */
        public Subscription f20624i;

        /* renamed from: j  reason: collision with root package name */
        public UnicastProcessor<T> f20625j;

        public WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, long j12, int i11) {
            super(1);
            this.f20617b = subscriber;
            this.f20618c = j11;
            this.f20619d = j12;
            this.f20622g = i11;
        }

        public void cancel() {
            if (this.f20620e.compareAndSet(false, true)) {
                run();
            }
        }

        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.f20625j;
            if (unicastProcessor != null) {
                this.f20625j = null;
                unicastProcessor.onComplete();
            }
            this.f20617b.onComplete();
        }

        public void onError(Throwable th2) {
            UnicastProcessor<T> unicastProcessor = this.f20625j;
            if (unicastProcessor != null) {
                this.f20625j = null;
                unicastProcessor.onError(th2);
            }
            this.f20617b.onError(th2);
        }

        public void onNext(T t11) {
            FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept;
            long j11 = this.f20623h;
            UnicastProcessor<T> unicastProcessor = this.f20625j;
            if (j11 == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.f20622g, this);
                this.f20625j = unicastProcessor;
                flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                this.f20617b.onNext(flowableWindowSubscribeIntercept);
            } else {
                flowableWindowSubscribeIntercept = null;
            }
            long j12 = j11 + 1;
            if (unicastProcessor != null) {
                unicastProcessor.onNext(t11);
            }
            if (j12 == this.f20618c) {
                this.f20625j = null;
                unicastProcessor.onComplete();
            }
            if (j12 == this.f20619d) {
                this.f20623h = 0;
            } else {
                this.f20623h = j12;
            }
            if (flowableWindowSubscribeIntercept != null && flowableWindowSubscribeIntercept.b()) {
                flowableWindowSubscribeIntercept.f20669c.onComplete();
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20624i, subscription)) {
                this.f20624i = subscription;
                this.f20617b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (!SubscriptionHelper.validate(j11)) {
                return;
            }
            if (this.f20621f.get() || !this.f20621f.compareAndSet(false, true)) {
                this.f20624i.request(BackpressureHelper.multiplyCap(this.f20619d, j11));
                return;
            }
            this.f20624i.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(this.f20618c, j11), BackpressureHelper.multiplyCap(this.f20619d - this.f20618c, j11 - 1)));
        }

        public void run() {
            if (decrementAndGet() == 0) {
                this.f20624i.cancel();
            }
        }
    }

    public FlowableWindow(Flowable<T> flowable, long j11, long j12, int i11) {
        super(flowable);
        this.f20591d = j11;
        this.f20592e = j12;
        this.f20593f = i11;
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        long j11 = this.f20592e;
        long j12 = this.f20591d;
        if (j11 == j12) {
            this.f19260c.subscribe(new WindowExactSubscriber(subscriber, this.f20591d, this.f20593f));
        } else if (j11 > j12) {
            this.f19260c.subscribe(new WindowSkipSubscriber(subscriber, this.f20591d, this.f20592e, this.f20593f));
        } else {
            this.f19260c.subscribe(new WindowOverlapSubscriber(subscriber, this.f20591d, this.f20592e, this.f20593f));
        }
    }
}
