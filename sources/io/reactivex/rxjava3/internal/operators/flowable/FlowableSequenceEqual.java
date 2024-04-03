package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSequenceEqual<T> extends Flowable<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T> f20318c;

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends T> f20319d;

    /* renamed from: e  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f20320e;

    /* renamed from: f  reason: collision with root package name */
    public final int f20321f;

    public static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: d  reason: collision with root package name */
        public final BiPredicate<? super T, ? super T> f20322d;

        /* renamed from: e  reason: collision with root package name */
        public final EqualSubscriber<T> f20323e;

        /* renamed from: f  reason: collision with root package name */
        public final EqualSubscriber<T> f20324f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f20325g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f20326h = new AtomicInteger();

        /* renamed from: i  reason: collision with root package name */
        public T f20327i;

        /* renamed from: j  reason: collision with root package name */
        public T f20328j;

        public EqualCoordinator(Subscriber<? super Boolean> subscriber, int i11, BiPredicate<? super T, ? super T> biPredicate) {
            super(subscriber);
            this.f20322d = biPredicate;
            this.f20323e = new EqualSubscriber<>(this, i11);
            this.f20324f = new EqualSubscriber<>(this, i11);
            this.f20325g = new AtomicThrowable();
        }

        public void a() {
            this.f20323e.cancel();
            this.f20323e.a();
            this.f20324f.cancel();
            this.f20324f.a();
        }

        public void b(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.subscribe(this.f20323e);
            publisher2.subscribe(this.f20324f);
        }

        public void cancel() {
            super.cancel();
            this.f20323e.cancel();
            this.f20324f.cancel();
            this.f20325g.tryTerminateAndReport();
            if (this.f20326h.getAndIncrement() == 0) {
                this.f20323e.a();
                this.f20324f.a();
            }
        }

        public void drain() {
            boolean z11;
            if (this.f20326h.getAndIncrement() == 0) {
                int i11 = 1;
                do {
                    SimpleQueue<T> simpleQueue = this.f20323e.f20333f;
                    SimpleQueue<T> simpleQueue2 = this.f20324f.f20333f;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!isCancelled()) {
                            if (((Throwable) this.f20325g.get()) != null) {
                                a();
                                this.f20325g.tryTerminateConsumer((Subscriber<?>) this.f23170b);
                                return;
                            }
                            boolean z12 = this.f20323e.f20334g;
                            T t11 = this.f20327i;
                            if (t11 == null) {
                                try {
                                    t11 = simpleQueue.poll();
                                    this.f20327i = t11;
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    a();
                                    this.f20325g.tryAddThrowableOrReport(th2);
                                    this.f20325g.tryTerminateConsumer((Subscriber<?>) this.f23170b);
                                    return;
                                }
                            }
                            boolean z13 = false;
                            if (t11 == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            boolean z14 = this.f20324f.f20334g;
                            T t12 = this.f20328j;
                            if (t12 == null) {
                                try {
                                    t12 = simpleQueue2.poll();
                                    this.f20328j = t12;
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    a();
                                    this.f20325g.tryAddThrowableOrReport(th3);
                                    this.f20325g.tryTerminateConsumer((Subscriber<?>) this.f23170b);
                                    return;
                                }
                            }
                            if (t12 == null) {
                                z13 = true;
                            }
                            if (z12 && z14 && z11 && z13) {
                                complete(Boolean.TRUE);
                                return;
                            } else if (z12 && z14 && z11 != z13) {
                                a();
                                complete(Boolean.FALSE);
                                return;
                            } else if (!z11 && !z13) {
                                try {
                                    if (!this.f20322d.test(t11, t12)) {
                                        a();
                                        complete(Boolean.FALSE);
                                        return;
                                    }
                                    this.f20327i = null;
                                    this.f20328j = null;
                                    this.f20323e.request();
                                    this.f20324f.request();
                                } catch (Throwable th4) {
                                    Exceptions.throwIfFatal(th4);
                                    a();
                                    this.f20325g.tryAddThrowableOrReport(th4);
                                    this.f20325g.tryTerminateConsumer((Subscriber<?>) this.f23170b);
                                    return;
                                }
                            }
                        }
                        this.f20323e.a();
                        this.f20324f.a();
                        return;
                    } else if (isCancelled()) {
                        this.f20323e.a();
                        this.f20324f.a();
                        return;
                    } else if (((Throwable) this.f20325g.get()) != null) {
                        a();
                        this.f20325g.tryTerminateConsumer((Subscriber<?>) this.f23170b);
                        return;
                    }
                    i11 = this.f20326h.addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        public void innerError(Throwable th2) {
            if (this.f20325g.tryAddThrowableOrReport(th2)) {
                drain();
            }
        }
    }

    public interface EqualCoordinatorHelper {
        void drain();

        void innerError(Throwable th2);
    }

    public static final class EqualSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4804128302091633067L;

        /* renamed from: b  reason: collision with root package name */
        public final EqualCoordinatorHelper f20329b;

        /* renamed from: c  reason: collision with root package name */
        public final int f20330c;

        /* renamed from: d  reason: collision with root package name */
        public final int f20331d;

        /* renamed from: e  reason: collision with root package name */
        public long f20332e;

        /* renamed from: f  reason: collision with root package name */
        public volatile SimpleQueue<T> f20333f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f20334g;

        /* renamed from: h  reason: collision with root package name */
        public int f20335h;

        public EqualSubscriber(EqualCoordinatorHelper equalCoordinatorHelper, int i11) {
            this.f20329b = equalCoordinatorHelper;
            this.f20331d = i11 - (i11 >> 2);
            this.f20330c = i11;
        }

        public void a() {
            SimpleQueue<T> simpleQueue = this.f20333f;
            if (simpleQueue != null) {
                simpleQueue.clear();
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f20334g = true;
            this.f20329b.drain();
        }

        public void onError(Throwable th2) {
            this.f20329b.innerError(th2);
        }

        public void onNext(T t11) {
            if (this.f20335h != 0 || this.f20333f.offer(t11)) {
                this.f20329b.drain();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f20335h = requestFusion;
                        this.f20333f = queueSubscription;
                        this.f20334g = true;
                        this.f20329b.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.f20335h = requestFusion;
                        this.f20333f = queueSubscription;
                        subscription.request((long) this.f20330c);
                        return;
                    }
                }
                this.f20333f = new SpscArrayQueue(this.f20330c);
                subscription.request((long) this.f20330c);
            }
        }

        public void request() {
            if (this.f20335h != 1) {
                long j11 = this.f20332e + 1;
                if (j11 >= ((long) this.f20331d)) {
                    this.f20332e = 0;
                    ((Subscription) get()).request(j11);
                    return;
                }
                this.f20332e = j11;
            }
        }
    }

    public FlowableSequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i11) {
        this.f20318c = publisher;
        this.f20319d = publisher2;
        this.f20320e = biPredicate;
        this.f20321f = i11;
    }

    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(subscriber, this.f20321f, this.f20320e);
        subscriber.onSubscribe(equalCoordinator);
        equalCoordinator.b(this.f20318c, this.f20319d);
    }
}
