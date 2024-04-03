package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f15907d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15908e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f15909f;

    public static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;

        /* renamed from: b  reason: collision with root package name */
        public final SwitchMapSubscriber<T, R> f15910b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15911c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15912d;

        /* renamed from: e  reason: collision with root package name */
        public volatile SimpleQueue<R> f15913e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f15914f;

        /* renamed from: g  reason: collision with root package name */
        public int f15915g;

        public SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j11, int i11) {
            this.f15910b = switchMapSubscriber;
            this.f15911c = j11;
            this.f15912d = i11;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.f15910b;
            if (this.f15911c == switchMapSubscriber.f15927l) {
                this.f15914f = true;
                switchMapSubscriber.b();
            }
        }

        public void onError(Throwable th2) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.f15910b;
            if (this.f15911c != switchMapSubscriber.f15927l || !switchMapSubscriber.f15922g.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!switchMapSubscriber.f15920e) {
                switchMapSubscriber.f15924i.cancel();
                switchMapSubscriber.f15921f = true;
            }
            this.f15914f = true;
            switchMapSubscriber.b();
        }

        public void onNext(R r11) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.f15910b;
            if (this.f15911c != switchMapSubscriber.f15927l) {
                return;
            }
            if (this.f15915g != 0 || this.f15913e.offer(r11)) {
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
                        this.f15915g = requestFusion;
                        this.f15913e = queueSubscription;
                        this.f15914f = true;
                        this.f15910b.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.f15915g = requestFusion;
                        this.f15913e = queueSubscription;
                        subscription.request((long) this.f15912d);
                        return;
                    }
                }
                this.f15913e = new SpscArrayQueue(this.f15912d);
                subscription.request((long) this.f15912d);
            }
        }

        public void request(long j11) {
            if (this.f15915g != 1) {
                ((Subscription) get()).request(j11);
            }
        }
    }

    public static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: m  reason: collision with root package name */
        public static final SwitchMapInnerSubscriber<Object, Object> f15916m;
        private static final long serialVersionUID = -3491074160481096299L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f15917b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends R>> f15918c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15919d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f15920e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f15921f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f15922g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f15923h;

        /* renamed from: i  reason: collision with root package name */
        public Subscription f15924i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerSubscriber<T, R>> f15925j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        public final AtomicLong f15926k = new AtomicLong();

        /* renamed from: l  reason: collision with root package name */
        public volatile long f15927l;

        static {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = new SwitchMapInnerSubscriber<>((SwitchMapSubscriber) null, -1, 1);
            f15916m = switchMapInnerSubscriber;
            switchMapInnerSubscriber.cancel();
        }

        public SwitchMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11, boolean z11) {
            this.f15917b = subscriber;
            this.f15918c = function;
            this.f15919d = i11;
            this.f15920e = z11;
            this.f15922g = new AtomicThrowable();
        }

        public void a() {
            SwitchMapInnerSubscriber<Object, Object> andSet;
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = this.f15925j.get();
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber2 = f15916m;
            if (switchMapInnerSubscriber != switchMapInnerSubscriber2 && (andSet = this.f15925j.getAndSet(switchMapInnerSubscriber2)) != switchMapInnerSubscriber2 && andSet != null) {
                andSet.cancel();
            }
        }

        public void b() {
            SimpleQueue<R> simpleQueue;
            boolean z11;
            R r11;
            boolean z12;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f15917b;
                int i11 = 1;
                while (!this.f15923h) {
                    if (this.f15921f) {
                        if (this.f15920e) {
                            if (this.f15925j.get() == null) {
                                if (((Throwable) this.f15922g.get()) != null) {
                                    subscriber.onError(this.f15922g.terminate());
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                        } else if (((Throwable) this.f15922g.get()) != null) {
                            a();
                            subscriber.onError(this.f15922g.terminate());
                            return;
                        } else if (this.f15925j.get() == null) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber = this.f15925j.get();
                    if (switchMapInnerSubscriber != null) {
                        simpleQueue = switchMapInnerSubscriber.f15913e;
                    } else {
                        simpleQueue = null;
                    }
                    if (simpleQueue != null) {
                        if (switchMapInnerSubscriber.f15914f) {
                            if (!this.f15920e) {
                                if (((Throwable) this.f15922g.get()) != null) {
                                    a();
                                    subscriber.onError(this.f15922g.terminate());
                                    return;
                                } else if (simpleQueue.isEmpty()) {
                                    b.a(this.f15925j, switchMapInnerSubscriber, (Object) null);
                                }
                            } else if (simpleQueue.isEmpty()) {
                                b.a(this.f15925j, switchMapInnerSubscriber, (Object) null);
                            }
                        }
                        long j11 = this.f15926k.get();
                        long j12 = 0;
                        while (true) {
                            z11 = false;
                            if (j12 != j11) {
                                if (!this.f15923h) {
                                    boolean z13 = switchMapInnerSubscriber.f15914f;
                                    try {
                                        r11 = simpleQueue.poll();
                                    } catch (Throwable th2) {
                                        Throwable th3 = th2;
                                        Exceptions.throwIfFatal(th3);
                                        switchMapInnerSubscriber.cancel();
                                        this.f15922g.addThrowable(th3);
                                        r11 = null;
                                        z13 = true;
                                    }
                                    if (r11 == null) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    if (switchMapInnerSubscriber != this.f15925j.get()) {
                                        break;
                                    }
                                    if (z13) {
                                        if (this.f15920e) {
                                            if (z12) {
                                                b.a(this.f15925j, switchMapInnerSubscriber, (Object) null);
                                                break;
                                            }
                                        } else if (((Throwable) this.f15922g.get()) == null) {
                                            if (z12) {
                                                b.a(this.f15925j, switchMapInnerSubscriber, (Object) null);
                                                break;
                                            }
                                        } else {
                                            subscriber.onError(this.f15922g.terminate());
                                            return;
                                        }
                                    }
                                    if (z12) {
                                        break;
                                    }
                                    subscriber.onNext(r11);
                                    j12++;
                                } else {
                                    return;
                                }
                            } else {
                                break;
                            }
                        }
                        z11 = true;
                        if (j12 != 0 && !this.f15923h) {
                            if (j11 != Long.MAX_VALUE) {
                                this.f15926k.addAndGet(-j12);
                            }
                            switchMapInnerSubscriber.request(j12);
                        }
                        if (z11) {
                            continue;
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void cancel() {
            if (!this.f15923h) {
                this.f15923h = true;
                this.f15924i.cancel();
                a();
            }
        }

        public void onComplete() {
            if (!this.f15921f) {
                this.f15921f = true;
                b();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15921f || !this.f15922g.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!this.f15920e) {
                a();
            }
            this.f15921f = true;
            b();
        }

        public void onNext(T t11) {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber;
            if (!this.f15921f) {
                long j11 = this.f15927l + 1;
                this.f15927l = j11;
                SwitchMapInnerSubscriber switchMapInnerSubscriber2 = this.f15925j.get();
                if (switchMapInnerSubscriber2 != null) {
                    switchMapInnerSubscriber2.cancel();
                }
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f15918c.apply(t11), "The publisher returned is null");
                    SwitchMapInnerSubscriber switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber(this, j11, this.f15919d);
                    do {
                        switchMapInnerSubscriber = this.f15925j.get();
                        if (switchMapInnerSubscriber == f15916m) {
                            return;
                        }
                    } while (!b.a(this.f15925j, switchMapInnerSubscriber, switchMapInnerSubscriber3));
                    publisher.subscribe(switchMapInnerSubscriber3);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f15924i.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15924i, subscription)) {
                this.f15924i = subscription;
                this.f15917b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15926k, j11);
                if (this.f15927l == 0) {
                    this.f15924i.request(Long.MAX_VALUE);
                } else {
                    b();
                }
            }
        }
    }

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i11, boolean z11) {
        super(flowable);
        this.f15907d = function;
        this.f15908e = i11;
        this.f15909f = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f14763c, subscriber, this.f15907d)) {
            this.f14763c.subscribe(new SwitchMapSubscriber(subscriber, this.f15907d, this.f15908e, this.f15909f));
        }
    }
}
