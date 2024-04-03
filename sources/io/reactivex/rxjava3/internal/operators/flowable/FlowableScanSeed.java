package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f20304d;

    /* renamed from: e  reason: collision with root package name */
    public final Supplier<R> f20305e;

    public static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1776795561228106469L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f20306b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f20307c;

        /* renamed from: d  reason: collision with root package name */
        public final SimplePlainQueue<R> f20308d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f20309e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final int f20310f;

        /* renamed from: g  reason: collision with root package name */
        public final int f20311g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f20312h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f20313i;

        /* renamed from: j  reason: collision with root package name */
        public Throwable f20314j;

        /* renamed from: k  reason: collision with root package name */
        public Subscription f20315k;

        /* renamed from: l  reason: collision with root package name */
        public R f20316l;

        /* renamed from: m  reason: collision with root package name */
        public int f20317m;

        public ScanSeedSubscriber(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r11, int i11) {
            this.f20306b = subscriber;
            this.f20307c = biFunction;
            this.f20316l = r11;
            this.f20310f = i11;
            this.f20311g = i11 - (i11 >> 2);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i11);
            this.f20308d = spscArrayQueue;
            spscArrayQueue.offer(r11);
        }

        public void a() {
            int i11;
            boolean z11;
            Throwable th2;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f20306b;
                SimplePlainQueue<R> simplePlainQueue = this.f20308d;
                int i12 = this.f20311g;
                int i13 = this.f20317m;
                int i14 = 1;
                do {
                    long j11 = this.f20309e.get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (this.f20312h) {
                            simplePlainQueue.clear();
                            return;
                        } else {
                            boolean z12 = this.f20313i;
                            if (!z12 || (th2 = this.f20314j) == null) {
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
                                        this.f20315k.request((long) i12);
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
                    if (i11 == 0 && this.f20313i) {
                        Throwable th3 = this.f20314j;
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
                        BackpressureHelper.produced(this.f20309e, j12);
                    }
                    this.f20317m = i13;
                    i14 = addAndGet(-i14);
                } while (i14 != 0);
            }
        }

        public void cancel() {
            this.f20312h = true;
            this.f20315k.cancel();
            if (getAndIncrement() == 0) {
                this.f20308d.clear();
            }
        }

        public void onComplete() {
            if (!this.f20313i) {
                this.f20313i = true;
                a();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20313i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20314j = th2;
            this.f20313i = true;
            a();
        }

        public void onNext(T t11) {
            if (!this.f20313i) {
                try {
                    R apply = this.f20307c.apply(this.f20316l, t11);
                    Objects.requireNonNull(apply, "The accumulator returned a null value");
                    this.f20316l = apply;
                    this.f20308d.offer(apply);
                    a();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f20315k.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20315k, subscription)) {
                this.f20315k = subscription;
                this.f20306b.onSubscribe(this);
                subscription.request((long) (this.f20310f - 1));
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20309e, j11);
                a();
            }
        }
    }

    public FlowableScanSeed(Flowable<T> flowable, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        this.f20304d = biFunction;
        this.f20305e = supplier;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            R r11 = this.f20305e.get();
            Objects.requireNonNull(r11, "The seed supplied is null");
            this.f19260c.subscribe(new ScanSeedSubscriber(subscriber, this.f20304d, r11, Flowable.bufferSize()));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
