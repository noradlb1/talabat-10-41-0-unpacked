package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelJoin<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final ParallelFlowable<? extends T> f18114c;

    /* renamed from: d  reason: collision with root package name */
    public final int f18115d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f18116e;

    public static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;

        /* renamed from: b  reason: collision with root package name */
        public final JoinSubscriptionBase<T> f18117b;

        /* renamed from: c  reason: collision with root package name */
        public final int f18118c;

        /* renamed from: d  reason: collision with root package name */
        public final int f18119d;

        /* renamed from: e  reason: collision with root package name */
        public long f18120e;

        /* renamed from: f  reason: collision with root package name */
        public volatile SimplePlainQueue<T> f18121f;

        public JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i11) {
            this.f18117b = joinSubscriptionBase;
            this.f18118c = i11;
            this.f18119d = i11 - (i11 >> 2);
        }

        public SimplePlainQueue<T> a() {
            SimplePlainQueue<T> simplePlainQueue = this.f18121f;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f18118c);
            this.f18121f = spscArrayQueue;
            return spscArrayQueue;
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f18117b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f18117b.onError(th2);
        }

        public void onNext(T t11) {
            this.f18117b.onNext(this, t11);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, (long) this.f18118c);
        }

        public void request(long j11) {
            long j12 = this.f18120e + j11;
            if (j12 >= ((long) this.f18119d)) {
                this.f18120e = 0;
                ((Subscription) get()).request(j12);
                return;
            }
            this.f18120e = j12;
        }

        public void requestOne() {
            long j11 = this.f18120e + 1;
            if (j11 == ((long) this.f18119d)) {
                this.f18120e = 0;
                ((Subscription) get()).request(j11);
                return;
            }
            this.f18120e = j11;
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
                io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber<T>[] r1 = r0.f18123c
                int r2 = r1.length
                org.reactivestreams.Subscriber<? super T> r3 = r0.f18122b
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.f18125e
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r12 == 0) goto L_0x0067
                boolean r12 = r0.f18126f
                if (r12 == 0) goto L_0x001d
                r18.b()
                return
            L_0x001d:
                io.reactivex.internal.util.AtomicThrowable r12 = r0.f18124d
                java.lang.Object r12 = r12.get()
                java.lang.Throwable r12 = (java.lang.Throwable) r12
                if (r12 == 0) goto L_0x002e
                r18.b()
                r3.onError(r12)
                return
            L_0x002e:
                java.util.concurrent.atomic.AtomicInteger r12 = r0.f18127g
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
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r4.f18121f
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
                boolean r4 = r0.f18126f
                if (r4 == 0) goto L_0x0073
                r18.b()
                return
            L_0x0073:
                io.reactivex.internal.util.AtomicThrowable r4 = r0.f18124d
                java.lang.Object r4 = r4.get()
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                if (r4 == 0) goto L_0x0084
                r18.b()
                r3.onError(r4)
                return
            L_0x0084:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.f18127g
                int r4 = r4.get()
                if (r4 != 0) goto L_0x008e
                r4 = 1
                goto L_0x008f
            L_0x008e:
                r4 = 0
            L_0x008f:
                r12 = 0
            L_0x0090:
                if (r12 >= r2) goto L_0x00a3
                r13 = r1[r12]
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r13.f18121f
                if (r13 == 0) goto L_0x00a0
                boolean r13 = r13.isEmpty()
                if (r13 != 0) goto L_0x00a0
                r13 = 0
                goto L_0x00a4
            L_0x00a0:
                int r12 = r12 + 1
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
                if (r4 == 0) goto L_0x00bf
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00bf
                java.util.concurrent.atomic.AtomicLong r4 = r0.f18125e
                long r6 = -r10
                r4.addAndGet(r6)
            L_0x00bf:
                int r4 = r18.get()
                if (r4 != r5) goto L_0x00cd
                int r4 = -r5
                int r4 = r0.addAndGet(r4)
                if (r4 != 0) goto L_0x00cd
                return
            L_0x00cd:
                r5 = r4
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscription.d():void");
        }

        public void onComplete() {
            this.f18127g.decrementAndGet();
            c();
        }

        public void onError(Throwable th2) {
            if (this.f18124d.compareAndSet((Object) null, th2)) {
                a();
                c();
            } else if (th2 != this.f18124d.get()) {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t11) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.f18125e.get() != 0) {
                    this.f18122b.onNext(t11);
                    if (this.f18125e.get() != Long.MAX_VALUE) {
                        this.f18125e.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.a().offer(t11)) {
                    a();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.f18124d.compareAndSet((Object) null, missingBackpressureException)) {
                        this.f18122b.onError(missingBackpressureException);
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
        public final Subscriber<? super T> f18122b;

        /* renamed from: c  reason: collision with root package name */
        public final JoinInnerSubscriber<T>[] f18123c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicThrowable f18124d = new AtomicThrowable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f18125e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f18126f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f18127g = new AtomicInteger();

        public JoinSubscriptionBase(Subscriber<? super T> subscriber, int i11, int i12) {
            this.f18122b = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i11];
            for (int i13 = 0; i13 < i11; i13++) {
                joinInnerSubscriberArr[i13] = new JoinInnerSubscriber<>(this, i12);
            }
            this.f18123c = joinInnerSubscriberArr;
            this.f18127g.lazySet(i11);
        }

        public void a() {
            for (JoinInnerSubscriber<T> cancel : this.f18123c) {
                cancel.cancel();
            }
        }

        public void b() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.f18123c) {
                joinInnerSubscriber.f18121f = null;
            }
        }

        public abstract void c();

        public void cancel() {
            if (!this.f18126f) {
                this.f18126f = true;
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
                BackpressureHelper.add(this.f18125e, j11);
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
            if (r12 == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
            if (r15 == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
            if (((java.lang.Throwable) r0.f18124d.get()) == null) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
            r3.onError(r0.f18124d.terminate());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
            if (r15 == false) goto L_0x0011;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d() {
            /*
                r18 = this;
                r0 = r18
                io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber<T>[] r1 = r0.f18123c
                int r2 = r1.length
                org.reactivestreams.Subscriber<? super T> r3 = r0.f18122b
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.f18125e
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r12 == 0) goto L_0x0069
                boolean r12 = r0.f18126f
                if (r12 == 0) goto L_0x001d
                r18.b()
                return
            L_0x001d:
                java.util.concurrent.atomic.AtomicInteger r12 = r0.f18127g
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
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r4.f18121f
                if (r13 == 0) goto L_0x0048
                java.lang.Object r13 = r13.poll()
                if (r13 == 0) goto L_0x0048
                r3.onNext(r13)
                r4.requestOne()
                r16 = 1
                long r10 = r10 + r16
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0047
                goto L_0x0069
            L_0x0047:
                r15 = 0
            L_0x0048:
                int r14 = r14 + 1
                goto L_0x002a
            L_0x004b:
                if (r12 == 0) goto L_0x0067
                if (r15 == 0) goto L_0x0067
                io.reactivex.internal.util.AtomicThrowable r1 = r0.f18124d
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x0063
                io.reactivex.internal.util.AtomicThrowable r1 = r0.f18124d
                java.lang.Throwable r1 = r1.terminate()
                r3.onError(r1)
                goto L_0x0066
            L_0x0063:
                r3.onComplete()
            L_0x0066:
                return
            L_0x0067:
                if (r15 == 0) goto L_0x0011
            L_0x0069:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x00b1
                boolean r4 = r0.f18126f
                if (r4 == 0) goto L_0x0075
                r18.b()
                return
            L_0x0075:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.f18127g
                int r4 = r4.get()
                if (r4 != 0) goto L_0x007f
                r4 = 1
                goto L_0x0080
            L_0x007f:
                r4 = 0
            L_0x0080:
                r12 = 0
            L_0x0081:
                if (r12 >= r2) goto L_0x0094
                r13 = r1[r12]
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r13.f18121f
                if (r13 == 0) goto L_0x0091
                boolean r13 = r13.isEmpty()
                if (r13 != 0) goto L_0x0091
                r13 = 0
                goto L_0x0095
            L_0x0091:
                int r12 = r12 + 1
                goto L_0x0081
            L_0x0094:
                r13 = 1
            L_0x0095:
                if (r4 == 0) goto L_0x00b1
                if (r13 == 0) goto L_0x00b1
                io.reactivex.internal.util.AtomicThrowable r1 = r0.f18124d
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x00ad
                io.reactivex.internal.util.AtomicThrowable r1 = r0.f18124d
                java.lang.Throwable r1 = r1.terminate()
                r3.onError(r1)
                goto L_0x00b0
            L_0x00ad:
                r3.onComplete()
            L_0x00b0:
                return
            L_0x00b1:
                int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00c4
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00c4
                java.util.concurrent.atomic.AtomicLong r4 = r0.f18125e
                long r6 = -r10
                r4.addAndGet(r6)
            L_0x00c4:
                int r4 = r18.get()
                if (r4 != r5) goto L_0x00d2
                int r4 = -r5
                int r4 = r0.addAndGet(r4)
                if (r4 != 0) goto L_0x00d2
                return
            L_0x00d2:
                r5 = r4
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionDelayError.d():void");
        }

        public void onComplete() {
            this.f18127g.decrementAndGet();
            c();
        }

        public void onError(Throwable th2) {
            this.f18124d.addThrowable(th2);
            this.f18127g.decrementAndGet();
            c();
        }

        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t11) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                if (!joinInnerSubscriber.a().offer(t11) && joinInnerSubscriber.cancel()) {
                    this.f18124d.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.f18127g.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                if (this.f18125e.get() != 0) {
                    this.f18122b.onNext(t11);
                    if (this.f18125e.get() != Long.MAX_VALUE) {
                        this.f18125e.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.a().offer(t11)) {
                    joinInnerSubscriber.cancel();
                    this.f18124d.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.f18127g.decrementAndGet();
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
        this.f18114c = parallelFlowable;
        this.f18115d = i11;
        this.f18116e = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscriptionBase;
        if (this.f18116e) {
            joinSubscriptionBase = new JoinSubscriptionDelayError(subscriber, this.f18114c.parallelism(), this.f18115d);
        } else {
            joinSubscriptionBase = new JoinSubscription(subscriber, this.f18114c.parallelism(), this.f18115d);
        }
        subscriber.onSubscribe(joinSubscriptionBase);
        this.f18114c.subscribe(joinSubscriptionBase.f18123c);
    }
}
