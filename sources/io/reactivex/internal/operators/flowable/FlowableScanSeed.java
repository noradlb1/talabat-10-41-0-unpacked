package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f15794d;

    /* renamed from: e  reason: collision with root package name */
    public final Callable<R> f15795e;

    public static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1776795561228106469L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f15796b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f15797c;

        /* renamed from: d  reason: collision with root package name */
        public final SimplePlainQueue<R> f15798d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f15799e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final int f15800f;

        /* renamed from: g  reason: collision with root package name */
        public final int f15801g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f15802h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f15803i;

        /* renamed from: j  reason: collision with root package name */
        public Throwable f15804j;

        /* renamed from: k  reason: collision with root package name */
        public Subscription f15805k;

        /* renamed from: l  reason: collision with root package name */
        public R f15806l;

        /* renamed from: m  reason: collision with root package name */
        public int f15807m;

        public ScanSeedSubscriber(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r11, int i11) {
            this.f15796b = subscriber;
            this.f15797c = biFunction;
            this.f15806l = r11;
            this.f15800f = i11;
            this.f15801g = i11 - (i11 >> 2);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i11);
            this.f15798d = spscArrayQueue;
            spscArrayQueue.offer(r11);
        }

        public void a() {
            int i11;
            boolean z11;
            Throwable th2;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f15796b;
                SimplePlainQueue<R> simplePlainQueue = this.f15798d;
                int i12 = this.f15801g;
                int i13 = this.f15807m;
                int i14 = 1;
                do {
                    long j11 = this.f15799e.get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (this.f15802h) {
                            simplePlainQueue.clear();
                            return;
                        } else {
                            boolean z12 = this.f15803i;
                            if (!z12 || (th2 = this.f15804j) == null) {
                                R poll = simplePlainQueue.poll();
                                if (poll == null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z12 && z11) {
                                    subscriber.onComplete();
                                    return;
                                } else if (z11) {
                                    break;
                                } else {
                                    subscriber.onNext(poll);
                                    j12++;
                                    i13++;
                                    if (i13 == i12) {
                                        this.f15805k.request((long) i12);
                                        i13 = 0;
                                    }
                                }
                            } else {
                                simplePlainQueue.clear();
                                subscriber.onError(th2);
                                return;
                            }
                        }
                    }
                    if (i11 == 0 && this.f15803i) {
                        Throwable th3 = this.f15804j;
                        if (th3 != null) {
                            simplePlainQueue.clear();
                            subscriber.onError(th3);
                            return;
                        } else if (simplePlainQueue.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (j12 != 0) {
                        BackpressureHelper.produced(this.f15799e, j12);
                    }
                    this.f15807m = i13;
                    i14 = addAndGet(-i14);
                } while (i14 != 0);
            }
        }

        public void cancel() {
            this.f15802h = true;
            this.f15805k.cancel();
            if (getAndIncrement() == 0) {
                this.f15798d.clear();
            }
        }

        public void onComplete() {
            if (!this.f15803i) {
                this.f15803i = true;
                a();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15803i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15804j = th2;
            this.f15803i = true;
            a();
        }

        public void onNext(T t11) {
            if (!this.f15803i) {
                try {
                    R requireNonNull = ObjectHelper.requireNonNull(this.f15797c.apply(this.f15806l, t11), "The accumulator returned a null value");
                    this.f15806l = requireNonNull;
                    this.f15798d.offer(requireNonNull);
                    a();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f15805k.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15805k, subscription)) {
                this.f15805k = subscription;
                this.f15796b.onSubscribe(this);
                subscription.request((long) (this.f15800f - 1));
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15799e, j11);
                a();
            }
        }
    }

    public FlowableScanSeed(Flowable<T> flowable, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        this.f15794d = biFunction;
        this.f15795e = callable;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            this.f14763c.subscribe(new ScanSeedSubscriber(subscriber, this.f15794d, ObjectHelper.requireNonNull(this.f15795e.call(), "The seed supplied is null"), Flowable.bufferSize()));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
