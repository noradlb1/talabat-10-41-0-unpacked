package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSequenceEqual<T> extends Flowable<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T> f15808c;

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends T> f15809d;

    /* renamed from: e  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f15810e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15811f;

    public static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: d  reason: collision with root package name */
        public final BiPredicate<? super T, ? super T> f15812d;

        /* renamed from: e  reason: collision with root package name */
        public final EqualSubscriber<T> f15813e;

        /* renamed from: f  reason: collision with root package name */
        public final EqualSubscriber<T> f15814f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f15815g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f15816h = new AtomicInteger();

        /* renamed from: i  reason: collision with root package name */
        public T f15817i;

        /* renamed from: j  reason: collision with root package name */
        public T f15818j;

        public EqualCoordinator(Subscriber<? super Boolean> subscriber, int i11, BiPredicate<? super T, ? super T> biPredicate) {
            super(subscriber);
            this.f15812d = biPredicate;
            this.f15813e = new EqualSubscriber<>(this, i11);
            this.f15814f = new EqualSubscriber<>(this, i11);
            this.f15815g = new AtomicThrowable();
        }

        public void a() {
            this.f15813e.cancel();
            this.f15813e.a();
            this.f15814f.cancel();
            this.f15814f.a();
        }

        public void b(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.subscribe(this.f15813e);
            publisher2.subscribe(this.f15814f);
        }

        public void cancel() {
            super.cancel();
            this.f15813e.cancel();
            this.f15814f.cancel();
            if (this.f15816h.getAndIncrement() == 0) {
                this.f15813e.a();
                this.f15814f.a();
            }
        }

        public void drain() {
            boolean z11;
            if (this.f15816h.getAndIncrement() == 0) {
                int i11 = 1;
                do {
                    SimpleQueue<T> simpleQueue = this.f15813e.f15823f;
                    SimpleQueue<T> simpleQueue2 = this.f15814f.f15823f;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!isCancelled()) {
                            if (((Throwable) this.f15815g.get()) != null) {
                                a();
                                this.f18609b.onError(this.f15815g.terminate());
                                return;
                            }
                            boolean z12 = this.f15813e.f15824g;
                            T t11 = this.f15817i;
                            if (t11 == null) {
                                try {
                                    t11 = simpleQueue.poll();
                                    this.f15817i = t11;
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    a();
                                    this.f15815g.addThrowable(th2);
                                    this.f18609b.onError(this.f15815g.terminate());
                                    return;
                                }
                            }
                            boolean z13 = false;
                            if (t11 == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            boolean z14 = this.f15814f.f15824g;
                            T t12 = this.f15818j;
                            if (t12 == null) {
                                try {
                                    t12 = simpleQueue2.poll();
                                    this.f15818j = t12;
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    a();
                                    this.f15815g.addThrowable(th3);
                                    this.f18609b.onError(this.f15815g.terminate());
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
                                    if (!this.f15812d.test(t11, t12)) {
                                        a();
                                        complete(Boolean.FALSE);
                                        return;
                                    }
                                    this.f15817i = null;
                                    this.f15818j = null;
                                    this.f15813e.request();
                                    this.f15814f.request();
                                } catch (Throwable th4) {
                                    Exceptions.throwIfFatal(th4);
                                    a();
                                    this.f15815g.addThrowable(th4);
                                    this.f18609b.onError(this.f15815g.terminate());
                                    return;
                                }
                            }
                        }
                        this.f15813e.a();
                        this.f15814f.a();
                        return;
                    } else if (isCancelled()) {
                        this.f15813e.a();
                        this.f15814f.a();
                        return;
                    } else if (((Throwable) this.f15815g.get()) != null) {
                        a();
                        this.f18609b.onError(this.f15815g.terminate());
                        return;
                    }
                    i11 = this.f15816h.addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        public void innerError(Throwable th2) {
            if (this.f15815g.addThrowable(th2)) {
                drain();
            } else {
                RxJavaPlugins.onError(th2);
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
        public final EqualCoordinatorHelper f15819b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15820c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15821d;

        /* renamed from: e  reason: collision with root package name */
        public long f15822e;

        /* renamed from: f  reason: collision with root package name */
        public volatile SimpleQueue<T> f15823f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f15824g;

        /* renamed from: h  reason: collision with root package name */
        public int f15825h;

        public EqualSubscriber(EqualCoordinatorHelper equalCoordinatorHelper, int i11) {
            this.f15819b = equalCoordinatorHelper;
            this.f15821d = i11 - (i11 >> 2);
            this.f15820c = i11;
        }

        public void a() {
            SimpleQueue<T> simpleQueue = this.f15823f;
            if (simpleQueue != null) {
                simpleQueue.clear();
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f15824g = true;
            this.f15819b.drain();
        }

        public void onError(Throwable th2) {
            this.f15819b.innerError(th2);
        }

        public void onNext(T t11) {
            if (this.f15825h != 0 || this.f15823f.offer(t11)) {
                this.f15819b.drain();
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
                        this.f15825h = requestFusion;
                        this.f15823f = queueSubscription;
                        this.f15824g = true;
                        this.f15819b.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.f15825h = requestFusion;
                        this.f15823f = queueSubscription;
                        subscription.request((long) this.f15820c);
                        return;
                    }
                }
                this.f15823f = new SpscArrayQueue(this.f15820c);
                subscription.request((long) this.f15820c);
            }
        }

        public void request() {
            if (this.f15825h != 1) {
                long j11 = this.f15822e + 1;
                if (j11 >= ((long) this.f15821d)) {
                    this.f15822e = 0;
                    ((Subscription) get()).request(j11);
                    return;
                }
                this.f15822e = j11;
            }
        }
    }

    public FlowableSequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i11) {
        this.f15808c = publisher;
        this.f15809d = publisher2;
        this.f15810e = biPredicate;
        this.f15811f = i11;
    }

    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(subscriber, this.f15811f, this.f15810e);
        subscriber.onSubscribe(equalCoordinator);
        equalCoordinator.b(this.f15808c, this.f15809d);
    }
}
