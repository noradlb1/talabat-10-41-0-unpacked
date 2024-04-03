package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f15007d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15008e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15009f;

    /* renamed from: g  reason: collision with root package name */
    public final ErrorMode f15010g;

    public static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f15011b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends R>> f15012c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15013d;

        /* renamed from: e  reason: collision with root package name */
        public final int f15014e;

        /* renamed from: f  reason: collision with root package name */
        public final ErrorMode f15015f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f15016g = new AtomicThrowable();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicLong f15017h = new AtomicLong();

        /* renamed from: i  reason: collision with root package name */
        public final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> f15018i;

        /* renamed from: j  reason: collision with root package name */
        public Subscription f15019j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f15020k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f15021l;

        /* renamed from: m  reason: collision with root package name */
        public volatile InnerQueuedSubscriber<R> f15022m;

        public ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11, int i12, ErrorMode errorMode) {
            this.f15011b = subscriber;
            this.f15012c = function;
            this.f15013d = i11;
            this.f15014e = i12;
            this.f15015f = errorMode;
            this.f15018i = new SpscLinkedArrayQueue<>(Math.min(i12, i11));
        }

        public void a() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.f15022m;
            this.f15022m = null;
            if (innerQueuedSubscriber != null) {
                innerQueuedSubscriber.cancel();
            }
            while (true) {
                InnerQueuedSubscriber poll = this.f15018i.poll();
                if (poll != null) {
                    poll.cancel();
                } else {
                    return;
                }
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                do {
                    a();
                } while (decrementAndGet() != 0);
            }
        }

        public void cancel() {
            if (!this.f15020k) {
                this.f15020k = true;
                this.f15019j.cancel();
                b();
            }
        }

        public void drain() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber;
            int i11;
            long j11;
            long j12;
            boolean z11;
            SimpleQueue<R> queue;
            int i12;
            boolean z12;
            if (getAndIncrement() == 0) {
                InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.f15022m;
                Subscriber<? super R> subscriber = this.f15011b;
                ErrorMode errorMode = this.f15015f;
                int i13 = 1;
                while (true) {
                    long j13 = this.f15017h.get();
                    if (innerQueuedSubscriber2 != null) {
                        innerQueuedSubscriber = innerQueuedSubscriber2;
                    } else if (errorMode == ErrorMode.END || ((Throwable) this.f15016g.get()) == null) {
                        boolean z13 = this.f15021l;
                        innerQueuedSubscriber = this.f15018i.poll();
                        if (z13 && innerQueuedSubscriber == null) {
                            Throwable terminate = this.f15016g.terminate();
                            if (terminate != null) {
                                subscriber.onError(terminate);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        } else if (innerQueuedSubscriber != null) {
                            this.f15022m = innerQueuedSubscriber;
                        }
                    } else {
                        a();
                        subscriber.onError(this.f15016g.terminate());
                        return;
                    }
                    if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                        i11 = i13;
                        z11 = false;
                        j12 = 0;
                        j11 = 0;
                    } else {
                        j11 = 0;
                        while (true) {
                            i12 = (j11 > j13 ? 1 : (j11 == j13 ? 0 : -1));
                            i11 = i13;
                            if (i12 == 0) {
                                break;
                            } else if (this.f15020k) {
                                a();
                                return;
                            } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f15016g.get()) == null) {
                                boolean isDone = innerQueuedSubscriber.isDone();
                                try {
                                    R poll = queue.poll();
                                    if (poll == null) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    if (isDone && z12) {
                                        this.f15022m = null;
                                        this.f15019j.request(1);
                                        innerQueuedSubscriber = null;
                                        z11 = true;
                                        break;
                                    } else if (z12) {
                                        break;
                                    } else {
                                        subscriber.onNext(poll);
                                        j11++;
                                        innerQueuedSubscriber.requestOne();
                                        i13 = i11;
                                    }
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    Exceptions.throwIfFatal(th3);
                                    this.f15022m = null;
                                    innerQueuedSubscriber.cancel();
                                    a();
                                    subscriber.onError(th3);
                                    return;
                                }
                            } else {
                                this.f15022m = null;
                                innerQueuedSubscriber.cancel();
                                a();
                                subscriber.onError(this.f15016g.terminate());
                                return;
                            }
                        }
                        z11 = false;
                        if (i12 == 0) {
                            if (this.f15020k) {
                                a();
                                return;
                            } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f15016g.get()) == null) {
                                boolean isDone2 = innerQueuedSubscriber.isDone();
                                boolean isEmpty = queue.isEmpty();
                                if (isDone2 && isEmpty) {
                                    this.f15022m = null;
                                    this.f15019j.request(1);
                                    innerQueuedSubscriber = null;
                                    z11 = true;
                                }
                            } else {
                                this.f15022m = null;
                                innerQueuedSubscriber.cancel();
                                a();
                                subscriber.onError(this.f15016g.terminate());
                                return;
                            }
                        }
                        j12 = 0;
                    }
                    if (!(j11 == j12 || j13 == Long.MAX_VALUE)) {
                        this.f15017h.addAndGet(-j11);
                    }
                    if (z11) {
                        innerQueuedSubscriber2 = innerQueuedSubscriber;
                        i13 = i11;
                    } else {
                        i13 = addAndGet(-i11);
                        if (i13 != 0) {
                            innerQueuedSubscriber2 = innerQueuedSubscriber;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th2) {
            if (this.f15016g.addThrowable(th2)) {
                innerQueuedSubscriber.setDone();
                if (this.f15015f != ErrorMode.END) {
                    this.f15019j.cancel();
                }
                drain();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r11) {
            if (innerQueuedSubscriber.queue().offer(r11)) {
                drain();
                return;
            }
            innerQueuedSubscriber.cancel();
            innerError(innerQueuedSubscriber, new MissingBackpressureException());
        }

        public void onComplete() {
            this.f15021l = true;
            drain();
        }

        public void onError(Throwable th2) {
            if (this.f15016g.addThrowable(th2)) {
                this.f15021l = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f15012c.apply(t11), "The mapper returned a null Publisher");
                InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.f15014e);
                if (!this.f15020k) {
                    this.f15018i.offer(innerQueuedSubscriber);
                    publisher.subscribe(innerQueuedSubscriber);
                    if (this.f15020k) {
                        innerQueuedSubscriber.cancel();
                        b();
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f15019j.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            long j11;
            if (SubscriptionHelper.validate(this.f15019j, subscription)) {
                this.f15019j = subscription;
                this.f15011b.onSubscribe(this);
                int i11 = this.f15013d;
                if (i11 == Integer.MAX_VALUE) {
                    j11 = Long.MAX_VALUE;
                } else {
                    j11 = (long) i11;
                }
                subscription.request(j11);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15017h, j11);
                drain();
            }
        }
    }

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i11, int i12, ErrorMode errorMode) {
        super(flowable);
        this.f15007d = function;
        this.f15008e = i11;
        this.f15009f = i12;
        this.f15010g = errorMode;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f14763c.subscribe(new ConcatMapEagerDelayErrorSubscriber(subscriber, this.f15007d, this.f15008e, this.f15009f, this.f15010g));
    }
}
