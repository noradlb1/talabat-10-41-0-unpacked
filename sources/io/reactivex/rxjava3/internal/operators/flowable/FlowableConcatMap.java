package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f19471d;

    /* renamed from: e  reason: collision with root package name */
    public final int f19472e;

    /* renamed from: f  reason: collision with root package name */
    public final ErrorMode f19473f;

    /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19474a;

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
                f19474a = r0
                io.reactivex.rxjava3.internal.util.ErrorMode r1 = io.reactivex.rxjava3.internal.util.ErrorMode.BOUNDARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19474a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.internal.util.ErrorMode r1 = io.reactivex.rxjava3.internal.util.ErrorMode.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, ConcatMapSupport<R>, Subscription {
        private static final long serialVersionUID = -3511336836796789179L;

        /* renamed from: b  reason: collision with root package name */
        public final ConcatMapInner<R> f19475b = new ConcatMapInner<>(this);

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends R>> f19476c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19477d;

        /* renamed from: e  reason: collision with root package name */
        public final int f19478e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f19479f;

        /* renamed from: g  reason: collision with root package name */
        public int f19480g;

        /* renamed from: h  reason: collision with root package name */
        public SimpleQueue<T> f19481h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f19482i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f19483j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicThrowable f19484k = new AtomicThrowable();

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f19485l;

        /* renamed from: m  reason: collision with root package name */
        public int f19486m;

        public BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
            this.f19476c = function;
            this.f19477d = i11;
            this.f19478e = i11 - (i11 >> 2);
        }

        public abstract void a();

        public abstract void b();

        public final void innerComplete() {
            this.f19485l = false;
            a();
        }

        public final void onComplete() {
            this.f19482i = true;
            a();
        }

        public final void onNext(T t11) {
            if (this.f19486m == 2 || this.f19481h.offer(t11)) {
                a();
                return;
            }
            this.f19479f.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19479f, subscription)) {
                this.f19479f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f19486m = requestFusion;
                        this.f19481h = queueSubscription;
                        this.f19482i = true;
                        b();
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f19486m = requestFusion;
                        this.f19481h = queueSubscription;
                        b();
                        subscription.request((long) this.f19477d);
                        return;
                    }
                }
                this.f19481h = new SpscArrayQueue(this.f19477d);
                b();
                subscription.request((long) this.f19477d);
            }
        }
    }

    public static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;

        /* renamed from: n  reason: collision with root package name */
        public final Subscriber<? super R> f19487n;

        /* renamed from: o  reason: collision with root package name */
        public final boolean f19488o;

        public ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11, boolean z11) {
            super(function, i11);
            this.f19487n = subscriber;
            this.f19488o = z11;
        }

        public void a() {
            boolean z11;
            Object obj;
            if (getAndIncrement() == 0) {
                while (!this.f19483j) {
                    if (!this.f19485l) {
                        boolean z12 = this.f19482i;
                        if (!z12 || this.f19488o || ((Throwable) this.f19484k.get()) == null) {
                            try {
                                T poll = this.f19481h.poll();
                                if (poll == null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z12 && z11) {
                                    this.f19484k.tryTerminateConsumer((Subscriber<?>) this.f19487n);
                                    return;
                                } else if (!z11) {
                                    try {
                                        Object apply = this.f19476c.apply(poll);
                                        Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                        Publisher publisher = (Publisher) apply;
                                        if (this.f19486m != 1) {
                                            int i11 = this.f19480g + 1;
                                            if (i11 == this.f19478e) {
                                                this.f19480g = 0;
                                                this.f19479f.request((long) i11);
                                            } else {
                                                this.f19480g = i11;
                                            }
                                        }
                                        if (publisher instanceof Supplier) {
                                            try {
                                                obj = ((Supplier) publisher).get();
                                            } catch (Throwable th2) {
                                                Exceptions.throwIfFatal(th2);
                                                this.f19484k.tryAddThrowableOrReport(th2);
                                                if (!this.f19488o) {
                                                    this.f19479f.cancel();
                                                    this.f19484k.tryTerminateConsumer((Subscriber<?>) this.f19487n);
                                                    return;
                                                }
                                                obj = null;
                                            }
                                            if (obj == null) {
                                                continue;
                                            } else if (this.f19475b.isUnbounded()) {
                                                this.f19487n.onNext(obj);
                                            } else {
                                                this.f19485l = true;
                                                this.f19475b.setSubscription(new SimpleScalarSubscription(obj, this.f19475b));
                                            }
                                        } else {
                                            this.f19485l = true;
                                            publisher.subscribe(this.f19475b);
                                        }
                                    } catch (Throwable th3) {
                                        Exceptions.throwIfFatal(th3);
                                        this.f19479f.cancel();
                                        this.f19484k.tryAddThrowableOrReport(th3);
                                        this.f19484k.tryTerminateConsumer((Subscriber<?>) this.f19487n);
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                Exceptions.throwIfFatal(th4);
                                this.f19479f.cancel();
                                this.f19484k.tryAddThrowableOrReport(th4);
                                this.f19484k.tryTerminateConsumer((Subscriber<?>) this.f19487n);
                                return;
                            }
                        } else {
                            this.f19484k.tryTerminateConsumer((Subscriber<?>) this.f19487n);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void b() {
            this.f19487n.onSubscribe(this);
        }

        public void cancel() {
            if (!this.f19483j) {
                this.f19483j = true;
                this.f19475b.cancel();
                this.f19479f.cancel();
                this.f19484k.tryTerminateAndReport();
            }
        }

        public void innerError(Throwable th2) {
            if (this.f19484k.tryAddThrowableOrReport(th2)) {
                if (!this.f19488o) {
                    this.f19479f.cancel();
                    this.f19482i = true;
                }
                this.f19485l = false;
                a();
            }
        }

        public void innerNext(R r11) {
            this.f19487n.onNext(r11);
        }

        public void onError(Throwable th2) {
            if (this.f19484k.tryAddThrowableOrReport(th2)) {
                this.f19482i = true;
                a();
            }
        }

        public void request(long j11) {
            this.f19475b.request(j11);
        }
    }

    public static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;

        /* renamed from: n  reason: collision with root package name */
        public final Subscriber<? super R> f19489n;

        /* renamed from: o  reason: collision with root package name */
        public final AtomicInteger f19490o = new AtomicInteger();

        public ConcatMapImmediate(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
            super(function, i11);
            this.f19489n = subscriber;
        }

        public void a() {
            boolean z11;
            if (this.f19490o.getAndIncrement() == 0) {
                while (!this.f19483j) {
                    if (!this.f19485l) {
                        boolean z12 = this.f19482i;
                        try {
                            T poll = this.f19481h.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                this.f19489n.onComplete();
                                return;
                            } else if (!z11) {
                                try {
                                    Object apply = this.f19476c.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                    Publisher publisher = (Publisher) apply;
                                    if (this.f19486m != 1) {
                                        int i11 = this.f19480g + 1;
                                        if (i11 == this.f19478e) {
                                            this.f19480g = 0;
                                            this.f19479f.request((long) i11);
                                        } else {
                                            this.f19480g = i11;
                                        }
                                    }
                                    if (publisher instanceof Supplier) {
                                        try {
                                            Object obj = ((Supplier) publisher).get();
                                            if (obj == null) {
                                                continue;
                                            } else if (!this.f19475b.isUnbounded()) {
                                                this.f19485l = true;
                                                this.f19475b.setSubscription(new SimpleScalarSubscription(obj, this.f19475b));
                                            } else if (!HalfSerializer.onNext(this.f19489n, obj, (AtomicInteger) this, this.f19484k)) {
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            Exceptions.throwIfFatal(th2);
                                            this.f19479f.cancel();
                                            this.f19484k.tryAddThrowableOrReport(th2);
                                            this.f19484k.tryTerminateConsumer((Subscriber<?>) this.f19489n);
                                            return;
                                        }
                                    } else {
                                        this.f19485l = true;
                                        publisher.subscribe(this.f19475b);
                                    }
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    this.f19479f.cancel();
                                    this.f19484k.tryAddThrowableOrReport(th3);
                                    this.f19484k.tryTerminateConsumer((Subscriber<?>) this.f19489n);
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            Exceptions.throwIfFatal(th4);
                            this.f19479f.cancel();
                            this.f19484k.tryAddThrowableOrReport(th4);
                            this.f19484k.tryTerminateConsumer((Subscriber<?>) this.f19489n);
                            return;
                        }
                    }
                    if (this.f19490o.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void b() {
            this.f19489n.onSubscribe(this);
        }

        public void cancel() {
            if (!this.f19483j) {
                this.f19483j = true;
                this.f19475b.cancel();
                this.f19479f.cancel();
                this.f19484k.tryTerminateAndReport();
            }
        }

        public void innerError(Throwable th2) {
            this.f19479f.cancel();
            HalfSerializer.onError((Subscriber<?>) this.f19489n, th2, (AtomicInteger) this, this.f19484k);
        }

        public void innerNext(R r11) {
            HalfSerializer.onNext(this.f19489n, r11, (AtomicInteger) this, this.f19484k);
        }

        public void onError(Throwable th2) {
            this.f19475b.cancel();
            HalfSerializer.onError((Subscriber<?>) this.f19489n, th2, (AtomicInteger) this, this.f19484k);
        }

        public void request(long j11) {
            this.f19475b.request(j11);
        }
    }

    public static final class ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 897683679971470653L;

        /* renamed from: j  reason: collision with root package name */
        public final ConcatMapSupport<R> f19491j;

        /* renamed from: k  reason: collision with root package name */
        public long f19492k;

        public ConcatMapInner(ConcatMapSupport<R> concatMapSupport) {
            super(false);
            this.f19491j = concatMapSupport;
        }

        public void onComplete() {
            long j11 = this.f19492k;
            if (j11 != 0) {
                this.f19492k = 0;
                produced(j11);
            }
            this.f19491j.innerComplete();
        }

        public void onError(Throwable th2) {
            long j11 = this.f19492k;
            if (j11 != 0) {
                this.f19492k = 0;
                produced(j11);
            }
            this.f19491j.innerError(th2);
        }

        public void onNext(R r11) {
            this.f19492k++;
            this.f19491j.innerNext(r11);
        }

        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public interface ConcatMapSupport<T> {
        void innerComplete();

        void innerError(Throwable th2);

        void innerNext(T t11);
    }

    public static final class SimpleScalarSubscription<T> extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = -7606889335172043256L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19493b;

        /* renamed from: c  reason: collision with root package name */
        public final T f19494c;

        public SimpleScalarSubscription(T t11, Subscriber<? super T> subscriber) {
            this.f19494c = t11;
            this.f19493b = subscriber;
        }

        public void cancel() {
        }

        public void request(long j11) {
            if (j11 > 0 && compareAndSet(false, true)) {
                Subscriber<? super T> subscriber = this.f19493b;
                subscriber.onNext(this.f19494c);
                subscriber.onComplete();
            }
        }
    }

    public FlowableConcatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i11, ErrorMode errorMode) {
        super(flowable);
        this.f19471d = function;
        this.f19472e = i11;
        this.f19473f = errorMode;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11, ErrorMode errorMode) {
        int i12 = AnonymousClass1.f19474a[errorMode.ordinal()];
        if (i12 == 1) {
            return new ConcatMapDelayed(subscriber, function, i11, false);
        }
        if (i12 != 2) {
            return new ConcatMapImmediate(subscriber, function, i11);
        }
        return new ConcatMapDelayed(subscriber, function, i11, true);
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f19260c, subscriber, this.f19471d)) {
            this.f19260c.subscribe(subscribe(subscriber, this.f19471d, this.f19472e, this.f19473f));
        }
    }
}
