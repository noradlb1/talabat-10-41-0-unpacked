package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f19495d;

    /* renamed from: e  reason: collision with root package name */
    public final int f19496e;

    /* renamed from: f  reason: collision with root package name */
    public final int f19497f;

    /* renamed from: g  reason: collision with root package name */
    public final ErrorMode f19498g;

    public static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f19499b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends R>> f19500c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19501d;

        /* renamed from: e  reason: collision with root package name */
        public final int f19502e;

        /* renamed from: f  reason: collision with root package name */
        public final ErrorMode f19503f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f19504g = new AtomicThrowable();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicLong f19505h = new AtomicLong();

        /* renamed from: i  reason: collision with root package name */
        public final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> f19506i;

        /* renamed from: j  reason: collision with root package name */
        public Subscription f19507j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f19508k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f19509l;

        /* renamed from: m  reason: collision with root package name */
        public volatile InnerQueuedSubscriber<R> f19510m;

        public ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i11, int i12, ErrorMode errorMode) {
            this.f19499b = subscriber;
            this.f19500c = function;
            this.f19501d = i11;
            this.f19502e = i12;
            this.f19503f = errorMode;
            this.f19506i = new SpscLinkedArrayQueue<>(Math.min(i12, i11));
        }

        public void a() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.f19510m;
            this.f19510m = null;
            if (innerQueuedSubscriber != null) {
                innerQueuedSubscriber.cancel();
            }
            while (true) {
                InnerQueuedSubscriber poll = this.f19506i.poll();
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
            if (!this.f19508k) {
                this.f19508k = true;
                this.f19507j.cancel();
                this.f19504g.tryTerminateAndReport();
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
                InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.f19510m;
                Subscriber<? super R> subscriber = this.f19499b;
                ErrorMode errorMode = this.f19503f;
                int i13 = 1;
                while (true) {
                    long j13 = this.f19505h.get();
                    if (innerQueuedSubscriber2 != null) {
                        innerQueuedSubscriber = innerQueuedSubscriber2;
                    } else if (errorMode == ErrorMode.END || ((Throwable) this.f19504g.get()) == null) {
                        boolean z13 = this.f19509l;
                        innerQueuedSubscriber = this.f19506i.poll();
                        if (z13 && innerQueuedSubscriber == null) {
                            this.f19504g.tryTerminateConsumer((Subscriber<?>) this.f19499b);
                            return;
                        } else if (innerQueuedSubscriber != null) {
                            this.f19510m = innerQueuedSubscriber;
                        }
                    } else {
                        a();
                        this.f19504g.tryTerminateConsumer((Subscriber<?>) this.f19499b);
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
                            } else if (this.f19508k) {
                                a();
                                return;
                            } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f19504g.get()) == null) {
                                boolean isDone = innerQueuedSubscriber.isDone();
                                try {
                                    R poll = queue.poll();
                                    if (poll == null) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    if (isDone && z12) {
                                        this.f19510m = null;
                                        this.f19507j.request(1);
                                        innerQueuedSubscriber = null;
                                        z11 = true;
                                        break;
                                    } else if (z12) {
                                        break;
                                    } else {
                                        subscriber.onNext(poll);
                                        j11++;
                                        innerQueuedSubscriber.request(1);
                                        i13 = i11;
                                    }
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    Exceptions.throwIfFatal(th3);
                                    this.f19510m = null;
                                    innerQueuedSubscriber.cancel();
                                    a();
                                    subscriber.onError(th3);
                                    return;
                                }
                            } else {
                                this.f19510m = null;
                                innerQueuedSubscriber.cancel();
                                a();
                                this.f19504g.tryTerminateConsumer((Subscriber<?>) this.f19499b);
                                return;
                            }
                        }
                        z11 = false;
                        if (i12 == 0) {
                            if (this.f19508k) {
                                a();
                                return;
                            } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f19504g.get()) == null) {
                                boolean isDone2 = innerQueuedSubscriber.isDone();
                                boolean isEmpty = queue.isEmpty();
                                if (isDone2 && isEmpty) {
                                    this.f19510m = null;
                                    this.f19507j.request(1);
                                    innerQueuedSubscriber = null;
                                    z11 = true;
                                }
                            } else {
                                this.f19510m = null;
                                innerQueuedSubscriber.cancel();
                                a();
                                this.f19504g.tryTerminateConsumer((Subscriber<?>) this.f19499b);
                                return;
                            }
                        }
                        j12 = 0;
                    }
                    if (!(j11 == j12 || j13 == Long.MAX_VALUE)) {
                        this.f19505h.addAndGet(-j11);
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
            if (this.f19504g.tryAddThrowableOrReport(th2)) {
                innerQueuedSubscriber.setDone();
                if (this.f19503f != ErrorMode.END) {
                    this.f19507j.cancel();
                }
                drain();
            }
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
            this.f19509l = true;
            drain();
        }

        public void onError(Throwable th2) {
            if (this.f19504g.tryAddThrowableOrReport(th2)) {
                this.f19509l = true;
                drain();
            }
        }

        public void onNext(T t11) {
            try {
                Object apply = this.f19500c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.f19502e);
                if (!this.f19508k) {
                    this.f19506i.offer(innerQueuedSubscriber);
                    publisher.subscribe(innerQueuedSubscriber);
                    if (this.f19508k) {
                        innerQueuedSubscriber.cancel();
                        b();
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f19507j.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            long j11;
            if (SubscriptionHelper.validate(this.f19507j, subscription)) {
                this.f19507j = subscription;
                this.f19499b.onSubscribe(this);
                int i11 = this.f19501d;
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
                BackpressureHelper.add(this.f19505h, j11);
                drain();
            }
        }
    }

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i11, int i12, ErrorMode errorMode) {
        super(flowable);
        this.f19495d = function;
        this.f19496e = i11;
        this.f19497f = i12;
        this.f19498g = errorMode;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19260c.subscribe(new ConcatMapEagerDelayErrorSubscriber(subscriber, this.f19495d, this.f19496e, this.f19497f, this.f19498g));
    }
}
