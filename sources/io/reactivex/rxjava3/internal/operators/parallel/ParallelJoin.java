package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelJoin<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final ParallelFlowable<? extends T> f22648c;

    /* renamed from: d  reason: collision with root package name */
    public final int f22649d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f22650e;

    public static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;

        /* renamed from: b  reason: collision with root package name */
        public final JoinSubscriptionBase<T> f22651b;

        /* renamed from: c  reason: collision with root package name */
        public final int f22652c;

        /* renamed from: d  reason: collision with root package name */
        public final int f22653d;

        /* renamed from: e  reason: collision with root package name */
        public long f22654e;

        /* renamed from: f  reason: collision with root package name */
        public volatile SimplePlainQueue<T> f22655f;

        public JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i11) {
            this.f22651b = joinSubscriptionBase;
            this.f22652c = i11;
            this.f22653d = i11 - (i11 >> 2);
        }

        public SimplePlainQueue<T> a() {
            SimplePlainQueue<T> simplePlainQueue = this.f22655f;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f22652c);
            this.f22655f = spscArrayQueue;
            return spscArrayQueue;
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f22651b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22651b.onError(th2);
        }

        public void onNext(T t11) {
            this.f22651b.onNext(this, t11);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, (long) this.f22652c);
        }

        public void request(long j11) {
            long j12 = this.f22654e + j11;
            if (j12 >= ((long) this.f22653d)) {
                this.f22654e = 0;
                ((Subscription) get()).request(j12);
                return;
            }
            this.f22654e = j12;
        }

        public void requestOne() {
            long j11 = this.f22654e + 1;
            if (j11 == ((long) this.f22653d)) {
                this.f22654e = 0;
                ((Subscription) get()).request(j11);
                return;
            }
            this.f22654e = j11;
        }
    }

    public static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        public JoinSubscription(Subscriber<? super T> subscriber, int i11, int i12) {
            super(subscriber, i11, i12);
        }

        public void c() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
            if (r12 == false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
            if (r15 == false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
            if (r15 == false) goto L_0x0011;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d() {
            /*
                r18 = this;
                r0 = r18
                io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber<T>[] r1 = r0.f22657c
                int r2 = r1.length
                org.reactivestreams.Subscriber<? super T> r3 = r0.f22656b
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.f22659e
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r12 == 0) goto L_0x0067
                boolean r12 = r0.f22660f
                if (r12 == 0) goto L_0x001d
                r18.b()
                return
            L_0x001d:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r12 = r0.f22658d
                java.lang.Object r12 = r12.get()
                java.lang.Throwable r12 = (java.lang.Throwable) r12
                if (r12 == 0) goto L_0x002e
                r18.b()
                r3.onError(r12)
                return
            L_0x002e:
                java.util.concurrent.atomic.AtomicInteger r12 = r0.f22661g
                int r12 = r12.get()
                if (r12 != 0) goto L_0x0038
                r12 = 1
                goto L_0x0039
            L_0x0038:
                r12 = 0
            L_0x0039:
                r14 = 0
                r15 = 1
            L_0x003b:
                int r4 = r1.length
                if (r14 >= r4) goto L_0x005d
                r4 = r1[r14]
                io.reactivex.rxjava3.operators.SimplePlainQueue<T> r13 = r4.f22655f
                if (r13 == 0) goto L_0x005a
                java.lang.Object r13 = r13.poll()
                if (r13 == 0) goto L_0x005a
                r3.onNext(r13)
                r4.requestOne()
                r16 = 1
                long r10 = r10 + r16
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0059
                goto L_0x0067
            L_0x0059:
                r15 = 0
            L_0x005a:
                int r14 = r14 + 1
                goto L_0x003b
            L_0x005d:
                if (r12 == 0) goto L_0x0065
                if (r15 == 0) goto L_0x0065
                r3.onComplete()
                return
            L_0x0065:
                if (r15 == 0) goto L_0x0011
            L_0x0067:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x00ac
                boolean r4 = r0.f22660f
                if (r4 == 0) goto L_0x0073
                r18.b()
                return
            L_0x0073:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r4 = r0.f22658d
                java.lang.Object r4 = r4.get()
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                if (r4 == 0) goto L_0x0084
                r18.b()
                r3.onError(r4)
                return
            L_0x0084:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.f22661g
                int r4 = r4.get()
                if (r4 != 0) goto L_0x008e
                r4 = 1
                goto L_0x008f
            L_0x008e:
                r4 = 0
            L_0x008f:
                r6 = 0
            L_0x0090:
                if (r6 >= r2) goto L_0x00a3
                r7 = r1[r6]
                io.reactivex.rxjava3.operators.SimplePlainQueue<T> r7 = r7.f22655f
                if (r7 == 0) goto L_0x00a0
                boolean r7 = r7.isEmpty()
                if (r7 != 0) goto L_0x00a0
                r13 = 0
                goto L_0x00a4
            L_0x00a0:
                int r6 = r6 + 1
                goto L_0x0090
            L_0x00a3:
                r13 = 1
            L_0x00a4:
                if (r4 == 0) goto L_0x00ac
                if (r13 == 0) goto L_0x00ac
                r3.onComplete()
                return
            L_0x00ac:
                int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00b5
                java.util.concurrent.atomic.AtomicLong r4 = r0.f22659e
                io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r4, r10)
            L_0x00b5:
                int r4 = -r5
                int r5 = r0.addAndGet(r4)
                if (r5 != 0) goto L_0x0008
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscription.d():void");
        }

        public void onComplete() {
            this.f22661g.decrementAndGet();
            c();
        }

        public void onError(Throwable th2) {
            if (this.f22658d.compareAndSet((Object) null, th2)) {
                a();
                c();
            } else if (th2 != this.f22658d.get()) {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t11) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.f22659e.get() != 0) {
                    this.f22656b.onNext(t11);
                    if (this.f22659e.get() != Long.MAX_VALUE) {
                        this.f22659e.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.a().offer(t11)) {
                    a();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.f22658d.compareAndSet((Object) null, missingBackpressureException)) {
                        this.f22656b.onError(missingBackpressureException);
                        return;
                    } else {
                        RxJavaPlugins.onError(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.a().offer(t11)) {
                a();
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            d();
        }
    }

    public static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f22656b;

        /* renamed from: c  reason: collision with root package name */
        public final JoinInnerSubscriber<T>[] f22657c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicThrowable f22658d = new AtomicThrowable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f22659e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f22660f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f22661g = new AtomicInteger();

        public JoinSubscriptionBase(Subscriber<? super T> subscriber, int i11, int i12) {
            this.f22656b = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i11];
            for (int i13 = 0; i13 < i11; i13++) {
                joinInnerSubscriberArr[i13] = new JoinInnerSubscriber<>(this, i12);
            }
            this.f22657c = joinInnerSubscriberArr;
            this.f22661g.lazySet(i11);
        }

        public void a() {
            for (JoinInnerSubscriber<T> cancel : this.f22657c) {
                cancel.cancel();
            }
        }

        public void b() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.f22657c) {
                joinInnerSubscriber.f22655f = null;
            }
        }

        public abstract void c();

        public void cancel() {
            if (!this.f22660f) {
                this.f22660f = true;
                a();
                if (getAndIncrement() == 0) {
                    b();
                }
            }
        }

        public abstract void onComplete();

        public abstract void onError(Throwable th2);

        public abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t11);

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f22659e, j11);
                c();
            }
        }
    }

    public static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        public JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i11, int i12) {
            super(subscriber, i11, i12);
        }

        public void c() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
            if (r12 == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
            if (r15 == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
            r0.f22658d.tryTerminateConsumer((org.reactivestreams.Subscriber<?>) r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
            if (r15 == false) goto L_0x0011;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d() {
            /*
                r18 = this;
                r0 = r18
                io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber<T>[] r1 = r0.f22657c
                int r2 = r1.length
                org.reactivestreams.Subscriber<? super T> r3 = r0.f22656b
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.f22659e
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r12 == 0) goto L_0x0057
                boolean r12 = r0.f22660f
                if (r12 == 0) goto L_0x001d
                r18.b()
                return
            L_0x001d:
                java.util.concurrent.atomic.AtomicInteger r12 = r0.f22661g
                int r12 = r12.get()
                if (r12 != 0) goto L_0x0027
                r12 = 1
                goto L_0x0028
            L_0x0027:
                r12 = 0
            L_0x0028:
                r14 = 0
                r15 = 1
            L_0x002a:
                if (r14 >= r2) goto L_0x004b
                r4 = r1[r14]
                io.reactivex.rxjava3.operators.SimplePlainQueue<T> r13 = r4.f22655f
                if (r13 == 0) goto L_0x0048
                java.lang.Object r13 = r13.poll()
                if (r13 == 0) goto L_0x0048
                r3.onNext(r13)
                r4.requestOne()
                r16 = 1
                long r10 = r10 + r16
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0047
                goto L_0x0057
            L_0x0047:
                r15 = 0
            L_0x0048:
                int r14 = r14 + 1
                goto L_0x002a
            L_0x004b:
                if (r12 == 0) goto L_0x0055
                if (r15 == 0) goto L_0x0055
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r0.f22658d
                r1.tryTerminateConsumer((org.reactivestreams.Subscriber<?>) r3)
                return
            L_0x0055:
                if (r15 == 0) goto L_0x0011
            L_0x0057:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x008d
                boolean r4 = r0.f22660f
                if (r4 == 0) goto L_0x0063
                r18.b()
                return
            L_0x0063:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.f22661g
                int r4 = r4.get()
                if (r4 != 0) goto L_0x006d
                r4 = 1
                goto L_0x006e
            L_0x006d:
                r4 = 0
            L_0x006e:
                r6 = 0
            L_0x006f:
                if (r6 >= r2) goto L_0x0082
                r7 = r1[r6]
                io.reactivex.rxjava3.operators.SimplePlainQueue<T> r7 = r7.f22655f
                if (r7 == 0) goto L_0x007f
                boolean r7 = r7.isEmpty()
                if (r7 != 0) goto L_0x007f
                r13 = 0
                goto L_0x0083
            L_0x007f:
                int r6 = r6 + 1
                goto L_0x006f
            L_0x0082:
                r13 = 1
            L_0x0083:
                if (r4 == 0) goto L_0x008d
                if (r13 == 0) goto L_0x008d
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r0.f22658d
                r1.tryTerminateConsumer((org.reactivestreams.Subscriber<?>) r3)
                return
            L_0x008d:
                int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x0096
                java.util.concurrent.atomic.AtomicLong r4 = r0.f22659e
                io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r4, r10)
            L_0x0096:
                int r4 = -r5
                int r5 = r0.addAndGet(r4)
                if (r5 != 0) goto L_0x0008
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.JoinSubscriptionDelayError.d():void");
        }

        public void onComplete() {
            this.f22661g.decrementAndGet();
            c();
        }

        public void onError(Throwable th2) {
            if (this.f22658d.tryAddThrowableOrReport(th2)) {
                this.f22661g.decrementAndGet();
                c();
            }
        }

        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t11) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                if (!joinInnerSubscriber.a().offer(t11)) {
                    joinInnerSubscriber.cancel();
                    this.f22658d.tryAddThrowableOrReport(new MissingBackpressureException("Queue full?!"));
                    this.f22661g.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                if (this.f22659e.get() != 0) {
                    this.f22656b.onNext(t11);
                    if (this.f22659e.get() != Long.MAX_VALUE) {
                        this.f22659e.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.a().offer(t11)) {
                    joinInnerSubscriber.cancel();
                    this.f22658d.tryAddThrowableOrReport(new MissingBackpressureException("Queue full?!"));
                    this.f22661g.decrementAndGet();
                    d();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            d();
        }
    }

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i11, boolean z11) {
        this.f22648c = parallelFlowable;
        this.f22649d = i11;
        this.f22650e = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscriptionBase;
        if (this.f22650e) {
            joinSubscriptionBase = new JoinSubscriptionDelayError(subscriber, this.f22648c.parallelism(), this.f22649d);
        } else {
            joinSubscriptionBase = new JoinSubscription(subscriber, this.f22648c.parallelism(), this.f22649d);
        }
        subscriber.onSubscribe(joinSubscriptionBase);
        this.f22648c.subscribe(joinSubscriptionBase.f22657c);
    }
}
