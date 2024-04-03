package io.reactivex.rxjava3.internal.operators.parallel;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelReduceFull<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final ParallelFlowable<? extends T> f22705c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<T, T, T> f22706d;

    public static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;

        /* renamed from: b  reason: collision with root package name */
        public final ParallelReduceFullMainSubscriber<T> f22707b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<T, T, T> f22708c;

        /* renamed from: d  reason: collision with root package name */
        public T f22709d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22710e;

        public ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber<T> parallelReduceFullMainSubscriber, BiFunction<T, T, T> biFunction) {
            this.f22707b = parallelReduceFullMainSubscriber;
            this.f22708c = biFunction;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            if (!this.f22710e) {
                this.f22710e = true;
                this.f22707b.b(this.f22709d);
            }
        }

        public void onError(Throwable th2) {
            if (this.f22710e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22710e = true;
            this.f22707b.innerError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22710e) {
                T t12 = this.f22709d;
                if (t12 == null) {
                    this.f22709d = t11;
                    return;
                }
                try {
                    T apply = this.f22708c.apply(t12, t11);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.f22709d = apply;
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
        public final ParallelReduceFullInnerSubscriber<T>[] f22711d;

        /* renamed from: e  reason: collision with root package name */
        public final BiFunction<T, T, T> f22712e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<SlotPair<T>> f22713f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f22714g = new AtomicInteger();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f22715h = new AtomicThrowable();

        public ParallelReduceFullMainSubscriber(Subscriber<? super T> subscriber, int i11, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            ParallelReduceFullInnerSubscriber<T>[] parallelReduceFullInnerSubscriberArr = new ParallelReduceFullInnerSubscriber[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                parallelReduceFullInnerSubscriberArr[i12] = new ParallelReduceFullInnerSubscriber<>(this, biFunction);
            }
            this.f22711d = parallelReduceFullInnerSubscriberArr;
            this.f22712e = biFunction;
            this.f22714g.lazySet(i11);
        }

        public SlotPair<T> a(T t11) {
            SlotPair<T> slotPair;
            int b11;
            while (true) {
                slotPair = this.f22713f.get();
                if (slotPair == null) {
                    slotPair = new SlotPair<>();
                    if (!b.a(this.f22713f, (Object) null, slotPair)) {
                        continue;
                    }
                }
                b11 = slotPair.b();
                if (b11 >= 0) {
                    break;
                }
                b.a(this.f22713f, slotPair, (Object) null);
            }
            if (b11 == 0) {
                slotPair.f22716b = t11;
            } else {
                slotPair.f22717c = t11;
            }
            if (!slotPair.a()) {
                return null;
            }
            b.a(this.f22713f, slotPair, (Object) null);
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
                        t11 = this.f22712e.apply(a11.f22716b, a11.f22717c);
                        Objects.requireNonNull(t11, "The reducer returned a null value");
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        innerError(th2);
                        return;
                    }
                }
            }
            if (this.f22714g.decrementAndGet() == 0) {
                SlotPair slotPair = this.f22713f.get();
                this.f22713f.lazySet((Object) null);
                if (slotPair != null) {
                    complete(slotPair.f22716b);
                } else {
                    this.f23170b.onComplete();
                }
            }
        }

        public void cancel() {
            for (ParallelReduceFullInnerSubscriber<T> a11 : this.f22711d) {
                a11.a();
            }
        }

        public void innerError(Throwable th2) {
            if (this.f22715h.compareAndSet((Object) null, th2)) {
                cancel();
                this.f23170b.onError(th2);
            } else if (th2 != this.f22715h.get()) {
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;

        /* renamed from: b  reason: collision with root package name */
        public T f22716b;

        /* renamed from: c  reason: collision with root package name */
        public T f22717c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f22718d = new AtomicInteger();

        public boolean a() {
            return this.f22718d.incrementAndGet() == 2;
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
        this.f22705c = parallelFlowable;
        this.f22706d = biFunction;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(subscriber, this.f22705c.parallelism(), this.f22706d);
        subscriber.onSubscribe(parallelReduceFullMainSubscriber);
        this.f22705c.subscribe(parallelReduceFullMainSubscriber.f22711d);
    }
}
