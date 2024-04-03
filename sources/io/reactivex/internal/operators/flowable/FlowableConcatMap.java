package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f14983d;

    /* renamed from: e  reason: collision with root package name */
    public final int f14984e;

    /* renamed from: f  reason: collision with root package name */
    public final ErrorMode f14985f;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14986a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.reactivex.internal.util.ErrorMode[] r0 = io.reactivex.internal.util.ErrorMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14986a = r0
                io.reactivex.internal.util.ErrorMode r1 = io.reactivex.internal.util.ErrorMode.BOUNDARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14986a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.internal.util.ErrorMode r1 = io.reactivex.internal.util.ErrorMode.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableConcatMap.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, ConcatMapSupport<R>, Subscription {
        private static final long serialVersionUID = -3511336836796789179L;

        /* renamed from: b  reason: collision with root package name */
        public final ConcatMapInner<R> f14987b = new ConcatMapInner<>(this);

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends R>> f14988c;

        /* renamed from: d  reason: collision with root package name */
        public final int f14989d;

        /* renamed from: e  reason: collision with root package name */
        public final int f14990e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f14991f;

        /* renamed from: g  reason: collision with root package name */
        public int f14992g;

        /* renamed from: h  reason: collision with root package name */
        public SimpleQueue<T> f14993h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f14994i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f14995j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicThrowable f14996k = new AtomicThrowable();

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f14997l;

        /* renamed from: m  reason: collision with root package name */
        public int f14998m;

        public BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
            this.f14988c = function;
            this.f14989d = i11;
            this.f14990e = i11 - (i11 >> 2);
        }

        public abstract void a();

        public abstract void b();

        public final void innerComplete() {
            this.f14997l = false;
            a();
        }

        public final void onComplete() {
            this.f14994i = true;
            a();
        }

        public final void onNext(T t11) {
            if (this.f14998m == 2 || this.f14993h.offer(t11)) {
                a();
                return;
            }
            this.f14991f.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14991f, subscription)) {
                this.f14991f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f14998m = requestFusion;
                        this.f14993h = queueSubscription;
                        this.f14994i = true;
                        b();
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f14998m = requestFusion;
                        this.f14993h = queueSubscription;
                        b();
                        subscription.request((long) this.f14989d);
                        return;
                    }
                }
                this.f14993h = new SpscArrayQueue(this.f14989d);
                b();
                subscription.request((long) this.f14989d);
            }
        }
    }

    public static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;

        /* renamed from: n  reason: collision with root package name */
        public final Subscriber<? super R> f14999n;

        /* renamed from: o  reason: collision with root package name */
        public final boolean f15000o;

        public ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11, boolean z11) {
            super(function, i11);
            this.f14999n = subscriber;
            this.f15000o = z11;
        }

        public void a() {
            boolean z11;
            Object obj;
            if (getAndIncrement() == 0) {
                while (!this.f14995j) {
                    if (!this.f14997l) {
                        boolean z12 = this.f14994i;
                        if (!z12 || this.f15000o || ((Throwable) this.f14996k.get()) == null) {
                            try {
                                T poll = this.f14993h.poll();
                                if (poll == null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z12 && z11) {
                                    Throwable terminate = this.f14996k.terminate();
                                    if (terminate != null) {
                                        this.f14999n.onError(terminate);
                                        return;
                                    } else {
                                        this.f14999n.onComplete();
                                        return;
                                    }
                                } else if (!z11) {
                                    try {
                                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f14988c.apply(poll), "The mapper returned a null Publisher");
                                        if (this.f14998m != 1) {
                                            int i11 = this.f14992g + 1;
                                            if (i11 == this.f14990e) {
                                                this.f14992g = 0;
                                                this.f14991f.request((long) i11);
                                            } else {
                                                this.f14992g = i11;
                                            }
                                        }
                                        if (publisher instanceof Callable) {
                                            try {
                                                obj = ((Callable) publisher).call();
                                            } catch (Throwable th2) {
                                                Exceptions.throwIfFatal(th2);
                                                this.f14996k.addThrowable(th2);
                                                if (!this.f15000o) {
                                                    this.f14991f.cancel();
                                                    this.f14999n.onError(this.f14996k.terminate());
                                                    return;
                                                }
                                                obj = null;
                                            }
                                            if (obj == null) {
                                                continue;
                                            } else if (this.f14987b.isUnbounded()) {
                                                this.f14999n.onNext(obj);
                                            } else {
                                                this.f14997l = true;
                                                this.f14987b.setSubscription(new SimpleScalarSubscription(obj, this.f14987b));
                                            }
                                        } else {
                                            this.f14997l = true;
                                            publisher.subscribe(this.f14987b);
                                        }
                                    } catch (Throwable th3) {
                                        Exceptions.throwIfFatal(th3);
                                        this.f14991f.cancel();
                                        this.f14996k.addThrowable(th3);
                                        this.f14999n.onError(this.f14996k.terminate());
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                Exceptions.throwIfFatal(th4);
                                this.f14991f.cancel();
                                this.f14996k.addThrowable(th4);
                                this.f14999n.onError(this.f14996k.terminate());
                                return;
                            }
                        } else {
                            this.f14999n.onError(this.f14996k.terminate());
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
            this.f14999n.onSubscribe(this);
        }

        public void cancel() {
            if (!this.f14995j) {
                this.f14995j = true;
                this.f14987b.cancel();
                this.f14991f.cancel();
            }
        }

        public void innerError(Throwable th2) {
            if (this.f14996k.addThrowable(th2)) {
                if (!this.f15000o) {
                    this.f14991f.cancel();
                    this.f14994i = true;
                }
                this.f14997l = false;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerNext(R r11) {
            this.f14999n.onNext(r11);
        }

        public void onError(Throwable th2) {
            if (this.f14996k.addThrowable(th2)) {
                this.f14994i = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void request(long j11) {
            this.f14987b.request(j11);
        }
    }

    public static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;

        /* renamed from: n  reason: collision with root package name */
        public final Subscriber<? super R> f15001n;

        /* renamed from: o  reason: collision with root package name */
        public final AtomicInteger f15002o = new AtomicInteger();

        public ConcatMapImmediate(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
            super(function, i11);
            this.f15001n = subscriber;
        }

        public void a() {
            boolean z11;
            if (this.f15002o.getAndIncrement() == 0) {
                while (!this.f14995j) {
                    if (!this.f14997l) {
                        boolean z12 = this.f14994i;
                        try {
                            T poll = this.f14993h.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                this.f15001n.onComplete();
                                return;
                            } else if (!z11) {
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f14988c.apply(poll), "The mapper returned a null Publisher");
                                    if (this.f14998m != 1) {
                                        int i11 = this.f14992g + 1;
                                        if (i11 == this.f14990e) {
                                            this.f14992g = 0;
                                            this.f14991f.request((long) i11);
                                        } else {
                                            this.f14992g = i11;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object call = ((Callable) publisher).call();
                                            if (call == null) {
                                                continue;
                                            } else if (!this.f14987b.isUnbounded()) {
                                                this.f14997l = true;
                                                this.f14987b.setSubscription(new SimpleScalarSubscription(call, this.f14987b));
                                            } else if (get() == 0 && compareAndSet(0, 1)) {
                                                this.f15001n.onNext(call);
                                                if (!compareAndSet(1, 0)) {
                                                    this.f15001n.onError(this.f14996k.terminate());
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            Exceptions.throwIfFatal(th2);
                                            this.f14991f.cancel();
                                            this.f14996k.addThrowable(th2);
                                            this.f15001n.onError(this.f14996k.terminate());
                                            return;
                                        }
                                    } else {
                                        this.f14997l = true;
                                        publisher.subscribe(this.f14987b);
                                    }
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    this.f14991f.cancel();
                                    this.f14996k.addThrowable(th3);
                                    this.f15001n.onError(this.f14996k.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            Exceptions.throwIfFatal(th4);
                            this.f14991f.cancel();
                            this.f14996k.addThrowable(th4);
                            this.f15001n.onError(this.f14996k.terminate());
                            return;
                        }
                    }
                    if (this.f15002o.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void b() {
            this.f15001n.onSubscribe(this);
        }

        public void cancel() {
            if (!this.f14995j) {
                this.f14995j = true;
                this.f14987b.cancel();
                this.f14991f.cancel();
            }
        }

        public void innerError(Throwable th2) {
            if (this.f14996k.addThrowable(th2)) {
                this.f14991f.cancel();
                if (getAndIncrement() == 0) {
                    this.f15001n.onError(this.f14996k.terminate());
                    return;
                }
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerNext(R r11) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f15001n.onNext(r11);
                if (!compareAndSet(1, 0)) {
                    this.f15001n.onError(this.f14996k.terminate());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f14996k.addThrowable(th2)) {
                this.f14987b.cancel();
                if (getAndIncrement() == 0) {
                    this.f15001n.onError(this.f14996k.terminate());
                    return;
                }
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void request(long j11) {
            this.f14987b.request(j11);
        }
    }

    public static final class ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 897683679971470653L;

        /* renamed from: j  reason: collision with root package name */
        public final ConcatMapSupport<R> f15003j;

        /* renamed from: k  reason: collision with root package name */
        public long f15004k;

        public ConcatMapInner(ConcatMapSupport<R> concatMapSupport) {
            super(false);
            this.f15003j = concatMapSupport;
        }

        public void onComplete() {
            long j11 = this.f15004k;
            if (j11 != 0) {
                this.f15004k = 0;
                produced(j11);
            }
            this.f15003j.innerComplete();
        }

        public void onError(Throwable th2) {
            long j11 = this.f15004k;
            if (j11 != 0) {
                this.f15004k = 0;
                produced(j11);
            }
            this.f15003j.innerError(th2);
        }

        public void onNext(R r11) {
            this.f15004k++;
            this.f15003j.innerNext(r11);
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

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15005b;

        /* renamed from: c  reason: collision with root package name */
        public final T f15006c;

        public SimpleScalarSubscription(T t11, Subscriber<? super T> subscriber) {
            this.f15006c = t11;
            this.f15005b = subscriber;
        }

        public void cancel() {
        }

        public void request(long j11) {
            if (j11 > 0 && compareAndSet(false, true)) {
                Subscriber<? super T> subscriber = this.f15005b;
                subscriber.onNext(this.f15006c);
                subscriber.onComplete();
            }
        }
    }

    public FlowableConcatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i11, ErrorMode errorMode) {
        super(flowable);
        this.f14983d = function;
        this.f14984e = i11;
        this.f14985f = errorMode;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11, ErrorMode errorMode) {
        int i12 = AnonymousClass1.f14986a[errorMode.ordinal()];
        if (i12 == 1) {
            return new ConcatMapDelayed(subscriber, function, i11, false);
        }
        if (i12 != 2) {
            return new ConcatMapImmediate(subscriber, function, i11);
        }
        return new ConcatMapDelayed(subscriber, function, i11, true);
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f14763c, subscriber, this.f14983d)) {
            this.f14763c.subscribe(subscribe(subscriber, this.f14983d, this.f14984e, this.f14985f));
        }
    }
}
