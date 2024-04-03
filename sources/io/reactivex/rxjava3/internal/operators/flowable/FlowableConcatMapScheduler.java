package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapScheduler<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f19516d;

    /* renamed from: e  reason: collision with root package name */
    public final int f19517e;

    /* renamed from: f  reason: collision with root package name */
    public final ErrorMode f19518f;

    /* renamed from: g  reason: collision with root package name */
    public final Scheduler f19519g;

    /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19520a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.reactivex.rxjava3.internal.util.ErrorMode[] r0 = io.reactivex.rxjava3.internal.util.ErrorMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19520a = r0
                io.reactivex.rxjava3.internal.util.ErrorMode r1 = io.reactivex.rxjava3.internal.util.ErrorMode.BOUNDARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19520a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.internal.util.ErrorMode r1 = io.reactivex.rxjava3.internal.util.ErrorMode.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, FlowableConcatMap.ConcatMapSupport<R>, Subscription, Runnable {
        private static final long serialVersionUID = -3511336836796789179L;

        /* renamed from: b  reason: collision with root package name */
        public final FlowableConcatMap.ConcatMapInner<R> f19521b = new FlowableConcatMap.ConcatMapInner<>(this);

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends R>> f19522c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19523d;

        /* renamed from: e  reason: collision with root package name */
        public final int f19524e;

        /* renamed from: f  reason: collision with root package name */
        public final Scheduler.Worker f19525f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f19526g;

        /* renamed from: h  reason: collision with root package name */
        public int f19527h;

        /* renamed from: i  reason: collision with root package name */
        public SimpleQueue<T> f19528i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f19529j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f19530k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicThrowable f19531l = new AtomicThrowable();

        /* renamed from: m  reason: collision with root package name */
        public volatile boolean f19532m;

        /* renamed from: n  reason: collision with root package name */
        public int f19533n;

        public BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int i11, Scheduler.Worker worker) {
            this.f19522c = function;
            this.f19523d = i11;
            this.f19524e = i11 - (i11 >> 2);
            this.f19525f = worker;
        }

        public abstract void a();

        public abstract void b();

        public final void innerComplete() {
            this.f19532m = false;
            a();
        }

        public final void onComplete() {
            this.f19529j = true;
            a();
        }

        public final void onNext(T t11) {
            if (this.f19533n == 2 || this.f19528i.offer(t11)) {
                a();
                return;
            }
            this.f19526g.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19526g, subscription)) {
                this.f19526g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f19533n = requestFusion;
                        this.f19528i = queueSubscription;
                        this.f19529j = true;
                        b();
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f19533n = requestFusion;
                        this.f19528i = queueSubscription;
                        b();
                        subscription.request((long) this.f19523d);
                        return;
                    }
                }
                this.f19528i = new SpscArrayQueue(this.f19523d);
                b();
                subscription.request((long) this.f19523d);
            }
        }
    }

    public static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;

        /* renamed from: o  reason: collision with root package name */
        public final Subscriber<? super R> f19534o;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f19535p;

        public ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11, boolean z11, Scheduler.Worker worker) {
            super(function, i11, worker);
            this.f19534o = subscriber;
            this.f19535p = z11;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                this.f19525f.schedule(this);
            }
        }

        public void b() {
            this.f19534o.onSubscribe(this);
        }

        public void cancel() {
            if (!this.f19530k) {
                this.f19530k = true;
                this.f19521b.cancel();
                this.f19526g.cancel();
                this.f19525f.dispose();
                this.f19531l.tryTerminateAndReport();
            }
        }

        public void innerError(Throwable th2) {
            if (this.f19531l.tryAddThrowableOrReport(th2)) {
                if (!this.f19535p) {
                    this.f19526g.cancel();
                    this.f19529j = true;
                }
                this.f19532m = false;
                a();
            }
        }

        public void innerNext(R r11) {
            this.f19534o.onNext(r11);
        }

        public void onError(Throwable th2) {
            if (this.f19531l.tryAddThrowableOrReport(th2)) {
                this.f19529j = true;
                a();
            }
        }

        public void request(long j11) {
            this.f19521b.request(j11);
        }

        public void run() {
            boolean z11;
            Object obj;
            while (!this.f19530k) {
                if (!this.f19532m) {
                    boolean z12 = this.f19529j;
                    if (!z12 || this.f19535p || ((Throwable) this.f19531l.get()) == null) {
                        try {
                            T poll = this.f19528i.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19534o);
                                this.f19525f.dispose();
                                return;
                            } else if (!z11) {
                                try {
                                    Object apply = this.f19522c.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                    Publisher publisher = (Publisher) apply;
                                    if (this.f19533n != 1) {
                                        int i11 = this.f19527h + 1;
                                        if (i11 == this.f19524e) {
                                            this.f19527h = 0;
                                            this.f19526g.request((long) i11);
                                        } else {
                                            this.f19527h = i11;
                                        }
                                    }
                                    if (publisher instanceof Supplier) {
                                        try {
                                            obj = ((Supplier) publisher).get();
                                        } catch (Throwable th2) {
                                            Exceptions.throwIfFatal(th2);
                                            this.f19531l.tryAddThrowableOrReport(th2);
                                            if (!this.f19535p) {
                                                this.f19526g.cancel();
                                                this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19534o);
                                                this.f19525f.dispose();
                                                return;
                                            }
                                            obj = null;
                                        }
                                        if (obj != null && !this.f19530k) {
                                            if (this.f19521b.isUnbounded()) {
                                                this.f19534o.onNext(obj);
                                            } else {
                                                this.f19532m = true;
                                                this.f19521b.setSubscription(new FlowableConcatMap.SimpleScalarSubscription(obj, this.f19521b));
                                            }
                                        }
                                    } else {
                                        this.f19532m = true;
                                        publisher.subscribe(this.f19521b);
                                    }
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    this.f19526g.cancel();
                                    this.f19531l.tryAddThrowableOrReport(th3);
                                    this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19534o);
                                    this.f19525f.dispose();
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            Exceptions.throwIfFatal(th4);
                            this.f19526g.cancel();
                            this.f19531l.tryAddThrowableOrReport(th4);
                            this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19534o);
                            this.f19525f.dispose();
                            return;
                        }
                    } else {
                        this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19534o);
                        this.f19525f.dispose();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;

        /* renamed from: o  reason: collision with root package name */
        public final Subscriber<? super R> f19536o;

        /* renamed from: p  reason: collision with root package name */
        public final AtomicInteger f19537p = new AtomicInteger();

        public ConcatMapImmediate(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11, Scheduler.Worker worker) {
            super(function, i11, worker);
            this.f19536o = subscriber;
        }

        public void a() {
            if (this.f19537p.getAndIncrement() == 0) {
                this.f19525f.schedule(this);
            }
        }

        public void b() {
            this.f19536o.onSubscribe(this);
        }

        public boolean c() {
            return get() == 0 && compareAndSet(0, 1);
        }

        public void cancel() {
            if (!this.f19530k) {
                this.f19530k = true;
                this.f19521b.cancel();
                this.f19526g.cancel();
                this.f19525f.dispose();
                this.f19531l.tryTerminateAndReport();
            }
        }

        public void innerError(Throwable th2) {
            if (this.f19531l.tryAddThrowableOrReport(th2)) {
                this.f19526g.cancel();
                if (getAndIncrement() == 0) {
                    this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19536o);
                    this.f19525f.dispose();
                }
            }
        }

        public void innerNext(R r11) {
            if (c()) {
                this.f19536o.onNext(r11);
                if (!compareAndSet(1, 0)) {
                    this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19536o);
                    this.f19525f.dispose();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f19531l.tryAddThrowableOrReport(th2)) {
                this.f19521b.cancel();
                if (getAndIncrement() == 0) {
                    this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19536o);
                    this.f19525f.dispose();
                }
            }
        }

        public void request(long j11) {
            this.f19521b.request(j11);
        }

        public void run() {
            boolean z11;
            while (!this.f19530k) {
                if (!this.f19532m) {
                    boolean z12 = this.f19529j;
                    try {
                        T poll = this.f19528i.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            this.f19536o.onComplete();
                            this.f19525f.dispose();
                            return;
                        } else if (!z11) {
                            try {
                                Object apply = this.f19522c.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                Publisher publisher = (Publisher) apply;
                                if (this.f19533n != 1) {
                                    int i11 = this.f19527h + 1;
                                    if (i11 == this.f19524e) {
                                        this.f19527h = 0;
                                        this.f19526g.request((long) i11);
                                    } else {
                                        this.f19527h = i11;
                                    }
                                }
                                if (publisher instanceof Supplier) {
                                    try {
                                        Object obj = ((Supplier) publisher).get();
                                        if (obj != null && !this.f19530k) {
                                            if (!this.f19521b.isUnbounded()) {
                                                this.f19532m = true;
                                                this.f19521b.setSubscription(new FlowableConcatMap.SimpleScalarSubscription(obj, this.f19521b));
                                            } else if (c()) {
                                                this.f19536o.onNext(obj);
                                                if (!compareAndSet(1, 0)) {
                                                    this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19536o);
                                                    this.f19525f.dispose();
                                                    return;
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        this.f19526g.cancel();
                                        this.f19531l.tryAddThrowableOrReport(th2);
                                        this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19536o);
                                        this.f19525f.dispose();
                                        return;
                                    }
                                } else {
                                    this.f19532m = true;
                                    publisher.subscribe(this.f19521b);
                                }
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                this.f19526g.cancel();
                                this.f19531l.tryAddThrowableOrReport(th3);
                                this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19536o);
                                this.f19525f.dispose();
                                return;
                            }
                        }
                    } catch (Throwable th4) {
                        Exceptions.throwIfFatal(th4);
                        this.f19526g.cancel();
                        this.f19531l.tryAddThrowableOrReport(th4);
                        this.f19531l.tryTerminateConsumer((Subscriber<?>) this.f19536o);
                        this.f19525f.dispose();
                        return;
                    }
                }
                if (this.f19537p.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public FlowableConcatMapScheduler(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i11, ErrorMode errorMode, Scheduler scheduler) {
        super(flowable);
        this.f19516d = function;
        this.f19517e = i11;
        this.f19518f = errorMode;
        this.f19519g = scheduler;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i11 = AnonymousClass1.f19520a[this.f19518f.ordinal()];
        if (i11 == 1) {
            this.f19260c.subscribe(new ConcatMapDelayed(subscriber, this.f19516d, this.f19517e, false, this.f19519g.createWorker()));
        } else if (i11 != 2) {
            this.f19260c.subscribe(new ConcatMapImmediate(subscriber, this.f19516d, this.f19517e, this.f19519g.createWorker()));
        } else {
            this.f19260c.subscribe(new ConcatMapDelayed(subscriber, this.f19516d, this.f19517e, true, this.f19519g.createWorker()));
        }
    }
}
