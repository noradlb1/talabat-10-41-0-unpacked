package io.reactivex.internal.operators.parallel;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelReduceFull<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final ParallelFlowable<? extends T> f18171c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<T, T, T> f18172d;

    public static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;

        /* renamed from: b  reason: collision with root package name */
        public final ParallelReduceFullMainSubscriber<T> f18173b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<T, T, T> f18174c;

        /* renamed from: d  reason: collision with root package name */
        public T f18175d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f18176e;

        public ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber<T> parallelReduceFullMainSubscriber, BiFunction<T, T, T> biFunction) {
            this.f18173b = parallelReduceFullMainSubscriber;
            this.f18174c = biFunction;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            if (!this.f18176e) {
                this.f18176e = true;
                this.f18173b.b(this.f18175d);
            }
        }

        public void onError(Throwable th2) {
            if (this.f18176e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18176e = true;
            this.f18173b.innerError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18176e) {
                T t12 = this.f18175d;
                if (t12 == null) {
                    this.f18175d = t11;
                    return;
                }
                try {
                    this.f18175d = ObjectHelper.requireNonNull(this.f18174c.apply(t12, t11), "The reducer returned a null value");
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

    public static final class ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;

        /* renamed from: d  reason: collision with root package name */
        public final ParallelReduceFullInnerSubscriber<T>[] f18177d;

        /* renamed from: e  reason: collision with root package name */
        public final BiFunction<T, T, T> f18178e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<SlotPair<T>> f18179f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f18180g = new AtomicInteger();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<Throwable> f18181h = new AtomicReference<>();

        public ParallelReduceFullMainSubscriber(Subscriber<? super T> subscriber, int i11, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            ParallelReduceFullInnerSubscriber<T>[] parallelReduceFullInnerSubscriberArr = new ParallelReduceFullInnerSubscriber[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                parallelReduceFullInnerSubscriberArr[i12] = new ParallelReduceFullInnerSubscriber<>(this, biFunction);
            }
            this.f18177d = parallelReduceFullInnerSubscriberArr;
            this.f18178e = biFunction;
            this.f18180g.lazySet(i11);
        }

        public SlotPair<T> a(T t11) {
            SlotPair<T> slotPair;
            int b11;
            while (true) {
                slotPair = this.f18179f.get();
                if (slotPair == null) {
                    slotPair = new SlotPair<>();
                    if (!b.a(this.f18179f, (Object) null, slotPair)) {
                        continue;
                    }
                }
                b11 = slotPair.b();
                if (b11 >= 0) {
                    break;
                }
                b.a(this.f18179f, slotPair, (Object) null);
            }
            if (b11 == 0) {
                slotPair.f18182b = t11;
            } else {
                slotPair.f18183c = t11;
            }
            if (!slotPair.a()) {
                return null;
            }
            b.a(this.f18179f, slotPair, (Object) null);
            return slotPair;
        }

        public void b(T t11) {
            if (t11 != null) {
                while (true) {
                    SlotPair a11 = a(t11);
                    if (a11 == null) {
                        break;
                    }
                    try {
                        t11 = ObjectHelper.requireNonNull(this.f18178e.apply(a11.f18182b, a11.f18183c), "The reducer returned a null value");
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        innerError(th2);
                        return;
                    }
                }
            }
            if (this.f18180g.decrementAndGet() == 0) {
                SlotPair slotPair = this.f18179f.get();
                this.f18179f.lazySet((Object) null);
                if (slotPair != null) {
                    complete(slotPair.f18182b);
                } else {
                    this.f18609b.onComplete();
                }
            }
        }

        public void cancel() {
            for (ParallelReduceFullInnerSubscriber<T> a11 : this.f18177d) {
                a11.a();
            }
        }

        public void innerError(Throwable th2) {
            if (b.a(this.f18181h, (Object) null, th2)) {
                cancel();
                this.f18609b.onError(th2);
            } else if (th2 != this.f18181h.get()) {
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;

        /* renamed from: b  reason: collision with root package name */
        public T f18182b;

        /* renamed from: c  reason: collision with root package name */
        public T f18183c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f18184d = new AtomicInteger();

        public boolean a() {
            return this.f18184d.incrementAndGet() == 2;
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

    public ParallelReduceFull(ParallelFlowable<? extends T> parallelFlowable, BiFunction<T, T, T> biFunction) {
        this.f18171c = parallelFlowable;
        this.f18172d = biFunction;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(subscriber, this.f18171c.parallelism(), this.f18172d);
        subscriber.onSubscribe(parallelReduceFullMainSubscriber);
        this.f18171c.subscribe(parallelReduceFullMainSubscriber.f18177d);
    }
}
