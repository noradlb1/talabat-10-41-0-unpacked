package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final int f15535d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15536e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f15537f;

    /* renamed from: g  reason: collision with root package name */
    public final Action f15538g;

    public static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -2514538129242366402L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15539b;

        /* renamed from: c  reason: collision with root package name */
        public final SimplePlainQueue<T> f15540c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f15541d;

        /* renamed from: e  reason: collision with root package name */
        public final Action f15542e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f15543f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f15544g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f15545h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f15546i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicLong f15547j = new AtomicLong();

        /* renamed from: k  reason: collision with root package name */
        public boolean f15548k;

        public BackpressureBufferSubscriber(Subscriber<? super T> subscriber, int i11, boolean z11, boolean z12, Action action) {
            SimplePlainQueue<T> simplePlainQueue;
            this.f15539b = subscriber;
            this.f15542e = action;
            this.f15541d = z12;
            if (z11) {
                simplePlainQueue = new SpscLinkedArrayQueue<>(i11);
            } else {
                simplePlainQueue = new SpscArrayQueue<>(i11);
            }
            this.f15540c = simplePlainQueue;
        }

        public boolean a(boolean z11, boolean z12, Subscriber<? super T> subscriber) {
            if (this.f15544g) {
                this.f15540c.clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!this.f15541d) {
                    Throwable th2 = this.f15546i;
                    if (th2 != null) {
                        this.f15540c.clear();
                        subscriber.onError(th2);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    Throwable th3 = this.f15546i;
                    if (th3 != null) {
                        subscriber.onError(th3);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
        }

        public void cancel() {
            if (!this.f15544g) {
                this.f15544g = true;
                this.f15543f.cancel();
                if (!this.f15548k && getAndIncrement() == 0) {
                    this.f15540c.clear();
                }
            }
        }

        public void clear() {
            this.f15540c.clear();
        }

        public void drain() {
            int i11;
            boolean z11;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<T> simplePlainQueue = this.f15540c;
                Subscriber<? super T> subscriber = this.f15539b;
                int i12 = 1;
                while (!a(this.f15545h, simplePlainQueue.isEmpty(), subscriber)) {
                    long j11 = this.f15547j.get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        }
                        boolean z12 = this.f15545h;
                        T poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!a(z12, z11, subscriber)) {
                            if (z11) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j12++;
                        } else {
                            return;
                        }
                    }
                    if (i11 != 0 || !a(this.f15545h, simplePlainQueue.isEmpty(), subscriber)) {
                        if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                            this.f15547j.addAndGet(-j12);
                        }
                        i12 = addAndGet(-i12);
                        if (i12 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean isEmpty() {
            return this.f15540c.isEmpty();
        }

        public void onComplete() {
            this.f15545h = true;
            if (this.f15548k) {
                this.f15539b.onComplete();
            } else {
                drain();
            }
        }

        public void onError(Throwable th2) {
            this.f15546i = th2;
            this.f15545h = true;
            if (this.f15548k) {
                this.f15539b.onError(th2);
            } else {
                drain();
            }
        }

        public void onNext(T t11) {
            if (!this.f15540c.offer(t11)) {
                this.f15543f.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.f15542e.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    missingBackpressureException.initCause(th2);
                }
                onError(missingBackpressureException);
            } else if (this.f15548k) {
                this.f15539b.onNext(null);
            } else {
                drain();
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15543f, subscription)) {
                this.f15543f = subscription;
                this.f15539b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Nullable
        public T poll() throws Exception {
            return this.f15540c.poll();
        }

        public void request(long j11) {
            if (!this.f15548k && SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15547j, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f15548k = true;
            return 2;
        }
    }

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int i11, boolean z11, boolean z12, Action action) {
        super(flowable);
        this.f15535d = i11;
        this.f15536e = z11;
        this.f15537f = z12;
        this.f15538g = action;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new BackpressureBufferSubscriber(subscriber, this.f15535d, this.f15536e, this.f15537f, this.f15538g));
    }
}
