package io.reactivex.rxjava3.internal.operators.flowable;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f20417d;

    /* renamed from: e  reason: collision with root package name */
    public final int f20418e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f20419f;

    public static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;

        /* renamed from: b  reason: collision with root package name */
        public final SwitchMapSubscriber<T, R> f20420b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20421c;

        /* renamed from: d  reason: collision with root package name */
        public final int f20422d;

        /* renamed from: e  reason: collision with root package name */
        public volatile SimpleQueue<R> f20423e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f20424f;

        /* renamed from: g  reason: collision with root package name */
        public int f20425g;

        public SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j11, int i11) {
            this.f20420b = switchMapSubscriber;
            this.f20421c = j11;
            this.f20422d = i11;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.f20420b;
            if (this.f20421c == switchMapSubscriber.f20437l) {
                this.f20424f = true;
                switchMapSubscriber.b();
            }
        }

        public void onError(Throwable th2) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.f20420b;
            if (this.f20421c != switchMapSubscriber.f20437l || !switchMapSubscriber.f20432g.tryAddThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!switchMapSubscriber.f20430e) {
                switchMapSubscriber.f20434i.cancel();
                switchMapSubscriber.f20431f = true;
            }
            this.f20424f = true;
            switchMapSubscriber.b();
        }

        public void onNext(R r11) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.f20420b;
            if (this.f20421c != switchMapSubscriber.f20437l) {
                return;
            }
            if (this.f20425g != 0 || this.f20423e.offer(r11)) {
                switchMapSubscriber.b();
            } else {
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f20425g = requestFusion;
                        this.f20423e = queueSubscription;
                        this.f20424f = true;
                        this.f20420b.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.f20425g = requestFusion;
                        this.f20423e = queueSubscription;
                        subscription.request((long) this.f20422d);
                        return;
                    }
                }
                this.f20423e = new SpscArrayQueue(this.f20422d);
                subscription.request((long) this.f20422d);
            }
        }

        public void request(long j11) {
            if (this.f20425g != 1) {
                ((Subscription) get()).request(j11);
            }
        }
    }

    public static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: m  reason: collision with root package name */
        public static final SwitchMapInnerSubscriber<Object, Object> f20426m;
        private static final long serialVersionUID = -3491074160481096299L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f20427b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends R>> f20428c;

        /* renamed from: d  reason: collision with root package name */
        public final int f20429d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f20430e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f20431f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f20432g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f20433h;

        /* renamed from: i  reason: collision with root package name */
        public Subscription f20434i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerSubscriber<T, R>> f20435j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        public final AtomicLong f20436k = new AtomicLong();

        /* renamed from: l  reason: collision with root package name */
        public volatile long f20437l;

        static {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = new SwitchMapInnerSubscriber<>((SwitchMapSubscriber) null, -1, 1);
            f20426m = switchMapInnerSubscriber;
            switchMapInnerSubscriber.cancel();
        }

        public SwitchMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11, boolean z11) {
            this.f20427b = subscriber;
            this.f20428c = function;
            this.f20429d = i11;
            this.f20430e = z11;
            this.f20432g = new AtomicThrowable();
        }

        public void a() {
            AtomicReference<SwitchMapInnerSubscriber<T, R>> atomicReference = this.f20435j;
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = f20426m;
            SwitchMapInnerSubscriber<Object, Object> andSet = atomicReference.getAndSet(switchMapInnerSubscriber);
            if (andSet != switchMapInnerSubscriber && andSet != null) {
                andSet.cancel();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0095, code lost:
            r15 = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r17 = this;
                r1 = r17
                int r0 = r17.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super R> r2 = r1.f20427b
                r4 = 1
            L_0x000c:
                boolean r0 = r1.f20433h
                if (r0 == 0) goto L_0x0011
                return
            L_0x0011:
                boolean r0 = r1.f20431f
                if (r0 == 0) goto L_0x0046
                boolean r0 = r1.f20430e
                if (r0 == 0) goto L_0x0027
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.f20435j
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x0046
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.f20432g
                r0.tryTerminateConsumer((org.reactivestreams.Subscriber<?>) r2)
                return
            L_0x0027:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.f20432g
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x003a
                r17.a()
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.f20432g
                r0.tryTerminateConsumer((org.reactivestreams.Subscriber<?>) r2)
                return
            L_0x003a:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.f20435j
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x0046
                r2.onComplete()
                return
            L_0x0046:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.f20435j
                java.lang.Object r0 = r0.get()
                r5 = r0
                io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap.SwitchMapInnerSubscriber) r5
                r6 = 0
                if (r5 == 0) goto L_0x0056
                io.reactivex.rxjava3.operators.SimpleQueue<R> r0 = r5.f20423e
                r7 = r0
                goto L_0x0057
            L_0x0056:
                r7 = r6
            L_0x0057:
                if (r7 == 0) goto L_0x011d
                java.util.concurrent.atomic.AtomicLong r0 = r1.f20436k
                long r8 = r0.get()
                r10 = 0
                r12 = r10
            L_0x0062:
                int r14 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
                if (r14 == 0) goto L_0x00c7
                boolean r0 = r1.f20433h
                if (r0 == 0) goto L_0x006b
                return
            L_0x006b:
                boolean r0 = r5.f20424f
                java.lang.Object r16 = r7.poll()     // Catch:{ all -> 0x0074 }
                r3 = r16
                goto L_0x0086
            L_0x0074:
                r0 = move-exception
                r16 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r16)
                r5.cancel()
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.f20432g
                r3 = r16
                r0.tryAddThrowableOrReport(r3)
                r3 = r6
                r0 = 1
            L_0x0086:
                if (r3 != 0) goto L_0x008b
                r16 = 1
                goto L_0x008d
            L_0x008b:
                r16 = 0
            L_0x008d:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r15 = r1.f20435j
                java.lang.Object r15 = r15.get()
                if (r5 == r15) goto L_0x0097
            L_0x0095:
                r15 = 1
                goto L_0x00c8
            L_0x0097:
                if (r0 == 0) goto L_0x00bd
                boolean r0 = r1.f20430e
                if (r0 != 0) goto L_0x00b5
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.f20432g
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x00ad
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.f20432g
                r0.tryTerminateConsumer((org.reactivestreams.Subscriber<?>) r2)
                return
            L_0x00ad:
                if (r16 == 0) goto L_0x00bd
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.f20435j
                i.b.a(r0, r5, r6)
                goto L_0x0095
            L_0x00b5:
                if (r16 == 0) goto L_0x00bd
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.f20435j
                i.b.a(r0, r5, r6)
                goto L_0x0095
            L_0x00bd:
                if (r16 == 0) goto L_0x00c0
                goto L_0x00c7
            L_0x00c0:
                r2.onNext(r3)
                r14 = 1
                long r12 = r12 + r14
                goto L_0x0062
            L_0x00c7:
                r15 = 0
            L_0x00c8:
                if (r14 != 0) goto L_0x00ff
                boolean r0 = r5.f20424f
                if (r0 == 0) goto L_0x00ff
                boolean r0 = r1.f20430e
                if (r0 != 0) goto L_0x00f2
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.f20432g
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x00e5
                r17.a()
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.f20432g
                r0.tryTerminateConsumer((org.reactivestreams.Subscriber<?>) r2)
                return
            L_0x00e5:
                boolean r0 = r7.isEmpty()
                if (r0 == 0) goto L_0x00ff
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.f20435j
                i.b.a(r0, r5, r6)
                goto L_0x000c
            L_0x00f2:
                boolean r0 = r7.isEmpty()
                if (r0 == 0) goto L_0x00ff
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.f20435j
                i.b.a(r0, r5, r6)
                goto L_0x000c
            L_0x00ff:
                int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                if (r0 == 0) goto L_0x0119
                boolean r0 = r1.f20433h
                if (r0 != 0) goto L_0x0119
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x0116
                java.util.concurrent.atomic.AtomicLong r0 = r1.f20436k
                long r6 = -r12
                r0.addAndGet(r6)
            L_0x0116:
                r5.request(r12)
            L_0x0119:
                if (r15 == 0) goto L_0x011d
                goto L_0x000c
            L_0x011d:
                int r0 = -r4
                int r4 = r1.addAndGet(r0)
                if (r4 != 0) goto L_0x000c
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap.SwitchMapSubscriber.b():void");
        }

        public void cancel() {
            if (!this.f20433h) {
                this.f20433h = true;
                this.f20434i.cancel();
                a();
                this.f20432g.tryTerminateAndReport();
            }
        }

        public void onComplete() {
            if (!this.f20431f) {
                this.f20431f = true;
                b();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20431f || !this.f20432g.tryAddThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!this.f20430e) {
                a();
            }
            this.f20431f = true;
            b();
        }

        public void onNext(T t11) {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber;
            if (!this.f20431f) {
                long j11 = this.f20437l + 1;
                this.f20437l = j11;
                SwitchMapInnerSubscriber switchMapInnerSubscriber2 = this.f20435j.get();
                if (switchMapInnerSubscriber2 != null) {
                    switchMapInnerSubscriber2.cancel();
                }
                try {
                    Object apply = this.f20428c.apply(t11);
                    Objects.requireNonNull(apply, "The publisher returned is null");
                    Publisher publisher = (Publisher) apply;
                    SwitchMapInnerSubscriber switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber(this, j11, this.f20429d);
                    do {
                        switchMapInnerSubscriber = this.f20435j.get();
                        if (switchMapInnerSubscriber == f20426m) {
                            return;
                        }
                    } while (!b.a(this.f20435j, switchMapInnerSubscriber, switchMapInnerSubscriber3));
                    publisher.subscribe(switchMapInnerSubscriber3);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f20434i.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20434i, subscription)) {
                this.f20434i = subscription;
                this.f20427b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20436k, j11);
                if (this.f20437l == 0) {
                    this.f20434i.request(Long.MAX_VALUE);
                } else {
                    b();
                }
            }
        }
    }

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i11, boolean z11) {
        super(flowable);
        this.f20417d = function;
        this.f20418e = i11;
        this.f20419f = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f19260c, subscriber, this.f20417d)) {
            this.f19260c.subscribe(new SwitchMapSubscriber(subscriber, this.f20417d, this.f20418e, this.f20419f));
        }
    }
}
