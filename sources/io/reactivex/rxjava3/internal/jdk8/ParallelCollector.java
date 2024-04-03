package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.stream.Collector;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelCollector<T, A, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final ParallelFlowable<? extends T> f18949c;

    /* renamed from: d  reason: collision with root package name */
    public final Collector<T, A, R> f18950d;

    public static final class ParallelCollectorInnerSubscriber<T, A, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;

        /* renamed from: b  reason: collision with root package name */
        public final ParallelCollectorSubscriber<T, A, R> f18951b;

        /* renamed from: c  reason: collision with root package name */
        public final BiConsumer<A, T> f18952c;

        /* renamed from: d  reason: collision with root package name */
        public final BinaryOperator<A> f18953d;

        /* renamed from: e  reason: collision with root package name */
        public A f18954e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18955f;

        public ParallelCollectorInnerSubscriber(ParallelCollectorSubscriber<T, A, R> parallelCollectorSubscriber, A a11, BiConsumer<A, T> biConsumer, BinaryOperator<A> binaryOperator) {
            this.f18951b = parallelCollectorSubscriber;
            this.f18952c = biConsumer;
            this.f18953d = binaryOperator;
            this.f18954e = a11;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            if (!this.f18955f) {
                A a11 = this.f18954e;
                this.f18954e = null;
                this.f18955f = true;
                this.f18951b.b(a11, this.f18953d);
            }
        }

        public void onError(Throwable th2) {
            if (this.f18955f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18954e = null;
            this.f18955f = true;
            this.f18951b.innerError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18955f) {
                try {
                    this.f18952c.accept(this.f18954e, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    ((Subscription) get()).cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class ParallelCollectorSubscriber<T, A, R> extends DeferredScalarSubscription<R> {
        private static final long serialVersionUID = -5370107872170712765L;

        /* renamed from: d  reason: collision with root package name */
        public final ParallelCollectorInnerSubscriber<T, A, R>[] f18956d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<SlotPair<A>> f18957e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f18958f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f18959g = new AtomicThrowable();

        /* renamed from: h  reason: collision with root package name */
        public final Function<A, R> f18960h;

        public ParallelCollectorSubscriber(Subscriber<? super R> subscriber, int i11, Collector<T, A, R> collector) {
            super(subscriber);
            this.f18960h = collector.finisher();
            ParallelCollectorInnerSubscriber<T, A, R>[] parallelCollectorInnerSubscriberArr = new ParallelCollectorInnerSubscriber[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                parallelCollectorInnerSubscriberArr[i12] = new ParallelCollectorInnerSubscriber<>(this, collector.supplier().get(), collector.accumulator(), collector.combiner());
            }
            this.f18956d = parallelCollectorInnerSubscriberArr;
            this.f18958f.lazySet(i11);
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [A, T] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.reactivex.rxjava3.internal.jdk8.ParallelCollector.SlotPair<A> a(A r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r0 = r3.f18957e
                java.lang.Object r0 = r0.get()
                io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair r0 = (io.reactivex.rxjava3.internal.jdk8.ParallelCollector.SlotPair) r0
                r1 = 0
                if (r0 != 0) goto L_0x0019
                io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair r0 = new io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair
                r0.<init>()
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r2 = r3.f18957e
                boolean r2 = i.b.a(r2, r1, r0)
                if (r2 != 0) goto L_0x0019
                goto L_0x0000
            L_0x0019:
                int r2 = r0.b()
                if (r2 >= 0) goto L_0x0025
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r2 = r3.f18957e
                i.b.a(r2, r0, r1)
                goto L_0x0000
            L_0x0025:
                if (r2 != 0) goto L_0x002a
                r0.f18961b = r4
                goto L_0x002c
            L_0x002a:
                r0.f18962c = r4
            L_0x002c:
                boolean r4 = r0.a()
                if (r4 == 0) goto L_0x0038
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r4 = r3.f18957e
                i.b.a(r4, r0, r1)
                return r0
            L_0x0038:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelCollector.ParallelCollectorSubscriber.a(java.lang.Object):io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair");
        }

        public void b(A a11, BinaryOperator<A> binaryOperator) {
            while (true) {
                SlotPair a12 = a(a11);
                if (a12 == null) {
                    break;
                }
                try {
                    a11 = binaryOperator.apply(a12.f18961b, a12.f18962c);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    innerError(th2);
                    return;
                }
            }
            if (this.f18958f.decrementAndGet() == 0) {
                SlotPair slotPair = this.f18957e.get();
                this.f18957e.lazySet((Object) null);
                try {
                    R apply = this.f18960h.apply(slotPair.f18961b);
                    Objects.requireNonNull(apply, "The finisher returned a null value");
                    complete(apply);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    innerError(th3);
                }
            }
        }

        public void cancel() {
            for (ParallelCollectorInnerSubscriber<T, A, R> a11 : this.f18956d) {
                a11.a();
            }
        }

        public void innerError(Throwable th2) {
            if (this.f18959g.compareAndSet((Object) null, th2)) {
                cancel();
                this.f23170b.onError(th2);
            } else if (th2 != this.f18959g.get()) {
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;

        /* renamed from: b  reason: collision with root package name */
        public T f18961b;

        /* renamed from: c  reason: collision with root package name */
        public T f18962c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f18963d = new AtomicInteger();

        public boolean a() {
            return this.f18963d.incrementAndGet() == 2;
        }

        public int b() {
            int i11;
            do {
                i11 = get();
                if (i11 >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i11, i11 + 1));
            return i11;
        }
    }

    public ParallelCollector(ParallelFlowable<? extends T> parallelFlowable, Collector<T, A, R> collector) {
        this.f18949c = parallelFlowable;
        this.f18950d = collector;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            ParallelCollectorSubscriber parallelCollectorSubscriber = new ParallelCollectorSubscriber(subscriber, this.f18949c.parallelism(), this.f18950d);
            subscriber.onSubscribe(parallelCollectorSubscriber);
            this.f18949c.subscribe(parallelCollectorSubscriber.f18956d);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
